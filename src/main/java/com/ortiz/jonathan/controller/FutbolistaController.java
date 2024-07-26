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
@RequestMapping("/futbolistas")
public class FutbolistaController extends BaseControllerImpl<Futbolista, FutbolistaServiceImpl> {

    private final FutbolistaServiceImpl service;

    protected FutbolistaController(FutbolistaServiceImpl service) {
        super(service);
        this.service = service;
    }


    @Override
    public ResponseEntity<?> getAll() {
        List<Futbolista> lista = service.findAll();
        return new ResponseEntity<>(lista, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> getOne(Long id) {
        Optional<Futbolista> futbolistaPorId = service.findById(id);
        return new ResponseEntity<>(futbolistaPorId, HttpStatus.OK);
    }


    @Override
    public ResponseEntity<?> getPosiciones() {
        Posicion posicion = new Posicion();
        return new ResponseEntity<Posicion>(posicion, HttpStatus.OK);
    }


    public Page<Futbolista> getAll(@PathVariable Integer page, Pageable pageable) {
         pageable = PageRequest.of(page, 6);
        return service.findAll(pageable);
    }

    /*@Override
    public Page<Futbolista> getAll(Pageable pageable) {
        return service.findAll(pageable);
    }*/
}

