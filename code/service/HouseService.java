package com.example.restapidemo.service;

import com.example.restapidemo.entity.House;

import java.util.List;

public interface HouseService {
    public List<House> findAll();
    House findById(int theId);
    void save(House house);
    void deleteById(int theId);
}
