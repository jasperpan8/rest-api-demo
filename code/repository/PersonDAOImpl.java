package com.example.restapidemo.repository;

import com.example.restapidemo.entity.Person;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class PersonDAOImpl implements PersonDAO{

    private EntityManager entityManager;

    @Autowired
    public PersonDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Person> findAll() {
        Session currentSession = entityManager.unwrap(Session.class);

        Query<Person> theQuery =
                currentSession.createQuery("from Person", Person.class);

        List<Person> persons = theQuery.getResultList();
        return persons;
    }

    @Override
    public Person findById(int theId) {
        Session currentSession = entityManager.unwrap(Session.class);
        Person person = currentSession.get(Person.class, theId);
        return person;
    }

    @Override
    public void save(Person person) {
        Session currentSession = entityManager.unwrap(Session.class);
        currentSession.saveOrUpdate(person);
    }

    @Override
    public void deleteById(int theId) {
        Session currentSession = entityManager.unwrap(Session.class);
        Query theQuery =
                currentSession.createQuery(
                        "delete from Person where id=:personId");

        theQuery.setParameter("personId",theId);

        theQuery.executeUpdate();
    }
}
