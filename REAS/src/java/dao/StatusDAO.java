
package dao;

import dto.Status;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import mylib.DBUtils;

public class StatusDAO {
    public static ArrayList<Status> getStatusList() throws ClassNotFoundException, SQLException {
        ArrayList<Status> list = new ArrayList<>();
        Connection cn = DBUtils.getConnection();
        if (cn != null) {
            String sql = "SELECT StatusID, StatusName FROM [Status]";
            PreparedStatement pst = cn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                   int id = rs.getInt("StatusID");
                   String name = rs.getString("StatusName");
                   Status s = new Status(id, name);
                   list.add(s);
                }
            }
            cn.close();
        }      
        return list;
    }
//    public static void main(String[] args) throws ClassNotFoundException, SQLException {
//        ArrayList<Status> list = getStatusList();
//        for (Status status : list) {
//            System.out.println(status.toString());
//        }
//    }
}
