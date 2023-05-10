package com.estagio.visitManager.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
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
public class Pessoa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false, unique = true)
//    @Pattern(regexp = "\\d{11}", message = "CPF invalido")
    private String cpf;

    @Column(nullable = false)
    private Boolean isAtivo = true;

    @Column(nullable = false)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm", timezone = "UTC")
    private Timestamp createdAt;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "id_usuario")
//    @JsonIgnore
    private Usuario usuario;
    @JsonIgnore
    @OneToMany(mappedBy = "pessoa", targetEntity = Registro.class)
    private List<Registro> registros;
}

