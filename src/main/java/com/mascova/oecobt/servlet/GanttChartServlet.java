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
import org.joda.time.DateTime;

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

        DateTime dt = new DateTime();
        new DateTime(2011, 2, 1, 8, 0).getMillis();
        System.out.println("new DateTime(2011, 2, 1, 8, 0).getMillis(): "+new DateTime(2011, 2, 1, 8, 0).getMillis());
        
        // _____________________________________________________________________
        //
        // BEGIN added dummy gantt chart data 
        // _____________________________________________________________________
        List<GanttChartItem> ganttChartItemList = new ArrayList();

        List<GanttChartValue> values = new ArrayList();

        GanttChartItem gci1 = new GanttChartItem(
                "Sprint 0", 
                "Analysis");
        List<GanttChartValue> values1 = new ArrayList();
        values1.add(new GanttChartValue(
                "/Date("+new DateTime(2011, 11, 3, 8, 0).getMillis()+")/",
                "/Date("+new DateTime(2011, 11, 28, 9, 0).getMillis()+")/",
                "Requirement Gathering",
                "ganttRed"));
        gci1.setValues(values1);
        ganttChartItemList.add(gci1);                                   
        // _____________________________________________________________________
        //
        // END added dummy gantt chart data 
        // _____________________________________________________________________        

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
