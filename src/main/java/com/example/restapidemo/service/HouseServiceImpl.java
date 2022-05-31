package com.example.restapidemo.service;

import com.example.restapidemo.entity.House;
import com.example.restapidemo.repository.HouseDAO;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class HouseServiceImpl implements HouseService{

    private HouseDAO houseDAO;
    private final Log logger = LogFactory.getLog(PersonServiceImpl.class);

    @Autowired
    public HouseServiceImpl(HouseDAO houseDAO) {
        this.houseDAO = houseDAO;
    }

    @Override
    @Transactional
    public List<House> findAll() {
        logger.info("Applying House findAll method!");
        return houseDAO.findAll();
    }

    @Override
    @Transactional
    public House findById(int theId) {
        logger.info("Applying House findById method!");
        return houseDAO.findById(theId);
    }

    @Override
    @Transactional
    public void save(House house) {
        logger.info("Applying House save method!");
        houseDAO.save(house);
    }

    @Override
    @Transactional
    public void deleteById(int theId) {
        logger.info("Applying House deleteById method!");
        houseDAO.deleteById(theId);
    }
}
