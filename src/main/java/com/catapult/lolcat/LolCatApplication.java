package com.catapult.lolcat;

import com.catapult.lolcat.config.MQTTConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

@EnableAutoConfiguration
@ComponentScan({"com.catapult.lolcat.web","com.catapult.lolcat.service"})
@Import(MQTTConfig.class)
public class LolCatApplication {


    public static void main(String[] args) throws Exception {
        SpringApplication.run(LolCatApplication.class, args);
    }
}