/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controllersAdmin;

import dao.AdminDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.UserVM;

/**
 *
 * @author Admin
 */
public class EditUserWalletServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String url = "";
        String editAction = request.getParameter("editAction");
        try {
            if (editAction != null) {
                String fundP = request.getParameter("fund");
                String currentfundP = request.getParameter("currentFund");
                String accIdP = request.getParameter("accId");

                double fund = Integer.parseInt(fundP);
                double currentFund = Integer.parseInt(currentfundP);
                AdminDAO adminDAO = new AdminDAO();
                int result = adminDAO.editUserWallet(accIdP, fund, currentFund, editAction);
                if (result == 1) {
                    url = "AdminController?action=userWalletPage";
                } else if (result == 3) {
                    request.setAttribute("error", "So tien refund khong the lon hon AccountBalance");
                    url = "AdminController?action=userWalletPage";

                } else {
                    System.out.println("Cannot update user wallet");
                }
            }
        } catch (Exception e) {
        }
        request.getRequestDispatcher(url).forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
