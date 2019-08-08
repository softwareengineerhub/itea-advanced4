package com.ch01.app05;

public class CalculationThread extends Thread {
    private int[] data;
    private int start;
    private int end;
    private int sum;

    public CalculationThread(int[] data, int start, int end) {
        this.data = data;
        this.start = start;
        this.end = end;
    }

    public void run() {
        for (int i = start; i < end; i++) {
            try {
                //System.out.println(getName()+"; "+sum);
                sum += data[i];
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public int getSum() {
        return sum;
    }


}
