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
    public boolean saveUserGoogle(UserGoogle userGoogle) throws ClassNotFoundException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        Account result = null;
        try {
            con = DBUtils.getConnection();

            if (con != null) {
                // SQL query to insert user information
                String sql = "INSERT INTO user_google (id, email, verified_email, name, given_name, family_name, picture) "
                        + "VALUES (?, ?, ?, ?, ?, ?, ?)";

                stm = con.prepareStatement(sql);

                // Set values for the parameters
                stm.setString(1, userGoogle.getId());
                stm.setString(2, userGoogle.getEmail());
                stm.setBoolean(3, userGoogle.isVerified_email());
                stm.setString(4, userGoogle.getName());
                stm.setString(5, userGoogle.getGiven_name());
                stm.setString(6, userGoogle.getFamily_name());
                stm.setString(7, userGoogle.getPicture());

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
}