package com.app.model;

public class Person {

    private String name;
    private int age;

    public Person() {
        System.out.println("Person()");
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void doAction(){
        System.out.println("doAction():"+"name="+name+"; age="+age);
    }

    public void doAction(String message){
        System.out.println("doAction():"+message+"name="+name+"; age="+age);
    }


    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
