package com.ortiz.jonathan.repository;


import com.ortiz.jonathan.entity.Futbolista;
import com.ortiz.jonathan.entity.Posicion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IFutbolistaRepository extends JpaRepository<Futbolista, Long> {
    @Query("from Posicion ")
    public List<Posicion> findAllPosiciones();
}
