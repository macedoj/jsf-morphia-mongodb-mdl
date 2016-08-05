/*
 * The MIT License
 *
 * Copyright 2016, Juliano Macedo.
 * See LICENSE file for details.
 *
 */
package me.deployfor.controller;

import me.deployfor.model.Person;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

/**
 *
 * @author Juliano Macedo
 */
public class EmailManagerTest {

    private String name;
    private String email;
    private EmailManager instance;

    public EmailManagerTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        name = "Junit Tester";
        email = "rpv.management.site@gmail.com";
        instance = new EmailManager();
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of sendEmail method, of class EmailManager.
     */
    @Ignore
    public void testSendEmail_Sucess() {
        Person person = new Person(name, email);
        instance.sendEmail(person);
    }

    /**
     * Test of sendEmail method, of class EmailManager.
     */
    @Test
    public void testSendEmail_Unsucess() {
        Person person = null;
        instance.sendEmail(person);
    }
}
