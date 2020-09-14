package com.gisconsultoria.com.apiBox.dao;

import com.gisconsultoria.com.apiBox.model.FacturaEmitida;
import org.springframework.data.repository.CrudRepository;

/**
 * @author Luis Enrique Morales Soriano
 */
public interface IFacturaEmitidaDao extends CrudRepository<FacturaEmitida, Long> {
}
