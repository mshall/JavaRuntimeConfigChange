package com.shall.plugin;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfiguration {
    @Bean
    public GreetProvider greetProvider(){
        return new GreetProvider();
    }
}
