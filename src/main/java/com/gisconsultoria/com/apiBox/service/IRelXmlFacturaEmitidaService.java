package com.gisconsultoria.com.apiBox.service;

import com.gisconsultoria.com.apiBox.model.RelXmlFacturaEmitida;

import java.util.List;

/**
 * @author Luis Enrique Morales Soriano
 */
public interface IRelXmlFacturaEmitidaService {

    public List<RelXmlFacturaEmitida> findFirstFacturaEmitidaByUuid(String uuid);

    public void save (RelXmlFacturaEmitida relXmlFacturaEmitida);

}
