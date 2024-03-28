/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import java.time.LocalDateTime;


public class OrderWallet {
    private String orderID;
    private int walletID;
    private Long price;
    private LocalDateTime date;
    private String statusName;

    public OrderWallet() {
    }

    public OrderWallet(String orderID, int walletID, Long price, LocalDateTime date, String statusName) {
        this.orderID = orderID;
        this.walletID = walletID;
        this.price = price;
        this.date = date;
        this.statusName = statusName;
    }

    public String getOrderID() {
        return orderID;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    public int getWalletID() {
        return walletID;
    }

    public void setWalletID(int walletID) {
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

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }

    
   
    
}
