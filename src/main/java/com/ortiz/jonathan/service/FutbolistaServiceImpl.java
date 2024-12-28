package com.ortiz.jonathan.service;


import com.ortiz.jonathan.entity.Futbolista;
import com.ortiz.jonathan.entity.dtos.FutbolistaDto;
import com.ortiz.jonathan.entity.mapper.FutbolistaMapper;
import com.ortiz.jonathan.repository.FutbolistaRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
public class FutbolistaServiceImpl implements   FutbolsitaService{

	private final FutbolistaRepository futbolistaRepository;
	private final FutbolistaMapper futbolistaMapper;

	public FutbolistaServiceImpl(FutbolistaRepository futbolistaRepository, FutbolistaMapper futbolistaMapper) {
		this.futbolistaRepository = futbolistaRepository;
		this.futbolistaMapper = futbolistaMapper;
	}

	/*@Override
	public Page<Futbolista> paginate(Pageable pageable) {
		return futbolistaRepository.findAll(pageable);
	}*/

	@Override
	public Page<FutbolistaDto> paginate(Pageable pageable) {
		return futbolistaRepository.findAll(pageable)
				.map(u -> futbolistaMapper.toFutbolistaDto(u)
		);
	}

	@Override
	public Futbolista listarFutbolistaPorId(Long id) {
		return futbolistaRepository.findById(id).orElse(null);
	}
}
