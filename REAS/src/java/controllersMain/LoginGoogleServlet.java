
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
import dto.Account;
import dto.UserGoogle;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
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
        UserGoogle user = getUserInfo(accessToken);
        System.out.println(user);
        String url = HOMEPAGE;

        String inputString = user.toString();

        // Tìm vị trí bắt đầu và kết thúc của nội dung giữa dấu ngoặc nhọn {}
        int start = inputString.indexOf("{");
        int end = inputString.lastIndexOf("}") + 1;

        // Lấy nội dung giữa dấu ngoặc nhọn {}
        String jsonString = inputString.substring(start, end);

        // Hiển thị chuỗi JSON
        System.out.println(jsonString);

        // Chuyển đổi chuỗi JSON thành đối tượng Java
        UserGoogle userGoogle = parseJson(jsonString);

        // Hiển thị kết quả
        System.out.println(userGoogle);

        HttpSession session = request.getSession();
        session.setAttribute("userGoogle", userGoogle);

        RequestDispatcher rd = request.getRequestDispatcher(url);
        rd.forward(request, response);
        out.close();
    }

    private static UserGoogle parseJson(String jsonString) {
        // Trong thực tế, bạn có thể sử dụng thư viện JSON parsing như Jackson hoặc Gson
        // Đây là một cách đơn giản chỉ để minh họa, không khuyến khích sử dụng trong ứng dụng thực tế
        // Sử dụng thư viện JSON parsing để đảm bảo xử lý đúng cho các tình huống phức tạp hơn
        String[] keyValuePairs = jsonString.split(",");
        UserGoogle userGoogle = new UserGoogle();
        for (String pair : keyValuePairs) {
            String[] entry = pair.split("=");
            String key = entry[0].trim();
            String value = entry[1].trim();
            switch (key) {
                case "id":
                    userGoogle.setId(value);
                    break;
                case "email":
                    userGoogle.setEmail(value);
                    break;
                case "verified_email":
                    userGoogle.setVerified_email(Boolean.parseBoolean(value));
                    break;
                case "name":
                    userGoogle.setName(value);
                    break;
                case "given_name":
                    userGoogle.setGiven_name(value);
                    break;
                case "family_name":
                    userGoogle.setFamily_name(value);
                    break;
                case "picture":
                    userGoogle.setPicture(value);
                    break;
                // Add more cases for other properties as needed
            }
        }
        return userGoogle;
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
