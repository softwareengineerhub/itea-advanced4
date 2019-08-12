package com.ch08;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;

public class BlockingQueueExample {

    public static void main(String[] args) {
        //BlockingQueue bq = new ArrayBlockingQueue(5);
        BlockingQueue bq = new SynchronousQueue();

        SampleProducer sp = new SampleProducer(bq);
        SampleConsumer sq = new SampleConsumer(bq);

        sp.start();
        sq.start();

    }
}
