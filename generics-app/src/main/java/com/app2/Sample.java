package com.app2;

import com.app.Person;

import java.util.ArrayList;
import java.util.List;

public class Sample {

    public void doAction(){

        List list = new ArrayList();
        list.add(new Person());
        helperMethod(list);
    }

    private void helperMethod(List list){
        for(Object item: list){
            Person p = (Person) item;
        }
    }
}
