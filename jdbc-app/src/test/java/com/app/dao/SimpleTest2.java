package com.app.dao;

import org.junit.Ignore;
import org.junit.Test;

public class SimpleTest2 {

    @Ignore
    @Test(timeout = 1000)
    public void test() throws InterruptedException {
       Thread.sleep(5000);
    }
}
