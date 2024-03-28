<%-- 
    Document   : naptien
    Created on : Mar 14, 2024, 6:48:26 PM
    Author     : ADMIN
--%>

<%@page import="dao.WalletDAO"%>
<%@page import="dto.Wallet"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Nap tien Page</title>
        <link rel="icon" type="image/x-icon" href="image/logo.png">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bulma@0.9.4/css/bulma.min.css">
        <link rel="stylesheet" href="style.css" type="text/css" >
        <link rel="stylesheet" href="postRealEstate.css" type="text/css" >
        <style>
            /* Style cho form */

            .form-post-real-estate {
                width: 700px; /* Điều chỉnh chiều rộng form */
                margin: 0 auto;
                padding: 30px;
                background-color: #D9D9D9;
                border-radius: 5px;
                box-shadow: 0 0 10px rgba(0, 0, 0, 0.2); /* Đổ bóng cho form */
                font-family: Arial, sans-serif;
            }

            /* Style cho tiêu đề */
            .TieuDe h1 {
                text-align: center;
                color: #333;
                margin-bottom: 20px;
                font-size: 40px; /* Kích thước font chữ */
                font-weight: bold; /* Chữ in đậm */
            }

            /* Style cho label */
            label {
                font-weight: bold;
                font-size: 20px;
                margin-bottom: 5px;
                display: block; 
            }
            .form-post-real-estate ::placeholder {
                font-size: 16;
                color: #333;
                font-style: normal;
            }

            /* Style cho input và select */
            input[type="text"],
            input[type="datetime-local"],
            select,option {
                width: 100%;
                padding: 10px;
                border: 2px solid #ccc;
                border-radius: 4px;
                box-sizing: border-box;
                margin-bottom: 15px;
                margin-left: 0px;
                font-size: 14px;
                resize: vertical;

            }

            .form-container textarea {
                width: 100%;
                padding: 10px;
                border: 1px solid #ccc;
                border-radius: 4px;
                box-sizing: border-box;
                margin-bottom: 15px;
                font-size: 14px;
                resize: vertical; /* Cho phép resize theo chiều dọc */
            }

            /* Style cho nút submit */
            button.btn-submit {
                text-align: center;
                display: block;
                margin: 0 auto;
                background-color: #000; 
                color: white;
                padding: 15px 24px;
                border: none;
                border-radius: 4px;
                cursor: pointer;
                font-size: 20px;
                font-weight: bold;
                transition: background-color 0.3s ease;
                margin-top: 20px;
            }

            button.btn-submit:hover {
                background-color: #D9AB73; /* Màu đậm hơn khi di chuột qua */
            }

            input[type="file"] {
                width: 200px;
                display: inline-block;
                padding: 8px 12px;
                background-color: #f2f2f2;
                border: 2px solid #ccc;
                border-radius: 4px;
                cursor: pointer;
                font-size: 16px;
                color: #333;
                transition: background-color 0.3s ease;

            }

            input[type="file"]:hover {
                background-color: #e6e6e6;
                border: 2px solid #ccc;
            }

            input[type="file"]:focus {
                outline: none;
                box-shadow: 0 0 5px rgba(0, 0, 0, 0.3);
                border: 2px solid #ccc;
            }

            .checkbox-container {
                display: flex;
                align-items: center;
                justify-content: center; /* Căn giữa theo chiều ngang */
                margin-top: 10px; /* Khoảng cách từ checkbox và label đến các trường form */
            }

            .checkbox-container input[type="checkbox"] {
                margin-right: 10px; /* Khoảng cách giữa checkbox và label */
            }

            .checkbox-container label {
                font-size: 16px; /* Kích thước font chữ */
                color: #333; /* Màu chữ */
            }

            .form-control {
                border: 2px solid #ccc;
                display: block;
                width: 100%;
                padding: .375rem .75rem;
                font-size: 1rem;
                font-weight: 400;
                line-height: 1.5;
                color: var(--bs-body-color);
                -webkit-appearance: none;
                -moz-appearance: none;
                appearance: none;
                background-color: #ffffff;
                background-clip: padding-box;
                border: var(--bs-border-width) solid var(--bs-border-color);
                border-radius: var(--bs-border-radius);
                transition: border-color .15s ease-in-out, box-shadow .15s ease-in-out;
            }
            textarea {
                resize: vertical;
                min-height: calc(1.5em + .75rem + calc(var(--bs-border-width)* 2));
                border: 2px solid #ccc;
            }
            div {
                display: block;
            }
            option{
                font-size: 16px;
            }
            .square-box {
                width: 450px; /* Độ rộng của ô vuông */
                height: 50px; /* Chiều cao của ô vuông */
                border: 1px solid #ccc; /* Đường viền của ô vuông */
                display: flex; /* Sử dụng flexbox để căn giữa nội dung */
                align-items: center; /* Căn giữa theo chiều dọc */
                justify-content: center; /* Căn giữa theo chiều ngang */
                border: 2px solid red;
                font-size: 20px;
                font-weight: bold;
                margin-left: 100px;
            }
        </style>
        <script>
            // Hàm hiển thị cửa sổ thông báo
            function showErrorMessage(message) {
                alert(message);
            }
            // Kiểm tra và hiển thị thông báo nếu có
            <c:if test="${not empty requestScope.Nap_Success}">
            showErrorMessage("${requestScope.Nap_Success}");
            </c:if>
            <c:if test="${not empty requestScope.Nap_Unsuccess}">
            showErrorMessage("${requestScope.Nap_Unsuccess}");
            </c:if>
            <c:if test="${not empty requestScope.Wrong_Price}">
            showErrorMessage("${requestScope.Wrong_Price}");
            </c:if>
        </script>
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
                        <form action="MainController" method="post">
                            <button class="navbar-1" type="submit" value="naptien" name="action">
                                <span>NẠP TIỀN</span>
                            </button>
                        </form>
                    </div>
                    <%
                        List<Wallet> wallet = new WalletDAO().getWallet();
                        pageContext.setAttribute("walletAccount", wallet);
                    %>
                    <div class="navbar-container-1">
                        <a class="navbar-1">SỐ DƯ :
                            <c:forEach var="wallet" items="${walletAccount}">
                                <c:if test="${wallet.accID eq member.accID}">
                                    <span class="list-auction-p-1">${wallet.accountBalance}</span>
                                </c:if>
                            </c:forEach>
                            (xu)
                        </a>                  
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
                                <form action="MemberController" method="post">
                                    <button type="submit" value="mypost" name="action">
                                        <input type="hidden" value="${sessionScope.member.accID}" name="mypostID">
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
                                    <button type="submit" value="lichsunaptien" name="action">
                                        <span>Lịch sử nạp tiền</span>
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
    <%--========================================================--%>
    <!-- BODY -->
    <div class="BodyForm">
        <div class="TieuDe">
            <h1>
                Nạp Tiền
            </h1>
        </div>

        <div class="form-post-real-estate" >
            <form action="MainController" method="post" enctype="multipart/form-data">
                <input type="hidden" id="accID" name="accID" value="${sessionScope.member.accID}">
                <c:forEach var="wallet" items="${walletAccount}">
                    <c:if test="${wallet.accID eq member.accID}">
                        <input type="hidden" id="accID" name="walletID" value="${wallet.walletID}">
                    </c:if>
                </c:forEach>
                <div class="form-element">
                    <label>1. Nhập số Xu
                        <span style="font-size: 14px; color: red; margin-top: 5px;" >Lưu ý : 1 Xu = 1.000.000 VNĐ</span>
                    </label>
                    <input type="text" class="form-control" id="soTien" name="soTien" placeholder="Xu" oninput="formatCurrency(updateMoney(this.value))" required>
                    <span id="moneyMessage" style="font-size: 14px; color: red; margin-top: 5px;"></span>
                </div>
                <div class="form-element">
                    <label>2. Cú pháp chuyển khoản</label>
                    <div class="square-box">
                        <h3 style="text-align: center">"TÊN TÀI KHOẢN"_ORDER_"SỐ XU NẠP"</h3>
                    </div>
                </div>
                <div class="form-element">
                    <label>3. Mã giao dịch </label>
                    <input type="text" class="form-control" id="orderID" name="orderID" placeholder="Điền mã giao dịch" required>
                </div>
                <div class="checkbox-container">
                    <input type="checkbox" id="agreeCheckbox" required>
                    <label for="agreeCheckbox">Tôi hoàn toàn chịu trách nhiệm với những sai sót của mình!</label>
                </div>
                <button type="submit" value="submitNaptien" name="action" class="btn-submit">
                    Xác nhận
                </button>
            </form>
        </div>

    </div>
    <!-- END BODY -->

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
                <img class="footer-right-content" src="image/logofu.png" alt="" href="" width="100" height="28" />
            </div>
        </div>
    </footer>
</body>
<script>

    function formatCurrency(input) {
        // Hàm định dạng số tiền sang dạng chuỗi có định dạng tiền tệ
        var value = input.value.replace(/[^\d]/g, '');

        // Định dạng giá trị thành chuỗi có dấu phân cách hàng nghìn
        var formattedValue = new Intl.NumberFormat().format(value);

        // Gán giá trị định dạng vào trường input
        input.value = formattedValue;
    }

</script>
<script>
    function updateMoney(xu) {
        // Tính số tiền tương ứng với số xu
        var tien = xu * 1000000;

        // Hiển thị thông báo về tỷ lệ đổi
        var message = " ";
        document.getElementById("moneyMessage").innerText = message;

        // Hiển thị số tiền tương ứng
        if (!isNaN(tien)) {
            document.getElementById("moneyMessage").innerText += " => " + tien.toLocaleString('vi-VN') + " VNĐ";
        } else {
            document.getElementById("moneyMessage").innerText = "Số xu không hợp lệ";
        }
    }
</script>
</html>
