
<%-- 
    Document   : index
    Created on : Jan 17, 2024, 11:02:09 PM
    Author     : ASUS
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="i" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Index Page</title>
        <link rel="icon" type="image/x-icon" href="image/logo.png">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bulma@0.9.4/css/bulma.min.css">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/swiper@11/swiper-bundle.min.css" />
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bulma@0.9.4/css/bulma.min.css">
        <link rel="stylesheet" href="style.css" type="text/css" >
    </head>
    <body>
        <nav class="navbar" role="navigation" aria-label="main navigation">
            <div class="navbar-brand">
                <a class="navbar-item" href="index.jsp">
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
                    <a class="navbar-item">
                        TRANG CHỦ
                    </a>

                    <a class="navbar-item">
                        <form action="MainController" method="post">
                            <button type="submit" value="DN" name="action">
                                <span>TIN TỨC</span>
                            </button>
                        </form>
                    </a>

                    <a class="navbar-item">
                        <form action="MainController" method="post">
                            <button type="submit" value="DN" name="action">
                                <span>NỘI QUY</span>
                            </button>
                        </form>
                    </a>
                </div>

                <div class="navbar-end">
                    <div class="navbar-item">
                        <div class="buttons" >
                            <form action="MainController" method="post">
                                <button class="button is-light" type="submit" value="DN" name="action">
                                    <span>ĐĂNG NHẬP</span>
                                </button>
                            </form>
                            <form action="MainController" method="post">
                                <button class="button is-light" type="submit" value="DK" name="action">
                                    <span>ĐĂNG KÝ</span>
                                </button>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </nav>


        <!-- BODY -->
        <form action="MainController" method="post">
            <div class="search-container">
                <div class="search-wrap">
                    <div class="field has-addons">
                        <div class="control search-bar">
                            <input class="input" type="text" name="nameRealEstate" placeholder="Nhập bất động sản yêu thích">
                        </div>
                        <div class="control button-search-container">
                            <button class="button is-info button-search" type="submit" value="DN" name="action">
                                TÌM KIẾM
                            </button>
                        </div>
                    </div>
                    <div class="search-detail-container">
                        <div class="control">
                            <div class="select">
                                <select class="custom-select">
                                    <option>Loại hình bất động sản</option>
                                    <option>...</option>
                                </select>
                            </div>
                            <div class="select">
                                <select class="custom-select">
                                    <option>Thành phố</option>
                                    <option>...</option>
                                </select>
                            </div>
                            <div class="select">
                                <select class="custom-select">
                                    <option>Diện tích</option>
                                    <option>...</option>
                                </select>
                            </div>
                            <div class="select">
                                <select class="custom-select">
                                    <option>Mức giá</option>
                                    <option>...</option>
                                </select>
                            </div>
                        </div>
                        <div class="realestate-quantity">
                            <p>Hiện có ... dự án</p>
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
                                <c:if test="${img.imageFolderID eq item.imageFolderID}"> <img src="data:image/jpeg;base64,${fn:escapeXml(img.base64Image1)}" alt="Image"></c:if>
                                
                            </c:forEach>
                            <a href="MainController?action=viewPostRealEstate&id=${item.realEstateID}">

                            <div class="text-home-container">
                                <p class="text-home-1">
                                    ${item.timeUp}
                                </p>
                                <p class="text-home-2">
                                    ${item.realEstateName}
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

        <!-- If we need scrollbar -->
        <!-- <div class="swiper-scrollbar"></div> -->

        <!--        <div class="columns">
                    <div class="column column-home-real">
                        <img src="image/homereallestate.png" style="display: flex;" alt="none"/>
                        <div class="text-home-container">
                            <p class="text-home-1">30/01/2024-22:00</p>
                            <p class="text-home-2">Sala-TPHCM</p>
                            <p class="text-home-3">28 tỷ 930 triệu</p>
                        </div>
                    </div>
                    <div class="column column-home-real column-home-real-2">
                        <img src="image/homereal2.png" style="display: flex;" alt="none"/>
                        <div class="text-home-container">
                            <p class="text-home-1">30/01/2024-22:00</p>
                            <p class="text-home-2">Grand Marina-TPHCM</p>
                            <p class="text-home-3">30 tỷ 500 triệu</p>
                        </div>
                    </div>
                    <div class="column column-home-real">
                        <img src="image/homereallestate.png" style="display: flex;" alt="none"/>
                        <div class="text-home-container">
                            <p class="text-home-1">30/01/2024-22:00</p>
                            <p class="text-home-2">Sala-TPHCM</p>
                            <p class="text-home-3">28 tỷ 930 triệu</p>
                        </div>
                    </div>
                    <div class="column column-home-real">
                        <img src="image/homereal2.png" style="display: flex;" alt="none"/>
                        <div class="text-home-container">
                            <p class="text-home-1">30/01/2024-22:00</p>
                            <p class="text-home-2">Grand Marina-TPHCM</p>
                            <p class="text-home-3">30 tỷ 500 triệu</p>
                        </div>
                    </div>
                </div>-->


        <footer class="footer" style="position: fixed; bottom: 0; left: 0; right: 0"> 
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
</html>

