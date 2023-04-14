package com.estagio.visitManager.entities;


import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Objects;

public class User implements  Serializable{
    private Long id;
    private String name;
    private String cpf;
    private String email;

    private String senha;
    private Boolean isAtivo =true;

    private Boolean isAdmin =false;
    /*private Timestamp createdAt =
            new Timestamp(System.currentTimeMillis()); */
    public User(Long id, String name, String cpf, String email, String senha, Boolean isAtivo, Boolean isAdmin) {
        this.id = id;
        this.name = name;
        this.cpf = cpf;
        this.email = email;
        this.senha = senha;
        this.isAtivo = isAtivo;
        this.isAdmin = isAdmin;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }









}

