/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllersMain;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import controllersAdmin.Constants;
import dao.AccountDAO;
import dao.GoogleDAO;
import dto.Account;
import dto.UserGoogle;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.fluent.Request;
import org.apache.http.client.fluent.Form;

/**
 *
 * @author tranl
 */
@WebServlet(name = "LoginGoogleServlet", urlPatterns = {"/LoginGoogleServlet"})
public class LoginGoogleServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    private final String HOMEPAGE = "register.jsp";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, Exception {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        boolean error = false;
        String url = HOMEPAGE;

        try {
            String code = request.getParameter("code");
            String accessToken = getToken(code);
            UserGoogle userGoogle = getUserInfo(accessToken);
            HttpSession session = request.getSession();
            session.setAttribute("userGoogle", userGoogle);

            System.out.println(userGoogle);

            String id = userGoogle.getId();
            String email = userGoogle.getEmail();
            boolean verified_email = userGoogle.isVerified_email();
            String name = userGoogle.getName();
            String given_name = userGoogle.getGiven_name();
            String family_name = userGoogle.getFamily_name();
            String picture = userGoogle.getPicture();


            // Tìm vị trí của chuỗi "@"
            int atIndex = email.indexOf("@");

            // Trích xuất phần đầu của chuỗi trước vị trí của "@"
            String username = email.substring(0, atIndex);
            
            request.setAttribute("updateinfo", "Bạn cần cập nhật thêm một vài thông tin");
            session.setAttribute("ggusername", username);
            request.setAttribute("ggemail", email);
            request.setAttribute("gggiven_name", given_name);

            GoogleDAO ggacc = new GoogleDAO();

            if (ggacc.checkIDGoogle(id)) {
                error = true;
                url = "HomeServletIndex_1";
            } else {
                boolean bl = ggacc.saveUserGoogle(id, email, verified_email, name, given_name, family_name, picture);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(LoginGoogleServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (NamingException ex) {
            ex.printStackTrace();
        } finally {
            RequestDispatcher rd = request.getRequestDispatcher(url);
            rd.forward(request, response);
            out.close();
        }
    }

    public static String getToken(String code) throws ClientProtocolException, IOException {
        // call api to get token
        String response = Request.Post(Constants.GOOGLE_LINK_GET_TOKEN)
                .bodyForm(Form.form().add("client_id", Constants.GOOGLE_CLIENT_ID)
                        .add("client_secret", Constants.GOOGLE_CLIENT_SECRET)
                        .add("redirect_uri", Constants.GOOGLE_REDIRECT_URI).add("code", code)
                        .add("grant_type", Constants.GOOGLE_GRANT_TYPE).build())
                .execute().returnContent().asString();
        JsonObject jobj = new Gson().fromJson(response, JsonObject.class);
        String accessToken = jobj.get("access_token").toString().replaceAll("\"", "");
        return accessToken;
    }

    public static UserGoogle getUserInfo(final String accessToken) throws ClientProtocolException, IOException {
        //gui req len gg minh co authen token keu tra dl nguoi dung
        String link = Constants.GOOGLE_LINK_GET_USER_INFO + accessToken;
        String response = Request.Get(link).execute().returnContent().asString();
        // va tra ve class nay dum minh
        UserGoogle googlePojo = new Gson().fromJson(response, UserGoogle.class);
        return googlePojo;
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the +
    // sign on the left to edit the code.">
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
        } catch (Exception ex) {
            Logger.getLogger(LoginGoogleServlet.class.getName()).log(Level.SEVERE, null, ex);
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
        } catch (Exception ex) {
            Logger.getLogger(LoginGoogleServlet.class.getName()).log(Level.SEVERE, null, ex);
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
