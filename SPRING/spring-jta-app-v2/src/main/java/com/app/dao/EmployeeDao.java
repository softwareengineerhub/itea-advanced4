package com.app.dao;

import com.app.model.Car;
import com.app.model.Employee;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;

@Repository
@Transactional(propagation = Propagation.REQUIRED)
public class EmployeeDao {

    @Resource(name="employeeDataSource")
    private DataSource dataSource;

    public void save(Employee employee) {
        try (Connection c = dataSource.getConnection()) {
            PreparedStatement ps = c.prepareStatement("INSERT_ INTO employee(name) VALUES(?)");
            ps.setObject(1, employee.getName());
            ps.execute();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
