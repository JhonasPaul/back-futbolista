package com.ortiz.jonathan.service;

import com.ortiz.jonathan.entity.BaseId;
import com.ortiz.jonathan.repository.BaseRepositorio;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;



public abstract class BaseServiceImpl<E extends BaseId, ID> implements BaseService<E, ID> {


    private final BaseRepositorio<E, ID> baserepository;

    public BaseServiceImpl(BaseRepositorio<E, ID> baserepository) {
        this.baserepository = baserepository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<E> findAll() {
        return baserepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Page<E> findAll(Pageable pageable) {
        return baserepository.findAll(pageable);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<E> findById(ID id) {
        return baserepository.findById(id);
    }

    @Override
    public E save(E entity) {
        return baserepository.save(entity);
    }
}
