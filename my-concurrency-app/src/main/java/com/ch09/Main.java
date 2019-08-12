package com.ch09;

import java.util.concurrent.CountDownLatch;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(5);

        MyExampleThread myExampleThread = new MyExampleThread(countDownLatch);
        myExampleThread.setDaemon(true);
        myExampleThread.start();


        countDownLatch.await();
        System.out.println("---------Main finished-------");

    }
}
