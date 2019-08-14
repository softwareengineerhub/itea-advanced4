package com.ch16;

import java.util.function.Supplier;

public class DenisThread extends Thread{

    private CommonData2 commonData2;
    private ThreadLocal<CommonData2> threadLocal;

    public DenisThread(CommonData2 commonData2){
        threadLocal = ThreadLocal.withInitial(new Supplier<CommonData2>() {

            public CommonData2 get() {
                return commonData2;
            }
        });
        threadLocal.set(commonData2);
        this.commonData2 = commonData2;
    }

    /*public void run(){
        for(int i=-10;i<0;i++){
            threadLocal.get().setValue(i);
            System.out.println("Denis: "+threadLocal.get().getValue());
        }
    }*/

    public void run(){
        for(int i=-10;i<0;i++){
            commonData2.setValue(i);
            System.out.println("Denis: "+commonData2.getValue());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


}
