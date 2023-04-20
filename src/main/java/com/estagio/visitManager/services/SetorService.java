package com.estagio.visitManager.services;

import com.estagio.visitManager.entities.Setor;
import com.estagio.visitManager.repositories.SetorRepository;

import com.estagio.visitManager.services.exceptions.DatabaseException;
import com.estagio.visitManager.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
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
    public Setor criarSetor(Setor obj) {
        return repository.save(obj);
    }

    public void excluirSetor(Long id) {
        try {
            repository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException(id);
        } catch (DataIntegrityViolationException e){
            throw new DatabaseException(e.getMessage());
        }
    }


}
