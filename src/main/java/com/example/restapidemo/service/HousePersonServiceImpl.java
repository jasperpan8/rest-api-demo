package com.example.restapidemo.service;

import com.example.restapidemo.entity.House_Person;
import com.example.restapidemo.repository.HousePersonDAO;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class HousePersonServiceImpl implements HousePersonService{

    private HousePersonDAO housePersonDAO;
    private final Log logger = LogFactory.getLog(HousePersonServiceImpl.class);

    @Autowired
    public HousePersonServiceImpl(HousePersonDAO housePersonDAO) {
        this.housePersonDAO = housePersonDAO;
    }

    @Override
    @Transactional
    public List<House_Person> findAll() {
        logger.info("Applying HousePerson findAll method!");
        return housePersonDAO.findAll();
    }

    @Override
    @Transactional
    public House_Person findById(int theId) {
        logger.info("Applying HousePerson findById method!");
        return housePersonDAO.findById(theId);
    }

    @Override
    @Transactional
    public void save(House_Person housePerson) {
        logger.info("Applying HousePerson save method!");
        housePersonDAO.save(housePerson);
    }

    @Override
    @Transactional
    public void deleteById(int theId) {
        logger.info("Applying HousePerson deleteById method!");
        housePersonDAO.deleteById(theId);
    }
}
