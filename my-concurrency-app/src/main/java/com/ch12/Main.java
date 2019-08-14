package com.ch12;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {

    public static void main(String[] args) throws Exception {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        MyCallable myCallable = new MyCallable();
        //executorService.submit(myCallable);

        MyCallableWithResult myCallableWithResult = new MyCallableWithResult();
        Future futureResult = executorService.submit(myCallableWithResult);
        System.out.println("After submit");
        while(!futureResult.isDone()) {

        }
        Object result = futureResult.get();
        System.out.println("After call get(); result=" + result);

    }

}
