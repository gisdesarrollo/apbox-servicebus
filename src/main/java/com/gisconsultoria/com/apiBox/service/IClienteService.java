package com.gisconsultoria.com.apiBox.service;

import com.gisconsultoria.com.apiBox.model.Cliente;

/**
 * @author Luis Enrique Morales Soriano
 */
public interface IClienteService {

    public Cliente getClienteByRfc(String rfc);

    public Cliente getClienteByParamsRazonSocial(String rfc, String razonSocial, Long id);

    public Cliente getClienteByParams(String rfc, Long id);

    public void save(Cliente cliente);
}
