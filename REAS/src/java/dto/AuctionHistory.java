
package dto;

import java.sql.Date;
import java.time.LocalDateTime;

public class AuctionHistory {
    private String auctionHisID;
    private String auctionID;
    private int status;
    private long lamda;
    private LocalDateTime timeJoin;
    private LocalDateTime timeOut;
    private int numberOfBids;
    private long startPrice;

    public AuctionHistory() {
    }

    public AuctionHistory(String auctionHisID, String auctionID, int status, long lamda, LocalDateTime timeJoin, LocalDateTime timeOut, int numberOfBids, long startPrice) {
        this.auctionHisID = auctionHisID;
        this.auctionID = auctionID;
        this.status = status;
        this.lamda = lamda;
        this.timeJoin = timeJoin;
        this.timeOut = timeOut;
        this.numberOfBids = numberOfBids;
        this.startPrice = startPrice;
    }

    public String getAuctionHisID() {
        return auctionHisID;
    }

    public void setAuctionHisID(String auctionHisID) {
        this.auctionHisID = auctionHisID;
    }

    public String getAuctionID() {
        return auctionID;
    }

    public void setAuctionID(String auctionID) {
        this.auctionID = auctionID;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public long getLamda() {
        return lamda;
    }

    public void setLamda(long lamda) {
        this.lamda = lamda;
    }

    public LocalDateTime getTimeJoin() {
        return timeJoin;
    }

    public void setTimeJoin(LocalDateTime timeJoin) {
        this.timeJoin = timeJoin;
    }

    public LocalDateTime getTimeOut() {
        return timeOut;
    }

    public void setTimeOut(LocalDateTime timeOut) {
        this.timeOut = timeOut;
    }

    public int getNumberOfBids() {
        return numberOfBids;
    }

    public void setNumberOfBids(int numberOfBids) {
        this.numberOfBids = numberOfBids;
    }

    public long getStartPrice() {
        return startPrice;
    }

    public void setStartPrice(long startPrice) {
        this.startPrice = startPrice;
    }

    @Override
    public String toString() {
        return "AuctionHistory{" + "auctionHisID=" + auctionHisID + ", auctionID=" + auctionID + ", status=" + status + ", lamda=" + lamda + ", timeJoin=" + timeJoin + ", timeOut=" + timeOut + ", numberOfBids=" + numberOfBids + ", startPrice=" + startPrice + '}';
    }
}
