package com.service;

import com.app.model.User;

import java.util.List;

public interface UserServicw {

    public void createUser(String name, int age);

    public List<User> findAllUsers();

    public void deleteByAge(int age);


}
