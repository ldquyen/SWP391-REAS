/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

/**
 *
 * @author tranl
 */
public class GoogleAccount {
    private String GgAccID;
    private String RoleID;
    private String Email;
    private boolean VerifiedEmail;
    private String Name;
    private String GivenName;
    private String FamilyName;
    private String Picture;

    public GoogleAccount() {
    }

    public GoogleAccount(String GgAccID, String RoleID, String Email, boolean VerifiedEmail, String Name, String GivenName, String FamilyName, String Picture) {
        this.GgAccID = GgAccID;
        this.RoleID = RoleID;
        this.Email = Email;
        this.VerifiedEmail = VerifiedEmail;
        this.Name = Name;
        this.GivenName = GivenName;
        this.FamilyName = FamilyName;
        this.Picture = Picture;
    }

    public String getGgAccID() {
        return GgAccID;
    }

    public void setGgAccID(String GgAccID) {
        this.GgAccID = GgAccID;
    }

    public String getRoleID() {
        return RoleID;
    }

    public void setRoleID(String RoleID) {
        this.RoleID = RoleID;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public boolean isVerifiedEmail() {
        return VerifiedEmail;
    }

    public void setVerifiedEmail(boolean VerifiedEmail) {
        this.VerifiedEmail = VerifiedEmail;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getGivenName() {
        return GivenName;
    }

    public void setGivenName(String GivenName) {
        this.GivenName = GivenName;
    }

    public String getFamilyName() {
        return FamilyName;
    }

    public void setFamilyName(String FamilyName) {
        this.FamilyName = FamilyName;
    }

    public String getPicture() {
        return Picture;
    }

    public void setPicture(String Picture) {
        this.Picture = Picture;
    }

    @Override
    public String toString() {
        return "GoogleAccount{" + "GgAccID=" + GgAccID + ", RoleID=" + RoleID + ", Email=" + Email + ", VerifiedEmail=" + VerifiedEmail + ", Name=" + Name + ", GivenName=" + GivenName + ", FamilyName=" + FamilyName + ", Picture=" + Picture + '}';
    }

    
    
}
