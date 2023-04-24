package com.estagio.visitManager.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

@Entity
@Table
public class Pessoa implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
//    @Column(nullable = false)
    private String nome;
//    @Column(nullable = false, unique = true)
//    @Pattern(regexp = "\\d{11}", message = "CPF invalido")
    private String cpf;
//    @Column(nullable = true)
    private Boolean isAtivo = true;
//    @Column(nullable = false)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm", timezone = "UTC")
    private Timestamp createdAt;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    @JsonIgnore
    private Usuario usuario;
    @OneToMany(mappedBy = "pessoa")
    private List<Registro> registros;


    //construtores

    public Pessoa() {
    }

    public Pessoa(Long id, String nome, String cpf,Boolean isAtivo,Timestamp createdAt) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.isAtivo = isAtivo;
        this.createdAt = createdAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Boolean getAtivo() {
        return isAtivo;
    }

    public void setAtivo(Boolean ativo) {
        isAtivo = ativo;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}

