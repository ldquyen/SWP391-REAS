/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllersAdmin;

import dao.StatisticalDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author TRUONG SON
 */
public class detailStatisticalServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */

            StatisticalDAO staDAO = new StatisticalDAO();
            String year = request.getParameter("year");
            String month = request.getParameter("month");
            String day = request.getParameter("day");
            String registeryear = request.getParameter("registeryear");
            String registermonth = request.getParameter("registermonth");
            String registerday = request.getParameter("registerday");
            if (year != null || month != null || day != null) {
                int totalLoginYear = staDAO.getTotalLoginCount(year);
                int totalLoginMonth = staDAO.getTotalLoginCountMonth(month);
                int totalLoginDay = staDAO.getTotalLoginCountDay(day);
                int totalLoginDate = staDAO.getTotalLoginCountYMD(year, month, day);
                request.setAttribute("totalLoginYear", "Số lượt đăng nhập trong năm " + year + " là : " + totalLoginYear);
                request.setAttribute("totalLoginMonth", "Số lượt đăng nhập trong tháng " + month + " là : " + totalLoginMonth);
                request.setAttribute("totalLoginDay", "Số lượt đăng nhập trong ngày " + day + " là : " + totalLoginDay);
                request.setAttribute("totalLoginDate", "Số lượt đăng nhập trong ngày " + day +" tháng "+ month+" năm "+ year +  " là : " + totalLoginDate);                
                request.getRequestDispatcher("AdminController?action=detailStatisticalJSP").forward(request, response);
            }
            if (registeryear != null || registermonth != null || registerday != null) {
                int totalRegisterYear = staDAO.getTotalRegisterCountYear(registeryear);
                int totalRegisterMonth = staDAO.getTotalRegisterCountMonth(registermonth);
                int totalRegisternDay = staDAO.getTotalRegisterCountDay(registerday);
                int totalRegisterDate = staDAO.getTotalRegisterCountYMD(registeryear, registermonth, registerday);
                request.setAttribute("totalRegisterYear", "Số lượt đăng ký trong năm " + registeryear + " là : " + totalRegisterYear);
                request.setAttribute("totalRegisterMonth", "Số lượt đăng ký trong tháng " + registermonth + " là : " + totalRegisterMonth);
                request.setAttribute("totalRegisterDay", "Số lượt đăng ký trong ngày " + registerday + " là : " + totalRegisternDay);
                request.setAttribute("totalRegisterDate", "Số lượt đăng nhập trong ngày " + registerday +" tháng "+ registermonth+" năm "+ registeryear +  " là : " + totalRegisterDate);  
                request.getRequestDispatcher("AdminController?action=detailStatisticalJSP").forward(request, response);
            } else {
                request.getRequestDispatcher("AdminController?action=detailStatisticalJSP").forward(request, response);
            }
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
