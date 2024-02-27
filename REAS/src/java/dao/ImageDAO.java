package dao;

import dto.Image;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.naming.NamingException;
import javax.servlet.http.Part;
import mylib.DBUtils;

public class ImageDAO {

    public static Image getImageByID(String folderID)
            throws SQLException, NamingException, ClassNotFoundException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            //1. create connect
            con = DBUtils.getConnection();
            if (con != null) { //connection is available
                //2. connect sql string
                String sql = "SELECT [ImageFolderID]\n"
                        + "      ,[ImageLink1]\n"
                        + "      ,[ImageLink2]\n"
                        + "      ,[ImageLink3]\n"
                        + "  FROM [dbo].[Image] where ImageFolderID = ?";

                //3. create statement obj
                stm = con.prepareStatement(sql);
                stm.setString(1, folderID);

                //4. execute query
                rs = stm.executeQuery();
                //5. process
                //1 dong if nhieu dong while username la primary key

                while (rs.next()) {
                    Image image = new Image();
                    image.setImageFolderID(folderID);
//                    image.setImageLink1(rs.getString("ImageLink1"));
//                    image.setImageLink2(rs.getString("ImageLink2"));
//                    image.setImageLink3(rs.getString("ImageLink3"));
                    return image;
                }
                //jdbc object khai bao dong no lai su dung
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return null;
    }

    public static void saveImg(String imageFolderID, Part imageLink1, Part imageLink2, Part imageLink3) throws ClassNotFoundException, SQLException {
        Connection cn = DBUtils.getConnection();
        if (cn != null) {
            try {
                InputStream inputStream1 = imageLink1.getInputStream();
                InputStream inputStream2 = imageLink2.getInputStream();
                InputStream inputStream3 = imageLink3.getInputStream();

                ByteArrayOutputStream buffer1 = new ByteArrayOutputStream();
                ByteArrayOutputStream buffer2 = new ByteArrayOutputStream();
                ByteArrayOutputStream buffer3 = new ByteArrayOutputStream();

                int nRead1, nRead2, nRead3;
                byte[] data1 = new byte[1024];
                byte[] data2 = new byte[1024];
                byte[] data3 = new byte[1024];

                while ((nRead1 = inputStream1.read(data1, 0, data1.length)) != -1) {
                    buffer1.write(data1, 0, nRead1);
                }
                while ((nRead2 = inputStream2.read(data2, 0, data2.length)) != -1) {
                    buffer2.write(data2, 0, nRead2);
                }
                while ((nRead3 = inputStream3.read(data3, 0, data3.length)) != -1) {
                    buffer3.write(data3, 0, nRead3);
                }

                buffer1.flush();
                buffer2.flush();
                buffer3.flush();

                byte[] imgBytes1 = buffer1.toByteArray();
                byte[] imgBytes2 = buffer2.toByteArray();
                byte[] imgBytes3 = buffer3.toByteArray();

                String sql = "INSERT INTO [dbo].[Image] ([ImageFolderID],[ImageLink1],[ImageLink2],[ImageLink3]) VALUES (?, ?, ?, ?)";
                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setString(1, imageFolderID);
                pst.setBytes(2, imgBytes1);
                pst.setBytes(3, imgBytes2);
                pst.setBytes(4, imgBytes3);
                pst.executeUpdate();

            } catch (Exception e) {
                cn.close();
            }
        }
    }

