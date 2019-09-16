package com.app.main;

import com.config.MyConfig;
import com.service.UserServicw;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainSpringJavaConfig {

    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(MyConfig.class);
        UserServicw userServicw = ctx.getBean(UserServicw.class);
        userServicw.findAllUsers();
    }
}
