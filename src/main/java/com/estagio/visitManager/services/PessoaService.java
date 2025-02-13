package com.estagio.visitManager.services;

import com.estagio.visitManager.entities.Pessoa;
import com.estagio.visitManager.repositories.PessoaRepository;
import com.estagio.visitManager.services.exceptions.DatabaseException;
import com.estagio.visitManager.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PessoaService {
    @Autowired
    private PessoaRepository pessoaRepository;

    public List<Pessoa> findAll() {
        return pessoaRepository.findAll();
    }

    public Pessoa findById(Long id) {
        Optional<Pessoa> obj = pessoaRepository.findById(id);
        return obj.get();
    }

    // serviço para criar nova pessoa
    public Pessoa criarPessoa(Pessoa obj) {
        return pessoaRepository.save(obj);
    }

    public void excluirPessoa(Long id) {
        try {
            pessoaRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException(id);
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException(e.getMessage());
        }
    }


}
