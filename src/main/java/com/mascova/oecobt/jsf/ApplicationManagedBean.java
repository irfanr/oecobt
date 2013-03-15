/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mascova.oecobt.jsf;

import com.mascova.oecobt.jsf.enumeration.Page;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ApplicationScoped;

/**
 *
 * @author irfan
 */
@ManagedBean
@ApplicationScoped
public class ApplicationManagedBean {
    
    private Page page;
    /**
     * Creates a new instance of ApplicationManagedBean
     */
    public ApplicationManagedBean() {
                
    }
    
    @PostConstruct
    private void init(){
        page = Page.DEFECT;
    }

    /**
     * @return the page
     */
    public int getPage() {
        return page.getPageCode();
    }

    /**
     * @param page the page to set
     */
    public void setPage(Page page) {
        this.page = page;
    }

}
