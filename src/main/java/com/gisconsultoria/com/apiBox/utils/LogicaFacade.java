package com.gisconsultoria.com.apiBox.utils;

import com.gisconsultoria.com.apiBox.model.Cliente;
import com.gisconsultoria.com.apiBox.model.FacturaEmitida;
import com.gisconsultoria.com.apiBox.model.Sucursal;
import com.gisconsultoria.com.apiBox.model.dao.ImpuestoDao;
import com.gisconsultoria.com.apiBox.model.dto.ComprobanteXmlDto;
import com.gisconsultoria.com.apiBox.model.enums.PaisEnum;
import com.gisconsultoria.com.apiBox.service.IClienteService;
import com.gisconsultoria.com.apiBox.service.IFacturaEmitidaService;
import com.gisconsultoria.com.apiBox.service.ISucursalService;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * @author Luis Enrique Morales Soriano
 */
@Service
public class LogicaFacade implements ILogicaFacade {

    protected static final Logger LOG = Logger.getLogger(ApBoxReadXmlFile.class.getName());

//    @Autowired
//    private IRelXmlFacturaEmitidaService relXmlFacturaEmitidaService;

    @Autowired
    private IClienteService clienteService;

    @Autowired
    private ISucursalService sucursalService;

    @Autowired
    private IFacturaEmitidaService facturaEmitidaService;

    @Override
    public boolean checarUuidRepetidoBD(String fecha, String uuid,
                                        File file, String xml) throws ParseException {

        LOG.info("Verificando si existe el uuid: ".concat(uuid).concat(" en la base de datos"));

        File archivo = new File(file.getAbsolutePath() + "/" + xml);
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-DD");
        Date fechaTimbrado = format.parse(fecha);
        calendar.setTime(fechaTimbrado);

        List<FacturaEmitida> facturas =
                facturaEmitidaService.findFirstFacturaEmitidaByUuid(uuid);

        if (facturas != null) {
            for (FacturaEmitida factura : facturas) {
                if (factura != null) {
                    LOG.error("El folio ".concat(factura.getUuid().concat(" ya fue cargado al sistema")));
                    if (archivo.delete()) {
                        LOG.info("Archivo repetido, se eliminó correctamente");
                        return false;
                    }
                }
            }
        }

        return true;
    }

    @Override
    public boolean checarRfcReceptor(ComprobanteXmlDto comprobante) throws Exception {

        Sucursal sucursal = sucursalService.getSucursalByRfc(comprobante.getEmisor().getRfc());

        if (sucursal == null) {
            throw new Exception("El RFC del emisor: ".concat(comprobante.getEmisor().getRfc())
                    .concat(" no fue encontrado en la base de datos"));
        }

        List<Cliente> clientes;

        if (comprobante.getReceptor().getRfc().equals("XEXX010101000") ||
                comprobante.getReceptor().getRfc().equals("XAXX010101000")) {
            clientes = clienteService.getListClienteByParamsRazonSocial(comprobante.getReceptor().getRfc(),
                    comprobante.getReceptor().getNombre(), sucursal.getId());
        } else {
            clientes = clienteService.getListClienteByParams(comprobante.getReceptor().getRfc()
                    , sucursal.getId());
        }

        if (clientes.isEmpty()) {

            new Cliente();
            Cliente cliente;

            cliente = new Cliente(new Date(), 1, comprobante.getReceptor().getNombre(),
                    comprobante.getReceptor().getRfc(), PaisEnum.MEX.number, sucursal);

            try {
                clienteService.save(cliente);
            } catch (DataIntegrityViolationException diExc) {
                LOG.error("Error al momento de guardar al cliente en la base de datos", diExc);
                throw new Exception("Error al momento de guardar al cliente en la base de datos",
                        diExc.getCause());
            }
        }

        return true;
    }

