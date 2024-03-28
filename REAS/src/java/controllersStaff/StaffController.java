package controllersStaff;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class StaffController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");;
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
                case "staffjsp":
                    url = "staff.jsp";
                    break;
                case "approve":
                    url = "staff_approve.jsp";
                    break;
                case "approved":
                    url = "staff_approved.jsp";
                    break;
                case "searchAuctionApprove":
                    url = "SearchAuctionApproveServlet";
                    break;
                case "searchAuctionApproved":
                    url = "SearchAuctionApprovedServlet";
                    break;
                case "updateStatusButton":
                    url = "UpdateStatusServlet";
                    break;
                case "deleteRealEstateButton":
                    url = "DeleteRealEstateServlet";
                    break;
                case "viewPostRealEstate":
                    url = "REDetailServlet";
                    break;
                case "viewPostRealEstateStatus2":
                    url = "REDetailServlet_status2";
                    break;
                case "listRequestMuaNgay":
                    url = "SearchRequestMuaNgayServlet";
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
