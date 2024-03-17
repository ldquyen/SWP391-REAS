
<%@page import="dto.Wallet"%>
<%@page import="dao.WalletDAO"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Real Estate Auction System</title>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bulma@0.9.4/css/bulma.min.css">
        <link rel="stylesheet" href="style.css" type="text/css" >
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    </head>
    <body>
        <nav class="navbar" role="navigation" aria-label="main navigation">
            <div class="navbar-brand">
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

        <!-- BODY -->


        <c:if test="${not empty sessionScope.member.password }">
            <c:set var="m" value="${sessionScope.member}"></c:set>
                <div style="background-color: black; border-radius: 40px;padding: 20px; text-align: center; border: 6px solid #D9AB73; color: #D9AB73; position: fixed; top: 45%; left: 50%; transform: translate(-50%, -50%);">
                    <form  style="text-align: center;display: inline-block"  action="MemberController" method="post">
                        <h1 style="font-weight: bold; margin-bottom: 5px; font-size: 20px">THÔNG BÁO ĐẤU GIÁ</h1>          
                    <c:forEach var="REGETBYID" items="${requestScope.REGETBYID}">
                        <p class="bold-text-2">Dự án: <span>
                                ${REGETBYID.realEstateName}
                            </span></p>
                        <p class="bold-text-2">Người trúng đấu giá: <span></span></p>
                        <p class="bold-text-2">Số điện thoại người bán: <span></span></p>
                        <p class="bold-text-2">Trạng thái đấu giá: <span></span></p>
                        <p class="bold-text-2">Giá trúng đấu giá: <span>
                                <script>
                                    var number = ${REGETBYID.priceLast}; // Assuming auctions.lamda contains the number
                                    var formattedNumber = number.toLocaleString('en-US').replace(/,/g, '.');
                                    document.write(formattedNumber);
                                </script> VND
                            </span></p>
                        <p class="bold-text-2">Đánh giá</p>
                    </c:forEach>

                    <%--
            
            
                    --%>

                    <input type="hidden" name="accidmember" value="${m.accID}">

                </form>
                <form action="MemberController" method="post">
                    <div class="rating" style="color: #fff;margin-bottom: 10px;">
                        <span class="fa fa-star star-vote" onclick="setRating(1)"></span>
                        <span class="fa fa-star star-vote" onclick="setRating(2)"></span>
                        <span class="fa fa-star star-vote" onclick="setRating(3)"></span>
                        <span class="fa fa-star star-vote" onclick="setRating(4)"></span>
                        <span class="fa fa-star star-vote" onclick="setRating(5)"></span>
                    </div>
                    <c:if test="${not empty auctions}">
                        <c:forEach var="REGETBYID" items="${requestScope.REGETBYID}">
                            <c:forEach var="auctions" items="${requestScope.auctions}"> 
                                <c:if test="${auctions.realEstateID eq REGETBYID.realEstateID}">
                                    <input type="hidden" name="auctionIDfeedback" value="${auctions.realEstateID}">
                                </c:if>
                            </c:forEach>
                        </c:forEach>
                    </c:if>
                    <input type="hidden" name="rating" id="rating" value="">
                    <input type="hidden" value="${sessionScope.member.accID}" name="feedbackaccID">
                    <div class="control">
                        <textarea name="feedbacktext" style="border: 3px solid #D9AB73; background-color: #000; color: #fff; font-size: 16px;" class="textarea is-small" placeholder="Giới hạn 250 kí tự." placeholderstyle="color: red;"></textarea>
                    </div>
                    <button type="submit" value="feedbackServlet" name="action" style="border: 5px solid #D9AB73; color: #D9AB73;border-radius: 40px; font-size: 18px;margin-top: 10px;padding: 5px 62px;font-weight: bold;">
                        <span>QUAY VỀ TRANG CHỦ</span><br>
                    </button>
                </form>
            </div>
        </c:if>

        <c:if test="${not empty auctions}">
            <c:forEach var="auctionwinningresult" items="${requestScope.auctionwinningresult}">
                <c:forEach var="auctions" items="${requestScope.auctions}"> 
                    <c:if test="${auctions.realEstateID eq REGETBYID.realEstateID}">
                        <script>
                            var number = ${auctions.lamda}; // Assuming auctions.lamda contains the number
                            var formattedNumber = number.toLocaleString('en-US').replace(/,/g, '.');
                            document.write(formattedNumber);
                        </script>
                    </c:if>
                </c:forEach>
            </c:forEach>
        </c:if>

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
            function setRating(rating) {
                const stars = document.querySelectorAll('.fa-star');
                stars.forEach((star, index) => {
                    if (index < rating) {
                        star.classList.add('checked');
                    } else {
                        star.classList.remove('checked');
                    }
                });
                document.getElementById('rating').value = rating;
                console.log("Đã chọn " + rating + " sao");
            }
        </script>

    </body>
</html>
