package com.catapult.lolcat;

import com.catapult.lolcat.config.AMQPConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

@EnableAutoConfiguration
@ComponentScan({"com.catapult.lolcat.web","com.catapult.lolcat.service","com.catapult.lolcat.component"})
@Import(AMQPConfig.class)
public class LolCatApplication {


    public static void main(String[] args) throws Exception {
        SpringApplication.run(LolCatApplication.class, args);
    }
}