/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mascova.oecobt;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author irfan
 */
public class GanttChartItem implements Serializable{
    
    private Object name;
    private String desc;
    private List<GanttChartValue> values;

    public GanttChartItem() {
    }

    public GanttChartItem(Object name, String desc) {
        this.name = name;
        this.desc = desc;
    }

    /**
     * @return the name
     */
    public Object getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(Object name) {
        this.name = name;
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
     * @return the values
     */
    public List<GanttChartValue> getValues() {
        return values;
    }

    /**
     * @param values the values to set
     */
    public void setValues(List<GanttChartValue> values) {
        this.values = values;
    }


    
}
