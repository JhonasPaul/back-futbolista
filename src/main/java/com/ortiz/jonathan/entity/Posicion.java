package com.ortiz.jonathan.entity;


import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "posiciones")
public class Posicion implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String posicion;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPosicion() {
        return posicion;
    }

    public void setPosicion(String posicion) {
        this.posicion = posicion;
    }

    private static final long serialVersionUID =1L;

}
