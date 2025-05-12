package com.example.ApiSistemaCadastro.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Entity
@Table(name = "departamentos")
public class DepartamentosModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Setter
    @Getter
    @Column (name = "nome", nullable = false, unique = true, length = 250)
    private String nome;

    @Setter
    @Getter
    @Column (name = "descricao", nullable = false, length = 500)
    private String descricao;

}
