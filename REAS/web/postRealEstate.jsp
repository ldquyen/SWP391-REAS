<%-- 
    Document   : postRealEstate
    Created on : Jan 22, 2024, 11:24:00 PM
    Author     : ADMIN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
                                    <span>DS ĐẤU GIÁ</span>
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
                                        <button type="submit" value="aboutus" name="action">
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


                <form action="xulydangky.jsp" method="post" class="formDangKy" >

                    <div class="form-group">
                        <label for="tenTaiSan">1. Tên tài sản đấu giá</label>
                        <input type="text" class="form-control" id="tenTaiSan" name="tenTaiSan" required>
                    </div>

                    <div class="form-group">
                        <label for="diaChiTaiSan">2. Địa chỉ tài sản đấu giá</label>

                        <div class="form-group1">
                            <label for="diaChi">Đia chỉ</label>
                            <input type="text" class="form-control" id="diaChi" name="diaChi" required>
                        </div>
                        <div class="form-group1">
                            <label for="thanhPho">Tỉnh Thành</label>
                            <select class="form-control" id="tinhThanh" name="tinhThanh" required>
                                <option value="" disabled selected hidden>-- Chọn tỉnh/thành phố --</option>
                            </select>
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="giaTriTaiSan">3. Giá trị tài sản</label>

                        <input type="text" class="form-control" id="giaTriTaiSan" name="giaTriTaiSan" placeholder="VNĐ" oninput="formatCurrency(this)" required>
                    </div>

                    <div class="form-group">
                        <label for="thoiGianDangKy">4. Thời gian đăng ký đấu giá</label>
                        <input type="datetime-local" class="form-control" id="thoiGianDangKy" name="thoiGianDangKy" required>
                    </div>

                    <div class="form-group">
                        <label for="thoiGianBanDauGia">5. Thời gian bán đấu giá</label>
                        <input type="datetime-local" class="form-control" id="thoiGianBanDauGia" name="thoiGianBanDauGia" required>
                    </div>

                    

                    <div class="form-group">
                        <label for="noiDungTaiSan">6. Nội dung tài sản</label>
                        <div class="form-group1">
                            <label for="loaTaiSan">Loại tài sản</label>
                            <select id="loaiTaiSan" name="loaiTaiSan" >
                                <option value="" disabled selected hidden>-- Chọn --</option>
                                <option value="nhaDat">Nhà </option>
                                <option value="nhaDat">Đất </option>
                                <option value="chungCu">Chung cư</option>
                                <option value="bietThu">Biệt thự</option>
                            </select>
                        </div>

                        <div class="form-group1">
                            <label for="dienTichTaiSan">Diện tích (m²)</label>
                            <input type="text" class="form-control1" id="diaChiTaiSan" name="length" placeholder="Dài" required>
                            <input type="text" class="form-control1" id="diaChiTaiSan" name="width" placeholder="Rộng" required>
                        </div>
                        <div class="form-group1">
                            <label for="diaChiTaiSan" >Mô tả</label>          
                            <textarea id="moTaTaiSan" name="moTaTaiSan" rows="4" cols="50" class="form-control" placeholder="Nhập mô tả tài sản..."></textarea>
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="hinhAnh">7. Hình ảnh</label>
                        <input type="file" id="hinhAnh" name="hinhAnh[]" accept="image/*" multiple required>
                    </div>

                    <button type="submit" value="Submit" name="action" class="submit-form">LƯU NỘI DUNG THÔNG TIN</button>

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
        <script>
            document.addEventListener("DOMContentLoaded", function () {
                // Fetch data from your JSON file
                fetch('./City.json')
                        .then(response => response.json())
                        .then(data => {
                            // Populate the dropdown with fetched data
                            const tinhThanhDropdown = document.getElementById('tinhThanh');

                            data.provinces.forEach(provinces => {
                                const option = document.createElement('option');
                                option.value = provinces.id;
                                option.text = provinces.province_name;
                                tinhThanhDropdown.appendChild(option);
                            });
                        })
                        .catch(error => console.error('Error fetching data:', error));
            });
        </script> 
   
    </body>
</html>
