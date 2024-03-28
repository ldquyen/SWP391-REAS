/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 *
 * @author ADMIN
 */
public class PurchaseRequest implements Serializable{
    private String realEstateID;
    private String accID;
    private long pricePaid;
    private LocalDateTime timeRequest;
    private int requestStatusID;
    private String requestStatusName;
    
    public PurchaseRequest() {
    }

    public PurchaseRequest(String realEstateID, String accID, long pricePaid, LocalDateTime timeRequest, int requestStatusID, String requestStatusName) {
        this.realEstateID = realEstateID;
        this.accID = accID;
        this.pricePaid = pricePaid;
        this.timeRequest = timeRequest;
        this.requestStatusID = requestStatusID;
        this.requestStatusName = requestStatusName;
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

    public long getPricePaid() {
        return pricePaid;
    }

    public void setPricePaid(long pricePaid) {
        this.pricePaid = pricePaid;
    }

    public LocalDateTime getTimeRequest() {
        return timeRequest;
    }

    public void setTimeRequest(LocalDateTime timeRequest) {
        this.timeRequest = timeRequest;
    }

    public int getRequestStatusID() {
        return requestStatusID;
    }

    public void setRequestStatusID(int requestStatusID) {
        this.requestStatusID = requestStatusID;
    }

    public String getRequestStatusName() {
        return requestStatusName;
    }

    public void setRequestStatusName(String requestStatusName) {
        this.requestStatusName = requestStatusName;
    }

    
   
    
    
}
