package com.gisconsultoria.com.apiBox.dao;

import com.gisconsultoria.com.apiBox.model.RelXmlFacturaEmitida;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @author Luis Enrique Morales Soriano
 */
public interface IRelXmlFacturaEmitidaDao extends CrudRepository<RelXmlFacturaEmitida, Long> {

    @Query("select rxfe from RelXmlFacturaEmitida rxfe where rxfe.uuid = :uuid")
    public List<RelXmlFacturaEmitida> findFirstFacturaEmitidaByUuid(@Param("uuid") String uuid);
}
