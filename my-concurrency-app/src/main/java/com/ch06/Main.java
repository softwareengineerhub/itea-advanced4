package com.ch06;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        BadIncrement2 increment2 = new BadIncrement2();
        MyDecrmentThread myDecrmentThread = new MyDecrmentThread(increment2);
        MyIncrementThread myIncrementThread = new MyIncrementThread(increment2);

        myDecrmentThread.start();
        myIncrementThread.start();

        myDecrmentThread.join();
        myIncrementThread.join();

        System.out.println(increment2.getValue());

    }
}
