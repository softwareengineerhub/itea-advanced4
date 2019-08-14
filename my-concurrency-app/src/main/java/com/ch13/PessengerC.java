package com.ch13;

import java.util.concurrent.Semaphore;

public class PessengerC  extends Thread {

    private Semaphore semaphore;

    public PessengerC(Semaphore semaphore) {
        this.semaphore = semaphore;
    }

    public void run(){
        while(true){
            try {
                semaphore.acquire();
                System.out.println("C inside; "+semaphore.availablePermits());
                Thread.sleep(3000);
                System.out.println("\tC before out; "+semaphore.availablePermits());
                semaphore.release();
            }catch(Exception ex){
                ex.printStackTrace();
            }

        }
    }
}
