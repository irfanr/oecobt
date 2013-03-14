/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mascova.oecobt.jsf;

import com.mascova.oecobt.entity.Priority;
import com.mascova.oecobt.service.PriorityService;
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
public class PriorityManagedBean implements Serializable {

    public static final String FORM_TABLE_ID = "formPriorityTable";
    public static final String FORM_DETAIL_ID = "formPriorityFields";
    @EJB
    private PriorityService priorityService;
    private List<Priority> priorities;
    private Priority priority;

    /**
     * Creates a new instance of PriorityManagedBean
     */
    public PriorityManagedBean() {
    }

    @PostConstruct
    public void init() {

        priorities = priorityService.searchPriority();
        priority = new Priority();

    }

    public void prepareFormAdd() {

        this.priority = new Priority();

        // Scroll to form 
        scrollToForm(FORM_DETAIL_ID);
    }

    /*
     *  Add Priority ActionListener
     */
    public void addPriority() {

        System.out.println("Add Priority");
        priorityService.createPriority(priority);

        priorities = priorityService.searchPriority();

        prepareFormEdit(priority);
    }

    public void prepareFormEdit(Priority editedPriority) {

        this.priority = priorityService.findPriority(editedPriority.getId());

        scrollToForm(FORM_DETAIL_ID);

    }

    /*
     *  Edit Priority ActionListener
     */
    public void editPriority() {

        System.out.println("Edit Priority");
        priorityService.editPriority(priority);

        priorities = priorityService.searchPriority();

        prepareFormEdit(priority);
    }

    public void prepareDelete(Priority deletedPriority) {

        this.priority = deletedPriority;

    }

    /*
     *  Delete Priority ActionListener
     */
    public void deletePriority() {

        System.out.println("Delete Priority");
        priorityService.deletePriority(priority);

        priorities = priorityService.searchPriority();

        prepareFormAdd();

//        scrollToForm(FORM_TABLE_ID);
    }

    private void scrollToForm(String componentId) {
        // Scroll to form 
        RequestContext.getCurrentInstance().scrollTo(componentId);
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

    /**
     * @return the priority
     */
    public Priority getPriority() {
        return priority;
    }

    /**
     * @param priority the priority to set
     */
    public void setPriority(Priority priority) {
        this.priority = priority;
    }
}
