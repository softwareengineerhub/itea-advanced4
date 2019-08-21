package com.app.dao;

import com.app.model.Person;
import org.junit.*;

import java.util.List;

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

    @After
    public void afterTest(){
        dao.deleteAll();
        System.out.println("@After");
    }

    @AfterClass
    public static void afterClass(){
        System.out.println("@After class");
    }
}
