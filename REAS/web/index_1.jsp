<%-- 
    Document   : index
    Created on : Jan 17, 2024, 11:02:09 PM
    Author     : ASUS
--%>

<%@page import="dto.UserGoogle"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Real Estate Auction System</title>
        <link rel="icon" type="image/x-icon" href="image/logo.png">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bulma@0.9.4/css/bulma.min.css">
        <link rel="stylesheet" href="style.css" type="text/css" >
    </head>
    <body>
        <nav class="navbar" role="navigation" aria-label="main navigation">
            <div class="navbar-brand">
                <a class="navbar-item" href="index_1.jsp">
                    <img class="logo-header" src="image/logo.png" alt="" href="index.jsp" width="100" height="28" />
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
                                        <button type="submit" value="Logout" name="action">
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

        <div class="stream_text-container" id="streamContainer">
            <div class="stream_text" id="streamText">Biệt thự khu đô thị Sala đã trúng đấu giá với giá tiền 30 tỷ đồng</div>
        </div>

        <!-- BODY -->
        <form action="MainController" method="post">
            <div class="search-container">
                <div class="search-wrap">
                    <div class="field has-addons">
                        <div class="control search-bar">
                            <input class="input" type="text" placeholder="Nhập bất động sản yêu thích">
                        </div>
                        <div class="control button-search-container">
                            <button class="button is-info button-search" type="submit" value="searchRealEstate" name="action">
                                TÌM KIẾM
                            </button>
                        </div>
                    </div>
                    <div class="search-detail-container">
                        <div class="control">
                            <div class="select">
                                <select class="custom-select">
                                    <option value="nonecategory">Loại hình bất động sản</option>
                                    <option value="cc">Chung cư</option>
                                    <option value="bt">Biệt thự</option>
                                    <option value="nd">Nhà đất</option>
                                    <option value="cdt">Condotel</option>
                                </select>
                            </div>
                            <div class="select">
                                <select class="custom-select">
                                    <option value="0">Thành phố</option>
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
                            <div class="select">
                                <select class="custom-select">
                                    <option value="nonearea">Diện tích</option>
                                    <option value="100m2">0-100 m2</option>
                                    <option value="500m2">100-500 m2</option>
                                    <option value="1000m2">500-1000 m2</option>
                                    <option value="1001m2">Trên 1000 m2</option>
                                </select>
                            </div>
                            <div class="select">
                                <select class="custom-select">
                                    <option value="noneprice">Mức giá</option>
                                    <option value="5">0-5 tỷ</option>
                                    <option value="10">5-10 tỷ</option>
                                    <option value="50">10-50 tỷ</option>
                                    <option value="100">50-100 tỷ</option>
                                    <option value="101">Trên 100 tỷ</option>
                                </select>
                            </div>
                        </div>
                        <div class="realestate-quantity">
                            <p>Hiện có 99 dự án</p>
                        </div>
                    </div>
                </div>
            </div>
        </form>

        <footer class="footer"> 
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
            // Get the element with the ID 'streamText'
            const streamText = document.getElementById('streamText');
            const streamContainer = document.getElementById('streamContainer');

// Check if the element was found

            // If the element exists, calculate its width
            const textWidth = streamText.offsetWidth; // Độ dài của văn bản

            // Calculate animation duration based on text width
            const animationDuration = (textWidth / 100) * 0.5; // 100 pixels/second

            // Apply the animation duration to the 'stream_text' class
            streamText.style.animationDuration = animationDuration + 's';


            // Check if there is text inside the streamText element
            if (streamText.textContent.trim().length > 0) {
                // Add the stream_text-container class to the container
                streamContainer.classList.add('stream_text-container-2');
            }

            // Listen for the end of the animation
            streamText.addEventListener('animationend', function () {
                // Remove the background color class from the container
                streamContainer.classList.remove('stream_text-container-2');
            });

        </script>
    </body>
</html>
