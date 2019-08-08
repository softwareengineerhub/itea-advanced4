package com.ch01.app03;

public class Main {


    public static void main(String[] args) throws Exception {
        Thread t = new MyDemonThread();
        //t.setDaemon(true);
        t.setName("denis thread");
        t.start();

        Thread.sleep(3000);
        System.out.println("-------MAIN FINISH---------");

    }
}
