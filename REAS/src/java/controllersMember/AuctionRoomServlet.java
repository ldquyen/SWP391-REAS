package controllersMember;

import dao.AuctionDAO;
import dao.AuctionHistoryDAO;
import dao.CategoryDAO;
import dao.CityDAO;
import dao.ImageDAO;
import dao.RealEstateDAO;
import dto.Auction;
import dto.Category;
import dto.City;
import dto.Image;
import dto.RealEstate;
import dto.RealEstateInfo;
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
@WebServlet(name = "AuctionRoomServlet", urlPatterns = {"/AuctionRoomServlet"})
public class AuctionRoomServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    private final String AUCTIONROOM = "auctionRoom.jsp";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = AUCTIONROOM;
        try {
            String IDRE = request.getParameter("idRE3");

//            System.out.println(IDRE);
            AuctionDAO auctionDAO = new AuctionDAO();

            List<Auction> auctions = auctionDAO.getAuctions();

            ArrayList<City> city = CityDAO.getCityList();

            Auction auction = auctionDAO.getAuctionByRealEstateId(IDRE);

            ArrayList<Category> category = CategoryDAO.getListCategory();

            ArrayList<Image> listImgAuction = ImageDAO.getListImageByID(IDRE);

            ArrayList<RealEstate> REGETBYID = RealEstateDAO.getRealEstateByID(IDRE);
            
            //List top 5 price auction history
            AuctionHistoryDAO auctionHistoryDAO = new AuctionHistoryDAO();
            List<Integer> top5Prices = auctionHistoryDAO.getPriceTop5(auction.getAuctionID());
            System.out.println(top5Prices);
            request.setAttribute("TOP5Prices", top5Prices);

            RealEstateDAO dao = new RealEstateDAO();
            List<RealEstateInfo> listRealEstate = dao.getAllRealEstate(3);
            request.setAttribute("SEARCH_RESULT", listRealEstate);

            List<Auction> auctionV2 = auctionDAO.getAuctionsV2();
            request.setAttribute("auctionV2", auctionV2);

            request.setAttribute("REGETBYID", REGETBYID);
            request.setAttribute("city", city);
            request.setAttribute("category", category);
            request.setAttribute("listimgauction", listImgAuction);
//            System.out.println(listImgAuction);

            request.setAttribute("auctions", auctions);
            request.setAttribute("auction", auction);

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
