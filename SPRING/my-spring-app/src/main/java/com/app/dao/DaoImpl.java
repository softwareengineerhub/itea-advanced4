package com.app.dao;

import com.app.model.User;

import java.util.ArrayList;
import java.util.List;

public class DaoImpl implements  Dao {
    private List<User> users = new ArrayList<User>();

    public void init(){
        System.out.println("init()");
    }

    public void add(User user) {
        users.add(user);
    }

    public void delete(int age) {

    }

    public List<User> getAll() {
        return users;
    }
}
