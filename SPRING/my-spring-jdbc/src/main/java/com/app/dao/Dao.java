package com.app.dao;

import java.util.List;

public interface Dao {

    public void save(String message);

    public List<String> readAllMessages();
}
