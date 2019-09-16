package com.app.processor;

import com.app.model.Car;
import com.app.model.Employee;
import com.app.service.CarService;
import com.app.service.EmployeeService;

public class BusinessProcessor {

    private CarService carService;
    private EmployeeService employeeService;


    public void makeAction(Car car, Employee employee){
        carService.persist(car);
        employeeService.persist(employee);
    }

    public void setCarService(CarService carService) {
        this.carService = carService;
    }

    public void setEmployeeService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
}
