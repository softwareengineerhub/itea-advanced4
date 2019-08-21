package com.ch12;

import java.util.concurrent.Callable;

public class MyCallableWithResult implements Callable {

    public Object call() throws Exception {
        try {
            System.out.println("MyCallableWithResult.call(). START");
            Thread.sleep(5000);
            System.out.println("MyCallableWithResult.call(). Finish");
            return "SUCCESS";
        }catch(Exception ex){
            throw new RuntimeException(ex);
        }
    }
}
