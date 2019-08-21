package com.app.dao;

import com.app.model.Person;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        try(Connection c = getConnection()){
            List<Person> persons = new ArrayList<>();
            PreparedStatement ps = c.prepareStatement("SELECT * FROM persons WHERE name=?");
            ps.setString(1, name);

            ResultSet rs = ps.executeQuery();
            Person p =  null;
            while(rs.next()){
                p = new Person();
                //String name = rs.getString("name");
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

    public List<Person> readAllByAge(int age) {
        try(Connection c = getConnection()){
            List<Person> persons = new ArrayList<>();
            PreparedStatement ps = c.prepareStatement("SELECT * FROM persons WHERE age=?");
            //ps.setObject(1, age);
            ps.setInt(1, age);

            ResultSet rs = ps.executeQuery();
            Person p =  null;
            while(rs.next()){
                p = new Person();
                String name = rs.getString("name");
                //int age = rs.getInt("age");
                p.setName(name);
                p.setAge(age);
                persons.add(p);
            }

            return persons;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public void update(String name, Person candidate) {
        try(Connection c = getConnection()){
            PreparedStatement ps = c.prepareStatement("UPDATE persons SET name=?,age=? WHERE name=? ");
            int i=0;
            ps.setObject(++i, candidate.getName());
            ps.setObject(++i, candidate.getAge());
            ps.setObject(++i, name);
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
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
        try(Connection c = getConnection()){
            PreparedStatement ps = c.prepareStatement("DELETE FROM persons WHERE name=?");
         //
            ps.setObject(1, name);
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteAllByAge(int age) {
        try(Connection c = getConnection()){
            PreparedStatement ps = c.prepareStatement("DELETE FROM persons WHERE age=?");
            ps.setObject(1, age);
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteAllByAgeAndName(int age, String name) {
        try(Connection c = getConnection()){
            PreparedStatement ps = c.prepareStatement("DELETE FROM persons WHERE age=? AND name=?");
            ps.setObject(2, name);
            ps.setObject(1, age);
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void multipleSave(List<Person> persons) {

        try(Connection c =getConnection()){

            c.setAutoCommit(false);

            String sql = "INSERT INTO persons(name, age) VALUES('%s', %s)";

            for(Person person : persons){
                String query = String.format(sql, person.getName(), person.getAge());
                PreparedStatement ps = c.prepareStatement(query);
                ps.execute();
            }

            c.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    /*@Override
    public void multipleSave(List<Person> persons) {
        Connection c = null;
        try{
            c = getConnection();
            c.setAutoCommit(false);

            String sql = "INSERT INTO persons(name, age) VALUES('%s', %s)";

            for(Person person : persons){
                String query = String.format(sql, person.getName(), person.getAge());
                if(person.getName().contains("3")){
                    query = String.format("INSERD INTO persons(name, age) VALUES('%s', %s), person.getName()", person.getAge());
                }

                    PreparedStatement ps = c.prepareStatement(query);
                    ps.execute();
            }

            //c.commit();
        } catch (SQLException e) {
            //e.printStackTrace();
            try {
                c.commit();
                //c.rollback();
            } catch (SQLException ex) {
               // ex.printStackTrace();
            }
        }finally{
            if(c!=null){
                try {
                    c.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }*/

    @Override
    public List<Map<String, Object>> readAllByMetaData() {
        try(Connection c = getConnection()){
            PreparedStatement ps = c.prepareStatement("SELECT * FROM persons");
            ResultSet rs = ps.executeQuery();
            ResultSetMetaData  meta = rs.getMetaData();
            int n = meta.getColumnCount();
            List<String> names = new ArrayList();
            for(int i=0;i<n;i++){
                String columnName = meta.getColumnName(i+1);
                names.add(columnName);
            }

            List<Map<String, Object>> res = new ArrayList<>();
            while(rs.next()){

                Map<String, Object> item = new HashMap<>();
                for(String columnName: names){
                    Object value = rs.getObject(columnName);
                    item.put(columnName, value);
                }
                res.add(item);

            }
            return res;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/itea_db", "root", "11111111");
    }
}
