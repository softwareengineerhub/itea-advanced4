package com.ch01.app01;

public class Processor {

    public void doAction(int n) {
        for (int i = 0; i < n; i++) {
            System.out.println("Processor " + i);
            delay(1000);
        }
    }

    private void delay(long delay) {
        long start = System.currentTimeMillis();
        while (System.currentTimeMillis() - start <= delay) {

        }
    }

}
