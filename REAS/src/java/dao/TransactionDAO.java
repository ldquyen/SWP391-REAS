package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import mylib.DBUtils;

public class TransactionDAO {

    public boolean processTransaction(String buyerID, String sellerID, long pricePaid) throws ClassNotFoundException, SQLException {
        // Lấy accountBalance của người mua
        long buyerBalance = getAccountBalance(buyerID);
        // Lấy accountBalance của người bán
        long sellerBalance = getAccountBalance(sellerID);

        // Kiểm tra xem người mua có đủ tiền để thực hiện giao dịch không
        if (buyerBalance > (pricePaid + (pricePaid * 10 / 100))) {
            // Trừ tiền từ tài khoản người mua
            boolean buyerUpdated = updateAccountBalance(buyerID, buyerBalance - pricePaid);
            // Cộng tiền vào tài khoản người bán
            boolean sellerUpdated = updateAccountBalance(sellerID, sellerBalance + (pricePaid - (pricePaid * 10 / 100)));
            // Chuyển 5 cho admin
            boolean adminUpdated = updateAdminAccount(pricePaid * 10 / 100);

            // Trả về true nếu tất cả các bước đều thành công
            return buyerUpdated && sellerUpdated && adminUpdated;
        } else {
            return false; // Nếu người mua không có đủ tiền
        }
    }

    // Method để lấy accountBalance của một tài khoản
    public long getAccountBalance(String accID) throws ClassNotFoundException, SQLException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        long accountBalance = 0;

        try {
            con = DBUtils.getConnection();
            if (con != null) {
                String sql = "SELECT AccountBalance FROM dbo.Wallet WHERE AccID = ? ";
                stm = con.prepareStatement(sql);
                stm.setString(1, accID);
                rs = stm.executeQuery();
                if (rs.next()) {
                    accountBalance = rs.getLong("AccountBalance");
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
        return accountBalance;
    }

    // Method để cập nhật accountBalance của một tài khoản
    public boolean updateAccountBalance(String accID, long newBalance) throws ClassNotFoundException, SQLException {
        Connection con = null;
        PreparedStatement stm = null;
        boolean result = false;

        try {
            con = DBUtils.getConnection();
            if (con != null) {
                String sql = "UPDATE dbo.Wallet SET AccountBalance = ? WHERE AccID = ?";
                stm = con.prepareStatement(sql);
                stm.setLong(1, newBalance);
                stm.setString(2, accID);
                int rowsAffected = stm.executeUpdate();
                result = rowsAffected > 0; // Kiểm tra xem có dòng nào được ảnh hưởng không
            }
        } finally {
            // Đóng các tài nguyên
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return result;
    }

    // Method để cập nhật accountBalance của tài khoản admin
    public boolean updateAdminAccount(long amount) throws ClassNotFoundException, SQLException {
        Connection con = null;
        PreparedStatement stm = null;
        boolean success = false;

        try {
            con = DBUtils.getConnection();
            if (con != null) {
                // Lấy accountBalance hiện tại của tài khoản admin
                long currentBalance = getAccountBalance("A1");
                // Tính toán accountBalance mới
                long newBalance = currentBalance + amount;
                // Cập nhật accountBalance mới cho tài khoản admin
                String sql = "UPDATE dbo.Wallet SET AccountBalance = ? WHERE AccID = 'A1' ";
                stm = con.prepareStatement(sql);
                stm.setLong(1, newBalance);
                int rowsAffected = stm.executeUpdate();
                success = rowsAffected > 0; // Kiểm tra xem có dòng nào được ảnh hưởng không
            }
        } finally {
            // Đóng các tài nguyên
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return success;
    }

}
