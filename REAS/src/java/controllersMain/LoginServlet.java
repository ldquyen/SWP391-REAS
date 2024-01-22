/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllersMain;

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
import dao.AccountDAO;
import dto.Account;
import java.util.List;
import javax.servlet.http.HttpSession;

/**
 *
 * @author thaiq
 */
@WebServlet(name = "LoginServlet", urlPatterns = {"/LoginServlet"})
public class LoginServlet extends HttpServlet {

    private final String HOMEPAGE = "index_1.jsp"; // bien la hang so phai lhai bao in hoa
    private final String LOGINPAGE = "login.jsp";

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
            throws ServletException, IOException, ClassNotFoundException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        //1. get all paratmeter
        String username = request.getParameter("txtUsername");
        String password = request.getParameter("txtPassword");
        String url = LOGINPAGE;
        boolean error = false;
        try {
            AccountDAO dao = new AccountDAO();
            Account dto = dao.checkLogin(username, password);

            if (dto == null) {
                // Authentication failed
                error = true;
                url = LOGINPAGE;
            } else if ("A".equals(dto.getRoleID())) {
                System.out.println(dto.getRoleID());
                url = "admin.jsp";
                error = false;
                HttpSession session = request.getSession();
                Account a = dao.getAccount(username, password);
                session.setAttribute("adnin", a);

            } else if ("M".equals(dto.getRoleID())) {
                url = "index_1.jsp";
                error = false;
                HttpSession session = request.getSession();
                Account m = dao.getAccount(username, password);
                session.setAttribute("member", m);
            } else if ("S".equals(dto.getRoleID())) {
                url = "staff.jsp";
                error = false;
                HttpSession session = request.getSession();
                Account s = dao.getAccount(username, password);
                session.setAttribute("staff", s);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (NamingException ex) {
            ex.printStackTrace();
        } finally {
            RequestDispatcher rd = request.getRequestDispatcher(url);
            rd.forward(request, response);
            out.close();
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
            Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
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
