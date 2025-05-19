package com.example.ApiSistemaCadastro.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "equipamento")
public class EquipamentosModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Getter
    @Setter
    @Column(name = "nome", nullable = false, length = 255)
    private String nome;

    @Getter
    @Setter
    @Column(name = "descricao", length = 500)
    private String descricao;

    @Getter
    @Setter
    @Column(name = "disponivel", columnDefinition = "boolean default true")
    private  boolean disponivel = true;



}
