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
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Juliano Macedo
 */
public class EmailAuthTest {

    public EmailAuthTest() {
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
    @Test
    public void testConstructor(){
        String email = "";
        String passphrase = "";
        EmailAuth expResult = new EmailAuth(email, passphrase);
        assertNotNull(expResult);
    }

    /**
     * Test of getId method, of class EmailAuth.
     */
    @Test
    public void testGetId() {
        EmailAuth instance = new EmailAuth();
        ObjectId expResult = new ObjectId();
        ObjectId result = instance.getId();
        assertNotEquals(expResult, result);
    }

    /**
     * Test of getEmail method, of class EmailAuth.
     */
    @Test
    public void testGetEmail() {
        EmailAuth instance = new EmailAuth();
        String expResult = "";
        instance.setEmail(expResult);
        String result = instance.getEmail();
        assertEquals(expResult, result);
    }

    /**
     * Test of setEmail method, of class EmailAuth.
     */
    @Test
    public void testSetEmail() {
        String expResult = "";
        EmailAuth instance = new EmailAuth();
        instance.setEmail(expResult);
        String result = instance.getEmail();
        assertEquals(expResult, result);

    }

    /**
     * Test of getPassphrase method, of class EmailAuth.
     */
    @Test
    public void testGetPassphrase() {
        EmailAuth instance = new EmailAuth();
        String expResult = "";
        instance.setPassphrase(expResult);
        String result = instance.getPassphrase();
        assertEquals(expResult, result);
    }

    /**
     * Test of setPassphrase method, of class EmailAuth.
     */
    @Test
    public void testSetPassphrase() {
        String expResult = "";
        EmailAuth instance = new EmailAuth();
        instance.setPassphrase(expResult);
        String result = instance.getPassphrase();
        assertEquals(result, expResult);
    }

}
