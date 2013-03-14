/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mascova.oecobt.dao.jpa;

import com.mascova.oecobt.dao.PriorityDao;
import com.mascova.oecobt.entity.Priority;
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
public class PriorityDaoJpa implements Serializable, PriorityDao {

    @PersistenceContext(unitName = "oecobtPU")
    private EntityManager em;

    public PriorityDaoJpa() {
    }

    public PriorityDaoJpa(EntityManager em) {
        this.em = em;
    }

    @Override
    public int getCount() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void create(Priority priority) {
        em.persist(priority);
    }

    @Override
    public Priority find(Integer id) {
        return em.find(Priority.class, id);
    }

    @Override
    public void edit(Priority priority) {
        em.merge(priority);
    }

    @Override
    public void delete(Priority priority) {
        em.merge(priority);
        em.remove(priority);
    }

    @Override
    public void delete(int id) {
        Priority priority = em.find(Priority.class, id);
        em.remove(priority);
    }

    @Override
    public List<Priority> search() {
        return em.createQuery("select p from Priority p").getResultList();
    }

    @Override
    public List<Priority> search(int maxResults, int firstResult) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
