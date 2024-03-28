package controllersMember;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MemberController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String action = request.getParameter("action");
            String url = "";
            if (action == null) {
                action = "";
            }
            switch (action) {
                case "":
                    url = "index_1.jsp";
                    break;
                case "changePassServlet":
                    url = "ChangePasswordServlet";
                    break;
                case "changePass":
                    url = "changePass.jsp";
                    break;
                case "newsjsp":
                    url = "news.jsp";
                    break;
                case "filterInNews":
                    url = "FilterInNewsServlet";
                    break;
                case "changeInfo":
                    url = "InformationChangeServlet";
                    break;
                case "xemroom":
                    url = "AuctionRoomServlet";
                    break;
                case "dangkiroom":
                    url = "RegisterAuctionServlet";
                    break;
                case "tragia":
                    url = "AuctionServlet";
                    break;
                case "auctionRoom":
                    url = "auctionRoom.jsp";
                    break;
                case "resultAuction":
                    url = "ResultAuctionServlet";
                    break;
                case "stastus2tostatus3":
                    url = "Status2toStatus3Servlet";
                    break;
                case "registerAuction":
                    url = "RegisterAuctionServlet";
                    break;
                case "mypost":
                    url = "MyPostServlet";
                    break;
                case "mypostjsp":
                    url = "myPost.jsp";
                    break;
                case "feedbackServlet":
                    url = "FeedbackServlet";
                    break;
                case "xacNhanMuaNgay":
                    url = "AcceptRequestMuaNgayServlet";
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
