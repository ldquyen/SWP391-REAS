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
    private int priceNow;
    private LocalDateTime timeUp;
    private LocalDateTime timeDown;
    private int cost;
    private int status = 0;
    private int area;
    private String address;
    private String detail;
    private Image image;

    @Override
    public String toString() {
        return "RealEstate{" + "realEstateID=" + realEstateID + ", imageFolderID=" + imageFolderID + ", accID=" + accID + ", catID=" + catID + ", cityID=" + cityID + ", realEstateName=" + realEstateName + ", priceNow=" + priceNow + ", timeUp=" + timeUp + ", timeDown=" + timeDown + ", cost=" + cost + ", status=" + status + ", area=" + area + ", address=" + address + ", detail=" + detail + ", image=" + image + '}';
    }


    public RealEstate() {
    }

    public RealEstate(String realEstateID, String imageFolderID, String accID, String catID, int cityID, String realEstateName, int priceNow, LocalDateTime timeUp, LocalDateTime timeDown, int cost, int area, String address, String detail, Image image) {
        this.realEstateID = realEstateID;
        this.imageFolderID = imageFolderID;
        this.accID = accID;
        this.catID = catID;
        this.cityID = cityID;
        this.realEstateName = realEstateName;
        this.priceNow = priceNow;
        this.timeUp = timeUp;
        this.timeDown = timeDown;
        this.cost = cost;
        this.area = area;
        this.address = address;
        this.detail = detail;
        this.image = image;
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

    public int getPriceNow() {
        return priceNow;
    }

    public void setPriceNow(int priceNow) {
        this.priceNow = priceNow;
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

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
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

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    
 

}
