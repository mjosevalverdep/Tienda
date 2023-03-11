
package com.tienda.service;

import com.tienda.dao.ArticuloDao;
import com.tienda.domain.Articulo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service //IMPORTANTEEE A LAS PERSONAS NO LES APARECEN LOS MÉTODOS DESPÚES POR NO PONER ESO
public class ArticuloServiceImpl implements ArticuloService{
    
    @Autowired
    private ArticuloDao articuloDao;
    
    @Override
    @Transactional(readOnly = true) //Para menejar transacciones de solo lectura
    public List<Articulo> getArticulos(boolean activos) {
       var lista=(List<Articulo>)articuloDao.findAll();
       
       if(activos){
           lista.removeIf(e->!e.isActivo());
       }
       return lista;
    }

    @Override
    @Transactional(readOnly = true) //Para menejar transacciones de solo lectura
    public Articulo getArticulo(Articulo articulo) {
        return articuloDao.findById(articulo.getIdArticulo()).orElse(null);
    }

    @Override
    @Transactional
    public void save(Articulo articulo) {
        articuloDao.save(articulo);
    }

    @Override
    @Transactional
    public void delete(Articulo articulo) {
       articuloDao.deleteById(articulo.getIdArticulo()); 
    }  
}





