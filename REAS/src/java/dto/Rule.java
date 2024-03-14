package dto;

import java.util.Date;

public class Rule {
    private int ruleID;
    private String ruleDetail;
    private String accID;
    private Integer sectionID;
    private Date modifyTime;

    public Rule() {
    }

    public Rule(int ruleID, String ruleDetail, String accID, Integer sectionID, Date modifyTime) {
        this.ruleID = ruleID;
        this.ruleDetail = ruleDetail;
        this.accID = accID;
        this.sectionID = sectionID;
        this.modifyTime = modifyTime;
    }

    public int getRuleID() {
        return ruleID;
    }

    public void setRuleID(int ruleID) {
        this.ruleID = ruleID;
    }

    public String getRuleDetail() {
        return ruleDetail;
    }

    public void setRuleDetail(String ruleDetail) {
        this.ruleDetail = ruleDetail;
    }

    public String getAccID() {
        return accID;
    }

    public void setAccID(String accID) {
        this.accID = accID;
    }

    public Integer getSectionID() {
        return sectionID;
    }

    public void setSectionID(Integer sectionID) {
        this.sectionID = sectionID;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }
}
