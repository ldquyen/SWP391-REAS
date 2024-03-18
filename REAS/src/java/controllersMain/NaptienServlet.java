/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllersMain;

import dao.WalletDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ADMIN
 */
@WebServlet(name = "NaptienServlet", urlPatterns = {"/NaptienServlet"})
public class NaptienServlet extends HttpServlet {

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
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        String url = "naptien.jsp";
        
        int walletID;
        String walletIDstr = request.getParameter("walletID");
        walletID = Integer.parseInt(walletIDstr);
        
        long price = 0;
        String priceStr = request.getParameter("soTien");
        if (priceStr != null) {
            priceStr = priceStr.replaceAll("[,.]", "");
            if (priceStr != null && !priceStr.isEmpty()) {
                // Nếu có thì parse sang long
                price = Long.parseLong(priceStr);
                if (price <= 0) {
                    request.setAttribute("Wrong_Price", "Số Xu phải lớn hơn 0!!!");
                    RequestDispatcher rd = request.getRequestDispatcher(url);
                    rd.forward(request, response);
                    return;
                }
            }
        }
        String content = request.getParameter("content");
        try {
            WalletDAO dao = new WalletDAO();
            boolean result = dao.sendRequestNapTien(walletID, price, content);
            if (result) {
                url = "naptien.jsp";
                request.setAttribute("Nap_Success", "Đơn yêu cầu nạp tiền gửi THÀNH CÔNG, vui lòng đợi hệ thống xét duyệt!!!");
                RequestDispatcher rd = request.getRequestDispatcher(url);
                rd.forward(request, response);
            } 
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(PostRealEstateServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        long price = 300;
        WalletDAO dao = new WalletDAO();
            boolean result = dao.sendRequestNapTien(1, price, "Nap tien de");
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
            Logger.getLogger(NaptienServlet.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(NaptienServlet.class.getName()).log(Level.SEVERE, null, ex);
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
