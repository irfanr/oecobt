/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mascova.oecobt.service;

import com.mascova.oecobt.dao.SeverityDao;
import com.mascova.oecobt.entity.Severity;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author irfan
 */
@Stateless
public class SeverityService {

    @EJB
    SeverityDao severityDao;
    
    public int getCountSeverity() {
        return severityDao.getCount();
    }
    
    public void createSeverity(Severity severity) {
        severityDao.create(severity);
    }
    
    public Severity findSeverity(Integer id) {
        return severityDao.find(id);
    }

    
    public void editSeverity(Severity severity) {
        severityDao.edit(severity);
    }

    
    public void deleteSeverity(Severity severity) {
        severityDao.delete(severity.getId());
    }

    
    public void deleteSeverity(int id) {
        severityDao.delete(id);
    }

    
    public List<Severity> searchSeverity() {
        return severityDao.search();
    }

    
    public List<Severity> searchSeverity(int maxResults, int firstResult) {
        return severityDao.search(maxResults, firstResult);
    }    
}
