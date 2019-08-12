package com.ch09;

import java.util.concurrent.CountDownLatch;

public class MyExampleThread extends Thread {
    private CountDownLatch countDownLatch;

    public MyExampleThread(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }

    public void run(){
        while(true) {
            try {
                Thread.sleep(3000);
                System.out.println("do some action");
                countDownLatch.countDown();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
