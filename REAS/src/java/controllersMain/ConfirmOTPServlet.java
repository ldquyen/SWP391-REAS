/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllersMain;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author sny12
 */
public class ConfirmOTPServlet extends HttpServlet {

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
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ConfirmOTPServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ConfirmOTPServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
          String userEmail = request.getParameter("email");
        String resendMail = "";

        Cookie[] cookies = request.getCookies();
        String url = "";

        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("userEmail")) {
                // Found the desired cookie
                resendMail = cookie.getValue();
                System.out.println("Cookie value: " + resendMail);
                break;
            }
        }
        if (resendMail.length() > 1) {
            try {
                int value = Integer.parseInt(request.getParameter("otp").trim());
                HttpSession session = request.getSession();
                // set this mail for resend
                request.setAttribute("emailSent", userEmail);
                int otp = (int) session.getAttribute("otp");
                if (value == otp) {
                    request.setAttribute("email", userEmail);
                    request.setAttribute("Status", "Success");
                    url = "MainController?action=resetpasswordPage";
                } else {
                    request.setAttribute("message", "Wrong OTP. Try Again");
                    url = "MainController?action=confirmOTP";
                }

                request.getRequestDispatcher(url).forward(request, response);

            } catch (Exception e) {
                request.setAttribute("message", "Session is run out of time");
                url = "MainController?action=confirmOTP";
                request.getRequestDispatcher(url).forward(request, response);

            }
        } else {
                request.setAttribute("message", "Your OTP is not valid please resend");
                url = "MainController?action=confirmOTP";
                request.getRequestDispatcher(url).forward(request, response);
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
