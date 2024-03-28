/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Datnt
 */
public class AuctionResultVM {
    public String auctionName, userName, phone, accountID;
    public int status;
    public int price;

    public AuctionResultVM() {
    }

    public AuctionResultVM(String auctionName, String userName, String phone, String accountID, int status, int price) {
        this.auctionName = auctionName;
        this.userName = userName;
        this.phone = phone;
        this.accountID = accountID;
        this.status = status;
        this.price = price;
    }

    public void setAuctionName(String auctionName) {
        this.auctionName = auctionName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setAccountID(String accountID) {
        this.accountID = accountID;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getAuctionName() {
        return auctionName;
    }

    public String getUserName() {
        return userName;
    }

    public String getPhone() {
        return phone;
    }

    public String getAccountID() {
        return accountID;
    }

    public int getStatus() {
        return status;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "AuctionResultVM{" + "auctionName=" + auctionName + ", userName=" + userName + ", phone=" + phone + ", accountID=" + accountID + ", status=" + status + ", price=" + price + '}';
    }

    
}


