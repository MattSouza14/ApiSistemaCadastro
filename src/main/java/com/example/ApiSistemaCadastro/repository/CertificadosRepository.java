package com.example.ApiSistemaCadastro.repository;


import com.example.ApiSistemaCadastro.model.CertificadosModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface CertificadosRepository extends JpaRepository<CertificadosModel, Long> {

    List<CertificadosModel> findByDataVencimentoBetween(LocalDate startDate, LocalDate endDate);

    Optional<CertificadosModel> findByNomeCertificado(String nomeCertificado);








}
