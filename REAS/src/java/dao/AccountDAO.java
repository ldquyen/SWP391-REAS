package dao;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import dto.Account;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.naming.NamingException;
import mylib.DBUtils;

public class AccountDAO {

    public Account checkLogin(String username, String password)
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
                stm.setString(2, password);

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
}
