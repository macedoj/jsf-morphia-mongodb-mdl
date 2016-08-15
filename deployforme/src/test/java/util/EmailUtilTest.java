/*
 * The MIT License
 *
 * Copyright 2016, Juliano Macedo.
 * See LICENSE file for details.
 *
 */
package util;

import com.mongodb.MongoClient;
import me.deployfor.model.EmailAuth;
import me.deployfor.model.Person;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.Ignore;
import org.mongodb.morphia.Morphia;

/**
 *
 * @author Juliano Macedo
 */
public class EmailUtilTest {

    private String name;
    private String email;
    private MongoClient mongo;
    private Morphia morphia;
    private EmailUtil instance;

    public EmailUtilTest() {
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
        email = "junit@tester.com";
        mongo = MongoUtil.getMongoConnection();
        morphia = new Morphia();
        morphia.map(EmailAuth.class);
        instance = new EmailUtil(mongo, morphia);
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of sendEmail method, of class EmailUtil.
     */
    @Ignore
    public void testSendEmail_Sucess() {
        Person person = new Person(name, email);
        instance.sendEmail(person);
    }

    /**
     * Test of sendEmail method, of class EmailUtil.
     */
    @Test
    public void testSendEmail_Unsucess() {
        Person person = null;
        instance.sendEmail(person);
    }

}
