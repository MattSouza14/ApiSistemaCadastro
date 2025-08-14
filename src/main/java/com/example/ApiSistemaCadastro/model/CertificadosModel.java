package com.example.ApiSistemaCadastro.model;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

import java.time.LocalDate;

@Entity
@Table(name = "certificados_digitais")
public class CertificadosModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Setter
    @Getter
    @Column(name="nome_empresa", nullable = false, length = 150)
    private String nomeEmp;

    @Setter
    @Getter
    @Column(name = "nome_certificado" , nullable = false, length = 150)
    private String nomeCertificado;

    @Setter
    @Getter
    @Column(name = "data_vencimento", nullable = false)
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate dataVencimento;

}
