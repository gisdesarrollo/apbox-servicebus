package com.gisconsultoria.com.apiBox.service;

import com.gisconsultoria.com.apiBox.dao.IFacturaEmitidaDao;
import com.gisconsultoria.com.apiBox.model.FacturaEmitida;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Luis Enrique Morales Soriano
 */
@Service
public class FacturaEmitidaServiceImpl implements IFacturaEmitidaService{

    @Autowired
    private IFacturaEmitidaDao facturaEmitidaDao;

    @Override
    public List<FacturaEmitida> findFirstFacturaEmitidaByUuid(String uuid) {
        return facturaEmitidaDao.findFirstFacturaEmitidaByUuid(uuid);
    }

    @Override
    public void save(FacturaEmitida facturaEmitida) {
        facturaEmitidaDao.save(facturaEmitida);
    }
}
