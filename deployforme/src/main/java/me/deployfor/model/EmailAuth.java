/*
 * The MIT License
 *
 * Copyright 2016, Juliano Macedo.
 * See LICENSE file for details.
 *
 */
package me.deployfor.model;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;

/**
 * <p>
 * Classe responsável por manter o objeto que contem as informações de
 * autenticação do <i>email</i> do sistema.</p>
 *
 * @author Juliano Macedo  < /JulianoR at GitHub and Bitbucket >
 * @since 2016.07.30, 1:11:10 AM
 * @version 0.1
 */
@Entity
public class EmailAuth {

    @Id
    private ObjectId id;
    private String email;
    private String passphrase;

    public EmailAuth() {
    }

    public EmailAuth(String email, String passphrase) {
        this.email = email;
        this.passphrase = passphrase;
    }

    public ObjectId getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassphrase() {
        return passphrase;
    }

    public void setPassphrase(String passphrase) {
        this.passphrase = passphrase;
    }

}
