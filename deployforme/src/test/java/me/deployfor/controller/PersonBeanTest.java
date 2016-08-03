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
import util.MongoUtil;

/**
 *
 * @author Juliano Macedo
 */
@Ignore
public class PersonBeanTest {

    private String name;
    private String email;
    private PersonBean instance;

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
        email = "rpv.management.site@gmail.com";
    }

    @After
    public void tearDown() {
        MongoClient mongo = MongoUtil.getMongoConnection();
        Morphia morphia = new Morphia();
        morphia.map(Person.class);
        PersonDAO pdao = new PersonDAO(mongo, morphia, MongoUtil.getDBName());
        pdao.removeByEmail(email);
    }

    /**
     * Test of subscribe method, of class PersonBean.
     */
    @Ignore
    public void testSubscribe_Sucess() {
        instance.setName(name);
        instance.setEmail(email);
        instance.subscribe();
    }

    /**
     * Test of subscribe method, of class PersonBean.
     */
    @Ignore
    public void testSubscribe_Unsucess() {
        instance.setName(name);
        instance.setEmail(email);
        instance.subscribe();
        /**
         * Forçando um teste falso, pois tenta realizar a inscrição do mesmo
         * usuário duas vezes seguidas.
         */
        instance.subscribe();
    }

    /**
     * Test of unsubscribe method, of class PersonBean.
     */
    @Test
    public void testUnsubscribe_Sucess() {
        instance.setName(name);
        instance.setEmail(email);
        instance.unsubscribe();
    }

    /**
     * Test of unsubscribe method, of class PersonBean.
     */
    @Test
    public void testUnsubscribe_Unsucess() {
        instance.setName(name);
        instance.setEmail(email);
        instance.unsubscribe();
        /**
         * Forçando um teste falso, pois realiza a desinscrição do mesmo usuário
         * duas vezes seguidas.
         */
        instance.unsubscribe();
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
