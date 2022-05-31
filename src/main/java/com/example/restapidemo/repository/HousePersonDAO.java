package com.example.restapidemo.repository;

import com.example.restapidemo.entity.House_Person;

import java.util.List;

public interface HousePersonDAO {
    public List<House_Person> findAll();
    House_Person findById(int theId);
    void save(House_Person housePerson);
    void deleteById(int theId);
}
