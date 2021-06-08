package com.gisconsultoria.com.apiBox.dao;

import com.gisconsultoria.com.apiBox.model.Cliente;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @author Luis Enrique Morales Soriano
 */
public interface IClienteDao extends CrudRepository<Cliente, Long> {

    @Query("select c from Cliente c where c.rfc = rfc")
    public Cliente getClienteByRfc(@Param("rfc")String rfc);

    @Query("select c from Cliente c where c.rfc = :rfc and c.razonSocial = :razonSocial and " +
            "c.sucursal.id = :id")
    public Cliente getClienteByParamsRazonSocial(@Param("rfc")String rfc,
                                      @Param("razonSocial")String razonSocial,
                                      @Param("id") Long id);

    @Query("select c from Cliente c where c.rfc = :rfc and c.sucursal.id = :id group by c.rfc")
    public Cliente getClienteByParams(@Param("rfc")String rfc,
                                      @Param("id") Long id);

    @Query("select c from Cliente c where c.rfc = :rfc and c.sucursal.id = :id group by c.rfc")
    public List<Cliente> getListClienteByParams(@Param("rfc")String rfc,
                                      @Param("id") Long id);

    @Query("select c from Cliente c where c.rfc = :rfc and c.razonSocial = :razonSocial and " +
            "c.sucursal.id = :id")
    public List<Cliente> getListClienteByParamsRazonSocial(@Param("rfc")String rfc,
                                                       @Param("razonSocial")String razonSocial,
                                                       @Param("id") Long id);
}
