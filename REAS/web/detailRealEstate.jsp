<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>


<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>detailRealEstate</title>
        <link rel="icon" type="image/x-icon" href="image/logo.png">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bulma@0.9.4/css/bulma.min.css">
        <link rel="stylesheet" href="detailRealEstate.css" type="text/css" >
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




        <div class="columns">
            <div class="column is-two-thirds" style="padding-top: 30px;display: flex;justify-content: end;">

                <div class="container-full-left">
                    <!-- Container for the image gallery -->
                    <div class="container">

                        <!-- Full-width images with number text -->
                        <div class="mySlides">
                            <div class="numbertext">1 / 6</div>
                            <img src="image/img_woods_wide.png" style="width:100%">
                        </div>

                        <div class="mySlides">
                            <div class="numbertext">2 / 6</div>
                            <img src="image/img_5terre_wide.jpg" style="width:100%">
                        </div>

                        <div class="mySlides">
                            <div class="numbertext">3 / 6</div>
                            <img src="image/img_mountains_wide.jpg" style="width:100%">
                        </div>

                        <div class="mySlides">
                            <div class="numbertext">4 / 6</div>
                            <img src="image/img_lights_wide.jpg" style="width:100%">
                        </div>

                        <div class="mySlides">
                            <div class="numbertext">5 / 6</div>
                            <img src="image/img_nature_wide.jpg" style="width:100%">
                        </div>

                        <div class="mySlides">
                            <div class="numbertext">6 / 6</div>
                            <img src="image/img_snow_wide.jpg" style="width:100%">
                        </div>

                        <!-- Next and previous buttons -->
                        <a class="prev" onclick="plusSlides(-1)">&#10094;</a>
                        <a class="next" onclick="plusSlides(1)">&#10095;</a>

                        <!-- Image text -->
                        <div class="caption-container">
                            <p id="caption"></p>
                        </div>

                        <!-- Thumbnail images -->
                        <div class="row">
                            <div class="column">
                                <img class="demo cursor" src="image/img_woods_wide.jpg" style="width:100%; min-height: 100px" onclick="currentSlide(1)" alt="The Woods">
                            </div>
                            <div class="column">
                                <img class="demo cursor" src="image/img_5terre_wide.jpg" style="width:100%; min-height: 100px" onclick="currentSlide(2)" alt="Cinque Terre">
                            </div>
                            <div class="column">
                                <img class="demo cursor" src="image/img_mountains_wide.jpg" style="width:100%; min-height: 100px" onclick="currentSlide(3)" alt="Mountains and fjords">
                            </div>
                            <div class="column">
                                <img class="demo cursor" src="image/img_lights_wide.jpg" style="width:100%; min-height: 100px" onclick="currentSlide(4)" alt="Northern Lights">
                            </div>
                            <div class="column">
                                <img class="demo cursor" src="image/img_nature_wide.jpg" style="width:100%; min-height: 100px" onclick="currentSlide(5)" alt="Nature and sunrise">
                            </div>
                            <div class="column">
                                <img class="demo cursor" src="image/img_snow_wide.jpg" style="width:100%; min-height: 100px" onclick="currentSlide(6)" alt="Snowy Mountains">
                            </div>
                        </div>
                    </div>
                    <div class="container-full-bellow">
                        <h1 class="flex-center h1-text-mid">Dự án: The Landmark 81</h1>
                        <div class="columns">
                            <div class="column" style="padding: 1.2rem 2.75rem;">
                                <h1 class="flex-center h1-text-left-right">Thông tin bất động sản</h1>
                                <div style="padding-top: 8px;">
                                    <p class="bold-text">Diện tích: <span>55m²</span></p>
                                    <p class="bold-text">Loại hình: <span>căn hộ chung cư</span></p>
                                    <p class="bold-text">Địa chỉ: <span> Landmark 81, Đường Điện Biên Phủ, Phường 22, Bình Thạnh, Hồ Chí Minh.</span></p>
                                </div>
                            </div>
                             <div class="divider"></div>
                            <div class="column" style="padding: 1.2rem 2.75rem;">
                                <h1 class="flex-center h1-text-left-right">Thông tin đấu giá cơ bản</h1>
                                <div style="padding-top: 8px;">
                                    <p class="bold-text">Giá khởi điểm: <span>6,4Tỷ</span></p>
                                    <p class="bold-text">Bước giá: <span>50Triệu</span></p>
                                    <p class="bold-text">Thời gian bắt đầu đấu giá: </br><span>11:00AM- 03:00PM 12/01/2024.</span></p>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>


            </div>

            <div class="column" style="padding-top: 30px">
                <div class="container-full-right flex-center text-center">
                    <div>
                        <p class="h1-text-mid" style="color: #fff;">Đăng bởi<p>
                        <p style="color: #D9AB73;font-size: 20px">Trương Gia Bình<p>
                        <p style="color: #D9AB73;font-size: 20px">0888999xxx<p>
                    </div>
                </div>


                <div class="container-full-right-bellow">
                    <div>
                        <p class="flex-center text-center" style="color: #000;font-weight: bold;font-size: 26px !important;">Các bài đăng khác<p>
                        <div style="text-align: left; padding-left: 10px;">
                            <form action="MainController" method="post">
                                <button type="submit" value="rule" name="action" style="padding: 8px 10px;font-size: 16px">
                                    <span>Thảo Điền Pearl</span>
                                </button>
                            </form>
                            <form action="MainController" method="post">
                                <button type="submit" value="rule" name="action" style="padding: 8px 10px;font-size: 16px">
                                    <span>Hoàng Anh River View</span>
                                </button>
                            </form>
                            <form action="MainController" method="post">
                                <button type="submit" value="rule" name="action" style="padding: 8px 10px;font-size: 16px">
                                    <span>Thủ Thiêm Sky(5)</span>
                                </button>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>


        <footer class="footer" style="margin-top: 20px;position: initial"> 
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
            let slideIndex = 1;
            showSlides(slideIndex);

// Next/previous controls
            function plusSlides(n) {
                showSlides(slideIndex += n);
            }

// Thumbnail image controls
            function currentSlide(n) {
                showSlides(slideIndex = n);
            }

            function showSlides(n) {
                let i;
                let slides = document.getElementsByClassName("mySlides");
                let dots = document.getElementsByClassName("demo");
                let captionText = document.getElementById("caption");
                if (n > slides.length) {
                    slideIndex = 1
                }
                if (n < 1) {
                    slideIndex = slides.length
                }
                for (i = 0; i < slides.length; i++) {
                    slides[i].style.display = "none";
                }
                for (i = 0; i < dots.length; i++) {
                    dots[i].className = dots[i].className.replace(" active", "");
                }
                slides[slideIndex - 1].style.display = "block";
                dots[slideIndex - 1].className += " active";
                captionText.innerHTML = dots[slideIndex - 1].alt;
            }
        </script>
    </body>
</html>