
package dto;

public class Image {
    private String imageID;
    private String realEstateID;
    private String imageLink;

    public Image() {
    }

    public Image(String imageID, String realEstateID, String imageLink) {
        this.imageID = imageID;
        this.realEstateID = realEstateID;
        this.imageLink = imageLink;
    }

    public String getImageID() {
        return imageID;
    }

    public void setImageID(String imageID) {
        this.imageID = imageID;
    }

    public String getRealEstateID() {
        return realEstateID;
    }

    public void setRealEstateID(String realEstateID) {
        this.realEstateID = realEstateID;
    }

    public String getImageLink() {
        return imageLink;
    }

    public void setImageLink(String imageLink) {
        this.imageLink = imageLink;
    }

    @Override
    public String toString() {
        return "Image{" + "imageID=" + imageID + ", realEstateID=" + realEstateID + ", imageLink=" + imageLink + '}';
    }  
}
