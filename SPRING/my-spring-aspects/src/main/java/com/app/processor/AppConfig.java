package com.app.processor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com")
public class AppConfig {

    @Bean
    public MessageProcessor messageProcessor(){
        return new MessageProcessor();
    }


    @Bean
    public MyInterceptor interceptor(){
        return new MyInterceptor();
    }

}
