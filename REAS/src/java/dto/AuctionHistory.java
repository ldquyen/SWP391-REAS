
package dto;

import java.sql.Date;
import java.time.LocalDateTime;

public class AuctionHistory {
    private int auctionHisID;
    private String auctionID;
    private long lamda;
    private LocalDateTime TimeDate;
    private long Price;

    public AuctionHistory() {
    }

    public AuctionHistory(int auctionHisID, String auctionID, long lamda, LocalDateTime TimeDate, long Price) {
        this.auctionHisID = auctionHisID;
        this.auctionID = auctionID;
        this.lamda = lamda;
        this.TimeDate = TimeDate;
        this.Price = Price;
    }

    public AuctionHistory(String auctionHisID, String auctionID, int status, long lamda, LocalDateTime timeJoin, LocalDateTime timeOut, int numberOfBids, long startPrice) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void setAuctionHisID(int auctionHisID) {
        this.auctionHisID = auctionHisID;
    }

    public void setAuctionID(String auctionID) {
        this.auctionID = auctionID;
    }

    public void setLamda(long lamda) {
        this.lamda = lamda;
    }

    public void setTimeDate(LocalDateTime TimeDate) {
        this.TimeDate = TimeDate;
    }

    public void setPrice(long Price) {
        this.Price = Price;
    }

    public int getAuctionHisID() {
        return auctionHisID;
    }

    public String getAuctionID() {
        return auctionID;
    }

    public long getLamda() {
        return lamda;
    }

    public LocalDateTime getTimeDate() {
        return TimeDate;
    }

    public long getPrice() {
        return Price;
    }
    
}

   