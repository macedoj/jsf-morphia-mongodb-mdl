/*
 * The MIT License
 *
 * Copyright 2016, Juliano Macedo.
 * See LICENSE file for details.
 *
 */
package me.deployfor.dao;

import com.mongodb.MongoClient;
import me.deployfor.model.EmailAuth;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.mongodb.morphia.Morphia;
import org.mongodb.morphia.query.QueryResults;
import util.MongoUtil;

/**
 *
 * @author Juliano Macedo
 */
public class EmailAuthDAOTest {

    private MongoClient mongo;
    private Morphia morphia;
    private String email;
    private EmailAuthDAO instance;

    public EmailAuthDAOTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        email = "junit@tester.com";
        mongo = MongoUtil.getMongoConnection();
        morphia = new Morphia();
        morphia.map(EmailAuth.class);
        instance = new EmailAuthDAO(mongo, morphia, MongoUtil.getDBName());
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of queryRetrieveAllEmails method, of class EmailAuthDAO.
     */
    @Test
    public void testQueryRetrieveAllEmails() {
        QueryResults<EmailAuth> expResult = null;
        QueryResults<EmailAuth> result = instance.queryRetrieveAllEmails();
        assertNotEquals(expResult, result);
    }

    /**
     * Test of queryByEmail method, of class EmailAuthDAO.
     */
    @Test
    public void testQueryByEmail() {
        EmailAuth expResult = null;
        EmailAuth result = instance.queryByEmail(email);
        assertEquals(expResult, result);
    }

}
