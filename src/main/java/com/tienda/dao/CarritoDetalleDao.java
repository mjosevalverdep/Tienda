package com.tienda.dao;


import com.tienda.domain.Articulo;
import com.tienda.domain.CarritoDetalle;
import java.util.List;
import org.springframework.data.repository.CrudRepository;


public interface CarritoDetalleDao extends CrudRepository <CarritoDetalle,Long>{
    
    List<CarritoDetalle> findByIdCarrito(Long idCarrito);
    
    CarritoDetalle findByIdCarritoAndArticulo(Long idCarrito, Articulo articulo);
    
    void deleteByIdCarrito(Long idCarrito);
    
}
