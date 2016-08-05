/*
 * The MIT License
 *
 * Copyright 2016, Juliano Macedo.
 * See LICENSE file for details.
 *
 */
package util;

import java.util.logging.Logger;
import com.mongodb.MongoClient;
import java.util.logging.Level;

/**
 * <p></p>
 *
 * @author Juliano Macedo  < /JulianoR at GitHub and Bitbucket >
 * @since 2016.07.23, 8:47:37 AM
 * @version 0.1
 */
public abstract class MongoUtil {

    private static MongoClient mongoClient = null;
    private static final int PORT = 27017;
    private static final String HOST = "localhost";
    private static final String DB_NAME = "deployforme";

    /**
     *
     * @return the MongoDB connection
     */
    public static MongoClient getMongoConnection() {
        if (mongoClient == null) {
            try {
                mongoClient = new MongoClient(HOST, PORT);
            } catch (Exception ex) {
                Logger.getLogger(MongoUtil.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return mongoClient;
    }

    public static int getPORT() {
        return PORT;
    }

    public static String getHOST() {
        return HOST;
    }

    public static String getDBName() {
        return DB_NAME;
    }
}
