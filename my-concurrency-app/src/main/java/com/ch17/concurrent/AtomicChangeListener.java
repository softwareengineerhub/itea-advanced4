package com.ch17.concurrent;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicChangeListener extends Thread {
    private AtomicInteger data;

    public AtomicChangeListener(AtomicInteger data) {
        this.data = data;
    }

    public void run(){
        int localVal = data.get();
        while(localVal<10){
            if(localVal!=data.get()){
                localVal = data.get();
                System.out.println("Change detected "+localVal);
            }
        }
        System.out.println("ChangeListener finish");
    }
}
