/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mascova.oecobt.jsf.converter;

import com.mascova.oecobt.entity.Severity;
import com.mascova.oecobt.entity.Status;
import com.mascova.oecobt.service.SeverityService;
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
@FacesConverter(value = "severityConverter")
public class SeverityConverter implements Converter {

    @EJB
    private SeverityService severityService;
    public List<Severity> severities;

    @PostConstruct
    private void init(){
        
        severities = severityService.searchSeverity();
    }
    
    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {

        if (string.trim().equals("")) {
            return null;
        } else {
            try {
                int number = Integer.parseInt(string);

                for (Severity severity : severities) {
                    if (severity.getId() == number) {
                        return severity;
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
        if (o == null || o.equals("") || !(o instanceof Severity)) {
            return "";
        } else {
            return String.valueOf(((Severity) o).getId());
        }
    }
}
