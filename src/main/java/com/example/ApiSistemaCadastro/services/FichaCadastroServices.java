package com.example.ApiSistemaCadastro.services;

import com.example.ApiSistemaCadastro.model.FichaCadastroModel;
import com.example.ApiSistemaCadastro.repository.FichaCadastroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FichaCadastroServices {
    @Autowired
    private FichaCadastroRepository fichaCadastroRepository;

//    public String hello(String name) {
//        return "Hello " + name;
//    }

    public FichaCadastroModel cadastrarFicha(FichaCadastroModel ficha) {
        return fichaCadastroRepository.save(ficha);
    }


}
