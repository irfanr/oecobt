/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mascova.oecobt.jsf;

import com.mascova.oecobt.entity.Login;
import com.mascova.oecobt.entity.Pic;
import com.mascova.oecobt.exception.PasswordNotMatchException;
import com.mascova.oecobt.service.LoginService;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.security.auth.login.LoginException;

/**
 *
 * @author irfan
 */
@ManagedBean
@SessionScoped
public class LoginBean {
    
    @EJB
    private LoginService loginService;
    private Login login;
    
    @PostConstruct
    private void init() {

        setDefaultValues();

    }
    
    private void setDefaultValues() {
        login = new Login();
    }        
    
    public void doLogin(){
        try {
            loginService.login(login);
            
            doRedirect("/");
        } catch (LoginException ex) {
            Logger.getLogger(LoginBean.class.getName()).log(Level.SEVERE, null, ex);
        } catch (PasswordNotMatchException ex) {
            Logger.getLogger(LoginBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /*
     * method to getting session time FacesContext facesContext =
     * FacesContext.getCurrentInstance(); ExternalContext externalContext =
     * facesContext.getExternalContext(); HttpSession session =
     * externalContext.getSession();
     */
    private void doRedirect(String url) {
        try {
            FacesContext context = FacesContext.getCurrentInstance();
            context.getExternalContext().redirect(FacesContext.getCurrentInstance().getExternalContext().getRequestContextPath() + url);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }    

    /**
     * Creates a new instance of LoginBean
     */
    public LoginBean() {
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
