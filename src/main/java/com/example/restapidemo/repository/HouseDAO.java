package com.example.restapidemo.repository;

import com.example.restapidemo.entity.House;

import java.util.List;

public interface HouseDAO {

    public List<House> findAll();
    House findById(int theId);
    void save(House house);
    void deleteById(int theId);
}
