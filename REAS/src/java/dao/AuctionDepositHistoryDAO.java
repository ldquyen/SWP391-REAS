package dao;

import dto.AuctionDepositHistory;
import dto.City;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import mylib.DBUtils;

public class AuctionDepositHistoryDAO {

    // trả về tổng số cuộc đấu giá đã diễn ra
    public static long getTongSoCuocDauGiaDienRa() throws SQLException, ClassNotFoundException {
        long a = 0;
        Connection cn = DBUtils.getConnection();
        if (cn != null) {
            String sql = "SELECT COUNT(DISTINCT [AuctionID]) AS SCDGDR\n"
                    + "FROM AuctionDepositHistory";
            PreparedStatement pst = cn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    a = rs.getLong("SCDGDR");
                }
            }
            cn.close();
        }
        return a;
    }

    //trả về số ng tham gia trong từng cuộc đấu giá để nhân 5 tr = tiền phí
    public static long getSoNgThamGiaTrongTungCuocDauGia() throws SQLException, ClassNotFoundException {
        long a = 0;
        Connection cn = DBUtils.getConnection();
        if (cn != null) {
            String sql = "SELECT   COUNT ( AuctionDepositHisID) AS STPTD\n"
                    + "FROM AuctionDepositHistory";
            PreparedStatement pst = cn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    a = rs.getLong("STPTD");
                }
            }
            cn.close();
        }
        return a;
    }

    //trả về tổng số tiền thắng được của các cuộc đấu giá
    public static long getTongSoTienCuaCacCuocDauGia() throws SQLException, ClassNotFoundException {
        long a = 0;
        Connection cn = DBUtils.getConnection();
        if (cn != null) {
            String sql = "SELECT SUM(Highest) AS STTDG\n"
                    + "FROM (\n"
                    + "    SELECT MAX([Quantity]) AS Highest\n"
                    + "    FROM AuctionDepositHistory\n"
                    + "    GROUP BY [AuctionID]\n"
                    + ") AS subquery;";
            PreparedStatement pst = cn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    a = rs.getLong("STTDG");
                }
            }
            cn.close();
        }
        return a;
    }

    public static ArrayList<AuctionDepositHistory> getListADH() throws SQLException, ClassNotFoundException {
        ArrayList<AuctionDepositHistory> a = new ArrayList<>();

        Connection cn = DBUtils.getConnection();
        if (cn != null) {
            String sql = "SELECT  [AuctionID], MAX([Quantity]) AS [Quantity]\n"
                    + "FROM AuctionDepositHistory\n"
                    + "GROUP BY [AuctionID];";
            PreparedStatement pst = cn.prepareStatement(sql);

            ResultSet rs = pst.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    AuctionDepositHistory adh = new AuctionDepositHistory();
                    String walletID = rs.getString("AuctionID");
                    int quantity = rs.getInt("Quantity") / 1000;
                    adh.setAuctionID(walletID);
                    adh.setQuantity(quantity);
                    a.add(adh);
                }
            }
            cn.close();
        }
        return a;
    }

    //month
    public static long getTongSoCuocDauGiaDienRaInMonth(String month) throws SQLException, ClassNotFoundException {
        long a = 0;
        Connection cn = DBUtils.getConnection();
        if (cn != null) {
            String sql = "SELECT COUNT(DISTINCT [AuctionID]) AS SCDGDR \n"
                    + "FROM AuctionDepositHistory WHERE MONTH(DateAndTime) = ?";
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setString(1, month);
            ResultSet rs = pst.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    a = rs.getLong("SCDGDR");
                }
            }
            cn.close();
        }
        return a;
    }

    public static long getSoNgThamGiaTrongTungCuocDauGiaInMonth(String month) throws SQLException, ClassNotFoundException {
        long a = 0;
        Connection cn = DBUtils.getConnection();
        if (cn != null) {
            String sql = "SELECT   COUNT ( AuctionDepositHisID) AS STPTD\n"
                    + "FROM AuctionDepositHistory WHERE MONTH(DateAndTime) = ?\n";
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setString(1, month);
            ResultSet rs = pst.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    a = rs.getLong("STPTD");
                }
            }
            cn.close();
        }
        return a;
    }

    public static long getTongSoTienCuaCacCuocDauGiaInMonth(String month) throws SQLException, ClassNotFoundException {
        long a = 0;
        Connection cn = DBUtils.getConnection();
        if (cn != null) {
            String sql = "SELECT SUM(Highest) AS STTDG\n"
                    + "FROM (\n"
                    + "    SELECT MAX([Quantity]) AS Highest \n"
                    + "    FROM AuctionDepositHistory WHERE MONTH(DateAndTime) = ?\n"
                    + "    GROUP BY [AuctionID]\n"
                    + ") AS subquery;";
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setString(1, month);
            ResultSet rs = pst.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    a = rs.getLong("STTDG");
                }
            }
            cn.close();
        }
        return a;
    }

    public static ArrayList<AuctionDepositHistory> getListADHInMonth(String month) throws SQLException, ClassNotFoundException {
        ArrayList<AuctionDepositHistory> a = new ArrayList<>();

        Connection cn = DBUtils.getConnection();
        if (cn != null) {
            String sql = "SELECT  [AuctionID], MAX([Quantity]) AS [Quantity]\n"
                    + "FROM AuctionDepositHistory\n"
                    + "WHERE MONTH(DateAndTime) = ?\n"
                    + "GROUP BY [AuctionID];";
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setString(1, month);
            ResultSet rs = pst.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    AuctionDepositHistory adh = new AuctionDepositHistory();
                    String walletID = rs.getString("AuctionID");
                    int quantity = rs.getInt("Quantity") / 1000;
                    adh.setAuctionID(walletID);
                    adh.setQuantity(quantity);
                    a.add(adh);
                }
            }
            cn.close();
        }
        return a;
    }

    public static ArrayList<AuctionDepositHistory> getListRefund(String AuctionID) throws SQLException, ClassNotFoundException {
        ArrayList<AuctionDepositHistory> a = new ArrayList<>();

        Connection cn = DBUtils.getConnection();
        if (cn != null) {
            String sql = "SELECT WalletID, DateAndTime, Quantity\n"
                    + "FROM AuctionDepositHistory\n"
                    + "WHERE AuctionID = ?\n"
                    + "ORDER BY DateAndTime ASC\n"
                    + "OFFSET 0 ROWS\n"
                    + "FETCH NEXT (SELECT COUNT(*) - 1 FROM AuctionDepositHistory WHERE AuctionID LIKE '%3%') ROWS ONLY;";
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setString(1, AuctionID);
            ResultSet rs = pst.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    AuctionDepositHistory adh = new AuctionDepositHistory();
                    String walletID = rs.getString("WalletID");
                    long quantity = rs.getLong("Quantity");
                    Timestamp time = rs.getTimestamp("DateAndTime");
                    LocalDateTime DateAndTime = time.toLocalDateTime();
                    adh.setWalletID(walletID);
                    adh.setDateAndTime(DateAndTime);
                    adh.setQuantity(quantity);

                    a.add(adh);
                }
            }
            cn.close();
        }
        return a;
    }

    public static ArrayList<AuctionDepositHistory> getListRefundDetail(String AuctionID) throws SQLException, ClassNotFoundException {
        ArrayList<AuctionDepositHistory> a = new ArrayList<>();

        Connection cn = DBUtils.getConnection();
        if (cn != null) {
            String sql = "SELECT WalletID, SUM(Quantity) AS TotalQuantity\n"
                    + "FROM (\n"
                    + "    SELECT WalletID, Quantity, ROW_NUMBER() OVER (ORDER BY DateAndTime ASC) AS RowNum\n"
                    + "    FROM AuctionDepositHistory\n"
                    + "    WHERE AuctionID = ?\n"
                    + ") AS Subquery\n"
                    + "WHERE RowNum < (SELECT COUNT(*) FROM AuctionDepositHistory WHERE AuctionID LIKE '%3%')\n"
                    + "GROUP BY WalletID;";
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setString(1, AuctionID);
            ResultSet rs = pst.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    AuctionDepositHistory adh = new AuctionDepositHistory();
                    String walletID = rs.getString("WalletID");
                    long quantity = rs.getLong("TotalQuantity");
                    
                    adh.setWalletID(walletID);
                    
                    adh.setQuantity(quantity);

                    a.add(adh);
                }
            }
            cn.close();
        }
        return a;
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        ArrayList<AuctionDepositHistory> getListADH = getListRefundDetail("M3");
        for (AuctionDepositHistory auctionDepositHistory : getListADH) {
            System.out.println(auctionDepositHistory.getWalletID() +"|" + auctionDepositHistory.getQuantity());
        }
//        Long a = getSoNgThamGiaTrongTungCuocDauGiaInMonth("3");
//        System.out.println(a);
    }
}
