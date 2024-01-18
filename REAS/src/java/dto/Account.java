
package dto;

public class Account {
    private String accID;
    private String roleID;
    private String userName;
    private String password;
    private String fullname;
    private boolean status;
    private String email;
    private String phone;
    private String cccd;
    private String address;
    private String placeOfReg;
    private String dateOfReg;
    private String bankName;
    private String bankCode;

    public Account() {
    }

    public Account(String accID, String roleID, String userName, String password, String fullname, boolean status, String email, String phone, String cccd, String address, String placeOfReg, String dateOfReg, String bankName, String bankCode) {
        this.accID = accID;
        this.roleID = roleID;
        this.userName = userName;
        this.password = password;
        this.fullname = fullname;
        this.status = status;
        this.email = email;
        this.phone = phone;
        this.cccd = cccd;
        this.address = address;
        this.placeOfReg = placeOfReg;
        this.dateOfReg = dateOfReg;
        this.bankName = bankName;
        this.bankCode = bankCode;
    }

    public String getAccID() {
        return accID;
    }

    public void setAccID(String accID) {
        this.accID = accID;
    }

    public String getRoleID() {
        return roleID;
    }

    public void setRoleID(String roleID) {
        this.roleID = roleID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCccd() {
        return cccd;
    }

    public void setCccd(String cccd) {
        this.cccd = cccd;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPlaceOfReg() {
        return placeOfReg;
    }

    public void setPlaceOfReg(String placeOfReg) {
        this.placeOfReg = placeOfReg;
    }

    public String getDateOfReg() {
        return dateOfReg;
    }

    public void setDateOfReg(String dateOfReg) {
        this.dateOfReg = dateOfReg;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getBankCode() {
        return bankCode;
    }

    public void setBankCode(String bankCode) {
        this.bankCode = bankCode;
    }

    @Override
    public String toString() {
        return "Account{" + "accID=" + accID + ", roleID=" + roleID + ", userName=" + userName + ", password=" + password + ", fullname=" + fullname + ", status=" + status + ", email=" + email + ", phone=" + phone + ", cccd=" + cccd + ", address=" + address + ", placeOfReg=" + placeOfReg + ", dateOfReg=" + dateOfReg + ", bankName=" + bankName + ", bankCode=" + bankCode + '}';
    }
    
    
}
