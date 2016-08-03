/*
 * The MIT License
 *
 * Copyright 2016, Juliano Macedo.
 * See LICENSE file for details.
 *
 */
package util;

import com.mongodb.MongoClient;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import me.deployfor.dao.EmailAuthDAO;
import me.deployfor.model.EmailAuth;
import me.deployfor.model.Person;
import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.HtmlEmail;
import org.mongodb.morphia.Morphia;
import org.mongodb.morphia.query.QueryResults;

/**
 * <p>
 * Classe responsável por manipular o envio de <i>emails</i> no sistema.</p>
 *
 * @author Juliano Macedo  < /JulianoR at GitHub and Bitbucket >
 * @since 2016.07.30, 1:37:11 AM
 * @version 0.1
 */
public class EmailUtil {

    private static String email;
    private static String passphrase;
    private static EmailAuthDAO emailDAO;

    public EmailUtil(MongoClient mongo, Morphia morphia) {
        emailDAO = new EmailAuthDAO(mongo, morphia, MongoUtil.getDBName());
        email = "";
        passphrase = "";
        loadEmailAuth();
    }

    /**
     * <p>
     * Método responsável por autenticar com o servidor de <i>email</i> e enviar
     * a mensagem ao usuário conforme necessário.
     * </p>
     *
     * @param person - O usuário que receberá o <i>email</i> do sistema. [Objeto
     * do tipo <code>Person</code>]
     */
    public void sendEmail(Person person) {
        if (person != null) {
            try {
                HtmlEmail htmlmail = new HtmlEmail();
                htmlmail.setHostName("smtp.googlemail.com");
                htmlmail.setSmtpPort(587);
                htmlmail.setAuthenticator(
                        new DefaultAuthenticator(getEmail(), getPassphrase())
                );
                htmlmail.setStartTLSEnabled(true);
                htmlmail.setFrom(getEmail(), "DeployFor.Me");
                htmlmail.setSubject("Oba, a DeployFor.Me espera por você =)");

                htmlmail.setHtmlMsg(getEmailMsg(person.getName()));
                htmlmail.addTo(person.getEmail(), person.getName());

                htmlmail.send();

            } catch (Exception ex) {
                Logger.getLogger(EmailUtil.class.getName()).log(Level.SEVERE, null, ex);

            }
        }
    }

// <editor-fold defaultstate="collapsed" desc="Message builder, Loader, Getter and Setter.">     
    /**
     * <p>
     * Método responsável por retornar a mensagem que será enviada no corpo do
     * <i>email</i>. Criado para manter uma melhor organização do código na
     * classe.
     * </p>
     *
     * @return A mensagem a ser enviada no <i>email</i>. [Objeto do tipo
     * <code>String</code>]
     */
    private String getEmailMsg(String userName) {
        StringBuilder emailmsg = new StringBuilder();

        // <editor-fold defaultstate="collapsed" desc="Email message"> 
        emailmsg.append("﻿<!DOCTYPE html>\n"
                + "<html lang=\"pt-br\">\n"
                + "    <head>\n"
                + "        <meta charset=\"utf-8\"/>\n"
                + "        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\"/>\n"
                + "    </head>\n"
                + "    <body>\n"
                + "        <div style=\"width: 15%;\">\n"
                + "        </div>\n"
                + "        <div style=\"display: inline; text-align: center; width: 70%; padding: 19px; margin-bottom: 20px;\">\n"
                + "            <h2>Seja bem-vindo ").append(userName).append("!</h2>\n"
                + "            <form>\n"
                + "                <div style=\"margin-bottom: 15px;\">\n"
                + "                    <br/>\n"
                + "                    <p>Lhe manteremos atualizado até o lançamento oficial do <strong>DeployFor.Me!</strong>.\n"
                + "                        <br/>\n"
                + "                        <br/>Mas antes disso queremos ouvir a sua opinião ;)</p>\n"
                + "                    <br/>\n"
                + "                    <br/>\n"
                + "                    <a style=\"padding: 15px; color: #ffffff; background-color: #3fb618; border-color: #3fb618;\" href=\"http://localhost:8080/deployforme/view/survey.jsf\">\n"
                + "                        <strong>Opinar</strong>\n"
                + "                    </a>\n"
                + "                    <p>\n"
                + "                        <br/>\n"
                + "                        <br/>\n"
                + "                        Até breve :)\n"
                + "                    </p>\n"
                + "                    <footer>\n"
                + "                        <nav>\n"
                + "                            <hr>\n"
                + "                            <p>\n"
                + "                                <small>\n"
                + "                                    Caso não deseje mais receber nossos emails, clique aqui \n"
                + "                                    <a href=\"http://localhost:8080/deployforme/view/unsubscribe.jsf\">\n"
                + "                                        unsubscribe\n"
                + "                                    </a>\n"
                + "                                </small>\n"
                + "                            </p>\n"
                + "                            <hr>\n"
                + "                        </nav>\n"
                + "                    </footer>\n"
                + "                </div>\n"
                + "            </form>\n"
                + "        </div>\n"
                + "        <div style=\"width: 15%;\"></div>\n"
                + "    </body>\n"
                + "</html>");

        // </editor-fold>
        return emailmsg.toString();
    }

    /**
     * <p>
     * Método para recuperar e carregar nas devidas variáveis, as informações de
     * autenticação do
     * <i>email</i> do sistema.</p>
     *
     */
    private void loadEmailAuth() {
        QueryResults<EmailAuth> queryByEmail = emailDAO.queryRetrieveAllEmails();
        List<EmailAuth> asList = queryByEmail.asList();
        if (!asList.isEmpty()) {
            for (EmailAuth emailAuth : asList) {
                email = emailAuth.getEmail();
                passphrase = emailAuth.getPassphrase();
                break;
            }
        }
    }

    /**
     *
     * @return A senha do <i>email</i> do sistema. [Objeto do tipo
     * <code>String</code>]
     */
    private static String getPassphrase() {
        return passphrase;
    }

    /**
     *
     * @return O <i>email</i> do sistema. [Objeto do tipo <code>String</code>]
     */
    private static String getEmail() {
        return email;
    }

    // </editor-fold>
}
