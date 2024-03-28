/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllersMember;

import dao.AccountDAO;
import dao.AuctionDAO;
import dao.AuctionWinningHistoryDAO;
import dao.RealEstateDAO;
import dto.Account;
import dto.Auction;
import dto.RealEstate;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.AuctionResultVM;

/**
 *
 * @author tranl
 */
@WebServlet(name = "ResultAuctionServlet", urlPatterns = {"/ResultAuctionServlet"})
public class ResultAuctionServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    private final String RESULTAUCTION = "resultAuction.jsp";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = RESULTAUCTION;

        String idreal = request.getParameter("idAuctionResult");
        System.out.println(idreal);
        try {
            AuctionDAO auctionDAO = new AuctionDAO();
            List<Auction> auctions = auctionDAO.getAuctions();
            request.setAttribute("auctions", auctions);

            auctionDAO.setStatusTimeEndAuctions(4, idreal);
            AuctionResultVM auctionResult = auctionDAO.getAuctionResult(idreal);

            ArrayList<RealEstate> REGETBYID = RealEstateDAO.getRealEstateByID(idreal);
            request.setAttribute("REGETBYID", REGETBYID);
            request.setAttribute("AuctionResult", auctionResult);

            AuctionWinningHistoryDAO auctionwinning = new AuctionWinningHistoryDAO();
            List<Object> topPrices = auctionwinning.getPriceTop1();
            String idmemwin = topPrices.get(1).toString(); // Convert Object to String
            int priceLast = (int) topPrices.get(0);

            AccountDAO accDao = new AccountDAO();
            Account accountmember = accDao.getAccountByID(idmemwin);
            ArrayList<Account> accountfull = accDao.getAllAccount();

// Create a list or an array to hold the account member
            List<Account> accountMembers = new ArrayList<>();
            accountMembers.add(accountmember); // Add the retrieved account to the list

            request.setAttribute("accountmember", accountMembers); // Set the list as an attribute
            request.setAttribute("accountfull", accountfull); // Set the list as an attribute

            request.setAttribute("priceLast", priceLast);

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
