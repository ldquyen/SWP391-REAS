package dao;

import dto.Account;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import mylib.DBUtils;

public class AuctionDAO {

    public Account getAuction() throws ClassNotFoundException, SQLException {
        Account a = new Account();
        Connection cn = DBUtils.getConnection();
        if (cn != null) {
            String sql = "SELECT\n"
                    + "    A.AuctionName,\n"
                    + "    C.CatName,\n"
                    + "    CI.CityName,\n"
                    + "    R.PriceNow,\n"
                    + "    A.TimeEnd,\n"
                    + "    R.Status\n"
                    + "FROM\n"
                    + "    Auction A\n"
                    + "    JOIN RealEstate R ON A.RealEstateID = R.RealEstateID\n"
                    + "    JOIN Category C ON R.CatID = C.CatID\n"
                    + "    JOIN City CI ON R.CityID = CI.CityID;";
            PreparedStatement pst = cn.prepareStatement(sql);
//            pst.setString(1, Username);
//            pst.setString(2, Password);
            ResultSet rs = pst.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    String accID = rs.getString("AccID");
                    String roleID = rs.getString("RoleID");
                    String userName = rs.getString("UserName");
                    String password = rs.getString("Password");
                    String fullname = rs.getString("FullName");
                    boolean status = rs.getBoolean("Status");
                    String email = rs.getString("Email");
                    String phone = rs.getString("Phone");
                    String cccd = rs.getString("CCCD");
                    String address = rs.getString("Address");
                    String placeOfReg = rs.getString("PlaceOfReg");
                    String dateOfReg = rs.getString("DateOfReg");
                    String bankName = rs.getString("BankName");
                    String bankCode = rs.getString("BankCode");
                    a = new Account(accID, roleID, userName, password, fullname, status, email, phone, cccd, address, placeOfReg, dateOfReg, bankName, bankCode);
                }
            }
            cn.close();
        }
        return a;
    }
}
