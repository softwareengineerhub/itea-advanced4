package com.ch17;

import java.util.concurrent.atomic.AtomicInteger;

public class Main {

    public static void main(String[] args) {
        AtomicInteger i = new AtomicInteger();
        int val = i.addAndGet(4);
        System.out.println(val);
        val=i.getAndAdd(5);
        System.out.println(val);
        val=i.get();
        System.out.println(val);
    }
}
