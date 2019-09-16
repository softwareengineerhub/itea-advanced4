package com.app.dao;

import com.app.model.Car;
import com.app.model.Employee;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class EmployeeDao {

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

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }
}
