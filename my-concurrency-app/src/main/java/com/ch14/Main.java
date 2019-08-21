package com.ch14;

import java.util.concurrent.Semaphore;

public class Main {

    public static void main(String[] args) {
        Semaphore f1 = new Semaphore(1);
        Semaphore f2 = new Semaphore(1);
        Semaphore f3 = new Semaphore(1);
        Semaphore f4 = new Semaphore(1);
        Semaphore f5 = new Semaphore(1);

        Philosopher a = new Philosopher("A", f1, f5);
        Philosopher b = new Philosopher("B", f5, f2);
        Philosopher c = new Philosopher("C", f2, f3);
        Philosopher d = new Philosopher("D", f3, f4);
        Philosopher e = new Philosopher("E", f4, f1);

        a.start();
        b.start();
        c.start();
        d.start();
        e.start();
    }
}
