/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllersAdmin;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ASUS
 */
public class AdminController extends HttpServlet {

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
                    url = "admin.jsp";
                    break;
                case "adminjsp":
                    url = "admin.jsp";
                    break;
                // nhan vien
                case "searchMember":
                    url = "searchMember.jsp";
                    break;
                case "searchNameMember":
                    url = "SearchMemberServlet";
                    break;
                //==============
                case "searchStaff":
                    url = "searchStaff.jsp";
                    break;
                case "searchNameStaff":
                    url = "SearchStaffServlet";
                    break;
                case "blockUnblock":
                    url = "BlockUnblockServlet";
                    break;
                case "chinhsua":
                    url = "changeInfoStaffServlet";
                    break;
                case "chinhsuajsp":
                    url = "changeInfoStaff.jsp";
                    break;
                case "chinhsuathongtin":
                    url = "ChangeInfomationStaffServlet";
                    break;
                case "addStaff":
                    url = "addNewStaff.jsp";
                    break;
                case "addNewStaff":
                    url = "addNewStaffServlet";
                    break;
                case "userWalletPage":
                    url = "GetListUserServlet";
                    break;
                case "editUserWallet":
                    url = "EditUserWalletServlet";
                    break;
                case "adminInformationPage":
                    url = "adminInformationPage.jsp";
                    break;
                case "informationChangeAdmin":
                    url = "InformationChangeAdminServlet";
                    break;
                //Xét duyệt đơn nạp tiền Cus
                case "approve_order":
                    url = "admin_ApproveOrder.jsp";
                    break;
                case "approved_order":
                    url = "admin_ApprovedOrder.jsp";
                    break;
                case "reject_order":
                    url = "admin_RejectOrder.jsp";
                    break;
                case "approveOrderList":
                    url = "ApproveOrderServlet";
                    break;
                case "approvedOrderList":
                    url = "ApprovedOrderServlet";
                    break;
                case "rejectOrderList":
                    url = "RejectOrderServlet";
                    break;
                case "approveOrder":
                    url = "UpdateStatusOrderS2Servlet";
                    break;
                case "rejectOrder":
                    url = "UpdateStatusOrderS2Servlet";
                    break;
                // Search,Update Status, Chọn Staff cho RealEstate
                case "adminSearchAuctionApprove":
                    url = "AdminSearchAuctionApproveServlet";
                    break;
                case "adminSearchAuctionApproved":
                    url = "AdminSearchAuctionApprovedServlet";
                    break;
                case "updateStatusButton":
                    url = "AdminUpdateStatusRealEstateServlet";
                    break;
                case "approve":
                    url = "admin_approve.jsp";
                    break;
                case "approved":
                    url = "admin_approved.jsp";
                    break;
                //chinh sua luat le
                case "ruleedited":
                    url = "rule.jsp";
                    break;
                case "fixrule":
                    url = "fixrule.jsp";
                    break;
                case "rulefix":
                    url = "RuleModifyServlet";
                    break;
                //chi tiet thong ke
                case "detailStatistical":
                    url = "detailStatisticalServlet";
                    break;
                case "detailStatisticalJSP":
                    url = "detailStatistical.jsp";
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
