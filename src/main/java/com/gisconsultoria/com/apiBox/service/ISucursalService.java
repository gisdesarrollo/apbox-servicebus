package com.gisconsultoria.com.apiBox.service;

import com.gisconsultoria.com.apiBox.model.Sucursal;

import java.util.List;

/**
 * @author Luis Enrique Morales Soriano
 */
public interface ISucursalService {

    public Sucursal findById(Long id);

    public List<Sucursal> getActiveSucursales();

    public void save(Sucursal sucursal);

    public Sucursal getSucursalByRfc(String rfc);

}
