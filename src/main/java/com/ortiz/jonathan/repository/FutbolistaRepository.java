package com.ortiz.jonathan.repository;


import com.ortiz.jonathan.entity.Futbolista;
import org.springframework.data.jpa.repository.JpaRepository;


public interface FutbolistaRepository extends JpaRepository<Futbolista, Long> {
    /*@Query("from Posicion ")
     List<Posicion> findAllPosiciones();*/
}
