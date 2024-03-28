
package dto;

import java.sql.Date;
import java.time.LocalDateTime;

public class Auction {
    private String auctionID;
    private String realEstateID;
    private String auctionName;
    private long priceNow;
    private long lamda;
    private LocalDateTime timeStart;
    private LocalDateTime timeEnd;
    private String accID;

    public Auction() {
    }

    public Auction(String auctionID, String realEstateID, String auctionName, long priceNow, long lamda, LocalDateTime timeStart, LocalDateTime timeEnd, String accID) {
        this.auctionID = auctionID;
        this.realEstateID = realEstateID;
        this.auctionName = auctionName;
        this.priceNow = priceNow;
        this.lamda = lamda;
        this.timeStart = timeStart;
        this.timeEnd = timeEnd;
        this.accID = accID;
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

    public long getPriceNow() {
        return priceNow;
    }

    public void setPriceNow(long priceNow) {
        this.priceNow = priceNow;
    }

    public long getLamda() {
        return lamda;
    }

    public void setLamda(long lamda) {
        this.lamda = lamda;
    }

    public LocalDateTime getTimeStart() {
        return timeStart;
    }

    public void setTimeStart(LocalDateTime timeStart) {
        this.timeStart = timeStart;
    }

    public LocalDateTime getTimeEnd() {
        return timeEnd;
    }

    public void setTimeEnd(LocalDateTime timeEnd) {
        this.timeEnd = timeEnd;
    }

    public String getAccID() {
        return accID;
    }

    public void setAccID(String accID) {
        this.accID = accID;
    }

   

    @Override
    public String toString() {
        return "Auction{" + "auctionID=" + auctionID + ", realEstateID=" + realEstateID + ", auctionName=" + auctionName + ", priceNow=" + priceNow + ", lamda=" + lamda + ", timeStart=" + timeStart + ", timeEnd=" + timeEnd + '}';
    }
}
