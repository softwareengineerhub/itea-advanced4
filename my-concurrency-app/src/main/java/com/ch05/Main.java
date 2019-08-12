package com.ch05;

public class Main {

    public static void main(String[] args) {
        MyMonitor value = new MyMonitor();
        MyFactory myFactory = new MyFactory(value);
        MyStore myStoreA = new MyStore(value);
        MyStore myStoreB = new MyStore(value);
       // MyStore2 myStore2 = new MyStore2(value);

        myFactory.start();
        myStoreA.start();
        myStoreB.start();
        //myStore2.start();

    }
}
