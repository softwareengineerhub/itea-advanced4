package com.ch13;

import java.util.concurrent.Semaphore;

public class PassengerB extends Thread {
    private Semaphore semaphore;

    public PassengerB(Semaphore semaphore) {
        this.semaphore = semaphore;
    }

    public void run(){
        while(true){
            try {
                semaphore.acquire();
                System.out.println("B inside; "+semaphore.availablePermits());
                Thread.sleep(3000);
                System.out.println("\tB before out; "+semaphore.availablePermits());
                semaphore.release();
            }catch(Exception ex){
                ex.printStackTrace();
            }

        }
    }
}
