
package dto;

public class UserGoogle {
    private String ggAccID;
    private String roleID;
    private String email;
    private boolean verifiedEmail;
    private String name;
    private String givenName;
    private String familyName;
    private String picture;

    public UserGoogle() {
    }

    public UserGoogle(String ggAccID, String roleID, String email, boolean verifiedEmail, String name, String givenName, String familyName, String picture) {
        this.ggAccID = ggAccID;
        this.roleID = roleID;
        this.email = email;
        this.verifiedEmail = verifiedEmail;
        this.name = name;
        this.givenName = givenName;
        this.familyName = familyName;
        this.picture = picture;
    }

    public String getGgAccID() {
        return ggAccID;
    }

    public void setGgAccID(String ggAccID) {
        this.ggAccID = ggAccID;
    }

    public String getRoleID() {
        return roleID;
    }

    public void setRoleID(String roleID) {
        this.roleID = roleID;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isVerifiedEmail() {
        return verifiedEmail;
    }

    public void setVerifiedEmail(boolean verifiedEmail) {
        this.verifiedEmail = verifiedEmail;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGivenName() {
        return givenName;
    }

    public void setGivenName(String givenName) {
        this.givenName = givenName;
    }

    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    @Override
    public String toString() {
        return "UserGoogle{" + "ggAccID=" + ggAccID + ", roleID=" + roleID + ", email=" + email + ", verifiedEmail=" + verifiedEmail + ", name=" + name + ", givenName=" + givenName + ", familyName=" + familyName + ", picture=" + picture + '}';
    }
}