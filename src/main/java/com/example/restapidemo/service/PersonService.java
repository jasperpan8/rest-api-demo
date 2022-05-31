package com.example.restapidemo.service;

import com.example.restapidemo.entity.Person;

import java.util.List;

public interface PersonService {

    public List<Person> findAll();
    Person findById(int theId);
    void save(Person person);
    void deleteById(int theId);

}
