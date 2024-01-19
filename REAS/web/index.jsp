<%-- 
    Document   : index
    Created on : Jan 17, 2024, 11:02:09 PM
    Author     : ASUS
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bulma@0.9.4/css/bulma.min.css">
        <link rel="stylesheet" href="style.css" type="text/css" >
    </head>
    <body>
        <nav class="navbar" role="navigation" aria-label="main navigation">
            <div class="navbar-brand">
                <a class="navbar-item" href="https://bulma.io">
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
                        VỀ CHÚNG TÔI
                    </a>

                    <a class="navbar-item">
                        NỘI QUY
                    </a>
                </div>

                <div class="navbar-end">
                    <div class="navbar-item">
                        <div class="buttons" >
                            <a class="button is-light">
                                <strong>ĐĂNG NHẬP</strong>
                            </a>
                            <a class="button is-light">
                                <strong>ĐĂNG KÝ</strong>
                            </a>
                        </div>
                    </div>
                </div>
            </div>
        </nav>


        <!-- BODY -->
        <div class="search-container">
            <div class="search-wrap">
                <div class="field has-addons">
                    <div class="control search-bar">
                        <input class="input" type="text" placeholder="Nhập bất động sản yêu thích">
                    </div>
                    <div class="control button-search-container">
                        <a class="button is-info button-search">
                            Tìm kiếm
                        </a>
                    </div>
                </div>
                <div class="search-detail-container">
                    <div class="control">
                        <div class="select">
                            <select>
                                <option>Loại hình bất động sản</option>
                                <option>Chung cư</option>
                                <option>Biệt thự</option>
                                <option>Nhà đất</option>
                                <option>Condotel</option>
                            </select>
                        </div>
                        <div class="select">
                            <select>
                                <option>Thành phố</option>
                                <option>With options</option>
                            </select>
                        </div>
                        <div class="select">
                            <select>
                                <option>Diện tích</option>
                                <option>0-100 m2</option>
                                <option>100-500 m2</option>
                                <option>500-1000 m2</option>
                                <option>Trên 1000 m2</option>
                            </select>
                        </div>
                        <div class="select">
                            <select>
                                <option>Mức giá</option>
                                <option>0-5 tỷ</option>
                                <option>5-10 tỷ</option>
                                <option>10-50 tỷ</option>
                                <option>50-100 tỷ</option>
                                <option>Trên 100 tỷ</option>
                            </select>
                        </div>
                    </div>
                    <div class="realestate-quantity">
                        <p>Hiện có 99 dự án</p>
                    </div>
                </div>
            </div>
        </div>

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
