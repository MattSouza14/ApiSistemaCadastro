package com.example.ApiSistemaCadastro.controller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
@SpringBootApplication
@RestController
public class FichaCadastroVencimentos {

    public static void main(String[] args) {
        SpringApplication.run(FichaCadastroVencimentos.class, args);
    }


    //Endpoints para cadastro de nova ficha
//    @GetMapping("/V1/Cadastro")
    //Endpoint para listar cadastros
 //   @GetMapping("/V1/ListarCadastros")
    //Endpoint para excluir ficha
//    @GetMapping("/V1/ExcluirCadastro")
    //Endpoint para alterar data ou toda a ficha

}
