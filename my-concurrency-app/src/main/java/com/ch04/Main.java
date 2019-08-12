package com.ch04;

public class Main {

    public static void main(String[] args) {
        Object monitor = new Object();
        MyProducer producer = new MyProducer(monitor);
        MyConsumer consumer = new MyConsumer(monitor, producer);
        MyConsumer consumer2 = new MyConsumer(monitor, producer);

        producer.start();
        consumer.start();
        consumer2.start();
    }

}
