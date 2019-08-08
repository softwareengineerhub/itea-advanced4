package com.ch03.app01;

public class Main {


    public static void main(String[] args) throws Exception {
        BadIncrement bi = new BadIncrement();
        Thread minusT = new MinusThread(bi);
        Thread plusT = new PlusThread(bi);

        minusT.start();
        plusT.start();

        minusT.join();
        plusT.join();

        System.out.println(bi.getValue());
    }
}
