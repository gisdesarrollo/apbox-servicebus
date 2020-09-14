package com.gisconsultoria.com.apiBox.utils;

import com.gisconsultoria.com.apiBox.model.dto.ComprobanteXmlDto;

import java.io.File;
import java.text.ParseException;

/**
 * @author Luis Enrique Morales Soriano
 */
public interface ILogicaFacade {

    public boolean checarUuidRepetidoBD(String fecha, String uuid, File file, String xml) throws ParseException;

    public boolean checarRfcReceptor(ComprobanteXmlDto comprobante) throws Exception;

    public boolean guardarComprobanteBD(ComprobanteXmlDto comprobante, File file
            , String xml, String uuid)throws Exception;

}
