/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mascova.oecobt.service;

import com.mascova.oecobt.dao.LoginDao;
import com.mascova.oecobt.entity.Login;
import com.mascova.oecobt.entity.Pic;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

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
    
    public void register(Login login){        
        loginDao.create(login);
    }
}
