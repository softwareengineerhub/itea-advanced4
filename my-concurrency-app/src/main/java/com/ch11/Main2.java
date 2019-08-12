package com.ch11;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Main2 {

    public static void main(String[] args) {

        int n=Runtime.getRuntime().availableProcessors();
        System.out.println(n);
        //ExecutorService executor = Executors.newFixedThreadPool(n);
        //ExecutorService executor = Executors.newSingleThreadExecutor();

        //ExecutorService executor = Executors.newCachedThreadPool();
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(10);

        Runnable ping = new Runnable() {
            public void run() {
                System.out.println("PING!!!! "+Thread.currentThread().getName());
            }
        };

        executor.scheduleAtFixedRate(ping, 2000, 1000, TimeUnit.MILLISECONDS);


        for(int i=0;i<1000;i++) {
            executor.execute(new Runnable() {

                public void run() {
                    System.out.println("Some job start" +Thread.currentThread().getName());
                    try {
                       // Thread.sleep(7000);
                    } catch (Exception e) {
                          e.printStackTrace();
                    }
                    System.out.println("Some job finish "+Thread.currentThread().getName());
                }
            });

        }

    }


}
