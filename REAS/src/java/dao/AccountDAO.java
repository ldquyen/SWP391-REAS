package dao;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import dto.Account;
import dao.AccountDAO;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import javax.naming.NamingException;
import mylib.DBUtils;

public class AccountDAO {

    public Account checkLogin(String username, String password2)
            throws SQLException, NamingException, ClassNotFoundException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        Account result = null;
        try {

            //1. create connect
            con = DBUtils.getConnection();
            if (con != null) { //connection is available
                //2. connect sql string
                String sql = "SELECT AccID, UserName, FullName, RoleID, Status "
                        + "FROM Account "
                        + "WHERE UserName = ? AND Password = ?";

                //3. create statement obj
                stm = con.prepareStatement(sql);
                stm.setString(1, username);
                stm.setString(2, password2);

                //4. execute query
                rs = stm.executeQuery();
                //5. process
                //1 dong if nhieu dong while username la primary key

                while (rs.next()) {
                    result = new Account();
                    result.setAccID(rs.getString("accID"));
                    result.setFullname(rs.getString("fullname"));
                    result.setRoleID(rs.getString("roleID"));
                    result.setStatus(rs.getBoolean("status"));
                }
                //jdbc object khai bao dong no lai su dung
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return result;
    }

    private List<Account> accounts;

    public List<Account> getAccounts() {
        return accounts;
    }

    public Account getAccount(String Username, String Password) throws ClassNotFoundException, SQLException {
        Account a = new Account();
        Connection cn = DBUtils.getConnection();
        if (cn != null) {
            String sql = "SELECT [AccID],[RoleID],[UserName],[Password],[FullName],[Status], [Email], [Phone], [CCCD], [Address], [PlaceOfReg], [DateOfReg], [BankName],[BankCode] \n"
                    + "FROM Account WHERE [UserName] = ? and [Password] = ?";
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setString(1, Username);
            pst.setString(2, Password);
            ResultSet rs = pst.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    String accID = rs.getString("AccID");
                    String roleID = rs.getString("RoleID");
                    String userName = rs.getString("UserName");
                    String password = rs.getString("Password");
                    String fullname = rs.getString("FullName");
                    boolean status = rs.getBoolean("Status");
                    String email = rs.getString("Email");
                    String phone = rs.getString("Phone");
                    String cccd = rs.getString("CCCD");
                    String address = rs.getString("Address");
                    String placeOfReg = rs.getString("PlaceOfReg");
                    String dateOfReg = rs.getString("DateOfReg");
                    String bankName = rs.getString("BankName");
                    String bankCode = rs.getString("BankCode");
                    a = new Account(accID, roleID, userName, password, fullname, status, email, phone, cccd, address, placeOfReg, dateOfReg, bankName, bankCode);
                }
            }
            cn.close();
        }
        return a;
    }

    public boolean resetPassword(String password, String email) throws ClassNotFoundException, SQLException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            con = DBUtils.getConnection();
            if (con != null) {
                String sql = "UPDATE [dbo].[Account] SET [Password] = ? WHERE [Email] = ?";
                PreparedStatement pst = con.prepareStatement(sql);
                pst.setString(1, password);
                pst.setString(2, email);
                int rowsAffected = pst.executeUpdate();
                if (rowsAffected > 0) {
                    return true;
                }
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return false;
    }

    public static boolean checkAccount(String AccID) throws Exception {
        Connection cn = DBUtils.getConnection();
        if (cn != null) {
            String sql = "select [AccID] from [dbo].[Account] WHERE [AccID] = ?";
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setString(1, AccID);
            ResultSet rs = pst.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    String accID = rs.getString("AccID");
                    if (accID != null) {
                        return true;
                    } else {
                        return false;
                    }
                }
            }
        }
        return false;
    }

    public static boolean checkUsername(String username) throws Exception {
        Connection cn = DBUtils.getConnection();
        if (cn != null) {
            String sql = "SELECT [UserName] FROM [dbo].[Account] WHERE [UserName] = ?";
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setString(1, username);
            ResultSet rs = pst.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    String Username = rs.getString("UserName");
                    if (Username != null) {
                        return true;
                    } else {
                        return false;
                    }
                }
            }
        }
        return false;
    }

    public static boolean checkEmail(String email) throws Exception {
        Connection cn = DBUtils.getConnection();
        if (cn != null) {
            String sql = "SELECT [Email] FROM [dbo].[Account] WHERE [Email] = ?";
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setString(1, email);
            ResultSet rs = pst.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    String Email = rs.getString("Email");
                    if (Email != null) {
                        return true;
                    } else {
                        return false;
                    }
                }
            }
        }
        return false;
    }

    public static boolean checkPhone(String phone) throws Exception {
        Connection cn = DBUtils.getConnection();
        if (cn != null) {
            String sql = "SELECT [Phone] FROM [dbo].[Account] WHERE [Phone] = ?";
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setString(1, phone);
            ResultSet rs = pst.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    String Phone = rs.getString("Phone");
                    if (Phone != null) {
                        return true;
                    } else {
                        return false;
                    }
                }
            }
        }
        return false;
    }

    public static boolean checkCCCD(String cccd) throws Exception {
        Connection cn = DBUtils.getConnection();
        if (cn != null) {
            String sql = "SELECT [CCCD] FROM [dbo].[Account] WHERE [CCCD] = ?";
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setString(1, cccd);
            ResultSet rs = pst.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    String Cccd = rs.getString("CCCD");
                    if (Cccd != null) {
                        return true;
                    } else {
                        return false;
                    }
                }
            }
        }
        return false;
    }

    public static boolean insertAccount(String accid, String username, String password, String fullname, String email, String phone, String cccd, String address, String cccdregplace, String cccdregdate, String bankname, String bankcode) {
        Connection cn = null;
        PreparedStatement pst = null;

        try {
            cn = DBUtils.getConnection();
            if (cn != null) {
                String sql = "INSERT INTO [dbo].[Account]([AccID],[RoleID],[UserName],[Password],[FullName],[Status],[Email],[Phone],[CCCD],[Address],[PlaceOfReg],[DateOfReg],[BankName],[BankCode])\n"
                        + "VALUES (?,'M',?,?,?,0,?,?,?,?,?,?,?,?)";
                pst = cn.prepareStatement(sql);
                pst.setString(1, accid);
                pst.setString(2, username);
                pst.setString(3, password);
                pst.setString(4, fullname);
                pst.setString(5, email);
                pst.setString(6, phone);
                pst.setString(7, cccd);
                pst.setString(8, address);
                pst.setString(9, cccdregplace);
                pst.setString(10, cccdregdate);
                pst.setString(11, bankname);
                pst.setString(12, bankcode);
                int rowsAffected = pst.executeUpdate();
                return rowsAffected > 0;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (pst != null) {
                    pst.close();
                }
                if (cn != null) {
                    cn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    public static boolean checkEqual(String string1, String string2) {
        if (string1.equals(string2)) {
            return true;
        }
        return false;
    }

    public static void changePassword(String accid, String newpassword) throws ClassNotFoundException, SQLException {
        Connection cn = DBUtils.getConnection();
        if (cn != null) {
            String sql = "UPDATE [dbo].[Account] SET [Password] = ? WHERE [AccID] = ?";
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setString(1, newpassword);
            pst.setString(2, accid);
            int rowsAffected = pst.executeUpdate();
        }
        cn.close();
    }

    public static String encodePassword(String password) throws Exception {
        String str = password;
        String encodedString = Base64.getEncoder().encodeToString(str.getBytes());
        System.out.println(encodedString); // R1AgQ29kZXI=
        return encodedString;
    }

    public static String decodePassword(String password) throws Exception {
        byte[] decodedBytes = Base64.getDecoder().decode(password);
        String decodedString = new String(decodedBytes);
        //System.out.println(decodedString); // GP Coder
        return decodedString;
    }

    public static boolean checkGmailContainSymbol(String str) {
        // Kiểm tra xem chuỗi có chứa ký tự @ hay không
        if (str == null) {
            return false;
        }

        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '@') {
                count++;
                if (count > 1) {
                    return false;
                }
            }
        }
        return count == 1;
    }

    public static void changeFullname(String fullname, String accid) throws ClassNotFoundException, SQLException {
        Connection cn = DBUtils.getConnection();
        if (cn != null) {
            String sql = "UPDATE [dbo].[Account]\n"
                    + "SET  [FullName]= ?\n"
                    + "WHERE [AccID] = ?";
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setString(1, fullname);
            pst.setString(2, accid);
            int rowsAffected = pst.executeUpdate();
        }
        cn.close();
    }

    public static void changeEmail(String Email, String accid) throws ClassNotFoundException, SQLException {
        Connection cn = DBUtils.getConnection();
        if (cn != null) {
            String sql = "UPDATE [dbo].[Account]\n"
                    + "SET  [Email]= ?\n"
                    + "WHERE [AccID] = ?";
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setString(1, Email);
            pst.setString(2, accid);
            int rowsAffected = pst.executeUpdate();
        }
        cn.close();
    }

    public static void changePhone(String phone, String accid) throws ClassNotFoundException, SQLException {
        Connection cn = DBUtils.getConnection();
        if (cn != null) {
            String sql = "UPDATE [dbo].[Account]\n"
                    + "SET  [Phone]= ?\n"
                    + "WHERE [AccID] = ?";
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setString(1, phone);
            pst.setString(2, accid);
            int rowsAffected = pst.executeUpdate();
        }
        cn.close();
    }

    public static void changeCCCD(String cccd, String accid) throws ClassNotFoundException, SQLException {
        Connection cn = DBUtils.getConnection();
        if (cn != null) {
            String sql = "UPDATE [dbo].[Account]\n"
                    + "SET  [CCCD]= ?\n"
                    + "WHERE [AccID] = ?";
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setString(1, cccd);
            pst.setString(2, accid);
            int rowsAffected = pst.executeUpdate();
        }
        cn.close();
    }

    public static void changeCCCDRegPlace(String cccdRegplace, String accid) throws ClassNotFoundException, SQLException {
        Connection cn = DBUtils.getConnection();
        if (cn != null) {
            String sql = "UPDATE [dbo].[Account]\n"
                    + "SET  [PlaceOfReg]= ?\n"
                    + "WHERE [AccID] = ?";
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setString(1, cccdRegplace);
            pst.setString(2, accid);
            int rowsAffected = pst.executeUpdate();
        }
        cn.close();
    }

    public static void changeCCCDRegDate(String cccdRegDate, String accid) throws ClassNotFoundException, SQLException {
        Connection cn = DBUtils.getConnection();
        if (cn != null) {
            String sql = "UPDATE [dbo].[Account]\n"
                    + "SET  [DateOfReg]= ?\n"
                    + "WHERE [AccID] = ?";
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setString(1, cccdRegDate);
            pst.setString(2, accid);
            int rowsAffected = pst.executeUpdate();
        }
        cn.close();
    }

    public static void changeAddress(String address, String accid) throws ClassNotFoundException, SQLException {
        Connection cn = DBUtils.getConnection();
        if (cn != null) {
            String sql = "UPDATE [dbo].[Account]\n"
                    + "SET  [Address]= ?\n"
                    + "WHERE [AccID] = ?";
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setString(1, address);
            pst.setString(2, accid);
            int rowsAffected = pst.executeUpdate();
        }
        cn.close();
    }

    public static void changeBankName(String bankname, String accid) throws ClassNotFoundException, SQLException {
        Connection cn = DBUtils.getConnection();
        if (cn != null) {
            String sql = "UPDATE [dbo].[Account]\n"
                    + "SET  [BankName]= ?\n"
                    + "WHERE [AccID] = ?";
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setString(1, bankname);
            pst.setString(2, accid);
            int rowsAffected = pst.executeUpdate();
        }
        cn.close();
    }

    public static void changeBankCode(String bankcode, String accid) throws ClassNotFoundException, SQLException {
        Connection cn = DBUtils.getConnection();
        if (cn != null) {
            String sql = "UPDATE [dbo].[Account]\n"
                    + "SET  [BankCode]= ?\n"
                    + "WHERE [AccID] = ?";
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setString(1, bankcode);
            pst.setString(2, accid);
            int rowsAffected = pst.executeUpdate();
        }
        cn.close();
    }

    public static boolean containsOnlyLettersAndSpaces(String str) {
        // Loại bỏ dấu từ chuỗi
        String normalizedString = Normalizer.normalize(str, Normalizer.Form.NFD)
                .replaceAll("[^\\p{ASCII}]", "");

        // Sử dụng vòng lặp để kiểm tra từng ký tự trong chuỗi
        for (int i = 0; i < normalizedString.length(); i++) {
            char currentChar = normalizedString.charAt(i);

            // Kiểm tra xem ký tự có phải là chữ cái hoặc dấu cách không
            if (!Character.isLetter(currentChar) && !Character.isWhitespace(currentChar)) {
                return false;
            }
        }
        return true;
    }

    public static ArrayList<Account> getAllAccountByRole(String roleid) throws ClassNotFoundException, SQLException {
        ArrayList<Account> list = new ArrayList<>();
        Connection cn = DBUtils.getConnection();
        if (cn != null) {
            String sql = "SELECT [AccID],[RoleID],[UserName],[Password],[FullName],[Status], [Email], [Phone], [CCCD], [Address], [PlaceOfReg], [DateOfReg], [BankName],[BankCode]\n"
                    + "FROM Account WHERE [RoleID] = ?";
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setString(1, roleid);
            ResultSet rs = pst.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    String accID = rs.getString("AccID");
                    String roleID = rs.getString("RoleID");
                    String userName = rs.getString("UserName");
                    String password = rs.getString("Password");
                    String fullname = rs.getString("FullName");
                    boolean status = rs.getBoolean("Status");
                    String email = rs.getString("Email");
                    String phone = rs.getString("Phone");
                    String cccd = rs.getString("CCCD");
                    String address = rs.getString("Address");
                    String placeOfReg = rs.getString("PlaceOfReg");
                    String dateOfReg = rs.getString("DateOfReg");
                    String bankName = rs.getString("BankName");
                    String bankCode = rs.getString("BankCode");

                    Account a = new Account(accID, roleID, userName, password, fullname, status, email, phone, cccd, address, placeOfReg, dateOfReg, bankName, bankCode);
                    list.add(a);
                }
            }
            cn.close();
        }
        return list;
    }

    public static ArrayList<Account> getAllAccountByName(String roleid, String name) throws ClassNotFoundException, SQLException {
        ArrayList<Account> list = new ArrayList<>();
        Connection cn = DBUtils.getConnection();
        if (cn != null) {
            String sql = "SELECT [AccID],[RoleID],[UserName],[Password],[FullName],[Status], [Email], [Phone], [CCCD], [Address], [PlaceOfReg], [DateOfReg], [BankName],[BankCode]\n"
                    + "FROM Account WHERE [RoleID] = ? AND [FullName] LIKE ?";
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setString(1, roleid);
            pst.setString(2, "%" + name + "%");
            ResultSet rs = pst.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    String accID = rs.getString("AccID");
                    String roleID = rs.getString("RoleID");
                    String userName = rs.getString("UserName");
                    String password = rs.getString("Password");
                    String fullname = rs.getString("FullName");
                    boolean status = rs.getBoolean("Status");
                    String email = rs.getString("Email");
                    String phone = rs.getString("Phone");
                    String cccd = rs.getString("CCCD");
                    String address = rs.getString("Address");
                    String placeOfReg = rs.getString("PlaceOfReg");
                    String dateOfReg = rs.getString("DateOfReg");
                    String bankName = rs.getString("BankName");
                    String bankCode = rs.getString("BankCode");

                    Account a = new Account(accID, roleID, userName, password, fullname, status, email, phone, cccd, address, placeOfReg, dateOfReg, bankName, bankCode);
                    list.add(a);
                }
            }
            cn.close();
        }
        return list;
    }

    public static Account getAccountByID(String AccID) throws ClassNotFoundException, SQLException, Exception {
        Account a = new Account();
        Connection cn = DBUtils.getConnection();
        if (cn != null) {
            String sql = "SELECT [AccID],[RoleID],[UserName],[Password],[FullName],[Status], [Email], [Phone], [CCCD], [Address], [PlaceOfReg], [DateOfReg], [BankName],[BankCode]\n"
                    + "FROM Account WHERE [AccID] = ?";
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setString(1, AccID);
            ResultSet rs = pst.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    String accID = rs.getString("AccID");
                    String roleID = rs.getString("RoleID");
                    String userName = rs.getString("UserName");
                    String oldpassword = rs.getString("Password");
                    String newpassword = AccountDAO.decodePassword(oldpassword);
                    String fullname = rs.getString("FullName");
                    boolean status = rs.getBoolean("Status");
                    String email = rs.getString("Email");
                    String phone = rs.getString("Phone");
                    String cccd = rs.getString("CCCD");
                    String address = rs.getString("Address");
                    String placeOfReg = rs.getString("PlaceOfReg");
                    String dateOfReg = rs.getString("DateOfReg");
                    String bankName = rs.getString("BankName");
                    String bankCode = rs.getString("BankCode");

                    a = new Account(accID, roleID, userName, newpassword, fullname, status, email, phone, cccd, address, placeOfReg, dateOfReg, bankName, bankCode);
                }
            }
            cn.close();
        }
        return a;
    }

    public static void changeStatusAccount(String Accid, boolean Status) throws ClassNotFoundException, SQLException {
        Connection cn = DBUtils.getConnection();
        if (cn != null) {
            if (Status == false) {
                String sql = "UPDATE [dbo].[Account] SET [Status] = 1 WHERE AccID = ?";
                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setString(1, Accid);
                int rowsAffected = pst.executeUpdate();
            } else {
                String sql = "UPDATE [dbo].[Account] SET [Status] = 0 WHERE AccID = ?";
                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setString(1, Accid);
                int rowsAffected = pst.executeUpdate();
            }
        }
    }

    public static boolean changeInfoStaff(String Accid, String userName, String password, String fullname, String email, String phone, String cccd, String address, String placeOfReg, String dateOfReg, String bankName, String bankCode) throws ClassNotFoundException, SQLException {
        Connection cn = DBUtils.getConnection();
        if (cn != null) {
            String sql = "UPDATE [dbo].[Account]\n"
                    + "SET \n"
                    + "    [UserName] = ?,\n"
                    + "    [Password] = ?,\n"
                    + "    [FullName] = ?,\n"
                    + "    [Email] = ?,\n"
                    + "    [Phone] = ?,\n"
                    + "    [CCCD] = ?,\n"
                    + "    [Address] = ?,\n"
                    + "    [PlaceOfReg] = ?,\n"
                    + "    [DateOfReg] = ?,\n"
                    + "    [BankName] = ?,\n"
                    + "    [BankCode] = ?\n"
                    + "WHERE [AccID] = ?;";
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setString(12, Accid);
            pst.setString(1, userName);
            pst.setString(2, password);
            pst.setString(3, fullname);
            pst.setString(4, email);
            pst.setString(5, phone);
            pst.setString(6, cccd);
            pst.setString(7, address);
            pst.setString(8, placeOfReg);
            pst.setString(9, dateOfReg);
            pst.setString(10, bankName);
            pst.setString(11, bankCode);
            int rowsAffected = pst.executeUpdate();
            return true;
        }
        return false;
    }
    
    public static boolean addStaff(String accid, String username, String password, String fullname, String email, String phone, String cccd, String address, String cccdregplace, String cccdregdate, String bankname, String bankcode) {
        Connection cn = null;
        PreparedStatement pst = null;

        try {
            cn = DBUtils.getConnection();
            if (cn != null) {
                String sql = "INSERT INTO [dbo].[Account]([AccID],[RoleID],[UserName],[Password],[FullName],[Status],[Email],[Phone],[CCCD],[Address],[PlaceOfReg],[DateOfReg],[BankName],[BankCode])\n"
                        + "VALUES (?,'S',?,?,?,0,?,?,?,?,?,?,?,?)";
                pst = cn.prepareStatement(sql);
                pst.setString(1, accid);
                pst.setString(2, username);
                pst.setString(3, password);
                pst.setString(4, fullname);
                pst.setString(5, email);
                pst.setString(6, phone);
                pst.setString(7, cccd);
                pst.setString(8, address);
                pst.setString(9, cccdregplace);
                pst.setString(10, cccdregdate);
                pst.setString(11, bankname);
                pst.setString(12, bankcode);
                int rowsAffected = pst.executeUpdate();
                return rowsAffected > 0;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (pst != null) {
                    pst.close();
                }
                if (cn != null) {
                    cn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false;
    }
    
}
