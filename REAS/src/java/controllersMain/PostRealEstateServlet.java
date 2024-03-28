/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllersMain;

import dao.ImageDAO;
import dao.RealEstateDAO;
import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author ADMIN
 */
@WebServlet(name = "PostRealEstateServlet", urlPatterns = {"/PostRealEstateServlet"})
@MultipartConfig
public class PostRealEstateServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = "postRealEstate.jsp";
        /*1*/
        String accID = request.getParameter("accID");
        /*2*/
        String realEstateID;
        /*3*/
        String realEstateName = request.getParameter("realEstateName");
        /*4*/
        String catID = request.getParameter("catID");
        /*5*/
        int cityID = Integer.parseInt(request.getParameter("cityID"));
        /*6*/
        long priceFirst = 0;
        String priceFirstStr = request.getParameter("priceFirst");
        if (priceFirstStr != null) {
            priceFirstStr = priceFirstStr.replaceAll("[,.]", "");
            if (priceFirstStr != null && !priceFirstStr.isEmpty()) {
                // Nếu có thì parse sang long
                priceFirst = Long.parseLong(priceFirstStr);
                if (priceFirst <= 0) {
                    request.setAttribute("Wrong_PriceFirst", "Số tiền phải lớn hơn 0!!!");
                    RequestDispatcher rd = request.getRequestDispatcher(url);
                    rd.forward(request, response);
                    return;
                }
            }
        }
        /*7*/
        long priceLast = 0;
        String priceLastStr = request.getParameter("priceLast");
        if (priceLastStr != null && !priceLastStr.isEmpty()) {
            // Nếu có thì parse sang long
            priceLast = Long.parseLong(priceLastStr);
        }
        /*8*/
        long pricePaid = 0;
        String pricePaidStr = request.getParameter("pricePaid");
        if (pricePaidStr != null && !pricePaidStr.isEmpty()) {
            pricePaidStr = pricePaidStr.replaceAll("[,.]", "");
            pricePaid = Long.parseLong(pricePaidStr);
        } else {
            int[] top1 = {9, 19, 25, 27, 58};
            int[] top2 = {2, 7, 8, 11, 12, 14, 15, 20, 26, 38, 40, 44, 46, 47, 50, 55, 57, 59, 61};
            int[] top3 = {1, 3, 4, 5, 6, 10, 13, 16, 17, 18, 21, 22, 23, 24, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 39, 41, 42, 43, 45, 48, 49, 51, 52, 53, 54, 56, 62, 63};

            if (Arrays.binarySearch(top1, cityID) >= 0) {
                pricePaid = (priceFirst * 120) / 100;
            }
            if (Arrays.binarySearch(top2, cityID) >= 0) {
                pricePaid = (priceFirst * 110) / 100;
            }
            if (Arrays.binarySearch(top3, cityID) >= 0) {
                pricePaid = (priceFirst * 105) / 100;
            }
        }

        long lamda = (long) (priceFirst * 0.01);
        /*9*/
        int statusID;
        String statusStr = request.getParameter("status");

        if (statusStr != null && !statusStr.isEmpty()) {
            statusID = Integer.parseInt(statusStr);
        } else {
            statusID = 0;
        }
        /*10*/
        String timeUpStr = request.getParameter("timeStart");

        LocalDateTime timeUp = LocalDateTime.parse(timeUpStr, DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm"));
        LocalDateTime timeDown = timeUp.plusHours(3);
        /*11*/
        String address = request.getParameter("address");
        /*12*/
        int area = 0;
        String areaStr = request.getParameter("area");
        areaStr = areaStr.replace(",", "");
        if (isNumeric(areaStr)) {
            area = Integer.parseInt(areaStr);
            if (area <= 0) {
                request.setAttribute("Wrong_Area", "Diện tích phải LỚN HƠN 0!!!");
                RequestDispatcher rd = request.getRequestDispatcher(url);
                rd.forward(request, response);
                return;
            }
        } else {
            request.setAttribute("Wrong_Area_Nummeric", "Diện tích phải là một SỐ!!!");
            RequestDispatcher rd = request.getRequestDispatcher(url);
            rd.forward(request, response);
            return;
        }
        /*13*/
        String detail = request.getParameter("detail");

        /*14*/
        Part imagePart1 = request.getPart("image1");
        Part imagePart2 = request.getPart("image2");
        Part imagePart3 = request.getPart("image3");

        /*15*/
        String imageFolderID;

        try {
            RealEstateDAO dao = new RealEstateDAO();
            int i = 0;
            do {
                i++;
                String i1 = Integer.toString(i);
                realEstateID = "M" + i1;
            } while (dao.checkRealEstateIDExists(realEstateID));
            imageFolderID = realEstateID;
            ImageDAO.saveImg(imageFolderID, imagePart1, imagePart2, imagePart3);

            boolean result = dao.createPost(realEstateID, imageFolderID, accID, catID, cityID, realEstateName, priceFirst, timeUp, timeDown,
                    priceLast, pricePaid, statusID, area, address, detail, lamda);

            if (result) {
                url = "postRealEstate.jsp";
                request.setAttribute("Success", "Bài Đấu Giá Của Bạn Đã Gửi THÀNH CÔNG, vui lòng đợi hệ thống xét duyệt!!!");
                RequestDispatcher rd = request.getRequestDispatcher(url);
                rd.forward(request, response);
            } else {
                url = "postRealEstate.jsp";
                request.setAttribute("Fail", "Bài Đấu Giá Của Bạn Gửi THẤT BẠI, hãy thử l!!!");
                RequestDispatcher rd = request.getRequestDispatcher(url);
                rd.forward(request, response);
                return;
            }
        } catch (ClassNotFoundException | SQLException | NamingException ex) {
            Logger.getLogger(PostRealEstateServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void main(String[] args) {
        int[] top1 = {9, 19, 25, 27, 58};
        int[] top2 = {2, 7, 8, 11, 12, 14, 15, 20, 26, 38, 40, 44, 46, 47, 50, 55, 57, 59, 61};
        int[] top3 = {1, 3, 4, 5, 6, 10, 13, 16, 17, 18, 21, 22, 23, 24, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 39, 41, 42, 43, 45, 48, 49, 51, 52, 53, 54, 56, 62, 63};

        Set<Integer> set = new HashSet<>();
        // Kiểm tra phần tử trùng lặp trong top1
        for (int num : top1) {
            if (!set.add(num)) {
                System.out.println("Phần tử trùng lặp: " + num);
            }
        }

        // Kiểm tra phần tử trùng lặp trong top2
        for (int num : top2) {
            if (!set.add(num)) {
                System.out.println("Phần tử trùng lặp: " + num);
            }
        }

        // Kiểm tra phần tử trùng lặp trong top3
        for (int num : top3) {
            if (!set.add(num)) {
                System.out.println("Phần tử trùng lặp: " + num);
            }
        }

        if (set.isEmpty()) {
            System.out.println("Không có phần tử nào trùng lặp giữa ba mảng.");
        }
    }

    public boolean isNumeric(String str) {
        return str != null && str.matches("-?\\d+");
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
