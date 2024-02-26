/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.time.LocalDateTime;
import java.util.Base64;

/**
 *
 * @author Admin
 */
public class RealEstateVM {

    private String realEstateID;
    private String imageFolderID;
    private String accID;
    private String catID;
    private String category;
    private int cityID;
    public String city;
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
    private byte[] imageLink1;
    private byte[] imageLink2;
    private byte[] imageLink3;


    public RealEstateVM() {
    }

    public RealEstateVM(String realEstateID, String imageFolderID, String accID, String catID, String category, int cityID, String city, String realEstateName, long priceFirst, LocalDateTime timeUp, LocalDateTime timeDown, long priceLast, long pricePaid, int statusID, int area, String address, String detail, byte[] imageLink1, byte[] imageLink2, byte[] imageLink3) {
        this.realEstateID = realEstateID;
        this.imageFolderID = imageFolderID;
        this.accID = accID;
        this.catID = catID;
        this.category = category;
        this.cityID = cityID;
        this.city = city;
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
        this.imageLink1 = imageLink1;
        this.imageLink2 = imageLink2;
        this.imageLink3 = imageLink3;
    }
    

    public String getBase64Image1() {
        return Base64.getEncoder().encodeToString(imageLink1);
    }
    
    public String getBase64Image2() {
        return Base64.getEncoder().encodeToString(imageLink2);
    }
    
    public String getBase64Image3() {
        return Base64.getEncoder().encodeToString(imageLink3);
    }

    public byte[] getImageLink1() {
        return imageLink1;
    }

    public void setImageLink1(byte[] imageLink1) {
        this.imageLink1 = imageLink1;
    }

    public byte[] getImageLink2() {
        return imageLink2;
    }

    public void setImageLink2(byte[] imageLink2) {
        this.imageLink2 = imageLink2;
    }

    public byte[] getImageLink3() {
        return imageLink3;
    }

    public void setImageLink3(byte[] imageLink3) {
        this.imageLink3 = imageLink3;
    }

    



    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getCategory() {
        return category;
    }


    public void setRealEstateID(String realEstateID) {
        this.realEstateID = realEstateID;
    }

    public void setImageFolderID(String imageFolderID) {
        this.imageFolderID = imageFolderID;
    }

    public void setAccID(String accID) {
        this.accID = accID;
    }

    public void setCatID(String catID) {
        this.catID = catID;
    }

    public void setCityID(int cityID) {
        this.cityID = cityID;
    }

    public void setRealEstateName(String realEstateName) {
        this.realEstateName = realEstateName;
    }

    public void setPriceFirst(long priceFirst) {
        this.priceFirst = priceFirst;
    }

    public void setTimeUp(LocalDateTime timeUp) {
        this.timeUp = timeUp;
    }

    public void setTimeDown(LocalDateTime timeDown) {
        this.timeDown = timeDown;
    }

    public void setPriceLast(long priceLast) {
        this.priceLast = priceLast;
    }

    public void setPricePaid(long pricePaid) {
        this.pricePaid = pricePaid;
    }

    public void setStatusID(int statusID) {
        this.statusID = statusID;
    }

    public void setArea(int area) {
        this.area = area;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getRealEstateID() {
        return realEstateID;
    }

    public String getImageFolderID() {
        return imageFolderID;
    }

    public String getAccID() {
        return accID;
    }

    public String getCatID() {
        return catID;
    }

    public int getCityID() {
        return cityID;
    }

    public String getRealEstateName() {
        return realEstateName;
    }

    public long getPriceFirst() {
        return priceFirst;
    }

    public LocalDateTime getTimeUp() {
        return timeUp;
    }

    public LocalDateTime getTimeDown() {
        return timeDown;
    }

    public long getPriceLast() {
        return priceLast;
    }

    public long getPricePaid() {
        return pricePaid;
    }

    public int getStatusID() {
        return statusID;
    }

    public int getArea() {
        return area;
    }

    public String getAddress() {
        return address;
    }

    public String getDetail() {
        return detail;
    }

    @Override
    public String toString() {
        return "RealEstateVM{" + "realEstateID=" + realEstateID + ", imageFolderID=" + imageFolderID + ", accID=" + accID + ", catID=" + catID + ", category=" + category + ", cityID=" + cityID + ", city=" + city + ", realEstateName=" + realEstateName + ", priceFirst=" + priceFirst + ", timeUp=" + timeUp + ", timeDown=" + timeDown + ", priceLast=" + priceLast + ", pricePaid=" + pricePaid + ", statusID=" + statusID + ", area=" + area + ", address=" + address + ", detail=" + detail + ", imageLink1=" + imageLink1 + ", imageLink2=" + imageLink2 + ", imageLink3=" + imageLink3 + '}';
    }
}
