<%-- 
    Document   : index
    Created on : Jan 17, 2024, 11:02:09 PM
    Author     : ASUS
--%>

<%@page import="dto.UserGoogle"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Real Estate Auction System</title>
        <link rel="icon" type="image/x-icon" href="image/logo.png">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bulma@0.9.4/css/bulma.min.css">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/swiper@11/swiper-bundle.min.css" />
        <link rel="stylesheet" href="style.css" type="text/css" >
    </head>
    <body>
        <nav class="navbar" role="navigation" aria-label="main navigation">
            <a class="navbar-item">
                <form action="MainController" method="post">
                    <button type="submit" value="homeindex_1" name="action">
                        <img class="logo-header" src="image/logo.png" alt="" href="" width="100" height="28" />
                    </button>
                </form>
            </a>
            <a role="button" class="navbar-burger" aria-label="menu" aria-expanded="false" data-target="navbarBasicExample">
                <span aria-hidden="true"></span>
                <span aria-hidden="true"></span>
                <span aria-hidden="true"></span>
            </a>
        </div>

        <div id="navbarBasicExample" class="navbar-menu">
            <div class="navbar-start">
                <a class="navbar-item">
                    <form action="MainController" method="post">
                        <button type="submit" value="homeindex_1" name="action">
                            <span>TRANG CHỦ</span>
                        </button>
                    </form>
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
                        <input class="input" type="text" name="txtName" placeholder="Nhập bất động sản yêu thích" value="${requestScope.name}">
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
                            <select class="custom-select" name="loaihinhbds">
                                <option value="">Loại hình bất động sản</option>
                                <option value="cc"<c:if test="${loaihinhbds eq 'cc'}">selected</c:if>>Chung cư</option>
                                <option value="bt"<c:if test="${loaihinhbds eq 'bt'}">selected</c:if>>Biệt thự</option>
                                <option value="dn"<c:if test="${loaihinhbds eq 'dn'}">selected</c:if>>Đất nền</option>
                                <option value="no"<c:if test="${loaihinhbds eq 'no'}">selected</c:if>>Nhà ở</option>
                                </select>
                            </div>
                            <div class="select">
                                <select class="custom-select" name="thanhpho">
                                    <option value="">Thành phố</option>
                                    <option value="1" <c:if test="${thanhpho eq '1'}">selected</c:if>>An Giang</option>
                                <option value="2" <c:if test="${thanhpho eq '2'}">selected</c:if>>Bà Rịa - Vũng Tàu</option>
                                <option value="3" <c:if test="${thanhpho eq '3'}">selected</c:if>>Bắc Giang</option>
                                <option value="4" <c:if test="${thanhpho eq '4'}">selected</c:if>>Bắc Kạn</option>
                                <option value="5" <c:if test="${thanhpho eq '5'}">selected</c:if>>Bạc Liêu</option>
                                <option value="6" <c:if test="${thanhpho eq '6'}">selected</c:if>>Bắc Ninh</option>
                                <option value="7" <c:if test="${thanhpho eq '7'}">selected</c:if>>Bến Tre</option>
                                <option value="8" <c:if test="${thanhpho eq '8'}">selected</c:if>>Bình Định</option>
                                <option value="9" <c:if test="${thanhpho eq '9'}">selected</c:if>>Bình Bương</option>
                                <option value="10" <c:if test="${thanhpho eq '10'}">selected</c:if>>Bình Phước</option>
                                <option value="11" <c:if test="${thanhpho eq '11'}">selected</c:if>>Bình Thuận</option>
                                <option value="12" <c:if test="${thanhpho eq '12'}">selected</c:if>>Cà Mau</option>
                                <option value="13" <c:if test="${thanhpho eq '13'}">selected</c:if>>Cao Bằng</option>
                                <option value="14" <c:if test="${thanhpho eq '14'}">selected</c:if>>Cần Thơ</option>
                                <option value="15" <c:if test="${thanhpho eq '15'}">selected</c:if>>Đà Nẵng</option>
                                <option value="16" <c:if test="${thanhpho eq '16'}">selected</c:if>>Đắk Lắk</option>
                                <option value="17" <c:if test="${thanhpho eq '17'}">selected</c:if>>Đắk Nông</option>
                                <option value="18" <c:if test="${thanhpho eq '18'}">selected</c:if>>Điện Biên</option>
                                <option value="19" <c:if test="${thanhpho eq '19'}">selected</c:if>>Đồng Nai</option>
                                <option value="20" <c:if test="${thanhpho eq '20'}">selected</c:if>>Đồng Tháp</option>
                                <option value="21" <c:if test="${thanhpho eq '21'}">selected</c:if>>Gia Lai</option>
                                <option value="22" <c:if test="${thanhpho eq '22'}">selected</c:if>>Hà Giang</option>
                                <option value="23" <c:if test="${thanhpho eq '23'}">selected</c:if>>Hà Nam</option>
                                <option value="24" <c:if test="${thanhpho eq '24'}">selected</c:if>>Hà Tĩnh</option>
                                <option value="25" <c:if test="${thanhpho eq '25'}">selected</c:if>>Hà Nội</option>
                                <option value="26" <c:if test="${thanhpho eq '26'}">selected</c:if>>Hải Dương</option>
                                <option value="27" <c:if test="${thanhpho eq '27'}">selected</c:if>>Hải Phòng</option>
                                <option value="28" <c:if test="${thanhpho eq '28'}">selected</c:if>>Hậu Giang</option>
                                <option value="29" <c:if test="${thanhpho eq '29'}">selected</c:if>>Hòa Bình</option>
                                <option value="30" <c:if test="${thanhpho eq '30'}">selected</c:if>>Hưng Yên</option>
                                <option value="31" <c:if test="${thanhpho eq '31'}">selected</c:if>>Khánh Hòa</option>
                                <option value="32" <c:if test="${thanhpho eq '32'}">selected</c:if>>Kiên Giang</option>
                                <option value="33" <c:if test="${thanhpho eq '33'}">selected</c:if>>Kon Tum</option>
                                <option value="34" <c:if test="${thanhpho eq '34'}">selected</c:if>>Lai Châu</option>
                                <option value="35" <c:if test="${thanhpho eq '35'}">selected</c:if>>Lâm Đồng</option>
                                <option value="36" <c:if test="${thanhpho eq '36'}">selected</c:if>>Lạng Sơn</option>
                                <option value="37" <c:if test="${thanhpho eq '37'}">selected</c:if>>Lào Cai</option>
                                <option value="38" <c:if test="${thanhpho eq '38'}">selected</c:if>>Long An</option>
                                <option value="39" <c:if test="${thanhpho eq '39'}">selected</c:if>>Nam Định</option>
                                <option value="40" <c:if test="${thanhpho eq '40'}">selected</c:if>>Nghệ An</option>
                                <option value="41" <c:if test="${thanhpho eq '41'}">selected</c:if>>Ninh Bình</option>
                                <option value="42" <c:if test="${thanhpho eq '42'}">selected</c:if>>Ninh Thuận</option>
                                <option value="43" <c:if test="${thanhpho eq '43'}">selected</c:if>>Phú Thọ</option>
                                <option value="44" <c:if test="${thanhpho eq '44'}">selected</c:if>>Phú Yên</option>
                                <option value="45" <c:if test="${thanhpho eq '45'}">selected</c:if>>Quảng Bình</option>
                                <option value="46" <c:if test="${thanhpho eq '46'}">selected</c:if>>Quảng Nam</option>
                                <option value="47" <c:if test="${thanhpho eq '47'}">selected</c:if>>Quảng Ngãi</option>
                                <option value="48" <c:if test="${thanhpho eq '48'}">selected</c:if>>Quảng Ninh</option>
                                <option value="49" <c:if test="${thanhpho eq '49'}">selected</c:if>>Quảng Trị</option>
                                <option value="50" <c:if test="${thanhpho eq '50'}">selected</c:if>>Sóc Trăng</option>
                                <option value="51" <c:if test="${thanhpho eq '51'}">selected</c:if>>Sơn La</option>
                                <option value="52" <c:if test="${thanhpho eq '52'}">selected</c:if>>Tây Ninh</option>
                                <option value="53" <c:if test="${thanhpho eq '53'}">selected</c:if>>Thái Bình</option>
                                <option value="54" <c:if test="${thanhpho eq '54'}">selected</c:if>>Thái Nguyên</option>
                                <option value="55" <c:if test="${thanhpho eq '55'}">selected</c:if>>Thanh Hóa</option>
                                <option value="56" <c:if test="${thanhpho eq '56'}">selected</c:if>>Thừa Thiên Huế</option>
                                <option value="57" <c:if test="${thanhpho eq '57'}">selected</c:if>>Tiền Giang</option>
                                <option value="58" <c:if test="${thanhpho eq '58'}">selected</c:if>>TP Hồ Chí Minh</option>
                                <option value="59" <c:if test="${thanhpho eq '59'}">selected</c:if>>Trà Vinh</option>
                                <option value="60" <c:if test="${thanhpho eq '60'}">selected</c:if>>Tuyên Quang</option>
                                <option value="61" <c:if test="${thanhpho eq '61'}">selected</c:if>>Vĩnh Long</option>
                                <option value="62" <c:if test="${thanhpho eq '62'}">selected</c:if>>Vĩnh Phúc</option>
                                <option value="63" <c:if test="${thanhpho eq '63'}">selected</c:if>>Yên Bái</option>

                                </select>
                            </div>
                            <div class="select">
                                <select class="custom-select" name="dientich">
                                    <option value="">Diện tích</option>
                                    <option value="100" <c:if test="${dientich eq '100'}">selected</c:if>>0-100 m2</option>
                                    <option value="500" <c:if test="${dientich eq '500'}">selected</c:if>>100-500 m2</option>
                                    <option value="1000" <c:if test="${dientich eq '1000'}">selected</c:if>>500-1000 m2</option>
                                    <option value="1001" <c:if test="${dientich eq '1001'}">selected</c:if>>Trên 1000 m2</option>
                                </select>
                            </div>
                            <div class="select">
                                <select class="custom-select" name="mucgia">
                                    <option value="">Mức giá</option>
                                    <option value="5" <c:if test="${mucgia eq '5'}">selected</c:if>>0-5 tỷ</option>
                                    <option value="10" <c:if test="${mucgia eq '10'}">selected</c:if>>5-10 tỷ</option>
                                    <option value="50" <c:if test="${mucgia eq '50'}">selected</c:if>>10-50 tỷ</option>
                                    <option value="100" <c:if test="${mucgia eq '100'}">selected</c:if>>50-100 tỷ</option>
                                    <option value="101" <c:if test="${mucgia eq '101'}">selected</c:if>>Trên 100 tỷ</option>
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

        <div class="swiper postElstate-container">
            <div class="swiper-wrapper postElstate-list">
            <c:forEach items="${list}" var="item">
                <div class=" realestate-items swiper-slide"> 
                    <h1>${item.imageLink1}</h1>
                    <c:forEach var="img" items="${listImg}">
                        <c:if test="${img.imageFolderID eq item.imageFolderID}"> <img class="img-home-page" src="data:image/jpeg;base64,${fn:escapeXml(img.base64Image1)}" alt="Image"></c:if>
                    </c:forEach>
                    <a href="MainController?action=viewPostRealEstate&id=${item.realEstateID}">

                        <div class="text-home-container">
                            <p class="text-home-1 timeUp">
                                ${item.timeUp}
                            </p>
                            <p class="text-home-2">
                                ${item.realEstateName} - <span>
                                    <c:forEach var="cityList" items="${requestScope.city}"> 
                                        <c:if test="${cityList.cityID eq item.cityID}">
                                            ${cityList.cityName}
                                        </c:if>
                                    </c:forEach>
                                </span>
                            </p>

                            <p class="text-home-2">
                                ${item.address}
                            </p>
                            <p class="text-home-3">
                                <script>
                                    var number = ${item.priceFirst}; // Assuming auctions.lamda contains the number
                                    var formattedNumber = number.toLocaleString('en-US').replace(/,/g, '.');
                                    document.write(formattedNumber);
                                </script> VND
                                <%--  <fmt:formatNumber type="currency" value="${item.priceFirst}" /> vnd --%>
                            </p>
                        </div>
                    </a>
                </div>

            </c:forEach>
        </div>
    </div>
    <div class="swiper-pagination pagination-style"></div>
    <div class="swiper-button-prev swiper-navBtn"></div>
    <div class="swiper-button-next swiper-navBtn"></div>

    <footer class="footer" style="position: initial"> 
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
</body>
<script src="https://cdn.jsdelivr.net/npm/swiper@11/swiper-bundle.min.js"></script>
<script>
                                    const swiper = new Swiper('.swiper', {
                                        slidesPerView: 4,
                                        spaceBetween: 25,
                                        // loop: true,
                                        centeredSlide: 'true',
                                        direction: 'horizontal',
                                        fade: 'true',
                                        grabCursor: 'true',
                                        pagination: {
                                            clickable: true,
                                            renderBullet: function (index, className) {
                                                return '<span class="' + className + '">' + (index + 1) + "</span>";
                                            },
                                            el: '.swiper-pagination',
                                        },
                                        navigation: {
                                            nextEl: '.swiper-button-next',
                                            prevEl: '.swiper-button-prev',
                                        },

                                        scrollbar: {
                                            el: '.swiper-scrollbar',
                                        },

                                        breakpoints: {
                                            0: {
                                                slidesPerView: 1,
                                            },
                                            520: {
                                                slidesPerView: 2,
                                            },
                                            950: {
                                                slidesPerView: 3,
                                            },
                                            1024: {
                                                slidesPerView: 4,
                                            }
                                        }
                                    });
