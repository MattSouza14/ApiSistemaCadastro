package com.example.ApiSistemaCadastro.services;


import com.example.ApiSistemaCadastro.model.CertificadosModel;
import com.example.ApiSistemaCadastro.model.LicencaOfficeModel;
import com.example.ApiSistemaCadastro.repository.CertificadosRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CertificadosService {

    @Autowired
    private CertificadosRepository CertificadosRepository;

    public List<CertificadosModel> listarCertificados() {
        return CertificadosRepository.findAll();
    }

    public CertificadosModel cadastrarCertificado(CertificadosModel Certificado) {
        return CertificadosRepository.save(Certificado);
    }

    public void atualizarCertificado(String nomeCertificado, CertificadosModel certificadoAtualizado) {
        CertificadosModel certificadoExistente = CertificadosRepository.findByNomeCertificado(nomeCertificado)
                .orElseThrow(() -> new RuntimeException("Certificado não encontrado" ));
        if (certificadoAtualizado.getNomeCertificado() != null){
            certificadoAtualizado.setNomeCertificado(certificadoExistente.getNomeCertificado());
        }
        if (certificadoAtualizado.getNomeEmp() != null) {
            certificadoExistente.setNomeEmp(certificadoExistente.getNomeEmp());
        }
        if (certificadoAtualizado.getDataVencimento() != null) {
            certificadoExistente.setDataVencimento(certificadoExistente.getDataVencimento());
        }
        CertificadosRepository.save(certificadoExistente);
    }

    public String ExcluirCertificado(String nomeCertificado) {
        Optional<CertificadosModel> certificado = CertificadosRepository.findByNomeCertificado(nomeCertificado);
        if(certificado.isPresent()) {
            CertificadosRepository.delete(certificado.get());
            return "Certificado deletado com sucesso";
        }else {
            return "Não foi possivel excluir o certificado";
        }

    }

}
