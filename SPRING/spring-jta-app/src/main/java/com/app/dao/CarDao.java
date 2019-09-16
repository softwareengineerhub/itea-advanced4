package com.app.dao;

import com.app.model.Car;
import com.app.model.Employee;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CarDao {

    private DataSource dataSource;

    public void save(Car car){
        try(Connection c = dataSource.getConnection()){
            PreparedStatement ps = c.prepareStatement("INSERT INTO car(name) VALUES(?)");
            ps.setObject(1, car.getName());
            ps.execute();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }
}
