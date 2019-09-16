package com.app.main;

import com.app.config.AppConfig;
import com.app.model.Car;
import com.app.model.Employee;
import com.app.processor.BusinessProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);

        BusinessProcessor businessProcessor = ctx.getBean(BusinessProcessor.class);


        Car car = new Car();
        car.setName("CarA");

        Employee employee = new Employee();
        employee.setName("employeeA");

        businessProcessor.makeAction(car, employee);
    }




}
