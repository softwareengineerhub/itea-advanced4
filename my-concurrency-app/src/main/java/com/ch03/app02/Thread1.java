package com.ch03.app02;

public class Thread1 extends Thread {
    private String nameA;
    private String nameB;

    public Thread1(String nameA, String nameB) {
        this.nameA = nameA;
        this.nameB = nameB;
    }

    public void run() {
        synchronized (nameA) {
            System.out.println(getName() + " in " + nameA);

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

            synchronized (nameB) {
                System.out.println(getName() + " in " + nameB);
            }

        }
    }

}
