package com.estagio.visitManager.resources;

import com.estagio.visitManager.entities.Pessoa;
import com.estagio.visitManager.services.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/pessoas")
public class PessoaResource{
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
}

