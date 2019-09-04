package com.app3;

import com.app.Person;

public class Main {

    public static void main(String[] args) {
        MyStack<Person> myStack = new MyStack();
        //myStack.push("a");
        //myStack.push(1);
        myStack.push(new Person());
        System.out.println(myStack.size());

        MyStack m = new MyStack();
        m.push("sadas");
    }
}
