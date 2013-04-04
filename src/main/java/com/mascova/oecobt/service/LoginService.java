/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mascova.oecobt.service;

import com.mascova.oecobt.dao.LoginDao;
import com.mascova.oecobt.entity.Login;
import com.mascova.oecobt.exception.PasswordNotMatchException;
import com.mascova.oecobt.util.OecobtDigester;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.security.auth.login.LoginException;
import org.apache.commons.lang3.StringUtils;

/**
 *
 * @author irfan
 */
@Stateless
public class LoginService {

    @EJB
    LoginDao loginDao;

    public int getCountLogin() {
        return loginDao.getCount();
    }

    public void createLogin(Login login) {
        loginDao.create(login);
    }

    public Login findLogin(Integer id) {
        return loginDao.find(id);
    }

    public void editLogin(Login login) {
        loginDao.edit(login);
    }

    public void deleteLogin(Login login) {
        loginDao.delete(login.getId());
    }

    public void deleteLogin(int id) {
        loginDao.delete(id);
    }

    public List<Login> searchLogin() {
        return loginDao.search();
    }

    public List<Login> searchLogin(int maxResults, int firstResult) {
        return loginDao.search(maxResults, firstResult);
    }

    public void register(Login login) {

        login.setPassword(OecobtDigester.hash(login.getPassword()));
        loginDao.create(login);


    }

    public Login login(Login login) throws LoginException, PasswordNotMatchException {

        Login loginFromDb = loginDao.findByLogin(login.getLogin());

        if (loginFromDb != null) {
            
            if( StringUtils.equals(loginFromDb.getPassword(), OecobtDigester.hash(login.getPassword())) ){
                return loginFromDb;
            }
            else{
                throw new PasswordNotMatchException("Password Not Match");
            }
            
        } else {
            throw new LoginException("Authentication failed");
        }

    }
}
