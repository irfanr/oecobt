/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mascova.oecobt.jsf.enumeration;

/**
 *
 * @author irfan
 */
public enum Page {

    DEFECT(0), STATUS(1), SEVERITY(2), PRIORITY(3), PIC(4);
    
    private int pageCode;

    private Page(int pageCode) {
        this.pageCode = pageCode;
    }

    /**
     * @return the pageCode
     */
    public int getPageCode() {
        return pageCode;
    }

    /**
     * @param pageCode the pageCode to set
     */
    public void setPageCode(int pageCode) {
        this.pageCode = pageCode;
    }
}
