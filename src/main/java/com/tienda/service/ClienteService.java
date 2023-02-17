package com.tienda.service; //Este ClienteService es como un contrato
import com.tienda.domain.Cliente;
import java.util.List;



public interface ClienteService {
    public List<Cliente> getClientes();
    
    public Cliente getCliente(Cliente cliente);
    
    public void save(Cliente cliente); //Tanto para insertar como modificar un registro
    
    public void delete (Cliente cliente);
    
}
