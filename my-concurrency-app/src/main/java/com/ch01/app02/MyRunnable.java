package com.ch01.app02;

import java.io.Serializable;

public class MyRunnable implements Runnable, Serializable {


    //@Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(i + ";" + Thread.currentThread());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
