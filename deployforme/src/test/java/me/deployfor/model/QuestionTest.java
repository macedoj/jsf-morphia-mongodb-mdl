/*
 * The MIT License
 *
 * Copyright 2016, Juliano Macedo.
 * See LICENSE file for details.
 *
 */
package me.deployfor.model;

import java.util.HashMap;
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
public class QuestionTest {
    
    public QuestionTest() {
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
     * Test of getTitle method, of class Question.
     */
    @Test
    public void testGetTitle() {
        Question instance = new Question();
        String expResult = "";
        instance.setTitle(expResult);
        String result = instance.getTitle();
        assertEquals(expResult, result);
    }

    /**
     * Test of setTitle method, of class Question.
     */
    @Test
    public void testSetTitle() {
        String title = "";
        Question instance = new Question();
        instance.setTitle(title);
    }

    /**
     * Test of getChoices method, of class Question.
     */
    @Test
    public void testGetChoices() {
        Question instance = new Question();
        HashMap<String, String> expResult = null;
        instance.setChoices(expResult);
        HashMap<String, String> result = instance.getChoices();
        assertEquals(expResult, result);
    }

    /**
     * Test of setChoices method, of class Question.
     */
    @Test
    public void testSetChoices() {
        HashMap<String, String> choices = null;
        Question instance = new Question();
        instance.setChoices(choices);
    }

    /**
     * Test of getNumber method, of class Question.
     */
    @Test
    public void testGetNumber() {
        Question instance = new Question();
        int expResult = 25;
        instance.setNumber(expResult);
        int result = instance.getNumber();
        assertEquals(expResult, result);
    }

    /**
     * Test of setNumber method, of class Question.
     */
    @Test
    public void testSetNumber() {
        int number = 0;
        Question instance = new Question();
        instance.setNumber(number);
    }
    
}
