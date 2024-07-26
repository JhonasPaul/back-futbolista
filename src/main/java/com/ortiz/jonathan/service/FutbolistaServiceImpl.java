package com.ortiz.jonathan.service;


import com.ortiz.jonathan.entity.Futbolista;
import com.ortiz.jonathan.repository.BaseRepositorio;
import org.springframework.stereotype.Service;


@Service
public class FutbolistaServiceImpl extends BaseServiceImpl<Futbolista, Long> implements FutbolsitaService{

	public FutbolistaServiceImpl(BaseRepositorio<Futbolista, Long> baserepository) {
		super(baserepository);

	}

}
