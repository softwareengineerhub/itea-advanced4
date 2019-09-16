package com.app.service;

import com.app.dao.EmployeeDao;
import com.app.model.Employee;

public class EmployeeService {

    private EmployeeDao employeeDao;

    public void persist(Employee employee) {
        employeeDao.save(employee);
    }

    public void setEmployeeDao(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }
}
