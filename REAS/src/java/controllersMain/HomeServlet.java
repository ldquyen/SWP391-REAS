/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllersMain;

import dao.ImageDAO;
import dao.RealEstateDAO;
import dto.Image;
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
 * @author sny12
 */
public class HomeServlet extends HttpServlet {

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
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet HomeServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet HomeServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
            request.setAttribute("list", list);
            ImageDAO imgDAO = new ImageDAO();
            List<Image> listImage = imgDAO.getListImage2();
            request.setAttribute("listImg", listImage);
            request.setAttribute("pagenum", pageNum);
            request.getRequestDispatcher("index.jsp").forward(request, response);
        } catch (ClassNotFoundException | SQLException  ex) {
            Logger.getLogger(HomeServlet.class.getName()).log(Level.SEVERE, null, ex);
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
