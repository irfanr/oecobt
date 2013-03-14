/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mascova.oecobt.dao;

import com.mascova.oecobt.entity.Defect;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author irfan
 */
@Local
public interface DefectDao {

    int getCount();

    void create(Defect defect);

    Defect find(Integer id);

    void edit(Defect defect);

    void delete(Defect defect);

    void delete(int id);

    List<Defect> search();

    List<Defect> search(int maxResults, int firstResult);
}
