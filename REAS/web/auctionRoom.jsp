<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>


<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Danh sách đấu giá</title>
        <link rel="icon" type="image/x-icon" href="image/logo.png">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bulma@0.9.4/css/bulma.min.css">
        <link rel="stylesheet" href="auctionRoom.css" type="text/css" >
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
            <div class="column is-two-thirds"style="padding-top: 30px">
                <div class="register-modal-container">
                    <div class="img-auction-room-container">
                        <img class="img-real-auction-room" src="image/auctionroom1.png" alt="auctionroom1" />
                        <img class="img-real-auction-room" src="image/auctionroom2.png" alt="auctionroom2" />
                    </div>
                    <h1 class="text-auction-room-h1">The Marq - TPHCM - 500 m2</h1>
                    <div class="text-auction-room-container">
                        <p>Giá khởi điểm: 50 tỷ 200 triệu đồng</p>
                        <p>Loại hình: Chung cư</p>
                        <p>Địa chỉ: 123 đường ABCXYZ, quận 1, TPHCM</p>
                        <p>Mô tả: ....</p>
                    </div>
                </div>
                <div style="width: 100%; display: flex; justify-content: center">
                    <div class="list-auction-p-container" style="">
                        <p class="list-auction-p-1">Đấu giá viên: Trương Gia Bình</p>
                        <p class="list-auction-p-2">00:15:32</p>
                    </div>
                </div>
            </div>
            <div class="column" style="padding-top: 30px">
                <div class="register-modal-container">
                    <h1 style="font-size: 22px; padding: 4px 0px;">Diễn biến cuộc đấu giá</h1>
                    <div class="number-price-container">
                        <p style="color: #D9AB73; font-size: 22px">50.300.000.000 Đ</p>
                        <p>50.250.000.000 Đ</p>
                        <p>50.215.000.000 Đ</p>
                        <p>50.205.000.000 Đ</p>
                        <p>50.200.000.000 Đ</p>
                    </div>
                </div>

                <div class="register-modal-container" style="margin-top: 25px">
                    <h1 style="font-size: 20px; padding: 4px 0px;color: #D9AB73;font-weight: bold;">Giá hiện tại: 50.300.000.000 Đ</h1>
                    <div class="number-price-container number-price-container-bellow">
                        <p class="number-price-bellow-1">15.000.000</p>
                        <p class="number-price-bellow-2">X</p>
                        <p id="quantity-field">
                            <button id="down" onclick="setQuantity('down');" style="color: #fff">-</button>
                            <input type="text" id="quantity" value="1" style="background-color: #000; color: #fff;width: 50%; border: 3px #fff solid;padding: 2px 10px;font-family: Inter;
                                   font-size: 20px;
                                   font-style: normal;
                                   font-weight: 400;
                                   line-height: normal;
                                   text-align: center">
                            <button id="up" onclick="setQuantity('up');" style="color: #fff">+</button>
                        </p>
                    </div>
                    <div style="display: flex; justify-content: center">
                        <h1  style="display: flex;justify-content: center;font-size: 20px; padding: 4px 0px;color: #D9AB73;font-weight: bold;border: 3px #D9AB73 solid;width: 75%;margin-top: 8px">
                            Trả giá:  <p id="total-price"></p></h1>
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
            function setQuantity(upordown) {
                var quantity = document.getElementById('quantity');

                if (quantity.value > 1) {
                    if (upordown == 'up') {
                        ++document.getElementById('quantity').value;
                    } else if (upordown == 'down') {
                        --document.getElementById('quantity').value;
                    }
                } else if (quantity.value == 1) {
                    if (upordown == 'up') {
                        ++document.getElementById('quantity').value;
                    }
                } else
                {
                    document.getElementById('quantity').value = 1;
                }
            }
        </script>

        <script>
            // Function to update the total price based on quantity
            function updateTotalPrice() {
                var quantity = parseInt(document.getElementById('quantity').value);
                var pricePerUnit = parseFloat(document.querySelector('.number-price-bellow-1').innerText.replace(/\./g, '').replace(',', '.'));
                var totalPrice = quantity * pricePerUnit;
                document.getElementById('total-price').innerText = totalPrice.toLocaleString('vi-VN') + ' Đ';
            }

// Initialize total price based on default quantity and price per unit
            updateTotalPrice();

// Function to handle quantity changes
            function setQuantity(action) {
                var quantityElement = document.getElementById('quantity');
                var quantity = parseInt(quantityElement.value);

                if (action === 'up') {
                    quantity += 1;
                } else if (action === 'down' && quantity > 1) {
                    quantity -= 1;
                }

                quantityElement.value = quantity;

                // Update total price based on the new quantity
                updateTotalPrice();
            }
        </script>
    </body>
</html>