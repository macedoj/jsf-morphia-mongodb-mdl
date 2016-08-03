/*
 * The MIT License
 *
 * Copyright 2016, Juliano Macedo.
 * See LICENSE file for details.
 *
 */
package me.deployfor.model;

import java.util.ArrayList;
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
public class SurveyTest {
    
    public SurveyTest() {
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
     * Test of getQuestions method, of class Survey.
     */
    @Test
    public void testGetQuestions() {
        Survey instance = new Survey();
        ArrayList<Question> expResult = null;
        instance.setQuestions(expResult);
        ArrayList<Question> result = instance.getQuestions();
        assertEquals(expResult, result);
    }

    /**
     * Test of setQuestions method, of class Survey.
     */
    @Test
    public void testSetQuestions() {
        ArrayList<Question> expResult = new ArrayList<>();
        Survey instance = new Survey(expResult);
        ArrayList<Question> result = instance.getQuestions();
        assertEquals(result, expResult);
    }
    
}
