/*
 * The MIT License
 *
 * Copyright 2016, Juliano Macedo.
 * See LICENSE file for details.
 *
 */
package me.deployfor.model;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;

/**
 * <p></p>
 *
 * @author Juliano Macedo  < /JulianoR at GitHub and Bitbucket >
 * @since 2016.07.23, 8:43:35 AM
 * @version 0.1
 */
@Entity
public class Person {

    @Id 
    private ObjectId id;
    private String name;
    private String email;

    public Person() {
    }

    public Person(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public ObjectId getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
