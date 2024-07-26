package com.ortiz.jonathan.controller;

import com.ortiz.jonathan.entity.BaseId;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;



public interface BaseController<E extends BaseId, ID> {
/* ? siginifa que recibe cualquir objeto que extiene de objet*/
    ResponseEntity<?> getAll();
    ResponseEntity<?> getOne(ID id);

    ResponseEntity<?> getPosiciones();
    Page<E> getAll(Pageable pageable);

    ResponseEntity<?> save(E entity);



}
