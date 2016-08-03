/*
 * The MIT License
 *
 * Copyright 2016, Juliano Macedo.
 * See LICENSE file for details.
 *
 */
package util;

import com.mongodb.MongoClient;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;

/**
 *
 * @author Juliano Macedo
 */
@Ignore
public class MongoUtilTest {

    private int port;
    private String host;
    private String dbName;
    private MongoClient mongoClient;

    public MongoUtilTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Setando os dados defaults para os testes, lembrando que os mesmo devems
     * ser configurados para cada contexto (servidor ou localhost).
     */
    @Before
    public void setUp() {
        port = 27017;
        dbName = "deployforme";
        host = "localhost";
        mongoClient = null;
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of getMongoConnection method, of class MongoUtil.
     */
    @Test
    public void testGetMongoConnection() {
        MongoClient expResult = mongoClient;
        MongoClient result = MongoUtil.getMongoConnection();
        assertNotEquals(expResult, result);
    }

    /**
     * Test of getPort method, of class MongoUtil.
     */
    @Test
    public void testGetPort() {
        int expResult = port;
        int result = MongoUtil.getPORT();
        assertEquals(expResult, result);
    }

    /**
     * Test of getHost method, of class MongoUtil.
     */
    @Test
    public void testGetHost() {
        String expResult = host;
        String result = MongoUtil.getHOST();
        assertEquals(expResult, result);
    }

    /**
     * Test of getDBName method, of class MongoUtil.
     */
    @Test
    public void testGetDBName() {
        String expResult = dbName;
        String result = MongoUtil.getDBName();
        assertEquals(expResult, result);
    }

}
