/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllersAdmin;

import dao.AccountDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddNewStaffServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, Exception {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String fullName = request.getParameter("fullName");
            String userName = request.getParameter("userName");
            String password = request.getParameter("password");
            String newpassword = AccountDAO.encodePassword(password);
            String email = request.getParameter("email");
            String phone = request.getParameter("phone");
            String address = request.getParameter("address");
            String cccd = request.getParameter("cccd");
            String placeOfReg = request.getParameter("placeOfReg");
            String dateOfReg = request.getParameter("dateOfReg");
            String bankName = request.getParameter("bankName");
            String bankCode = request.getParameter("bankCode");
            String accid;
            int i = 0;
            if (!fullName.isEmpty() && !userName.isEmpty() && !password.isEmpty() && !email.isEmpty() && !phone.isEmpty() && !address.isEmpty() && !cccd.isEmpty() && !placeOfReg.isEmpty() && !dateOfReg.isEmpty() && !bankCode.isEmpty() && !bankName.isEmpty()) {
                do {
                    i++;
                    String i1 = Integer.toString(i);
                    accid = "S" + i1;
                } while (AccountDAO.checkAccount(accid));
                boolean addnew = AccountDAO.addStaff(accid, userName, newpassword, fullName, email, phone, cccd, address, placeOfReg, dateOfReg, bankName, bankCode);
                if (addnew) {
                    request.setAttribute("ADDOKE", "OKE");
                    request.getRequestDispatcher("AdminController?action=addStaff").forward(request, response);
                }else{
                    request.setAttribute("ADDnotOKE", "KO OKE");
                    request.getRequestDispatcher("AdminController?action=addStaff").forward(request, response);
                }
            } else {
                request.setAttribute("THIEUTT", "Thiếu thông tin ");
                request.getRequestDispatcher("AdminController?action=addStaff").forward(request, response);
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
        } catch (Exception ex) {
            Logger.getLogger(AddNewStaffServlet.class.getName()).log(Level.SEVERE, null, ex);
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
        } catch (Exception ex) {
            Logger.getLogger(AddNewStaffServlet.class.getName()).log(Level.SEVERE, null, ex);
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
