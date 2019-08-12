package com.ch06;

public class MyIncrementThread extends Thread {
    private BadIncrement2 badIncrement2;

    public MyIncrementThread(BadIncrement2 badIncrement2) {
        this.badIncrement2 = badIncrement2;
    }

    public void run(){
        for(int i=0;i<1000000;i++){
            badIncrement2.increment();
        }
    }
}
