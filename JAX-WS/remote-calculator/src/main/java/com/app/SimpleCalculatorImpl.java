package com.app;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public class SimpleCalculatorImpl implements SimpleCalculator {

    @WebMethod
    public int add(int a, int b) {
        return a+b;
    }
}
