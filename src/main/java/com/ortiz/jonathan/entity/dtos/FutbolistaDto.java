package com.ortiz.jonathan.entity.dtos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.ortiz.jonathan.entity.Posicion;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class FutbolistaDto {

    private long id;
    private String nombres;
    private String apellidos;
    private LocalDate fechaNacimiento;
    private String caracteristicas;
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Posicion posicion;
}