    @Override
    public boolean guardarComprobanteBD(ComprobanteXmlDto comprobante, File file,
                                        String xml, String uuid) throws Exception {

        LOG.info("GUARDANDO INFORMACIÓN EN LA Base de Datos");

        try {

            Sucursal sucursal = sucursalService.getSucursalByRfc(comprobante.getEmisor().getRfc());
            if (sucursal == null) {
                throw new Exception("No se encontró el RFC del emisor: "
                        .concat(comprobante.getEmisor().getRfc()));
            }

            List<Cliente> clientes;

            if (comprobante.getReceptor().getRfc().equals("XEXX010101000") ||
                    comprobante.getReceptor().getRfc().equals("XAXX010101000")) {
                clientes = clienteService.getListClienteByParamsRazonSocial(
                        comprobante.getReceptor().getRfc(),
                        comprobante.getReceptor().getNombre(),
                        sucursal.getId()
                );
                if (clientes.isEmpty()) {
                    LOG.error("No se encontró receptor con RFC ".
                            concat(comprobante.getEmisor().getRfc()).concat(" y Razón Social ").
                            concat(comprobante.getEmisor().getNombre()));
                    throw new Exception("No se encontró receptor con RFC ".
                            concat(comprobante.getEmisor().getRfc()).concat(" y Razón Social ").
                            concat(comprobante.getEmisor().getNombre()));
                }
            } else {
                clientes = clienteService.getListClienteByParams(comprobante.getReceptor().getRfc(),
                        sucursal.getId());
                if (clientes.isEmpty()) {
                    LOG.error("No se encontró receptor con RFC: "
                            .concat(comprobante.getEmisor().getRfc()));
                    throw new Exception("No se encontró receptor con RFC: "
                            .concat(comprobante.getEmisor().getRfc()));
                }
            }

            FacturaEmitida facturaEmitida;

            File archivo = new File(file.getAbsolutePath() + "/" + xml);
            byte[] encode = Base64.encodeBase64(FileUtils.readFileToByteArray(archivo));

            if (comprobante.getFormaPago() == null || comprobante.getMetodoPago() == null) {
                facturaEmitida = new FacturaEmitida(sucursal.getId(), clientes.get(0).getId(),
                        comprobante.getFecha(), comprobante.getFolio(),
                        0, 0,
                        0.0, comprobante.getMoneda().number, comprobante.getSerie(), comprobante.getSubTotal(),
                        comprobante.getTipoCambio(), comprobante.getTipoComprobante().number,
                        comprobante.getTotal(), comprobante.getVersion().toString(),
                        uuid, encode, new Date());
            } else {
                facturaEmitida = new FacturaEmitida(sucursal.getId(), clientes.get(0).getId(),
                        comprobante.getFecha(), comprobante.getFolio(),
                        Integer.parseInt(comprobante.getFormaPago()), comprobante.getMetodoPago().tipo,
                        0.0, comprobante.getMoneda().number, comprobante.getSerie(), comprobante.getSubTotal(),
                        comprobante.getTipoCambio(), comprobante.getTipoComprobante().number,
                        comprobante.getTotal(), comprobante.getVersion().toString(),
                        uuid, encode, new Date());
            }

            Double totalImpuestosTrasladados = 0.0;
            Double totalImpuestosRetenidos = 0.0;

            if (comprobante.getImpuestos() != null) {
                for (ImpuestoDao impuestos : comprobante.getImpuestos()) {
                    totalImpuestosRetenidos = impuestos.getTotalImpuestosRetenidos();
                    totalImpuestosTrasladados = impuestos.getTotalImpuestosTrasladados();
                }
                if (totalImpuestosRetenidos != null) {
                    facturaEmitida.setTotalImpuestosRetenidos(totalImpuestosRetenidos);
                } else {
                    facturaEmitida.setTotalImpuestosRetenidos(0.0);
                }
                facturaEmitida.setTotalImpuestosTrasladados(totalImpuestosTrasladados);
            } else {
                facturaEmitida.setTotalImpuestosRetenidos(totalImpuestosRetenidos);
                facturaEmitida.setTotalImpuestosTrasladados(totalImpuestosTrasladados);
            }

            facturaEmitidaService.save(facturaEmitida);

            if (archivo.delete()) {
                LOG.info("Archivo eliminado de la carpeta: " + file.getName());
            }
        } catch (Exception ex) {
            LOG.error("Ocurrió un error al momento de guardar el documento", ex);
            throw new Exception("Occurió un error al momento de guardar el documento", ex);
        }

        return true;
    }
}
