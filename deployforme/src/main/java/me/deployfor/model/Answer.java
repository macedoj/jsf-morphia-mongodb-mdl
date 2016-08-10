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
 * Classe responsável por manter o objeto que contem as respostas de cada
 * usuário, referente ao questionário do sistema.
 * </p>
 *
 * @author Juliano Macedo  < /JulianoR at GitHub and Bitbucket >
 * @since 2016.07.29, 1:20:38 PM
 * @version 0.1
 */
@Entity
public class Answer {

    @Id
    private ObjectId id;
    private int questionNumber;
    private String answer;
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

    public Answer(int questionNumber, String answer, String email) {
        this.questionNumber = questionNumber;
        this.answer = answer;
        this.email = email;
    }

    public Answer() {
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public int getQuestionNumber() {
        return questionNumber;
    }

    public void setQuestionNumber(int questionNumber) {
        this.questionNumber = questionNumber;
    }

    public ObjectId getId() {
        return id;
    }

    /**
     *
     * @param email the value of email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     *
     * @return
     */
    public String getEmail() {
        return email;
    }
}
