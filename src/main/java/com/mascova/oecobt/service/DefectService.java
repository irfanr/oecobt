/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mascova.oecobt.service;

import com.mascova.oecobt.dao.DefectDao;
import com.mascova.oecobt.entity.Defect;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author irfan
 */
@Stateless
public class DefectService {

    @EJB
    DefectDao defectDao;
    
    public int getCountDefect() {
        return defectDao.getCount();
    }
    
    public void createDefect(Defect defect) {
        defectDao.create(defect);
    }
    
    public Defect findDefect(Integer id) {
        return defectDao.find(id);
    }

    
    public void editDefect(Defect defect) {
        defectDao.edit(defect);
    }

    
    public void deleteDefect(Defect defect) {
        defectDao.delete(defect.getId());
    }

    
    public void deleteDefect(int id) {
        defectDao.delete(id);
    }

    
    public List<Defect> searchDefect() {
        return defectDao.search();
    }

    
    public List<Defect> searchDefect(int maxResults, int firstResult) {
        return defectDao.search(maxResults, firstResult);
    }    
}
