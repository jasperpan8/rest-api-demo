package com.example.restapidemo.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "person")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "person", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = false)
    private List<House_Person> house_people = new ArrayList<>();

    public Person() {
    }

    public Person(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<House_Person> getHouse_people() {
        return house_people;
    }

    public void setHouse_people(List<House_Person> house_people) {
        this.house_people = house_people;
    }

    public void addHousePerson(House_Person hp){
        this.house_people.add(hp);
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", house_people=" + house_people +
                '}';
    }
}
