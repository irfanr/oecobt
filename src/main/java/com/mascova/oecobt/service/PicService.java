/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mascova.oecobt.service;

import com.mascova.oecobt.dao.PicDao;
import com.mascova.oecobt.entity.Pic;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author irfan
 */
@Stateless
public class PicService {

    @EJB
    PicDao picDao;

    public int getCountPic() {
        return picDao.getCount();
    }

    public void createPic(Pic pic) {
        picDao.create(pic);
    }

    public Pic findPic(Integer id) {
        return picDao.find(id);
    }

    public void editPic(Pic pic) {
        picDao.edit(pic);
    }

    public void deletePic(Pic pic) {
        picDao.delete(pic.getId());
    }

    public void deletePic(int id) {
        picDao.delete(id);
    }

    public List<Pic> searchPic() {
        return picDao.search();
    }

    public List<Pic> searchPic(int maxResults, int firstResult) {
        return picDao.search(maxResults, firstResult);
    }
}
