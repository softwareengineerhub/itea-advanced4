package com.ch10;

import java.util.concurrent.CyclicBarrier;

public class MyBarrierThreadA extends  Thread {

    private CyclicBarrier cyclicBarrier;

    public MyBarrierThreadA(CyclicBarrier cyclicBarrier) {
        this.cyclicBarrier = cyclicBarrier;
    }

    public void run(){
        System.out.println("A. STARTED");
        try {
            Thread.sleep(4000);
            System.out.println("A. after sleep");
            cyclicBarrier.await();
            System.out.println("A. FINISHED");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
