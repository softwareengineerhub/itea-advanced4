package com.ch17.concurrent;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicChangeMaker extends Thread {

    private AtomicInteger data;

    public AtomicChangeMaker(AtomicInteger data) {
        this.data = data;
    }

    public void run(){
        int localVal = data.get();
        while(localVal<10){
            localVal = data.incrementAndGet();
            //int currentRes = data.getAndIncrement();
            System.out.println("Made: "+localVal);
            try {
                Thread.sleep(3000);
            }catch(Exception ex){
                ex.printStackTrace();
            }
        }
        System.out.println("ChangeMaker finish");
    }
}
