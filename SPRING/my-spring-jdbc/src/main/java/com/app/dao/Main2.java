package com.app.dao;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main2 {

    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        DataProcessor dataProcessor = ctx.getBean(DataProcessor.class);
        dataProcessor.processData("msg2");
    }
}
