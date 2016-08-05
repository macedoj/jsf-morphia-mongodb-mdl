/*
 * The MIT License
 *
 * Copyright 2016, Juliano Macedo.
 * See LICENSE file for details.
 *
 */
package me.deployfor.controller;

import com.mongodb.MongoClient;
import me.deployfor.dao.AnswerDAO;
import me.deployfor.model.Answer;
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
public class SurveyBeanTest {
    
    private String email;
    private SurveyBean instance;
    private MongoClient mongo;
    private Morphia morphia;
    
    public SurveyBeanTest() {
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
        instance = new SurveyBean();
    }
    
    @After
    public void tearDown() {
        AnswerDAO answerDAO = new AnswerDAO(mongo, morphia, MongoUtil.getDBName());
        answerDAO.removeByEmail(email);
    }

    /**
     * Test of saveSurveyAnswers method, of class SurveyBean.
     */
    @Test
    public void testSaveSurveyAnswers_Sucess() {
        instance.setEmail(email);
        instance.setAnswer1("A");
        instance.setAnswer2("B");
        instance.setAnswer3("C");
        instance.setAnswer4("D");
        instance.saveSurveyAnswers();
    }

    /**
     * Test of saveSurveyAnswers method, of class SurveyBean.
     */
    @Test
    public void testSaveSurveyAnswers_Unsucess() {
        instance.setAnswer1("");
        instance.setAnswer2("");
        instance.setAnswer3("");
        instance.setAnswer4("");
        instance.saveSurveyAnswers();
    }

    /**
     * Test of getAnswer1 method, of class SurveyBean.
     */
    @Test
    public void testGetAnswer1() {
        String expResult = "";
        SurveyBean instance1 = new SurveyBean(email);
        instance1.setAnswer1(expResult);
        String result = instance1.getAnswer1();
        assertEquals(expResult, result);
    }

    /**
     * Test of setAnswer1 method, of class SurveyBean.
     */
    @Test
    public void testSetAnswer1() {
        String expResult = "";
        instance.setAnswer1(expResult);
        assertEquals(expResult, instance.getAnswer1());
    }

    /**
     * Test of getAnswer2 method, of class SurveyBean.
     */
    @Test
    public void testGetAnswer2() {
        String expResult = "";
        instance.setAnswer2(expResult);
        String result = instance.getAnswer2();
        assertEquals(expResult, result);
    }

    /**
     * Test of setAnswer2 method, of class SurveyBean.
     */
    @Test
    public void testSetAnswer2() {
        String expResult = "";
        instance.setAnswer2(expResult);
        assertEquals(expResult, instance.getAnswer2());
    }

    /**
     * Test of getAnswer3 method, of class SurveyBean.
     */
    @Test
    public void testGetAnswer3() {
        String expResult = "";
        instance.setAnswer3(expResult);
        String result = instance.getAnswer3();
        assertEquals(expResult, result);
    }

    /**
     * Test of setAnswer3 method, of class SurveyBean.
     */
    @Test
    public void testSetAnswer3() {
        String answer3 = "";
        instance.setAnswer3(answer3);
        assertEquals(answer3, instance.getAnswer3());
        
    }

    /**
     * Test of getAnswer4 method, of class SurveyBean.
     */
    @Test
    public void testGetAnswer4() {
        String expResult = "";
        instance.setAnswer4(expResult);
        String result = instance.getAnswer4();
        assertEquals(expResult, result);
    }

    /**
     * Test of setAnswer4 method, of class SurveyBean.
     */
    @Test
    public void testSetAnswer4() {
        String answer4 = "";
        instance.setAnswer4(answer4);
        assertEquals(answer4, instance.getAnswer4());
        
    }

    /**
     * Test of getEmail method, of class SurveyBean.
     */
    @Test
    public void testGetEmail() {
        String expResult = "";
        instance.setEmail(expResult);
        String result = instance.getEmail();
        assertEquals(expResult, result);
    }

    /**
     * Test of setEmail method, of class SurveyBean.
     */
    @Test
    public void testSetEmail() {
        instance.setEmail(email);
        assertEquals(email, instance.getEmail());
    }

    /**
     * Test of isAnswerSavedOk method, of class SurveyBean.
     */
    @Test
    public void testIsAnswerSavedOk() {
        boolean expResult = false;
        instance.setAnswerSavedOk(expResult);
        boolean result = instance.isAnswerSavedOk();
        assertEquals(expResult, result);
    }

    /**
     * Test of setAnswerSavedOk method, of class SurveyBean.
     */
    @Test
    public void testSetAnswerSavedOk() {
        boolean expResult = true;
        instance.setAnswerSavedOk(expResult);
        assertEquals(expResult, instance.isAnswerSavedOk());
    }
}
