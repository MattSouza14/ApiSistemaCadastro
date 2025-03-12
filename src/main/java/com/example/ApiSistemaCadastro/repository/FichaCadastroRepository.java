package com.example.ApiSistemaCadastro.repository;


import com.example.ApiSistemaCadastro.model.FichaCadastroModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Repository
public interface FichaCadastroRepository extends JpaRepository<FichaCadastroModel, Long> {

    default <S extends FichaCadastroModel> S saveAndFlush(S entity) {
        return null;
    }
}
