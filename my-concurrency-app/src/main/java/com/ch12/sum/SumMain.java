package com.ch12.sum;

public class SumMain {

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        int[] data = {1,2,3,4,5,6,7,8,9,10};
        SumBusinessProcessor processor = new SumBusinessProcessor();
        int sum = processor.sum(data);
        System.out.println("-------SUM-------");
        System.out.println(sum);
        System.out.println("time: "+(System.currentTimeMillis()-start));
    }
}
