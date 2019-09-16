package com.service;

import com.app.dao.Dao;
import com.app.model.User;

import java.util.List;

public class UserServiceImpl implements UserServicw {

    private Dao dao;

    public UserServiceImpl(Dao dao) {
        this.dao = dao;
    }

    public UserServiceImpl() {
    }

    public void createUser(String name, int age) {
        if(age>20) {
            User user = new User();
            user.setAge(age);
            user.setName(name);
            dao.add(user);
        }
    }

    public List<User> findAllUsers() {
        return dao.getAll();
    }

    public void deleteByAge(int age) {

    }

    public void setDao(Dao dao){
        this.dao=dao;
    }
}
