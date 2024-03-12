/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dto.RealEstateInfo;
import dto.Rule;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import javax.naming.NamingException;
import mylib.DBUtils;

/**
 *
 * @author TRUONG SON
 */
public class RuleDAO {

    public List<Rule> getRule() throws ClassNotFoundException, SQLException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        List<Rule> result = null;

        try {
            con = DBUtils.getConnection();
            if (con != null) {
                String sql = "select [ruleID],[ruleDetail],[AccID],[modifyTime]\n"
                        + "from [dbo].[Rule]";
                stm = con.prepareStatement(sql);
                rs = stm.executeQuery();
                while (rs.next()) {
                    if (result == null) {
                        result = new ArrayList<Rule>();
                    }
                    Rule dto = new Rule();
                    dto.setRuleID(rs.getInt("ruleID"));
                    dto.setRuleDetail(rs.getString("ruleDetail"));
                    dto.setAccID(rs.getString("AccID"));
                    dto.setModifyTime(rs.getDate("modifyTime"));
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
}
