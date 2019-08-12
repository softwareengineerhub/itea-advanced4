package com.ch07;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class DataConsumer extends Thread {
    private Lock lock;
    private Condition condition;
    private DataProducer dataProducer;

    public DataConsumer(DataProducer dataProducer, Lock lock, Condition condition) {
        this.dataProducer = dataProducer;
        this.lock = lock;
        this.condition = condition;
    }

    public void run(){
        System.out.println("DataConsumer. START. "+getName());
        try {
             lock.lock();
             while(dataProducer.getValue()==0){
               condition.await();
             }
            System.out.println("DataConsumer. GOT NOTIFIED. "+getName());
            condition.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
