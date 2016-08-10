/*
 * The MIT License
 *
 * Copyright 2016, Juliano Macedo.
 * See LICENSE file for details.
 *
 */
package me.deployfor.controller;

import com.mongodb.MongoClient;
import java.util.logging.Level;
import java.util.logging.Logger;
import me.deployfor.model.EmailAuth;
import me.deployfor.model.Person;
import org.mongodb.morphia.Morphia;
import util.EmailUtil;
import util.MongoUtil;

/**
 * <p>
 * Classe destinada a manipular as informações necessárias quando o sistema
 * precisar envia <i>emails</i>.
 * </p>
 *
 * @author Juliano Macedo  < /JulianoR at GitHub and Bitbucket >
 * @since 2016.07.30, 1:34:05 AM
 * @version 0.1
 */
public class EmailManager {

    private static MongoClient mongo;
    private static Morphia morphia;

    public EmailManager() {
        mongo = MongoUtil.getMongoConnection();
        morphia = new Morphia();
        morphia.map(EmailAuth.class);
    }

    /**
     * <p>
     * Método responsável por invocar a classe que enviará o <i>email</i> ao
     * usuário.</p>
     *
     * @param person - O usuário que receberá o <i>email</i> do sistema. [Objeto
     * do tipo <code>Person</code>]
     */
    public void sendEmail(Person person) {
        if (person != null) {
            try {
                EmailUtil emailUtil = new EmailUtil(mongo, morphia);
                emailUtil.sendEmail(person);
            } catch (Exception ex) {
                Logger.getLogger(EmailManager.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
