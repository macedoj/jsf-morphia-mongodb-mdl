/*
 * The MIT License
 *
 * Copyright 2016, Juliano Macedo.
 * See LICENSE file for details.
 *
 */
package me.deployfor.dao;

import com.mongodb.MongoClient;
import me.deployfor.model.EmailAuth;
import org.bson.types.ObjectId;
import org.mongodb.morphia.Morphia;
import org.mongodb.morphia.dao.BasicDAO;
import org.mongodb.morphia.query.Query;
import org.mongodb.morphia.query.QueryResults;

/**
 * <p>
 * Classe responsável por recuperar da base de dados, as informações do <i>email</i> do sistema.  </p>
 *
 * @author Juliano Macedo  < /JulianoR at GitHub and Bitbucket >
 * @since 2016.07.30, 1:18:29 AM
 * @version 0.1
 */
public class EmailAuthDAO extends BasicDAO<EmailAuth, ObjectId> {

    private Query<EmailAuth> query = null;

    public EmailAuthDAO(MongoClient mongoClient, Morphia morphia, String dbName) {
        super(mongoClient, morphia, dbName);
        query = new Morphia().createDatastore(mongoClient, dbName).createQuery(EmailAuth.class);
    }

    /**
     * <p>
     * Método para procurar na base de dados as informações de autenticação do
     * <i>email</i> do sistema.</p>
     *
     * @return  <code>ArrayList</code> do tipo <code>EmailAuth</code> contendo o
     * resultado da busca.
     */
    public QueryResults<EmailAuth> queryRetrieveAllEmails() {
        return super.find();
    }

    /**
     * <p>
     * Método para procurar na base de dados as informações de autenticação do
     * <i>email</i> recebido por parâmetro.</p>
     *
     * @param email do tipo <code>String</code>
     * @return Objeto do tipo <code>EmailAuth</code> contendo o resultado da
     * busca.
     */
    public EmailAuth queryByEmail(String email) {
        query.field("email").equal(email);
        return super.findOne(query);
    }

}
