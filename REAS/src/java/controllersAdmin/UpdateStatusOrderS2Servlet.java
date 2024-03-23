/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllersAdmin;

import dao.WalletDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
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
@WebServlet(name = "UpdateStatusOrderS2Servlet", urlPatterns = {"/UpdateStatusOrderS2Servlet"})
public class UpdateStatusOrderS2Servlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
//    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException, ClassNotFoundException, NamingException {
//        response.setContentType("text/html;charset=UTF-8");
//        String url = "admin_ApproveOrder.jsp";
//        String orderIDstr = request.getParameter("orderID");
//        int orderID = Integer.parseInt(orderIDstr);
//        String searchValue = request.getParameter("txtSearchValue");
//
//        try {
//            WalletDAO dao = new WalletDAO();
//            boolean result = dao.updateRequestNapTien(orderID, 2);
//            if (result) {
//                url = "AdminController"
//                        + "?action=approveOrder"
//                        + "&txtSearchValue=" + searchValue;
//            } else {
//                // Cập nhật không thành công, chuyển hướng đến trang lỗi
//                url = "rule.jsp";
//            }
//        } catch (SQLException ex) {
//            ex.printStackTrace();
//        } finally {
//            response.sendRedirect(url);
//        }
//    }
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClassNotFoundException, NamingException {
        response.setContentType("text/html;charset=UTF-8");
        String url = "admin_ApproveOrder.jsp";

        String orderID = request.getParameter("orderID");
        String searchValue = request.getParameter("txtSearchValue");

        String action = request.getParameter("action");

        try {
            WalletDAO dao = new WalletDAO();
            boolean result = false;
            if ("approveOrder".equals(action)) {
                result = dao.updateRequestNapTien(orderID, 2);
            } else if ("rejectOrder".equals(action)) {
                result = dao.updateRequestNapTien(orderID, 3);
            }
            if (result) {
                url = "AdminController"
                        + "?action=approveOrderList"
                        + "&txtSearchValue=" + searchValue;
                
            } else {
                url="";
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            response.sendRedirect(url);
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
            Logger.getLogger(UpdateStatusOrderS2Servlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NamingException ex) {
            Logger.getLogger(UpdateStatusOrderS2Servlet.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(UpdateStatusOrderS2Servlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NamingException ex) {
            Logger.getLogger(UpdateStatusOrderS2Servlet.class.getName()).log(Level.SEVERE, null, ex);
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
