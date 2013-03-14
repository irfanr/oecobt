/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mascova.oecobt.dao.jpa;

import com.mascova.oecobt.dao.StatusDao;
import com.mascova.oecobt.entity.Status;
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
public class StatusDaoJpa implements Serializable, StatusDao {

    @PersistenceContext(unitName = "oecobtPU")
    private EntityManager em;

    public StatusDaoJpa() {
    }

    public StatusDaoJpa(EntityManager em) {
        this.em = em;
    }

    @Override
    public int getCount() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void create(Status status) {
        em.persist(status);
    }

    @Override
    public Status find(Integer id) {
        return em.find(Status.class, id);
    }

    @Override
    public void edit(Status status) {
        em.merge(status);
    }

    @Override
    public void delete(Status status) {
        em.merge(status);
        em.remove(status);
    }

    @Override
    public void delete(int id) {
        Status status = em.find(Status.class, id);
        em.remove(status);
    }

    @Override
    public List<Status> search() {
        return em.createQuery("select s from Status s").getResultList();
    }

    @Override
    public List<Status> search(int maxResults, int firstResult) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
