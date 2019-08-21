package com.app.dao;

import com.app.model.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class InmemoryDaoImpl implements Dao {

    private List<Person> persons = new ArrayList<Person>();


    public void save(Person person) {
        persons.add(person);
    }

    public List<Person> readAll() {
        return persons;
    }

    public List<Person> readAllByName(String name) {
        List<Person> res = new ArrayList();
        for(Person p: persons){
            if(name.equalsIgnoreCase(p.getName())){
                res.add(p);
            }
        }
        return res;
    }

    public List<Person> readAllByAge(int age) {
        List<Person> res = new ArrayList();
        for(Person p: persons){
            if(age==p.getAge()){
                res.add(p);
            }
        }
        return res;
    }

    public void update(String name, Person candidate) {

        for(Person p: persons){
            if(name.equalsIgnoreCase(p.getName())){
                p.setName(candidate.getName());
                p.setAge(candidate.getAge());
            }
        }

    }

    public void deleteAll() {
        persons.clear();
    }

    public void deleteAllByName(String name) {
        for(Person p: persons){
            if(name.equalsIgnoreCase(p.getName())){
                persons.remove(p);
            }
        }
    }

    public void deleteAllByAge(int age) {
        for(Person p: persons){
            if(age==p.getAge()){
                persons.remove(p);
            }
        }
    }

    public void deleteAllByAgeAndName(int age, String name) {
        for(Person p: persons){
            if(age==p.getAge() && name.equalsIgnoreCase(p.getName())){
                persons.remove(p);
            }
        }
    }

    @Override
    public void multipleSave(List<Person> persons) {

    }

    @Override
    public List<Map<String, Object>> readAllByMetaData() {
        return null;
    }
}
