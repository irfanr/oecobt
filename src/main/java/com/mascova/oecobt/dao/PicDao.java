/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mascova.oecobt.dao;

import com.mascova.oecobt.entity.Pic;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author irfan
 */
@Local
public interface PicDao {

    int getCount();

    void create(Pic pic);

    Pic find(Integer id);

    void edit(Pic pic);

    void delete(Pic pic);

    void delete(int id);

    List<Pic> search();

    List<Pic> search(int maxResults, int firstResult);
}
