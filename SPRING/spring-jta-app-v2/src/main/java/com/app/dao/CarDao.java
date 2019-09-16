package com.app.dao;

import com.app.model.Car;
import com.app.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@Repository
@Transactional
public class CarDao {

    @Autowired
    @Qualifier("carDataSource")
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

}
