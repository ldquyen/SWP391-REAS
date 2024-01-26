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
    private final String HOMEPAGE = "index_1.jsp";
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String code = request.getParameter("code");
        String accessToken = getToken(code);
        UserGoogle userGoogle = getUserInfo(accessToken);
        String url = HOMEPAGE;
        
//        System.out.println(getUserInfo(accessToken));
        
//        System.out.println(userGoogle);

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
        
        GoogleDAO ggacc = new GoogleDAO();
        try {
            boolean bl = ggacc.saveUserGoogle(id, email, verified_email, name, given_name, family_name, picture);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(LoginGoogleServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        System.out.println(email);


//        String id = userGoogle.getId();
//        System.out.println(id);
//            String username = request.getParameter("txtUsername");
//            String email = request.getParameter("txtEmail");
//            String phone = request.getParameter("txtPhone");
//            String cccd = request.getParameter("txtCCCD");
//            String address = request.getParameter("txtAddress");
//            String cccdregplace = request.getParameter("txtCCCDRegplace");
//            String cccdregdate = request.getParameter("txtCCCDRegdate");
//            String bankname = request.getParameter("txtBankname");
//            String bankcode = request.getParameter("txtBankcode");
//            String password = request.getParameter("txtPassword");
//            String repassword = request.getParameter("txtRepassword");
//            String accid;
//            AccountDAO acc = new AccountDAO();

        RequestDispatcher rd = request.getRequestDispatcher(url);
        rd.forward(request, response);
        out.close();
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