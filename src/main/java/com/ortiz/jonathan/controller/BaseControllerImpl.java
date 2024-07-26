package com.ortiz.jonathan.controller;

import com.ortiz.jonathan.entity.BaseId;
import com.ortiz.jonathan.service.BaseServiceImpl;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;


public abstract class BaseControllerImpl<E extends BaseId, S extends BaseServiceImpl<E, Long>> implements BaseController<E, Long> {

    
    private final S service;

    public BaseControllerImpl(S service) {
        this.service = service;
    }

    @Override
    @GetMapping("")
    public ResponseEntity<?> getAll() {
        List<E> lista = service.findAll();
        return new ResponseEntity<>(lista, HttpStatus.OK);
    }

    @Override
    @GetMapping("page/{page}")
    public Page<E> getAll(Pageable pageable) {
        return service.findAll(pageable);
    }

    /*@GetMapping("/futbolistas/page/{page}")
    public ResponseEntity<PagedModel<EntityModel<Futbolista>>> index(@PathVariable Integer page, PagedResourcesAssembler<Futbolista> assembler) {
        Pageable pageable = PageRequest.of(page, 6);
        Page<Futbolista> futbolistas = futbolistaService.findAll(pageable);
        return   ResponseEntity.ok(assembler.toModel(futbolistas));
    }*/


    /*@GetMapping("/{id}")
    public ResponseEntity<?> show(@PathVariable Long id) {
        Optional<E> opcional = service.findById(id);
        return new ResponseEntity<>(opcional, HttpStatus.OK);
    }*/


    @Override
    @GetMapping("/{id}")
    public ResponseEntity<?> getOne(@PathVariable Long id) {
        Optional<E> optional = service.findById(id);
        return new ResponseEntity<>(optional, HttpStatus.OK);
    }

    @Override
    @PostMapping("/guardar")
    public ResponseEntity<?> save(@RequestBody E entity) {
        E saved = service.save(entity);
        return new ResponseEntity<>(saved,HttpStatus.OK);
    }
}
