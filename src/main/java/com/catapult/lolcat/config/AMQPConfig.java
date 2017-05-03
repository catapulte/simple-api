package com.catapult.lolcat.config;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.QueueBuilder;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.amqp.support.converter.SimpleMessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.converter.StringMessageConverter;

/**
 * Created by erwann on 25/01/17.
 */
@Configuration
public class AMQPConfig {

    @Bean
    ConnectionFactory rabbitmqConnectionFactory(@Value("${amqp.host:localhost}") String host,
                                                @Value("${amqp.port:5672}") int port,
                                                @Value("${amqp.user:guest}") String user,
                                                @Value("${amqp.pass:guest}") String pass) {
        CachingConnectionFactory cf = new CachingConnectionFactory();
        cf.setHost(host);
        cf.setPort(port);
        cf.setUsername(user);
        cf.setPassword(pass);
        return cf;
    }

    @Bean
    RabbitAdmin admin(ConnectionFactory rabbitmqConnectionFactory) {
        RabbitAdmin admin = new RabbitAdmin(rabbitmqConnectionFactory);
        admin.declareQueue(catDataQueue());
        return admin;
    }

    @Bean
    Queue catDataQueue() {
        return QueueBuilder.durable("cat.data")
                .build();
    }

    @Bean
    MessageConverter stringMessageConverter() {
        return new SimpleMessageConverter();
    }
}
