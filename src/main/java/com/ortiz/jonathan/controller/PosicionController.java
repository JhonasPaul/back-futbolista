package com.ortiz.jonathan.controller;

import com.ortiz.jonathan.service.PosicionService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/posiciones")
public class PosicionController {

    private final PosicionService service;

    public PosicionController(PosicionService service) {
        this.service = service;
    }

}
