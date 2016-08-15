/*
 * The MIT License
 *
 * Copyright 2016, Juliano Macedo.
 * See LICENSE file for details.
 *
 */
package me.deployfor.dao;

import com.mongodb.MongoClient;
import me.deployfor.model.Person;
import org.bson.types.ObjectId;
import org.mongodb.morphia.Morphia;
import org.mongodb.morphia.dao.BasicDAO;
import org.mongodb.morphia.query.Query;
import org.mongodb.morphia.query.QueryResults;

/**
 * <p>
 * Classe responsável por manipular os dados do tipo <code>Person</code> na base
 * de dados.
 * </p>
 *
 * @author Juliano Macedo  < /JulianoR at GitHub and Bitbucket >
 * @since 2016.07.23, 8:46:31 AM
 * @version 0.1
 */
public class PersonDAO extends BasicDAO<Person, ObjectId> {

    private Query<Person> query = null;

    public PersonDAO(MongoClient mongoClient, Morphia morphia, String dbName) {
        super(mongoClient, morphia, dbName);
        query = new Morphia().createDatastore(mongoClient, dbName).createQuery(Person.class);
    }

    /**
     * <p>
     * Método responsável por inserir uma nova pessoa na base de dados, mas
     * antes de realizar essa ação, invoca uma consulta para verificar se a
     * pessoa já existe na base.
     * </p>
     *
     * @param entity
     * @return <code>true</code> se a pessoa foi cadastrada com sucesso.
     * <code>false</code> caso a pessoa já esteja registrada na base de dados.
     */
    public boolean insert(Person entity) {
        if (queryByEmail(entity.getEmail()) == null) {
            super.save(entity);
            return true;
        }
        return false;
    }

    /**
     * <p>
     * Método para procurar na base de dados uma pessoa com o mesmo
     * <code>Id</code> recebido por parâmetro.
     * </p>
     *
     * @param id do tipo <code>ObjectId</code>
     * @return Objeto do tipo <code>Person</code> contendo o resultado da busca.
     */
    public Person queryByKey(ObjectId id) {
        query.field("id").equal(id);
        return super.findOne(query);
    }

    /**
     * <p>
     * Método para procurar na base de dados uma pessoa com o mesmo
     * <i>email</i> recebido por parâmetro.</p>
     *
     * @param email do tipo <code>String</code>.
     * @return Objeto do tipo <code>Person</code> contendo o resultado da busca.
     */
    public Person queryByEmail(String email) {
        query.field("email").equal(email);
        return super.findOne(query);
    }

    /**
     * <p>
     * Método para procurar na base de dados todas as ocorrências de um usuário,
     * de acordo com o <i>email</i> recebido por parâmetro. É utilizado para
     * verifica a existência de cadastro duplicados.</p>
     *
     * @param email do tipo <code>String</code>.
     * @return Um lista de objetos do tipo <code>Person</code> contendo o
     * resultado da busca.
     */
    public QueryResults<Person> queryAllByEmail(String email) {
        query.field("email").equal(email);
        return super.find(query);
    }

    /**
     * <p>
     * Método responsável por remover uma pessoa da base de dados, antes de
     * realizar a remoção, verifica se a pessoa realmente existe na base.
     * </p>
     *
     * @param email
     * @return <code>true</code> se a pessoa foi descadastrada com sucesso,
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
