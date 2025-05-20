package com.example.ApiSistemaCadastro.configuration;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
//Classe de configuração do rabbitmq
@Configuration
public class RabbitMQConfig {
    //Nome da fila que será usada para enviar notificações de licenças expirando
    public static final String LICENCA_EXPIRANDO_QUEUE = "licenca.expirando.queue";

    @Bean
    public Queue licencaExpirandoQueue() {
        return new Queue(LICENCA_EXPIRANDO_QUEUE, true);//true = indica que a fila é duravel (persistente)
    }
    //Conversor de mensagens, transforma obj java em json e vice-versa
    @Bean
    public Jackson2JsonMessageConverter messageConverter() {
        return new Jackson2JsonMessageConverter();
    }
    //Classe principal para interagir com spring
    @Bean
    public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory,
                                         Jackson2JsonMessageConverter messageConverter) {
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(messageConverter);
        return rabbitTemplate;
    }


}
