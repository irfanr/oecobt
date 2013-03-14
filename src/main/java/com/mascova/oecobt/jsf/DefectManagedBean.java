/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mascova.oecobt.jsf;

import com.mascova.oecobt.entity.Defect;
import com.mascova.oecobt.service.DefectService;
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
public class DefectManagedBean implements Serializable {

    public static final String FORM_TABLE_ID = "formDefectTable";
    public static final String FORM_DETAIL_ID = "formDefectFields";
    @EJB
    private DefectService defectService;
    private List<Defect> defects;
    private Defect defect;

    /**
     * Creates a new instance of DefectManagedBean
     */
    public DefectManagedBean() {
    }

    @PostConstruct
    public void init() {

        defects = defectService.searchDefect();
        defect = new Defect();

    }

    public void prepareFormAdd() {

        this.defect = new Defect();

        // Scroll to form 
        scrollToForm(FORM_DETAIL_ID);
    }

    /*
     *  Add Defect ActionListener
     */
    public void addDefect() {

        System.out.println("Add Defect");
        defectService.createDefect(defect);

        defects = defectService.searchDefect();

        prepareFormEdit(defect);
    }

    public void prepareFormEdit(Defect editedDefect) {

        this.defect = defectService.findDefect(editedDefect.getId());

        scrollToForm(FORM_DETAIL_ID);

    }

    /*
     *  Edit Defect ActionListener
     */
    public void editDefect() {

        System.out.println("Edit Defect");
        defectService.editDefect(defect);

        defects = defectService.searchDefect();

        prepareFormEdit(defect);
    }

    public void prepareDelete(Defect deletedDefect) {

        this.defect = deletedDefect;

    }

    /*
     *  Delete Defect ActionListener
     */
    public void deleteDefect() {

        System.out.println("Delete Defect");
        defectService.deleteDefect(defect);

        defects = defectService.searchDefect();

        prepareFormAdd();

//        scrollToForm(FORM_TABLE_ID);
    }

    private void scrollToForm(String componentId) {
        // Scroll to form 
        RequestContext.getCurrentInstance().scrollTo(componentId);
    }

    /**
     * @return the defects
     */
    public List<Defect> getDefects() {
        return defects;
    }

    /**
     * @param defects the defects to set
     */
    public void setDefects(List<Defect> defects) {
        this.defects = defects;
    }

    /**
     * @return the defect
     */
    public Defect getDefect() {
        return defect;
    }

    /**
     * @param defect the defect to set
     */
    public void setDefect(Defect defect) {
        this.defect = defect;
    }
}
