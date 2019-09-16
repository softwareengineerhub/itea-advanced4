package com.app.processor;

import com.app.model.Car;
import com.app.model.Employee;
import com.app.service.CarService;
import com.app.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional(propagation = Propagation.REQUIRED)
public class BusinessProcessor {

    @Autowired
    private CarService carService;
    @Autowired
    private EmployeeService employeeService;

    public void makeAction(Car car, Employee employee){
        try {
            carService.persist(car);
            employeeService.persist(employee);
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }

}
