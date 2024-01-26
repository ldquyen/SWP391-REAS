package dao;

import dto.RealEstate;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
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
                String sql =   "Insert into RealEstate("
                        +"realEstateID, imageFolderID,  accID,  catID,  cityID,  realEstateName,  priceNow, timeUp,  timeDown,  cost,  status,  area,  detail,  city"
                        + "Values("
                        +"?,?,?,?,?,?,?,?,?,?,?,?,?,?"
                        +")";
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

}
