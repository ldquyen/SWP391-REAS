/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllersMember;

import dao.AccountDAO;
import dto.Account;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author TRUONG SON
 */
public class InformationChangeServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClassNotFoundException, SQLException, Exception {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            String fullname = request.getParameter("txtFullname");
            String email = request.getParameter("txtEmail");
            String phone = request.getParameter("txtPhone");
            String cccd = request.getParameter("txtCCCD");
            String address = request.getParameter("txtAddress");
            String cccdregplace = request.getParameter("txtCCCDRegplace");
            String cccdregdate = request.getParameter("txtCCCDRegdate");
            String bankname = request.getParameter("txtBankname");
            String bankcode = request.getParameter("txtBankcode");
            String accId = request.getParameter("txtAccID");
            AccountDAO acc = new AccountDAO();
            if (fullname.length() > 1) {
                if (!acc.containsOnlyLettersAndSpaces(fullname)) {
                    request.setAttribute("ERROR", "Tên sai định dạng, vui lòng nhập lại!");
                    request.getRequestDispatcher("MainController?action=informationPage").forward(request, response);
                } else {
                    acc.changeFullname(fullname, accId);
                    request.setAttribute("SUCCESS", "Thay đổi thông tin thành công, vui lòng đăng nhập lại!");
                    request.getRequestDispatcher("MainController?action=informationPage").forward(request, response);
                }
            }
            if (email.length() > 1) {
                if (!acc.checkGmailContainSymbol(email)) {
                    request.setAttribute("ERROR", "Email sai định dạng, vui lòng nhập lại!" + email);
                    request.getRequestDispatcher("MainController?action=informationPage").forward(request, response);
                } else if (acc.checkEmail(email)) {
                    request.setAttribute("ERROR", "Email đã tồn tại, vui lòng nhập email khác!");
                    request.getRequestDispatcher("MainController?action=informationPage").forward(request, response);
                } else {
                    acc.changeEmail(email, accId);
                    request.setAttribute("SUCCESS", "Thay đổi thông tin thành công, vui lòng đăng nhập lại!");
                    request.getRequestDispatcher("MainController?action=informationPage").forward(request, response);
                }
            }
            if (phone.length() > 1) {
                if (!phone.matches("\\d{10}")) {
                    request.setAttribute("ERROR", "Số điện thoại sai định dạng, vui lòng nhập lại!");
                    request.getRequestDispatcher("MainController?action=informationPage").forward(request, response);
                } else if (acc.checkPhone(phone)) {
                    request.setAttribute("ERROR", "Số điện thoại đã tồn tại, vui lòng nhập lại!");
                    request.getRequestDispatcher("MainController?action=informationPage").forward(request, response);
                } else {
                    acc.changeFullname(phone, accId);
                    request.setAttribute("SUCCESS", "Thay đổi thông tin thành công, vui lòng đăng nhập lại");
                    request.getRequestDispatcher("MainController?action=informationPage").forward(request, response);
                }
            }
            if (cccd.length() > 1) {
                if (!cccd.matches("\\d{12}")) {
                    request.setAttribute("ERROR", "CCCD sai định dạng, vui lòng nhập lại!");
                    request.getRequestDispatcher("MainController?action=informationPage").forward(request, response);
                } else if (acc.checkCCCD(cccd)) {
                    request.setAttribute("ERROR", "CCCD đã tồn tại, vui lòng nhập lại!");
                    request.getRequestDispatcher("MainController?action=informationPage").forward(request, response);
                } else {
                    acc.changeFullname(cccd, accId);
                    request.setAttribute("SUCCESS", "Thay đổi thông tin thành công, vui lòng đăng nhập lại");
                    request.getRequestDispatcher("MainController?action=informationPage").forward(request, response);
                }
            }
            if (address.length() > 1) {
                acc.changeAddress(address, accId);
                request.setAttribute("SUCCESS", "Thay đổi thông tin thành công, vui lòng đăng nhập lại");
                request.getRequestDispatcher("MainController?action=informationPage").forward(request, response);
            }
            if (cccdregdate.length() > 1) {
                acc.changeCCCDRegDate(cccdregdate, accId);
                request.setAttribute("SUCCESS", "Thay đổi thông tin thành công, vui lòng đăng nhập lại");
                request.getRequestDispatcher("MainController?action=informationPage").forward(request, response);
            }
            if (cccdregplace.length() > 1) {
                acc.changeCCCDRegPlace(cccdregplace, accId);
                request.setAttribute("SUCCESS", "Thay đổi thông tin thành công, vui lòng đăng nhập lại");
                request.getRequestDispatcher("MainController?action=informationPage").forward(request, response);
            }
            if (bankname.length() > 1) {
                if (!acc.containsOnlyLettersAndSpaces(bankname)) {
                    request.setAttribute("ERROR", "Tên ngân hàng sai định dạng, vui lòng nhập lại!");
                    request.getRequestDispatcher("MainController?action=informationPage").forward(request, response);
                } else {
                    acc.changeBankName(bankname, accId);
                    request.setAttribute("SUCCESS", "Thay đổi thông tin thành công, vui lòng đăng nhập lại");
                    request.getRequestDispatcher("MainController?action=informationPage").forward(request, response);
                }
            }
            if (bankcode.length() > 1) {
                if (!bankcode.matches("\\d+")) {
                    request.setAttribute("ERROR", "Sồ tài khoản ngân hàng sai định dạng, vui lòng nhập lại!");
                    request.getRequestDispatcher("MainController?action=informationPage").forward(request, response);
                } else {
                    acc.changeBankCode(bankcode, accId);
                    request.setAttribute("SUCCESS", "Thay đổi thông tin thành công, vui lòng đăng nhập lại");
                    request.getRequestDispatcher("MainController?action=informationPage").forward(request, response);
                }
            } else {
                request.setAttribute("ERROR", "Hãy nhập vào thông tin muốn thay đổi!");
                request.getRequestDispatcher("MainController?action=informationPage").forward(request, response);
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
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(InformationChangeServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(InformationChangeServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(InformationChangeServlet.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(InformationChangeServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(InformationChangeServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(InformationChangeServlet.class.getName()).log(Level.SEVERE, null, ex);
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
