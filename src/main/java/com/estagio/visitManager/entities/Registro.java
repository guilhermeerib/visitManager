package com.estagio.visitManager.entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table
public class Registro implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String descricao;
    @Column(nullable = false)
    private Timestamp horaEntrada;
    @Column(nullable = false)
    private Timestamp horaSaida;
    @Column(nullable = false)
    private Boolean isAtivo;
    @ManyToOne
    @JoinColumn(name = "id_pessoa")
    private Pessoa pessoa;
    @ManyToOne
    @JoinColumn(name = "id_setor")
    private Setor setor;
    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;


    public Registro() {
    }

    public Registro(Long id, String descricao, Timestamp horaEntrada,
                    Timestamp horaSaida, Boolean isAtivo, Pessoa pessoa,
                    Setor setor, Usuario usuario) {
        this.id = id;
        this.descricao = descricao;
        this.horaEntrada = horaEntrada;
        this.horaSaida = horaSaida;
        this.isAtivo = isAtivo;
        this.pessoa = pessoa;
        this.setor = setor;
        this.usuario = usuario;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Timestamp getHoraEntrada() {
        return horaEntrada;
    }

    public void setHoraEntrada(Timestamp horaEntrada) {
        this.horaEntrada = horaEntrada;
    }

    public Timestamp getHoraSaida() {
        return horaSaida;
    }

    public void setHoraSaida(Timestamp horaSaida) {
        this.horaSaida = horaSaida;
    }

    public Boolean getAtivo() {
        return isAtivo;
    }

    public void setAtivo(Boolean ativo) {
        isAtivo = ativo;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public Setor getSetor() {
        return setor;
    }

    public void setSetor(Setor setor) {
        this.setor = setor;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

}
