package dao;

import dto.OrderWallet;
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
import javax.naming.NamingException;
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

    public static List<Wallet> getWallet() throws ClassNotFoundException, SQLException {
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

    public long getAccountBalanceByAccID(String accID) throws ClassNotFoundException, SQLException {
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

    public static boolean sendRequestNapTien(Integer walletID, Long price, String orderID) throws ClassNotFoundException, SQLException {
        Connection con = null;
        PreparedStatement stm = null;

        try {
            con = DBUtils.getConnection();
            if (con != null) {
                String sql = "INSERT INTO [dbo].[WalletHistory] ([WalletID], [Price], [DateAndTime], [StatusID], [OrderID]) VALUES (?, ?, ?, 1, ?);";
                stm = con.prepareStatement(sql);
                stm.setInt(1, walletID);
                stm.setLong(2, price);
                stm.setTimestamp(3, Timestamp.valueOf(LocalDateTime.now()));
                stm.setString(4, orderID);
                // Gán các giá trị cần thiết cho các tham số trong câu lệnh SQL

                // Thực thi câu lệnh SQL
                stm.executeUpdate();
            }
        } finally {
            // Đóng tài nguyên
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return true;
    }
// Lấy Request Nạp Tiền bằng Status

    public List<OrderWallet> getRequestNapTien(int statusID) throws ClassNotFoundException, SQLException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        List<OrderWallet> result = null;

        try {
            con = DBUtils.getConnection();
            if (con != null) {
                String sql = "SELECT wh.OrderID, wh.WalletID, wh.Price, wh.DateAndTime, wh.StatusID, whs.StatusName\n"
                        + " FROM dbo.WalletHistory wh \n"
                        + " JOIN WalletHistoryStatus whs ON wh.StatusID = whs.StatusID \n"
                        + " WHERE wh.StatusID = ? ";
                stm = con.prepareStatement(sql);
                stm.setInt(1, statusID);
                rs = stm.executeQuery();
                while (rs.next()) {
                    if (result == null) {
                        result = new ArrayList<OrderWallet>();
                    }
                    OrderWallet dto = new OrderWallet();

                    dto.setOrderID(rs.getString("OrderID"));
                    dto.setWalletID(rs.getInt("WalletID"));
                    dto.setPrice(rs.getLong("Price"));

                    Timestamp dateSql = rs.getTimestamp("DateAndTime");
                    LocalDateTime date = dateSql.toLocalDateTime();
                    dto.setDate(date);

                    dto.setStatusName(rs.getString("StatusName"));

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

    // Lấy Request nạp tiền = WalletID
    public List<OrderWallet> getRequestNapTienByWalletID(int walletID) throws ClassNotFoundException, SQLException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        List<OrderWallet> result = null;

        try {
            con = DBUtils.getConnection();
            if (con != null) {
                String sql = "SELECT wh.OrderID, wh.WalletID, wh.Price, wh.DateAndTime, wh.StatusID, whs.StatusName\n"
                        + " FROM dbo.WalletHistory wh \n"
                        + " JOIN WalletHistoryStatus whs ON wh.StatusID = whs.StatusID \n"
                        + " WHERE wh.WalletID = ? \n"
                        + " ORDER BY wh.DateAndTime DESC";
                stm = con.prepareStatement(sql);
                stm.setInt(1, walletID);
                rs = stm.executeQuery();
                while (rs.next()) {
                    if (result == null) {
                        result = new ArrayList<OrderWallet>();
                    }
                    OrderWallet dto = new OrderWallet();

                    dto.setOrderID(rs.getString("OrderID"));
                    dto.setWalletID(rs.getInt("WalletID"));
                    dto.setPrice(rs.getLong("Price"));

                    Timestamp dateSql = rs.getTimestamp("DateAndTime");
                    LocalDateTime date = dateSql.toLocalDateTime();
                    dto.setDate(date);

                    dto.setStatusName(rs.getString("StatusName"));

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

    public boolean updateRequestNapTien(String orderID, int statusID) throws ClassNotFoundException, SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        boolean result = false;
        try {
            con = DBUtils.getConnection();
            if (con != null) {
                String sql = "UPDATE [dbo].[WalletHistory] SET [StatusID] = ? WHERE [OrderID] = ?";

                stm = con.prepareStatement(sql);
                stm.setInt(1, statusID);
                stm.setString(2, orderID);
                int effectRows = stm.executeUpdate();
                if (effectRows > 0) {
                    result = true;
                }
            }
        } finally {

            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return result;
    }

    public static boolean checkRequestOrderExists(String orderID) throws SQLException, ClassNotFoundException {
        Connection cn = DBUtils.getConnection();
        PreparedStatement pst = null;
        if (cn != null) {
            String sql = "select [OrderID] from [dbo].[WalletHistory] WHERE [OrderID] = ?";
            pst = cn.prepareStatement(sql);
            pst.setString(1, orderID);
            ResultSet rs = pst.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    String OrderID = rs.getString("orderID");
                    if (OrderID != null) {
                        return true;
                    } else {
                        return false;
                    }
                }
            }
        }
        return false;
    }

//    public static void main(String[] args) {
//       List<OrderWallet> list  =
//       list
//    }
//    public static void main(String[] args) {
//        boolean bl1 = addNewWallet(4, "M4");
//    }
}
