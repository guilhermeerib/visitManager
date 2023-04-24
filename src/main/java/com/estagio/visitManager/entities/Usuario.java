package com.estagio.visitManager.entities;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

//Entidade usuario
@Entity
public class Usuario implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String cpf;
    @Column(nullable = false)
    private String email;
    private String senha;

    @JsonProperty("isAtivo")
    private Boolean isAtivo;

    @JsonProperty("isAdmin")
    private Boolean isAdmin;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm", timezone = "UTC")
    private Timestamp createdAt;

    @OneToMany(mappedBy = "usuario", fetch = FetchType.LAZY)
    private List<Setor> setores;
    @OneToMany(mappedBy = "usuario", fetch = FetchType.LAZY)
    private List<Pessoa> pessoas;
    @OneToMany(mappedBy = "usuario", fetch = FetchType.LAZY)
    private List<Registro> registros;

    //Construtores
    public Usuario() {
    }

    public Usuario(Long id, String name, String cpf, String email, String senha, Boolean isAtivo) {
        this.id = id;
        this.name = name;
        this.cpf = cpf;
        this.email = email;
        this.senha = senha;
        this.isAtivo = isAtivo;
        this.isAdmin = isAdmin;
    }

    //Getter and setters>>>
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
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public List<Setor> getSetores() {
        return setores;
    }

    public void setSetores(List<Setor> setores) {
        this.setores = setores;
    }

    public List<Pessoa> getPessoas() {
        return pessoas;
    }

    public void setPessoas(List<Pessoa> pessoas) {
        this.pessoas = pessoas;
    }

    public List<Registro> getRegistros() {
        return registros;
    }

    public void setRegistros(List<Registro> registros) {
        this.registros = registros;
    }


}

