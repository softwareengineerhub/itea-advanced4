package com.app.dao;

import com.app.model.Person;
import org.junit.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class DaoImplTest {

    private Dao dao = new DaoImpl();

    @BeforeClass
    public static void beforeClass(){
        System.out.println("@Before class");
    }

    @Before
    public void beforeTest(){
        System.out.println("@Before");
        dao.deleteAll();

    }

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

    @Test
    public void updateTest(){
        Person p = new Person();
        p.setAge(1);
        p.setName("Name1");
        dao.save(p);

        p = new Person();
        p.setAge(2);
        p.setName("Name2");
        dao.save(p);

        Person candidate = new Person();
        candidate.setAge(45);
        candidate.setName("Piter");
        dao.update("Name1", candidate);

        List<Person> persons = dao.readAllByName("Piter");
        assertTrue(persons.size()==1);
        Person  current = persons.get(0);
        assertTrue(current.getAge()==45);
        assertEquals("Piter", current.getName());
    }

    @Test
    public void multipleTest(){
        List<Person> persons = new ArrayList<>();
        Person p = new Person();
        p.setAge(1);
        p.setName("Name1");
        persons.add(p);

        p = new Person();
        p.setAge(2);
        p.setName("Name2");
        persons.add(p);

        p = new Person();
        p.setAge(3);
        p.setName("Name3");
        persons.add(p);

        dao.multipleSave(persons);
    }

    @Test
    public void readAllByMetaDataTest(){
        List<Person> persons = new ArrayList<>();
        Person p = new Person();
        p.setAge(1);
        p.setName("Name1");
        persons.add(p);

        p = new Person();
        p.setAge(2);
        p.setName("Name2");
        persons.add(p);

        p = new Person();
        p.setAge(3);
        p.setName("Name3");
        persons.add(p);

        dao.multipleSave(persons);

        List<Map<String, Object>> res = dao.readAllByMetaData();
        assertTrue(res.size()==3);

    }



    @After
    public void afterTest(){
        //dao.deleteAll();
        System.out.println("@After");
    }

    @AfterClass
    public static void afterClass(){
        System.out.println("@After class");
    }
}
