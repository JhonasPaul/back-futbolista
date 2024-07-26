package com.ortiz.jonathan.controller;

import com.ortiz.jonathan.entity.Posicion;
import com.ortiz.jonathan.service.PosicionService;
import com.ortiz.jonathan.service.PosicionServiceImpl;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/posiciones")
public class PosicionController extends BaseControllerImpl<Posicion, PosicionServiceImpl> {

    private final PosicionServiceImpl service;

    public PosicionController(PosicionServiceImpl service) {
        super(service);
        this.service = service;
    }

    @Override
    public ResponseEntity<?> getAll() {
        List<Posicion> listar = service.findAll();
        return new ResponseEntity<>(listar, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> getOne(Long id) {
        Optional<Posicion> posicionId = service.findById(id);
        return new ResponseEntity<>(posicionId, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> save(Posicion entity) {
        Posicion guardar = service.save(entity);
        return new ResponseEntity<>(guardar, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> getPosiciones() {
        return null;
    }



}
