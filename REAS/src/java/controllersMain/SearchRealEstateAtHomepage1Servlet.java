/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllersMain;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.ImageDAO;
import dao.RealEstateDAO;
import dto.Image;
import dao.CityDAO;
import dto.City;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.RealEstateVM;

/**
 *
 * @author tranl
 */
@WebServlet(name = "SearchRealEstateAtHomepage1Servlet", urlPatterns = {"/SearchRealEstateAtHomepage1Servlet"})
public class SearchRealEstateAtHomepage1Servlet extends HttpServlet {

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
            throws ServletException, IOException, SQLException, ClassNotFoundException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            String loaihinhbds = request.getParameter("loaihinhbds");
            String thanhpho = request.getParameter("thanhpho");
            String dientich = request.getParameter("dientich");
            String mucgia = request.getParameter("mucgia");
            String name = request.getParameter("txtName");

            String locbds = "";
            String loctp = "";
            String locgia = "";
            String locdientich = "";
            String locname = "";

            if (!name.isEmpty()) {
                locname = "AND re.RealEstateName LIKE '%" + name + "%'";
            }

            if (!loaihinhbds.isEmpty()) {
                locbds = " AND re.CatID = '" + loaihinhbds + "'";
            }

            if (!thanhpho.isEmpty()) {
                loctp = " AND re.CityID = " + thanhpho + "";
            }

            if (!dientich.isEmpty()) {
                if (dientich.equals("100")) {
                    locdientich = " AND re.Area < 100";
                } else if (dientich.equals("500")) {
                    locdientich = " AND re.Area BETWEEN 100 AND 500";
                } else if (dientich.equals("1000")) {
                    locdientich = " AND re.Area BETWEEN 500 AND 1000";
                } else if (dientich.equals("1001")) {
                    locdientich = " AND re.Area > 1000";
                }
            }

            if (!mucgia.isEmpty()) {
                if (mucgia.equals("5")) {
                    locgia = " AND re.PriceFirst < 5000000000";
                } else if (mucgia.equals("10")) {
                    locgia = "AND re.PriceFirst BETWEEN 5000000000  AND 10000000000 ";
                } else if (mucgia.equals("50")) {
                    locgia = "AND re.PriceFirst BETWEEN 10000000000 AND 50000000000 ";
                } else if (mucgia.equals("100")) {
                    locgia = "AND re.PriceFirst BETWEEN 50000000000 AND 100000000000 ";
                } else if (mucgia.equals("101")) {
                    locgia = "AND re.PriceFirst > 100000000000 ";
                }
            }

            if (loaihinhbds.isEmpty() && thanhpho.isEmpty() && dientich.isEmpty() && mucgia.isEmpty() && name.isEmpty()) {
                RealEstateDAO realEstateDAO = new RealEstateDAO();
                ImageDAO imgDAO = new ImageDAO();
                List<RealEstateVM> list = realEstateDAO.getListAvailableRealEstate();
                request.setAttribute("list", list);
                List<Image> listImage = imgDAO.getListImage2();
                List<City> cityList = CityDAO.getCityList();
                request.setAttribute("city", cityList);
                request.setAttribute("listImg", listImage);
                request.getRequestDispatcher("MainController?action=homeindex").forward(request, response);
            } else {
                String sql = "SELECT re.RealEstateID, re.AccID, re.CityID, re.CatID, re.ImageFolderID, re.RealEstateName, re.PriceFirst, re.PriceLast, re.PricePaid, re.TimeUp, re.TimeDown, re.Address, re.Area, im.ImageLink1\n"
                        + "FROM dbo.RealEstate re JOIN dbo.Image im ON re.ImageFolderID = im.ImageFolderID\n"
                        + "WHERE re.StatusID = 1 " + locname + locbds + loctp + locdientich + locgia + "ORDER BY re.TimeUp DESC;";
                List<RealEstateVM> list = RealEstateDAO.getListAvailableRealEstateByFilterWithSQL(sql);
                ImageDAO imgDAO = new ImageDAO();
                request.setAttribute("list", list);
                List<Image> listImage = imgDAO.getListImage2();
                List<City> cityList = CityDAO.getCityList();
                request.setAttribute("city", cityList);
                request.setAttribute("listImg", listImage);

                request.setAttribute("name", name);
                request.setAttribute("loaihinhbds", loaihinhbds);
                request.setAttribute("thanhpho", thanhpho);
                request.setAttribute("dientich", dientich);
                request.setAttribute("mucgia", mucgia);
                request.getRequestDispatcher("MainController?action=homeindex").forward(request, response);
            }
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
        } catch (SQLException ex) {
            Logger.getLogger(SearchRealEstateAtHomepage1Servlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SearchRealEstateAtHomepage1Servlet.class.getName()).log(Level.SEVERE, null, ex);
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
        } catch (SQLException ex) {
            Logger.getLogger(SearchRealEstateAtHomepage1Servlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SearchRealEstateAtHomepage1Servlet.class.getName()).log(Level.SEVERE, null, ex);
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
