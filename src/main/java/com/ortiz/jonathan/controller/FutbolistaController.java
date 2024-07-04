package com.ortiz.jonathan.controller;


import com.ortiz.jonathan.entity.Futbolista;
import com.ortiz.jonathan.entity.Posicion;
import com.ortiz.jonathan.service.IFutbolistaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;



@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/api")
public class FutbolistaController {

	@Autowired
	private IFutbolistaService futbolistaService;

	@GetMapping("/futbolistas")
	public List<Futbolista> index() {
		return futbolistaService.findAll();
	}
	
	@GetMapping("/futbolistas/page/{page}")
	public Page<Futbolista> index(@PathVariable Integer page) {
		Pageable pageable = PageRequest.of(page, 6);
		return futbolistaService.findAll(pageable);
	}
	
	@GetMapping("/futbolistas/{id}")
	public ResponseEntity<?> show(@PathVariable Long id) {
		Futbolista futbolista = null;
		Map<String, Object> response = new HashMap<>();
		return new ResponseEntity<Futbolista>(futbolista, HttpStatus.OK);
	}

	@GetMapping("/futbolistas/posiciones")
	private List<Posicion> listarPosiciones() {
		return futbolistaService.listarPosiciones();
	}
}
