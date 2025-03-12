package com.example.ApiSistemaCadastro.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
@Entity
@Table(name = "credenciais")
public class CredenciasModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Setter
    @Getter
    @Column(nullable = false, unique = true , length = 150)
    private String emailGmail;

    @Setter
    @Getter
    @Column(nullable = false, unique = false, length = 150)
    private String passwordGmail;

    @Setter
    @Getter
    @Column (nullable = false, unique = true, length = 150)
    private String emailOutlook;

    @Setter
    @Getter
    @Column (nullable = false, unique = false, length = 150)
    private String passwordOutlook;

    @Setter
    @Getter
    @Column (nullable = true, unique = true, length = 150)
    private String usuarioTop;

    @Setter
    @Getter
    @Column (nullable = true, unique = false, length = 150)
    private String passwordTop;

    @Setter
    @Getter
    @Column (nullable = true, unique = true, length = 150)
    private String teamViewerAcesso;

}
