<%-- 
    Document   : index
    Created on : Jan 17, 2024, 11:02:09 PM
    Author     : ASUS
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="i" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Index Page</title>
        <link rel="icon" type="image/x-icon" href="image/logo.png">
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
        <c:forEach items="${requestScope.list}" var="item">
            <div>
                <img src="${pageContext.request.contextPath}/${item.image.getImageLink1()}" alt="none"/>
                <p>${item.realEstateName}</p>
                <p>${item.priceNow}</p>
            </div>
        </c:forEach>
        <c:forEach begin="1" end="${requestScope.totalPage}" var="item">
            <a href="${pageContext.request.contextPath}/home?pagenum=${item}">${item}</a>
        </c:forEach>
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
    </body>
</html>