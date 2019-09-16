package com.service;

import com.app.dao.Dao;
import com.app.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserServiceImpl2 implements UserServicw {
    @Autowired
    @Qualifier("daoImpl2")
    private Dao dao;

    public void createUser(String name, int age) {

    }

    public List<User> findAllUsers() {
        return dao.getAll();
    }

    public void deleteByAge(int age) {

    }
}
