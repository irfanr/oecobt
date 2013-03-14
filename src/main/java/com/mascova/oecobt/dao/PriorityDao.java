/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mascova.oecobt.dao;

import com.mascova.oecobt.entity.Priority;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author irfan
 */
@Local
public interface PriorityDao {

    int getCount();

    void create(Priority priority);

    Priority find(Integer id);

    void edit(Priority priority);

    void delete(Priority priority);

    void delete(int id);

    List<Priority> search();

    List<Priority> search(int maxResults, int firstResult);
}
