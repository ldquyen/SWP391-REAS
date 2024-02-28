package dao;

import dto.RealEstate;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import javax.naming.NamingException;
import model.RealEstateVM;
import mylib.DBUtils;

public class RealEstateDAO {

    public boolean createPost(String realEstateID, String imageFolderID, String accID, String catID, int cityID,
            String realEstateName, long priceFirst, LocalDateTime timeUp, LocalDateTime timeDown, long priceLast, long pricePaid, int statusID,
            int area, String address, String detail) throws SQLException, NamingException, ClassNotFoundException {
        //mở connection
        Connection con = null;
        PreparedStatement stm = null;
        boolean result = false;
        try {
            con = DBUtils.getConnection();

            if (con != null) {
                String sql1 = "INSERT INTO [dbo].[RealEstate]"
                        + "([RealEstateID], [ImageFolderID], [AccID], [CatID], [CityID], [RealEstateName], [PriceFirst], [TimeUp], [TimeDown],[PriceLast],[PricePaid], [statusID], [Area], [Address], [Detail])"
                        + " VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
                stm = con.prepareStatement(sql1);

                stm.setString(1, realEstateID);
                stm.setString(2, imageFolderID);
                stm.setString(3, accID);
                stm.setString(4, catID);
                stm.setInt(5, cityID);
                stm.setString(6, realEstateName);
                stm.setLong(7, priceFirst);
                stm.setTimestamp(8, Timestamp.valueOf(LocalDateTime.now()));
                stm.setTimestamp(9, Timestamp.valueOf(LocalDateTime.now()));
                stm.setLong(10, priceLast);
                stm.setLong(11, pricePaid);
                stm.setInt(12, statusID);
                stm.setInt(13, area);
                stm.setString(14, address);
                stm.setString(15, detail);

                int effectRows = stm.executeUpdate();
                if (effectRows > 0) {
                    String sql2 = "INSERT INTO [dbo].[Auction]"
                            + "([AuctionID],[RealEstateID],[AuctionName],[PriceNow],[Lamda],[TimeStart],[TimeEnd])"
                            + "VALUES (?,?,?,?,0,?,?)";
                    try (PreparedStatement anotherStm = con.prepareStatement(sql2)) {
                        anotherStm.setString(1, realEstateID);
                        anotherStm.setString(2, realEstateID);
                        anotherStm.setString(3, realEstateName);
                        anotherStm.setLong(4, priceFirst);
                        anotherStm.setTimestamp(5, Timestamp.valueOf(timeUp));
                        anotherStm.setTimestamp(6, Timestamp.valueOf(timeDown));

                        int anotherEffectRows = anotherStm.executeUpdate();
                        // Xử lý kết quả hoặc thông báo

                    }
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

    public static boolean checkRealEstateIDExists(String realEstateID) throws SQLException, ClassNotFoundException {
        Connection cn = DBUtils.getConnection();
        PreparedStatement pst = null;
        if (cn != null) {
            String sql = "select [RealEstateID] from [dbo].[RealEstate] WHERE [RealEstateID] = ?";
            pst = cn.prepareStatement(sql);
            pst.setString(1, realEstateID);
            ResultSet rs = pst.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    String RealEstateID = rs.getString("realEstateID");
                    if (RealEstateID != null) {
                        return true;
                    } else {
                        return false;
                    }
                }
            }
        }
        return false;
    }

    public static ArrayList<RealEstate> getRealEstateByStatus(String stringsql, int StatusID) throws ClassNotFoundException, SQLException, NamingException {
        ArrayList<RealEstate> list = new ArrayList<>();
        Connection cn = DBUtils.getConnection();
        if (cn != null) {
            String sql = stringsql;
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setInt(1, StatusID);
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
                    long pricePaid = rs.getLong("PricePaid");
                    int statusid = rs.getInt("StatusID");
                    int area = rs.getInt("Area");
                    String address = rs.getString("Address");
                    String detail = rs.getString("Detail");

                    RealEstate re = new RealEstate(realEstateID, imageFolderID, accID, catID, cityID, realEstateName, priceFirst, timeUp, timeDown, priceLast, pricePaid, statusid, area, address, detail);
                    list.add(re);
                }
            }
            cn.close();
        }
        return list;
    }

