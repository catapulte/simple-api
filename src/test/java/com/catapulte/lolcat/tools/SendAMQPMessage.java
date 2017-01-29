package com.catapulte.lolcat.tools;

import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

public class SendAMQPMessage {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SendAMQPMessage.class);
        RabbitTemplate rabbitmq = context.getBean(RabbitTemplate.class);
        rabbitmq.convertAndSend("cat.data", "#1|4810.8296N|126.8342W|84.20|174.00|8|28/1/2017@22:35:7.0|19.00|41.60|4.32#");
        context.close();
    }

    @Bean
    ConnectionFactory rabbitmqConnectionFactory(@Value("${amqp.host:localhost}") String host,
                                                @Value("${amqp.port:5672}") int port,
                                                @Value("${amqp.host:guest}") String user,
                                                @Value("${amqp.host:guest}") String pass) {
        CachingConnectionFactory cf = new CachingConnectionFactory();
        cf.setHost(host);
        cf.setPort(port);
        cf.setUsername(user);
        cf.setPassword(pass);
        return cf;
    }

    @Bean
    RabbitTemplate rabbitTemplate(ConnectionFactory rabbitmqConnectionFactory) {
        RabbitTemplate template = new RabbitTemplate(rabbitmqConnectionFactory);
        return template;
    }
}
