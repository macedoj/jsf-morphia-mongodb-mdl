/*
 * The MIT License
 *
 * Copyright 2016, Juliano Macedo.
 * See LICENSE file for details.
 *
 */
package me.deployfor.controller;

import com.mongodb.MongoClient;
import me.deployfor.dao.PersonDAO;
import me.deployfor.model.Person;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;
import org.mongodb.morphia.Morphia;
import org.mongodb.morphia.query.QueryResults;
import util.MongoUtil;

/**
 * <p></p>
 *
 * @author Juliano Macedo
 */
public class PersonBeanTest {

    private String name;
    private String email;
    private PersonBean instance;
    private PersonDAO pdao;

    public PersonBeanTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        instance = new PersonBean();
        name = "Person Test by Junit";
        email = "junit@tester.com";
        MongoClient mongo = MongoUtil.getMongoConnection();
        Morphia morphia = new Morphia();
        morphia.map(Person.class);
        pdao = new PersonDAO(mongo, morphia, MongoUtil.getDBName());
    }

    @After
    public void tearDown() {
        pdao.removeByEmail(email);
    }

    /**
     * Test of subscribe method, of class PersonBean.
     */
    @Ignore
    public void testSubscribe_Sucess() {
        String expResult = email;
        instance.setName(name);
        instance.setEmail(expResult);
        instance.subscribe();

        Person queryByEmail = pdao.queryByEmail(email);
        String result = queryByEmail.getEmail();
        assertEquals(result, expResult);
    }

    /**
     * Test of subscribe method, of class PersonBean.
     */
    @Ignore
    public void testSubscribe_Unsucess() {
        long expResult = 1;
        
        instance.setName(name);
        instance.setEmail(email);
        instance.subscribe();
        instance.subscribe();
        
        QueryResults<Person> queryAllByEmail = pdao.queryAllByEmail(email);
        long result = queryAllByEmail.countAll();
        assertEquals(result, expResult);
    }

    /**
     * Test of unsubscribe method, of class PersonBean.
     */
    @Test
    public void testUnsubscribe_Sucess() {
        Person expResult = null;
        
        instance.setName(name);
        instance.setEmail(email);
        instance.unsubscribe();
        
        Person result = pdao.queryByEmail(email);
        assertEquals(result, expResult);   
    }

    /**
     * Test of unsubscribe method, of class PersonBean.
     */
    @Test
    public void testUnsubscribe_Unsucess() {
        Person expResult = null;
        
        instance.setName(name);
        instance.setEmail(email);
        instance.unsubscribe();
        instance.unsubscribe();
        
        Person result = pdao.queryByEmail(email);
        assertEquals(result, expResult);         
    }

    /**
     * Test of getEmail method, of class PersonBean.
     */
    @Test
    public void testGetEmail() {
        String expResult = "";
        instance.setEmail(expResult);
        String result = instance.getEmail();
        assertEquals(expResult, result);
    }

    /**
     * Test of setEmail method, of class PersonBean.
     */
    @Test
    public void testSetEmail() {
        String expResult = "";
        instance.setEmail(expResult);
        assertEquals(expResult, instance.getEmail());
    }

    /**
     * Test of getName method, of class PersonBean.
     */
    @Test
    public void testGetName() {
        String expResult = "";
        instance.setName(expResult);
        String result = instance.getName();
        assertEquals(expResult, result);
    }

    /**
     * Test of setName method, of class PersonBean.
     */
    @Test
    public void testSetName() {
        String expResult = "";
        instance.setName(expResult);
        assertEquals(expResult, instance.getName());
    }

    /**
     * Test of isSubscriptionOk method, of class PersonBean.
     */
    @Test
    public void testIsSubscriptionOk() {
        boolean expResult = false;
        instance.setSubscriptionOk(expResult);
        boolean result = instance.isSubscriptionOk();
        assertEquals(expResult, result);
    }

    /**
     * Test of setSubscriptionOk method, of class PersonBean.
     */
    @Test
    public void testSetSubscriptionOk() {
        boolean subscriptionOk = true;
        instance.setSubscriptionOk(subscriptionOk);
        assertEquals(subscriptionOk, instance.isSubscriptionOk());
    }

    /**
     * Test of isUnsubscriptionOk method, of class PersonBean.
     */
    @Test
    public void testIsUnsubscriptionOk() {
        boolean expResult = true;
        instance.setUnsubscriptionOk(expResult);
        boolean result = instance.isUnsubscriptionOk();
        assertEquals(expResult, result);
    }

    /**
     * Test of setUnsubscriptionOk method, of class PersonBean.
     */
    @Test
    public void testSetUnsubscriptionOk() {
        boolean unsubscriptionOk = false;
        instance.setUnsubscriptionOk(unsubscriptionOk);
        assertEquals(unsubscriptionOk, instance.isUnsubscriptionOk());
    }

}
