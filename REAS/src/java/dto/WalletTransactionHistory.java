
package dto;

import java.sql.Date;
import java.time.LocalDateTime;

public class WalletTransactionHistory {
    private String walletTransID;
    private String walletID;
    private long quantity;
    private LocalDateTime dateAndTime;
    private String action;

    public WalletTransactionHistory() {
    }

    public WalletTransactionHistory(String walletTransID, String walletID, long quantity, LocalDateTime dateAndTime, String action) {
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

    public long getQuantity() {
        return quantity;
    }

    public void setQuantity(long quantity) {
        this.quantity = quantity;
    }

    public LocalDateTime getDateAndTime() {
        return dateAndTime;
    }

    public void setDateAndTime(LocalDateTime dateAndTime) {
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
