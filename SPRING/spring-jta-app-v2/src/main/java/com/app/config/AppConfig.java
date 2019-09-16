package com.app.config;

import com.atomikos.icatch.jta.J2eeUserTransaction;
import com.atomikos.icatch.jta.UserTransactionManager;
import com.atomikos.jdbc.AtomikosDataSourceBean;
import com.mysql.jdbc.jdbc2.optional.MysqlXADataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.jta.JtaTransactionManager;

import javax.sql.DataSource;
import java.io.IOException;


//JTA
@Configuration
@ComponentScan(basePackages = {"com.app"})
@EnableTransactionManagement
public class AppConfig {

    @Bean
    public DataSource carDataSource(){
        MysqlXADataSource mysqlXaDataSource = new MysqlXADataSource();
        mysqlXaDataSource.setUrl("jdbc:mysql://localhost:3306/jta_car?useSSL=false");
        mysqlXaDataSource.setPinGlobalTxToPhysicalConnection(true);
        mysqlXaDataSource.setUser("root");
        mysqlXaDataSource.setPassword("11111111");

        AtomikosDataSourceBean dataSource = new AtomikosDataSourceBean();
        dataSource.setUniqueResourceName("CAR-XADBMSA");
        dataSource.setXaDataSourceClassName("com.mysql.jdbc.jdbc2.optional.MysqlXADataSource");
        dataSource.setXaDataSource(mysqlXaDataSource);
        dataSource.setPoolSize(1);
        return dataSource;
    }

    @Bean
    public DataSource employeeDataSource(){
        MysqlXADataSource mysqlXaDataSource = new MysqlXADataSource();
        mysqlXaDataSource.setUrl("jdbc:mysql://localhost:3306/jta_employee?useSSL=false");
        mysqlXaDataSource.setPinGlobalTxToPhysicalConnection(true);
        mysqlXaDataSource.setUser("root");
        mysqlXaDataSource.setPassword("11111111");



        AtomikosDataSourceBean dataSource = new AtomikosDataSourceBean();
        dataSource.setUniqueResourceName("EMPLOYEE-XADBMSA");
        dataSource.setXaDataSourceClassName("com.mysql.jdbc.jdbc2.optional.MysqlXADataSource");
        dataSource.setXaDataSource(mysqlXaDataSource);
        dataSource.setPoolSize(1);
        return dataSource;
    }


    @Bean(initMethod = "init", destroyMethod = "close")
    public UserTransactionManager atomikosTransactionManager() {
        UserTransactionManager manager = new UserTransactionManager();
        manager.setForceShutdown(false);
        return manager;
    }

    @Bean
    public J2eeUserTransaction atomikosUserTransaction() {
        try {
            J2eeUserTransaction userTransaction = new J2eeUserTransaction();
            userTransaction.setTransactionTimeout(300);
            return userTransaction;
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    @Bean
    public JtaTransactionManager transactionManager() throws IOException {
        JtaTransactionManager jtaTransactionManager = new JtaTransactionManager();
        jtaTransactionManager.setTransactionManager(atomikosTransactionManager());
        jtaTransactionManager.setUserTransaction(atomikosUserTransaction());
        jtaTransactionManager.setAllowCustomIsolationLevels(true);
        return jtaTransactionManager;
    }



}
