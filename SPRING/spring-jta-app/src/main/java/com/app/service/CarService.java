package com.app.service;

import com.app.dao.CarDao;
import com.app.model.Car;

public class CarService {

    private CarDao carDao;

    public void persist(Car car) {
        carDao.save(car);
    }

    public void setCarDao(CarDao carDao) {
        this.carDao = carDao;
    }
}
