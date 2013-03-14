/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mascova.oecobt.jsf;

import com.mascova.oecobt.entity.Severity;
import com.mascova.oecobt.service.SeverityService;
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
public class SeverityManagedBean implements Serializable {

    public static final String FORM_TABLE_ID = "formSeverityTable";
    public static final String FORM_DETAIL_ID = "formSeverityFields";
    @EJB
    private SeverityService severityService;
    private List<Severity> severities;
    private Severity severity;

    /**
     * Creates a new instance of SeverityManagedBean
     */
    public SeverityManagedBean() {
    }

    @PostConstruct
    public void init() {

        severities = severityService.searchSeverity();
        severity = new Severity();

    }

    public void prepareFormAdd() {

        this.severity = new Severity();

        // Scroll to form 
        scrollToForm(FORM_DETAIL_ID);
    }

    /*
     *  Add Severity ActionListener
     */
    public void addSeverity() {

        System.out.println("Add Severity");
        severityService.createSeverity(severity);

        severities = severityService.searchSeverity();

        prepareFormEdit(severity);
    }

    public void prepareFormEdit(Severity editedSeverity) {

        this.severity = severityService.findSeverity(editedSeverity.getId());

        scrollToForm(FORM_DETAIL_ID);

    }

    /*
     *  Edit Severity ActionListener
     */
    public void editSeverity() {

        System.out.println("Edit Severity");
        severityService.editSeverity(severity);

        severities = severityService.searchSeverity();

        prepareFormEdit(severity);
    }

    public void prepareDelete(Severity deletedSeverity) {

        this.severity = deletedSeverity;

    }

    /*
     *  Delete Severity ActionListener
     */
    public void deleteSeverity() {

        System.out.println("Delete Severity");
        severityService.deleteSeverity(severity);

        severities = severityService.searchSeverity();

        prepareFormAdd();

//        scrollToForm(FORM_TABLE_ID);
    }

    private void scrollToForm(String componentId) {
        // Scroll to form 
        RequestContext.getCurrentInstance().scrollTo(componentId);
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
     * @return the severity
     */
    public Severity getSeverity() {
        return severity;
    }

    /**
     * @param severity the severity to set
     */
    public void setSeverity(Severity severity) {
        this.severity = severity;
    }
}
