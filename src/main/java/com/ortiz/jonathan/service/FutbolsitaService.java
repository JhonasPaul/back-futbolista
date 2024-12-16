package com.ortiz.jonathan.service;

import com.ortiz.jonathan.entity.Futbolista;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


public interface FutbolsitaService{

    Page<Futbolista>paginate(Pageable page);
    Futbolista listarFutbolistaPorId(Long id);
}
