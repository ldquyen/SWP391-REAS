package controllersMain;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MainController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        String action = request.getParameter("action");
        String url = "";
        try {

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
                case "auctionList":
                    url = "ListAuctionServlet";
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
                case "ruleedit":
                    url = "RuleEditServlet";
                    break;
                case "rule":
                    url = "RuleEditServlet";
                    break;
                case "changePass":
                    url = "changePass.jsp";
                    break;
                case "news":
                    url = "NewServlet";
                    break;
                case "postNew":
                    url = "postRealEstate.jsp";
                    break;
                case "submitPost":
                    url = "PostRealEstateServlet";
                    break;
                case "forgotPassword":
                    url = "forgotPassword.jsp";
                    break;
                case "sendMail":
                    url = "ForgotPasswordServlet";
                    break;
                case "confirmOTP":
                    url = "confirmOTP.jsp";
                    break;
                case "validateOTP":
                    url = "ConfirmOTPServlet";
                    break;
                case "resetpasswordPage":
                    url = "resetPassword.jsp";
                    break;
                case "resetPassword":
                    url = "ResetPasswordServlet";
                    break;
                case "informationPage":
                    url = "informationPage.jsp";
                    break;
                case "viewPostRealEstateGuest":
                    url = "RealEstateDetailServlet";
                    break;
                case "viewPostRealEstate":
                    url = "RealEstateDetailServlet";
                    break;
                case "viewPostRealEstateStatus2":
                    url = "RealEstateDetailServlet";
                    break;
                case "cusViewMuaNgayList":
                    url = "RealEstateDetailServlet";
                    break;
                case "cusViewMuaNgayListV2":
                    url = "RealEstateDetailServlet";
                    break;
                case "cusSearchMuaNgayList":
                    url = "CusSearchRequestMuaNgayServlet";
                    break;
                case "cusSearchDaBanList":
                    url = "CusSearchRequestDaBanServlet";
                    break;
                case "muangay":
                    url = "MuaNgayServlet";
                    break;
                case "xacNhanMuaNgay":
                    url = "AcceptRequestMuaNgayServlet";
                    break;
                case "homeindex":
                    url = "HomeServletIndex";
                    break;
                case "homeindex_1":
                    url = "HomeServletIndex_1";
                    break;
                case "searchRealEstate":
                    url = "SearchRealEstateAtHomepageServlet";
                    break;
                case "homepage":
                    url = "index_1.jsp";
                    break;
                case "naptien":
                    url = "naptien.jsp";
                    break;
                case "submitNaptien":
                    url = "NaptienServlet";
                    break;
                case "lichsunaptien":
                    url = "naptien_history.jsp";
                    break;
                case "viewHistoryOrder":
                    url = "ViewHistoryOrderServlet";
                    break;
                //edited rule
                case "ruleedited":
                    url = "rule.jsp";
                    break;
            }
        } finally {
            RequestDispatcher rd = request.getRequestDispatcher(url);
            rd.forward(request, response);

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
