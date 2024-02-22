package dao;

import dto.RealEstate;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import javax.naming.NamingException;
import mylib.DBUtils;

public class RealEstateDAO {

    public boolean createPost(String realEstateID, String imageFolderID, String accID, String catID, int cityID,
            String realEstateName, long priceFirst, LocalDateTime timeUp, LocalDateTime timeDown, long priceLast, long pricePaid, int statusID,
            int area, String address, String detail) throws SQLException, NamingException, ClassNotFoundException {
        //mở connection
        Connection con = null;
        PreparedStatement stm = null;
        boolean result = false;
        try {
            con = DBUtils.getConnection();

            if (con != null) {
                String sql1 = "INSERT INTO [dbo].[RealEstate]"
                        + "([RealEstateID], [ImageFolderID], [AccID], [CatID], [CityID], [RealEstateName], [PriceFirst], [TimeUp], [TimeDown],[PriceLast],[PricePaid], [statusID], [Area], [Address], [Detail])"
                        + " VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
                stm = con.prepareStatement(sql1);

                stm.setString(1, realEstateID);
                stm.setString(2, imageFolderID);
                stm.setString(3, accID);
                stm.setString(4, catID);
                stm.setInt(5, cityID);
                stm.setString(6, realEstateName);
                stm.setLong(7, priceFirst);
                stm.setTimestamp(8, Timestamp.valueOf(LocalDateTime.now()));
                stm.setTimestamp(9, Timestamp.valueOf(LocalDateTime.now()));
                stm.setLong(10, priceLast);
                stm.setLong(11, pricePaid);
                stm.setInt(12, statusID);
                stm.setInt(13, area);
                stm.setString(14, address);
                stm.setString(15, detail);

                int effectRows = stm.executeUpdate();
                if (effectRows > 0) {
                    String sql2 = "INSERT INTO [dbo].[Auction]"
                            + "([AuctionID],[RealEstateID],[AuctionName],[PriceNow],[Lamda],[TimeStart],[TimeEnd])"
                            + "VALUES (?,?,?,?,0,?,?)";
                    try (PreparedStatement anotherStm = con.prepareStatement(sql2)) {
                        anotherStm.setString(1, realEstateID);
                        anotherStm.setString(2, realEstateID);
                        anotherStm.setString(3, realEstateName);
                        anotherStm.setLong(4, priceFirst);
                        anotherStm.setTimestamp(5, Timestamp.valueOf(timeUp));
                        anotherStm.setTimestamp(6, Timestamp.valueOf(timeDown));

                        int anotherEffectRows = anotherStm.executeUpdate();
                        // Xử lý kết quả hoặc thông báo

                    }
                    result = true;
                }
            }
        } finally {
            //xoa,sua,insert khong tra du lieu
            //bo ResultSet
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return result;
    }

    public static boolean checkRealEstateIDExists(String realEstateID) throws SQLException, ClassNotFoundException {
        Connection cn = DBUtils.getConnection();
        PreparedStatement pst = null;
        if (cn != null) {
            String sql = "select [RealEstateID] from [dbo].[RealEstate] WHERE [RealEstateID] = ?";
            pst = cn.prepareStatement(sql);
            pst.setString(1, realEstateID);
            ResultSet rs = pst.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    String RealEstateID = rs.getString("realEstateID");
                    if (RealEstateID != null) {
                        return true;
                    } else {
                        return false;
                    }
                }
            }
        }
        return false;
    }

    public static ArrayList<RealEstate> getRealEstateByStatus(String stringsql, int StatusID) throws ClassNotFoundException, SQLException, NamingException {
        ArrayList<RealEstate> list = new ArrayList<>();
        Connection cn = DBUtils.getConnection();
        if (cn != null) {
            String sql = stringsql;
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setInt(1, StatusID);
            ResultSet rs = pst.executeQuery();

            if (rs != null) {
                while (rs.next()) {

                    String realEstateID = rs.getString("RealEstateID");
                    String imageFolderID = rs.getString("ImageFolderID");
                    String accID = rs.getString("AccID");
                    String catID = rs.getString("CatID");
                    int cityID = rs.getInt("CityID");
                    String realEstateName = rs.getString("RealEstateName");
                    long priceFirst = rs.getLong("PriceFirst");

                    Timestamp timeUpSql = rs.getTimestamp("TimeUp");
                    Timestamp timeDownSql = rs.getTimestamp("TimeDown");

                    // Chuyển đổi Timestamp thành LocalDateTime
                    LocalDateTime timeUp = timeUpSql.toLocalDateTime();
                    LocalDateTime timeDown = timeDownSql.toLocalDateTime();
                    long priceLast = rs.getLong("PriceLast");
                    long pricePaid = rs.getLong("PricePaid");
                    int statusid = rs.getInt("StatusID");
                    int area = rs.getInt("Area");
                    String address = rs.getString("Address");
                    String detail = rs.getString("Detail");

                    RealEstate re = new RealEstate(realEstateID, imageFolderID, accID, catID, cityID, realEstateName, priceFirst, timeUp, timeDown, priceLast, pricePaid, statusid, area, address, detail);
                    list.add(re);
                }
            }
            cn.close();
        }
        return list;
    }
    
    public static ArrayList<RealEstate> getRealEstateByID(String RealEstateID) throws ClassNotFoundException, SQLException, NamingException {
        ArrayList<RealEstate> list = new ArrayList<>();
        Connection cn = DBUtils.getConnection();
        if (cn != null) {
            String sql = "SELECT [RealEstateID], [ImageFolderID], [AccID], [CatID], [CityID], [RealEstateName], [PriceFirst], [TimeUp], [TimeDown], [PriceLast],[PricePaid], [StatusID], [Area], [Address] ,[Detail] \n"
                    + "FROM RealEstate WHERE [RealEstateID] = ?";
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setString(1, RealEstateID);
            ResultSet rs = pst.executeQuery();

            if (rs != null) {
                while (rs.next()) {

                    String realEstateID = rs.getString("RealEstateID");
                    String imageFolderID = rs.getString("ImageFolderID");
                    String accID = rs.getString("AccID");
                    String catID = rs.getString("CatID");
                    int cityID = rs.getInt("CityID");
                    String realEstateName = rs.getString("RealEstateName");
                    long priceFirst = rs.getLong("PriceFirst");

                    Timestamp timeUpSql = rs.getTimestamp("TimeUp");
                    Timestamp timeDownSql = rs.getTimestamp("TimeDown");

                    // Chuyển đổi Timestamp thành LocalDateTime
                    LocalDateTime timeUp = timeUpSql.toLocalDateTime();
                    LocalDateTime timeDown = timeDownSql.toLocalDateTime();
                    long priceLast = rs.getLong("PriceLast");
                    long pricePaid = rs.getLong("PricePaid");
                    int statusid = rs.getInt("StatusID");
                    int area = rs.getInt("Area");
                    String address = rs.getString("Address");
                    String detail = rs.getString("Detail");

                    RealEstate re = new RealEstate(realEstateID, imageFolderID, accID, catID, cityID, realEstateName, priceFirst, timeUp, timeDown, priceLast, pricePaid, statusid, area, address, detail);
                    list.add(re);
                }
            }
            cn.close();
        }
        return list;
    }
}
