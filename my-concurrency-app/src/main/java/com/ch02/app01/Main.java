package com.ch02.app01;

import java.util.Timer;

public class Main {

    public static void main(String[] args) {
        Timer timer = new Timer();

        MyTimerTask t1 = new MyTimerTask("T1");
        MyTimerTask t2 = new MyTimerTask("T2");

        //timer.schedule(t1, 1000);
        //	timer.schedule(t2, 1000);
        timer.scheduleAtFixedRate(t1, 1, 3000);
        timer.scheduleAtFixedRate(t2, 1, 1500);

        long start = System.currentTimeMillis();
        while (System.currentTimeMillis() - start < 10000) {

        }
        t1.cancel();

        //timer.cancel();

    }

}
