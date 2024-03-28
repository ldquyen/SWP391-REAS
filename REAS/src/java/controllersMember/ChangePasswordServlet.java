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

public class ChangePasswordServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClassNotFoundException, SQLException, Exception {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            AccountDAO accdao = new AccountDAO();
            String password = request.getParameter("password");
            String encodePassword = AccountDAO.encodePassword(password);
            String passmember = request.getParameter("passmember");
            String newpassword = request.getParameter("newpassword");
            String encodeNewPassword = AccountDAO.encodePassword(newpassword);
            String renewpassword = request.getParameter("renewpassword");
            String cccd = request.getParameter("cccd");
            String cccdmember = request.getParameter("cccdmember");
            String accidmember = request.getParameter("accidmember");
            String usernamemember = request.getParameter("usernamemember");
            //check password = passmember / newpassword = renewpassmember / cccd = cccdmember
            if (AccountDAO.checkEqual(encodePassword, passmember) && AccountDAO.checkEqual(newpassword, renewpassword) && AccountDAO.checkEqual(cccd, cccdmember) && !AccountDAO.checkEqual(passmember, encodeNewPassword)) {
                AccountDAO.changePassword(accidmember, encodeNewPassword);
                request.setAttribute("CHANGEPASSOKE", "Đã thay đổi mật khẩu");
                HttpSession session = request.getSession();
                Account m = accdao.getAccount(usernamemember, encodeNewPassword);
                session.setAttribute("member", m);
                request.getRequestDispatcher("MainController?action=changePass").forward(request, response);
            } else {
                if (!AccountDAO.checkEqual(encodePassword, passmember)) {
                    request.setAttribute("WRONGPASSWORD", "MK cũ không đúng");
                    request.getRequestDispatcher("MainController?action=changePass").forward(request, response);
                } else if (AccountDAO.checkEqual(encodeNewPassword, passmember)) {
                    request.setAttribute("DUPLICATEOLDPASSWORD", "MK mới không được trùng với MK cũ");
                    request.getRequestDispatcher("MainController?action=changePass").forward(request, response);
                } else if (!AccountDAO.checkEqual(newpassword, renewpassword)) {
                    request.setAttribute("WRONGNEWPASSWORD", "Xác nhận MK mới không khớp");
                    request.getRequestDispatcher("MainController?action=changePass").forward(request, response);
                } else if (!AccountDAO.checkEqual(cccd, cccdmember)) {
                    request.setAttribute("WRONGCCCD", "Mã CCCD không hợp lệ");
                    request.getRequestDispatcher("MainController?action=changePass").forward(request, response);
                }
            }
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ChangePasswordServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ChangePasswordServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(ChangePasswordServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ChangePasswordServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ChangePasswordServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(ChangePasswordServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
