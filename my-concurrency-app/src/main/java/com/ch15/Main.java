package com.ch15;

public class Main {

    public static void main(String[] args) {
        CommonData commonData = new CommonData();
        ChangeListener changeListener = new ChangeListener(commonData);
        ChangeMaker changeMaker = new ChangeMaker(commonData);

        changeListener.start();
        changeMaker.start();
    }
}