</script>

<script>
    document.addEventListener("DOMContentLoaded", function () {
        var timeUpElements = document.querySelectorAll(".timeUp");

        timeUpElements.forEach(function (element) {
            // Format start time
            var startTime = new Date(element.innerText);
            var formattedStartTime = formatTime(startTime);

            // Update the HTML with the formatted time
            element.innerText = formattedStartTime;
        });
    });

    // Function to format the time
    function formatTime(time) {
        var year = time.getFullYear();
        var month = padZero(time.getMonth() + 1);
        var date = padZero(time.getDate());
        var hours = padZero(time.getHours());
        var minutes = padZero(time.getMinutes());
        var seconds = padZero(time.getSeconds());
        var formattedTime = year + "-" + month + "-" + date + " " + hours + ":" + minutes + ":" + seconds;
        return formattedTime;
    }

    // Function to pad zero to single digit numbers
    function padZero(number) {
        return number < 10 ? '0' + number : number;
    }
</script>
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
//
//
//            // Check if there is text inside the streamText element
//            if (streamText.textContent.trim().length > 0) {
//                // Add the stream_text-container class to the container
//                streamContainer.classList.add('stream_text-container-2');
//            }
//
//            // Listen for the end of the animation
//            streamText.addEventListener('animationend', function () {
//                // Remove the background color class from the container
//                streamContainer.classList.remove('stream_text-container-2');
//            });

</script>
</html>
