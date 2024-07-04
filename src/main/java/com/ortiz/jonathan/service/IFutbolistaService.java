package com.ortiz.jonathan.service;


import com.ortiz.jonathan.entity.Futbolista;
import com.ortiz.jonathan.entity.Posicion;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IFutbolistaService {

	public List<Futbolista> findAll();
	
	public Page<Futbolista> findAll(Pageable pageable);
	
	public Futbolista findById(Long id);

	List<Posicion>listarPosiciones();

}
