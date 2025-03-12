package com.example.ApiSistemaCadastro.services;

import com.example.ApiSistemaCadastro.model.FichaCadastroModel;
import com.example.ApiSistemaCadastro.repository.FichaCadastroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FichaCadastroServices {
    @Autowired
    private FichaCadastroRepository fichaCadastroRepository;

//    public String hello(String name) {
//        return "Hello " + name;
//    }

    public List<FichaCadastroModel> listarFichas() {
        return fichaCadastroRepository.findAll();
    }
    public FichaCadastroModel cadastrarFicha(FichaCadastroModel ficha) {
        return fichaCadastroRepository.save(ficha);
    }
    public Optional<FichaCadastroModel> buscarFichaPorEmail(String email) {
        return fichaCadastroRepository.findByEmail(email);
    }
    public String ExcluirFicha(String email) {
        Optional<FichaCadastroModel> ficha = fichaCadastroRepository.findByEmail(email);
        if(ficha.isPresent()) {
            fichaCadastroRepository.delete(ficha.get());
            return "Ficha deletada com sucesso";
        }else {
            return "Não foi possivel excluir a ficha";
        }

    }

}
