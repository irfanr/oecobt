/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mascova.oecobt.dao.jpa;

import com.mascova.oecobt.dao.DefectDao;
import com.mascova.oecobt.entity.Defect;
import java.io.Serializable;
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
public class DefectDaoJpa implements Serializable, DefectDao {

    @PersistenceContext(unitName = "oecobtPU")
    private EntityManager em;

    public DefectDaoJpa() {
    }

    public DefectDaoJpa(EntityManager em) {
        this.em = em;
    }

    @Override
    public int getCount() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void create(Defect defect) {
        em.persist(defect);
    }

    @Override
    public Defect find(Integer id) {
        return em.find(Defect.class, id);
    }

    @Override
    public void edit(Defect defect) {
        em.merge(defect);
    }

    @Override
    public void delete(Defect defect) {
        em.merge(defect);
        em.remove(defect);
    }

    @Override
    public void delete(int id) {
        Defect defect = em.find(Defect.class, id);
        em.remove(defect);
    }

    @Override
    public List<Defect> search() {
        TypedQuery<Defect> typedQuery = em.createNamedQuery(Defect.FIND_ALL, Defect.class);
        return typedQuery.getResultList();
    }

    @Override
    public List<Defect> search(int maxResults, int firstResult) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
