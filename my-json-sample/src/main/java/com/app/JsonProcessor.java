package com.app;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonProcessor {

    public String toJSON(Person person){
        return String.format("{'name':'%s','age':'%s'}", person.getName(), person.getAge());
    }

    public String toJSON2(Person person){
        try {
            ObjectMapper objectMappper = new ObjectMapper();
            return objectMappper.writeValueAsString(person);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    public Person fromJSON2(String json){
        try {
            ObjectMapper objectMappper = new ObjectMapper();
            return objectMappper.readValue(json, Person.class);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


}
