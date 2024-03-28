package dao;

import dto.Auction;
import dto.AuctionHistory;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import mylib.DBUtils;

public class AuctionDAO {

    public Auction getAuctionByRealEstateId(String realEstateId) throws ClassNotFoundException, SQLException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;

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
                        + "  FROM [dbo].[Auction] WHERE RealEstateID = ?";
                stm = con.prepareStatement(sql);
                stm.setString(1, realEstateId);
                rs = stm.executeQuery();
                if (rs.next()) {

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
                    System.out.println(dto);
                    return dto;
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
        return null;
    }

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

    public List<Auction> getAuctionsV2() throws ClassNotFoundException, SQLException {
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
                        + "      ,[AccID]\n"
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
                    dto.setAccID(rs.getString("AccID"));

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

    public void setPriceNowAuctions(String pricenowbid, String realEstateID) throws ClassNotFoundException, SQLException {
        Connection cn = null;
        PreparedStatement pst = null;
        try {
            cn = DBUtils.getConnection();
            if (cn != null) {
                String sql = "UPDATE [dbo].[Auction]\n"
                        + "SET  [PriceNow]= ?, [Status] = 4 "
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

    public void setStatusTimeEndAuctions(int statusID, String realEstateID) throws ClassNotFoundException, SQLException {
        Connection cn = null;
        PreparedStatement pst = null;
        try {
            cn = DBUtils.getConnection();
            if (cn != null) {
                String sql = "UPDATE [dbo].[RealEstate]\n"
                        + "SET  [statusID]= ?\n"
                        + "WHERE [RealEstateID] = ?";
                pst = cn.prepareStatement(sql);
                pst.setInt(1, statusID);
                pst.setString(2, realEstateID);

                int rowsAffected = pst.executeUpdate();
                if (rowsAffected > 0) {
                    System.out.println("Cập nhật status = " + statusID + "thành công cho phiên đấu giá có ID: " + realEstateID);
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

    public void addTenSecondsToTimeEnd(String auctionId) throws ClassNotFoundException, SQLException {
        Connection cn = null;
        PreparedStatement pst = null;
        try {
            cn = DBUtils.getConnection();
            if (cn != null) {
                String sql = "UPDATE Auction SET TimeEnd = DATEADD(SECOND, 10, TimeEnd) WHERE auctionId = ?";
                pst = cn.prepareStatement(sql);
                pst.setString(1, auctionId);

                int rowsAffected = pst.executeUpdate();
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

    public double getCurrentPriceNow(String auctionId) throws ClassNotFoundException, SQLException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;

        try {
            con = DBUtils.getConnection();
            if (con != null) {
                String sql = "SELECT PriceNow FROM dbo.[Auction] WHERE AuctionID = ?";
                stm = con.prepareStatement(sql);
                stm.setString(1, auctionId);
                rs = stm.executeQuery();
                if (rs.next()) {
                    return rs.getFloat("PriceNow");
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
        return 0;
    }

    public int registerAuction(String auctionId, String accountId, double currentUserBalance, double requirmentPrice, int walletId, double auctionPriceNow) throws SQLException, ClassNotFoundException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;

        try {
            con = DBUtils.getConnection();
            // check price
            if (currentUserBalance >= requirmentPrice) {
                double userWalletBalance = currentUserBalance - requirmentPrice;
                if (con != null) {
                    LocalDateTime localDateTime = LocalDateTime.now();

                    // Convert LocalDateTime to java.sql.Date
                    java.util.Date date = new java.util.Date();

                    // Can check trong cai bang nay da co cai auctionID do chua. 
                    String sql = "INSERT INTO dbo.[AuctionDepositHistory] (WalletID, AuctionID, DateAndTime, Quantity) VALUES (?, ?, ?, ?)";
                    stm = con.prepareStatement(sql);
                    stm.setInt(1, walletId);
                    stm.setString(2, auctionId);
//                    stm.setObject(3, LocalDateTime.now());
                    stm.setTimestamp(3, new java.sql.Timestamp(date.getTime()));
                    stm.setDouble(4, requirmentPrice);

                    int affectedRow = stm.executeUpdate();
                    if (affectedRow > 0) {
                        // insert data thanh cong
                        // tiep tuc update bang userwallet va tao add data vao bang wallet transcationHistory
                        sql = "UPDATE dbo.[Wallet] SET AccountBalance = ? WHERE WalletID = ?";
                        stm = con.prepareStatement(sql);
                        stm.setDouble(1, userWalletBalance);
                        stm.setInt(2, walletId);
                        affectedRow = stm.executeUpdate();
                        if (affectedRow > 0) {
                            String action = "Register auction id = " + auctionId + " pirce = " + requirmentPrice;
                            sql = "INSERT INTO dbo.[WalletTransactionHistory] (WalletID, Quantity, DateAndTime, Action) VALUES (?, ?, ?, ?)";
                            stm = con.prepareStatement(sql);
                            stm.setInt(1, walletId);
                            // Tien gia ban dau cua cai auction + 5%.
                            stm.setDouble(2, requirmentPrice);
                            stm.setTimestamp(3, new java.sql.Timestamp(date.getTime()));
                            stm.setString(4, action);
                            affectedRow = stm.executeUpdate();
                            if (affectedRow > 0) {
                                // Add tien vao trong tai khoan admin [O day co hardcode adminId = A1, sau nay doi data thi vao DAO sua lai cho AccID]
                                int result = AddToAdminWallet(requirmentPrice);
                                if (result == 0) {
                                    return 0;
                                } else {
                                    // Add to admin wallet Successfully.
                                    // Add to auction history and winning history;
                                    Auction auction = getAuctionByRealEstateId(auctionId);
                                    AuctionHistory aucHistory = AuctionHistoryRecord(auctionId, auctionPriceNow, auction.getLamda());
                                    result = AuctionWinningHistory(aucHistory, accountId);
                                }
                                // successfully code
                                return 5;
                            } else {
                                // Cannot create WalletTranscationHistory table.
                                return 4;
                            }
                        } else {
                            // cannot update Wallet Table.
                            return 3;
                        }

                    } else {
                        // cannot create AuctionDepository Table.
                        return 2;
                    }

                }
            } else {
                // not enough money code
                return 1;
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
        return 0;
    }

    public int AddToAdminWallet(double price) {
        AccountDAO accountDAO = new AccountDAO();
        String ADMIN_WALLET_ID = "A1";
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        double currentUserBalance = accountDAO.getAccountWallet(ADMIN_WALLET_ID);
        double newBalance = currentUserBalance + price;
        try {
            con = DBUtils.getConnection();
            // Can check trong cai bang nay da co cai auctionID do chua. 
            String sql = "UPDATE dbo.[Wallet] SET AccountBalance = ? WHERE AccID = ?";
            stm = con.prepareStatement(sql);
            stm.setDouble(1, newBalance);
            stm.setString(2, ADMIN_WALLET_ID);
            int affectedRow = stm.executeUpdate();
            if (affectedRow > 0) {
                return 1;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public AuctionHistory AuctionHistoryRecord(String auctionId, double Price, double Lamda) {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            con = DBUtils.getConnection();
            java.util.Date date = new java.util.Date();
            String sql = "INSERT INTO dbo.[AuctionHistory] (AuctionId, Price, Lamda, Date) VALUES (?, ?, ?, ?)";
            stm = con.prepareStatement(sql);
            stm.setString(1, auctionId);
            stm.setDouble(2, Price);
            stm.setDouble(3, Lamda);
            stm.setTimestamp(4, new java.sql.Timestamp(date.getTime()));
            int affectedRow = stm.executeUpdate();
            if (affectedRow > 0) {
                sql = "SELECT TOP 1 * FROM AuctionHistory ORDER BY Date DESC";
                stm = con.prepareStatement(sql);
                rs = stm.executeQuery();
                if (rs.next()) {
                    AuctionHistory auctionHistory = new AuctionHistory();
                    auctionHistory.setAuctionHisID(rs.getInt("AuctionHisID"));
                    auctionHistory.setLamda(rs.getLong("Lamda"));
                    auctionHistory.setPrice(rs.getLong("Price"));
                    return auctionHistory;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    public int AuctionWinningHistory(AuctionHistory auctionHistory, String accountId) {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            String AuctionWinID = "AuctionWin-" + auctionHistory.getAuctionHisID();
            con = DBUtils.getConnection();
            // Can check trong cai bang nay da co cai auctionID do chua. 
            String sql = "INSERT INTO dbo.[AutionWinningHistory] (AuctionWinID, AuctionHisID, AccID, FinalPrice) VALUES (?, ?, ?, ?)";
            stm = con.prepareStatement(sql);
            stm.setString(1, AuctionWinID);
            stm.setInt(2, auctionHistory.getAuctionHisID());
            stm.setString(3, accountId);
            stm.setDouble(4, auctionHistory.getPrice());
            int affectedRow = stm.executeUpdate();
            if (affectedRow > 0) {
                return 1;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

}
