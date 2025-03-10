package com.example.ApiSistemaCadastro.model;

import jakarta.persistence.*;

import java.io.Serializable;
@Entity
@Table(name = "credenciais")
public class CredenciasModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(nullable = false, unique = true , length = 150)
    private String emailGmail;

    @Column(nullable = false, unique = false, length = 150)
    private String passwordGmail;

    @Column (nullable = false, unique = true, length = 150)
    private String emailOutlook;

    @Column (nullable = false, unique = false, length = 150)
    private String passwordOutlook;

    @Column (nullable = true, unique = true, length = 150)
    private String usuarioTop;

    @Column (nullable = true, unique = false, length = 150)
    private String passwordTop;

    @Column (nullable = true, unique = true, length = 150)
    private String teamViewerAcesso;
}
