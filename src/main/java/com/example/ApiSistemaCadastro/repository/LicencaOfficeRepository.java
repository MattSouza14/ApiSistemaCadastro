package com.example.ApiSistemaCadastro.repository;


import com.example.ApiSistemaCadastro.model.LicencaOfficeModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface LicencaOfficeRepository extends JpaRepository<LicencaOfficeModel, Long> {

    List<LicencaOfficeModel> findByDataVencimentoBetween(LocalDate startDate, LocalDate endDate);
    Optional<LicencaOfficeModel> findByEmail(String email);
}
