package com.app.processor;

import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
public class MessageProcessor {


    public String processMessage(String parameter){
        System.out.println("processMessage()");
        return "Hello, "+parameter;
    }

}
