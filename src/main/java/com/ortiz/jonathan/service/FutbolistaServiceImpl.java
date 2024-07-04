package com.ortiz.jonathan.service;


import com.ortiz.jonathan.entity.Futbolista;
import com.ortiz.jonathan.entity.Posicion;
import com.ortiz.jonathan.repository.IFutbolistaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class FutbolistaServiceImpl implements IFutbolistaService {

	@Autowired
	private IFutbolistaRepository futbolistaRepository;

	@Override
	@Transactional(readOnly = true)
	public List<Futbolista> findAll() {
		return (List<Futbolista>) futbolistaRepository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Page<Futbolista> findAll(Pageable pageable) {
		return futbolistaRepository.findAll(pageable);
	}
	
	@Override
	@Transactional(readOnly = true)
	public Futbolista findById(Long id) {
		return futbolistaRepository.findById(id).orElse(null);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Posicion> listarPosiciones() {
		return futbolistaRepository.findAllPosiciones();
	}

}
