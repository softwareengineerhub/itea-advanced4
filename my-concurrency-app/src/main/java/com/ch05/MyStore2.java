package com.ch05;

public class MyStore2 extends Thread {
    private MyMonitor value;

    public MyStore2(MyMonitor value) {
        this.value = value;
    }

    public void run() {

            try {
                System.out.println("\t------START STORE2-------------");
                synchronized (value) {
                    while (value.getValue() == 0) {
                        value.wait();
                    }
                }
                System.out.println("\tSTORE2:" + value);
            } catch (Exception ex) {
                ex.printStackTrace();
            }

    }
}
