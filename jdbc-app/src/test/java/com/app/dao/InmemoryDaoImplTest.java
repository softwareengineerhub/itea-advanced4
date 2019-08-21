package com.app.dao;

import com.app.model.Person;
import org.junit.Test;
//import org.junit.Assert;

import static org.junit.Assert.*;

import java.util.List;

public class InmemoryDaoImplTest {

    private Dao dao = new InmemoryDaoImpl();

    @Test
    public void saveTest(){
        Person p = new Person();
        p.setAge(1);
        p.setName("Name1");
        dao.save(p);
        List<Person> persons =  dao.readAll();
        assertTrue(persons.size()==1);

        /*assert 1<2 : "message";
        if(persons.size()!=1){
           throw new AssertionError("message");
        }*/

    }

    @Test(expected = NullPointerException.class)
    public void simpleTest(){

    }
}
