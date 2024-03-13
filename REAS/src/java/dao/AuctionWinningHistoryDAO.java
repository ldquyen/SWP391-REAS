package dao;

import dto.Account;
import dto.Auction;
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

public class AuctionWinningHistoryDAO {

    public List<AuctionWinningHistory> getAuctionWinning() throws ClassNotFoundException, SQLException {

        Connection cn = DBUtils.getConnection();
        List<AuctionWinningHistory> result = null;
        if (cn != null) {
            String sql = "SELECT [AuctionWinID],[AuctionHisID],[AccID],[FinalPrice] \n"
                    + "FROM AutionWinningHistory";
//             WHERE [AuctionWinID] = ?
            PreparedStatement pst = cn.prepareStatement(sql);
//            pst.setString(1, auctionHisID);
            ResultSet rs = pst.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    AuctionWinningHistory a = new AuctionWinningHistory();
                    a.setAuctionWinID(rs.getString("AuctionWinID"));
                    a.setAuctionHisID(rs.getString("AuctionHisID"));
                    a.setAccID(rs.getString("AccID"));
                    a.setFinalPrice(rs.getLong("FinalPrice"));
                    result.add(a);
                }
            }
            cn.close();
        }
        return result;
    }

    public List<AuctionWinningHistory> getAuctionWinning2() throws ClassNotFoundException, SQLException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        List<AuctionWinningHistory> result = null;

        try {
            con = DBUtils.getConnection();
            if (con != null) {
                String sql = "SELECT [`1AuctionWinID],[AuctionHisID],[AccID],[FinalPrice] \n"
                        + "FROM AutionWinningHistory";
                stm = con.prepareStatement(sql);
                rs = stm.executeQuery();
                while (rs.next()) {
                    if (result == null) {
                        result = new ArrayList<AuctionWinningHistory>();
                    }
                    AuctionWinningHistory a = new AuctionWinningHistory();
                    a.setAuctionWinID(rs.getString("AuctionWinID"));
                    a.setAuctionHisID(rs.getString("AuctionHisID"));
                    a.setAccID(rs.getString("AccID"));
                    a.setFinalPrice(rs.getLong("FinalPrice"));

//                    dto.setTimeStart(rs.getObject("TimeStart", LocalDateTime.class));
//                    dto.setTimeEnd(rs.getObject("TimeEnd", LocalDateTime.class));
                    result.add(a);

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
}
