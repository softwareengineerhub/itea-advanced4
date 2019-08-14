package com.ch12.sum;

import java.util.concurrent.Callable;

public class SumAggregationTask  implements Callable<Integer> {
    private int[] data;
    private int start;
    private int end;

    public SumAggregationTask(int[] data, int start, int end) {
        this.data = data;
        this.start = start;
        this.end = end;
    }

    public Integer call() {
        System.out.println("call(); "+Thread.currentThread().getName());
        int sum = 0;
        for(int i=start;i<end;i++){
            sum+=data[i];
            delay(1000);
        }
        return sum;
    }

    private void delay(long period){
        long start = System.currentTimeMillis();
        while(System.currentTimeMillis()-start<period){

        }
    }
}
