package com.ch01.app01;

public class Main {

    public static void main(String[] args) {

        Processor p1 = new Processor();
        Processor p2 = new Processor();

        //p1.doAction(10);
        //p2.doAction(5);


        MyThread t1 = new MyThread(p1, 10);
        Thread t2 = new MyThread(p2, 5);

        //t1.run();
        //t2.run();

        t1.start();
        t2.start();

        //	t1.start();

    }

}
