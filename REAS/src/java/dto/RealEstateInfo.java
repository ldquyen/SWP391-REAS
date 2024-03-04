package dto;

import java.io.Serializable;
import java.time.LocalDateTime;

public class RealEstateInfo implements Serializable{
    private String realEstateID;
    private String realEstateName;
    private String userName;
    private String address;
    private String catName;
    private long priceFirst;
    private long pricePaid;
    private long lamda;
    private LocalDateTime timeStart;
    private LocalDateTime timeEnd;
    private int area;
    private String imageFolderID;
    private String detail;
    private LocalDateTime timeUp;
    private String statusName;
    private int statusID;
    private String auctionID;
//    private String catID;
//    private int cityID;
//    private LocalDateTime timeDown;
//    private long priceLast;
// 
//    private String auctionID;
//    private String auctionName;
//    private long priceNow;
//    private String cityName;

    public RealEstateInfo() {
    }

    public RealEstateInfo(String realEstateID, String realEstateName, String userName, String address, String catName, long priceFirst, long pricePaid, long lamda, LocalDateTime timeStart, LocalDateTime timeEnd, int area, String imageFolderID, String detail, LocalDateTime timeUp, String statusName, int statusID, String auctionID) {
        this.realEstateID = realEstateID;
        this.realEstateName = realEstateName;
        this.userName = userName;
        this.address = address;
        this.catName = catName;
        this.priceFirst = priceFirst;
        this.pricePaid = pricePaid;
        this.lamda = lamda;
        this.timeStart = timeStart;
        this.timeEnd = timeEnd;
        this.area = area;
        this.imageFolderID = imageFolderID;
        this.detail = detail;
        this.timeUp = timeUp;
        this.statusName = statusName;
        this.statusID = statusID;
        this.auctionID = auctionID;
    }

    public String getRealEstateID() {
        return realEstateID;
    }

    public void setRealEstateID(String realEstateID) {
        this.realEstateID = realEstateID;
    }

    public String getRealEstateName() {
        return realEstateName;
    }

    public void setRealEstateName(String realEstateName) {
        this.realEstateName = realEstateName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCatName() {
        return catName;
    }

    public void setCatName(String catName) {
        this.catName = catName;
    }

    public long getPriceFirst() {
        return priceFirst;
    }

    public void setPriceFirst(long priceFirst) {
        this.priceFirst = priceFirst;
    }

    public long getPricePaid() {
        return pricePaid;
    }

    public void setPricePaid(long pricePaid) {
        this.pricePaid = pricePaid;
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

    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }

    public String getImageFolderID() {
        return imageFolderID;
    }

    public void setImageFolderID(String imageFolderID) {
        this.imageFolderID = imageFolderID;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public LocalDateTime getTimeUp() {
        return timeUp;
    }

    public void setTimeUp(LocalDateTime timeUp) {
        this.timeUp = timeUp;
    }

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }

    public int getStatusID() {
        return statusID;
    }

    public void setStatusID(int statusID) {
        this.statusID = statusID;
    }

    public String getAuctionID() {
        return auctionID;
    }

    public void setAuctionID(String auctionID) {
        this.auctionID = auctionID;
    }



}