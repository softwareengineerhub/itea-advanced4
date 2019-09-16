package com.app.processor;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String[] args) {
        //ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        ApplicationContext ctx = new ClassPathXmlApplicationContext("appConfig.xml");
        MessageProcessor messageProcessor = ctx.getBean(MessageProcessor.class);
        String result = messageProcessor.processMessage("Denis");
        System.out.println(result);
    }
}
