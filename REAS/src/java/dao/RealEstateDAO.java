package dao;

import dto.Image;
import dto.RealEstate;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import mylib.DBUtils;

public class RealEstateDAO {

    private List<RealEstate> post;

    public List<RealEstate> getPost() {
        return post;
    }

    public boolean createPost(RealEstate post, HttpServletRequest request) throws SQLException, NamingException, ClassNotFoundException {
        //mở connection
        Connection con = null;
        PreparedStatement stm = null;
        boolean result = false;
        try {
            con = DBUtils.getConnection();

            if (con != null) {
                String sql = "Insert into RealEstate("
                        + "[RealEstateID], [ImageFolderID], [AccID], [CatID], [CityID], [RealEstateName], [PriceNow], [TimeUp], [TimeDown], [Cost], [Status], [Area], [Address], [Detail]"
                        + " VALUES (realestate_seq.NEXTVAL,?,?,?,?,?,?,?,?,?,?,?,?,?)";
                stm = con.prepareStatement(sql);

                LocalDateTime ldt = LocalDateTime.now();

                Instant instant = ldt.atZone(ZoneId.systemDefault()).toInstant();

                Timestamp ts = Timestamp.from(instant);

                HttpSession session = request.getSession();
                String accID = (String) session.getAttribute("AccID");

                stm.executeUpdate(sql);
                
                stm.setString(2, accID);
                stm.setString(3, post.getCatID());
                stm.setInt(4, post.getCityID());
                stm.setString(5, post.getRealEstateName());
                stm.setFloat(6, post.getPriceNow());
                stm.setTimestamp(7, ts);
                stm.setTimestamp(8, ts);
                stm.setFloat(9, post.getCost());
        //        stm.setInt(10, post.getStatus("0"));
                stm.setFloat(11, post.getArea());
                stm.setString(12, post.getDetail());
                

                int effectRows = stm.executeUpdate();

                if (effectRows > 0) {
                    result = true;
                }
            }
        } finally {
            //xoa,sua,insert khong tra du lieu
            //bo ResultSet
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return result;
    }

    public static ArrayList<RealEstate> getRealEstateByStatus(int Status) throws ClassNotFoundException, SQLException, NamingException {
        ArrayList<RealEstate> list = new ArrayList<>();
        Connection cn = DBUtils.getConnection();
        if (cn != null) {
            String sql = "SELECT [RealEstateID], [ImageFolderID], [AccID], [CatID], [CityID], [RealEstateName], [PriceNow], [TimeUp], [TimeDown], [Cost], [Status], [Area], [Address], [Detail] \n"
                    + "FROM RealEstate WHERE [Status] = ?";
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setInt(1, Status);
            ResultSet rs = pst.executeQuery();
            ImageDAO imageDAO = new ImageDAO();
            if (rs != null) {
                while (rs.next()) {
                    
                    String realEstateID = rs.getString("RealEstateID");
                    String imageFolderID = rs.getString("ImageFolderID");
                    String accID = rs.getString("AccID");
                    String catID = rs.getString("CatID");
                    int cityID = rs.getInt("CityID");
                    String realEstateName = rs.getString("RealEstateName");
                    float priceNow = rs.getFloat("PriceNow");

                    Timestamp timeUpSql = rs.getTimestamp("TimeUp");
                    Timestamp timeDownSql = rs.getTimestamp("TimeDown");
                    Image imageByID = imageDAO.getImageByID(imageFolderID);
                    // Chuyển đổi Timestamp thành LocalDateTime
                    LocalDateTime timeUp = timeUpSql.toLocalDateTime();
                    LocalDateTime timeDown = timeDownSql.toLocalDateTime();
                    float cost = rs.getFloat("Cost");
                    int status = rs.getInt("Status");
                    int area = rs.getInt("Area");
                    String address = rs.getString("Address");
                    String detail = rs.getString("Detail");

                    RealEstate re = new RealEstate(realEstateID, imageFolderID, accID, catID, cityID, realEstateName, priceNow, timeUp, timeDown, cost, status, area, address, detail);
                    re.setImage(imageByID);
                    list.add(re);
                }
            }
            cn.close();
        }
        return list;
    }
    
    
}
