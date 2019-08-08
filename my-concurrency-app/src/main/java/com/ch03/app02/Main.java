package com.ch03.app02;

public class Main {

    public static void main(String[] args) {
        String nameA = "A";
        String nameB = "B";

        Thread t1 = new Thread1(nameA, nameB);
        Thread t2 = new Thread2(nameA, nameB);

        t1.start();
        t2.start();


    }

}
