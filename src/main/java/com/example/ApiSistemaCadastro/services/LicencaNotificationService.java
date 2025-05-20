package com.example.ApiSistemaCadastro.services;

import com.example.ApiSistemaCadastro.NotificacaoEmailDTO;
import com.example.ApiSistemaCadastro.configuration.RabbitMQConfig;
import com.example.ApiSistemaCadastro.model.LicencaOfficeModel;
import com.example.ApiSistemaCadastro.repository.LicencaOfficeRepository;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class LicencaNotificationService {
    private final LicencaOfficeRepository licencaOfficeRepository;
    private final RabbitTemplate rabbitTemplate;
    private static final int DIAS_NOTIFICACAO = 7;


    public LicencaNotificationService(LicencaOfficeRepository licencaRepository,
                                      RabbitTemplate rabbitTemplate) {
        this.licencaOfficeRepository = licencaRepository;
        this.rabbitTemplate = rabbitTemplate;
    }
    //             seg min hrs dia mes
    @Scheduled(cron = "0 0 12 20 * ?")
    public void verificarLicencasProximasExpiracao() {
        LocalDate dataNotificacao = LocalDate.now().plusDays(DIAS_NOTIFICACAO);

        List<LicencaOfficeModel> licencas = licencaOfficeRepository
                .findByDataVencimentoBetween(LocalDate.now(), dataNotificacao);

        licencas.forEach(licenca -> {
            NotificacaoEmailDTO notificacao = new NotificacaoEmailDTO(
                    "mateussouza.malibru@gmail.com",
                    "Licença do Office está próxima da expiração",
                    String.format("Licença do usuário %s, do Office expira em %s.", licenca.getNome(), licenca.getDataVencimento())
            );

            rabbitTemplate.convertAndSend(
                    RabbitMQConfig.LICENCA_EXPIRANDO_QUEUE,
                    notificacao);
        });
}
}