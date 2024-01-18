
package dto;

import java.sql.Date;

public class AuctionDepositHistory {
    private String auctionDepositHisID;
    private String walletID;
    private String auctionID;
    private Date dateAndTime;
    private float quantity;

    public AuctionDepositHistory() {
    }

    public AuctionDepositHistory(String auctionDepositHisID, String walletID, String auctionID, Date dateAndTime, float quantity) {
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

    public Date getDateAndTime() {
        return dateAndTime;
    }

    public void setDateAndTime(Date dateAndTime) {
        this.dateAndTime = dateAndTime;
    }

    public float getQuantity() {
        return quantity;
    }

    public void setQuantity(float quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "AuctionDepositHistory{" + "auctionDepositHisID=" + auctionDepositHisID + ", walletID=" + walletID + ", auctionID=" + auctionID + ", dateAndTime=" + dateAndTime + ", quantity=" + quantity + '}';
    }
}
