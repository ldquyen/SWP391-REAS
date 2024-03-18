package dto;

import java.util.Date;

public class AccountLoginDate {
    private int loginDateId;
    private String accID;
    private Date loginDate;

    public AccountLoginDate() {
    }

    public AccountLoginDate(int loginDateId, String accID, Date loginDate) {
        this.loginDateId = loginDateId;
        this.accID = accID;
        this.loginDate = loginDate;
    }

    public int getLoginDateId() {
        return loginDateId;
    }

    public void setLoginDateId(int loginDateId) {
        this.loginDateId = loginDateId;
    }

    public String getAccID() {
        return accID;
    }

    public void setAccID(String accID) {
        this.accID = accID;
    }

    public Date getLoginDate() {
        return loginDate;
    }

    public void setLoginDate(Date loginDate) {
        this.loginDate = loginDate;
    }
}
