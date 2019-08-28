package org.client;

import com.app.SimpleCalculatorImpl;
import com.app.SimpleCalculatorImplService;

public class Main {

    public static void main(String[] args) {
        SimpleCalculatorImplService service = new SimpleCalculatorImplService();
        SimpleCalculatorImpl simpleCalculator = service.getSimpleCalculatorImplPort();;
        int res= simpleCalculator.add(1,20);
        System.out.println(res);

    }
}
