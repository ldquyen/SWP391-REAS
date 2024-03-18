/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controllersMain;

import dao.AuctionDAO;
import dao.CityDAO;
import dao.ImageDAO;
import dao.RealEstateDAO;
import dto.Auction;
import dto.City;
import dto.Image;
import dto.RealEstateInfo;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
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

                RealEstateDAO dao = new RealEstateDAO();
                List<RealEstateInfo> listRealEstate = dao.getAllRealEstate(1);
                request.setAttribute("SEARCH_RESULT", listRealEstate);
                // Sắp xếp danh sách theo thời gian cập nhật mới nhất
//                Collections.sort(listRealEstate, Comparator.comparing(RealEstateInfo::getTimeUp).reversed());
                // Chỉ lấy 3 bất động sản đầu tiên
//                List<RealEstateInfo> top3RealEstate = listRealEstate.subList(0, Math.min(3, listRealEstate.size()));
//                request.setAttribute("TOP_3_REAL_ESTATE", top3RealEstate);

// Tạo một seed ngẫu nhiên
                if (listRealEstate != null && !listRealEstate.isEmpty()) {
                    // Shuffle listRealEstate
                    long seed = System.nanoTime();
                    Collections.shuffle(listRealEstate, new Random(seed));
                    
                    // Get a sublist of randomRealEstate
                    int numberOfRandomElements = 3;
                    List<RealEstateInfo> randomRealEstate = listRealEstate.subList(0, Math.min(numberOfRandomElements, listRealEstate.size()));
                    request.setAttribute("RANDOM_REAL_ESTATE", randomRealEstate);
                } else {
                    // Handle case where listRealEstate is empty or null
                    System.out.println("RealEstateDetailServlet: No real estate found");
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
