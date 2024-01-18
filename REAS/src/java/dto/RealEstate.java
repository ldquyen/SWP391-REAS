
package dto;

import java.time.LocalTime;

public class RealEstate {
    private String realEstateID;
    private String accID;
    private String catID;
    private String realEstateName;
    private float priceNow;
    private float pricePay;
    private LocalTime timeUp;
    private LocalTime timeDown;
    private float cost;
    private int status;
    private String detail;
    private String city;

    public RealEstate() {
    }

    public RealEstate(String realEstateID, String accID, String catID, String realEstateName, float priceNow, float pricePay, LocalTime timeUp, LocalTime timeDown, float cost, int status, String detail, String city) {
        this.realEstateID = realEstateID;
        this.accID = accID;
        this.catID = catID;
        this.realEstateName = realEstateName;
        this.priceNow = priceNow;
        this.pricePay = pricePay;
        this.timeUp = timeUp;
        this.timeDown = timeDown;
        this.cost = cost;
        this.status = status;
        this.detail = detail;
        this.city = city;
    }

    public String getRealEstateID() {
        return realEstateID;
    }

    public void setRealEstateID(String realEstateID) {
        this.realEstateID = realEstateID;
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

    public float getPricePay() {
        return pricePay;
    }

    public void setPricePay(float pricePay) {
        this.pricePay = pricePay;
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

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "RealEstate{" + "realEstateID=" + realEstateID + ", accID=" + accID + ", catID=" + catID + ", realEstateName=" + realEstateName + ", priceNow=" + priceNow + ", pricePay=" + pricePay + ", timeUp=" + timeUp + ", timeDown=" + timeDown + ", cost=" + cost + ", status=" + status + ", detail=" + detail + ", city=" + city + '}';
    }
}
