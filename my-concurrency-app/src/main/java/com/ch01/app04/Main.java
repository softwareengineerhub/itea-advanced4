package com.ch01.app04;

public class Main {

    public static void main(String... args) {
        Thread t1 = new MyPriorityThread();
        Thread t2 = new MyPriorityThread();
        Thread t3 = new MyPriorityThread();

        t1.setName("T1");
        t2.setName("T2");
        t3.setName("T3");

        t1.setPriority(1);
        t2.setPriority(Thread.NORM_PRIORITY);
        t3.setPriority(Thread.MAX_PRIORITY);

        t1.start();
        t2.start();
        t3.start();
    }

}
