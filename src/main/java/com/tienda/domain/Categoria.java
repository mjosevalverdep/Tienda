
package com.tienda.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.io.Serializable;
import lombok.Data;

@Data
@Entity
@Table(name="categoria")
public class Categoria implements Serializable {
    private static final long serialVersionUID=1L;
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id_categoria")
    private Long idCategoria; // se transforma en id_categoria
    private String descripcion;
    private boolean activo;

    public Categoria() {
    }

    public Categoria(String descripcion, boolean activo) {
        this.descripcion = descripcion;
        this.activo = activo;
    }

   
    
    
}
