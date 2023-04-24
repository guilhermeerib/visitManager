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
    private RegistroRepository registroRepository;

    public List<Registro> findAll() {
        return registroRepository.findAll();
    }

    public Registro findById(Long id) {
        Optional<Registro> obj = registroRepository.findById(id);
        return obj.get();
    }
    public Registro criarRegistro(Registro obj){
        return registroRepository.save(obj);

    }

}
