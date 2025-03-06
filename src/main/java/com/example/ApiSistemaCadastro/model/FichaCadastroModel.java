package com.example.ApiSistemaCadastro.model;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "ficha")
public class FichaCadastroModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false, length = 200)
    private String nome;

    @Column(nullable = false, unique = true , length = 200)
    private String email;

    @Column(nullable = false, unique = true, length = 200)
    private LocalDate dataVencimento;
}
