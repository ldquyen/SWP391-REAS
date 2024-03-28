package dto;


import java.util.Base64;

public class Image {

    private String imageFolderID;
    private byte[] imageLink1;
    private byte[] imageLink2;
    private byte[] imageLink3;

    public Image() {
    }

    public Image(String imageFolderID, byte[] imageLink1, byte[] imageLink2, byte[] imageLink3) {
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

    public byte[] getImageLink1() {
        return imageLink1;
    }

    public void setImageLink1(byte[] imageLink1) {
        this.imageLink1 = imageLink1;
    }

    public byte[] getImageLink2() {
        return imageLink2;
    }

    public void setImageLink2(byte[] imageLink2) {
        this.imageLink2 = imageLink2;
    }

    public byte[] getImageLink3() {
        return imageLink3;
    }

    public void setImageLink3(byte[] imageLink3) {
        this.imageLink3 = imageLink3;
    }

    @Override
    public String toString() {
        return "Image{" + "imageFolderID=" + imageFolderID + ", imageLink1=" + imageLink1 + ", imageLink2=" + imageLink2 + ", imageLink3=" + imageLink3 + '}';
    }
    
    public String getBase64Image1() {
        return Base64.getEncoder().encodeToString(imageLink1);
    }
    
    public String getBase64Image2() {
        return Base64.getEncoder().encodeToString(imageLink2);
    }
    
    public String getBase64Image3() {
        return Base64.getEncoder().encodeToString(imageLink3);
    }
    
//    public BufferedImage getImage1BufferedImage() throws IOException {
//        ByteArrayInputStream bis = new ByteArrayInputStream(imageLink1);
//        return ImageIO.read(bis);
//    }
//
//    public BufferedImage getImage2BufferedImage() throws IOException {
//        ByteArrayInputStream bis = new ByteArrayInputStream(imageLink2);
//        return ImageIO.read(bis);
//    }
//
//    public BufferedImage getImage3BufferedImage() throws IOException {
//        ByteArrayInputStream bis = new ByteArrayInputStream(imageLink3);
//        return ImageIO.read(bis);
//    }
}
