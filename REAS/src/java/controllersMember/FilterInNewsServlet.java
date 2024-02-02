package controllersMember;

import dao.CategoryDAO;
import dao.CityDAO;
import dao.RealEstateDAO;
import dto.Category;
import dto.City;
import dto.RealEstate;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class FilterInNewsServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClassNotFoundException, SQLException, NamingException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String loaihinhbds = request.getParameter("loaihinhbds");
            String thanhpho = request.getParameter("thanhpho");
            String mucgia = request.getParameter("mucgia");

            String locbds = "";
            String loctp = "";
            String locgia = "";

            if (!loaihinhbds.isEmpty()) {
                locbds = " AND CatID = '" + loaihinhbds + "'";
            }

            if (!thanhpho.isEmpty()) {
                loctp = " AND CityID = " + thanhpho + "";
            }

            if (!mucgia.isEmpty()) {
                locgia = " ORDER BY Area " + mucgia;
            }
            if (loaihinhbds.isEmpty() && thanhpho.isEmpty() && mucgia.isEmpty()) {
                String sql = "SELECT [RealEstateID], [ImageFolderID], [AccID], [CatID], [CityID], [RealEstateName], [PriceFirst], [TimeUp], [TimeDown], [PriceLast],[PricePaid], [StatusID], [Area], [Address], [Status] ,[Detail] \n"
                    + "FROM RealEstate WHERE [Status] = ?";
                ArrayList<RealEstate> listRE = RealEstateDAO.getRealEstateByStatus(sql, 4);
                ArrayList<City> listCity = CityDAO.getCityList();
                ArrayList<Category> listCategory = CategoryDAO.getListCategory();

                request.setAttribute("listRealEstateInNews", listRE);
                HttpSession session = request.getSession();
                session.setAttribute("CITYLIST", listCity);
                session.setAttribute("CATEGORYLIST", listCategory);
                request.getRequestDispatcher("MemberController?action=newsjsp").forward(request, response);
            } else {
                String sql1 = "SELECT [RealEstateID], [ImageFolderID], [AccID], [CatID], [CityID], [RealEstateName], [PriceFirst], [TimeUp], [TimeDown], [PriceLast],[PricePaid], [StatusID], [Area], [Address], [Status] ,[Detail] \n"
                    + "FROM RealEstate WHERE [Status] = ?" + locbds + loctp + locgia;
                ArrayList<RealEstate> listRE = RealEstateDAO.getRealEstateByStatus(sql1, 4);
                ArrayList<City> listCity = CityDAO.getCityList();
                ArrayList<Category> listCategory = CategoryDAO.getListCategory();

                request.setAttribute("listRealEstateInNews", listRE);
                HttpSession session = request.getSession();
                session.setAttribute("CITYLIST", listCity);
                session.setAttribute("CATEGORYLIST", listCategory);
                request.setAttribute("mucgia", mucgia);
                request.setAttribute("thanhpho", thanhpho);
                request.setAttribute("loaihinhbds", loaihinhbds);
                request.getRequestDispatcher("MemberController?action=newsjsp").forward(request, response);
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
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FilterInNewsServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(FilterInNewsServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NamingException ex) {
            Logger.getLogger(FilterInNewsServlet.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(FilterInNewsServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(FilterInNewsServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NamingException ex) {
            Logger.getLogger(FilterInNewsServlet.class.getName()).log(Level.SEVERE, null, ex);
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
