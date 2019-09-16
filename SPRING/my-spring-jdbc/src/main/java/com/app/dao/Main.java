package com.app.dao;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        Dao dao = ctx.getBean("daoImpl", Dao.class);
        dao.save("MsgA");

        dao = ctx.getBean("daoImpl2", Dao.class);
        List<String> allMessages =  dao.readAllMessages();
        System.out.println(allMessages);
    }
}
