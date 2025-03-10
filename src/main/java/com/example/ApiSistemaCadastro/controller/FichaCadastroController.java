package com.example.ApiSistemaCadastro.controller;

import com.example.ApiSistemaCadastro.services.FichaCadastroServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@RequestMapping
@RestController
public class FichaCadastroController {


    @Autowired
    private FichaCadastroServices fichaCadastroServices;

    @GetMapping("/Teste")
    public String teste(){
        return fichaCadastroServices.hello("Mateus");
    }
    //Deixando em void os endpoint por enquanto que não tem os services
    @GetMapping("/Listar/ListarFichas")
    public void ListarFichas(){
        return;
    }
    @GetMapping("/Listar/ListarUmaFicha")
    public void ListarUmaFicha(){
        return;
    }
    @PostMapping("/Cad/CadastrarFicha")
    public void CadastrarFicha(){
        return;
    }
    @PostMapping("/Login")
    public void Login(){
        return;
    }
    @PatchMapping("/Atualizar/AtulizarUmaFicha")
    public void AtualizarFicha(){
        return;
    }
    @DeleteMapping("/Del/DeletarFicha")
    public void DeletarFicha(){
        return;
    }



    //Endpoints para cadastro de nova ficha
//    @GetMapping("/V1/Cadastro")
    //Endpoint para listar cadastros
 //   @GetMapping("/V1/ListarCadastros")
    //Endpoint para excluir ficha
//    @DeleteMappingw("/V1/ExcluirCadastro")
    //Endpoint para alterar data ou toda a ficha

}





//public void setDataVencimento(String dataVencimento) {
//    try {
//        this.dataVencimento = LocalDate.parse(dataVencimento, fmt1);
//    } catch (Exception e) {
//        System.err.println("Erro ao definir data de vencimento: formato invalido (" + dataVencimento + ")");
//        this.dataVencimento = null;
//    }
//}
//
////    public static ArrayList<FichaCadastro> ListarCadastros() {
////    }
////    public static String adicionarNovoCadastro(){
////
////    }
//
//public static FichaCadastro pesquisarCadastro(String email, ArrayList<FichaCadastro> cadastros) {
//    return cadastros.stream()//Transforma a lista em Stream
//            .filter(f -> f.getEmail().equalsIgnoreCase(email))//Compara os emails ignorando maiusculas e minusculas
//            .findFirst() //Pega o primeiro elemento que corresponde ao filtro (se existir).Se houver varios cadastros com o mesmo email, somente o primeiro encontrado será retornado.
//            .orElse(null);//Se nenhum cadastro for encontrado vai retornar null.
//}
//
//@Override
//public String toString() {
//    return String.format(
//            "Nome do Usuario: %s%nConta Office: %s%nData de Vencimento: %s",
//            nome, email, dataVencimento != null ? dataVencimento.format(fmt1) : "Data invalida"
//    );
//}
