package controllersMain;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MainController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String action = request.getParameter("action");
            String url = "";
            if (action == null) {
                action = "";
            }
            switch (action) {
                case "":
                    url = "index.jsp";
                    break;
                case "DN":
                    url = "login.jsp";
                    break;
                case "LoginGG":
                    url = "LoginGoogleServlet";
                    break;
                case "Login":
                    url = "LoginServlet";
                    break;
                case "Logout":
                    url = "LogoutServlet";
                    break;
                case "DK":
                    url = "register.jsp";
                    break;
                case "dangky":
                    url = "RegisterServlet";
                    break;
                case "trangchu":
                    url = "index_1.jsp";
                    break;
                case "aboutus":
                    url = "aboutUS.jsp";
                    break;
                case "rule":
                    url = "rule.jsp";
                    break;
                case "changePass":
                    url = "changePass.jsp";
                    break;
                case "news":
                    url = "news.jsp";
                    break;
            }
            request.getRequestDispatcher(url).forward(request, response);

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
        processRequest(request, response);
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
        processRequest(request, response);
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
