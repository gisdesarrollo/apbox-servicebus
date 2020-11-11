package com.gisconsultoria.com.apiBox.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Luis Enrique Morales Soriano
 */
@Entity
@Table(name = "ori_facturasemitidas")
public class FacturaEmitida implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Long id;

    @Column(name = "EmisorId")
    private Long idEmisor;

    @Column(name = "ReceptorId")
    private Long idReceptor;

    @Column(name = "Fecha")
    private Date fecha;

    @Column(name = "Folio")
    private String folio;

    @Column(name = "FormaPago")
    private int formaPago;

    @Column(name = "MetodoPago")
    private int metodoPago;

    @Column(name = "Descuento")
    private Double descuento;

    @Column(name = "Moneda")
    private int moneda;

    @Column(name = "Serie")
    private String serie;

    @Column(name = "Subtotal")
    private Double subTotal;

    @Column(name = "TipoCambio")
    private Double tipoCambio;

    @Column(name = "TipoComprobante")
    private int tipoComprobante;

    @Column(name = "Total")
    private Double total;

    @Column(name = "Version")
    private String version;

    @Column(name = "FechaTimbrado")
    private Date fechaTimbrado;

    @Column(name = "TotalImpuestosRetenidos")
    private Double totalImpuestosRetenidos;

    @Column(name = "TotalImpuestosTrasladados")
    private Double totalImpuestosTrasladados;

    @Column(name = "Uuid")
    private String uuid;

    @Lob
    @Column(name = "ArchivoFisicoXml")
    private byte[] archivoFisicoXml;

    public FacturaEmitida() {
    }

    public FacturaEmitida(Long idEmisor, Long idReceptor, Date fecha, String folio, int formaPago,
                          int metodoPago, Double descuento, int moneda, String serie, Double subTotal,
                          Double tipoCambio, int tipoComprobante, Double total, String version,
                          String uuid, byte[] archivoFisicoXml, Date fechaTimbrado) {
        this.idEmisor = idEmisor;
        this.idReceptor = idReceptor;
        this.fecha = fecha;
        this.folio = folio;
        this.formaPago = formaPago;
        this.metodoPago = metodoPago;
        this.descuento = descuento;
        this.moneda = moneda;
        this.serie = serie;
        this.subTotal = subTotal;
        this.tipoCambio = tipoCambio;
        this.tipoComprobante = tipoComprobante;
        this.total = total;
        this.version = version;
        this.uuid = uuid;
        this.archivoFisicoXml = archivoFisicoXml;
        this.fechaTimbrado = fechaTimbrado;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdEmisor() {
        return idEmisor;
    }

    public void setIdEmisor(Long idEmisor) {
        this.idEmisor = idEmisor;
    }

    public Long getIdReceptor() {
        return idReceptor;
    }

    public void setIdReceptor(Long idReceptor) {
        this.idReceptor = idReceptor;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getFolio() {
        return folio;
    }

    public void setFolio(String folio) {
        this.folio = folio;
    }

    public int getFormaPago() {
        return formaPago;
    }

    public void setFormaPago(int formaPago) {
        this.formaPago = formaPago;
    }

    public int getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(int metodoPago) {
        this.metodoPago = metodoPago;
    }

    public int getMoneda() {
        return moneda;
    }

    public void setMoneda(int moneda) {
        this.moneda = moneda;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public Double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(Double subTotal) {
        this.subTotal = subTotal;
    }

    public Double getTipoCambio() {
        return tipoCambio;
    }

    public void setTipoCambio(Double tipoCambio) {
        this.tipoCambio = tipoCambio;
    }

    public int getTipoComprobante() {
        return tipoComprobante;
    }

    public void setTipoComprobante(int tipoComprobante) {
        this.tipoComprobante = tipoComprobante;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public Date getFechaTimbrado() {
        return fechaTimbrado;
    }

    public void setFechaTimbrado(Date fechaTimbrado) {
        this.fechaTimbrado = fechaTimbrado;
    }

//    public Set<RelXmlFacturaEmitida> getFacturas() {
//        return facturas;
//    }
//
//    public void setFacturas(Set<RelXmlFacturaEmitida> facturas) {
//        this.facturas = facturas;
//    }

    public Double getDescuento() {
        return descuento;
    }

    public void setDescuento(Double descuento) {
        this.descuento = descuento;
    }

    public Double getTotalImpuestosRetenidos() {
        return totalImpuestosRetenidos;
    }

    public void setTotalImpuestosRetenidos(Double totalImpuestosRetenidos) {
        this.totalImpuestosRetenidos = totalImpuestosRetenidos;
    }

    public Double getTotalImpuestosTrasladados() {
        return totalImpuestosTrasladados;
    }

    public void setTotalImpuestosTrasladados(Double totalImpuestosTrasladados) {
        this.totalImpuestosTrasladados = totalImpuestosTrasladados;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        uuid = uuid;
    }

    public byte[] getArchivoFisicoXml() {
        return archivoFisicoXml;
    }

    public void setArchivoFisicoXml(byte[] archivoFisicoXml) {
        this.archivoFisicoXml = archivoFisicoXml;
    }
}
