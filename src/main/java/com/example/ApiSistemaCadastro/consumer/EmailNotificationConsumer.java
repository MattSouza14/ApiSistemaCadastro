package com.example.ApiSistemaCadastro.consumer;

import com.example.ApiSistemaCadastro.NotificacaoEmailDTO;
import com.example.ApiSistemaCadastro.configuration.RabbitMQConfig;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;
//Essa clase vai enviar o email/notificaçação
@Component
public class EmailNotificationConsumer {

    private final JavaMailSender mailSender;

    public EmailNotificationConsumer(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    @RabbitListener(queues = RabbitMQConfig.LICENCA_EXPIRANDO_QUEUE)
    public void processarNotificacao(NotificacaoEmailDTO notificacao) {
        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setTo(notificacao.getDestinatario());
            message.setSubject(notificacao.getAssunto());
            message.setText(notificacao.getMensagem());

            mailSender.send(message);
            System.out.println("Email enviado para: " + notificacao.getDestinatario());
        } catch (Exception e) {
            System.err.println("Erro ao enviar email: " + e.getMessage());
        }
    }
}