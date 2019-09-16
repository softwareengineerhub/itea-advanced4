package com.app.service;

import com.app.dao.CarDao;
import com.app.model.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CarService {

    @Autowired
    private CarDao carDao;

    public void persist(Car car) {
        carDao.save(car);
    }


}
