package com.ch05;

public class MyFactory extends Thread {
    private MyMonitor value;

    public MyFactory(MyMonitor value) {
        this.value = value;
    }

    public void run(){
        System.out.println("------START MYFACTORY-------------");
        try {
            Thread.sleep(5000);
        }catch(Exception ex){
            ex.printStackTrace();
        }

        synchronized (value) {
            try {

                Thread.sleep(3000);
                System.out.println("MyFactory.make : DeviceA");
                value.setValue(1);
                Thread.sleep(1000);
                System.out.println("MyFactory.make notification");
                value.notifyAll();



            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
}
