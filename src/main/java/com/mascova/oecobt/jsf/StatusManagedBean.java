/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mascova.oecobt.jsf;

import com.mascova.oecobt.entity.Status;
import com.mascova.oecobt.service.StatusService;
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
public class StatusManagedBean implements Serializable {

    public static final String FORM_TABLE_ID = "formStatusTable";
    public static final String FORM_DETAIL_ID = "formStatusFields";
    @EJB
    private StatusService statusService;
    private List<Status> statuses;
    private Status status;

    /**
     * Creates a new instance of StatusManagedBean
     */
    public StatusManagedBean() {
    }

    @PostConstruct
    public void init() {

        statuses = statusService.searchStatus();
        status = new Status();

    }

    public void prepareFormAdd() {

        this.status = new Status();

        // Scroll to form 
        scrollToForm(FORM_DETAIL_ID);
    }

    /*
     *  Add Status ActionListener
     */
    public void addStatus() {

        System.out.println("Add Status");
        statusService.createStatus(status);

        statuses = statusService.searchStatus();

        prepareFormEdit(status);
    }

    public void prepareFormEdit(Status editedStatus) {

        this.status = statusService.findStatus(editedStatus.getId());

        scrollToForm(FORM_DETAIL_ID);

    }

    /*
     *  Edit Status ActionListener
     */
    public void editStatus() {

        System.out.println("Edit Status");
        statusService.editStatus(status);

        statuses = statusService.searchStatus();

        prepareFormEdit(status);
    }

    public void prepareDelete(Status deletedStatus) {

        this.status = deletedStatus;

    }

    /*
     *  Delete Status ActionListener
     */
    public void deleteStatus() {

        System.out.println("Delete Status");
        statusService.deleteStatus(status);

        statuses = statusService.searchStatus();

        prepareFormAdd();

//        scrollToForm(FORM_TABLE_ID);
    }

    private void scrollToForm(String componentId) {
        // Scroll to form 
        RequestContext.getCurrentInstance().scrollTo(componentId);
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
     * @return the status
     */
    public Status getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(Status status) {
        this.status = status;
    }
}
