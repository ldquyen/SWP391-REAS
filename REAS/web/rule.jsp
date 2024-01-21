<%-- 
    Document   : rule
    Created on : Jan 19, 2024, 11:38:53 AM
    Author     : ASUS
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Real Estate Auction System</title>
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
                        <form action="MainController" method="post">
                            <button type="submit" value="aboutus" name="action">
                                <span>VỀ CHÚNG TÔI</span>
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
                                USERNAME
                            </a>
                            <div class="fake-div"></div>

                            <div class="navbar-dropdown">
                                <a class="navbar-item">
                                    <form action="MainController" method="post">
                                        <button type="submit" value="aboutus" name="action">
                                            <span>Thông tin tài khoản</span>
                                        </button>
                                    </form>
                                </a>
                                <a class="navbar-item">
                                    <form action="MainController" method="post">
                                        <button type="submit" value="aboutus" name="action">
                                            <span>Danh mục yêu thích</span>
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
                                        <button type="submit" value="aboutus" name="action">
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
                                        <button type="submit" value="aboutus" name="action">
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

        <h1>NỘI QUY</h1>
        <h2>CHƯƠNG I</h2>
        <h3> NHỮNG QUY ĐỊNH CHUNG</h3>
        <p>Điều 1. Đối tượng áp dụng</p>
        <p>
            1. Công ty đấu giá bất động sản (REAS), đấu giá viên được lựa chọn để đấu giá bất động sản.<br>
            2. Tổ chức, cá nhân tham gia đấu giá.<br>
            3. Cơ quan, tổ chức, cá nhân khác có liên quan đến hoạt động đấu giá bất động sản.<br>
        </p>

        <p>Điều 2. Nguyên tắc hoạt động </p>
        <p>
            1. Tuân thủ theo quy định của Nghị quyết của Quốc hội, Nghị định của Chính phủ và các văn bản pháp luật có liên quan.<br>
            2. Bảo mật về tài khoản truy cập, thông tin về người tham gia đấu giá và các thông tin khác.<br>
            3. Bảo đảm tính khách quan, minh bạch, an toàn, an ninh.<br>
            4. Bảo vệ quyền và lợi ích hợp pháp của đơn vị có tài sản, người tham gia đấu giá và cá nhân, tổ chức có liên quan.<br>
            5. Cuộc đấu giá trực tuyến bất động sản phải do đấu giá viên được phân công điều hành.<br>
        </p>


        <p>Điều 3. Giải thích từ ngữ</p>
        <p>
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


        <p>Điều 4. Quyền tiếp cận thông tin đối với Trang thông tin đấu giá trực tuyến biển số.</p>
        1. Khách hàng truy cập Trang thông tin đấu giá trực tuyến để tham khảo các thông tin về Công ty, bất động sản đưa ra đấu giá, thông tin của đơn vị có tài sản công khai theo quy định.<br>
        2. Khách hàng đã đăng ký tài khoản đăng nhập vào hệ thống có quyền:<br>
        - Tiếp cận, tham khảo thông tin về bất động sản đã, đang và sắp tổ chức đấu giá;<br>
        - Đăng ký tham gia đấu giá nộp tiền hồ sơ, tiền đặt trước, tham gia đấu giá theo thời gian quy định;<br>
        - Tra cứu lịch sử tham gia đấu giá của mình;<br>
        - Yêu cầu chỉnh sửa dữ liệu cá nhân trừ trường hợp pháp luật có quy định khác.<br>
        - Được tiếp cận tài liệu hướng dẫn sử dụng, trên Trang thông tin đấu giá trực tuyến REAS.<br>

        CHƯƠNG II
        TRÌNH TỰ, THỦ TỤC ĐẤU GIÁ BIỂN SỐ XE Ô TÔ


        Điều 5. Trình tự thực hiện phiên đấu giá biển số xe ô tô bằng hình thức đấu giá trực tuyến.
        1. Trong thời hạn ít nhất 30 ngày trước ngày tổ chức phiên đấu giá, Công ty thông báo công khai danh sách biển số xe ô tô đưa ra đấu giá trên Cổng thông tin điện tử quốc gia về đấu giá tài sản, Trang thông tin đấu giá trực tuyến và niêm yết tại trụ sở. Quy chế đấu giá phải được niêm yết, thông báo công khai trên Trang thông tin đấu giá trực tuyến, trụ sở của Công ty.
        2. Khi đăng ký tham gia đấu giá, người tham gia đấu giá được cấp một tài khoản truy cập, được hướng dẫn về cách sử dụng tài khoản, cách trả giá và các nội dung khác trên Trang thông tin đấu giá trực tuyến để thực hiện việc đấu giá.
        3. Người tham gia đấu giá truy cập vào Trang thông tin đấu giá trực tuyến bằng tài khoản truy cập của mình và thực hiện thủ tục đấu giá theo Quy chế đấu giá.
        4. Tại thời điểm kết thúc cuộc đấu giá trực tuyến, Trang thông tin đấu giá trực tuyến xác định người trúng đấu giá, thông báo kết quả cuộc đấu giá, hiển thị biên bản đấu giá để người trúng đấu giá xác nhận, gửi vào hòm thư điện tử của người tham gia đấu giá đã đăng ký với Công ty.
        5. Đấu giá viên chịu trách nhiệm điều hành cuộc đấu giá trực tuyến, xác thực vào biên bản đấu giá bằng chữ ký số để gửi cho người trúng đấu giá.


        Điều 6. Thông báo kết quả đấu giá trực tuyến biển số xe ô tô
        1.  Trang thông tin đấu giá trực tuyến biển số thông báo kết quả trúng đấu giá cho người trúng đấu giá ngay sau khi có kết quả đấu giá trực tuyến biển số xe ô tô.
        2. Trong thời hạn 07 ngày làm việc kể từ ngày nhận được kết quả đấu giá, biên bản đấu giá, danh sách người trúng đấu giá từ Công ty, Cục Cảnh sát giao thông - Bộ Công an ban hành văn bản phê duyệt kết quả đấu giá.
        3. Thông báo kết quả trúng đấu giá:  
        - Cục Cảnh sát giao thông - Bộ Công an thông báo kết quả trúng đấu giá biển số xe ô tô vào hòm thư điện tử và gửi tin nhắn thông báo tới số điện thoại đã đăng ký tại tài khoản truy cập cho người trúng đấu giá ngay sau khi phê duyệt kết quả đấu giá; thông báo kết quả trúng đấu giá biển số xe ô tô thay thế hợp đồng mua bán tài sản đấu giá hoặc hợp đồng bán tài sản nhà nước.
        - Nội dung thông báo kết quả trúng đấu giá gồm: Biển số xe ô tô trúng đấu giá, tên, mã định danh của cá nhân, tổ chức (trường hợp tổ chức chưa được cấp mã định danh thì ghi mã số thuế hoặc số quyết định thành lập tổ chức), địa chỉ người trúng đấu giá, giá trúng đấu giá, số tiền phải nộp, số tài khoản chuyên thu do Bộ Công an mở tại ngân hàng, chi nhánh ngân hàng nước ngoài để nộp tiền trúng đấu giá, thời hạn nộp tiền trúng đấu giá, việc huỷ kết quả đấu giá nếu không nộp đủ số tiền trúng đấu giá theo quy định.


        Điều 7. Biên bản cuộc đấu giá trực tuyến biển số xe ô tô
        1. Biên bản cuộc đấu giá trực tuyến phải ghi nhận thời điểm bắt đầu tiến hành đấu giá, thời điểm kết thúc cuộc đấu giá, số người tham gia đấu giá, giá trúng đấu giá, người trúng đấu giá. Diễn biến của cuộc đấu giá được hệ thống đấu giá trực tuyến ghi nhận phải được trích xuất, có xác nhận của Công ty và đính kèm biên bản đấu giá.
        2. Biên bản cuộc đấu giá phải được lập tại thời điểm kết thúc việc trả giá. Đấu giá viên chịu trách nhiệm tổ chức thực hiện cuộc đấu giá trực tuyến, xác thực vào biên bản cuộc đấu giá bằng chữ ký số để gửi cho người trúng đấu giá.
        3. Biên bản cuộc đấu giá được gửi cho khách hàng trúng đấu giá vào hòm thư điện tử và trong mục “Tài liệu của tôi”, khách hàng trúng đấu giá xác nhận trong vòng 120 phút kể từ thời điểm kết thúc cuộc đấu giá. Trường hợp khách hàng trúng đấu giá không xác nhận biên bản cuộc đấu giá thì coi như không chấp nhận giao kết hợp đồng mua bán tài sản đấu giá và sẽ bị hủy kết quả đấu giá. 


        CHƯƠNG III
        QUY TRÌNH ĐẤU GIÁ

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
