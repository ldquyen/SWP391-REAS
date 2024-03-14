/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import java.time.LocalDateTime;

/**
 *
 * @author ADMIN
 */
public class OrderWallet {
    private String orderID;
    private String walletID;
    private Long price;
    private LocalDateTime date;
    private int statusID;
    private String context;

    public OrderWallet(String orderID, String walletID, Long price, LocalDateTime date, int statusID, String context) {
        this.orderID = orderID;
        this.walletID = walletID;
        this.price = price;
        this.date = date;
        this.statusID = statusID;
        this.context = context;
    }

    public String getOrderID() {
        return orderID;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    public String getWalletID() {
        return walletID;
    }

    public void setWalletID(String walletID) {
        this.walletID = walletID;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public int getStatusID() {
        return statusID;
    }

    public void setStatusID(int statusID) {
        this.statusID = statusID;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }
    
    
}
