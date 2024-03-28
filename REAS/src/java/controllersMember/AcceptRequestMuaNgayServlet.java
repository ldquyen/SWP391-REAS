/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllersMember;

import dao.PurchaseRequestDAO;
import dao.RealEstateDAO;
import dao.TransactionDAO;
import dto.Account;
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
import javax.servlet.http.HttpSession;

/**
 *
 * @author ADMIN
 */
@WebServlet(name = "AcceptRequestMuaNgayServlet", urlPatterns = {"/AcceptRequestMuaNgayServlet"})
public class AcceptRequestMuaNgayServlet extends HttpServlet {

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
            throws ServletException, IOException, ClassNotFoundException, SQLException, NamingException {
        response.setContentType("text/html;charset=UTF-8");
        String url = "";
        String realEstateID = request.getParameter("realEstateID");
        String accID_nguoiMua = request.getParameter("accID");

        long pricePaid = 0;
        String pricePaidStr = request.getParameter("pricePaid");
        if (pricePaidStr != null && !pricePaidStr.isEmpty()) {
            pricePaidStr = pricePaidStr.replaceAll("[,.]", "");
            pricePaid = Long.parseLong(pricePaidStr);
        }

        try {
            HttpSession session = request.getSession(false);
            if (session != null && session.getAttribute("member") != null) {
                Account account = (Account) session.getAttribute("member");
                String accID_nguoiBan = account.getAccID();
                
                RealEstateDAO dao = new RealEstateDAO();
                boolean result = dao.updateStatusID(realEstateID, 6);

                PurchaseRequestDAO dao1 = new PurchaseRequestDAO();
                boolean result1 = dao1.updateStatus2(accID_nguoiMua,realEstateID);

                TransactionDAO dao2 = new TransactionDAO();
                boolean result2 = dao2.processTransaction(accID_nguoiMua, accID_nguoiBan, pricePaid);
            
                if (result && result1 && result2) {
                    url = "MainController?action=cusViewMuaNgayListV2&id=" + realEstateID;
                } else {
                    // Cập nhật không thành công, chuyển hướng đến trang lỗi
                    url = "rule.jsp";
                }
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
            Logger.getLogger(AcceptRequestMuaNgayServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(AcceptRequestMuaNgayServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NamingException ex) {
            Logger.getLogger(AcceptRequestMuaNgayServlet.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(AcceptRequestMuaNgayServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(AcceptRequestMuaNgayServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NamingException ex) {
            Logger.getLogger(AcceptRequestMuaNgayServlet.class.getName()).log(Level.SEVERE, null, ex);
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
