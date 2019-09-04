package com.app;

public class Main {

    public static void main(String[] args) {
        Object[] data = new Object[10];
        data[0] = "asdad";
        data[1] = null;
        data[2] = new Person();

        Person[] persons = new Person[10];
        persons[0] = new Person();

        countSum(data);

        countSum(persons);
    }


    private static int countSum(Object[] data){
        return 1;
    }
}
