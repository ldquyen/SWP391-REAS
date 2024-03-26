/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllersStaff;

import dao.AuctionDAO;
import dao.CityDAO;
import dao.ImageDAO;
import dao.PurchaseRequestDAO;
import dao.RealEstateDAO;
import dto.Auction;
import dto.City;
import dto.Image;
import dto.PurchaseRequest;
import dto.RealEstateInfo;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.RealEstateVM;

/**
 *
 * @author ADMIN
 */
@WebServlet(name = "SearchRequestMuaNgayServlet", urlPatterns = {"/SearchRequestMuaNgayServlet"})
public class SearchRequestMuaNgayServlet extends HttpServlet {

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
            throws ServletException, IOException, ClassNotFoundException, NamingException {
        String realEstateId = request.getParameter("realEstateID");
        String url = "StaffController?action=viewPostRealEstate&id=" + realEstateId;
        
        String searchValue = request.getParameter("txtSearchValue");
        try {
            if (realEstateId != null) {
                RealEstateDAO realEstateDAO = new RealEstateDAO();
                AuctionDAO auctionDAO = new AuctionDAO();

                List<Auction> auctions = auctionDAO.getAuctions();
                request.setAttribute("Auctions", auctions);

                RealEstateDAO dao = new RealEstateDAO();
                PurchaseRequestDAO dao1 = new PurchaseRequestDAO();

                if (searchValue == null || searchValue.trim().isEmpty()) {
                    List<RealEstateInfo> listRealEstate = dao.getAllRealEstate(1);
                    request.setAttribute("SEARCH_RESULT", listRealEstate);

                    List<PurchaseRequest> listRequestMuaNgay = dao1.getAllPurchaseRequests(realEstateId);
                    request.setAttribute("LIST_REQUEST", listRequestMuaNgay);

                } else {
                    List<RealEstateInfo> listRealEstate = dao.getAllRealEstate(1);
                    request.setAttribute("SEARCH_RESULT", listRealEstate);

                    List<PurchaseRequest> listRequestMuaNgay = dao1.getAllPurchaseRequests(realEstateId);
                    request.setAttribute("LIST_REQUEST", listRequestMuaNgay);

                }

                System.out.println(auctions);

                ArrayList<Image> listIMG = ImageDAO.getListImageByID(realEstateId);
                ArrayList<City> city = CityDAO.getCityList();
                RealEstateVM realEstateVM = realEstateDAO.getRealEstateById(realEstateId);

                System.out.println(realEstateVM);
                if (realEstateVM != null) {
                    request.setAttribute("realEstate", realEstateVM);
                    request.setAttribute("city", city);
                    request.setAttribute("listimg", listIMG);

                    url = "staff_detailRealEstate_approved.jsp";
                } else {
                    System.out.println("RealEstateDetailServlet null exception");
                }
            } else {
                url = "home";
            }
            request.getRequestDispatcher(url).forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
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
            Logger.getLogger(SearchRequestMuaNgayServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NamingException ex) {
            Logger.getLogger(SearchRequestMuaNgayServlet.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(SearchRequestMuaNgayServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NamingException ex) {
            Logger.getLogger(SearchRequestMuaNgayServlet.class.getName()).log(Level.SEVERE, null, ex);
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
