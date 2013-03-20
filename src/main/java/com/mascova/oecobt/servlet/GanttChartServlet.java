/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mascova.oecobt.servlet;

import com.mascova.oecobt.GanttChartItem;
import com.mascova.oecobt.GanttChartValue;
import com.mascova.oecobt.service.DefectService;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.map.ObjectMapper;

/**
 *
 * @author irfan
 */
public class GanttChartServlet extends HttpServlet {

    @EJB
    DefectService defectService;

    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("application/json");
        PrintWriter out = response.getWriter();

        List<GanttChartItem> ganttChartItemList = new ArrayList();
        
        List<GanttChartValue> values = new ArrayList();        
        values.add(new GanttChartValue(
                "/Date(1320192000000)/",
                "/Date(1322401600000)/",
                "",
                "Requirement Gathering",
                "ganttRed"));        
        
        GanttChartItem gci1 = new GanttChartItem("name1", "desc1");
        gci1.setValues(values);
        ganttChartItemList.add(gci1);
        GanttChartItem gci2 = new GanttChartItem("name2", "desc2");
        gci2.setValues(values);
        ganttChartItemList.add(gci2);
        GanttChartItem gci3 = new GanttChartItem("name3", "desc3");
        gci3.setValues(values);
        ganttChartItemList.add(gci3);        

        ObjectMapper mapper = new ObjectMapper();
//        mapper.configure(JsonGenerator.Feature.QUOTE_FIELD_NAMES, false);
//        mapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);

        try {
            /* TODO output your page here. You may use following sample code. */
            out.println(mapper.writeValueAsString(ganttChartItemList));

        } finally {
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
