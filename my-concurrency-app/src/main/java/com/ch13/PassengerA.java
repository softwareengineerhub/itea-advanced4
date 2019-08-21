package com.ch13;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class PassengerA extends Thread {
    private Semaphore semaphore;
    Random random = new Random();

    public PassengerA(Semaphore semaphore) {
        this.semaphore = semaphore;
    }

    public void run(){
        while(true){
            try {
                semaphore.acquire();
                System.out.println("A inside; "+semaphore.availablePermits());
                Thread.sleep(3000);
                System.out.println("\tA before out; "+semaphore.availablePermits());
                semaphore.release();
                Thread.sleep(Math.abs(random.nextInt()*1000));
            }catch(Exception ex){
                ex.printStackTrace();
            }

        }
    }
}
