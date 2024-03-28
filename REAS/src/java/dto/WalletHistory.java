
package dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class WalletHistory {
     private String orderID;
    private int walletID;
    private BigDecimal price;
    private LocalDateTime dateAndTime;
    private int statusID;

    public WalletHistory() {
    }

    public WalletHistory(String orderID, int walletID, BigDecimal price, LocalDateTime dateAndTime, int statusID) {
        this.orderID = orderID;
        this.walletID = walletID;
        this.price = price;
        this.dateAndTime = dateAndTime;
        this.statusID = statusID;
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

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public LocalDateTime getDateAndTime() {
        return dateAndTime;
    }

    public void setDateAndTime(LocalDateTime dateAndTime) {
        this.dateAndTime = dateAndTime;
    }

    public int getStatusID() {
        return statusID;
    }

    public void setStatusID(int statusID) {
        this.statusID = statusID;
    }
    
    
}
