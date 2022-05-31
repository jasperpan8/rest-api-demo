package com.example.restapidemo.repository;

import com.example.restapidemo.entity.Person;

import java.util.List;

public interface PersonDAO {

    public List<Person> findAll();
    Person findById(int theId);
    void save(Person person);
    void deleteById(int theId);

}
