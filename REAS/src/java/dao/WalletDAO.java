package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
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
                        + "values (?,?,?)";
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

//    public static void main(String[] args) {
//        boolean bl1 = addNewWallet(4, "M4");
//    }
}
