/*
 * The MIT License
 *
 * Copyright 2016, Juliano Macedo.
 * See LICENSE file for details.
 *
 */
package me.deployfor.model;

import org.bson.types.ObjectId;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import static org.junit.Assert.*;

/**
 *
 * @author Juliano Macedo
 */
public class PersonTest {

    public PersonTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     *
     */
    @org.junit.Test
    public void testPerson() {
        String name = "";
        String email = "";
        Person instance = new Person(name, email);
        assertNotNull(instance);
    }

    /**
     * Test of getId method, of class Person.
     */
    @org.junit.Test
    public void testGetId() {
        Person instance = new Person();
        ObjectId expResult = null;
        ObjectId result = instance.getId();
        assertEquals(expResult, result);
    }

    /**
     * Test of getName method, of class Person.
     */
    @org.junit.Test
    public void testGetName() {
        Person instance = new Person();
        String expResult = "";
        instance.setName(expResult);
        String result = instance.getName();
        assertEquals(expResult, result);
    }

    /**
     * Test of setName method, of class Person.
     */
    @org.junit.Test
    public void testSetName() {
        Person instance = new Person();
        String name = "";
        instance.setName(name);
        assertEquals(name, instance.getName());
    }

    /**
     * Test of getEmail method, of class Person.
     */
    @org.junit.Test
    public void testGetEmail() {
        Person instance = new Person();
        String expResult = "";
        instance.setEmail(expResult);
        String result = instance.getEmail();
        assertEquals(expResult, result);
    }

    /**
     * Test of setEmail method, of class Person.
     */
    @org.junit.Test
    public void testSetEmail() {
        Person instance = new Person();
        String email = "";
        instance.setEmail(email);
        assertEquals(email, instance.getEmail());
    }

}
