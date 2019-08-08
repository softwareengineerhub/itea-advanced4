package com.ch02.app01;

import java.util.TimerTask;

public class MyTimerTask extends TimerTask {
    private String message;

    public MyTimerTask(String message) {
        this.message = message;
    }

    @Override
    public void run() {
        System.out.println("I am working; " + message);
    }

}
