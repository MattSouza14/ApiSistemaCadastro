package com.example.ApiSistemaCadastro.repository;


import com.example.ApiSistemaCadastro.model.LicencaOfficeModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LicencaOfficeRepository extends JpaRepository<LicencaOfficeModel, Long> {

//    default <S extends FichaCadastroModel> S saveAndFlush(S entity) {
//        return null;
//    }

    Optional<LicencaOfficeModel> findByEmail(String email);
}
