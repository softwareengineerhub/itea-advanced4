package com.ch01.app05;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        long start = System.currentTimeMillis();
        int[] data = new int[100];
        for (int i = 0; i < data.length; i++) {
            data[i] = i;
        }


        CalculationThread[] array = new CalculationThread[10];
        int step = 10;
        for (int i = 0; i < array.length; i++) {
            array[i] = new CalculationThread(data, i * 10, i * step + step);
            array[i].start();
        }

        for (int i = 0; i < array.length; i++) {
            array[i].join();
        }

        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum += array[i].getSum();
        }

        System.out.println(System.currentTimeMillis() - start);
        System.out.println("Total sum: " + sum);

    }


    public static void mainOld(String[] args) throws InterruptedException {
        long start = System.currentTimeMillis();
        int[] data = new int[10];
        for (int i = 0; i < data.length; i++) {
            data[i] = i;
        }

        CalculationThread t1 = new CalculationThread(data, 0, data.length);
        //t1.join();
        t1.start();
        t1.run();


        System.out.println(System.currentTimeMillis() - start);
        System.out.println("Total sum: " + t1.getSum());

    }

}
