package com.ch01.app03;

public class MyDemonThread extends Thread {

    public MyDemonThread() {
        setDaemon(true);
    }


    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {

                e.printStackTrace();
            }

        }
    }
}
