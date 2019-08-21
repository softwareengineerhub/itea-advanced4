package com.app.dao;

import com.app.model.Person;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DaoImpl implements Dao {

/*    static{

        try {
            //DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            //Class.forName("com.mysql.jdbc.Driver");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }*/




    public void save(Person person) {
        Connection c = null;
        try {
            String sql = "INSERT INTO persons(name, age) VALUES('%s', %s)";
            String query = String.format(sql, person.getName(), person.getAge());
            c = getConnection();
            Statement st = c.createStatement();
            st.execute(query);
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            if (c != null) {
                try {
                    c.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public List<Person> readAll() {
        try(Connection c = getConnection()){
            List<Person> persons = new ArrayList<>();
            String sql = "SELECT * FROM persons";
            PreparedStatement ps = c.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();
            Person p =  null;
            while(rs.next()){
                p = new Person();
                String name = rs.getString("name");
                int age = rs.getInt("age");
                p.setName(name);
                p.setAge(age);
                persons.add(p);
            }

            return persons;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Person> readAllByName(String name) {
        return null;
    }

    public List<Person> readAllByAge(int age) {
        return null;
    }

    public void update(String name, Person candidate) {

    }

    public void deleteAll() {
        try(Connection c = getConnection()){
            PreparedStatement ps = c.prepareStatement("DELETE FROM persons");
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteAllByName(String name) {

    }

    public void deleteAllByAge(int age) {

    }

    public void deleteAllByAgeAndName(int age, String name) {

    }

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/itea_db", "root", "11111111");
    }
}
