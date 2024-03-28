/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dto.Rule;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import mylib.DBUtils;

/**
 *
 * @author TRUONG SON
 */
public class RuleDAO {

    public List<Rule> getRule(int sectionId) throws ClassNotFoundException, SQLException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        List<Rule> result = null;

        try {
            con = DBUtils.getConnection();
            if (con != null) {
                String sql = "select [ruleDetail]\n"
                        + "from [dbo].[Rule]\n"
                        + "where [sectionID] = ?";
                stm = con.prepareStatement(sql);
                stm.setInt(1, sectionId);
                rs = stm.executeQuery();
                while (rs.next()) {
                    if (result == null) {
                        result = new ArrayList<Rule>();
                    }
                    Rule dto = new Rule();
                    dto.setRuleDetail(rs.getString("ruleDetail"));
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

    public static boolean checkRule(int ruleID) throws Exception {
        Connection cn = DBUtils.getConnection();
        if (cn != null) {
            String sql = "select [ruleDetail]\n"
                    + "from [dbo].[Rule]\n"
                    + "where [ruleID] = ?";
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setInt(1, ruleID);
            ResultSet rs = pst.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    String ruleDetail = rs.getString("ruleDetail");
                    if (ruleDetail != null) {
                        return true;
                    } else {
                        return false;
                    }
                }
            }
        }
        return false;
    }

    public static boolean insertRule(int ruleid, String ruledetail, String accid, int sectionid) {
        Connection cn = null;
        PreparedStatement pst = null;
        LocalDate currentTime = LocalDate.now();
        Date date = Date.valueOf(currentTime);
        try {
            cn = DBUtils.getConnection();
            if (cn != null) {
                String sql = "insert into [dbo].[Rule] ([ruleID],[ruleDetail],[AccID],[sectionID],[modifyTime])\n"
                        + "values (?, ?, ?, ?, ?)";
                pst = cn.prepareStatement(sql);
                pst.setInt(1, ruleid);
                pst.setString(2, ruledetail);
                pst.setString(3, accid);
                pst.setInt(4, sectionid);
                pst.setDate(5, date);
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
    public static void main(String[] args) {
               boolean b1 = insertRule(48,"Day la luat 1", "A1", 1);
    }
}
