package com.example.ApiSistemaCadastro.model;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class EquipamentosModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome_equipamento", nullable = false, unique = true, length = 200)
    private String nomeEquipamento;

    @Column(name = "descricao", length = 320)
    private String descricao;

    @Column(name = "quantidade_total", nullable = false)
    private int quantidadeTotal;

    @Column(name = "quantidade_disponivel", nullable = false)
    private int quantidadeDisponivel;

    @Column(name = "status", columnDefinition = "boolean default true")
    private boolean status;

    @Column(name = "tipo_equipamento", nullable = false, length = 100)
    private String tipoEquipamento;

    // Método para marcar equipamento como em uso
    public void marcarComoEmUso() {
        if (this.quantidadeDisponivel > 0) {
            this.status = true;
            this.quantidadeDisponivel--;
        } else {
            throw new IllegalStateException("Não há equipamentos disponíveis");
        }
    }

    // Método para devolver equipamento
    public void devolverEquipamento() {
        if (this.status && this.quantidadeDisponivel < this.quantidadeTotal) {
            this.status = false;
            this.quantidadeDisponivel++;
        }
    }

}
