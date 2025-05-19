package com.example.ApiSistemaCadastro.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.sql.Date;
import java.time.LocalDate;

@Entity
@Table(name = "licenca_office")
public class LicencaOfficeModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Setter
    @Getter
    @Column(name="nome", nullable = false, length = 200)
    private String nome;

    @Setter
    @Getter
    @Column(name = "email",nullable = false, unique = true , length = 200)
    private String email;

    @Setter
    @Getter
    @Column(name = "senha", nullable = false, length = 200)
    private String senha;


    @Setter
    @Getter
    @Column(name = "data_expiracao", nullable = false)
    private LocalDate dataVencimento;

}
