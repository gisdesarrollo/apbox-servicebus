package com.gisconsultoria.com.apiBox.service;

import com.gisconsultoria.com.apiBox.model.FacturaEmitida;

import java.util.List;

/**
 * @author Luis Enrique Morales Soriano
 */
public interface IFacturaEmitidaService {

    public List<FacturaEmitida> findFirstFacturaEmitidaByUuid(String uuid);

    public void save(FacturaEmitida facturaEmitida);
}
