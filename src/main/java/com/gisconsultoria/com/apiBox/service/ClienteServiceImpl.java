package com.gisconsultoria.com.apiBox.service;

import com.gisconsultoria.com.apiBox.dao.IClienteDao;
import com.gisconsultoria.com.apiBox.model.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Luis Enrique Morales Soriano
 */
@Service
public class ClienteServiceImpl implements IClienteService{

    @Autowired
    private IClienteDao clienteDao;

    @Override
    public Cliente getClienteByRfc(String rfc) {
        return clienteDao.getClienteByRfc(rfc);
    }

    @Override
    public Cliente getClienteByParamsRazonSocial(String rfc, String razonSocial, Long id) {
        return clienteDao.getClienteByParamsRazonSocial(rfc, razonSocial, id);
    }

    @Override
    public Cliente getClienteByParams(String rfc, Long id) {
        return clienteDao.getClienteByParams(rfc, id);
    }

    @Override
    public List<Cliente> getListClienteByParams(String rfc, Long id) {
        return clienteDao.getListClienteByParams(rfc, id);
    }

    @Override
    public List<Cliente> getListClienteByParamsRazonSocial(String rfc, String razonSocial, Long id) {
        return clienteDao.getListClienteByParamsRazonSocial(rfc, razonSocial, id);
    }

    @Override
    public void save(Cliente cliente) {
        clienteDao.save(cliente);
    }
}
