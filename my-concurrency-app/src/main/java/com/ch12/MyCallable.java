package com.ch12;

import java.util.concurrent.Callable;

public class MyCallable implements Callable {


    public Object call() {
        try {
            System.out.println("MyCallable.call(). START");
            Thread.sleep(5000);
            System.out.println("MyCallable.call(). Finish");
            return null;
        }catch(Exception ex){
            throw new RuntimeException(ex);
        }
    }
}
