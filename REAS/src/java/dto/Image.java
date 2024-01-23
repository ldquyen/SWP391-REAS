package dto;

public class Image {

    private String imageFolderID;
    private String imageLink1;
    private String imageLink2;
    private String imageLink3;

    public Image() {
    }

    public Image(String imageFolderID, String imageLink1, String imageLink2, String imageLink3) {
        this.imageFolderID = imageFolderID;
        this.imageLink1 = imageLink1;
        this.imageLink2 = imageLink2;
        this.imageLink3 = imageLink3;
    }

    public String getImageFolderID() {
        return imageFolderID;
    }

    public void setImageFolderID(String imageFolderID) {
        this.imageFolderID = imageFolderID;
    }

    public String getImageLink1() {
        return imageLink1;
    }

    public void setImageLink1(String imageLink1) {
        this.imageLink1 = imageLink1;
    }

    public String getImageLink2() {
        return imageLink2;
    }

    public void setImageLink2(String imageLink2) {
        this.imageLink2 = imageLink2;
    }

    public String getImageLink3() {
        return imageLink3;
    }

    public void setImageLink3(String imageLink3) {
        this.imageLink3 = imageLink3;
    }

    @Override
    public String toString() {
        return "Image{" + "imageFolderID=" + imageFolderID + ", imageLink1=" + imageLink1 + ", imageLink2=" + imageLink2 + ", imageLink3=" + imageLink3 + '}';
    }
}
