/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mascova.oecobt.jsf;

import com.mascova.oecobt.entity.Login;
import com.mascova.oecobt.entity.Pic;
import com.mascova.oecobt.service.LoginService;
import com.mascova.oecobt.service.PicService;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

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
    private void init(){
        
        login = new Login();
        login.setPic( new Pic() );
        
    }
    
    public void register(){
        
        loginService.register(login);
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
