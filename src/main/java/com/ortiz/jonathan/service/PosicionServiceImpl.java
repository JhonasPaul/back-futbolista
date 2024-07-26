package com.ortiz.jonathan.service;

import com.ortiz.jonathan.entity.Posicion;
import com.ortiz.jonathan.repository.BaseRepositorio;
import org.springframework.stereotype.Service;

@Service
public class PosicionServiceImpl extends BaseServiceImpl<Posicion, Long> implements PosicionService {

    public PosicionServiceImpl(BaseRepositorio<Posicion, Long> baserepository) {
        super(baserepository);
    }
}
