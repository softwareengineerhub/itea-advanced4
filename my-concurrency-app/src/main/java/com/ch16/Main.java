package com.ch16;

public class Main {

    public static void main(String[] args) {
        CommonData2 commonData2 = new CommonData2();
        DenisThread denisThread = new DenisThread(commonData2);
        BorisThread borisThread = new BorisThread(commonData2);

        denisThread.start();
        borisThread.start();
    }
}
