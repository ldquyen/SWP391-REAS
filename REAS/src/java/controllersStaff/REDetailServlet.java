/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllersStaff;

import dao.AuctionDAO;
import dao.CityDAO;
import dao.ImageDAO;
import dao.RealEstateDAO;
import dto.Auction;
import dto.City;
import dto.Image;
import dto.RealEstateInfo;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
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
@WebServlet(name = "REDetailServlet", urlPatterns = {"/REDetailServlet"})
public class REDetailServlet extends HttpServlet {

 
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String url = "";
            String realEstateId = request.getParameter("id");
            if (realEstateId != null) {
                RealEstateDAO realEstateDAO = new RealEstateDAO();
                AuctionDAO auctionDAO = new AuctionDAO();

                List<Auction> auctions = auctionDAO.getAuctions();
                request.setAttribute("Auctions", auctions);

                RealEstateDAO dao = new RealEstateDAO();
                List<RealEstateInfo> listRealEstate = dao.getAllRealEstate(0);
                request.setAttribute("SEARCH_RESULT", listRealEstate);


                System.out.println(auctions);

                ArrayList<Image> listIMG = ImageDAO.getListImageByID(realEstateId);
                ArrayList<City> city = CityDAO.getCityList();
                RealEstateVM realEstateVM = realEstateDAO.getRealEstateById(realEstateId);

                System.out.println(realEstateVM);
                if (realEstateVM != null) {
                    request.setAttribute("realEstate", realEstateVM);
                    request.setAttribute("city", city);
                    request.setAttribute("listimg", listIMG);

                    url = "staff_detailRealEstate.jsp";
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
