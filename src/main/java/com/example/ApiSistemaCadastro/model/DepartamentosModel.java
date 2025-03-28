package com.example.ApiSistemaCadastro.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Entity
@Table(name = "departamentos")
public class DepartamentosModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Setter
    @Getter
    @Column (nullable = false, unique = true, length = 150)
    private String nome;

}
