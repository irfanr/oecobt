/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mascova.oecobt.jsf;

import com.mascova.oecobt.entity.Pic;
import com.mascova.oecobt.service.PicService;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.primefaces.context.RequestContext;

/**
 *
 * @author irfan
 */
@ManagedBean
@ViewScoped
public class PicManagedBean implements Serializable {

    public static final String FORM_TABLE_ID = "formPicTable";
    public static final String FORM_DETAIL_ID = "formPicFields";
    @EJB
    private PicService picService;
    private List<Pic> pics;
    private Pic pic;

    /**
     * Creates a new instance of PicManagedBean
     */
    public PicManagedBean() {
    }

    @PostConstruct
    public void init() {

        pics = picService.searchPic();
        pic = new Pic();

    }

    public void prepareFormAdd() {

        this.pic = new Pic();

        // Scroll to form 
        scrollToForm(FORM_DETAIL_ID);
    }

    /*
     *  Add Pic ActionListener
     */
    public void addPic() {

        System.out.println("Add Pic");
        picService.createPic(pic);

        pics = picService.searchPic();

        prepareFormEdit(pic);
    }

    public void prepareFormEdit(Pic editedPic) {

        this.pic = picService.findPic(editedPic.getId());

        scrollToForm(FORM_DETAIL_ID);

    }

    /*
     *  Edit Pic ActionListener
     */
    public void editPic() {

        System.out.println("Edit Pic");
        picService.editPic(pic);

        pics = picService.searchPic();

        prepareFormEdit(pic);
    }

    public void prepareDelete(Pic deletedPic) {

        this.pic = deletedPic;

    }

    /*
     *  Delete Pic ActionListener
     */
    public void deletePic() {

        System.out.println("Delete Pic");
        picService.deletePic(pic);

        pics = picService.searchPic();

        prepareFormAdd();

//        scrollToForm(FORM_TABLE_ID);
    }

    private void scrollToForm(String componentId) {
        // Scroll to form 
        RequestContext.getCurrentInstance().scrollTo(componentId);
    }

    /**
     * @return the pics
     */
    public List<Pic> getPics() {
        return pics;
    }

    /**
     * @param pics the pics to set
     */
    public void setPics(List<Pic> pics) {
        this.pics = pics;
    }

    /**
     * @return the pic
     */
    public Pic getPic() {
        return pic;
    }

    /**
     * @param pic the pic to set
     */
    public void setPic(Pic pic) {
        this.pic = pic;
    }
}
