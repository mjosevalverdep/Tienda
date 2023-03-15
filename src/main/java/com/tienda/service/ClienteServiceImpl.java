
package com.tienda.service;

import com.tienda.dao.ClienteDao;
import com.tienda.dao.CreditoDao;
import com.tienda.domain.Cliente;
import com.tienda.domain.Credito;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
 
@Service //IMPORTANTEEE A LAS PERSONAS NO LES APARECEN LOS MÉTODOS DESPÚES POR NO PONER ESO
public class ClienteServiceImpl implements ClienteService{
    @Autowired
    private ClienteDao clienteDao;
    @Autowired
    private CreditoDao creditoDao;
    
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
    public void save(Cliente cliente) { //Cliente : idCliente=0, Credito: {idCredito=0, limite=200}
        Credito credito= cliente.getCredito();
        credito=creditoDao.save(credito);//Credito: {idCredito=4, limite=200} 
        cliente.setCredito(credito);//Cliente : idCliente=0, Credito: {idCredito=4, limite=200}
        clienteDao.save(cliente);
    }

    @Override
    @Transactional
    public void delete(Cliente cliente) {
       clienteDao.deleteById(cliente.getIdCliente()); 
    }

    @Override
    @Transactional(readOnly = true)
    public List<Cliente> getNombreOApellidos(String nombre, String apellidos){
       return (List<Cliente>)clienteDao.findByNombreOrApellidos(nombre, apellidos);
    }
}


