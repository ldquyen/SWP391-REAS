/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import mylib.DBUtils;

public class WalletHistoryDAO {
// số giao dịch thực hiện thành công
    public static long getSoGiaoDichThucHien() throws ClassNotFoundException, SQLException {
        long a = 0;
        Connection cn = DBUtils.getConnection();
        if (cn != null) {
            String sql = "Select COUNT([OrderID])AS TGDTH From [dbo].[WalletHistory]\n"
                    + "WHERE StatusID = 2";
            PreparedStatement pst = cn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    a = rs.getLong("TGDTH");
                }
            }
            cn.close();
        }
        return a;
    }
// số tiền giao dịch thực hiện thành công
    public static long getSoTienGiaoDichThucHien() throws ClassNotFoundException, SQLException {
        long a = 0;
        Connection cn = DBUtils.getConnection();
        if (cn != null) {
            String sql = "SELECT SUM([Price]) AS TSTGD From [dbo].[WalletHistory]\n"
                    + "WHERE StatusID = 2";
            PreparedStatement pst = cn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    a = rs.getLong("TSTGD");
                }
            }
            cn.close();
        }
        return a;
    }
//month
    public static long getSoGiaoDichThucHienInMonth(String month) throws ClassNotFoundException, SQLException {
        long a = 0;
        Connection cn = DBUtils.getConnection();
        if (cn != null) {
            String sql = "Select COUNT([OrderID])AS TGDTH From [dbo].[WalletHistory]\n"
                    + "WHERE StatusID = 2 AND MONTH(DateAndTime) = ?";
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setString(1, month);
            ResultSet rs = pst.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    a = rs.getLong("TGDTH");
                }
            }
            cn.close();
        }
        return a;
    }

    public static long getSoTienGiaoDichThucHienInMonth(String month)throws ClassNotFoundException, SQLException {
        long a = 0;
        Connection cn = DBUtils.getConnection();
        if (cn != null) {
            String sql = "SELECT SUM([Price]) AS TSTGD From [dbo].[WalletHistory]\n"
                    + "WHERE StatusID = 2 AND MONTH(DateAndTime) = ?";
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setString(1, month);
            ResultSet rs = pst.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    a = rs.getLong("TSTGD");
                }
            }
            cn.close();
        }
        return a;
    }
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        long a = getSoTienGiaoDichThucHienInMonth("3");
        System.out.println(a);
    }
}
