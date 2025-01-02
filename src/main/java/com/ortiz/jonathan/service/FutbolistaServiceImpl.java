package com.ortiz.jonathan.service;


import com.ortiz.jonathan.entity.Futbolista;
import com.ortiz.jonathan.repository.FutbolistaRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
public class FutbolistaServiceImpl implements   FutbolsitaService{

	private final FutbolistaRepository futbolistaRepository;

	public FutbolistaServiceImpl(FutbolistaRepository futbolistaRepository) {
		this.futbolistaRepository = futbolistaRepository;
	}

	@Override
	public Page<Futbolista> paginate(Pageable pageable) {
		return futbolistaRepository.findAll(pageable);
	}

	@Override
	public Futbolista listarFutbolistaPorId(Long id) {
		return futbolistaRepository.findById(id).orElse(null);
	}

	@Override
	public void eliminarFutbolista(Long id) {
		futbolistaRepository.deleteById(id);
	}
}
