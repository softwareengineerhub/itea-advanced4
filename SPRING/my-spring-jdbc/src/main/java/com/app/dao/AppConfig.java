package com.app.dao;

import com.atomikos.icatch.jta.UserTransactionManager;
import com.atomikos.jdbc.AtomikosDataSourceBean;
import com.mysql.jdbc.jdbc2.optional.MysqlXADataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.logging.Logger;

@Configuration
@ComponentScan(basePackages = {"com"})
public class AppConfig {

    /*@Bean
    public DataSource dataSource(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/spring_schema?useSSL=false");
        dataSource.setUsername("root");
        dataSource.setPassword("11111111");
        return dataSource;
    }*/

    @Bean(initMethod = "init", destroyMethod = "close")
    public UserTransactionManager atomikosTransactionManager() {
        UserTransactionManager manager = new UserTransactionManager();
        //manager.setForceShutdown(false);
        return manager;
    }

   // @Bean(initMethod = "init", destroyMethod = "close")
    @Bean
    public DataSource dataSource() {
        MysqlXADataSource mysqlXaDataSource = new MysqlXADataSource();
        mysqlXaDataSource.setUrl("jdbc:mysql://localhost:3306/spring_schema?useSSL=false");
        //mysqlXaDataSource.setUrl("jdbc:mysql://localhost:3306/jta_company");
        mysqlXaDataSource.setPinGlobalTxToPhysicalConnection(true);
        mysqlXaDataSource.setUser("root");
        mysqlXaDataSource.setPassword("11111111");


        AtomikosDataSourceBean dataSource = new AtomikosDataSourceBean();
        dataSource.setUniqueResourceName("COMPANY-XADBMSA");
        dataSource.setXaDataSourceClassName("com.mysql.jdbc.jdbc2.optional.MysqlXADataSource");
        dataSource.setXaDataSource(mysqlXaDataSource);
        dataSource.setPoolSize(1);
        return dataSource;
    }


    @Bean
    public JdbcTemplate getTemplate(){
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        DataSource ds = dataSource();
        jdbcTemplate.setDataSource(ds);
        return jdbcTemplate;
    }


    /*@Bean
    public Dao daoImpl(){
        return new DaoImpl();
    }

    @Bean
    public Dao daoImpl2(){
        return new DaoImpl2();
    }*/



}