    public static void saveImg2(String imageFolderID, String imageLink1, String imageLink2, String imageLink3) throws ClassNotFoundException, SQLException {
        Connection cn = DBUtils.getConnection();
        if (cn != null) {
            try {
                File imgFile1 = new File(imageLink1);
                FileInputStream inputStream1 = new FileInputStream(imgFile1);
                ByteArrayOutputStream buffer1 = new ByteArrayOutputStream();
                int nRead1;
                byte[] data1 = new byte[1024];
                while ((nRead1 = inputStream1.read(data1, 0, data1.length)) != -1) {
                    buffer1.write(data1, 0, nRead1);
                }
                buffer1.flush();
                byte[] imgBytes1 = buffer1.toByteArray();

                File imgFile2 = new File(imageLink2);
                FileInputStream inputStream2 = new FileInputStream(imgFile2);
                ByteArrayOutputStream buffer2 = new ByteArrayOutputStream();
                int nRead2;
                byte[] data2 = new byte[1024];
                while ((nRead2 = inputStream2.read(data2, 0, data2.length)) != -1) {
                    buffer2.write(data2, 0, nRead2);
                }
                buffer2.flush();
                byte[] imgBytes2 = buffer2.toByteArray();

                File imgFile3 = new File(imageLink3);
                FileInputStream inputStream3 = new FileInputStream(imgFile3);
                ByteArrayOutputStream buffer3 = new ByteArrayOutputStream();
                int nRead3;
                byte[] data3 = new byte[1024];
                while ((nRead3 = inputStream3.read(data3, 0, data3.length)) != -1) {
                    buffer3.write(data3, 0, nRead3);
                }
                buffer3.flush();
                byte[] imgBytes3 = buffer3.toByteArray();

                String sql = "INSERT INTO [dbo].[Image] ([ImageFolderID],[ImageLink1],[ImageLink2],[ImageLink3]) VALUES (?, ?, ?, ?)";
                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setString(1, imageFolderID);
                pst.setBytes(2, imgBytes1);
                pst.setBytes(3, imgBytes2);
                pst.setBytes(4, imgBytes3);
                pst.executeUpdate();

            } catch (Exception e) {
                cn.close();
            }
        }
    }

    public static ArrayList<Image> getListImageByFolderID(String folderid) throws ClassNotFoundException, SQLException {
        ArrayList<Image> list = new ArrayList<>();
        Connection cn = DBUtils.getConnection();
        if (cn != null) {
            String sql = "SELECT ImageFolderID,ImageLink1,ImageLink2,ImageLink3 FROM Image WHERE ImageFolderID = ?";
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setString(1, folderid);
            ResultSet rs = pst.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    String imageFolderID = rs.getString("ImageFolderID");
                    byte[] imageLink1 = rs.getBytes("ImageLink1");
                    byte[] imageLink2 = rs.getBytes("ImageLink2");
                    byte[] imageLink3 = rs.getBytes("ImageLink3");
                    Image i = new Image(imageFolderID, imageLink1, imageLink2, imageLink3);
                    list.add(i);
                }
            }
            cn.close();
        }
        return list;
    }
    
    public static ArrayList<Image> getListImage() throws ClassNotFoundException, SQLException {
        ArrayList<Image> list = new ArrayList<>();
        Connection cn = DBUtils.getConnection();
        if (cn != null) {
            String sql = "SELECT ImageFolderID,ImageLink1,ImageLink2,ImageLink3 FROM Image";
            PreparedStatement pst = cn.prepareStatement(sql);         
            ResultSet rs = pst.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    String imageFolderID = rs.getString("ImageFolderID");
                    byte[] imageLink1 = rs.getBytes("ImageLink1");
                    byte[] imageLink2 = rs.getBytes("ImageLink2");
                    byte[] imageLink3 = rs.getBytes("ImageLink3");
                    Image i = new Image(imageFolderID, imageLink1, imageLink2, imageLink3);
                    list.add(i);
                }
            }
            cn.close();
        }
        return list;
    }
    
    public  ArrayList<Image> getListImage2() throws ClassNotFoundException, SQLException {
        ArrayList<Image> list = new ArrayList<>();
        Connection cn = DBUtils.getConnection();
        if (cn != null) {
            String sql = "SELECT ImageFolderID,ImageLink1,ImageLink2,ImageLink3 FROM Image";
            PreparedStatement pst = cn.prepareStatement(sql);         
            ResultSet rs = pst.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    String imageFolderID = rs.getString("ImageFolderID");
                    byte[] imageLink1 = rs.getBytes("ImageLink1");
                    byte[] imageLink2 = rs.getBytes("ImageLink2");
                    byte[] imageLink3 = rs.getBytes("ImageLink3");
                    Image i = new Image(imageFolderID, imageLink1, imageLink2, imageLink3);
                    list.add(i);
                }
            }
            cn.close();
        }
        return list;
    }
     

    public static void main(String[] args) throws SQLException, NamingException, ClassNotFoundException {
        //ImageDAO.saveImg2("FOLDER10", "C:\\Users\\ASUS\\Pictures\\Screen\\gameedu.png", "C:\\Users\\ASUS\\Pictures\\Screen\\gameedu.png", "C:\\Users\\ASUS\\Pictures\\Screen\\gameedu.png");
        //ImageDAO iD = new ImageDAO();
        //Image i = iD.getImageByID("FOLDER10");
    }
}
