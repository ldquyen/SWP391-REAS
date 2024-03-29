package dao;

import dto.AuctionDepositHistory;
import dto.AuctionHistory;
import dto.AuctionWinningHistory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import mylib.DBUtils;

public class AuctionHistoryDAO {

    public AuctionHistory getAuctionHistory(String AuctionID) throws ClassNotFoundException, SQLException {
        AuctionHistory auctionhistory = new AuctionHistory();
        Connection cn = DBUtils.getConnection();
        if (cn != null) {
            String sql = "SELECT [AuctionHisID],[AuctionID],[Status],[Lamda],[TimeJoin],[TimeOut],[NumberOfBids],[StartPrice] \n"
                    + "FROM AuctionHistory WHERE [AuctionID] = ?";
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setString(1, AuctionID);
            ResultSet rs = pst.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    String auctionHisID = rs.getString("AuctionHisID");
                    String auctionID = rs.getString("AuctionID");
                    int status = rs.getInt("Status");
                    long lamda = rs.getLong("Lamda");

                    Timestamp timeJoinSql = rs.getTimestamp("TimeJoin");
                    Timestamp timeOutSql = rs.getTimestamp("TimeOut");

                    // Chuyển đổi Timestamp thành LocalDateTime
                    LocalDateTime timeJoin = timeJoinSql.toLocalDateTime();
                    LocalDateTime timeOut = timeOutSql.toLocalDateTime();

//                    auctionhistory.setTimeJoin(timeStart);
//                    auctionhistory.setTimeOut(timeEnd);
                    int numberOfBids = rs.getInt("NumberOfBids");
                    long startPrice = rs.getLong("StartPrice");
//                    auctionhistory = new AuctionHistory(auctionHisID, auctionID, status, lamda, timeJoin, timeOut, numberOfBids, startPrice);
                }
            }
            cn.close();
        }
        return auctionhistory;
    }

    public List<Integer> getPriceTop5(String AuctionID) throws ClassNotFoundException, SQLException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;

        List<Integer> top5Prices = new ArrayList<>();

        try {
            con = DBUtils.getConnection();
            if (con != null) {
                String sql = "SELECT DISTINCT TOP 5 Price\n"
                        + "FROM AuctionHistory\n"
                        + "WHERE AuctionID = ?\n"
                        + // corrected placement of WHERE clause
                        "ORDER BY Price DESC"; // moved ORDER BY clause here
                stm = con.prepareStatement(sql);
                stm.setString(1, AuctionID);
                rs = stm.executeQuery();

                while (rs.next()) {
                    int price = rs.getInt("Price");
                    top5Prices.add(price);
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
        return top5Prices;
    }

    public List<Integer> getPriceTop1(String AuctionID) throws ClassNotFoundException, SQLException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;

        List<Integer> topPrices = new ArrayList<>();

        try {
            con = DBUtils.getConnection();
            if (con != null) {
                String sql = "SELECT DISTINCT TOP 1 Price\n"
                        + "FROM AuctionHistory\n"
                        + "WHERE AuctionID = ?\n"
                        + // corrected placement of WHERE clause
                        "ORDER BY Price DESC"; // moved ORDER BY clause here
                stm = con.prepareStatement(sql);
                stm.setString(1, AuctionID);
                rs = stm.executeQuery();

                while (rs.next()) {
                    int price = rs.getInt("Price");
                    topPrices.add(price);
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
        return topPrices;
    }
}
