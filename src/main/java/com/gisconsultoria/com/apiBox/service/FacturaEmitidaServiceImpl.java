package com.gisconsultoria.com.apiBox.service;

import com.gisconsultoria.com.apiBox.dao.IFacturaEmitidaDao;
import com.gisconsultoria.com.apiBox.model.FacturaEmitida;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Luis Enrique Morales Soriano
 */
@Service
public class FacturaEmitidaServiceImpl implements IFacturaEmitidaService{

    @Autowired
    private IFacturaEmitidaDao facturaEmitidaDao;

    @Override
    public void save(FacturaEmitida facturaEmitida) {
        facturaEmitidaDao.save(facturaEmitida);
    }
}
