/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pricecalculation.PriceCalculation;

/**
 *
 * @author Albert Scheel Vandel
 */
public class ServletResult extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        if (Integer.parseInt(request.getParameter("height")) <= 0 || Integer.parseInt(request.getParameter("width")) <= 0) {
            throw new ServletException("Input positive numbers only");
        }
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ServletResult</title>");
            out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"resultcss.css\">");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>The price of the window </h1>");
            out.println("<div>");
            out.println("<p> Height: " + Integer.parseInt(request.getParameter("height")) + " cm</p>");
            out.println("<p> Width: " + Integer.parseInt(request.getParameter("width")) + " cm</p>");
            out.println("<p> Frame type: " + request.getParameter("type") + "</p>");    
            PriceCalculation calc= new PriceCalculation();
            out.println("<p> Price: " + calc.calculate(new BigDecimal(request.getParameter("height")),
                                new BigDecimal(request.getParameter("width")),
                                request.getParameter("type")) + "</p>");            
            out.println("</div>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
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
     * Handles the HTTP <code>POST</code> method.
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
