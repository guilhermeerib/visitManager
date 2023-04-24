package com.estagio.visitManager.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

@Entity
public class Setor implements Serializable {
    private  static  final  long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nome;
    private String descricao;
    private Boolean isAtivo;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm", timezone = "UTC")
    private Timestamp createdAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_usuario")
    @JsonIgnore
    private Usuario usuario;
    @OneToMany(mappedBy = "setor", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Registro> registros;


    public Setor() {
    }


    public Setor(Long id, String nome, String descricao,Boolean isAtivo, Timestamp createdAt, Usuario usuario) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.isAtivo = isAtivo;
        this.createdAt = createdAt;
        this.usuario = usuario;

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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
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

