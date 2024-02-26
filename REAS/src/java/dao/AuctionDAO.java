package dao;

import dto.Auction;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import mylib.DBUtils;

public class AuctionDAO {

    public List<Auction> getAuctions() throws ClassNotFoundException, SQLException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        List<Auction> result = null;

        try {
            con = DBUtils.getConnection();
            if (con != null) {
                String sql = "SELECT [AuctionID]\n"
                        + "      ,[RealEstateID]\n"
                        + "      ,[AuctionName]\n"
                        + "      ,[PriceNow]\n"
                        + "      ,[Lamda]\n"
                        + "      ,[TimeStart]\n"
                        + "      ,[TimeEnd]\n"
                        + "  FROM [dbo].[Auction]";
                stm = con.prepareStatement(sql);
                rs = stm.executeQuery();
                while (rs.next()) {
                    if (result == null) {
                        result = new ArrayList<Auction>();
                    }
                    Auction dto = new Auction();

                    dto.setAuctionID(rs.getString("AuctionID"));
                    dto.setRealEstateID(rs.getString("RealEstateID"));
                    dto.setAuctionName(rs.getString("AuctionName"));
                    dto.setPriceNow(rs.getLong("PriceNow"));
                    dto.setLamda(rs.getLong("Lamda"));

                    Timestamp timeStartSql = rs.getTimestamp("TimeStart");
                    Timestamp timeEndSql = rs.getTimestamp("TimeEnd");

                    // Chuyển đổi Timestamp thành LocalDateTime
                    LocalDateTime timeStart = timeStartSql.toLocalDateTime();
                    LocalDateTime timeEnd = timeEndSql.toLocalDateTime();

                    dto.setTimeStart(timeStart);
                    dto.setTimeEnd(timeEnd);

//                    dto.setTimeStart(rs.getObject("TimeStart", LocalDateTime.class));
//                    dto.setTimeEnd(rs.getObject("TimeEnd", LocalDateTime.class));
                    result.add(dto);

                    System.out.println(dto);
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

//        Auction auction = new Auction();
//        Connection cn = DBUtils.getConnection();
//        if (cn != null) {
//            String sql = "SELECT\n"
//                    + "    A.AuctionName,\n"
//                    + "    CI.CityName,\n"
//                    + "    C.CatName,\n"
//                    + "    R.PriceNow,\n"
//                    + "    A.TimeEnd,\n"
//                    + "    R.Status\n"
//                    + "FROM\n"
//                    + "    Auction A\n"
//                    + "    JOIN RealEstate R ON A.RealEstateID = R.RealEstateID\n"
//                    + "    JOIN Category C ON R.CatID = C.CatID\n"
//                    + "    JOIN City CI ON R.CityID = CI.CityID;";
//            PreparedStatement pst = cn.prepareStatement(sql);
//
//            ResultSet rs = pst.executeQuery();
//            if (rs != null) {
//                while (rs.next()) {
//                    String AuctionName = rs.getString("AuctionName");
//                    String CityName = rs.getString("CityName");
//                    String CatName = rs.getString("CatName");
//                    String PriceNow = rs.getString("PriceNow");
//                    String TimeEnd = rs.getString("TimeEnd");
//                    boolean Status = rs.getBoolean("Status");
//                    auction = new Auction(AuctionName, TimeEnd, AuctionName, 0, 0, LocalDateTime.MAX, LocalDateTime.MIN);
//                }
//            }
//            cn.close();
//        }
//        return auction;
    }

    public void setPriceNowAuctions(String pricenowbid, String realEstateID) throws ClassNotFoundException, SQLException {
        Connection cn = null;
        PreparedStatement pst = null;
        try {
            cn = DBUtils.getConnection();
            if (cn != null) {
                String sql = "UPDATE [dbo].[Auction]\n"
                        + "SET  [PriceNow]= ?\n"
                        + "WHERE [RealEstateID] = ?";
                pst = cn.prepareStatement(sql);
                pst.setString(1, pricenowbid);
                pst.setString(2, realEstateID);

                int rowsAffected = pst.executeUpdate();
                if (rowsAffected > 0) {
                    System.out.println("Cập nhật giá thành công cho phiên đấu giá có ID: " + realEstateID);
                } else {
                    System.out.println("Không tìm thấy phiên đấu giá nào có ID: " + realEstateID);
                }
            }
        } finally {
            if (pst != null) {
                pst.close();
            }
            if (cn != null) {
                cn.close();
            }
        }
    }

}
