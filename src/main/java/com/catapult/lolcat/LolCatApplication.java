package com.catapult.lolcat;

import com.catapult.lolcat.config.AMQPConfig;
import com.catapult.lolcat.config.MongoConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableWebMvc
@ComponentScan({"com.catapult.lolcat.web","com.catapult.lolcat.service","com.catapult.lolcat.component"})
@Import({AMQPConfig.class, MongoConfig.class})
public class LolCatApplication {


    public static void main(String[] args) throws Exception {
        SpringApplication.run(LolCatApplication.class, args);
    }
}