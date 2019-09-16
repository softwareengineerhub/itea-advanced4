package com.app.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Component
public class DaoImpl implements Dao {
    @Autowired
    private DataSource dataSource;

    public void save(String message) {
        try(Connection c = dataSource.getConnection()){
            String sql = "INSERT INTO messages(MESSAGE) VALUES(?)";
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setObject(1, message);
            ps.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<String> readAllMessages() {
        try(Connection c = dataSource.getConnection()){
            List<String> data = new ArrayList();
            PreparedStatement ps = c.prepareStatement("SELECT * FROM messages");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                String msg = rs.getString("message");
                data.add(msg);
            }
            return data;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
