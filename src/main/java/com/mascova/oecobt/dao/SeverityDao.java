/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mascova.oecobt.dao;

import com.mascova.oecobt.entity.Severity;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author irfan
 */
@Local
public interface SeverityDao {

    int getCount();

    void create(Severity severity);

    Severity find(Integer id);

    void edit(Severity severity);

    void delete(Severity severity);

    void delete(int id);

    List<Severity> search();

    List<Severity> search(int maxResults, int firstResult);
}
