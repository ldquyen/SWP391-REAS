package controllersAdmin;

import dao.AccountDAO;
import dto.Account;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ASUS
 */
@WebServlet(name = "ChangeInfomationStaffServlet", urlPatterns = {"/ChangeInfomationStaffServlet"})
public class ChangeInfomationStaffServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClassNotFoundException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String ID = request.getParameter("ID");
            String fullName = request.getParameter("fullName");
            String userName = request.getParameter("userName");
            String password = request.getParameter("password");
            String email = request.getParameter("email");
            String phone = request.getParameter("phone");
            String address = request.getParameter("address");
            String cccd = request.getParameter("cccd");
            String placeOfReg = request.getParameter("placeOfReg");
            String dateOfReg = request.getParameter("dateOfReg");
            String bankName = request.getParameter("bankName");
            String bankCode = request.getParameter("bankCode");

            boolean update = AccountDAO.changeInfoStaff(ID, userName, password, fullName, email, phone, cccd, address, placeOfReg, dateOfReg, bankName, bankCode);
            AccountDAO.changeInfoStaff(ID, userName, password, fullName, email, phone, cccd, address, placeOfReg, dateOfReg, bankName, bankCode);
            if (update) {
                request.setAttribute("UpdateOKE", "OKE");
                Account a = AccountDAO.getAccountByID(ID);
                request.setAttribute("staff", a);
                request.getRequestDispatcher("AdminController?action=chinhsuajsp").forward(request, response);
            } else {
                request.setAttribute("UpdateFAIL", "FAIL");
                Account a = AccountDAO.getAccountByID(ID);
                request.setAttribute("staff", a);
                request.getRequestDispatcher("AdminController?action=chinhsuajsp").forward(request, response);
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
            Logger.getLogger(ChangeInfomationStaffServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ChangeInfomationStaffServlet.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(ChangeInfomationStaffServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ChangeInfomationStaffServlet.class.getName()).log(Level.SEVERE, null, ex);
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
