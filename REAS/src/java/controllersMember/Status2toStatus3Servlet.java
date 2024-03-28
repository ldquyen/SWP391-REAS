/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllersMember;

import dao.AuctionDAO;
import dao.CategoryDAO;
import dao.CityDAO;
import dao.RealEstateDAO;
import dto.Auction;
import dto.Category;
import dto.City;
import dto.RealEstate;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author tranl
 */
@WebServlet(name = "Status2toStatus3Servlet", urlPatterns = {"/Status2toStatus3Servlet"})
public class Status2toStatus3Servlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    private final String AUCTIONLISTPAGE = "auctionList.jsp";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = AUCTIONLISTPAGE;

        String idreal = request.getParameter("idAuction2to3");
        System.out.println(idreal);
        try {
            AuctionDAO auctionDAO = new AuctionDAO();
            List<Auction> auctions = auctionDAO.getAuctions();
            auctionDAO.setStatusTimeEndAuctions(3, idreal);
            ArrayList<City> city = CityDAO.getCityList();
            ArrayList<Category> category = CategoryDAO.getListCategory();

            String sql = "SELECT [RealEstateID], [ImageFolderID], [AccID], [CatID], [CityID], [RealEstateName], [PriceFirst], [TimeUp], [TimeDown], [PriceLast],[PricePaid], [StatusID], [Area], [Address] ,[Detail] \n"
                    + "FROM RealEstate WHERE [StatusID] = ?";
            ArrayList<RealEstate> listRE2 = RealEstateDAO.getRealEstateByStatus(sql, 2);
            ArrayList<RealEstate> listRE3 = RealEstateDAO.getRealEstateByStatus(sql, 3);

            request.setAttribute("listRE2", listRE2);
            request.setAttribute("listRE3", listRE3);
            request.setAttribute("city", city);
            request.setAttribute("category", category);

            request.setAttribute("auctions", auctions);

        } catch (Exception e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error fetching auctions");
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
