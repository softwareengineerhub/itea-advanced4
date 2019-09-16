package org.app;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;

import java.util.concurrent.Future;

@Component
public class Engine {

    @Async
    public void doWork(){
        System.out.println("-------doWork() START----");
        long start = System.currentTimeMillis();
        while(System.currentTimeMillis()-start<=15000){

        }
        System.out.println("-------doWork() FINISH----");
    }


    @Async
    public Future<String> doWork2(){
        System.out.println("-------doWork2() START----");
        long start = System.currentTimeMillis();
        while(System.currentTimeMillis()-start<=15000){

        }
        System.out.println("-------doWork2() FINISH----");
        return new AsyncResult<String>("work2Result");
    }
}
