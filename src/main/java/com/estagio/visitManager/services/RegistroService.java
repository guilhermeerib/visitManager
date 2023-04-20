package com.estagio.visitManager.services;

import com.estagio.visitManager.entities.Registro;
import com.estagio.visitManager.repositories.RegistroRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RegistroService {
    @Autowired
    private RegistroRepository repository;

    public List<Registro> findAll() {
        return repository.findAll();
    }

    public Registro findById(Long id) {
        Optional<Registro> obj = repository.findById(id);
        return obj.get();
    }


}
