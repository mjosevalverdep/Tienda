
package com.tienda.dao;
import com.tienda.domain.Cliente;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface ClienteDao extends CrudRepository<Cliente,Long> {
    List<Cliente> findByNombreOrApellidos(String nombre,String apellidos);
}
