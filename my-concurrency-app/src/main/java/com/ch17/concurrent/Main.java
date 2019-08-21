package com.ch17.concurrent;

import java.util.concurrent.atomic.AtomicInteger;

public class Main {

    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger();
        AtomicChangeMaker changeMaker = new AtomicChangeMaker(atomicInteger);
        AtomicChangeListener changeListener = new AtomicChangeListener(atomicInteger);
        changeListener.start();
        changeMaker.start();
    }
}
