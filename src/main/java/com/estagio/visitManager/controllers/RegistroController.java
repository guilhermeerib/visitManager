package com.estagio.visitManager.controllers;

import com.estagio.visitManager.entities.Registro;
import com.estagio.visitManager.services.RegistroService;

import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/registros")
public class RegistroController {
    @Autowired
    private RegistroService service;
    @GetMapping
    public ResponseEntity<List<Registro>> findAll(){
        List<Registro> list =service.findAll();
        return ResponseEntity.ok().body(list);
    }
    @GetMapping(value = "/{id}")
    public ResponseEntity<Registro> findById(@PathVariable Long id) {
        Registro obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }
    @PostMapping
    public ResponseEntity<Registro> criarRegistro(@RequestBody Registro obj) {
        obj = service.criarRegistro(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).body(obj);
    }

}
