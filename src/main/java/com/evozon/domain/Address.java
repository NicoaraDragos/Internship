package com.evozon.domain;

import javax.persistence.*;

/**
 * Created by dianamohanu on 11/07/2016.
 */
@Entity
public class Address {
    @Id
    @GeneratedValue
    private Integer id;

    @Column(name="STREET")
    private String street;

    @Column(name="NUMBER")
    private Integer number;

    @Column(name="TYPE")
    private String type;

    @ManyToOne
    private User user;

    public Address() {

    }

    public Address(String street, Integer number, String type) {
        this.street = street;
        this.number = number;
        this.type = type;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
