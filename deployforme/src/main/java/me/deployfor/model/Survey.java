/*
 * The MIT License
 *
 * Copyright 2016, Juliano Macedo.
 * See LICENSE file for details.
 *
 */
package me.deployfor.model;

import java.util.ArrayList;
//import org.bson.types.ObjectId;
//import org.mongodb.morphia.annotations.Embedded;
//import org.mongodb.morphia.annotations.Entity;
//import org.mongodb.morphia.annotations.Id;

/**
 * <p>
 * Classe responsável por manter o objeto que aglomera todas as informações do
 * questionário aplicado aos usuário, mantendo um  <code>ArrayList</code> com as
 * perguntas do questionário.</p>
 *
 * @author Juliano Macedo  < /JulianoR at GitHub and Bitbucket >
 * @since 2016.07.23, 8:45:35 AM
 * @version 0.1
 * @deprecated Classe legada por mudança na engenharia da aplicação.  
 */
//@Entity
@Deprecated
public class Survey {

//    @Id
//    private ObjectId id;
//    @Embedded
    private ArrayList<Question> questions;

    public Survey() {
    }

    public Survey(ArrayList<Question> questions) {
        this.questions = questions;
    }

//    public ObjectId getId() {
//        return id;
//    }
    public ArrayList<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(ArrayList<Question> questions) {
        this.questions = questions;
    }

}
