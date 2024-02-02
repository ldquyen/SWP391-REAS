package dto;

import java.io.Serializable;
import java.time.LocalDateTime;

public class RealEstate implements Serializable {

    private String realEstateID;
    private String imageFolderID;
    private String accID;
    private String catID;
    private int cityID;
    private String realEstateName;
    private long priceFirst;
    private LocalDateTime timeUp;
    private LocalDateTime timeDown;
    private long priceLast;
    private long pricePaid;
    private int statusID;
    private int area;
    private String address;
    private String detail;

    public RealEstate() {
    }

    public RealEstate(String realEstateID, String imageFolderID, String accID, String catID, int cityID, String realEstateName, long priceFirst, LocalDateTime timeUp, LocalDateTime timeDown, long priceLast, long pricePaid, int statusID, int area, String address, String detail) {
        this.realEstateID = realEstateID;
        this.imageFolderID = imageFolderID;
        this.accID = accID;
        this.catID = catID;
        this.cityID = cityID;
        this.realEstateName = realEstateName;
        this.priceFirst = priceFirst;
        this.timeUp = timeUp;
        this.timeDown = timeDown;
        this.priceLast = priceLast;
        this.pricePaid = pricePaid;
        this.statusID = statusID;
        this.area = area;
        this.address = address;
        this.detail = detail;
    }

    public String getRealEstateID() {
        return realEstateID;
    }

    public void setRealEstateID(String realEstateID) {
        this.realEstateID = realEstateID;
    }

    public String getImageFolderID() {
        return imageFolderID;
    }

    public void setImageFolderID(String imageFolderID) {
        this.imageFolderID = imageFolderID;
    }

    public String getAccID() {
        return accID;
    }

    public void setAccID(String accID) {
        this.accID = accID;
    }

    public String getCatID() {
        return catID;
    }

    public void setCatID(String catID) {
        this.catID = catID;
    }

    public int getCityID() {
        return cityID;
    }

    public void setCityID(int cityID) {
        this.cityID = cityID;
    }

    public String getRealEstateName() {
        return realEstateName;
    }

    public void setRealEstateName(String realEstateName) {
        this.realEstateName = realEstateName;
    }

    public long getPriceFirst() {
        return priceFirst;
    }

    public void setPriceFirst(long priceFirst) {
        this.priceFirst = priceFirst;
    }

    public LocalDateTime getTimeUp() {
        return timeUp;
    }

    public void setTimeUp(LocalDateTime timeUp) {
        this.timeUp = timeUp;
    }

    public LocalDateTime getTimeDown() {
        return timeDown;
    }

    public void setTimeDown(LocalDateTime timeDown) {
        this.timeDown = timeDown;
    }

    public long getPriceLast() {
        return priceLast;
    }

    public void setPriceLast(long priceLast) {
        this.priceLast = priceLast;
    }

    public long getPricePaid() {
        return pricePaid;
    }

    public void setPricePaid(long pricePaid) {
        this.pricePaid = pricePaid;
    }

    public int getStatusID() {
        return statusID;
    }

    public void setStatusID(int statusID) {
        this.statusID = statusID;
    }

    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    @Override
    public String toString() {
        return "RealEstate{" + "realEstateID=" + realEstateID + ", imageFolderID=" + imageFolderID + ", accID=" + accID + ", catID=" + catID + ", cityID=" + cityID + ", realEstateName=" + realEstateName + ", priceFirst=" + priceFirst + ", timeUp=" + timeUp + ", timeDown=" + timeDown + ", priceLast=" + priceLast + ", pricePaid=" + pricePaid + ", statusID=" + statusID + ", area=" + area + ", address=" + address + ", detail=" + detail + '}';
    }
}
