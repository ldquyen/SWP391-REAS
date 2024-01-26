package dao;

import dto.Category;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import mylib.DBUtils;

public class CategoryDAO {

    public static ArrayList<Category> getListCategory() throws ClassNotFoundException, SQLException {
        ArrayList<Category> list = new ArrayList<>();
        Connection cn = DBUtils.getConnection();
        if (cn != null) {
            String sql = "select [CatID],[CatName] from [dbo].[Category]";
            PreparedStatement pst = cn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    String catID = rs.getString("CatID");
                    String catName = rs.getString("CatName");
                    Category c = new Category(catID, catName);
                    list.add(c);
                }
            }
            cn.close();
        }
        return list;
    }

}
