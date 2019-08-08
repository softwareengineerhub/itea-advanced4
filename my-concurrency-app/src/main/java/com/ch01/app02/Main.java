package com.ch01.app02;

import java.io.Serializable;

public class Main {

    public static void main(String[] args) {
        Runnable r = new MyRunnable();
        //Serializable s = new MyRunnable();


        Thread t1 = new Thread(r);
        t1.start();

        Thread t2 = new Thread(r);
        t2.start();


    }

}
