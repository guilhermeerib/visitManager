package com.estagio.visitManager.controllers;

import com.estagio.visitManager.entities.Setor;
import com.estagio.visitManager.services.SetorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/setores")
public class SetorController {
    @Autowired
    private SetorService setorService;

    @GetMapping
    public ResponseEntity<List<Setor>> findAll() {
        List<Setor> list = setorService.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Setor> findById(@PathVariable Long id) {
        Setor obj = setorService.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @PostMapping
    public ResponseEntity<Setor> criarSetor(@RequestBody Setor obj) {
        obj = setorService.criarSetor(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).body(obj);
    }

    //Controlador para chamar o excluirSetor
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> excluirSetor(@PathVariable Long id) {
        setorService.excluirSetor(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Setor> atualizarSetor(@PathVariable Long id, @RequestBody Setor obj) {
        obj = setorService.atualizarSetor(id, obj);
        return ResponseEntity.ok().body(obj);

    }
}
