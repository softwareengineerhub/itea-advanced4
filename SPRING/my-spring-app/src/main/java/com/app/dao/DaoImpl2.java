package com.app.dao;

import com.app.model.User;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

//@Component
//@Service
//@Repository
@Component
//@Scope(value = "prototype")
//@Scope(value = "prototype")
public class DaoImpl2 implements  Dao {

    @PostConstruct
    public void init(){
        System.out.println();
    }

    public void add(User user) {

    }

    public void delete(int age) {

    }

    public List<User> getAll() {
        return null;
    }
}
