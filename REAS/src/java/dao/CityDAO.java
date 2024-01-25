package dao;

import dto.City;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import mylib.DBUtils;

public class CityDAO {

    public static ArrayList<City> getCityList() throws ClassNotFoundException, SQLException {
        ArrayList<City> list = new ArrayList<>();
        Connection cn = DBUtils.getConnection();
        if (cn != null) {
            String sql = "SELECT [CityID],[CityName] FROM [dbo].[City]";
            PreparedStatement pst = cn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    int cityID = rs.getInt("CityID");
                    String cityName = rs.getString("CityName");
                    City c = new City(cityID, cityName);
                    list.add(c);
                }
            }
            cn.close();
        }
        
        return list;
    }
}
