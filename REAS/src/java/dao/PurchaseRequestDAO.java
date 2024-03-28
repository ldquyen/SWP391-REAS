/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dto.PurchaseRequest;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import mylib.DBUtils;

/**
 *
 * @author ADMIN
 */
public class PurchaseRequestDAO {

    public boolean sendRequestMuaNgay(String accID, String realEstateID, long pricePaid) throws ClassNotFoundException, SQLException {
        Connection con = null;
        PreparedStatement stm = null;

        try {
            con = DBUtils.getConnection();
            if (con != null) {
                String sql = "INSERT INTO [dbo].[PurchaseRequests] ([AccID], [RealEstateID], [PricePaid], [DateAndTime], [RequestStatusID]) VALUES (?, ?, ?, ?, 1)";
                stm = con.prepareStatement(sql);
                stm.setString(1, accID);
                stm.setString(2, realEstateID);
                stm.setLong(3, pricePaid);
                stm.setTimestamp(4, Timestamp.valueOf(LocalDateTime.now()));
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

    public List<PurchaseRequest> getAllPurchaseRequests(String realEstateID) throws SQLException, ClassNotFoundException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        List<PurchaseRequest> result = null;
        try {
            con = DBUtils.getConnection();
            if (con != null) {
                String sql = " SELECT pr.AccID, "
                        + " pr.RealEstateID, "
                        + " pr.PricePaid, "
                        + " pr.DateAndTime, "
                        + " pr.RequestStatusID, "
                        + " rs.RequestStatusName "
                        + " FROM PurchaseRequests pr INNER JOIN RequestStatus rs ON pr.RequestStatusID = rs.RequestStatusID "
                        + " Where pr.RealEstateID = ? ";
                stm = con.prepareStatement(sql);
                stm.setString(1, realEstateID);
                rs = stm.executeQuery();
                while (rs.next()) {
                    if (result == null) {
                        result = new ArrayList<PurchaseRequest>();
                    }
                    PurchaseRequest dto = new PurchaseRequest();
                    dto.setRealEstateID(rs.getString("RealEstateID"));
                    dto.setAccID(rs.getString("AccID"));

                    dto.setPricePaid(rs.getLong("PricePaid"));

                    Timestamp timeRequestSql = rs.getTimestamp("DateAndTime");
                    LocalDateTime timeRequest = timeRequestSql.toLocalDateTime();
                    dto.setTimeRequest(timeRequest);

                    dto.setRequestStatusID(rs.getInt("RequestStatusID"));
                    dto.setRequestStatusName(rs.getString("RequestStatusName"));
                    result.add(dto);
                }
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            // Đóng tài nguyên
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return result;
    }

    public Integer getPurchaseStatus(String realEstateID, String accID) throws SQLException, ClassNotFoundException {
        Integer purchaseStatusID = null;
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;

        try {
            con = DBUtils.getConnection();
            // Tạo truy vấn SQL
            String sql = "SELECT RequestStatusID FROM PurchaseRequests WHERE RealEstateID = ? AND AccID = ?";
            stm = con.prepareStatement(sql);
            stm.setString(1, realEstateID);
            stm.setString(2, accID);

            // Thực thi truy vấn
            rs = stm.executeQuery();

            // Xử lý kết quả trả về
            if (rs.next()) {
                purchaseStatusID = rs.getInt("RequestStatusID");
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            // Đóng tài nguyên
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }

        return purchaseStatusID;
    }

    public void updateStatusForMultipleRequests() throws SQLException, ClassNotFoundException {
        String sql = "SELECT RealEstateID FROM PurchaseRequests GROUP BY RealEstateID HAVING COUNT(*) > 1";
        Connection con = null;
        try (PreparedStatement statement = con.prepareStatement(sql);
                ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                String realEstateID = resultSet.getString("RealEstateID");
                updateStatus3(realEstateID);
            }
        }
    }

    public boolean updateStatus3(String realEstateID) throws SQLException, ClassNotFoundException {
        Connection con = null;
        PreparedStatement stm = null;
        boolean result = false;

        try {
            con = DBUtils.getConnection();
            if (con != null) {
                String sql = "UPDATE PurchaseRequests SET RequestStatusID = 3 WHERE RealEstateID = ?";
                stm = con.prepareStatement(sql);
                stm.setString(1, realEstateID);
                int effectRows = stm.executeUpdate();
                if (effectRows > 0) {
                    result = true;
                }
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
        return result;
    }
//    public boolean updateStatus2(String realEstateID) throws SQLException, ClassNotFoundException {
//        Connection con = null;
//        PreparedStatement stm = null;
//        boolean result = false;
//
//        try {
//            con = DBUtils.getConnection();
//            if (con != null) {
//                String sql = "UPDATE PurchaseRequests SET RequestStatusID = 2 WHERE RealEstateID = ?";
//                stm = con.prepareStatement(sql);
//                stm.setString(1, realEstateID);
//                int effectRows = stm.executeUpdate();
//                if (effectRows > 0) {
//                    result = true;
//                }
//            }
//        } finally {
//            // Đóng tài nguyên
//            if (stm != null) {
//                stm.close();
//            }
//            if (con != null) {
//                con.close();
//            }
//        }
//        return result;
//    }
    public boolean updateStatus2(String accID, String realEsteateID) throws SQLException, ClassNotFoundException {
        Connection con = null;
        PreparedStatement stm = null;
        boolean result = false;

        try {
            con = DBUtils.getConnection();
            if (con != null) {
                String sql = "UPDATE PurchaseRequests SET RequestStatusID = 2 WHERE AccID = ? AND RealEstateID = ?";
                stm = con.prepareStatement(sql);
                stm.setString(1, accID);
                stm.setString(2, realEsteateID);
                int effectRows = stm.executeUpdate();
                if (effectRows > 0) {
                    result = true;
                }
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
        return result;
    }

}
