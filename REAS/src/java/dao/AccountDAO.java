
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

public class AccountDAO implements Serializable {

    public boolean checkLogin(String username, String password)
            throws SQLException, NamingException, ClassNotFoundException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        boolean result = false;
        try {
            //1. create connect
            con = DBUtils.getConnection();
            if (con != null) { //connection is available
                //2. connect sql string
                String sql = "Select UserName "
                        + "from AuctionSystem "
                        + "Where UserName = ? "
                        + "And Password = ?";
                //3. create statement obj
                stm = con.prepareStatement(sql);
                stm.setString(1, username);
                stm.setString(2, password);
                //4. execute query
                rs = stm.executeQuery();
                //5. process
                //1 dong if nhieu dong while username la primary key
                if (rs.next()) {
                    result = true;
                }//end username and password are existed
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
}

