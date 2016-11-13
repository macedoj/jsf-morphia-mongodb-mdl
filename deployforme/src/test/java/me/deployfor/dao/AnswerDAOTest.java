/*
 * The MIT License
 *
 * Copyright 2016, Juliano Macedo.
 * See LICENSE file for details.
 *
 */
package me.deployfor.dao;

import com.mongodb.MongoClient;
import java.util.HashMap;
import me.deployfor.model.Answer;
import org.bson.types.ObjectId;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.mongodb.morphia.Morphia;
import util.MongoUtil;

/**
 *
 * @author Juliano Macedo
 */
public class AnswerDAOTest {

    private String email;
    private MongoClient mongo;
    private Morphia morphia;
    private AnswerDAO instance;

    public AnswerDAOTest() {
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
        morphia.map(Answer.class);
        instance = new AnswerDAO(mongo, morphia, MongoUtil.getDBName());
    }

    @After
    public void tearDown() {
        instance.removeByEmail(email);
    }

    /**
     * Test of insert method, of class AnswerDAO.
     */
    @Test
    public void testInsert() {
        HashMap<String, String> choices = new HashMap<>();
        choices.put("A", "First choice");
        choices.put("B", "Second choice");
        choices.put("C", "Third choice");
        choices.put("D", "Fourth choice");

        Answer entity = new Answer(1, "A", email);
        instance.insert(entity);

        int result = instance.queryByEmail(email).getQuestionNumber();
        int expResult = 1;

        assertEquals(expResult, result);
    }

    /**
     * Test of queryByKey method, of class AnswerDAO.
     */
    @Test
    public void testQueryByKey_Sucess() {
        Answer expResult = new Answer(1, "Test query by Key", email);
        instance.insert(expResult);
        Answer result = instance.queryByKey(expResult.getId());
        assertEquals(expResult.getId(), result.getId());
    }

    /**
     * Test of queryByKey method, of class AnswerDAO.
     */
    @Test
    public void testQueryByKey_Unsucess() {
        Answer expResult = null;
        Answer result = instance.queryByKey(new ObjectId());
        assertEquals(expResult, result);
    }

    /**
     * Test of queryByEmail method, of class AnswerDAO.
     */
    @Test
    public void testQueryByEmail_Sucess() {
        Answer expResult = new Answer(1, "Test query by Key", email);
        instance.insert(expResult);
        Answer result = instance.queryByEmail(expResult.getEmail());
        assertEquals(expResult.getEmail(), result.getEmail());
    }

    /**
     * Test of queryByEmail method, of class AnswerDAO.
     */
    @Test
    public void testQueryByEmail_Unsucess() {
        Answer expResult = null;
        Answer result = instance.queryByEmail(email);
        assertEquals(expResult, result);
    }

    /**
     * Test of removeByEmail method, of class AnswerDAO.
     */
    @Test
    public void testRemoveByEmail_Sucess() {
        Answer entity = new Answer(1, "Test query by Key", email);
        instance.insert(entity);
        boolean expResult = true;
        boolean result = instance.removeByEmail(email);
        assertEquals(expResult, result);
    }

    /**
     * Test of removeByEmail method, of class AnswerDAO.
     */
    @Test
    public void testRemoveByEmail_Unsucess() {
        boolean expResult = false;
        boolean result = instance.removeByEmail(email);
        assertEquals(expResult, result);
    }

}
