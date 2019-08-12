package com.ch05;

public class MyStore extends Thread  {

    private MyMonitor value;

    public MyStore(MyMonitor value) {
        this.value = value;
    }

    public void run(){

            try {
                System.out.println("\t------START STORE-------------");
                synchronized (value) {
                    while (value.getValue() == 0) {
                        value.wait();
                    }
                }
                System.out.println("\tSTORE:" + value);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }


}
