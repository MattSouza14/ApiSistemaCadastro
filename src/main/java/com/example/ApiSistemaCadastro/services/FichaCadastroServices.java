package com.example.ApiSistemaCadastro.services;

import com.example.ApiSistemaCadastro.model.LicencaOfficeModel;
import com.example.ApiSistemaCadastro.repository.LicencaOfficeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FichaCadastroServices {
    @Autowired
    private LicencaOfficeRepository fichaCadastroRepository;

//    public String hello(String name) {
//        return "Hello " + name;
//    }

    public List<LicencaOfficeModel> listarFichas() {
        return fichaCadastroRepository.findAll();
    }
    public LicencaOfficeModel cadastrarLicenca(LicencaOfficeModel ficha) {
        return fichaCadastroRepository.save(ficha);
    }
    public Optional<LicencaOfficeModel> buscarFichaPorEmail(String email) {
        return fichaCadastroRepository.findByEmail(email);
    }
    public void atualizarFicha(String email, LicencaOfficeModel fichaAtualizada) {
        LicencaOfficeModel fichaExistente = fichaCadastroRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Ficha não encontrada para o email: " + email));
        if (fichaAtualizada.getEmail() != null){
            fichaAtualizada.setEmail(fichaExistente.getEmail());
        }
        if (fichaAtualizada.getNome() != null) {
            fichaExistente.setNome(fichaAtualizada.getNome());
        }
        if (fichaAtualizada.getDataVencimento() != null) {
            fichaExistente.setDataVencimento(fichaAtualizada.getDataVencimento());
        }

        fichaCadastroRepository.save(fichaExistente);
    }
    public String ExcluirFicha(String email) {
        Optional<LicencaOfficeModel> ficha = fichaCadastroRepository.findByEmail(email);
        if(ficha.isPresent()) {
            fichaCadastroRepository.delete(ficha.get());
            return "Ficha deletada com sucesso";
        }else {
            return "Não foi possivel excluir a ficha";
        }

    }

}
