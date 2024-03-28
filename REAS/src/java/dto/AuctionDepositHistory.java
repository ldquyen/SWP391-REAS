
package dto;

import java.sql.Date;
import java.time.LocalDateTime;

public class AuctionDepositHistory {
    private String auctionDepositHisID;
    private String walletID;
    private String auctionID;
    private LocalDateTime dateAndTime;
    private int quantity;

    public AuctionDepositHistory() {
    }

    public AuctionDepositHistory(String auctionDepositHisID, String walletID, String auctionID, LocalDateTime dateAndTime, int quantity) {
        this.auctionDepositHisID = auctionDepositHisID;
        this.walletID = walletID;
        this.auctionID = auctionID;
        this.dateAndTime = dateAndTime;
        this.quantity = quantity;
    }

    public String getAuctionDepositHisID() {
        return auctionDepositHisID;
    }

    public void setAuctionDepositHisID(String auctionDepositHisID) {
        this.auctionDepositHisID = auctionDepositHisID;
    }

    public String getWalletID() {
        return walletID;
    }

    public void setWalletID(String walletID) {
        this.walletID = walletID;
    }

    public String getAuctionID() {
        return auctionID;
    }

    public void setAuctionID(String auctionID) {
        this.auctionID = auctionID;
    }

    public LocalDateTime getDateAndTime() {
        return dateAndTime;
    }

    public void setDateAndTime(LocalDateTime dateAndTime) {
        this.dateAndTime = dateAndTime;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "AuctionDepositHistory{" + "auctionDepositHisID=" + auctionDepositHisID + ", walletID=" + walletID + ", auctionID=" + auctionID + ", dateAndTime=" + dateAndTime + ", quantity=" + quantity + '}';
    }

    
}
