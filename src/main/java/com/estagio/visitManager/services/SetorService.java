package com.estagio.visitManager.services;

import com.estagio.visitManager.entities.Setor;
import com.estagio.visitManager.repositories.SetorRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SetorService {
    @Autowired
    private SetorRepository repository;

    public List<Setor> findAll() {
        return repository.findAll();
    }

    public Setor findById(Long id) {
        Optional<Setor> obj = repository.findById(id);
        return obj.get();
    }

    public void excluirSetor(Long id){
        repository.deleteById(id);
    }


}
