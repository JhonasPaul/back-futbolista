package com.ortiz.jonathan.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
@Table(name = "futbolistas")
public class Futbolista extends Persona {

    private String caracteristicas;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "posicion_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Posicion posicion;

    public Futbolista() {
    }


}
