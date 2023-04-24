package com.estagio.visitManager.services;

import com.estagio.visitManager.entities.Setor;
import com.estagio.visitManager.repositories.SetorRepository;

import com.estagio.visitManager.services.exceptions.DatabaseException;
import com.estagio.visitManager.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SetorService {
    @Autowired
    private SetorRepository setorRepository;

    public List<Setor> findAll() {
        return setorRepository.findAll();
    }

    public Setor findById(Long id) {
        Optional<Setor> obj = setorRepository.findById(id);
        return obj.get();
    }
    public Setor criarSetor(Setor obj) {
        return setorRepository.save(obj);
    }

    public void excluirSetor(Long id) {
        try {
            setorRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException(id);
        } catch (DataIntegrityViolationException e){
            throw new DatabaseException(e.getMessage());
        }
    }
    public Setor atualizarSetor(Long id, Setor obj) {
        try {
            Setor entity = setorRepository.getReferenceById(id);
            atualizarDados(entity, obj);
            return setorRepository.save(entity);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException(id);
        }
    }

    //define os campos que serão atualizados na entidade Usuário
    private void atualizarDados(Setor entity, Setor obj) {
        entity.setNome(obj.getNome());
    }


}

