/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllersMain;

import dao.CityDAO;
import dao.ImageDAO;
import dao.RealEstateDAO;
import dto.City;
import dto.Image;
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
import model.RealEstateVM;

/**
 *
 * @author tranl
 */
@WebServlet(name = "HomeServletIndex_1", urlPatterns = {"/HomeServletIndex_1"})
public class HomeServletIndex_1 extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, NamingException {
        response.setContentType("text/html;charset=UTF-8");
        try {
            int pageNum = request.getParameter("pagenum") != null ? Integer.parseInt(request.getParameter("pagenum")) : 1;
            RealEstateDAO realEstateDAO = new RealEstateDAO();

            String sql = "SELECT [RealEstateID], [ImageFolderID], [AccID], [CatID], [CityID], [RealEstateName], [PriceFirst], [TimeUp], [TimeDown], [PriceLast], [Status], [Area], [Address], [Detail] \n"
                    + "FROM RealEstate WHERE [Status] = ?";
//            List<RealEstate> list = Pagination.paging(realEstateDAO.getRealEstateByStatus(sql, 1), pageNum);
//            int totalPage = realEstateDAO.getRealEstateByStatus(sql, 1).size() % 5 == 0? realEstateDAO.getRealEstateByStatus(sql, 1).size() / 5 : 
//                    (realEstateDAO.getRealEstateByStatus(sql, 1).size() / 5 + 1);
//            request.setAttribute("list", list);
//            request.setAttribute("totalPage", totalPage);

            List<RealEstateVM> list = realEstateDAO.getListAvailableRealEstate();
            int SoLuongDuAn = realEstateDAO.countRowsInTable();
            ArrayList<City> city = CityDAO.getCityList();
            request.setAttribute("list", list);
            ImageDAO imgDAO = new ImageDAO();
            List<Image> listImage = imgDAO.getListImage2();
            request.setAttribute("listImg", listImage);
            request.setAttribute("SoLuongDuAn", SoLuongDuAn);
            request.setAttribute("pagenum", pageNum);
            request.setAttribute("city", city);
            request.getRequestDispatcher("index_1.jsp").forward(request, response);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(HomeServletIndex_1.class.getName()).log(Level.SEVERE, null, ex);
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
        } catch (NamingException ex) {
            Logger.getLogger(HomeServletIndex_1.class.getName()).log(Level.SEVERE, null, ex);
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
        } catch (NamingException ex) {
            Logger.getLogger(HomeServletIndex_1.class.getName()).log(Level.SEVERE, null, ex);
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
