/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllersAdmin;

import dao.RuleDAO;
import dto.Rule;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author TRUONG SON
 */
public class RuleEditServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     * @throws java.sql.SQLException
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
         try {
            RuleDAO ruledao = new RuleDAO();
            List<Rule> rulelist = ruledao.getRule(1);
            List<Rule> rulelist2 = ruledao.getRule(2);
            List<Rule> rulelist3 = ruledao.getRule(3);
            List<Rule> rulelist4 = ruledao.getRule(4);
            List<Rule> rulelist5 = ruledao.getRule(5);
            List<Rule> rulelist6 = ruledao.getRule(6);
            List<Rule> rulelist7 = ruledao.getRule(7);
            List<Rule> rulelist8 = ruledao.getRule(8);
            List<Rule> rulelist9 = ruledao.getRule(9);
            
            request.setAttribute("rulelist", rulelist);
            request.setAttribute("rulelist2", rulelist2);
            request.setAttribute("rulelist3", rulelist3);
            request.setAttribute("rulelist4", rulelist4);
            request.setAttribute("rulelist5", rulelist5);
            request.setAttribute("rulelist6", rulelist6);
            request.setAttribute("rulelist7", rulelist7);
            request.setAttribute("rulelist8", rulelist8);
            request.setAttribute("rulelist9", rulelist9);
            request.getRequestDispatcher("MainController?action=ruleedited").forward(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(RuleEditServlet.class.getName()).log(Level.SEVERE, null, ex);
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(RuleEditServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(RuleEditServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
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
