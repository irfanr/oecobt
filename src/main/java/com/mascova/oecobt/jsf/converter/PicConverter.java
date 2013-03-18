/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mascova.oecobt.jsf.converter;

import com.mascova.oecobt.entity.Pic;
import com.mascova.oecobt.service.PicService;
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
@FacesConverter(value = "picConverter")
public class PicConverter implements Converter {

    @EJB
    private PicService picService;
    public List<Pic> pics;

    @PostConstruct
    private void init(){
        
        pics = picService.searchPic();
    }
    
    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {

        if (string.trim().equals("")) {
            return null;
        } else {
            try {
                int number = Integer.parseInt(string);

                for (Pic pic : pics) {
                    if (pic.getId() == number) {
                        return pic;
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
        if (o == null || o.equals("") || !(o instanceof Pic)) {
            return "";
        } else {
            return String.valueOf(((Pic) o).getId());
        }
    }
}
