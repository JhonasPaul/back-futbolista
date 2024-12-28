package com.ortiz.jonathan.service;

import com.ortiz.jonathan.entity.Futbolista;
import com.ortiz.jonathan.entity.dtos.FutbolistaDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;


public interface FutbolsitaService {
//    Page<Futbolista>paginate(Pageable pageable);
    Page<FutbolistaDto>paginate(Pageable pageable);

    Futbolista listarFutbolistaPorId(Long id);
}
