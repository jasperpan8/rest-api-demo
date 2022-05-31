package com.example.restapidemo.repository;

import com.example.restapidemo.entity.House;
import com.example.restapidemo.entity.Person;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class HouseDAOImpl implements HouseDAO{

    private EntityManager entityManager;

    @Autowired
    public HouseDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<House> findAll() {
        Session currentSession = entityManager.unwrap(Session.class);

        Query<House> theQuery =
                currentSession.createQuery("from House", House.class);

        List<House> houses = theQuery.getResultList();
        return houses;
    }

    @Override
    public House findById(int theId) {
        Session currentSession = entityManager.unwrap(Session.class);
        House house = currentSession.get(House.class, theId);
        return house;
    }

    @Override
    public void save(House house) {
        Session currentSession = entityManager.unwrap(Session.class);
        currentSession.saveOrUpdate(house);
    }

    @Override
    public void deleteById(int theId) {
        Session currentSession = entityManager.unwrap(Session.class);
        Query theQuery =
                currentSession.createQuery(
                        "delete from House where id=:houseId");

        theQuery.setParameter("houseId",theId);

        theQuery.executeUpdate();
    }
}
