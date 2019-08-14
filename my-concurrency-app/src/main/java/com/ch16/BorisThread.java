package com.ch16;

//import java.util.function.Supplier;

import java.util.function.Supplier;

public class BorisThread extends Thread {
    private final ThreadLocal<CommonData2> threadLocal;
    CommonData2 commonData2;

    public BorisThread(CommonData2 commonData2){
         //ThreadLocal.withInitial(() -> 1);

        threadLocal = ThreadLocal.withInitial(new Supplier<CommonData2>() {

            public CommonData2 get() {
                return commonData2;
            }
        });
        //threadLocal = new InheritableThreadLocal<CommonData2>();
        //threadLocal.set(commonData2);
        this.commonData2 = commonData2;
    }

    /*public void run(){
        for(int i=0;i<10;i++){
            threadLocal.get().setValue(i);
            System.out.println("Boris: "+threadLocal.get().getValue());
        }
    }*/

    public void run(){
        for(int i=0;i<10;i++){
            commonData2.setValue(i);
            System.out.println("Boris: "+commonData2.getValue());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
