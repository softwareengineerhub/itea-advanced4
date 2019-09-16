package com.app.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional(propagation = Propagation.REQUIRED)
public class DataProcessor {
    @Autowired
    @Qualifier("daoImpl")
    private Dao daoImpl;

    @Autowired
    @Qualifier("daoImpl2")
    private Dao daoImpl2;

    public void processData(String msg){
        daoImpl.save(msg);
        daoImpl2.save(msg);
    }

}
