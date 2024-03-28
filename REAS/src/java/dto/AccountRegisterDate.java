package dto;

import java.util.Date;

public class AccountRegisterDate {
    private int registerDateId;
    private String accID;
    private Date registerDate;

    public AccountRegisterDate() {
    }

    public AccountRegisterDate(int registerDateId, String accID, Date registerDate) {
        this.registerDateId = registerDateId;
        this.accID = accID;
        this.registerDate = registerDate;
    }

    public int getRegisterDateId() {
        return registerDateId;
    }

    public void setRegisterDateId(int registerDateId) {
        this.registerDateId = registerDateId;
    }

    public String getAccID() {
        return accID;
    }

    public void setAccID(String accID) {
        this.accID = accID;
    }

    public Date getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(Date registerDate) {
        this.registerDate = registerDate;
    }
}
