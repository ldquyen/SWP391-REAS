/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dto.RealEstate;
import dto.RealEstateInfo;
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
import javax.naming.NamingException;
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

    public static int getTotalLoginCount(String year) {
        Connection cn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        int totalLoginCount = 0;

        try {
            cn = DBUtils.getConnection();
            if (cn != null) {
                String sql = "SELECT COUNT(*) AS totalLogin FROM accountLoginDate WHERE YEAR(loginDate) = ?";
                pst = cn.prepareStatement(sql);
                pst.setString(1, year);
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

    public static int getTotalLoginCountMonth(String month) {
        Connection cn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        int totalLoginCount = 0;

        try {
            cn = DBUtils.getConnection();
            if (cn != null) {
                String sql = "SELECT COUNT(*) AS totalLogin FROM accountLoginDate WHERE MONTH(loginDate) = ?";
                pst = cn.prepareStatement(sql);
                pst.setString(1, month);
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

    public static int getTotalLoginCountDay(String day) {
        Connection cn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        int totalLoginCount = 0;

        try {
            cn = DBUtils.getConnection();
            if (cn != null) {
                String sql = "SELECT COUNT(*) AS totalLogin FROM accountLoginDate WHERE DAY(loginDate) = ?";
                pst = cn.prepareStatement(sql);
                pst.setString(1, day);
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

    public static int getTotalLoginCountYMD(String year, String month, String day) {
        Connection cn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        int totalLoginCount = 0;

        try {
            cn = DBUtils.getConnection();
            if (cn != null) {
                String sql = "SELECT COUNT(*) AS totalLogin FROM accountLoginDate WHERE YEAR(loginDate) = ? AND MONTH(loginDate) = ? AND DAY(loginDate) = ?";
                pst = cn.prepareStatement(sql);
                pst.setString(1, year);
                pst.setString(2, month);
                pst.setString(3, day);
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

    public static int getTotalRegisterCountYMD(String registeryear, String registermonth, String registerday) {
        Connection cn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        int totalRegisterCount = 0;

        try {
            cn = DBUtils.getConnection();
            if (cn != null) {
                String sql = "SELECT COUNT(*) AS totalRegister FROM accountRegisterDate WHERE YEAR(registerDate) = ? AND MONTH(registerDate) = ? AND DAY(registerDate) = ?";
                pst = cn.prepareStatement(sql);
                pst.setString(1, registeryear);
                pst.setString(2, registermonth);
                pst.setString(3, registerday);
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

    public static int getTotalRegisterCountDay(String day) {
        Connection cn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        int totalRegisterCount = 0;

        try {
            cn = DBUtils.getConnection();
            if (cn != null) {
                String sql = "SELECT COUNT(*) AS totalRegister FROM accountRegisterDate WHERE DAY(registerDate) = ?";
                pst = cn.prepareStatement(sql);
                pst.setString(1, day);
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

    public static int getTotalRegisterCountMonth(String month) {
        Connection cn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        int totalRegisterCount = 0;

        try {
            cn = DBUtils.getConnection();
            if (cn != null) {
                String sql = "SELECT COUNT(*) AS totalRegister FROM accountRegisterDate WHERE MONTH(registerDate) = ?";
                pst = cn.prepareStatement(sql);
                pst.setString(1, month);
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

    public static int getTotalRegisterCountYear(String year) {
        Connection cn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        int totalRegisterCount = 0;

        try {
            cn = DBUtils.getConnection();
            if (cn != null) {
                String sql = "SELECT COUNT(*) AS totalRegister FROM accountRegisterDate WHERE YEAR(registerDate) = ?";
                pst = cn.prepareStatement(sql);
                pst.setString(1, year);
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

    public static ArrayList<RealEstate> getAllRealEstateByCatID(String catid) throws ClassNotFoundException, SQLException, NamingException {
        ArrayList<RealEstate> list = new ArrayList<>();
        Connection cn = DBUtils.getConnection();
        if (cn != null) {
            String sql = "SELECT [RealEstateID], [ImageFolderID], [AccID], [CatID], [CityID], [RealEstateName], [PriceFirst], [TimeUp], [TimeDown], [PriceLast],[PricePaid], [StatusID], [Area], [Address] ,[Detail]\n"
                    + "FROM RealEstate WHERE [CatID] = ?";
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setString(1, catid);
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
