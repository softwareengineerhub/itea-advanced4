package com.ch14;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class Philosopher extends Thread {
    private String professorName;
    private Semaphore leftFork;
    private Semaphore rightFork;
    //private Random random = new Random();


    public Philosopher(String professorName, Semaphore leftFork, Semaphore rightFork) {
        this.professorName=professorName;
        this.leftFork = leftFork;
        this.rightFork = rightFork;
    }

    public void run(){
        while(true){

            try {
                leftFork.acquire();
                rightFork.acquire();
                System.out.println(professorName +" is eating");
                Thread.sleep(3000);
                rightFork.release();
                leftFork.release();
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
