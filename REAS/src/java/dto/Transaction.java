
package dto;

import java.sql.Date;

public class Transaction {
    private String transID;
    private String auctionHisID;
    private float quantity;
    private Date timePay;

    public Transaction() {
    }

    public Transaction(String transID, String auctionHisID, float quantity, Date timePay) {
        this.transID = transID;
        this.auctionHisID = auctionHisID;
        this.quantity = quantity;
        this.timePay = timePay;
    }

    public String getTransID() {
        return transID;
    }

    public void setTransID(String transID) {
        this.transID = transID;
    }

    public String getAuctionHisID() {
        return auctionHisID;
    }

    public void setAuctionHisID(String auctionHisID) {
        this.auctionHisID = auctionHisID;
    }

    public float getQuantity() {
        return quantity;
    }

    public void setQuantity(float quantity) {
        this.quantity = quantity;
    }

    public Date getTimePay() {
        return timePay;
    }

    public void setTimePay(Date timePay) {
        this.timePay = timePay;
    }

    @Override
    public String toString() {
        return "Transaction{" + "transID=" + transID + ", auctionHisID=" + auctionHisID + ", quantity=" + quantity + ", timePay=" + timePay + '}';
    }
}