    public static ArrayList<RealEstate> getRealEstateByID(String IDRE) throws ClassNotFoundException, SQLException, NamingException {
        ArrayList<RealEstate> list = new ArrayList<>();
        Connection cn = DBUtils.getConnection();
        if (cn != null) {
            String sql = "SELECT [RealEstateID], [ImageFolderID], [AccID], [CatID], [CityID], [RealEstateName], [PriceFirst], [TimeUp], [TimeDown], [PriceLast],[PricePaid], [StatusID], [Area], [Address] ,[Detail]\n"
                    + "FROM RealEstate WHERE [RealEstateID] = ?";
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setString(1, IDRE);
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
                    long pricePaid = rs.getLong("PricePaid");
                    int statusid = rs.getInt("StatusID");
                    int area = rs.getInt("Area");
                    String address = rs.getString("Address");
                    String detail = rs.getString("Detail");

                    RealEstate re = new RealEstate(realEstateID, imageFolderID, accID, catID, cityID, realEstateName, priceFirst, timeUp, timeDown, priceLast, pricePaid, statusid, area, address, detail);
                    list.add(re);
                }
            }
            cn.close();
        }
        return list;
    }

    public List<RealEstateVM> getListAvailableRealEstate() throws SQLException, ClassNotFoundException {
        List<RealEstateVM> listRealEstates = new ArrayList();
        Connection cn = DBUtils.getConnection();
        PreparedStatement pst = null;
        if (cn != null) {
            String sql = "select re.[RealEstateID], "
                    + "re.[AccID], "
                    + "re.[CityID], "
                    + "re.[ImageFolderID], "
                    + "re.[RealEstateName], "
                    + "re.[PriceFirst], "
                    + "re.[PriceLast], "
                    + "re.[PricePaid], "
                    + "re.[TimeUp], "
                    + "re.[TimeDown], "
                    + "re.[Address], "
                    + "im.[ImageLink1] "
                    + "from dbo.[RealEstate] re join dbo.[Image] im on re.ImageFolderID = im.ImageFolderID Where StatusID = 1 order by re.TimeUp desc ";
            pst = cn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                RealEstateVM re = new RealEstateVM();
                re.setRealEstateID(rs.getString("RealEstateID"));
                re.setImageFolderID(rs.getString("ImageFolderID"));
                re.setAccID(rs.getString("AccID"));
                re.setCityID(rs.getInt("CityID"));
                re.setRealEstateName(rs.getString("RealEstateName"));
                re.setPriceFirst(rs.getLong("PriceFirst"));
                re.setPriceLast(rs.getLong("PriceLast"));
                re.setPricePaid(rs.getLong("PricePaid"));
                Timestamp timeUpSql = rs.getTimestamp("TimeUp");
                Timestamp timeDownSql = rs.getTimestamp("TimeDown");
                re.setTimeUp(timeUpSql.toLocalDateTime());
                re.setTimeDown(timeDownSql.toLocalDateTime());
                // set image.
                byte[] imageLink1 = rs.getBytes("ImageLink1");
                re.setAddress(rs.getString("Address"));
                listRealEstates.add(re);
            }
        }
        return listRealEstates;
    }

    // get RealEstate by id 
    public RealEstateVM getRealEstateById(String realEstateID) throws SQLException, ClassNotFoundException {
        Connection cn = DBUtils.getConnection();
        PreparedStatement pst = null;
        RealEstateVM realEstate = new RealEstateVM();

        if (cn != null) {
            String sql = "Select re.[RealEstateID], "
                    + "re.[AccID], "
                    + "re.[RealEstateName], "
                    + "re.[PriceFirst], "
                    + "re.[PriceLast], "
                    + "re.[PricePaid], "
                    + "re.[TimeUp], "
                    + "re.[TimeDown], "
                    + "re.[Area],"
                    + "re.[Detail], "
                    + "re.[Address], "
                    + "im.[ImageLink1], "
                    + "im.[ImageLink2], "
                    + "im.[ImageLink3], "
                    + "ca.[CatName], "
                    + "city.[CityName] "
                    + "from dbo.[RealEstate] re join dbo.[Image] im on re.ImageFolderID = im.ImageFolderID "
                    + "join dbo.[Category] ca on ca.CatID = re.CatID join dbo.[City] city on re.CityID = city.CityID Where re.[RealEstateID] = ?";
            pst = cn.prepareStatement(sql);
            pst.setString(1, realEstateID);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                realEstate.setAccID(rs.getString("AccID"));
                realEstate.setRealEstateID(rs.getString("RealEstateID"));
                realEstate.setRealEstateName(rs.getString("RealEstateName"));
                realEstate.setPriceFirst(rs.getLong("PriceFirst"));
                realEstate.setPriceLast(rs.getLong("PriceLast"));
                realEstate.setAddress(rs.getString("Address"));
                Timestamp timeUpSql = rs.getTimestamp("TimeUp");
                Timestamp timeDownSql = rs.getTimestamp("TimeDown");
                realEstate.setTimeUp(timeUpSql.toLocalDateTime());
                realEstate.setTimeDown(timeDownSql.toLocalDateTime());
                // set image.
//                byte[] imageData1 = rs.getBytes("ImageLink1");
//                byte[] imageData2 = rs.getBytes("ImageLink2");
//                byte[] imageData3 = rs.getBytes("ImageLink3");
//                String base64Image1 = java.util.Base64.getEncoder().encodeToString(imageData1);
//                String base64Image2 = java.util.Base64.getEncoder().encodeToString(imageData2);
//                String base64Image3 = java.util.Base64.getEncoder().encodeToString(imageData3);
//                realEstate.setImage1(base64Image1);
//                realEstate.setImage2(base64Image2);
//                realEstate.setImage3(base64Image3);
                byte[] imageLink1 = rs.getBytes("ImageLink1");
                byte[] imageLink2 = rs.getBytes("ImageLink2");
                byte[] imageLink3 = rs.getBytes("ImageLink3");

                realEstate.setDetail(rs.getString("Detail"));
                realEstate.setArea(rs.getInt("Area"));
                realEstate.setPricePaid(rs.getLong("PricePaid"));
                realEstate.setImageFolderID(rs.getString("AccID"));
                realEstate.setCategory(rs.getString("CatName"));
                realEstate.setCity(rs.getString("CityName"));
                return realEstate;
            }
        }
        return null;
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        RealEstateDAO dao = new RealEstateDAO();
        List<RealEstateVM> list = dao.getListAvailableRealEstate();
        for (RealEstateVM realEstateVM : list) {
            System.out.println(realEstateVM.toString()
            );
        }
    }
}
