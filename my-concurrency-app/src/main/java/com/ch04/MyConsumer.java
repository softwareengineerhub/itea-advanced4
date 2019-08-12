package com.ch04;

public class MyConsumer extends Thread {
    private Object monitor;
    private MyProducer producer;

    public MyConsumer(Object monitor, MyProducer producer) {
        this.monitor = monitor;
        this.producer = producer;
    }

    public void run(){
        while(true){

            synchronized (monitor){
                while(!producer.isProduced()){
                    try {
                        monitor.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                try {
                    Thread.sleep(3000);
                }catch(Exception ex){
                    ex.printStackTrace();
                }
                int value=producer.consume();
                System.out.println("\tConsumed: "+value+"; "+getName());

                monitor.notifyAll();

            }




        }
    }
}
