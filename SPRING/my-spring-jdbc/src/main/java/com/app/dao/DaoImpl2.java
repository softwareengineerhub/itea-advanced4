package com.app.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Component
public class DaoImpl2 implements Dao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void save(final String message) {
        //String sql = "INSERT_ INTO messages(MESSAGE) VALUES(?)";
        jdbcTemplate.execute("INSERTq INTO messages(MESSAGE) VALUES("+message+")");
        /*jdbcTemplate.execute(sql, new PreparedStatementCallback<Object>() {

            @Override
            public Object doInPreparedStatement(PreparedStatement preparedStatement) throws SQLException, DataAccessException {
                preparedStatement.setObject(1, message);
                return null;
            }
        });*/
    }

    @Override
    public List<String> readAllMessages() {
        List<String> list = jdbcTemplate.query("SELECT * FROM messages", new RowMapper<String>() {
            @Override
            public String mapRow(ResultSet resultSet, int i) throws SQLException {
                return resultSet.getString("message");
            }
        });

        return list;
    }
}
