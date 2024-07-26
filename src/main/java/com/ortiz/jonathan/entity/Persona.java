package com.ortiz.jonathan.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@MappedSuperclass
@Getter
@Setter
public class Persona extends BaseId{

    protected String nombres;
    protected String apellidos;
    protected String fechaNacimiento;

}
