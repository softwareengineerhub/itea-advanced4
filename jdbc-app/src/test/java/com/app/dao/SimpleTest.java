package com.app.dao;

import org.junit.Test;

import static org.junit.Assert.fail;

public class SimpleTest {
    private int i;

    @Test(expected = Exception.class)
    public void myTest(){
        System.out.println("hashCode="+hashCode());
        i++;
        String s = null;
        s.toString();
    }

    @Test
    public void myTest2(){
        System.out.println("hashCode="+hashCode());
        try {
            String s = null;
            s.toString();
        }catch(NullPointerException ex){
            fail();
        }
    }

    @Test
    public void m3(){
        m1();
        m2();
    }


    private void m1(){

    }

    private void m2(){

    }
}
