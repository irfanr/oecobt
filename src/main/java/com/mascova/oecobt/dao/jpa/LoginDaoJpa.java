/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mascova.oecobt.dao.jpa;

import com.mascova.oecobt.dao.LoginDao;
import com.mascova.oecobt.entity.Login;
import com.mascova.oecobt.entity.Pic;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author irfan
 */
@Stateless
public class LoginDaoJpa implements LoginDao{

    @PersistenceContext(unitName = "oecobtPU")
    private EntityManager em;

    public LoginDaoJpa() {
    }

    public LoginDaoJpa(EntityManager em) {
        this.em = em;
    }

    @Override
    public int getCount() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void create(Login login) {
        Pic pic = login.getPic();
        em.persist(pic);
        em.persist(login);
    }

    @Override
    public Login find(Integer id) {
        return em.find(Login.class, id);
    }

    @Override
    public void edit(Login login) {
        em.merge(login);
    }

    @Override
    public void delete(Login login) {
        em.merge(login);
        em.remove(login);
    }

    @Override
    public void delete(int id) {
        Login login = em.find(Login.class, id);
        em.remove(login);
    }

    @Override
    public List<Login> search() {
        TypedQuery<Login> typedQuery = em.createNamedQuery(Login.FIND_ALL, Login.class);
        return typedQuery.getResultList();
    }

    @Override
    public List<Login> search(int maxResults, int firstResult) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
