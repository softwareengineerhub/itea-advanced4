package com.ch03.app02;

public class Thread2 extends Thread {


    private String nameA;
    private String nameB;

    public Thread2(String nameA, String nameB) {
        this.nameA = nameA;
        this.nameB = nameB;
    }

    public void run() {
        synchronized (nameB) {
            System.out.println(getName() + " in " + nameB);

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

            synchronized (nameA) {
                System.out.println(getName() + " in " + nameA);
            }

        }
    }

}
