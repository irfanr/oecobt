/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mascova.oecobt.jsf.converter;

import com.mascova.oecobt.entity.Status;
import com.mascova.oecobt.service.StatusService;
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
@FacesConverter(value = "statusConverter")
public class StatusConverter implements Converter {

    @EJB
    private StatusService statusService;
    public List<Status> statuses;

    @PostConstruct
    private void init(){
        
        statuses = statusService.searchStatus();
    }
    
    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {

        if (string.trim().equals("")) {
            return null;
        } else {
            try {
                int number = Integer.parseInt(string);

                for (Status status : statuses) {
                    if (status.getId() == number) {
                        return status;
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
        if (o == null || o.equals("") || !(o instanceof Status)) {
            return "";
        } else {
            return String.valueOf(((Status) o).getId());
        }
    }
}
