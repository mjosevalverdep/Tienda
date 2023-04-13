package com.tienda.service;

import com.tienda.domain.Articulo;
import com.tienda.domain.CarritoDetalle;
import java.util.List;

public interface CarritoDetalleService {
    
    public CarritoDetalle getCarritoDetalle(CarritoDetalle carritoDetalle);
    
    public CarritoDetalle getCarritoDetalleArticulo(Long idCarrito, Articulo articulo);
    
    public List<CarritoDetalle> getCarritoDetalles(Long idCarrito);
    
    public void save(CarritoDetalle carritoDetalle);
    
    public void delete(CarritoDetalle carritoDetalle);
    
    public void deleteAll(Long idCarrito);
}
