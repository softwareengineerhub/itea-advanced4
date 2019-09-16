package com.config;

import com.app.dao.Dao;
import com.app.dao.DaoImpl4;
import com.service.UserServiceImpl;
import com.service.UserServiceImpl2;
import com.service.UserServicw;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConfig {


    @Bean
    public Dao getDao(){
        return new DaoImpl4();
    }

    public UserServicw getUserServicw(){

        Dao dao = getDao();
        UserServiceImpl userServicw = new UserServiceImpl();

        userServicw.setDao(dao);

        return userServicw;
    }

}
