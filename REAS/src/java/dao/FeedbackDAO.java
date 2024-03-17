package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import mylib.DBUtils;

public class FeedbackDAO {

    private static int feedbackCounter = 1; // Initialize feedback counter

    public static boolean insertFeedback(String accID, String auctionID, LocalDateTime feedbackDate, int star, String detail) throws ClassNotFoundException {
        Connection cn = null;
        PreparedStatement pst = null;

        try {
            cn = DBUtils.getConnection();
            if (cn != null) {
                String feedbackID = "F" + String.format("%04d", feedbackCounter++); // Generate feedbackID
                String sql = "INSERT INTO Feedback (FeedbackID, AccID, AuctionID, FeedbackDate, Star, Detail) VALUES (?, ?, ?, ?, ?, ?)";
                pst = cn.prepareStatement(sql);
                pst.setString(1, feedbackID);
                pst.setString(2, accID);
                pst.setString(3, auctionID);
                pst.setTimestamp(4, Timestamp.valueOf(feedbackDate));
                pst.setInt(5, star);
                pst.setString(6, detail);
                int rowsAffected = pst.executeUpdate();
                return rowsAffected > 0;
            }
        } catch (SQLException e) {
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
}
