
package com.tienda.service;

import com.tienda.dao.CategoriaDao;
import com.tienda.domain.Categoria;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service //IMPORTANTEEE A LAS PERSONAS NO LES APARECEN LOS MÉTODOS DESPÚES POR NO PONER ESO
public class CategoriaServiceImpl implements CategoriaService{
    
    @Autowired
    private CategoriaDao categoriaDao;
    
    @Override
    @Transactional(readOnly = true) //Para menejar transacciones de solo lectura
    public List<Categoria> getCategorias(boolean activos) {
       var lista=(List<Categoria>)categoriaDao.findAll();
       
       if(activos){
           lista.removeIf(e->!e.isActivo());
       }
       return lista;
    }

    @Override
    @Transactional(readOnly = true) //Para menejar transacciones de solo lectura
    public Categoria getCategoria(Categoria categoria) {
        return categoriaDao.findById(categoria.getIdCategoria()).orElse(null);
    }

    @Override
    @Transactional
    public void save(Categoria categoria) {
       categoriaDao.save(categoria);
    }

    @Override
    @Transactional
    public void delete(Categoria categoria) {
      categoriaDao.deleteById(categoria.getIdCategoria()); 
    }
    
}

