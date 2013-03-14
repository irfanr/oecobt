/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mascova.oecobt.service;

import com.mascova.oecobt.dao.PriorityDao;
import com.mascova.oecobt.entity.Priority;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author irfan
 */
@Stateless
public class PriorityService {

    @EJB
    PriorityDao priorityDao;
    
    public int getCountPriority() {
        return priorityDao.getCount();
    }
    
    public void createPriority(Priority priority) {
        priorityDao.create(priority);
    }
    
    public Priority findPriority(Integer id) {
        return priorityDao.find(id);
    }

    
    public void editPriority(Priority priority) {
        priorityDao.edit(priority);
    }

    
    public void deletePriority(Priority priority) {
        priorityDao.delete(priority.getId());
    }

    
    public void deletePriority(int id) {
        priorityDao.delete(id);
    }

    
    public List<Priority> searchPriority() {
        return priorityDao.search();
    }

    
    public List<Priority> searchPriority(int maxResults, int firstResult) {
        return priorityDao.search(maxResults, firstResult);
    }    
}
