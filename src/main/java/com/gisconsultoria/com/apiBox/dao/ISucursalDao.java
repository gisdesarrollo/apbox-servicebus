package com.gisconsultoria.com.apiBox.dao;

import com.gisconsultoria.com.apiBox.model.Sucursal;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @author Luis Enrique Morales Soriano
 */
public interface ISucursalDao extends CrudRepository<Sucursal, Long> {

    @Query("select s from Sucursal s where s.status = 1")
    public List<Sucursal> getActiveSucursales();

    @Query("select s from Sucursal s where s.rfc = :rfc ")
    public Sucursal getSucursalByRfc(@Param("rfc")String rfc);

}
