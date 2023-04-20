package com.estagio.visitManager.resources;
import com.estagio.visitManager.entities.Setor;
import com.estagio.visitManager.services.SetorService;

import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/setores")
public class SetorResource {
    @Autowired
    private SetorService service;
    @GetMapping
    public ResponseEntity<List<Setor>> findAll(){
        List<Setor> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }
    @GetMapping(value = "/{id}")
    public ResponseEntity<Setor> findById(@PathVariable Long id) {
        Setor obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.excluirSetor(id);
        return ResponseEntity.noContent().build();
    }

}
