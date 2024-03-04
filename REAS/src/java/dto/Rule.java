/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import java.sql.Date;

/**
 *
 * @author TRUONG SON
 */
public class Rule {
     private int ruleID;
    private String ruleDetail;
    private String accID;
    private Date modifyTime;

    public Rule() {
    }

    public Rule(int ruleID, String ruleDetail, String accID, Date modifyTime) {
        this.ruleID = ruleID;
        this.ruleDetail = ruleDetail;
        this.accID = accID;
        this.modifyTime = modifyTime;
    }

    public int getRuleID() {
        return ruleID;
    }

    public String getRuleDetail() {
        return ruleDetail;
    }

    public String getAccID() {
        return accID;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setRuleID(int ruleID) {
        this.ruleID = ruleID;
    }

    public void setRuleDetail(String ruleDetail) {
        this.ruleDetail = ruleDetail;
    }

    public void setAccID(String accID) {
        this.accID = accID;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }
    
}
