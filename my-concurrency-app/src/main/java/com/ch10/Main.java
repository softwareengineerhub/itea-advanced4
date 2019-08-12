package com.ch10;

import java.util.concurrent.CyclicBarrier;

public class Main {

    public static void main(String[] args) {
        Runnable r = new CommonTask();
        CyclicBarrier barrier = new CyclicBarrier(2, r);

        MyBarrierThreadA threadA = new MyBarrierThreadA(barrier);
        MyBarrierThreadB threadB = new MyBarrierThreadB(barrier);

        threadA.start();
        threadB.start();
    }
}
