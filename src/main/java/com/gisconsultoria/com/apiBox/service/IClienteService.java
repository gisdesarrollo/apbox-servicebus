package com.gisconsultoria.com.apiBox.service;

import com.gisconsultoria.com.apiBox.model.Cliente;

import java.util.List;

/**
 * @author Luis Enrique Morales Soriano
 */
public interface IClienteService {

    public Cliente getClienteByRfc(String rfc);

    public Cliente getClienteByParamsRazonSocial(String rfc, String razonSocial, Long id);

    public Cliente getClienteByParams(String rfc, Long id);

    public List<Cliente> getListClienteByParams(String rfc, Long id);

    public List<Cliente> getListClienteByParamsRazonSocial(String rfc, String razonSocial, Long id);

    public void save(Cliente cliente);
}
