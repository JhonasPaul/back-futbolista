package com.ortiz.jonathan.service;

import com.ortiz.jonathan.entity.BaseId;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


public interface BaseService<E extends BaseId, ID> {

    List<E> findAll();

    Page<E> findAll(Pageable pageable);

    Optional<E> findById(ID id);

    E save(E entity);
}
