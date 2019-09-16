package com.app.main;

import com.app.dao.CarDao;
import com.app.dao.EmployeeDao;
import com.app.helper.MyDataSource;
import com.app.model.Car;
import com.app.model.Employee;
import com.app.processor.BusinessProcessor;
import com.app.service.CarService;
import com.app.service.EmployeeService;

public class Main {

    public static void main(String[] args) {
        MyDataSource carDataSource = new MyDataSource("root", "11111111", "jdbc:mysql://localhost:3306/jta_car?useSSL=false");
        MyDataSource employeeDataSource = new MyDataSource("root", "11111111", "jdbc:mysql://localhost:3306/jta_employee?useSSL=false");

        CarDao carDao = new CarDao();
        carDao.setDataSource(carDataSource);

        EmployeeDao employeeDao = new EmployeeDao();
        employeeDao.setDataSource(employeeDataSource);



        CarService carService = new CarService();
        carService.setCarDao(carDao);

        EmployeeService employeeService = new EmployeeService();
        employeeService.setEmployeeDao(employeeDao);


        BusinessProcessor businessProcessor = new BusinessProcessor();
        businessProcessor.setCarService(carService);
        businessProcessor.setEmployeeService(employeeService);


        Car car = new Car();
        car.setName("CarA");

        Employee employee = new Employee();
        employee.setName("employeeA");

        businessProcessor.makeAction(car, employee);
    }




}
