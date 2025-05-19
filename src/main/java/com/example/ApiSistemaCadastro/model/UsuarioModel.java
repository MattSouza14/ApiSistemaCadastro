package com.example.ApiSistemaCadastro.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;


@Entity
@Table(name = "usuario")
public class UsuarioModel implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Setter
    @Getter
    @Column(name = "nome", nullable = false, unique = true , length = 200)
    private String nome;

    @Setter
    @Getter
    @Column(name = "email", nullable = false, unique = true, length = 300)
    private String email;

    @Setter
    @Getter
    @Column(name = "login", nullable = false, unique = true, length = 150)
    private String login;

    @Setter
    @Getter
    @Column(name = "senha", nullable = false, length = 150)
    private String senha;


    @ManyToOne
    @JoinColumn(name = "departamento_id", nullable = false)
    private DepartamentosModel departamento;


    @ManyToOne
    @JoinColumn(name = "licenca_office_id", nullable = false)
    private LicencaOfficeModel licencasOffice;

}
