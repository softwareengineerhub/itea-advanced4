package com.ch11;

import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(5);


        executor.execute(new Runnable() {

            public void run() {
                System.out.println("Some job start");
                try {
                    Thread.sleep(7000);
                } catch (InterruptedException e) {
                  //  e.printStackTrace();
                }
                System.out.println("Some job finish");
            }
        });

       // executor.shutdown();
        List<Runnable> tasks =  executor.shutdownNow();
        System.out.println(tasks);
        for(Runnable item: tasks){
            System.out.println(item);
        }


        /*executor.execute(new Runnable() {

            public void run() {
                System.out.println("Another job start");
                try {
                    Thread.sleep(7000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Another job finish");
            }
        });*/


    }
}
