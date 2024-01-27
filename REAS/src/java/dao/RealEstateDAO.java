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
                String sql = "Insert INTO [dbo].[RealEstate]("
                        + "[RealEstateID], [ImageFolderID], [AccID], [CatID], [CityID], [RealEstateName], [PriceNow], [TimeUp], [TimeDown], [Cost], [Area], [Address], [Detail]"
                        + " VALUES (NEXT VALUE FOR RealEstateID_Seq,'folder1',?,?,?,?,?,?,?,?,?,?,?,?)";
                stm = con.prepareStatement(sql);

                LocalDateTime ldt = LocalDateTime.now();

                Instant instant = ldt.atZone(ZoneId.systemDefault()).toInstant();

                Timestamp ts = Timestamp.from(instant);

                HttpSession session = request.getSession();
                String accID = (String) session.getAttribute("AccID");

                stm.executeUpdate(sql);
                
                stm.setString(1, accID);
                stm.setString(2, post.getCatID());
                stm.setInt(3, post.getCityID());
                stm.setString(4, post.getRealEstateName());
//                stm.setString(5, post.getPriceNow());
                stm.setTimestamp(6, ts);
                stm.setTimestamp(7, ts);
//                stm.setFloat(8, post.getCost());
                stm.setFloat(9, post.getArea());
                stm.setString(10, post.getAddress());
                stm.setString(11, post.getDetail());
                

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
            String sql = "SELECT [RealEstateID], [ImageFolderID], [AccID], [CatID], [CityID], [RealEstateName], [PriceFirst], [TimeUp], [TimeDown], [PriceLast], [Status], [Area], [Address], [Detail] \n"
                    + "FROM RealEstate WHERE [Status] = ?";
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setInt(1, Status);
            ResultSet rs = pst.executeQuery();
            
            if (rs != null) {
                while (rs.next()) {
                    
                    String realEstateID = rs.getString("RealEstateID");
                    String imageFolderID = rs.getString("ImageFolderID");
                    String accID = rs.getString("AccID");
                    String catID = rs.getString("CatID");
                    int cityID = rs.getInt("CityID");
                    String realEstateName = rs.getString("RealEstateName");
                    long priceFirst = rs.getLong("PriceFirst");

                    Timestamp timeUpSql = rs.getTimestamp("TimeUp");
                    Timestamp timeDownSql = rs.getTimestamp("TimeDown");
                    
                    // Chuyển đổi Timestamp thành LocalDateTime
                    LocalDateTime timeUp = timeUpSql.toLocalDateTime();
                    LocalDateTime timeDown = timeDownSql.toLocalDateTime();
                    long priceLast = rs.getLong("PriceLast");
                    int status = rs.getInt("Status");
                    int area = rs.getInt("Area");
                    String address = rs.getString("Address");
                    String detail = rs.getString("Detail");

                    RealEstate re = new RealEstate(realEstateID, imageFolderID, accID, catID, cityID, realEstateName, priceFirst, timeUp, timeDown, priceLast, status, area, address, detail);
                    list.add(re);     
                }
            }
            cn.close();
        }
        return list;
    }
}
