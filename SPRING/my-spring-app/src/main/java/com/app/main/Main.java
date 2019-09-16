package com.app.main;

import com.app.dao.Dao;
import com.app.dao.DaoImpl;
import com.app.model.User;
import com.service.UserServiceImpl;
import com.service.UserServicw;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        Dao dao = new DaoImpl();
        UserServicw userService = new UserServiceImpl(dao);

        userService.createUser("U1", 31);

        List<User> users =  userService.findAllUsers();
        System.out.println(users);
    }

}
