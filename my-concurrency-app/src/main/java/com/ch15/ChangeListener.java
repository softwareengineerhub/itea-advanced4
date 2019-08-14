package com.ch15;

public class ChangeListener extends Thread {
    private CommonData commonData;

    public ChangeListener(CommonData commonData) {
        this.commonData = commonData;
    }

    public void run(){
        int localValue = commonData.getValue();
        while(localValue<10){
            if(localValue!=commonData.getValue()){
                System.out.println("Changes detected: "+commonData.getValue());
                localValue = commonData.getValue();
            }
        }
        System.out.println("--ChangeListener---FINISH");
    }
}
