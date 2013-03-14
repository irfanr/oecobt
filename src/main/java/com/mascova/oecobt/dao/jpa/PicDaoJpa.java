/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mascova.oecobt.dao.jpa;

import com.mascova.oecobt.dao.PicDao;
import com.mascova.oecobt.entity.Defect;
import com.mascova.oecobt.entity.Pic;
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
public class PicDaoJpa implements Serializable, PicDao {

    @PersistenceContext(unitName = "oecobtPU")
    private EntityManager em;

    public PicDaoJpa() {
    }

    public PicDaoJpa(EntityManager em) {
        this.em = em;
    }

    @Override
    public int getCount() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void create(Pic pic) {
        em.persist(pic);
    }

    @Override
    public Pic find(Integer id) {
        return em.find(Pic.class, id);
    }

    @Override
    public void edit(Pic pic) {
        em.merge(pic);
    }

    @Override
    public void delete(Pic pic) {
        em.merge(pic);
        em.remove(pic);
    }

    @Override
    public void delete(int id) {
        Pic pic = em.find(Pic.class, id);
        em.remove(pic);
    }

    @Override
    public List<Pic> search() {
        return em.createQuery("select p from Pic p").getResultList();
    }

    @Override
    public List<Pic> search(int maxResults, int firstResult) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
