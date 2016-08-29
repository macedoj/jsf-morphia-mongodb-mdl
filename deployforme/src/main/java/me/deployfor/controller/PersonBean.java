/*
 * The MIT License
 *
 * Copyright 2016, Juliano Macedo.
 * See LICENSE file for details.
 *
 */
package me.deployfor.controller;

import com.mongodb.MongoClient;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import me.deployfor.dao.PersonDAO;
import me.deployfor.model.Person;
import org.mongodb.morphia.Morphia;
import util.MongoUtil;

/**
 * <p>
 * Classe responsável por manipular as informações pessoais do usuário, quando
 * esse realiza sua inscrição no sistema.
 * </p>
 *
 * @author Juliano Macedo  < /JulianoR at GitHub and Bitbucket >
 * @since 2016.07.23, 5:36:07 AM
 * @version 0.1
 */
@RequestScoped
@Named
public class PersonBean implements Serializable {

    private String email;
    private String name;
    private boolean subscriptionOk;
    private boolean unsubscriptionOk;
    private final MongoClient mongo;
    private final Morphia morphia;

    public PersonBean() {
        mongo = MongoUtil.getMongoConnection();
        morphia = new Morphia();
        morphia.map(Person.class);
        subscriptionOk = false;
        unsubscriptionOk = false;
    }

    /**
     * <p>
     * Método responsável por realizar a inscrição do novo usuário no
     * sistema.</p>
     *
     */
    public void subscribe() {
        if (email != null && !email.isEmpty()) {
            try {
                Person person = new Person(name, email);
                PersonDAO pdao = new PersonDAO(mongo, morphia, MongoUtil.getDBName());

                // Disponível para manipulação de feedback ao usário.
                subscriptionOk = pdao.insert(person);

                if (subscriptionOk) {
                    EmailManager em = new EmailManager();
                    em.sendEmail(person);
                }
            } catch (Exception ex) {
                Logger.getLogger(PersonBean.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    /**
     * <p>
     * Método responsável por remover os dados pessoais do usuário da base de
     * dados.</p>
     *
     */
    public void unsubscribe() {
        if (email != null && !email.isEmpty()) {
            try {
                PersonDAO pdao = new PersonDAO(mongo, morphia, MongoUtil.getDBName());

                // Disponível para manipulação de feedback ao usário.
                unsubscriptionOk = pdao.removeByEmail(email);

            } catch (Exception ex) {
                Logger.getLogger(PersonBean.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

// <editor-fold defaultstate="collapsed" desc="Getters and Setters"> 
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isSubscriptionOk() {
        return subscriptionOk;
    }

    public void setSubscriptionOk(boolean subscriptionOk) {
        this.subscriptionOk = subscriptionOk;
    }

    public boolean isUnsubscriptionOk() {
        return unsubscriptionOk;
    }

    public void setUnsubscriptionOk(boolean unsubscriptionOk) {
        this.unsubscriptionOk = unsubscriptionOk;
    }
// </editor-fold>    

}
