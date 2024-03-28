/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllersAdmin;

import dao.StatisticalDAO;
import dto.RealEstate;
import dto.RealEstateInfo;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.NamingException;
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
            throws ServletException, IOException, ClassNotFoundException, SQLException, NamingException {
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
            String catid = request.getParameter("catid");
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
            }             
            if (catid != null) {
                if(catid.equals("no")){
                    ArrayList<RealEstate> realEstate = staDAO.getAllRealEstateByCatID("no");
                    request.setAttribute("realEstate", realEstate);
                    request.setAttribute("catid", "mem");
                    request.getRequestDispatcher("AdminController?action=detailStatisticalJSP").forward(request, response);
                }
                 if(catid.equals("cc")){
                    ArrayList<RealEstate> realEstate = staDAO.getAllRealEstateByCatID("cc");                    
                    request.setAttribute("realEstate", realEstate);
                    request.getRequestDispatcher("AdminController?action=detailStatisticalJSP").forward(request, response);
                }
                  if(catid.equals("bt")){
                    ArrayList<RealEstate> realEstate = staDAO.getAllRealEstateByCatID("bt");
                    request.setAttribute("realEstate", realEstate);
                    request.getRequestDispatcher("AdminController?action=detailStatisticalJSP").forward(request, response);
                }
                   if(catid.equals("dn")){
                    ArrayList<RealEstate> realEstate = staDAO.getAllRealEstateByCatID("dn");
                   request.setAttribute("realEstate", realEstate);
                    request.getRequestDispatcher("AdminController?action=detailStatisticalJSP").forward(request, response);
                }              
            }else {
                request.setAttribute("ERROR", "ERROR");
                request.getRequestDispatcher("AdminController?action=detailStatisticalJSP").forward(request, response);
            }
            
            
            
        }  
    }
    public static void main(String[] args) throws ClassNotFoundException, SQLException, NamingException {
    StatisticalDAO staDAO = new StatisticalDAO();
    ArrayList<RealEstate> realEstates = staDAO.getAllRealEstateByCatID("no");
    
    // Print each RealEstate object in the list
    for (RealEstate realEstate : realEstates) {
        System.out.println("RealEstate ID: " + realEstate.getRealEstateID());
        System.out.println("Account ID: " + realEstate.getAccID());
        System.out.println("Category ID: " + realEstate.getCatID());
        System.out.println("City ID: " + realEstate.getCityID());
        System.out.println("RealEstate Name: " + realEstate.getRealEstateName());
        System.out.println("Price First: " + realEstate.getPriceFirst());
        System.out.println("Price Paid: " + realEstate.getPricePaid());
        System.out.println("Area: " + realEstate.getArea());
        System.out.println("Address: " + realEstate.getAddress());
        System.out.println("Detail: " + realEstate.getDetail());
        System.out.println("---------------------------------");
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
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(detailStatisticalServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(detailStatisticalServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NamingException ex) {
            Logger.getLogger(detailStatisticalServlet.class.getName()).log(Level.SEVERE, null, ex);
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
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(detailStatisticalServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(detailStatisticalServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NamingException ex) {
            Logger.getLogger(detailStatisticalServlet.class.getName()).log(Level.SEVERE, null, ex);
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
