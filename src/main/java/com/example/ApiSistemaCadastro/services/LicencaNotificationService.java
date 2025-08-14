package com.example.ApiSistemaCadastro.services;

import com.example.ApiSistemaCadastro.NotificacaoEmailDTO;
import com.example.ApiSistemaCadastro.configuration.RabbitMQConfig;
import com.example.ApiSistemaCadastro.model.CertificadosModel;
import com.example.ApiSistemaCadastro.model.LicencaOfficeModel;
import com.example.ApiSistemaCadastro.repository.CertificadosRepository;
import com.example.ApiSistemaCadastro.repository.LicencaOfficeRepository;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class LicencaNotificationService {
    private final LicencaOfficeRepository licencaOfficeRepository;
    private final RabbitTemplate rabbitTemplate;
    private static final int DIAS_NOTIFICACAO = 7;
    private final CertificadosRepository certificadosRepository;


    public LicencaNotificationService(LicencaOfficeRepository licencaRepository,
                                      RabbitTemplate rabbitTemplate, CertificadosRepository certificadosRepository) {
        this.licencaOfficeRepository = licencaRepository;
        this.rabbitTemplate = rabbitTemplate;
        this.certificadosRepository = certificadosRepository;
    }
    //             seg min hrs dia mes
    @Scheduled(cron = "0 58 13 * * ?")
    public void verificarLicencasProximasExpiracao() {
        LocalDate dataNotificacao = LocalDate.now().plusDays(DIAS_NOTIFICACAO);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        List<LicencaOfficeModel> licencas = licencaOfficeRepository
                .findByDataVencimentoBetween(LocalDate.now(), dataNotificacao);
        List<CertificadosModel> certificados = certificadosRepository
                .findByDataVencimentoBetween(LocalDate.now(), dataNotificacao);

        licencas.forEach(licenca -> {
            String dataFormatada = licenca.getDataVencimento().format(formatter);

            NotificacaoEmailDTO notificacaoOffice = new NotificacaoEmailDTO(
                    "mateussouza.malibru@gmail.com",
                    "Licença do Office está próxima da expiração",
                    String.format("Informamos que a licença do " +
                     "Microsoft Office vinculada ao  usuário %s está programada para expirar em %s." +
                     "\n\nRecomendamos que providencie a renovação antes desta data para evitar interrupções no uso."
                     , licenca.getNome(), dataFormatada)
            );
                    rabbitTemplate.convertAndSend(
                    RabbitMQConfig.LICENCA_EXPIRANDO_QUEUE,
                    notificacaoOffice);
        });


        certificados.forEach(certificado -> {
            String dataFormatada = certificado.getDataVencimento().format(formatter);

            NotificacaoEmailDTO notificacaoCertificado = new NotificacaoEmailDTO(
                    "suporte.ti@dicoco.com.br",
                    "Certificado Digital Próximo da Expiração",
                    String.format(
                            "Prezados,\n\nBom dia" +
                                    "\n\nInformamos que o Certificado %s da Empresa %s está programado para expirar na data %s" +
                                    "\n\nRecomendamos que providencie a renovação antes desta data para evitar interrupções no uso.",
                            certificado.getNomeCertificado(),
                            certificado.getNomeEmp(),
                            dataFormatada)


            );
            rabbitTemplate.convertAndSend(
                    RabbitMQConfig.LICENCA_EXPIRANDO_QUEUE,
                    notificacaoCertificado);
        });
    }
}