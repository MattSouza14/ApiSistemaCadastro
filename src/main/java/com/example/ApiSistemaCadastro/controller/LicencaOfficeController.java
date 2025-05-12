package com.example.ApiSistemaCadastro.controller;

import com.example.ApiSistemaCadastro.model.LicencaOfficeModel;
import com.example.ApiSistemaCadastro.services.FichaCadastroServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RequestMapping
@RestController
public class LicencaOfficeController {


    @Autowired
    private FichaCadastroServices fichaCadastroServices;

//    @GetMapping("/Teste")
//    public String teste(){
//        return fichaCadastroServices.hello("Mateus");
//    }

    @GetMapping("/Listar/ListarFichas")
    public ResponseEntity<List<LicencaOfficeModel>> ListarFichas(){
        try {
            List<LicencaOfficeModel>fichas = fichaCadastroServices.listarFichas();
            return new ResponseEntity<>(fichas, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/Listar/ListarUmaFicha/{email}")
    public ResponseEntity<LicencaOfficeModel> ListarUmaFicha(@PathVariable String email){
        try{
            Optional<LicencaOfficeModel> ficha = fichaCadastroServices.buscarFichaPorEmail(email);
            return new ResponseEntity<>(ficha.get(), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PostMapping("/Cadastrar/CadastrarFicha")
    public ResponseEntity<String> CadastrarLicenca(@RequestBody LicencaOfficeModel ficha) throws IOException {
        try{
            LicencaOfficeModel fichaCadastro = fichaCadastroServices.cadastrarLicenca(ficha);
            return ResponseEntity.status(HttpStatus.CREATED).body("Nome: "+fichaCadastro.getNome() + "\n"
            + "Email: "+fichaCadastro.getEmail() + "\n"
            + "Data De Vencimento: "+fichaCadastro.getDataVencimento() + "\n"    );
        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao cadastrar ficha");
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }
    @PostMapping("/Login")
    public void Login(){
        return;
    }


    @PatchMapping("/Atualizar/AtualizarUmaFicha/{email}")
    public ResponseEntity<String> AtualizarFicha(@PathVariable String email, @RequestBody LicencaOfficeModel fichaAtualizada) {
        try {
            fichaCadastroServices.atualizarFicha(email, fichaAtualizada);
            return ResponseEntity.ok("Ficha atualizada com sucesso para o email: " + email);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
    @DeleteMapping("/Deletar/DeletarFicha/{email}")
    public ResponseEntity<String> DeletarFicha(@PathVariable String email){
        try{
            String ficha = fichaCadastroServices.ExcluirFicha(email);
            return new ResponseEntity<>(ficha, HttpStatus.OK);

        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }


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
