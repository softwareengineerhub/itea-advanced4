package com.ch08;

import java.util.concurrent.BlockingQueue;

public class SampleProducer extends Thread {

    private BlockingQueue blockingQueue;
    private int value;

    public SampleProducer(BlockingQueue blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    public void run(){
        while(true){
            value++;
            System.out.println("Produced: "+value+"; "+blockingQueue);
            try {
                blockingQueue.put(value);
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
