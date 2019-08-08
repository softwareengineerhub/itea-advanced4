package com.ch01.app04;

public class MyPriorityThread extends Thread {

    public void run() {
        for (; ; ) {
            System.out.println(getName());
        }
    }

}
