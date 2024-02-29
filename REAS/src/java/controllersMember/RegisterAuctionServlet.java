
package controllersMember;

import dao.AccountDAO;
import dao.AuctionDAO;
import dto.Account;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
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
@WebServlet(name = "RegisterAuctionServlet", urlPatterns = {"/RegisterAuctionServlet"})
public class RegisterAuctionServlet extends HttpServlet {

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
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = REGISTERAUCTION;

        try {
            // get auctionid
            // get accountblance check so voi priceNow + phi tham gia dau gia 5%.
            // neu thoa thi se update wallet
            // tao them auctionDepositHistory
            // tao walletTranscationHistory.
            AccountDAO accountDAO = new AccountDAO();
            AuctionDAO auctionDAO = new AuctionDAO();
            double requirmentPrice = 0; // gia yeu ca de co the tham gia dau gia = priceNow + 5% phi cua pricenow.
            double registerFee = 0; // 5% cua price now.
            // get auctionId
            String auctionIds = request.getParameter("auctionId");
            HttpSession session = request.getSession(false);
            if (session != null && session.getAttribute("member") != null) {
                Account account = (Account) session.getAttribute("member");
                // get current userBalance.
                double currentUserBalance = accountDAO.getAccountWallet(account.getAccID());
                int userWalletId = accountDAO.getUserWalletId(account.getAccID());
                // get priceNow
                double auctionPriceNow = auctionDAO.getCurrentPriceNow(auctionIds);
                registerFee = auctionPriceNow * 0.05;
                requirmentPrice = auctionPriceNow + registerFee;
                // Handle logic ben trong DAO. se tra ve code
                int result = auctionDAO.registerAuction(auctionIds, auctionIds, currentUserBalance, requirmentPrice, userWalletId);
                System.out.println("UserWAlleet - " + userWalletId);
                System.out.println("Current Balance - " + currentUserBalance);
                System.out.println("Phi dang ki dau gia - " + registerFee);
                System.out.println("Gia yeu cau de tham gia - " + requirmentPrice);
                if(result == 5) {
                    System.out.println("Successfully");
                } else {
                    System.out.println("Code - " + result);
                }
                 
            } else {
                response.sendRedirect(LOGIN);
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error fetching auctions");
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

