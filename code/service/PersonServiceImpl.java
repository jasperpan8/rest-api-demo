package com.example.restapidemo.service;

import com.example.restapidemo.entity.Person;
import com.example.restapidemo.repository.PersonDAO;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PersonServiceImpl implements PersonService{

    private PersonDAO personDAO;
    private final Log logger = LogFactory.getLog(PersonServiceImpl.class);

    @Autowired
    public PersonServiceImpl(PersonDAO personDAO) {
        this.personDAO = personDAO;
    }

    @Override
    @Transactional
    public List<Person> findAll() {
        logger.info("Applying person findAll method!");
        return personDAO.findAll();
    }

    @Override
    @Transactional
    public Person findById(int theId) {
        logger.info("Applying person findById method!");
        return personDAO.findById(theId);
    }

    @Override
    @Transactional
    public void save(Person person) {
        logger.info("Applying person save method!");
        personDAO.save(person);
    }

    @Override
    @Transactional
    public void deleteById(int theId) {
        logger.info("Applying person deleteById method!");
        personDAO.deleteById(theId);
    }
}
