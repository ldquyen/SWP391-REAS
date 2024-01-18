
package dto;

import java.sql.Date;

public class WalletTransactionHistory {
    private String walletTransID;
    private String walletID;
    private int quantity;
    private Date dateAndTime;
    private String action;

    public WalletTransactionHistory() {
    }

    public WalletTransactionHistory(String walletTransID, String walletID, int quantity, Date dateAndTime, String action) {
        this.walletTransID = walletTransID;
        this.walletID = walletID;
        this.quantity = quantity;
        this.dateAndTime = dateAndTime;
        this.action = action;
    }

    public String getWalletTransID() {
        return walletTransID;
    }

    public void setWalletTransID(String walletTransID) {
        this.walletTransID = walletTransID;
    }

    public String getWalletID() {
        return walletID;
    }

    public void setWalletID(String walletID) {
        this.walletID = walletID;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Date getDateAndTime() {
        return dateAndTime;
    }

    public void setDateAndTime(Date dateAndTime) {
        this.dateAndTime = dateAndTime;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    @Override
    public String toString() {
        return "WalletTransactionHistory{" + "walletTransID=" + walletTransID + ", walletID=" + walletID + ", quantity=" + quantity + ", dateAndTime=" + dateAndTime + ", action=" + action + '}';
    }
}
