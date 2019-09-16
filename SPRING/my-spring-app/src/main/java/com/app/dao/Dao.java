package com.app.dao;

import com.app.model.User;

import java.util.List;

public interface Dao {

    public void add(User user);

    public void delete(int age);

    public List<User> getAll();

}
