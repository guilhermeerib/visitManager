package com.estagio.visitManager.entities;


import com.fasterxml.jackson.annotation.JsonFormat;
//import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
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

    @JsonIgnore
    @OneToMany(mappedBy = "usuario",targetEntity = Setor.class)
    private List<Setor> setores;

    @JsonIgnore
    @OneToMany(mappedBy = "usuario", targetEntity = Pessoa.class)
    private List<Pessoa> pessoas;

    @JsonIgnore
    @OneToMany(mappedBy = "usuario", targetEntity = Registro.class)
    private List<Registro> registros;


}

