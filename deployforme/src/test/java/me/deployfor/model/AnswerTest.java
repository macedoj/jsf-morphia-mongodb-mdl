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
public class AnswerTest {
    
    public AnswerTest() {
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
     * Test of getAnswer method, of class Answer.
     */
    @Test
    public void testGetAnswer() {
        Answer instance = new Answer();
        String expResult = "";
        instance.setAnswer(expResult);
        String result = instance.getAnswer();
        assertEquals(expResult, result);
    }

    /**
     * Test of setAnswer method, of class Answer.
     */
    @Test
    public void testSetAnswer() {
        String answer = "";
        Answer instance = new Answer();
        instance.setAnswer(answer);
    }

    /**
     * Test of getQuestionNumber method, of class Answer.
     */
    @Test
    public void testGetQuestionNumber() {
        Answer instance = new Answer();
        int expResult = 10;
        instance.setQuestionNumber(expResult);
        int result = instance.getQuestionNumber();
        assertEquals(expResult, result);
    }

    /**
     * Test of setQuestionNumber method, of class Answer.
     */
    @Test
    public void testSetQuestionNumber() {
        int questionNumber = 0;
        Answer instance = new Answer();
        instance.setQuestionNumber(questionNumber);
    }

    /**
     * Test of getId method, of class Answer.
     */
    @Test
    public void testGetId() {
        Answer instance = new Answer();
        ObjectId expResult = new ObjectId();
        ObjectId result = instance.getId();
        assertNotSame(expResult, result);
    }

    /**
     * Test of setEmail method, of class Answer.
     */
    @Test
    public void testSetEmail() {
        String email = "";
        Answer instance = new Answer();
        instance.setEmail(email);
    }

    /**
     * Test of getEmail method, of class Answer.
     */
    @Test
    public void testGetEmail() {
        Answer instance = new Answer();
        String expResult = "";
        instance.setEmail(expResult);
        String result = instance.getEmail();
        assertEquals(expResult, result);
    }
    
}
