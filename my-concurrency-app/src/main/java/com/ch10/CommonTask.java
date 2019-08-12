package com.ch10;

public class CommonTask implements Runnable {

    public void run() {
        System.out.println("$$$$$$$$$$$ All are finished $$$$$$$$$$$$$$$$$$$$");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
