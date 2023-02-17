
package com.tienda.service;

import com.tienda.dao.ClienteDao;
import com.tienda.domain.Cliente;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service //IMPORTANTEEE A LAS PERSONAS NO LES APARECEN LOS MÉTODOS DESPÚES POR NO PONER ESO
public class ClienteServiceImpl implements ClienteService{
    @Autowired
    ClienteDao clienteDao;
    @Override
    @Transactional(readOnly = true) //Para menejar transacciones de solo lectura
    public List<Cliente> getClientes() {
        return (List<Cliente>)clienteDao.findAll();
    }

    @Override
    @Transactional(readOnly = true) //Para menejar transacciones de solo lectura
    public Cliente getCliente(Cliente cliente) {
        return clienteDao.findById(cliente.getIdCliente()).orElse(null);
    }

    @Override
    @Transactional
    public void save(Cliente cliente) {
        clienteDao.save(cliente);
    }

    @Override
    @Transactional
    public void delete(Cliente cliente) {
       clienteDao.deleteById(cliente.getIdCliente()); 
    }
    
}
