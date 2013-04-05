/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mascova.oecobt.jsf;

import com.mascova.oecobt.entity.Defect;
import com.mascova.oecobt.entity.Pic;
import com.mascova.oecobt.entity.Priority;
import com.mascova.oecobt.entity.Severity;
import com.mascova.oecobt.entity.Status;
import com.mascova.oecobt.service.DefectService;
import com.mascova.oecobt.service.PicService;
import com.mascova.oecobt.service.PriorityService;
import com.mascova.oecobt.service.SeverityService;
import com.mascova.oecobt.service.StatusService;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.joda.time.DateTime;
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
    @EJB
    private PicService picService;
    @EJB
    private StatusService statusService;
    @EJB
    private SeverityService severityService;
    @EJB
    private PriorityService priorityService;
    private List<Defect> defects;
    private Defect defect;
    private List<Pic> pics;
    private List<Status> statuses;
    private List<Severity> severities;
    private List<Priority> priorities;

    /**
     * Creates a new instance of DefectManagedBean
     */
    public DefectManagedBean() {
    }

    @PostConstruct
    public void init() {

        defects = defectService.searchDefect();
        defect = new Defect();
        pics = picService.searchPic();
        statuses = statusService.searchStatus();
        severities = severityService.searchSeverity();
        priorities = priorityService.searchPriority();
        setFormDefaultValues();

    }

    public void prepareFormAdd() {

        this.defect = new Defect();
        setFormDefaultValues();

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
     * @return the statuses
     */
    public List<Status> getStatuses() {
        return statuses;
    }

    /**
     * @param statuses the statuses to set
     */
    public void setStatuses(List<Status> statuses) {
        this.statuses = statuses;
    }

    /**
     * @return the severities
     */
    public List<Severity> getSeverities() {
        return severities;
    }

    /**
     * @param severities the severities to set
     */
    public void setSeverities(List<Severity> severities) {
        this.severities = severities;
    }

    /**
     * @return the priorities
     */
    public List<Priority> getPriorities() {
        return priorities;
    }

    /**
     * @param priorities the priorities to set
     */
    public void setPriorities(List<Priority> priorities) {
        this.priorities = priorities;
    }

    private void setFormDefaultValues() {

        // Set default value for Start Date
        DateTime dt = new DateTime();
        dt = dt.withHourOfDay(8).withMinuteOfHour(0);
        defect.setStartDate(dt.toDate());

        // Set default value for estimate
        defect.setEstimate(1.0);

        // Set default value for End Date        
        calculateEndDate();
    }

    public void calculateEndDate() {

        DateTime dt = new DateTime(defect.getStartDate());
        Double plusMinutes = defect.getEstimate() * 60;
        dt = dt.plusMinutes(plusMinutes.intValue());
        defect.setEndDate(dt.toDate());
    }
}
