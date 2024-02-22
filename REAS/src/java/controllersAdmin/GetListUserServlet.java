/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controllersAdmin;

import dao.AdminDAO;
import java.io.IOException;
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
public class GetListUserServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String url = "";
        try {
            AdminDAO adminDAO = new AdminDAO();
            List<UserVM> listMenbers = adminDAO.getListMemberWallet();
            if(listMenbers.size() > 0 || listMenbers.isEmpty()) {
                request.setAttribute("listUserWallet", listMenbers);
                url = "userWallet.jsp";
            } else {
                System.out.println("get list User Error");
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
