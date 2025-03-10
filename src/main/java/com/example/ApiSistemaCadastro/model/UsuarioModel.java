package com.example.ApiSistemaCadastro.model;

import jakarta.persistence.*;

import java.io.Serializable;


@Entity
@Table(name = "usuarios")
public class UsuarioModel implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(nullable = false, unique = true , length = 200)
    private String nome;

    @ManyToOne
    @JoinColumn(name = "id_departamento", nullable = false)
    private DepartamentosModel departamento;

    @ManyToOne
    @JoinColumn(name = "id_credenciais", nullable = false)
    private CredenciasModel credenciais;

}
