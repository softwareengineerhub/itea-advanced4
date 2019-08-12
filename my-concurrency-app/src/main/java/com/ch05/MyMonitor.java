package com.ch05;

public class MyMonitor {
    private int value;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "MyMonitor{" +
                "value=" + value +
                '}';
    }
}
