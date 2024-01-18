
package dto;

import java.sql.Date;

public class Auction {
    private String auctionID;
    private String realEstateID;
    private String auctionName;
    private float priceNow;
    private float lamda;
    private Date timeStart;
    private Date timeEnd;

    public Auction() {
    }

    public Auction(String auctionID, String realEstateID, String auctionName, float priceNow, float lamda, Date timeStart, Date timeEnd) {
        this.auctionID = auctionID;
        this.realEstateID = realEstateID;
        this.auctionName = auctionName;
        this.priceNow = priceNow;
        this.lamda = lamda;
        this.timeStart = timeStart;
        this.timeEnd = timeEnd;
    }

    public String getAuctionID() {
        return auctionID;
    }

    public void setAuctionID(String auctionID) {
        this.auctionID = auctionID;
    }

    public String getRealEstateID() {
        return realEstateID;
    }

    public void setRealEstateID(String realEstateID) {
        this.realEstateID = realEstateID;
    }

    public String getAuctionName() {
        return auctionName;
    }

    public void setAuctionName(String auctionName) {
        this.auctionName = auctionName;
    }

    public float getPriceNow() {
        return priceNow;
    }

    public void setPriceNow(float priceNow) {
        this.priceNow = priceNow;
    }

    public float getLamda() {
        return lamda;
    }

    public void setLamda(float lamda) {
        this.lamda = lamda;
    }

    public Date getTimeStart() {
        return timeStart;
    }

    public void setTimeStart(Date timeStart) {
        this.timeStart = timeStart;
    }

    public Date getTimeEnd() {
        return timeEnd;
    }

    public void setTimeEnd(Date timeEnd) {
        this.timeEnd = timeEnd;
    }

    @Override
    public String toString() {
        return "Auction{" + "auctionID=" + auctionID + ", realEstateID=" + realEstateID + ", auctionName=" + auctionName + ", priceNow=" + priceNow + ", lamda=" + lamda + ", timeStart=" + timeStart + ", timeEnd=" + timeEnd + '}';
    }
}
