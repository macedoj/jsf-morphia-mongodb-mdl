/*
 * The MIT License
 *
 * Copyright 2016, Juliano Macedo.
 * See LICENSE file for details.
 *
 */
package me.deployfor.dao;

import com.mongodb.MongoClient;
import me.deployfor.model.Answer;
import org.bson.types.ObjectId;
import org.mongodb.morphia.Key;
import org.mongodb.morphia.Morphia;
import org.mongodb.morphia.dao.BasicDAO;
import org.mongodb.morphia.query.Query;

/**
 * <p>
 * Classe responsável por manipular os dados do tipo <code>Answer</code> na base
 * de dados.
 * </p>p>
 *
 * @author Juliano Macedo  < /JulianoR at GitHub and Bitbucket >
 * @since 2016.07.29, 3:43:45 PM
 * @version 0.1
 */
public class AnswerDAO extends BasicDAO<Answer, ObjectId> {

    private Query<Answer> query = null;

    public AnswerDAO(MongoClient mongoClient, Morphia morphia, String dbName) {
        super(mongoClient, morphia, dbName);
        query = new Morphia().createDatastore(mongoClient, dbName).createQuery(Answer.class);
    }

    /**
     * <p>
     * Método responsável por inserir na base de dados um nova resposta ao
     * <i>Survey</i>. Um mesmo usuário pode responder o questionário quantas
     * vezes ele desejar.</p>
     *
     * @param entity do tipo <code>Answer</code>
     * @return 
     */
    public boolean insert(Answer entity) {
        Key<Answer> saved = super.save(entity);
        return saved != null;
    }

    /**
     * <p>
     * Método para procurar na base de dados uma resposta que corresponda ao
     * <code>Id</code> recebido por parâmetro.</p>
     *
     * @param id do tipo <code>ObjectId</code>
     * @return Objeto do tipo <code>Answer</code> contendo o resultado da busca.
     */
    public Answer queryByKey(ObjectId id) {
        query.field("id").equal(id);
        return super.findOne(query);
    }

    /**
     * <p>
     * Método para procurar na base de dados uma resposta que corresponda ao
     * <code>Email</code> recebido por parâmetro.</p>
     *
     * @param email do tipo <code>String</code>
     * @return Objeto do tipo <code>Answer</code> contendo o resultado da busca.
     */
    public Answer queryByEmail(String email) {
        query.field("email").equal(email);
        return super.findOne(query);
    }

    /**
     * <p>
     * Método responsável por remover todas as respostas de uma determinada
     * pessoa. <i>Atualmente utilizado unicamente nos métodos de teste.</i></p>
     *
     * @param email do tipo <code>String</code>
     * @return <code>true</code> se as respostas foram removidas com sucesso,
     * <code>false</code> para todos os demais casos.
     */
    public boolean removeByEmail(String email) {
        if (queryByEmail(email) != null) {
            query.field("email").equal(email);
            super.deleteByQuery(query);
            return true;
        }
        return false;
    }

}
