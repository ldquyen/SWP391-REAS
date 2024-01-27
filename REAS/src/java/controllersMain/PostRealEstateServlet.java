/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllersMain;


import dao.RealEstateDAO;
import dto.RealEstate;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ADMIN
 */
@WebServlet(name = "PostRealEstateServlet", urlPatterns = {"/PostRealEstateServlet"})
public class PostRealEstateServlet extends HttpServlet {

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
        try {
            // Retrieve data from the form
            String realEstateID = request.getParameter("realEstateID");
            String address = request.getParameter("address");
            int cityID = Integer.parseInt(request.getParameter("cityID"));
            String priceNow = request.getParameter("priceNow");
            String timeUpStr = request.getParameter("timeUp");
            String timeDownStr = request.getParameter("timeDown");
            LocalDateTime timeUp = LocalDateTime.parse(timeUpStr, DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm"));
            LocalDateTime timeDown = LocalDateTime.parse(timeDownStr, DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm"));
            String catID = request.getParameter("catID");
            float area = Float.parseFloat(request.getParameter("area"));
            String detail = request.getParameter("detail");

            // Assuming RealEstate is a class with appropriate getters and setters
            RealEstate realEstate = new RealEstate();
            realEstate.setRealEstateID(realEstateID);
            realEstate.setAddress(address);
            realEstate.setCityID(cityID);
 //           realEstate.setPriceNow(priceNow);
            realEstate.setTimeUp(timeUp);
            realEstate.setTimeDown(timeDown);
            realEstate.setCatID(catID);
            realEstate.setArea((int) area);
            realEstate.setDetail(detail);

            // Call your DAO class to insert into the database
            RealEstateDAO realEstateDAO = new RealEstateDAO();
            boolean result = realEstateDAO.createPost(realEstate, request);

            if (result) {
                // Insertion successful, you can redirect to a success page or do other actions
                response.sendRedirect("postRealEstate");
            } else {
                // Insertion failed, you can redirect to an error page or do other actions
                response.sendRedirect("index_1.jsp");
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PostRealEstateServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(PostRealEstateServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NamingException ex) {
            Logger.getLogger(PostRealEstateServlet.class.getName()).log(Level.SEVERE, null, ex);
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
