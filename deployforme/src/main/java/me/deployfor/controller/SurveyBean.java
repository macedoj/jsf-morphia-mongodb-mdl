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
import me.deployfor.dao.AnswerDAO;
import me.deployfor.model.Answer;
import org.mongodb.morphia.Morphia;
import util.MongoUtil;

/**
 * <p>
 * Classe responsável por manipular as respostas do usuário e persisti-las na
 * base de dados.</p>
 *
 * @author Juliano Macedo  < /JulianoR at GitHub and Bitbucket >
 * @since 2016.07.23, 5:36:38 AM
 * @version 0.1
 */
@RequestScoped
@Named
public class SurveyBean implements Serializable {

    private String answer1;
    private String answer2;
    private String answer3;
    private String answer4;
    /**
     * Inicial o sistema projetado para registrar a autoria das respostas, mas
     * ao pesquisa sobre, descobri que respostas em modo anônimo aumentam a o
     * engajamento e a honestidade das respostas.
     *
     * @deprecated o email não mais é utilizado para identificar o autor das
     * respostas.
     */
    @Deprecated
    private String email;
    private boolean answerSavedOk;
    private final MongoClient mongo;
    private final Morphia morphia;

    public SurveyBean() {
        mongo = MongoUtil.getMongoConnection();
        morphia = new Morphia();
        morphia.map(Answer.class);
        email = "";
        answerSavedOk = false;
    }

    @Deprecated
    public SurveyBean(String email) {
        mongo = MongoUtil.getMongoConnection();
        morphia = new Morphia();
        morphia.map(Answer.class);
        this.email = email;
    }

    /**
     * <p>
     * Método responsável por salvar as respostas no usuário na base de dados.
     * Antes do salvamento ocorrer, as respostas e o <i>email</i> do usuário são
     * validados.
     * </p>
     *
     */
    public void saveSurveyAnswers() {
        if (getAnswerValidation()) {
            try {
                AnswerDAO adao = new AnswerDAO(mongo, morphia, MongoUtil.getDBName());

                Answer a1 = new Answer(1, answer1, email);
                adao.insert(a1);

                Answer a2 = new Answer(2, answer2, email);
                adao.insert(a2);

                Answer a3 = new Answer(3, answer3, email);
                adao.insert(a3);

                Answer a4 = new Answer(4, answer4, email);
                answerSavedOk = adao.insert(a4);
            } catch (Exception ex) {
                Logger.getLogger(SurveyBean.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

// <editor-fold defaultstate="collapsed" desc="Getters, Setters and Validations">    
    /**
     * <p>
     * Método responsável por validar se o valor atual das variáveis
     * <i>answer</i> não é vazio ou nullo, pois eles não são permitidos.</p>
     *
     * @return <code>true</code> se o valor das variáveis <i>answer</i> não é
     * vazio ou nulo, <code>false</code> para todos os demais casos.
     */
    private boolean getAnswerValidation() {
        return (answer1 != null && answer2 != null && answer3 != null && answer4 != null)
                && (!answer1.isEmpty() && !answer2.isEmpty() && !answer3.isEmpty() && !answer4.isEmpty());
    }

    /**
     * <p>
     * Método responsável por validar se o valor atual da variável <i>email</i>
     * não é vazio ou nullo, pois eles não são permitidos.</p>
     *
     * @return <code>true</code> se o valor da variável <i>email</i> não é vazio
     * ou nulo, <code>false</code> para todos os demais casos.
     */
//    @Deprecated
//    private boolean getEmailValidation() {
//        return (email != null)
//                && (!email.isEmpty());
//    }
    public String getAnswer1() {
        return answer1;
    }

    public void setAnswer1(String answer1) {
        this.answer1 = answer1;
    }

    public String getAnswer2() {
        return answer2;
    }

    public void setAnswer2(String answer2) {
        this.answer2 = answer2;
    }

    public String getAnswer3() {
        return answer3;
    }

    public void setAnswer3(String answer3) {
        this.answer3 = answer3;
    }

    public String getAnswer4() {
        return answer4;
    }

    public void setAnswer4(String answer4) {
        this.answer4 = answer4;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isAnswerSavedOk() {
        return answerSavedOk;
    }

    public void setAnswerSavedOk(boolean answerSavedOk) {
        this.answerSavedOk = answerSavedOk;
    }
// </editor-fold>    

}
