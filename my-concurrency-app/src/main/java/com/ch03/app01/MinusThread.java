package com.ch03.app01;

public class MinusThread extends Thread {
    private BadIncrement badIncrement;

    public MinusThread(BadIncrement badIncrement) {
        this.badIncrement = badIncrement;
    }

    @Override
    public void run() {
        for (int i = 0; i < 1000000; i++) {
            badIncrement.decrement();
        }
    }


}
