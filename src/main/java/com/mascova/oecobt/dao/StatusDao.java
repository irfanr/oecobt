/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mascova.oecobt.dao;

import com.mascova.oecobt.entity.Status;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author irfan
 */
@Local
public interface StatusDao {

    int getCount();

    void create(Status defect);

    Status find(Integer id);

    void edit(Status defect);

    void delete(Status defect);

    void delete(int id);

    List<Status> search();

    List<Status> search(int maxResults, int firstResult);
}
