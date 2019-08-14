package com.ch13;

import java.util.concurrent.Semaphore;

public class Main {

    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(2);
        PassengerA a = new PassengerA(semaphore);
        PassengerB b = new PassengerB(semaphore);
        PessengerC c = new PessengerC(semaphore);
        a.start();
        b.start();
        c.start();
    }
}
