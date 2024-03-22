/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
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
}
