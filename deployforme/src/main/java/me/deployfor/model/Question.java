/*
 * The MIT License
 *
 * Copyright 2016, Juliano Macedo.
 * See LICENSE file for details.
 *
 */
package me.deployfor.model;

import java.util.HashMap;
//import org.mongodb.morphia.annotations.Embedded;

/**
 * <p>
 * Classe responsável por manter o objeto que contem as informações do
 * questionário aplicado aos usuário.</p>
 *
 * @author Juliano Macedo  < /JulianoR at GitHub and Bitbucket >
 * @since 2016.07.29, 2:05:33 PM
 * @version 0.1
 * @deprecated Classe legada por mudança na engenharia da aplicação.
 */
//@Embedded
@Deprecated
public class Question {

    private int number;
    private String title;
    private HashMap<String, String> choices;

    public Question() {
    }

    public Question(int number, String title, HashMap<String, String> choices) {
        this.number = number;
        this.title = title;
        this.choices = choices;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public HashMap<String, String> getChoices() {
        return choices;
    }

    public void setChoices(HashMap<String, String> choices) {
        this.choices = choices;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

}
