package com.app.main;

import com.app.dao.Dao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.service.UserServicw;

public class MainSpring {

    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationConfig.xml");
        //Object bean = ctx.getBean("dao");
        Dao dao = (Dao) ctx.getBean("dao");
        Dao dao1 = (Dao) ctx.getBean("dao");
        System.out.println(dao==dao1);
        System.out.println("------------------------");
        Dao dao3 = (Dao) ctx.getBean("dao3");
        Dao dao3Second = (Dao) ctx.getBean("dao3");
        System.out.println("------------------------");
        UserServicw userService = (UserServicw) ctx.getBean("userService");
        userService.createUser("U1", 25);
        System.out.println(userService.findAllUsers());
    }
}
