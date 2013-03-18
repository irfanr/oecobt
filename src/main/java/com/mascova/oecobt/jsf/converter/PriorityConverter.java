/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mascova.oecobt.jsf.converter;

import com.mascova.oecobt.entity.Priority;
import com.mascova.oecobt.service.PriorityService;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author irfan
 */
@ManagedBean
@RequestScoped
@FacesConverter(value = "priorityConverter")
public class PriorityConverter implements Converter {

    @EJB
    private PriorityService priorityService;
    public List<Priority> priorities;

    @PostConstruct
    private void init(){
        
        priorities = priorityService.searchPriority();
    }
    
    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {

        if (string.trim().equals("")) {
            return null;
        } else {
            try {
                int number = Integer.parseInt(string);

                for (Priority priority : priorities) {
                    if (priority.getId() == number) {
                        return priority;
                    }
                }

            } catch (NumberFormatException exception) {
                throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Conversion Error", "Not a valid player"));
            }
        }

        return null;
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object o) {
        if (o == null || o.equals("") || !(o instanceof Priority)) {
            return "";
        } else {
            return String.valueOf(((Priority) o).getId());
        }
    }
}
