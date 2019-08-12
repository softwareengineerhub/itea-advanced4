package com.ch07;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Main {

    public static void main(String[] args) {
        Lock lock = new ReentrantLock();
        Condition condition = lock.newCondition();
        Condition conditionForMeta = lock.newCondition();

        DataProducer dp = new DataProducer(lock, condition, conditionForMeta);

        DataConsumer dc1 = new DataConsumer(dp, lock, condition);
        DataConsumer dc2 = new DataConsumer(dp, lock, condition);

        MetaDataConsumer mdc1 = new MetaDataConsumer(dp, lock, conditionForMeta);
        MetaDataConsumer mdc2 = new MetaDataConsumer(dp, lock, conditionForMeta);

        dc1.start();
        dc2.start();

        mdc1.start();
        mdc2.start();

        dp.start();

    }
}
