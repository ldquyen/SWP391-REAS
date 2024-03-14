/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import javax.naming.NamingException;
import model.UserVM;
import mylib.DBUtils;

/**
 *
 * @author Admin
 */
public class AdminDAO {

    public int getListUserCount() {
        int count = 0;
        String sql = "SELECT count(*) FROM dbo.[Account] WHERE RoleID = ? ";
        try {
            String statusId = "M";
            Connection cn = DBUtils.getConnection();
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setString(1, statusId);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                count = rs.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return count;
    }

    public List<UserVM> getListMember() throws ClassNotFoundException, SQLException, NamingException {
        ArrayList<UserVM> listMemebers = new ArrayList<>();
        Connection cn = DBUtils.getConnection();
        String statusId = "M";
        if (cn != null) {
            String sql = "SELECt * FROM dbo.[Account] WHERE RoleID = ? ";
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setString(1, statusId);
            ResultSet rs = pst.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    UserVM userVM = new UserVM();
                    userVM.setAccID(rs.getString("AccID"));
                    userVM.setRoleID(rs.getString("RoleID"));
                    userVM.setFullName(rs.getString("FullName"));
                    userVM.setEmail(rs.getString("Email"));
                    userVM.setPhone(rs.getString("Phone"));
                    userVM.setcCCD(rs.getString("CCCD"));
                    userVM.setAddress(rs.getString("Address"));
                    userVM.setPlaceOfReg(rs.getString("PlaceOfReg"));
                    userVM.setDateOfReg(rs.getString("DateOfReg"));
                    userVM.setBankName(rs.getString("BankName"));
                    userVM.setBankName(rs.getString("BankCode"));
                    userVM.setStatus(rs.getBoolean("Status"));
                    listMemebers.add(userVM);
                }
            }
            cn.close();
        }
        return listMemebers;
    }

    public List<UserVM> getListMemberWallet(int offset) throws ClassNotFoundException, SQLException, NamingException {
        ArrayList<UserVM> listMemebers = new ArrayList<>();
        String statusId = "M";
        Connection cn = null;
        try {
            cn = DBUtils.getConnection();
            if (cn != null) {
                String sql = "SELECT * FROM dbo.[Account] acc JOIN dbo.[Wallet] w ON acc.AccID = w.AccID WHERE RoleID = ? "
                        + "order by acc.DateOfReg desc offset ? row fetch next 5 rows only";
                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setString(1, statusId);
                pst.setInt(2, (offset - 1) * 5);
                ResultSet rs = pst.executeQuery();
                if (rs != null) {
                    while (rs.next()) {
                        UserVM userVM = new UserVM();
                        userVM.setAccID(rs.getString("AccID"));
                        userVM.setRoleID(rs.getString("RoleID"));
                        userVM.setFullName(rs.getString("FullName"));
                        userVM.setEmail(rs.getString("Email"));
                        userVM.setPhone(rs.getString("Phone"));
                        userVM.setcCCD(rs.getString("CCCD"));
                        userVM.setAddress(rs.getString("Address"));
                        userVM.setPlaceOfReg(rs.getString("PlaceOfReg"));
                        userVM.setDateOfReg(rs.getString("DateOfReg"));
                        userVM.setBankName(rs.getString("BankName"));
                        userVM.setBankName(rs.getString("BankCode"));
                        userVM.setStatus(rs.getBoolean("Status"));
                        userVM.setAccountBalance(rs.getLong("AccountBalance"));
                        listMemebers.add(userVM);
                        System.out.println("Result " + userVM.toString());
                    }
                }
            }
            return listMemebers;
        } catch (Exception e) {
            System.out.println("getListMemberWallet " + e.getMessage());
        } finally {
            cn.close();
        }
        return null;
    }

    public int editUserWallet(String accId, double fund, double currentFund, String editAction) throws ClassNotFoundException, SQLException, NamingException {
        Connection cn = null;
        try {
            double newAccountBalance = 0;
            cn = DBUtils.getConnection();
            if (editAction.contains("add")) {
                newAccountBalance = fund + currentFund;
            } else {
                newAccountBalance = currentFund - fund;
                if (newAccountBalance < 0) {
                    return 3;
                }
            }
            if (cn != null) {
                String sql = "UPDATE dbo.[Wallet] SET AccountBalance = ? WHERE AccID = ? ";
                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setDouble(1, newAccountBalance);
                pst.setString(2, accId);
                int affectedRow = pst.executeUpdate();
                if (affectedRow > 0 && !(editAction.contains("add"))) {
                    LocalDateTime localDateTime = LocalDateTime.now();
                    int WalletId = getUserWalletId(accId);
                    System.out.println("Wallet Id" + WalletId);
                    // Convert LocalDateTime to java.sql.Date

                    // Convert LocalDateTime to java.sql.Date
                    java.util.Date date = new java.util.Date();

                    sql = "INSERT INTO dbo.[WalletTransactionHistory] (WalletID, Quantity, DateAndTime, Action) VALUES (?, ?, ?, ?)";
                    String actionEdit = "Admin refund from you " + fund;
                    pst = cn.prepareStatement(sql);
                    pst.setDouble(1, WalletId);
                    // Tien gia ban dau cua cai auction + 5%.
                    pst.setDouble(2, fund);
                    pst.setTimestamp(3, new java.sql.Timestamp(date.getTime()));
                    pst.setString(4, actionEdit);
                    affectedRow = pst.executeUpdate();
                    if (affectedRow > 0) {
                        return 1;
                    }
                } else if (affectedRow > 0) {
                    return 1;
                } else {
                    System.out.println("editUserWallet affected row = 0");
                    return 0;
                }
            }
        } catch (Exception e) {
            System.out.println("getListMemberWallet " + e.getMessage());
        } finally {
            cn.close();
        }
        return 0;

    }

    public int getUserWalletId(String accId) throws SQLException {
        Connection cn = null;
        try {
            cn = DBUtils.getConnection();
            if (cn != null) {
                String sql = "SELECT * FROM dbo.[Wallet] WHERE AccID = ? ";
                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setString(1, accId);
                ResultSet rs = pst.executeQuery();
                if (rs.next()) {
                    return rs.getInt("WalletId");
                }
            }
        } catch (Exception e) {
            System.out.println("getListMemberWallet " + e.getMessage());
        } finally {
            cn.close();
        }
        return 0;
    }

}
