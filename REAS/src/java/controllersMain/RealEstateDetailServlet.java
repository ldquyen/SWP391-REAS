/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controllersMain;

import dao.AuctionDAO;
import dao.CityDAO;
import dao.ImageDAO;
import dao.PurchaseRequestDAO;
import dao.RealEstateDAO;
import dto.Account;
import dto.Auction;
import dto.City;
import dto.Image;
import dto.RealEstateInfo;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.RealEstateVM;

/**
 *
 * @author Admin
 */
public class RealEstateDetailServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");

        try {
            String url = "";
            String realEstateId = request.getParameter("id");

            if (realEstateId != null) {
                RealEstateDAO realEstateDAO = new RealEstateDAO();
                AuctionDAO auctionDAO = new AuctionDAO();

                List<Auction> auctions = auctionDAO.getAuctions();
                request.setAttribute("Auctions", auctions);

                ArrayList<Image> listIMG = ImageDAO.getListImageByID(realEstateId);
                ArrayList<City> city = CityDAO.getCityList();
                RealEstateVM realEstateVM = realEstateDAO.getRealEstateById(realEstateId);

                if (action.equals("viewPostRealEstate")) {
                    if (realEstateVM != null) {
                        request.setAttribute("realEstate", realEstateVM);
                        request.setAttribute("city", city);
                        request.setAttribute("listimg", listIMG);
                        //===
                        RealEstateDAO dao = new RealEstateDAO();
                        List<RealEstateInfo> listRealEstate = dao.getAllRealEstate(1);
                        request.setAttribute("SEARCH_RESULT", listRealEstate);

                        HttpSession session = request.getSession(false);
                        Account member = (Account) session.getAttribute("member");
                        String accID = member.getAccID();

                        PurchaseRequestDAO dao1 = new PurchaseRequestDAO();
                        Integer purchaseStatus = dao1.getPurchaseStatus(realEstateId, accID);
                        // Sau khi lấy được purchaseStatus từ DAO, bạn có thể sử dụng nó cho mục đích của mình
                        // Ví dụ: lưu purchaseStatus vào request attribute để sử dụng trong JSP
                        request.setAttribute("purchaseStatus", purchaseStatus);

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
                        //=====
                        url = "detailRealEstate.jsp";
                    } else {
                        System.out.println("RealEstateDetailServlet null exception");
                    }
                }
                if (action.equals("viewPostRealEstateStatus2")) {
                    if (realEstateVM != null) {
                        request.setAttribute("realEstate", realEstateVM);
                        request.setAttribute("city", city);
                        request.setAttribute("listimg", listIMG);

                        RealEstateDAO dao = new RealEstateDAO();
                        List<RealEstateInfo> listRealEstate = dao.getAllRealEstate(2);
                        request.setAttribute("SEARCH_RESULT", listRealEstate);

                        url = "detailRealEstate_status2.jsp";
                    } else {
                        System.out.println("RealEstateDetailServlet null exception");
                    }
                }
                if (action.equals("viewPostRealEstateGuest")) {
                    if (realEstateVM != null) {
                        request.setAttribute("realEstate", realEstateVM);
                        request.setAttribute("city", city);
                        request.setAttribute("listimg", listIMG);

                        RealEstateDAO dao = new RealEstateDAO();
                        List<RealEstateInfo> listRealEstate = dao.getAllRealEstate(1);
                        request.setAttribute("SEARCH_RESULT", listRealEstate);
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
                        //=====
                        url = "detailRealEstate_guest.jsp";
                    } else {
                        System.out.println("RealEstateDetailServlet null exception");
                    }
                }
                if (action.equals("cusViewMuaNgayList")) {
                    if (realEstateVM != null) {
                        request.setAttribute("realEstate", realEstateVM);
                        request.setAttribute("city", city);
                        request.setAttribute("listimg", listIMG);
                        //===
                        RealEstateDAO dao = new RealEstateDAO();
                        List<RealEstateInfo> listRealEstate = dao.getAllRealEstate(1);
                        request.setAttribute("SEARCH_RESULT", listRealEstate);

                        HttpSession session = request.getSession(false);
                        Account member = (Account) session.getAttribute("member");
                        String accID = member.getAccID();

                        PurchaseRequestDAO dao1 = new PurchaseRequestDAO();
                        Integer purchaseStatus = dao1.getPurchaseStatus(realEstateId, accID);
                        request.setAttribute("purchaseStatus", purchaseStatus);

                        url = "cus_detailRealEstate_MuaNgay.jsp";
                    } else {
                        System.out.println("RealEstateDetailServlet null exception");
                    }
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
