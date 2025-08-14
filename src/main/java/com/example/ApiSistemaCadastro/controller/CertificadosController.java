package com.example.ApiSistemaCadastro.controller;

import com.example.ApiSistemaCadastro.model.CertificadosModel;
import com.example.ApiSistemaCadastro.model.LicencaOfficeModel;
import com.example.ApiSistemaCadastro.services.CertificadosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.io.IOException;
import java.util.List;

@RequestMapping
@RestController
public class CertificadosController {

    @Autowired
    private CertificadosService certificadosService;

    @GetMapping("/Listar/ListarCertificados")
    public ResponseEntity<List<CertificadosModel>> ListarCertificados() {
        try {
            List<CertificadosModel> certificados = certificadosService.listarCertificados();
            return new ResponseEntity<>(certificados, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PostMapping("/Cadastrar/CadastrarCertificados")
    public ResponseEntity<String> CadastrarCertificados(@RequestBody CertificadosModel certificado) throws IOException {
        try{
            CertificadosModel cert = certificadosService.cadastrarCertificado(certificado);
            return ResponseEntity.status(HttpStatus.CREATED).body("Nome: " + cert.getNomeCertificado() + "\n"
                    + "Empresa: "+cert.getNomeEmp() + "\n"
                    + "Data De Vencimento: "+cert.getDataVencimento() + "\n");
        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao cadastrar o certificado");
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    @PatchMapping("/Atualizar/AtualizarCertificado/{nomeCertificado}")
    public ResponseEntity<String> AtualizarFicha(@PathVariable String nomeCertificado, @RequestBody CertificadosModel certificadoAtualizado) {
        try {
            certificadosService.atualizarCertificado(nomeCertificado, certificadoAtualizado);
            return ResponseEntity.ok("Certificado atualizado com sucesso: " + nomeCertificado);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }



}

