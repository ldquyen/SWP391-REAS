
package dto;

import java.io.Serializable;
import java.time.LocalTime;

public class RealEstate implements Serializable{
    private String realEstateID;
    private String imageFolderID;
    private String accID;
    private String catID;
    private int cityID;
    private String realEstateName;
    private float priceNow;
    private LocalTime timeUp;
    private LocalTime timeDown;
    private float cost;
    private int status;
    private int area;
    private String address;
    private String detail;


    public RealEstate() {
    }

    public RealEstate(String realEstateID, String imageFolderID, String accID, String catID, int cityID, String realEstateName, float priceNow, LocalTime timeUp, LocalTime timeDown, float cost, int status, int area, String address, String detail) {
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
        this.status = status;
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

    public float getPriceNow() {
        return priceNow;
    }

    public void setPriceNow(float priceNow) {
        this.priceNow = priceNow;
    }

    public LocalTime getTimeUp() {
        return timeUp;
    }

    public void setTimeUp(LocalTime timeUp) {
        this.timeUp = timeUp;
    }

    public LocalTime getTimeDown() {
        return timeDown;
    }

    public void setTimeDown(LocalTime timeDown) {
        this.timeDown = timeDown;
    }

    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
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

    @Override
    public String toString() {
        return "RealEstate{" + "realEstateID=" + realEstateID + ", imageFolderID=" + imageFolderID + ", accID=" + accID + ", catID=" + catID + ", cityID=" + cityID + ", realEstateName=" + realEstateName + ", priceNow=" + priceNow + ", timeUp=" + timeUp + ", timeDown=" + timeDown + ", cost=" + cost + ", status=" + status + ", area=" + area + ", address=" + address + ", detail=" + detail + '}';
    }  
}
