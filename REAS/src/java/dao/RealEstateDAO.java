package dao;

import dto.RealEstate;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import javax.naming.NamingException;
import mylib.DBUtils;

public class RealEstateDAO {

    private List<RealEstate> post;

    public List<RealEstate> getPost() {
        return post;
    }

    public boolean createPost(RealEstate post) throws SQLException, NamingException, ClassNotFoundException {
        //mở connection
        Connection con = null;
        PreparedStatement stm = null;
        boolean result = false;
        try {
            //1.create connection
            con = DBUtils.getConnection();

            //2.create SQL String
            if (con != null) {
                String sql = "Insert into RealEstate("
                        + "realEstateID, imageFolderID,  accID,  catID,  cityID,  realEstateName,  priceNow, timeUp,  timeDown,  cost,  status,  area,  detail,  city"
                        + "Values("
                        + "?,?,?,?,?,?,?,?,?,?,?,?,?,?"
                        + ")";
                //3.create Statement Obj
                stm = con.prepareStatement(sql);
                stm.setString(1, post.getRealEstateID());
                stm.setString(2, post.getImageFolderID());
                stm.setString(3, post.getAccID());
                stm.setString(4, post.getCatID());

                //so nho hoac lon xuat hien loi unknown web
                //4.excute Query
                int effectRows = stm.executeUpdate();

                //end username and password are existed
                //5.Process
                if (effectRows > 0) {
                    result = true;
                }
            }//end connection í avaible

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

    public static ArrayList<RealEstate> getRealEstateByStatus(int Status) throws ClassNotFoundException, SQLException {
        ArrayList<RealEstate> list = new ArrayList<>();
        Connection cn = DBUtils.getConnection();
        if (cn != null) {
            String sql = "SELECT [RealEstateID], [ImageFolderID], [AccID], [CatID], [CityID], [RealEstateName], [PriceNow], [TimeUp], [TimeDown], [Cost], [Status], [Area], [Address], [Detail] \n"
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
                    float priceNow = rs.getFloat("PriceNow");
                    Time timeUpSql = rs.getTime("TimeUp");
                    LocalTime timeUp = timeUpSql.toLocalTime();
                    Time timeDownSql = rs.getTime("TimeDown");
                    LocalTime timeDown = timeDownSql.toLocalTime();
                    float cost = rs.getFloat("Cost");
                    int status = rs.getInt("Status");
                    int area = rs.getInt("Area");
                    String address = rs.getString("Address");
                    String detail = rs.getString("Detail");
                    
                    RealEstate re = new RealEstate(realEstateID, imageFolderID, accID, catID, cityID, realEstateName, priceNow, timeUp, timeDown, cost, status, area, address, detail);
                    list.add(re);
                }
            }
            cn.close();
        }
        return list;
    }
}
