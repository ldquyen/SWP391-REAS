/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

/**
 *
 * @author tranl
 */
import dto.Account;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import dto.UserGoogle;
import java.sql.ResultSet;
import mylib.DBUtils;

public class GoogleDAO {

    // Save UserGoogle information to the database
    public boolean saveUserGoogle(String id, String email, boolean verified_email, String name, String given_name, String family_name, String picture) throws ClassNotFoundException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        Account result = null;
        try {
            con = DBUtils.getConnection();

            if (con != null) {
                // SQL query to insert user information
                String sql = "INSERT INTO [dbo].[GoogleAccount] ([GgAccID],[RoleID],[Email],[VerifiedEmail],[Name],[GivenName],[FamilyName],[Picture]) "
                        + "VALUES (?,'M', ?, ?, ?, ?, ?, ?)";

                stm = con.prepareStatement(sql);

                // Set values for the parameters
                stm.setString(1, id);
                stm.setString(2, email);
                stm.setBoolean(3, verified_email);
                stm.setString(4, name);
                stm.setString(5, given_name);
                stm.setString(6, family_name);
                stm.setString(7, picture);

                // Execute the query
                int rowsAffected = stm.executeUpdate();
                return rowsAffected > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle the exception, log, or throw a custom exception as needed.
        } finally {
            try {
                if (stm != null) {
                    stm.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false;
    }
    
    public static boolean checkIDGoogle(String id) throws Exception {
        Connection cn = DBUtils.getConnection();
        if (cn != null) {
            String sql = "SELECT [GgAccID] FROM [dbo].[GoogleAccount] WHERE [GgAccID] = ?";
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setString(1, id);
            ResultSet rs = pst.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    String GgAccID = rs.getString("GgAccID");
                    if (GgAccID != null) {
                        return true;
                    } else {
                        return false;
                    }
                }
            }
        }
        return false;
    }
}