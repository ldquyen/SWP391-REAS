/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllersMember;

import dao.AccountDAO;
import dao.AuctionDAO;
import dao.CategoryDAO;
import dao.CityDAO;
import dao.ImageDAO;
import dao.RealEstateDAO;
import dto.Account;
import dto.Auction;
import dto.Category;
import dto.City;
import dto.Image;
import dto.RealEstate;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author tranl
 */
@WebServlet(name = "AuctionServlet", urlPatterns = {"/AuctionServlet"})
public class AuctionServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    private final String REGISTERAUCTION = "registerAuction.jsp";
    private final String LOGIN = "login.jsp";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClassNotFoundException, SQLException, NamingException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            String idauctionbid = request.getParameter("idAuctionBID");
            String pricenowbid = request.getParameter("priceNowBid");

            AuctionDAO auctionDAO = new AuctionDAO();
            AccountDAO accountDAO = new AccountDAO();

            // get auctionid
            // get accountblance check so voi priceNow + phi tham gia dau gia 5%.
            // neu thoa thi se update wallet
            // tao them auctionDepositHistory
            // tao walletTranscationHistory.
            double requirmentPrice = 0; // gia yeu ca de co the tham gia dau gia = priceNow + 5% phi cua pricenow.
            double registerFee = 0; // 5% cua price now.
            // get auctionId
            HttpSession session = request.getSession(false);
            if (session != null && session.getAttribute("member") != null) {
                double priceRegisterAuction = Double.parseDouble(pricenowbid);
                Account account = (Account) session.getAttribute("member");
                // get current userBalance.
                double currentUserBalance = accountDAO.getAccountWallet(account.getAccID());
                int userWalletId = accountDAO.getUserWalletId(account.getAccID());
                // get priceNow
                // Check phi dau gia co cao hon tien trong vi khong.
                registerFee = priceRegisterAuction * 0.05;
                requirmentPrice = priceRegisterAuction + registerFee;
                if (currentUserBalance >= requirmentPrice) {
                    // neu thoa thi update pricenow cua auction.
                    auctionDAO.setPriceNowAuctions(pricenowbid, idauctionbid);
                }
                double auctionPriceNow = auctionDAO.getCurrentPriceNow(idauctionbid);
                    
                // Handle logic ben trong DAO. se tra ve code
                int result = auctionDAO.registerAuction(idauctionbid, account.getAccID(), currentUserBalance, requirmentPrice, userWalletId, auctionPriceNow);
                System.out.println("UserWAlleet - " + userWalletId);
                System.out.println("Current Balance - " + currentUserBalance);
                System.out.println("Phi dang ki dau gia - " + registerFee);
                System.out.println("Gia yeu cau de tham gia - " + requirmentPrice);
                if (result == 5) {
                    System.out.println("Successfully");
                    // Cap nhat lich su dau gia.
                } else {
                    System.out.println("Code - " + result);
                }

            } else {
                response.sendRedirect(LOGIN);
            }

            List<Auction> auctions = auctionDAO.getAuctions();
            ArrayList<City> city = CityDAO.getCityList();
            ArrayList<Category> category = CategoryDAO.getListCategory();
            ArrayList<Image> listImgAuction = ImageDAO.getListImageByID(idauctionbid);

            ArrayList<RealEstate> REGETBYID = RealEstateDAO.getRealEstateByID(idauctionbid);
            
             List<Auction> auctionV2 = auctionDAO.getAuctionsV2();
            request.setAttribute("auctionV2", auctionV2);
            
            request.setAttribute("REGETBYID", REGETBYID);
            request.setAttribute("city", city);
            request.setAttribute("category", category);
            request.setAttribute("listimgauction", listImgAuction);
//            System.out.println(listImgAuction);

            request.setAttribute("auctions", auctions);
            request.setAttribute("priceoldbid", pricenowbid);

            request.getRequestDispatcher("MemberController?action=auctionRoom").forward(request, response);
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
            Logger.getLogger(AuctionServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(AuctionServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NamingException ex) {
            Logger.getLogger(AuctionServlet.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(AuctionServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(AuctionServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NamingException ex) {
            Logger.getLogger(AuctionServlet.class.getName()).log(Level.SEVERE, null, ex);
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
