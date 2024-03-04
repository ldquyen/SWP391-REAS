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
            priceFirstStr = priceFirstStr.replace(",", "");
            if (priceFirstStr != null && !priceFirstStr.isEmpty()) {
                // Nếu có thì parse sang long
                priceFirst = Long.parseLong(priceFirstStr);
                if (priceFirst <= 0) {
                    request.setAttribute("Wrong_PriceFirst", "Số tiền phải lớn hơn 0!!!");
                    RequestDispatcher rd = request.getRequestDispatcher(url);
                    rd.forward(request, response);
                }
            }
        }
        /*7*/
        long priceLast;
        String priceLastStr = request.getParameter("priceLast");
        if (priceLastStr != null && !priceLastStr.isEmpty()) {
            // Nếu có thì parse sang long
            priceLast = Long.parseLong(priceLastStr);
        } else {
            // Nếu không thì mặc định = 0
            priceLast = 0;
        }
        /*8*/
        long pricePaid = (priceFirst * 120) / 100;
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
        String timeDownStr = request.getParameter("timeEnd");

        LocalDateTime timeUp = LocalDateTime.parse(timeUpStr, DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm"));
        LocalDateTime timeDown = LocalDateTime.parse(timeDownStr, DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm"));
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
            }
        } else {
            request.setAttribute("Wrong_Area_Nummeric", "Diện tích phải là một SỐ!!!");
            RequestDispatcher rd = request.getRequestDispatcher(url);
            rd.forward(request, response);
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
                    priceLast, pricePaid, statusID, area, address, detail);

            if (result) {
                url = "postRealEstate.jsp";
                request.setAttribute("Success", "Bài Đấu Giá Của Bạn Đã Gửi Thành Công, vui lòng đợi hệ thống xét duyệt!!!");
            } else {
                url = "rule.jsp";
            }
        } catch (ClassNotFoundException | SQLException | NamingException ex) {
            Logger.getLogger(PostRealEstateServlet.class.getName()).log(Level.SEVERE, null, ex);
        } finally {

            RequestDispatcher rd = request.getRequestDispatcher(url);
            rd.forward(request, response);
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
