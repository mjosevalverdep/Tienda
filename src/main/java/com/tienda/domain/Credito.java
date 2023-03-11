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
@Table(name="credito")
public class Credito implements Serializable{
    private static final long serialVersionUID=1L;
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id_credito") //Permite indicar con cual campo de base de datos se va a mapear
    private Long idCredito; // se transforma en id_credito
    private Long limite;

    public Credito() {
    }

    public Credito(Long limite) {
        this.limite = limite;
    }

}
