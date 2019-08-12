package com.ch04;

public class MyProducer extends Thread {
    private Object monitor;
    private boolean produced;
    private int value;

    public MyProducer(Object monitor) {
        this.monitor = monitor;
    }

    public void run(){
        while(true){

            synchronized (monitor){
                while(produced){
                    try {
                        monitor.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                value++;
                produced=true;
                System.out.println("Produced: "+value);
                monitor.notifyAll();
            }


        }
    }


    public boolean isProduced(){
        return produced;
    }

    public int consume(){
        produced=false;
        return value;
    }

}
