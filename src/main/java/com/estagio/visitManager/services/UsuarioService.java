package com.estagio.visitManager.services;

import com.estagio.visitManager.entities.Usuario;
import com.estagio.visitManager.repositories.UsuarioRepository;

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
public class UsuarioService {
    @Autowired
    private UsuarioRepository repository;

    public List<Usuario> findAll() {
        return repository.findAll();
    }

    public Usuario findById(Long id) {
        Optional<Usuario> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    //Controlador para inserir os dados na entidade Usuário;
    public Usuario criarUsuario(Usuario obj) {
        return repository.save(obj);
    }

    public void  excluirUsuario(Long id) {
        try {
            repository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException(id);
        } catch (DataIntegrityViolationException e){
            throw new DatabaseException(e.getMessage());
        }
    }

    //Controlado: método para atualizar um usuário já existente
    public Usuario atualizarUsuario(Long id, Usuario obj) {
        try {
            Usuario entity = repository.getReferenceById(id);
            atualizarDados(entity, obj);
            return repository.save(entity);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException(id);
        }
    }

    //define os campos que serão atualizados na entidade Usuário
    private void atualizarDados(Usuario entity, Usuario obj) {
        entity.setName(obj.getName());
        entity.setEmail(obj.getEmail());
        entity.setSenha(obj.getSenha());
    }


}
