package com.example.restapidemo.entity;

import javax.persistence.*;

@Entity
@Table(name = "house")
public class House {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name= "house_name")
    private String house_name;

    public House() {
    }

    public House(String house_name) {
        this.house_name = house_name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHouse_name() {
        return house_name;
    }

    public void setHouse_name(String house_name) {
        this.house_name = house_name;
    }

    @Override
    public String toString() {
        return "House{" +
                "id=" + id +
                ", house_name='" + house_name + '\'' +
                '}';
    }
}
