package com.gisconsultoria.com.apiBox.dao;

import com.gisconsultoria.com.apiBox.model.FacturaEmitida;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @author Luis Enrique Morales Soriano
 */
public interface IFacturaEmitidaDao extends CrudRepository<FacturaEmitida, Long> {

    @Query("select factura from FacturaEmitida factura where factura.uuid = :uuid")
    public List<FacturaEmitida> findFirstFacturaEmitidaByUuid(@Param("uuid") String uuid);
}
