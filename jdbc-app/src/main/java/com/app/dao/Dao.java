package com.app.dao;

import com.app.model.Person;

import java.util.List;
import java.util.Map;

//CRUD
/*
C- create
R- read
U- update
D- delte
 */
public interface Dao {

    public void save(Person person);

    public List<Person> readAll();

    public List<Person> readAllByName(String name);

    public List<Person> readAllByAge(int age);

    public void update(String name, Person candidate);

    public void deleteAll();

    public void deleteAllByName(String name);

    public void deleteAllByAge(int age);

    public void deleteAllByAgeAndName(int age, String name);

    public void multipleSave(List<Person> persons);

    public List<Map<String, Object>> readAllByMetaData();

}
