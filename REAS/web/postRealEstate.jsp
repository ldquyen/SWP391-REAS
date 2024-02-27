<%-- 
    Document   : postRealEstate
    Created on : Jan 22, 2024, 11:24:00 PM
    Author     : ADMIN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Real Estate Auction System</title>
        <link rel="icon" type="image/x-icon" href="image/logo.png">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bulma@0.9.4/css/bulma.min.css">
        <link rel="stylesheet" href="style.css" type="text/css" >
        <link rel="stylesheet" href="postRealEstate.css" type="text/css" >

    </head>
    <body>
        <nav class="navbar" role="navigation" aria-label="main navigation">
            <div class="navbar-brand">
                <a class="navbar-item" href="index_1.jsp">
                    <img class="logo-header" src="image/logo.png" alt="" href="" width="100" height="28" />
                </a>

                <a role="button" class="navbar-burger" aria-label="menu" aria-expanded="false" data-target="navbarBasicExample">
                    <span aria-hidden="true"></span>
                    <span aria-hidden="true"></span>
                    <span aria-hidden="true"></span>
                </a>
            </div>

            <div id="navbarBasicExample" class="navbar-menu">
                <div class="navbar-start">
                    <a class="navbar-item" href="index_1.jsp">
                        TRANG CHỦ
                    </a>

                    <a class="navbar-item">
                        <form action="MainController" method="post">
                            <button type="submit" value="news" name="action">
                                <span>TIN TỨC</span>
                            </button>
                        </form>
                    </a>

                    <a class="navbar-item">
                        <form action="MainController" method="post">
                            <button type="submit" value="rule" name="action">
                                <span>NỘI QUY</span>
                            </button>
                        </form>
                    </a>
                </div>

                <div class="navbar-end">
                    <div class="navbar-item">
                        <div class="navbar-container-1">
                            <form action="MainController" method="post">
                                <button class="navbar-1" type="submit" value="auctionList" name="action">
                                    <span>DANH SÁCH ĐẤU GIÁ</span>
                                </button>
                            </form>
                        </div>
                        <div class="navbar-container-1">
                            <form action="MainController" method="post">
                                <button class="navbar-1" type="submit" value="postNew" name="action">
                                    <span>ĐĂNG TIN</span>
                                </button>
                            </form>
                        </div>
                        <div class="navbar-container-1">
                            <a class="navbar-1">10.000.000</a>                  
                        </div>

                        <div class="navbar-item hover-down has-dropdown is-hoverable">
                            <a class="navbar-link navbar-1-list">
                                <c:choose>
                                    <c:when test="${not empty sessionScope.member}">
                                        ${sessionScope.member.fullname}
                                    </c:when>
                                    <c:when test="${not empty sessionScope.userGoogle}">
                                        ${sessionScope.userGoogle.given_name}
                                    </c:when>
                                    <c:otherwise>
                                        Guest
                                    </c:otherwise>
                                </c:choose>
                            </a>
                            <div class="fake-div"></div>

                            <div class="navbar-dropdown">
                                <a class="navbar-item">
                                    <form action="MainController" method="post">
                                        <button type="submit" value="informationPage" name="action">
                                            <span>Thông tin tài khoản</span>
                                        </button>
                                    </form>
                                </a>
                                <a class="navbar-item">
                                    <form action="MainController" method="post">
                                        <button type="submit" value="aboutus" name="action">
                                            <span>Danh mục đã đăng kí</span>
                                        </button>
                                    </form>
                                </a>
                                <a class="navbar-item">
                                    <form action="MainController" method="post">
                                        <button type="submit" value="aboutus" name="action">
                                            <span>Lịch sử đấu giá</span>
                                        </button>
                                    </form>
                                </a>
                                <a class="navbar-item">
                                    <form action="MainController" method="post">
                                        <button type="submit" value="aboutus" name="action">
                                            <span>Quản lí tin đăng</span>
                                        </button>
                                    </form>
                                </a>
                                <a class="navbar-item">
                                    <form action="MainController" method="post">
                                        <button type="submit" value="changePass" name="action">
                                            <span>Thay đổi mật khẩu</span>
                                        </button>
                                    </form>
                                </a>
                                <a class="navbar-item">
                                    <form action="MainController" method="post">
                                        <button type="submit" value="aboutus" name="action">
                                            <span>Thông tin thanh toán</span>
                                        </button>
                                    </form>
                                </a>

                                <hr class="navbar-divider">
                                <a class="navbar-item">
                                    <form action="MainController" method="post">
                                        <button type="submit" value="Logout" name="action" >
                                            <span>Đăng xuất</span>
                                        </button>
                                    </form>
                                </a>

                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </nav>

        <!-- BODY -->
        <div class="BodyForm">
            <div class="TieuDe">
                <h1>
                    ĐĂNG KÍ THÔNG TIN ĐẤU GIÁ
                </h1>
            </div>

            <div class="form-post-real-estate" >
                <form action="MainController" method="post" enctype="multipart/form-data">
                    <input type="hidden" id="accID" name="accID" value="${sessionScope.member.accID}">
                    <!--                    <input type="text" id="realEstateID" name="realEstateID" required/></br>-->
                    <label>1. Tên tài sản đấu giá</label>
                    <input type="text" id="realEstateName" name="realEstateName" required></br>
                    <label>2.Địa chỉ</label>
                    <input type="text" id="address" name="address" required></br>
                    <label>3.Loại</label>
                    <select id="loaiTaiSan" name="catID" ></br>
                        <option value="" disabled selected hidden>-- Chọn --</option>
                        <option value="no">Nhà </option>
                        <option value="dn">Đất </option>
                        <option value="cc">Chung cư</option>
                        <option value="bt">Biệt thự</option>
                    </select></br>
                    <label>4.Thành phố</label>
                    <select id="cityID" name="cityID">
                        <option value="" disabled selected hidden>Thành phố</option>
                        <option value="1">An Giang</option>
                        <option value="2">Bà Rịa - Vũng Tàu</option>
                        <option value="3">Bắc Giang</option>
                        <option value="4">Bắc Kạn</option>
                        <option value="5">Bạc Liêu</option>
                        <option value="6">Bắc Ninh</option>
                        <option value="7">Bến Tre</option>
                        <option value="8">Bình Định</option>
                        <option value="9">Bình Bương</option>
                        <option value="10">Bình Phước</option>
                        <option value="11">Bình Thuận</option>
                        <option value="12">Cà Mau</option>
                        <option value="13">Cao Bằng</option>
                        <option value="14">Cần Thơ</option>
                        <option value="15">Đà Nẵng</option>
                        <option value="16">Đắk Lắk</option>
                        <option value="17">Đắk Nông</option>
                        <option value="18">Điện Biên</option>
                        <option value="19">Đồng Nai</option>
                        <option value="20">Đồng Tháp</option>
                        <option value="21">Gia Lai</option>
                        <option value="22">Hà Giang</option>
                        <option value="23">Hà Nam</option>
                        <option value="24">Hà Tĩnh</option>
                        <option value="25">Hà Nội</option>
                        <option value="26">Hải Dương</option>
                        <option value="27">Hải Phòng</option>
                        <option value="28">Hậu Giang</option>
                        <option value="29">Hòa Bình</option>
                        <option value="30">Hưng Yên</option>
                        <option value="31">Khánh Hòa</option>
                        <option value="32">Kiên Giang</option>
                        <option value="33">Kon Tum</option>
                        <option value="34">Lai Châu</option>
                        <option value="35">Lâm Đồng</option>
                        <option value="36">Lạng Sơn</option>
                        <option value="37">Lào Cai</option>
                        <option value="38">Long An</option>
                        <option value="39">Nam Định</option>
                        <option value="40">Nghệ An</option>
                        <option value="41">Ninh Bình</option>
                        <option value="42">Ninh Thuận</option>
                        <option value="43">Phú Thọ</option>
                        <option value="44">Phú Yên</option>
                        <option value="45">Quảng Bình</option>
                        <option value="46">Quảng Nam</option>
                        <option value="47">Quảng Ngãi</option>
                        <option value="48">Quảng Ninh</option>
                        <option value="49">Quảng Trị</option>
                        <option value="50">Sóc Trăng</option>
                        <option value="51">Sơn La</option>
                        <option value="52">Tây Ninh</option>
                        <option value="53">Thái Bình</option>
                        <option value="54">Thái Nguyên</option>
                        <option value="55">Thanh Hóa</option>
                        <option value="56">Thừa Thiên Huế</option>
                        <option value="57">Tiền Giang</option>
                        <option value="58">Hồ Chí Minh</option>
                        <option value="59">Trà Vinh</option>
                        <option value="60">Tuyên Quang</option>
                        <option value="61">Vĩnh Long</option>
                        <option value="62">Vĩnh Phúc</option>
                        <option value="63">Yên Bái</option>
                    </select></br>

                    <label>5.Giá</label>
                    <input type="text" id="priceFirst" name="priceFirst" placeholder="VNĐ" oninput="formatCurrency(this)" required></br>

                    <label>6.Thời gian bắt đầu</label>
                    <input type="datetime-local"  id="timeStart" name="timeStart" required></br>
                    <script>
                        // Lấy ngày và giờ hiện tại
                        var currentDate = new Date();

                        // Chuyển đổi ngày hiện tại thành chuỗi định dạng ISO (yyyy-mm-ddThh:mm)
                        var currentDateTime = currentDate.toISOString().slice(0, 16);

                        // Thiết lập thuộc tính min cho các trường datetime-local
                        document.getElementById("timeStart").min = currentDateTime;
                    </script>

                    <label>7.Thời gian kết thúc</label>
                    <input type="datetime-local"  id="timeEnd" name="timeEnd"  required></br>
                    <script>
                        // Lấy ngày và giờ hiện tại
                        var currentDate = new Date();

                        // Chuyển đổi ngày hiện tại thành chuỗi định dạng ISO (yyyy-mm-ddThh:mm)
                        var currentDateTime = currentDate.toISOString().slice(0, 16);

                        // Thiết lập thuộc tính min cho các trường datetime-local
                        document.getElementById("timeEnd").min = currentDateTime;
                    </script>

                    <label>8.Diện tích</label>
                    <input type="text"  id="area" name="area" placeholder="(m²)" required></br>
                    <script>
                        function validateArea() {
                            // Lấy giá trị diện tích từ trường input
                            var areaValue = document.getElementById("area").value;

                            // Chuyển đổi giá trị diện tích sang kiểu số
                            var areaNumber = parseFloat(areaValue);

                            // Kiểm tra nếu giá trị diện tích là lớn hơn 0
                            if (areaNumber <= 0 || isNaN(areaNumber)) {
                                // Hiển thị thông báo lỗi
                                alert("Diện tích phải lớn hơn 0");
                                // Ngăn chặn việc gửi form đi
                                return false;
                            }
                            // Cho phép gửi form đi nếu điều kiện hợp lệ
                            return true;
                        }
                    </script>

                    <label>9.Mô tả</label>
                    <input type= "text" id="detail" name="detail" placeholder="Nhập mô tả tài sản...">

                    <div>
                        <label>10. Hình ảnh</label><br>
                        <input type="file" title="Chọn Ảnh" name="image1"/>
                        <input type="file" title="Chọn Ảnh" name="image2"/> 
                        <input type="file" title="Chọn Ảnh" name="image3"/>
                    </div>

                    <button  type="submit" value="submitPost" name="action">
                        Đăng tin
                    </button>

                </form>

                <!--                <form action="MainController" method="post" class="formDangKy" enctype="multipart/form-data" >
                                    
                                    <input type="hidden" id="accID" name="accID" value="${sessionScope.member.accID}">
                                    <input type="hidden" id="priceLast" name="priceLast" value="">
                                    <input type="hidden" id="statusID" name="statusID" value="">
                                    <div class="form-group">
                                        <label for="tenTaiSan">0. ID</label>
                                        <input type="text" class="form-control" id="realEstateID" name="realEstateID" required>
                                    </div>
                                    <div class="form-group">
                                        <label for="tenTaiSan">1. Tên tài sản đấu giá</label>
                                        <input type="text" class="form-control" id="realEstateName" name="realEstateName" required>
                                    </div>
                
                                    <div class="form-group">
                                        <label for="diaChiTaiSan">2. Địa chỉ tài sản đấu giá</label>
                
                                        <div class="form-group1">
                                            <label for="diaChi">Đia chỉ</label>
                                            <input type="text" class="form-control" id="address" name="address" required>
                                        </div>
                                        <div class="form-group1">
                                            <label for="thanhPho">Tỉnh Thành</label>
                                            <select class="form-control" id="cityID" name="cityID" required>
                                                <option value="" disabled selected hidden>Thành phố</option>
                                                <option value="1">An Giang</option>
                                                <option value="2">Bà Rịa - Vũng Tàu</option>
                                                <option value="3">Bắc Giang</option>
                                                <option value="4">Bắc Kạn</option>
                                                <option value="5">Bạc Liêu</option>
                                                <option value="6">Bắc Ninh</option>
                                                <option value="7">Bến Tre</option>
                                                <option value="8">Bình Định</option>
                                                <option value="9">Bình Bương</option>
                                                <option value="10">Bình Phước</option>
                                                <option value="11">Bình Thuận</option>
                                                <option value="12">Cà Mau</option>
                                                <option value="13">Cao Bằng</option>
                                                <option value="14">Cần Thơ</option>
                                                <option value="15">Đà Nẵng</option>
                                                <option value="16">Đắk Lắk</option>
                                                <option value="17">Đắk Nông</option>
                                                <option value="18">Điện Biên</option>
                                                <option value="19">Đồng Nai</option>
                                                <option value="20">Đồng Tháp</option>
                                                <option value="21">Gia Lai</option>
                                                <option value="22">Hà Giang</option>
                                                <option value="23">Hà Nam</option>
                                                <option value="24">Hà Tĩnh</option>
                                                <option value="25">Hà Nội</option>
                                                <option value="26">Hải Dương</option>
                                                <option value="27">Hải Phòng</option>
                                                <option value="28">Hậu Giang</option>
                                                <option value="29">Hòa Bình</option>
                                                <option value="30">Hưng Yên</option>
                                                <option value="31">Khánh Hòa</option>
                                                <option value="32">Kiên Giang</option>
                                                <option value="33">Kon Tum</option>
                                                <option value="34">Lai Châu</option>
                                                <option value="35">Lâm Đồng</option>
                                                <option value="36">Lạng Sơn</option>
                                                <option value="37">Lào Cai</option>
                                                <option value="38">Long An</option>
                                                <option value="39">Nam Định</option>
                                                <option value="40">Nghệ An</option>
                                                <option value="41">Ninh Bình</option>
                                                <option value="42">Ninh Thuận</option>
                                                <option value="43">Phú Thọ</option>
                                                <option value="44">Phú Yên</option>
                                                <option value="45">Quảng Bình</option>
                                                <option value="46">Quảng Nam</option>
                                                <option value="47">Quảng Ngãi</option>
                                                <option value="48">Quảng Ninh</option>
                                                <option value="49">Quảng Trị</option>
                                                <option value="50">Sóc Trăng</option>
                                                <option value="51">Sơn La</option>
                                                <option value="52">Tây Ninh</option>
                                                <option value="53">Thái Bình</option>
                                                <option value="54">Thái Nguyên</option>
                                                <option value="55">Thanh Hóa</option>
                                                <option value="56">Thừa Thiên Huế</option>
                                                <option value="57">Tiền Giang</option>
                                                <option value="58">Hồ Chí Minh</option>
                                                <option value="59">Trà Vinh</option>
                                                <option value="60">Tuyên Quang</option>
                                                <option value="61">Vĩnh Long</option>
                                                <option value="62">Vĩnh Phúc</option>
                                                <option value="63">Yên Bái</option>
                                            </select>
                                        </div>
                                    </div>
                
                                    <div class="form-group">
                                        <label for="giaTriTaiSan">3. Giá trị tài sản</label>
                                        <input type="text" class="form-control" id="priceFirst" name="priceFirst" placeholder="VNĐ" oninput="formatCurrency(this)" required>
                                    </div>
                
                                    <div class="form-group">
                                        <label for="thoiGianDangKy">4. Thời gian đăng ký đấu giá</label>
                                        <input type="datetime-local" class="form-control" id="timeStart" name="timeStart" required>
                                    </div>
                
                                    <div class="form-group">
                                        <label for="thoiGianBanDauGia">5. Thời gian bán đấu giá</label>
                                        <input type="datetime-local" class="form-control" id="timeEnd" name="timeEnd" required>
                                    </div>
                
                                    <div class="form-group">
                                        <label for="noiDungTaiSan">6. Nội dung tài sản</label>
                                        <div class="form-group1">
                                            <label for="loaTaiSan">Loại tài sản</label>
                                            <select id="loaiTaiSan" name="catID" >
                                                <option value="" disabled selected hidden>-- Chọn --</option>
                                                <option value="no">Nhà </option>
                                                <option value="dn">Đất </option>
                                                <option value="cc">Chung cư</option>
                                                <option value="bt">Biệt thự</option>
                                            </select>
                                        </div>
                
                                        <div class="form-group1">
                                            <label for="dienTichTaiSan">Diện tích </label>
                                            <input type="text" class="form-control1" id="diaChiTaiSan" name="area" placeholder="(m²)" required>
                
                                        </div>
                                        <div class="form-group1">
                                            <label for="diaChiTaiSan" >Mô tả</label>          
                                            <textarea id="detail" name="detail" rows="4" cols="50" class="form-control" placeholder="Nhập mô tả tài sản..."></textarea>
                                        </div>
                                    </div>
                
                                    <div class="form-group">
                                        <label for="hinhAnh"> Hình ảnh</label>
                                        <input type="file" name="image1">
                                        <input type="file" name="image2"> 
                                        <input type="file" name="image3">
                                    </div>
                
                                    <button type="submit" value="submitPost" name="action" class="submit-form">LƯU NỘI DUNG THÔNG TIN</button>
                                </form>-->
            </div>
        </div>
        <!-- END BODY -->

        <footer class="footer" style="position: inherit; margin-top: 30px"> 
            <div>
                <p class="footer_content1">CÔNG TY TNHH ĐẤU GIÁ BẤT ĐỘNG SẢN REAS</p>
                <div class="footer-container">
                    <div class="footer-left-content"> Liên hệ:<br/>
                        Email: reas@gmail.com<br/>
                        Điện thoại: +84 (24) 8888 9999<br/>
                        <br/>
                    </div>
                    <div class="footer-mid-content"> Trụ sở chính:<br/>
                        Lô E2a-7, Đường D1, Đ. D1, Long Thạnh Mỹ, Thành Phố Thủ Đức, Thành phố Hồ Chí Minh<br/>
                        <br/>
                    </div>
                    <img class="footer-right-content" src="image/bocongthuong.png" alt="" href="" width="100" height="28" />
                </div>
            </div>
        </footer>

        <script>
            function formatCurrency(input) {
                // Xóa các ký tự không phải số từ giá trị input
                let value = input.value.replace(/[^\d]/g, '');
                // Định dạng số thành chuỗi có dấu phẩy ngăn cách nghìn
                value = new Intl.NumberFormat().format(value);
                // Gán giá trị đã định dạng vào input
                input.value = value;
            }
        </script>
    </body>
</html>
