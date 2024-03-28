/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllersMain;

import dao.PurchaseRequestDAO;
import dao.WalletDAO;
import dto.Account;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
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
@WebServlet(name = "MuaNgayServlet", urlPatterns = {"/MuaNgayServlet"})
public class MuaNgayServlet extends HttpServlet {

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
            throws ServletException, IOException, ClassNotFoundException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        
        String realEstateID = request.getParameter("realEstateID");

        String url = "MainController?action=viewPostRealEstateStatus2&id=" + realEstateID;

        HttpSession session = request.getSession(false);
        Account account = (Account) session.getAttribute("member");
        String accID  = account.getAccID();
        boolean result;

        long pricePaid = 0;
        String pricePaidStr = request.getParameter("pricePaid");
        if (pricePaidStr != null && !pricePaidStr.isEmpty()) {
            pricePaidStr = pricePaidStr.replaceAll("[,.]", "");
            pricePaid = Long.parseLong(pricePaidStr);
        }

        WalletDAO daoWallet = new WalletDAO();
        long accountBalance = daoWallet.getAccountBalanceByAccID(accID);
        
        try {
            if (accountBalance > (pricePaid + 5)) {
                PurchaseRequestDAO dao = new PurchaseRequestDAO();
                result = dao.sendRequestMuaNgay(accID, realEstateID, pricePaid);
                if (result) {
                    session.setAttribute("purchaseStatus", "Đang xét duyệt");
                    request.setAttribute("Purchase_Request", "Đơn mua ngay gửi THÀNH CÔNG, vui lòng đợi hệ thống xét duyệt!!!");
                }
            } else {
                request.setAttribute("Not_Request", "Số dư không đủ để thực hiện thao tác!!!");
            }
            // Lưu URL trước đó vào requestScope
            request.setAttribute("previousUrl", request.getHeader("Referer"));
            // Chuyển hướng đến trang JSP để hiển thị thông báo
            request.getRequestDispatcher("detailRealEstate_status2.jsp").forward(request, response);

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(MuaNgayServlet.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(MuaNgayServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(MuaNgayServlet.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(MuaNgayServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(MuaNgayServlet.class.getName()).log(Level.SEVERE, null, ex);
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
