package com.ch08;

import java.util.concurrent.BlockingQueue;

public class SampleConsumer extends Thread {
    private BlockingQueue blockingQueue;

    public SampleConsumer(BlockingQueue blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    public void run(){
        while(true){
            Object data=blockingQueue.poll();
            System.out.println("\tConsumed: "+data);
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
