/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mascova.oecobt.dao;

import com.mascova.oecobt.entity.Login;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author irfan
 */
@Local
public interface LoginDao {

    int getCount();

    void create(Login login);

    Login find(Integer id);

    Login findByLogin(String login);

    void edit(Login login);

    void delete(Login login);

    void delete(int id);

    List<Login> search();

    List<Login> search(int maxResults, int firstResult);
}
