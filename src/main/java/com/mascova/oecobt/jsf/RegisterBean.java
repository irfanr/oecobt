/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mascova.oecobt.jsf;

import com.mascova.oecobt.entity.Login;
import com.mascova.oecobt.entity.Pic;
import com.mascova.oecobt.service.LoginService;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.apache.commons.lang3.StringUtils;

/**
 *
 * @author irfan
 */
@ManagedBean
@ViewScoped
public class RegisterBean {

    @EJB
    private LoginService loginService;
    private Login login;

    /**
     * Creates a new instance of RegisterBean
     */
    public RegisterBean() {
    }

    @PostConstruct
    private void init() {

        setDefaultValues();

    }

    private void setDefaultValues() {
        login = new Login();
        login.setPic(new Pic());
    }

    public void register() {

        loginService.register(login);
        setDefaultValues();


    }

    /**
     * @return the login
     */
    public Login getLogin() {
        return login;
    }

    /**
     * @param login the login to set
     */
    public void setLogin(Login login) {
        this.login = login;
    }
}
