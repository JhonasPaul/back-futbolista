package com.ortiz.jonathan.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "posiciones")
public class Posicion extends BaseId{
    /*@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;*/
    private String posicion;

    public Posicion() {
    }

}
