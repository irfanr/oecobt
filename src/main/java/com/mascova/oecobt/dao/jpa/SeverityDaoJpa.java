/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mascova.oecobt.dao.jpa;

import com.mascova.oecobt.dao.SeverityDao;
import com.mascova.oecobt.entity.Severity;
import java.io.Serializable;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author irfan
 */
@Stateless
public class SeverityDaoJpa implements Serializable, SeverityDao {

    @PersistenceContext(unitName = "oecobtPU")
    private EntityManager em;

    public SeverityDaoJpa() {
    }

    public SeverityDaoJpa(EntityManager em) {
        this.em = em;
    }

    @Override
    public int getCount() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void create(Severity severity) {
        em.persist(severity);
    }

    @Override
    public Severity find(Integer id) {
        return em.find(Severity.class, id);
    }

    @Override
    public void edit(Severity severity) {
        em.merge(severity);
    }

    @Override
    public void delete(Severity severity) {
        em.merge(severity);
        em.remove(severity);
    }

    @Override
    public void delete(int id) {
        Severity severity = em.find(Severity.class, id);
        em.remove(severity);
    }

    @Override
    public List<Severity> search() {
        return em.createQuery("select s from Severity s").getResultList();
    }

    @Override
    public List<Severity> search(int maxResults, int firstResult) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
