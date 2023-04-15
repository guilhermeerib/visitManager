package com.estagio.visitManager.entities;


import jakarta.persistence.*;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "tb_user") //banco h2 tem como palavra reservada User;

public class User implements  Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String cpf;
    private String email;

    private String senha;
    private Boolean isAtivo =true;

    private Boolean isAdmin =false;
    private Timestamp createdAt ;  //  new Timestamp(System.currentTimeMillis())



    public User(Long id, String name, String cpf, String email, String senha, Boolean isAtivo, Boolean isAdmin) {
        this.id = id;
        this.name = name;
        this.cpf = cpf;
        this.email = email;
        this.senha = senha;
        this.isAtivo = isAtivo;
        this.isAdmin = isAdmin;
        this.createdAt = createdAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Boolean getAtivo() {
        return isAtivo;
    }

    public void setAtivo(Boolean ativo) {
        isAtivo = ativo;
    }

    public Boolean getAdmin() {
        return isAdmin;
    }

    public void setAdmin(Boolean admin) {
        isAdmin = admin;
    }

    public Timestamp getCreatedAt() {
        return createdAt =  new Timestamp(System.currentTimeMillis());
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }


}

