package com.app.service;

import com.app.dao.EmployeeDao;
import com.app.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


@Service
//@Transactional(propagation = Propagation.REQUIRES_NEW)
@Transactional(propagation = Propagation.REQUIRED)
public class EmployeeService {

    @Autowired
    private EmployeeDao employeeDao;

    public void persist(Employee employee) {
        employeeDao.save(employee);
    }

}
