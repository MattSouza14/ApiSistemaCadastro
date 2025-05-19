package com.example.ApiSistemaCadastro.repository;


import com.example.ApiSistemaCadastro.model.EquipamentosModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EquipamentoRepository extends JpaRepository<EquipamentosModel, Long> {
    Optional<EquipamentosModel> findByNome(String nome);
}