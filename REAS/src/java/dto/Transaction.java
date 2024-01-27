
package dto;

import java.sql.Date;
import java.time.LocalDateTime;

public class Transaction {
    private String transID;
    private String auctionHisID;
    private long quantity;
    private LocalDateTime timePay;

    public Transaction() {
    }

    public Transaction(String transID, String auctionHisID, long quantity, LocalDateTime timePay) {
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

    public long getQuantity() {
        return quantity;
    }

    public void setQuantity(long quantity) {
        this.quantity = quantity;
    }

    public LocalDateTime getTimePay() {
        return timePay;
    }

    public void setTimePay(LocalDateTime timePay) {
        this.timePay = timePay;
    }

    @Override
    public String toString() {
        return "Transaction{" + "transID=" + transID + ", auctionHisID=" + auctionHisID + ", quantity=" + quantity + ", timePay=" + timePay + '}';
    }
}
