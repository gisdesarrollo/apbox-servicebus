package com.gisconsultoria.com.apiBox.service;

import com.gisconsultoria.com.apiBox.dao.IRelXmlFacturaEmitidaDao;
import com.gisconsultoria.com.apiBox.model.RelXmlFacturaEmitida;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Luis Enrique Morales Soriano
 */
@Service
public class RelXmlFacturaEmitidaServiceImpl implements IRelXmlFacturaEmitidaService{

    @Autowired
    private IRelXmlFacturaEmitidaDao facturaEmitidaDao;

    @Override
    public List<RelXmlFacturaEmitida> findFirstFacturaEmitidaByUuid(String uuid) {
        return facturaEmitidaDao.findFirstFacturaEmitidaByUuid(uuid);
    }

    @Override
    public void save(RelXmlFacturaEmitida facturaEmitida) {
        facturaEmitidaDao.save(facturaEmitida);
    }
}
