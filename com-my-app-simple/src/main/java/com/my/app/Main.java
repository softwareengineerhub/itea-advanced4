package com.my.app;

import org.domain.model.Person;

public class Main {

    public static void main(String[] args) {
        System.out.println("Main");
        Person person = new Person();

        MyProcessor myProcessor1 = new MyProcessor();
        MyProcessor myProcessor2 = new MyProcessor();



    }
}
