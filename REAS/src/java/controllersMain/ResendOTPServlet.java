/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllersMain;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import mylib.MailService;

/**
 *
 * @author sny12
 */
public class ResendOTPServlet extends HttpServlet {

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
            out.println("<title>Servlet ResendOTPServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ResendOTPServlet at " + request.getContextPath() + "</h1>");
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
        try {

            Cookie[] cookies = request.getCookies();
            int otpValue = 0;
            String url = "MainController";
            HttpSession session = request.getSession();
            if (cookies != null) {
                String sendTo = "";
                //create otp
                Random rand = new Random();
                otpValue = rand.nextInt(1255650);

                for (Cookie cookie : cookies) {
                    if (cookie.getName().equals("userEmail")) {
                        // Found the desired cookie
                        sendTo = cookie.getValue();
                        System.out.println("Cookie value: " + sendTo);
                        break;
                    }
                }
                if (sendTo.length() > 1) {
                    String Title = "Your OTP to reset your password in REAS";
                    String content = "Your OTP is: " + otpValue + "\n "
                            + "Your OTP just able to 30s. \n"
                            + "Please do not share for anyone. Thank you.";
                    boolean result = MailService.sendMail(sendTo, Title, content);
                    if (result) {
                        session.setAttribute("otp", otpValue);
                        // set time for otp
                        session.setAttribute("email", sendTo);
                        url = "MainController?action=confirmOTP";
                    }
                } else {
                    String message = "Your email is not correct";
                    session.setAttribute("otpMessage", message);
                    url = "forgotPassword.jsp";
                }
            }
            request.getRequestDispatcher(url).forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
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
