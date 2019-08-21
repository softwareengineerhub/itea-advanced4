package com.ch15;

public class CommonData {
    private volatile int value;
    //private int value;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
