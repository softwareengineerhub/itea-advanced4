package com.ch07;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class DataProducer extends Thread {
    private Lock lock;
    private Condition condition;
    private Condition metaCondition;
    private int value;

    public DataProducer(Lock lock, Condition condition, Condition metaCondition) {
        this.lock = lock;
        this.condition = condition;
        this.metaCondition = metaCondition;
    }

    public void run(){
        System.out.println("Producer started!!!");
        try {
            Thread.sleep(3000);
            value++;
            System.out.println("Produced: "+value);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        try {
            lock.lock();

            System.out.println("Make notification!!!!!");
            //condition.signalAll();
            //metaCondition.signalAll();

            condition.signal();
        }finally{
            lock.unlock();
        }
    }

    public int getValue() {
        return value;
    }
}
