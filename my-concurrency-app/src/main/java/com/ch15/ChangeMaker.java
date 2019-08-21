package com.ch15;

public class ChangeMaker extends  Thread {
    private CommonData commonData;

    public ChangeMaker(CommonData commonData) {
        this.commonData = commonData;
    }

    public void run(){
        int localValue = commonData.getValue();
        while(localValue<10){
            localValue++;
            commonData.setValue(localValue);
            System.out.println("ChangeMaker: "+commonData.getValue());
            try {
                Thread.sleep(1500);
            }catch(Exception ex){
                ex.printStackTrace();
            }
        }
        System.out.println("---ChangeMaker FINISH--");
    }
}
