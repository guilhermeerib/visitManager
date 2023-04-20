package com.estagio.visitManager.controllers;

import com.estagio.visitManager.entities.Pessoa;
import com.estagio.visitManager.services.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/pessoas")
public class PessoaController {
    @Autowired
    private PessoaService service;
    @GetMapping
    public ResponseEntity<List<Pessoa>> findAll(){
        List<Pessoa> list =service.findAll();
        return ResponseEntity.ok().body(list);
    }
    @GetMapping(value = "/{id}")
    public ResponseEntity<Pessoa> findById(@PathVariable Long id){
        Pessoa obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }
    @PostMapping
    public ResponseEntity<Pessoa> criarPessoa(@RequestBody Pessoa obj) {
        obj = service.criarPessoa(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).body(obj);
    }
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> excluirPessoa(@PathVariable Long id) {
        service.excluirPessoa(id);
        return ResponseEntity.noContent().build();
    }

}

