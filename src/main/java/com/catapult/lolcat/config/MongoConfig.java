package com.catapult.lolcat.config;

import com.mongodb.MongoClientURI;
import com.mongodb.MongoCredential;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoClientFactoryBean;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;

import java.net.UnknownHostException;

@Configuration
public class MongoConfig {

    @Bean
    MongoDbFactory mongoDbFactory(@Value("${mongo.host:localhost}") String host,
                                  @Value("${mongo.port:27017}") int port,
                                  @Value("${mongo.user:guest}") String user,
                                  @Value("${mongo.pass:guest}") String pass) throws UnknownHostException {
        MongoClientURI uri = new MongoClientURI(String.format("mongodb://%s:%s@%s:%d/cat", user, pass, host, port));
        SimpleMongoDbFactory f = new SimpleMongoDbFactory(uri);
        return f;
    }

    @Bean
    MongoTemplate mongoTemplate(MongoDbFactory mongoDbFactory) {
        return new MongoTemplate(mongoDbFactory);
    }
}
