package com.app2;

import com.app.Person;

import java.util.ArrayList;
import java.util.List;

public class Sample2 {

    public void doAction(){
        List<Person> list = new ArrayList();
        list.add(new Person());
        helper(list);
        System.out.println(list);
    }

    private void helper(List<? super Person> list){
        list.add(new Person());
        //list.add("");
        list.add(new ChildPerson());
    }

    private void helper2(List<? extends Person> list){
        //list.add(new Person());
        Person p = list.get(0);
        //ChildPerson cp = (ChildPerson) list.get(0);
    }
}
