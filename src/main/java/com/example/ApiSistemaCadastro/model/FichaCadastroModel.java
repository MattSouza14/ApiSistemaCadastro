package com.example.ApiSistemaCadastro.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "ficha")
public class FichaCadastroModel implements Serializable {

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
    @Column(name = "dataVencimento", nullable = false, unique = false)
    private LocalDate dataVencimento;

}
