package com.ch03.app01;

public class PlusThread extends Thread {

    private BadIncrement badIncrement;

    public PlusThread(BadIncrement badIncrement) {
        this.badIncrement = badIncrement;
    }


    public void run() {
        for (int i = 0; i < 1000000; i++) {
            badIncrement.increment();
        }
    }


}
