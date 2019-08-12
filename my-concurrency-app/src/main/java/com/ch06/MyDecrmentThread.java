package com.ch06;

public class MyDecrmentThread extends Thread {

    private BadIncrement2 badIncrement2;

    public MyDecrmentThread(BadIncrement2 badIncrement2) {
        this.badIncrement2 = badIncrement2;
    }

    public void run(){
        for(int i=0;i<1000000;i++){
            badIncrement2.decrement();
        }
    }
}
