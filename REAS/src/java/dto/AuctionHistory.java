
package dto;

import java.sql.Date;

public class AuctionHistory {
    private String auctionHisID;
    private String auctionID;
    private int status;
    private float lamda;
    private Date timeJoin;
    private Date timeOut;
    private int numberOfBids;
    private float startPrice;

    public AuctionHistory() {
    }

    public AuctionHistory(String auctionHisID, String auctionID, int status, float lamda, Date timeJoin, Date timeOut, int numberOfBids, float startPrice) {
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

    public float getLamda() {
        return lamda;
    }

    public void setLamda(float lamda) {
        this.lamda = lamda;
    }

    public Date getTimeJoin() {
        return timeJoin;
    }

    public void setTimeJoin(Date timeJoin) {
        this.timeJoin = timeJoin;
    }

    public Date getTimeOut() {
        return timeOut;
    }

    public void setTimeOut(Date timeOut) {
        this.timeOut = timeOut;
    }

    public int getNumberOfBids() {
        return numberOfBids;
    }

    public void setNumberOfBids(int numberOfBids) {
        this.numberOfBids = numberOfBids;
    }

    public float getStartPrice() {
        return startPrice;
    }

    public void setStartPrice(float startPrice) {
        this.startPrice = startPrice;
    }

    @Override
    public String toString() {
        return "AuctionHistory{" + "auctionHisID=" + auctionHisID + ", auctionID=" + auctionID + ", status=" + status + ", lamda=" + lamda + ", timeJoin=" + timeJoin + ", timeOut=" + timeOut + ", numberOfBids=" + numberOfBids + ", startPrice=" + startPrice + '}';
    }
}
