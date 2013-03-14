/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mascova.oecobt.service;

import com.mascova.oecobt.dao.StatusDao;
import com.mascova.oecobt.entity.Status;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author irfan
 */
@Stateless
public class StatusService {

    @EJB
    StatusDao statusDao;
    
    public int getCountStatus() {
        return statusDao.getCount();
    }
    
    public void createStatus(Status status) {
        statusDao.create(status);
    }
    
    public Status findStatus(Integer id) {
        return statusDao.find(id);
    }

    
    public void editStatus(Status status) {
        statusDao.edit(status);
    }

    
    public void deleteStatus(Status status) {
        statusDao.delete(status.getId());
    }

    
    public void deleteStatus(int id) {
        statusDao.delete(id);
    }

    
    public List<Status> searchStatus() {
        return statusDao.search();
    }

    
    public List<Status> searchStatus(int maxResults, int firstResult) {
        return statusDao.search(maxResults, firstResult);
    }    
}
