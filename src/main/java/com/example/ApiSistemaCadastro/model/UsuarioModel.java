package com.example.ApiSistemaCadastro.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;


@Entity
@Table(name = "usuarios")
public class UsuarioModel implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Setter
    @Getter
    @Column(nullable = false, unique = true , length = 200)
    private String nome;

    @Setter
    @Getter
    @ManyToOne
    @JoinColumn(name = "id_departamento", nullable = false)
    private DepartamentosModel departamento;

    @Setter
    @Getter
    @ManyToOne
    @JoinColumn(name = "id_credenciais", nullable = false)
    private CredenciasModel credenciais;

}
