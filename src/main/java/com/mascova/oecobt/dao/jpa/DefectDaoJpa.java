/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mascova.oecobt.dao.jpa;

import com.mascova.oecobt.dao.DefectDao;
import com.mascova.oecobt.entity.Defect;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author irfan
 */
public class DefectDaoJpa implements Serializable, DefectDao {

    @Override
    public int getCount() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void create(Defect defect) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Defect find(Integer id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void edit(Defect defect) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void delete(Defect defect) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void delete(int id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<Defect> search() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<Defect> search(int maxResults, int firstResult) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
