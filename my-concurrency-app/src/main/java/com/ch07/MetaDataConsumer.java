package com.ch07;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class MetaDataConsumer extends Thread {

    private Lock lock;
    private Condition condition;
    private DataProducer dataProducer;

    public MetaDataConsumer(DataProducer dataProducer, Lock lock, Condition condition) {
        this.dataProducer = dataProducer;
        this.lock = lock;
        this.condition = condition;
    }

    public void run(){
        System.out.println("MetaDataConsumer. START. "+getName());
        try {
            lock.lock();
            while(dataProducer.getValue()==0){
                condition.await();
            }
            System.out.println("MetaDataConsumer. ###GOT NOTIFIED###. "+getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
