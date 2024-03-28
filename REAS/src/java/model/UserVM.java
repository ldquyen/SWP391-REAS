/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Admin
 */
public class UserVM {

    private String accID, roleID, fullName, email, phone, cCCD, address, placeOfReg, dateOfReg, bankName, bankCode;
    private long accountBalance;
    private boolean status;
    private int walletId;

    public UserVM() {
    }

    public UserVM(String accID, String roleID, String fullName, String email, String phone, String cCCD, String address, String placeOfReg, String dateOfReg, String bankName, String bankCode, long accountBalance, boolean status, int walletId) {
        this.accID = accID;
        this.roleID = roleID;
        this.fullName = fullName;
        this.email = email;
        this.phone = phone;
        this.cCCD = cCCD;
        this.address = address;
        this.placeOfReg = placeOfReg;
        this.dateOfReg = dateOfReg;
        this.bankName = bankName;
        this.bankCode = bankCode;
        this.accountBalance = accountBalance;
        this.status = status;
        this.walletId = walletId;
    }

    public void setAccID(String accID) {
        this.accID = accID;
    }

    public void setRoleID(String roleID) {
        this.roleID = roleID;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setcCCD(String cCCD) {
        this.cCCD = cCCD;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPlaceOfReg(String placeOfReg) {
        this.placeOfReg = placeOfReg;
    }

    public void setDateOfReg(String dateOfReg) {
        this.dateOfReg = dateOfReg;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public void setBankCode(String bankCode) {
        this.bankCode = bankCode;
    }

    public void setAccountBalance(long accountBalance) {
        this.accountBalance = accountBalance;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public void setWalletId(int walletId) {
        this.walletId = walletId;
    }

    public String getAccID() {
        return accID;
    }

    public String getRoleID() {
        return roleID;
    }

    public String getFullName() {
        return fullName;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getcCCD() {
        return cCCD;
    }

    public String getAddress() {
        return address;
    }

    public String getPlaceOfReg() {
        return placeOfReg;
    }

    public String getDateOfReg() {
        return dateOfReg;
    }

    public String getBankName() {
        return bankName;
    }

    public String getBankCode() {
        return bankCode;
    }

    public long getAccountBalance() {
        return accountBalance;
    }

    public boolean isStatus() {
        return status;
    }

    public int getWalletId() {
        return walletId;
    }
    
}