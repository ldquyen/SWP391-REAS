/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllersMain;

import dao.AccountDAO;
import dao.WalletDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author TRUONG SON
 */
public class RegisterServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String fullname = request.getParameter("txtFullname");
            String username = request.getParameter("txtUsername");
            String email = request.getParameter("txtEmail");
            String phone = request.getParameter("txtPhone");
            String cccd = request.getParameter("txtCCCD");
            String address = request.getParameter("txtAddress");
            String cccdregplace = request.getParameter("txtCCCDRegplace");
            String cccdregdate = request.getParameter("txtCCCDRegdate");
            String bankname = request.getParameter("txtBankname");
            String bankcode = request.getParameter("txtBankcode");
            String password = request.getParameter("txtPassword");
            String repassword = request.getParameter("txtRepassword");
            String accid;
            int walletId;
            AccountDAO acc = new AccountDAO();
            WalletDAO wallet = new WalletDAO();
            int i = 0;
            String password2 = acc.encodePassword(password);
            if (!password.equals(repassword)) {
                request.setAttribute("FAILREPASSWORD", "Mật khẩu không trùng khớp, vui lòng đăng ký lại");
                request.getRequestDispatcher("MainController?action=DK").forward(request, response);
            }
            if (!fullname.isEmpty() && !username.isEmpty() && !email.isEmpty() && !phone.isEmpty() && !cccd.isEmpty() && !cccdregplace.isEmpty() && !cccdregdate.isEmpty() && !password.isEmpty() && !repassword.isEmpty() && !bankcode.isEmpty() && !bankname.isEmpty()) {
                if (acc.checkUsername(username)) {
                    request.setAttribute("FAILUSERNAME", "Username đã tồn tại, vui lòng đăng kí lại");
                    request.getRequestDispatcher("MainController?action=DK").forward(request, response);
                } else if (!acc.containsOnlyLettersAndSpaces(fullname)) {
                    request.setAttribute("FAILFULLNAME", "Họ và tên sai định dạng, vui lòng đăng kí lại");
                    request.getRequestDispatcher("MainController?action=DK").forward(request, response);
                } else if (acc.checkPhone(phone)) {
                    request.setAttribute("FAILPHONE", "Phone đã tồn tại, vui lòng đăng kí lại");
                    request.getRequestDispatcher("MainController?action=DK").forward(request, response);
                } else if (!phone.matches("\\d{10}")) {
                    request.setAttribute("FAILPHONEPATTERN", "Phone sai định dạng, vui lòng đăng kí lại");
                    request.getRequestDispatcher("MainController?action=DK").forward(request, response);
                } else if (acc.checkEmail(email)) {
                    request.setAttribute("FAILEMAIL", "Email đã tồn tại, vui lòng đăng kí lại");
                    request.getRequestDispatcher("MainController?action=DK").forward(request, response);
                } else if (!acc.checkGmailContainSymbol(email)) {
                    request.setAttribute("FAILEMAILSYMBOL", "Email sai định dạng, vui lòng đăng kí lại");
                    request.getRequestDispatcher("MainController?action=DK").forward(request, response);
                } else if (acc.checkCCCD(cccd)) {
                    request.setAttribute("FAILCCCD", "CCCD đã tồn tại, vui lòng đăng kí lại");
                    request.getRequestDispatcher("MainController?action=DK").forward(request, response);
                } else if (!cccd.matches("\\d{12}")) {
                    request.setAttribute("FAILCCCDPATTERN", "CCCD sai định dạng, vui lòng đăng kí lại");
                    request.getRequestDispatcher("MainController?action=DK").forward(request, response);
                } else if (!cccdregdate.matches("\\d{2}/\\d{2}/\\d{4}")) {
                    request.setAttribute("FAILCCCDREGDATEPATTERN", "Ngày cấp CCCD sai định dạng, vui lòng đăng kí lại");
                    request.getRequestDispatcher("MainController?action=DK").forward(request, response);
                } else if (!acc.containsOnlyLettersAndSpaces(bankname)) {
                    request.setAttribute("FAILBANKNAMEPATTERN", "Tên ngân hàng sai định dạng, vui lòng đăng kí lại");
                    request.getRequestDispatcher("MainController?action=DK").forward(request, response);
                } else if (!bankcode.matches("\\d+")) {
                    request.setAttribute("FAILBANKCODEPATTERN", "Số tài khoản ngân hàng sai định dạng, vui lòng đăng kí lại");
                    request.getRequestDispatcher("MainController?action=DK").forward(request, response);
                } else if (password.length() < 8) {
                    request.setAttribute("FAILPASSWORDLENGTH", "Mật khẩu sai định dạng, vui lòng đăng kí lại");
                    request.getRequestDispatcher("MainController?action=DK").forward(request, response);
                } else {
                    do {
                        i++;
                        String i1 = Integer.toString(i);
                        accid = "M" + i1;
                        walletId = i;
                    } while (acc.checkAccount(accid));
                    boolean bl = acc.insertAccount(accid, username, password2, fullname, email, phone, cccd, address, cccdregplace, cccdregdate, bankname, bankcode);
                    boolean bl1 = wallet.addNewWallet(walletId, accid);
                    request.setAttribute("SUCCESS", "Đăng ký thành công, vui lòng đăng nhập");
                    request.setAttribute("UsernameRegister", username);
                    request.getRequestDispatcher("MainController?action=DN").forward(request, response);
                }
            } else {
                request.setAttribute("FAIL", "Đăng Ký thất bại, vui lòng đăng ký lại");
                request.getRequestDispatcher("MainController?action=DK").forward(request, response);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

//    public static void main(String[] args) throws Exception {
//        AccountDAO acc = new AccountDAO();
//        String email = "1234567890@fpt";
//        if (!acc.checkGmailContainSymbol(email)) {
//            System.out.println("toan chu cai");
//        } else {
//            System.out.println("sai me r");
//        }
//    }
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
