package com.ch10;

import java.util.concurrent.CyclicBarrier;

public class MyBarrierThreadB extends Thread {
    private CyclicBarrier cyclicBarrier;

    public MyBarrierThreadB(CyclicBarrier cyclicBarrier) {
        this.cyclicBarrier = cyclicBarrier;
    }

    public void run(){
        System.out.println("B. STARTED");
        try {
            Thread.sleep(1000);
            System.out.println("B. after sleep");
            cyclicBarrier.await();
            System.out.println("B. FINISHED");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
