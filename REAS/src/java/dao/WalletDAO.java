package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import mylib.DBUtils;

public class WalletDAO {

    public static boolean addNewWallet(int walletid, String accid) {
        Connection cn = null;
        PreparedStatement pst = null;

        try {
            cn = DBUtils.getConnection();
            if (cn != null) {
                String sql = "insert into [dbo].[Wallet] ([WalletID],[AccID],[AccountBalance])\n"
                        + "values (?,?,?)";
                pst = cn.prepareStatement(sql);
                pst.setInt(1, walletid);
                pst.setString(2, accid);
                pst.setLong(3, 0);
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
