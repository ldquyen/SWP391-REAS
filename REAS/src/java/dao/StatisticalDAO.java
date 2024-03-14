/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import mylib.DBUtils;

/**
 *
 * @author TRUONG SON
 */
public class StatisticalDAO {

    public static boolean addNewLoginDate(String accid) {
        Connection cn = null;
        PreparedStatement pst = null;
        LocalDate currentTime = LocalDate.now();

        try {
            cn = DBUtils.getConnection();
            if (cn != null) {
                String sql = "insert into [dbo].[accountLoginDate] ([AccID],[loginDate])\n"
                        + "values(?, ?)";
                pst = cn.prepareStatement(sql);
                pst.setString(1, accid);
                pst.setDate(2, Date.valueOf(currentTime));
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

    public static boolean addNewRegisterDate(String accid) {
        Connection cn = null;
        PreparedStatement pst = null;
        LocalDate currentTime = LocalDate.now();

        try {
            cn = DBUtils.getConnection();
            if (cn != null) {
                String sql = "insert into [dbo].[accountRegisterDate] ([AccID], [registerDate])\n"
                        + "values (?, ?)";
                pst = cn.prepareStatement(sql);
                pst.setString(1, accid);
                pst.setDate(2, Date.valueOf(currentTime));
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
    
   public static int getLoginCountByRole(Date date, char roleCharacter) {
        Connection cn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        int loginCount = 0;

        try {
            cn = DBUtils.getConnection();
            if (cn != null) {
                String sql = "SELECT COUNT(*) AS loginCount FROM accountLoginDate WHERE CONVERT(date, loginDate) = ? AND AccID LIKE ?";
                pst = cn.prepareStatement(sql);
                pst.setDate(1, date);
                pst.setString(2, "%" + roleCharacter + "%");
                rs = pst.executeQuery();
                if (rs.next()) {
                    loginCount = rs.getInt("loginCount");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
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
        return loginCount;
    }

   public static int getTotalLoginCount(int year) {
        Connection cn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        int totalLoginCount = 0;

        try {
            cn = DBUtils.getConnection();
            if (cn != null) {
                String sql = "SELECT COUNT(*) AS totalLogin FROM accountLoginDate WHERE YEAR(loginDate) = ?";
                pst = cn.prepareStatement(sql);
                pst.setInt(1, year);
                rs = pst.executeQuery();
                if (rs.next()) {
                    totalLoginCount = rs.getInt("totalLogin");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
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
        return totalLoginCount;
    }
   
     public static int getTotalRegisterCount(Date date) {
        Connection cn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        int totalRegisterCount = 0;

        try {
            cn = DBUtils.getConnection();
            if (cn != null) {
                String sql = "SELECT COUNT(*) AS totalRegister FROM accountRegisterDate WHERE CONVERT(date, registerDate) = ?";
                pst = cn.prepareStatement(sql);
                pst.setDate(1, date);
                rs = pst.executeQuery();
                if (rs.next()) {
                    totalRegisterCount = rs.getInt("totalRegister");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
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
        return totalRegisterCount;
    }
    

}
