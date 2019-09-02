package com.app;

public class Main {

    public static void main(String[] args) {
        Person p = new Person();
        p.setAge(1);
        p.setName("Name1");
        JsonProcessor jsonProcessor = new JsonProcessor();
        String json = jsonProcessor.toJSON2(p);
        System.out.println(json);
        p = jsonProcessor.fromJSON2(json);
        System.out.println(p);
    }
}
