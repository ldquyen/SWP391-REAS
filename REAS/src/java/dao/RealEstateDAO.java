package dao;

import dto.RealEstate;
import dto.RealEstateInfo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
            int area, String address, String detail, long lamda) throws SQLException, NamingException, ClassNotFoundException {
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
                            + "VALUES (?,?,?,?,?,?,?)";
                    try (PreparedStatement anotherStm = con.prepareStatement(sql2)) {
                        anotherStm.setString(1, realEstateID);
                        anotherStm.setString(2, realEstateID);
                        anotherStm.setString(3, realEstateName);
                        anotherStm.setLong(4, priceFirst);
                        anotherStm.setLong(5, lamda);
                        anotherStm.setTimestamp(6, Timestamp.valueOf(timeUp));
                        anotherStm.setTimestamp(7, Timestamp.valueOf(timeDown));

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

    // Lấy mọi thông tin của RealEstate bằng statusID
    public List<RealEstateInfo> getAllRealEstate(int statusID) throws ClassNotFoundException, SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        List<RealEstateInfo> result = null;

        try {
            con = DBUtils.getConnection();
            if (con != null) {
                String sql = "SELECT [RealEstate].RealEstateID "
                        + "      ,[Auction].AuctionID "
                        + "      ,[RealEstate].RealEstateName "
                        + "      ,[Account].UserName "
                        + "      ,[RealEstate].Address "
                        + "      ,[Category].CatName "
                        + "      ,[RealEstate].PriceFirst "
                        + "      ,[RealEstate].PricePaid "
                        + "      ,[Auction].Lamda "
                        + "      ,[Auction].TimeStart "
                        + "      ,[Auction].TimeEnd "
                        + "      ,[RealEstate].Area "
                        + "      ,[RealEstate].ImageFolderID "
                        + "      ,[RealEstate].Detail "
                        + "      ,[RealEstate].TimeUp "
                        + "      ,[Status].StatusName "
                        + "      ,[RealEstate].StatusID "
                        + "      ,[Auction].AccID "
                        + "      ,[Account].FullName "
                        + "      ,[Account].Phone "
                        + "      ,[City].CityName "
                        + "FROM [dbo].[RealEstate] "
                        + "INNER JOIN [dbo].[Category] ON [RealEstate].[CatID]  = [Category].[CatID] "
                        + "INNER JOIN [dbo].[City]     ON [RealEstate].[CityID] = [City].[CityID] "
                        + "INNER JOIN [dbo].[Account]  ON [RealEstate].[AccID]  = [Account].[AccID] "
                        + "INNER JOIN [dbo].[Auction]  ON [RealEstate].[RealEstateID] = [Auction].[RealEstateID] "
                        + "INNER JOIN [dbo].[Status] ON [RealEstate].[StatusID] = [Status].[StatusID] "
                        + "WHERE [RealEstate].[StatusID] = ? ORDER BY [RealEstate].[TimeUp] ASC";
                stm = con.prepareStatement(sql);
                stm.setInt(1, statusID);
                rs = stm.executeQuery();
                while (rs.next()) {
                    if (result == null) {
                        result = new ArrayList<RealEstateInfo>();
                    }
                    RealEstateInfo dto = new RealEstateInfo();

                    dto.setRealEstateID(rs.getString("RealEstateID"));
                    dto.setAuctionID(rs.getString("AuctionID"));
                    dto.setRealEstateName(rs.getString("RealEstateName"));
                    dto.setUserName(rs.getString("UserName"));
                    dto.setAddress(rs.getString("Address"));
                    dto.setCatName(rs.getString("CatName"));
                    dto.setPriceFirst(rs.getLong("PriceFirst"));
                    dto.setPricePaid(rs.getLong("PricePaid"));
                    dto.setLamda(rs.getLong("Lamda"));
                    dto.setArea(rs.getInt("Area"));
                    dto.setImageFolderID(rs.getString("ImageFolderID"));
                    dto.setDetail(rs.getString("Detail"));
                    dto.setStatusName(rs.getString("StatusName"));
                    dto.setStatusID(rs.getInt("StatusID"));
                    dto.setAccID(rs.getString("AccID"));
                    dto.setFullName(rs.getString("FullName"));
                    dto.setPhone(rs.getString("Phone"));
                    dto.setCityName(rs.getString("CityName"));

                    Timestamp timeStartSql = rs.getTimestamp("TimeStart");
                    Timestamp timeEndSql = rs.getTimestamp("TimeEnd");
                    Timestamp timeUpSql = rs.getTimestamp("TimeUp");

                    // Chuyển đổi Timestamp thành LocalDateTime
                    LocalDateTime timeStart = timeStartSql.toLocalDateTime();
                    LocalDateTime timeEnd = timeEndSql.toLocalDateTime();
                    LocalDateTime timeUp = timeUpSql.toLocalDateTime();

                    dto.setTimeStart(timeStart);
                    dto.setTimeEnd(timeEnd);
                    dto.setTimeUp(timeUp);

                    result.add(dto);
                }
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
        return result;
    }

    public boolean updateStatusID(String realEstateID, int statusID) throws ClassNotFoundException, SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        boolean result = false;
        try {
            con = DBUtils.getConnection();
            if (con != null) {
                String sql = "UPDATE [dbo].[RealEstate] SET [StatusID] = ? WHERE [RealEstateID] = ?";

                stm = con.prepareStatement(sql);
                stm.setInt(1, statusID);
                stm.setString(2, realEstateID);
                int effectRows = stm.executeUpdate();
                if (effectRows > 0) {
                    result = true;
                }
            }
        } finally {

            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return result;
    }

    public boolean deleteRealEstateID(String auctionID, String realEstateID, String imageFolderID) throws SQLException, NamingException, ClassNotFoundException {
        //mở connection
        Connection con = null;
        PreparedStatement stm1 = null;
        PreparedStatement stm2 = null;
        PreparedStatement stm3 = null;
        boolean result = false;
        try {
            //1.create connection
            con = DBUtils.getConnection();
            //2.create SQL String
            if (con != null) {
                String sql1 = " Delete From [dbo].[Auction] "
                        + "Where [AuctionID] = ?";
                //3.create Statement Obj
                stm1 = con.prepareStatement(sql1);
                stm1.setString(1, auctionID);
                int effectRows1 = stm1.executeUpdate();

                String sql2 = " Delete From [dbo].[RealEstate] "
                        + "Where [RealEstateID] = ?";
                //3.create Statement Obj
                stm2 = con.prepareStatement(sql2);
                stm2.setString(1, realEstateID);
                int effectRows2 = stm2.executeUpdate();

                String sql3 = " Delete From [dbo].[Image] "
                        + "Where [ImageFolderID] = ?";
                //3.create Statement Obj
                stm3 = con.prepareStatement(sql3);
                stm3.setString(1, imageFolderID);
                int effectRows3 = stm3.executeUpdate();

                //end username and password are existed
                //5.Process
                if (effectRows1 > 0 && effectRows2 > 0 && effectRows3 > 0) {
                    result = true;
                }
            }//end connection í avaible

        } finally {
            //xoa,sua,insert khong tra du lieu
            //bo ResultSet
            if (stm3 != null) {
                stm3.close();
            }
            if (stm2 != null) {
                stm2.close();
            }
            if (stm1 != null) {
                stm1.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return result;
    }

    public boolean chooseStaffForAuction(String accID, String realEstateID) throws SQLException, ClassNotFoundException {
        Connection con = null;
        PreparedStatement stm = null;
        boolean result = false;
        try {
            con = DBUtils.getConnection();
            if (con != null) {
                String sql = "UPDATE [dbo].[Auction] SET [AccID] = ? WHERE [RealEstateID] = ?";

                stm = con.prepareStatement(sql);
                stm.setString(1, accID);
                stm.setString(2, realEstateID);
                int effectRows = stm.executeUpdate();
                if (effectRows > 0) {
                    result = true;
                }
            }

        } finally {

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

    public static int countRowsInTable() throws ClassNotFoundException, SQLException, NamingException {
        int rowCount = 0;

        try (Connection cn = DBUtils.getConnection();
                Statement stmt = cn.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT COUNT(*) AS row_count FROM RealEstate where StatusID IN (1, 2, 3)")) {

            if (rs.next()) {
                rowCount = rs.getInt("row_count");
            }
        }

        return rowCount;
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
                    + "re.[Area], "
                    + "im.[ImageLink1] "
                    + "from dbo.[RealEstate] re join dbo.[Image] im on re.ImageFolderID = im.ImageFolderID Where StatusID IN (1 ,2, 3) order by re.TimeUp desc ";
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
                re.setArea(rs.getInt("Area"));
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
                    + "city.[CityName], "
                    + "city.[CityID] "
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
                realEstate.setCityID(rs.getInt("CityID"));
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

//    public static void main(String[] args) throws SQLException, ClassNotFoundException {
//        RealEstateDAO dao = new RealEstateDAO();
//        List<RealEstateVM> list = dao.getListAvailableRealEstate();
//        for (RealEstateVM realEstateVM : list) {
//            System.out.println(realEstateVM.toString()
//            );
//        }
//    }
    public static List<RealEstateVM> getListAvailableRealEstateByFilterWithSQL(String SQL) throws SQLException, ClassNotFoundException {
        List<RealEstateVM> listRealEstates = new ArrayList();
        Connection cn = DBUtils.getConnection();
        PreparedStatement pst = null;
        if (cn != null) {
            String sql = SQL;
            pst = cn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                RealEstateVM re = new RealEstateVM();
                re.setRealEstateID(rs.getString("RealEstateID"));
                re.setImageFolderID(rs.getString("ImageFolderID"));
                re.setAccID(rs.getString("AccID"));
                re.setCatID("CatID");
                re.setArea(rs.getInt("Area"));
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

    public static ArrayList<RealEstate> getRealEstateByIDAtMyPost(String accID) throws ClassNotFoundException, SQLException {
        ArrayList<RealEstate> reList = new ArrayList<>();
        Connection cn = DBUtils.getConnection();
        if (cn != null) {
            String sql = "SELECT RealEstateID,RealEstateName,TimeUp,StatusID FROM RealEstate WHERE AccID = ?";
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setString(1, accID);
            ResultSet rs = pst.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    RealEstate re = new RealEstate();
                    re.setRealEstateID(rs.getString("RealEstateID"));
                    re.setRealEstateName(rs.getString("RealEstateName"));
                    Timestamp timeUpSql = rs.getTimestamp("TimeUp");
                    re.setTimeUp(timeUpSql.toLocalDateTime());
                    re.setStatusID(rs.getInt("StatusID"));
                    reList.add(re);
                }
            }
        }

        return reList;
    }

//    public static void main(String[] args) throws ClassNotFoundException, SQLException {
//        ArrayList<RealEstate> reList = getRealEstateByIDAtMyPost("M1");
//        for (RealEstate realEstate : reList) {
//            System.out.println(realEstate.toString());
//        }
//    }
}
