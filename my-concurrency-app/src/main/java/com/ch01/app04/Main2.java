package com.ch01.app04;

public class Main2 {

    public static void main(String[] args) {
        ThreadGroup tg = new ThreadGroup("G1");


        Thread t1 = new MyPriorityThread();
        //	Thread t2 = new MyPriorityThread();
        //Thread t3 = new MyPriorityThread();

        t1.setName("T1");
        //t1.setDaemon(true);
        //t2.setName("T2");
        //t3.setName("T3");

        Thread t = new Thread(tg, t1);
        //t.setDaemon(true);
        tg.setDaemon(true);
        //Thread t = new Thread(t1);
        t.start();

    }

}
