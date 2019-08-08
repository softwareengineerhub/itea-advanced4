package com.ch01.app01;

public class MyThread extends Thread {
    private Processor processor;
    private int n;

    public MyThread(Processor processor, int n) {
        this.processor = processor;
        this.n = n;
    }

    public void run() {
        System.out.println("------STARTED-----------" + getName());
        processor.doAction(n);
        System.out.println("------FINISHED-----------" + getName());
    }

}
