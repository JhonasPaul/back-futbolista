package com.ortiz.jonathan.controller;


import com.ortiz.jonathan.entity.Futbolista;
import com.ortiz.jonathan.entity.Posicion;
import com.ortiz.jonathan.service.FutbolistaServiceImpl;
import com.ortiz.jonathan.service.FutbolsitaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;


import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/api/futbolistas")
public class FutbolistaController {

    private final FutbolsitaService service;

    protected FutbolistaController(FutbolsitaService service) {
        this.service = service;
    }


    @GetMapping("/page/{page}")
    public ResponseEntity<Page<Futbolista>> getFutbolistas(@PathVariable Integer page) {
        Pageable pageable = PageRequest.of(page, 10);
        return new ResponseEntity<>(service.paginate(pageable),HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Futbolista> getFutbolista(@PathVariable Long id) {
        return new ResponseEntity<>(service.listarFutbolistaPorId(id), HttpStatus.OK);
    }
}

