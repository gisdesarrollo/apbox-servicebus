package com.gisconsultoria.com.apiBox.service;

import com.gisconsultoria.com.apiBox.dao.ISucursalDao;
import com.gisconsultoria.com.apiBox.model.Sucursal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Luis Enrique Morales Soriano
 */
@Service
public class SucursalServiceImpl implements ISucursalService{

    @Autowired
    private ISucursalDao sucursalDao;

    @Override
    public Sucursal findById(Long id) {
        return sucursalDao.findById(id).orElse(null);
    }

    @Override
    public List<Sucursal> getActiveSucursales() {
        return sucursalDao.getActiveSucursales();
    }

    @Override
    public void save(Sucursal sucursal) {
        sucursalDao.save(sucursal);
    }

    @Override
    public Sucursal getSucursalByRfc(String rfc) {
        return sucursalDao.getSucursalByRfc(rfc);
    }
}
