package dao;

import dto.RealEstateInfo;
import dto.Wallet;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import mylib.DBUtils;

public class WalletDAO {
//add new wallet
    public static boolean addNewWallet(String accid) {
        Connection cn = null;
        PreparedStatement pst = null;

        try {
            cn = DBUtils.getConnection();
            if (cn != null) {
                String sql = "insert into [dbo].[Wallet] ([AccID],[AccountBalance])\n"
                        + "values (?,?)";
                pst = cn.prepareStatement(sql);
                pst.setString(1, accid);
                pst.setLong(2, 0);
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
    
    public static List<Wallet> getWallet() throws ClassNotFoundException, SQLException{
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        List<Wallet> result = null;

        try {
            con = DBUtils.getConnection();
            if (con != null) {
                String sql = "SELECT * FROM dbo.Wallet ";
                stm = con.prepareStatement(sql);
                rs = stm.executeQuery();
                while (rs.next()) {
                    if (result == null) {
                        result = new ArrayList<Wallet>();
                    }
                    Wallet dto = new Wallet();
                    
                    dto.setWalletID(rs.getString("WalletID"));
                    dto.setAccID(rs.getString("AccID"));
                    dto.setAccountBalance(rs.getLong("AccountBalance"));

                    result.add(dto);
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
        return result;
    }

//    public static void main(String[] args) {
//        boolean bl1 = addNewWallet(4, "M4");
//    }
}
