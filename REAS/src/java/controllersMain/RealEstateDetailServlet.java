/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controllersMain;

import dao.AuctionDAO;
import dao.RealEstateDAO;
import dto.Auction;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.RealEstateVM;

/**
 *
 * @author Admin
 */
public class RealEstateDetailServlet extends HttpServlet {

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

                RealEstateVM realEstateVM = realEstateDAO.getRealEstateById(realEstateId);
                if (realEstateVM != null) {
                    request.setAttribute("realEstate", realEstateVM);
                    url = "detailRealEstate.jsp";
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

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
