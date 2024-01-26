package dao;

import dto.Image;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.naming.NamingException;
import mylib.DBUtils;

public class ImageDAO {

    public Image getImageByID(String folderID)
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
                    image.setImageLink1(rs.getString("ImageLink1"));
                    image.setImageLink2(rs.getString("ImageLink2"));
                    image.setImageLink3(rs.getString("ImageLink3"));
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

}
