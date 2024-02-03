<%-- 
    Document   : rule
    Created on : Jan 19, 2024, 11:38:53 AM
    Author     : ASUS
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Real Estate Auction System</title>
        <link rel="icon" type="image/x-icon" href="image/logo.png">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bulma@0.9.4/css/bulma.min.css">
        <link rel="stylesheet" href="style.css" type="text/css" >
        <style>
            body {
                background-image: url(image/rulebg.png);
                background-size: cover;
                background-position: center;
                background-repeat: no-repeat;
                margin: 0; 
                padding: 0; 
            }
        </style>
    </head>
    <body>
        <nav class="navbar" role="navigation" aria-label="main navigation">
            <div class="navbar-brand">
                <a class="navbar-item" href="index_1.jsp">
                    <img class="logo-header" src="image/logo.png" alt="" href="#" width="100" height="28" />
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

        <h1 style="text-align: center; font-size: 36px; color: #D9AB73; margin-top: 30px ;">NỘI QUY</h1>
        <h2 style="text-align: center; font-size: 24px; color: #D9AB73;">CHƯƠNG I</h2>
        <h3 style="text-align: center; color: #D9AB73;"> NHỮNG QUY ĐỊNH CHUNG</h3>
        <p style="margin-left: 20px; font-weight: bold; color: white">Điều 1. Đối tượng áp dụng</p>
        <p style="margin-left: 35px; color: white">
            1. Công ty đấu giá bất động sản (REAS), đấu giá viên được lựa chọn để đấu giá bất động sản.<br>
            2. Tổ chức, cá nhân tham gia đấu giá.<br>
            3. Cơ quan, tổ chức, cá nhân khác có liên quan đến hoạt động đấu giá bất động sản.<br>
        </p>

        <p style="margin-left: 20px; font-weight: bold; color: white">Điều 2. Nguyên tắc hoạt động </p>
        <p style="margin-left: 35px; color: white">
            1. Tuân thủ theo quy định của Nghị quyết của Quốc hội, Nghị định của Chính phủ và các văn bản pháp luật có liên quan.<br>
            2. Bảo mật về tài khoản truy cập, thông tin về người tham gia đấu giá và các thông tin khác.<br>
            3. Bảo đảm tính khách quan, minh bạch, an toàn, an ninh.<br>
            4. Bảo vệ quyền và lợi ích hợp pháp của đơn vị có tài sản, người tham gia đấu giá và cá nhân, tổ chức có liên quan.<br>
            5. Cuộc đấu giá trực tuyến bất động sản phải do đấu giá viên được phân công điều hành.<br>
        </p>


        <p style="margin-left: 20px; font-weight: bold; color: white">Điều 3. Giải thích từ ngữ</p>
        <p style="margin-left: 35px; color: white">
            1. Người tham gia đấu giá là tổ chức, cá nhân người Việt Nam có đủ điều kiện tham gia đấu giá theo quy định của pháp luật.<br>
            2. Công ty đấu giá bất động sản REAS là tổ chức đấu giá tài sản có đủ năng lực, điều kiện tổ chức đấu giá và đấu giá trực tuyến được cơ quan có thẩm quyền cấp phép hoạt động.<br>
            4. Ban quản trị là Trung tâm quản trị và phát triển hệ thống thuộc Công ty - Đơn vị chuyên trách quản lý Trang thông tin đấu giá trực tuyến.<br>
            5. Người trúng đấu giá là người tham gia đấu giá trực tuyến bất động sản có mức trả giá cao nhất so với giá khởi điểm hoặc bằng giá khởi điểm theo quy định tại Điều 5 Nghị quyết số 73/2022/QH15.<br>
            6. Cuộc đấu giá bất động sản là toàn bộ quá trình đấu giá đối với một bất động sản.<br>
            7. Phiên đấu giá bất động sản tô bao gồm các cuộc đấu giá bất động sản được tổ chức thực hiện trong một kế hoạch đấu giá đã được phê duyệt.<br>
            8. Tiền trúng đấu giá không bao gồm lệ phí đăng ký bất động sản.<br>
            9. Giờ hoạt động trên trang Thông tin đấu giá trực tuyến được tính theo múi giờ số 7 theo hệ thống múi giờ quốc tế (GMT+7).<br>
            10. Đồng tiền sử dụng trong mọi hoạt động giao dịch là Việt Nam đồng.<br>
        </p>


        <p style="margin-left: 20px; font-weight: bold; color: white">Điều 4. Quyền tiếp cận thông tin đối với Trang thông tin đấu giá trực tuyến biển số.</p>
        <p style="margin-left: 35px; color: white">
            1. Khách hàng truy cập Trang thông tin đấu giá trực tuyến để tham khảo các thông tin về Công ty, bất động sản đưa ra đấu giá, thông tin của đơn vị có tài sản công khai theo quy định.<br>
            2. Khách hàng đã đăng ký tài khoản đăng nhập vào hệ thống có quyền:<br>
            - Tiếp cận, tham khảo thông tin về bất động sản đã, đang và sắp tổ chức đấu giá;<br>
            - Đăng ký tham gia đấu giá nộp tiền hồ sơ, tiền đặt trước, tham gia đấu giá theo thời gian quy định;<br>
            - Tra cứu lịch sử tham gia đấu giá của mình;<br>
            - Yêu cầu chỉnh sửa dữ liệu cá nhân trừ trường hợp pháp luật có quy định khác.<br>
            - Được tiếp cận tài liệu hướng dẫn sử dụng, trên Trang thông tin đấu giá trực tuyến REAS.<br>
        </p>

        <h2 style="text-align: center; font-size: 24px; color: #D9AB73;">CHƯƠNG II</h2>
        <h3 style="text-align: center; color: #D9AB73;">TRÌNH TỰ, THỦ TỤC ĐẤU GIÁ BẤT ĐỘNG SẢN</h3>


        <p style="margin-left: 20px; font-weight: bold; color: white">Điều 5. Trình tự thực hiện phiên đấu giá bất động sản bằng hình thức đấu giá trực tuyến.</p>
        <p style="margin-left: 35px; color: white">
            1. Trong thời hạn ít nhất 30 ngày trước ngày tổ chức phiên đấu giá, Công ty thông báo công khai danh sách bất động sản đưa ra đấu giá trên Cổng thông tin điện tử quốc gia về đấu giá tài sản, Trang thông tin đấu giá trực tuyến và niêm yết tại trụ sở. Quy chế đấu giá phải được niêm yết, thông báo công khai trên Trang thông tin đấu giá trực tuyến, trụ sở của Công ty.<br>
            2. Khi đăng ký tham gia đấu giá, người tham gia đấu giá được cấp một tài khoản truy cập, được hướng dẫn về cách sử dụng tài khoản, cách trả giá và các nội dung khác trên Trang thông tin đấu giá trực tuyến để thực hiện việc đấu giá.<br>
            3. Người tham gia đấu giá truy cập vào Trang thông tin đấu giá trực tuyến bằng tài khoản truy cập của mình và thực hiện thủ tục đấu giá theo Quy chế đấu giá.<br>
            4. Tại thời điểm kết thúc cuộc đấu giá trực tuyến, Trang thông tin đấu giá trực tuyến xác định người trúng đấu giá, thông báo kết quả cuộc đấu giá, hiển thị biên bản đấu giá để người trúng đấu giá xác nhận, gửi vào hòm thư điện tử của người tham gia đấu giá đã đăng ký với Công ty.<br>
            5. Đấu giá viên chịu trách nhiệm điều hành cuộc đấu giá trực tuyến, xác thực vào biên bản đấu giá bằng chữ ký số để gửi cho người trúng đấu giá.<br>
        </p>


        <p style="margin-left: 20px; font-weight: bold; color: white">Điều 6. Thông báo kết quả đấu giá trực tuyến bất động sản</p>
        <p style="margin-left: 35px ; color: white">
            1.  Trang thông tin đấu giá trực tuyến biển số thông báo kết quả trúng đấu giá cho người trúng đấu giá ngay sau khi có kết quả đấu giá trực tuyến bất động sản.<br>    
            2. Thông báo kết quả trúng đấu giá:  <br>
            - Thông báo kết quả trúng đấu giá bất động sản vào hòm thư điện tử đã đăng ký tại tài khoản truy cập cho người trúng đấu giá ngay sau khi phê duyệt kết quả đấu giá; thông báo kết quả trúng đấu giá bất động sản thay thế hợp đồng mua bán tài sản đấu giá hoặc hợp đồng bán tài sản nhà nước.<br>
            - Nội dung thông báo kết quả trúng đấu giá gồm: bất động sản trúng đấu giá, tên, mã định danh của cá nhân, tổ chức (trường hợp tổ chức chưa được cấp mã định danh thì ghi mã số thuế hoặc số quyết định thành lập tổ chức), địa chỉ người trúng đấu giá, giá trúng đấu giá, việc huỷ kết quả đấu giá nếu không nộp đủ số tiền trúng đấu giá theo quy định.<br>
        </p>


        <p style="margin-left: 20px; font-weight: bold; color: white"> Điều 7. Biên bản cuộc đấu giá trực tuyến bất động sản</p>
        <p style="margin-left: 35px; color: white">
            1. Biên bản cuộc đấu giá trực tuyến phải ghi nhận thời điểm bắt đầu tiến hành đấu giá, thời điểm kết thúc cuộc đấu giá, số người tham gia đấu giá, giá trúng đấu giá, người trúng đấu giá. Diễn biến của cuộc đấu giá được hệ thống đấu giá trực tuyến ghi nhận phải được trích xuất, có xác nhận của Công ty và đính kèm biên bản đấu giá.<br>
            2. Biên bản cuộc đấu giá phải được lập tại thời điểm kết thúc việc trả giá. Đấu giá viên chịu trách nhiệm tổ chức thực hiện cuộc đấu giá trực tuyến.<br>
            3. Biên bản cuộc đấu giá được gửi cho khách hàng trúng đấu giá vào hòm thư điện tử và trong mục “Lịch sử đấu giá”. Trường hợp khách hàng trúng đấu giá không xác nhận biên bản cuộc đấu giá thì coi như không chấp nhận giao kết hợp đồng mua bán tài sản đấu giá và sẽ bị hủy kết quả đấu giá. <br>
        </p>



        <h2 style="text-align: center; font-size: 24px; color: #D9AB73;">CHƯƠNG III</h2>
        <h3 style="text-align: center; color: #D9AB73;">QUY TRÌNH THANH TOÁN</h3>


        <p style="margin-left: 20px; font-weight: bold; color: white">Điều 8. Quy trình thanh toán</p>
        <p style="margin-left: 35px; color: white">
            1. Người đăng ký tham gia đấu giá trực tuyến bất động sản thanh toán tiền hồ sơ, tiền đặt trước tham gia đấu giá tài sản theo đúng quy định của pháp luật. <br>
            - Khách hàng thanh toán tiền hồ sơ, tiền đặt trước bằng hình thức chuyển tiền vào tài khoản Công ty theo quy định tại Quy chế đấu giá.<br>
            - Nội dung chuyển tiền: Cụ thể đối với từng khách hàng trong trường thông tin Nội dung chuyển khoản ghi "Họ và Tên người chuyển khoản".<br>
            - Số tiền thanh toán: Cụ thể đối với từng khách hàng trong trường thông tin Số tiền .<br>
            Lưu ý:<br>
            - Khách hàng bắt buộc chuyển đúng, đủ, không chỉnh sửa, không thay đổi nội dung chuyển khoản và số tiền thanh toán bất động sản.<br>
            - Đối với các trường hợp ghi sai nội dung chuyển khoản và không đúng, đủ số tiền thanh toán, khách hàng không nhận được mã đấu giá hoặc sau thời điểm chuyển tiền, khách hàng không nhận được mã đấu giá thì khách hàng liên hệ tổ chức đấu giá để được xem xét, giải quyết trước thời điểm tổ chức đấu giá 03 ngày. <br>
            - Mọi chi phí phát sinh trong việc chuyển, nhận lại tiền đặt trước do khách hàng chi trả.<br>
        </p>


        <p style="margin-left: 20px; font-weight: bold; color: white"> Điều 9. Phương thức hoàn trả tiền đặt trước</p>
        <p style="margin-left: 35px; color: white">
            1. Đối với khách hàng tham gia đấu giá mà không trúng đấu giá và không vi phạm Quy chế đấu giá sẽ được hoàn trả khoản tiền đặt trước trong thời hạn 03 ngày làm việc kể từ ngày kết thúc cuộc đấu giá. <br>
            2. Tiền đặt trước sẽ được hoàn trả vào tài khoản mà khách hàng đã đăng ký trên Trang thông tin đấu giá trực tuyến. Khách hàng tự chịu trách nhiệm về thông tin tài khoản nhận lại tiền đặt trước và tự chịu mọi chi phí liên quan đến giao dịch khoản tiền đặt trước. Công ty không hoàn trả lại tiền đặt trước cho bất kỳ tài khoản nào khác, ngoài tài khoản khách hàng đã đăng ký với Công ty. <br>
        </p>

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
    </body>
</html>
