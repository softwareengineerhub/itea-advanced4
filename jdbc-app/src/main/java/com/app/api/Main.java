package com.app.api;

import com.app.dao.Dao;
import com.app.dao.DaoImpl;

public class Main {

    public static void main(String[] args) {
        Dao dao = new DaoImpl();
        String filePath = "test.xlsx";
        DataApi dataApi = new ExcellDataApi(filePath, dao);
        //dataApi.read();
        dataApi.write();

    }
}
