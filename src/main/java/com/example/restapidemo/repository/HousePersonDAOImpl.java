package com.example.restapidemo.repository;

import com.example.restapidemo.entity.House;
import com.example.restapidemo.entity.House_Person;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class HousePersonDAOImpl implements HousePersonDAO{

    private EntityManager entityManager;

    @Autowired
    public HousePersonDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<House_Person> findAll() {
        Session currentSession = entityManager.unwrap(Session.class);

        Query<House_Person> theQuery =
                currentSession.createQuery("from House_Person", House_Person.class);

        List<House_Person> house_person = theQuery.getResultList();
        return house_person;
    }

    @Override
    public House_Person findById(int theId) {
        Session currentSession = entityManager.unwrap(Session.class);
        House_Person housePerson = currentSession.get(House_Person.class, theId);
        return housePerson;
    }

    @Override
    public void save(House_Person housePerson) {
        Session currentSession = entityManager.unwrap(Session.class);
        currentSession.saveOrUpdate(housePerson);
    }

    @Override
    public void deleteById(int theId) {
        Session currentSession = entityManager.unwrap(Session.class);
        Query theQuery =
                currentSession.createQuery(
                        "delete from House_Person where id=:housepersonId");

        theQuery.setParameter("housepersonId",theId);

        theQuery.executeUpdate();
    }
}
