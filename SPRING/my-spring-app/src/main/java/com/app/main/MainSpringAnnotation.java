package com.app.main;

import com.app.dao.DaoImpl2;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.service.UserServicw;

public class MainSpringAnnotation {

    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("annotationConfig.xml");
        ctx.getBean(DaoImpl2.class);
        UserServicw userServicw = ctx.getBean(UserServicw.class);
        userServicw.findAllUsers();
    }
}
