/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mascova.oecobt;

import java.io.Serializable;

/**
 *
 * @author irfan
 */
public class GanttChartValue implements Serializable{
    
    private String to;
    private String from;
    private String desc;
    private String label;
    private String customClass;

    public GanttChartValue() {
    }

    public GanttChartValue(String to, String from, String desc, String label, String customClass) {
        this.to = to;
        this.from = from;
        this.desc = desc;
        this.label = label;
        this.customClass = customClass;
    }

    /**
     * @return the to
     */
    public String getTo() {
        return to;
    }

    /**
     * @param to the to to set
     */
    public void setTo(String to) {
        this.to = to;
    }

    /**
     * @return the from
     */
    public String getFrom() {
        return from;
    }

    /**
     * @param from the from to set
     */
    public void setFrom(String from) {
        this.from = from;
    }

    /**
     * @return the desc
     */
    public String getDesc() {
        return desc;
    }

    /**
     * @param desc the desc to set
     */
    public void setDesc(String desc) {
        this.desc = desc;
    }

    /**
     * @return the label
     */
    public String getLabel() {
        return label;
    }

    /**
     * @param label the label to set
     */
    public void setLabel(String label) {
        this.label = label;
    }

    /**
     * @return the customClass
     */
    public String getCustomClass() {
        return customClass;
    }

    /**
     * @param customClass the customClass to set
     */
    public void setCustomClass(String customClass) {
        this.customClass = customClass;
    }
}
