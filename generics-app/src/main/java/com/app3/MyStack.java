package com.app3;

import java.util.Arrays;

public class MyStack <T> {
    private Object[] data;
    private int capacity = 10;
    private int n;

    public MyStack() {
        data =  new Object[capacity];
    }

    public boolean isEmpty(){
        return n==0;
    }

    public int size(){
        return n;
    }

    public void push(T item){
        if(n+1>data.length){
            data = Arrays.copyOf(data, data.length+capacity);
        }
        data[n] = item;
        n++;
    }

    public T peek(){

        return (T) data[n-1];
    }

    public T pock(){
        Object lastItem =  data[n-1];
        data[n-1]=null;
        n--;
        return (T) lastItem;
    }

}
