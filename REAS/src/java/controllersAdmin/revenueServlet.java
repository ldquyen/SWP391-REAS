/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllersAdmin;

import dao.AuctionDepositHistoryDAO;
import static dao.AuctionDepositHistoryDAO.getListADH;
import dao.WalletHistoryDAO;
import dto.AuctionDepositHistory;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ASUS
 */
public class revenueServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException, ClassNotFoundException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String month = request.getParameter("month");
            Long tienphi, sodaugia, sotienthang, sogiaodich, sotiengiaodich;

            if (month.isEmpty()) {
                tienphi = AuctionDepositHistoryDAO.getSoNgThamGiaTrongTungCuocDauGia();
                sodaugia = AuctionDepositHistoryDAO.getTongSoCuocDauGiaDienRa();
                sotienthang = AuctionDepositHistoryDAO.getTongSoTienCuaCacCuocDauGia();
                sogiaodich = WalletHistoryDAO.getSoGiaoDichThucHien();
                sotiengiaodich = WalletHistoryDAO.getSoTienGiaoDichThucHien();
                
                ArrayList<AuctionDepositHistory> getListADH = AuctionDepositHistoryDAO.getListADH();
                
                request.setAttribute("month", month);
                request.setAttribute("tienphi", tienphi);
                request.setAttribute("sodaugia", sodaugia);
                request.setAttribute("sotienthang", sotienthang);
                request.setAttribute("sogiaodich", sogiaodich);
                request.setAttribute("sotiengiaodich", sotiengiaodich);
                request.setAttribute("getListADH", getListADH);
                
                request.getRequestDispatcher("AdminController?action=revenue").forward(request, response);
            } else {
                tienphi = AuctionDepositHistoryDAO.getSoNgThamGiaTrongTungCuocDauGiaInMonth(month);
                sodaugia = AuctionDepositHistoryDAO.getTongSoCuocDauGiaDienRaInMonth(month);
                sotienthang = AuctionDepositHistoryDAO.getTongSoTienCuaCacCuocDauGiaInMonth(month);
                sogiaodich = WalletHistoryDAO.getSoGiaoDichThucHienInMonth(month);
                sotiengiaodich = WalletHistoryDAO.getSoTienGiaoDichThucHienInMonth(month);
                
                ArrayList<AuctionDepositHistory> getListADH = AuctionDepositHistoryDAO.getListADHInMonth(month);
                
                request.setAttribute("month", month);
                request.setAttribute("tienphi", tienphi);
                request.setAttribute("sodaugia", sodaugia);
                request.setAttribute("sotienthang", sotienthang);
                request.setAttribute("sogiaodich", sogiaodich);
                request.setAttribute("sotiengiaodich", sotiengiaodich);
                request.setAttribute("getListADH", getListADH);
                
                request.getRequestDispatcher("AdminController?action=revenue").forward(request, response);
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(revenueServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(revenueServlet.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(revenueServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(revenueServlet.class.getName()).log(Level.SEVERE, null, ex);
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
