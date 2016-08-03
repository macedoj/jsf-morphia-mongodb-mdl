/*
 * The MIT License
 *
 * Copyright 2016, Juliano Macedo.
 * See LICENSE file for details.
 *
 */
package me.deployfor.dao;

import com.mongodb.MongoClient;
import me.deployfor.model.Person;
import org.bson.types.ObjectId;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;
import org.mongodb.morphia.Morphia;
import util.MongoUtil;

/**
 *
 * @author Juliano Macedo
 */
@Ignore
public class PersonDAOTest {

    private String name;
    private String email;
    private MongoClient mongo;
    private Morphia morphia;
    private PersonDAO instance;

    public PersonDAOTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        name = "First Person in DB";
        email = "firstperson@email.com";
        mongo = MongoUtil.getMongoConnection();
        morphia = new Morphia();
        morphia.map(Person.class);
        instance = new PersonDAO(mongo, morphia, MongoUtil.getDBName());
    }

    @After
    public void tearDown() {
        instance.removeByEmail(email);
    }

    /**
     * Test of insert method, of class PersonDAO.
     */
    @Test
    public void testInsert_Sucess() {
        Person entity = new Person(name, email);
        boolean expResult = true;
        boolean result = instance.insert(entity);
        assertEquals(expResult, result);
    }

    /**
     * <p></p>
     */
    @Test
    public void testInsert_Unsuccess() {
        Person entity = new Person(name, email);
        boolean expResult = false;
        instance.insert(entity);
        boolean result = instance.insert(entity);
        assertEquals(expResult, result);
    }

    /**
     * Test of queryByKey method, of class PersonDAO.
     */
    @Test
    public void testQueryByKey_Sucess() {
        Person entity = new Person(name, email);
        instance.insert(entity);
        Person expResult = entity;
        Person result = instance.queryByKey(entity.getId());
        assertEquals(expResult.getId(), result.getId());
    }
    
    /**
     * <p></p>
     */
    @Test
    public void testQueryByKey_Unsucess() {
        Person expResult = null;
        Person result = instance.queryByKey(new ObjectId());
        assertEquals(expResult, result);
    }    

    /**
     * Test of queryByEmail method, of class PersonDAO.
     */
    @Test
    public void testQueryByEmail_Sucess() {
        Person entity = new Person(name, email);
        instance.insert(entity);
        Person expResult = entity;
        Person result = instance.queryByEmail(entity.getEmail());
        assertEquals(expResult.getEmail(), result.getEmail());
    }
    
    /**
     * Test of queryByEmail method, of class PersonDAO.
     */
    @Test
    public void testQueryByEmail_Unsucess() {
        Person expResult = null;
        Person result = instance.queryByEmail(email);
        assertEquals(expResult, result);
    }    
    

    /**
     * Test of removeByEmail method, of class PersonDAO.
     */
    @Test
    public void testRemoveByEmail_Sucess() {
        Person entity = new Person(name, email);
        instance.insert(entity);       
        boolean expResult = true;
        boolean result = instance.removeByEmail(email);
        assertEquals(expResult, result);
    }
    
    
    /**
     * Test of removeByEmail method, of class PersonDAO.
     */
    @Test
    public void testRemoveByEmail_Unsucess() {
        boolean expResult = false;
        boolean result = instance.removeByEmail(email);
        assertEquals(expResult, result);
    }    

}
