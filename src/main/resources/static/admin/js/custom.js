$(function () {

    $('#side-menu').metisMenu();

});

//Loads the correct sidebar on window load,
//collapses the sidebar on window resize.
// Sets the min-height of #page-wrapper to window size
$(function () {
    $(window).bind("load resize", function () {
        topOffset = 50;
        width = (this.window.innerWidth > 0) ? this.window.innerWidth : this.screen.width;
        if (width < 768) {
            $('div.navbar-collapse').addClass('collapse');
            topOffset = 100; // 2-row-menu
        } else {
            $('div.navbar-collapse').removeClass('collapse');
        }

        height = ((this.window.innerHeight > 0) ? this.window.innerHeight : this.screen.height) - 1;
        height = height - topOffset;
        if (height < 1) height = 1;
        if (height > topOffset) {
            $("#page-wrapper").css("min-height", (height) + "px");
        }
    });

    var url = window.location;
    var element = $('ul.nav a').filter(function () {
        return this.href == url || url.href.indexOf(this.href) == 0;
    }).addClass('active').parent().parent().addClass('in').parent();
    if (element.is('li')) {
        element.addClass('active');
    }
});


// function showConfirmModalcate(id,name){
// 	$('#productName').text(name);
// 	$('#yesDelete').attr('href','/admin/categories/delete/'+id);
// 	$('#staticBackdropcate').modal('show');
// }

//edit

function changeContentThumbnail() {
    document.getElementById('panel-title').innerText = "Ảnh Bìa sản phẩm";
    document.getElementById('panel-body').innerHTML = "<div><p><span>- Tham khảo hướng dẫn hình ảnh sản phẩm khi đăng bán</span><a  > <strong>tại đây</strong></a></p><p><span>- Tham khảo hướng dẫn cho Shopee Mall</span><strong> </strong><a ><strong>tại đây</strong></a></p></div>";
    document.getElementById('panel-guide').style.display = "block";

}

function changeContentImage() {
    document.getElementById('panel-title').innerText = "Hình ảnh sản phẩm";
    document.getElementById('panel-body').innerHTML = "<p><span>- Tham khảo hướng dẫn hình ảnh sản phẩm khi đăng bán</span><a > <strong>tại đây</strong></a></p><p><span>- Tham khảo hướng dẫn cho Shopee Mall</span><strong> </strong><a ><strong>tại đây</strong></a></p>";
    document.getElementById('panel-guide').style.display = "block";

}

function changeContentNamePro() {
    document.getElementById('panel-title').innerHTML = "Tên sản phẩm";
    document.getElementById('panel-body').innerHTML = "<div ><div ><div><p>- Tham khảo quy định đặt tên <a ><strong>tại đây</strong></a>.</p><p>- Với Shopee Mall, xem thêm quy định <a ><strong>tại đây</strong></a>.</p><p>Sử dụng tiếng Việt có dấu, không viết tắt, tối thiểu 10 ký tự. Độ dài tối đa của tên sản phẩm cho tất cả các Shop là 120 ký tự (bao gồm cả khoảng trắng).</p></div></div></div>";
        document.getElementById('panel-guide').style.display = "block";

}

function changeContentDecs() {
    document.getElementById('panel-title').innerHTML = "Mô tả sản phẩm";
    document.getElementById('panel-body').innerHTML = "<div ><p><strong>Lưu ý:</strong> Đối với một số mặt hàng nhất định, Người bán cần cung cấp các thông tin sau tại mục <strong>Mô tả sản phẩm</strong> theo quy định của Nghị định 85/2021/NĐ-CP (Xem Hướng dẫn chi tiết <a  ><strong>tại đây</strong></a>)</p><p>- Số chứng nhận phê duyệt kiểu</p><p>- Khuyến cáo</p><p>- Hướng dẫn sử dụng</p><p>- Thông số kỹ thuật</p><p>- Thông tin cảnh báo</p></div>";
        document.getElementById('panel-guide').style.display = "block";

}

function changeContentCategory() {
    document.getElementById('panel-title').innerHTML = "Danh mục";
    document.getElementById('panel-body').innerHTML = "<div><p>- Việc đăng tải sản phẩm đúng ngành hàng giúp Người mua dễ dàng tìm thấy sản phẩm của Shop khi đang tìm kiếm trong ngành hàng đó.</p><p>- Người bán có thể dễ dàng tìm thấy ngành hàng phù hợp cho sản phẩm của Shop.</p><p>- Tham khảo hướng dẫn chọn danh mục ngành hàng cho sản phẩm <a><strong>tại đây</strong></a>.</p></div>";
        document.getElementById('panel-guide').style.display = "block";

} 
function changeContentBrand() {
    document.getElementById('panel-title').innerHTML = "Thương Hiệu";
    document.getElementById('panel-body').innerHTML = "<div ><p>Sản phẩm có thương hiệu:</p><p>- Chọn từ danh sách/đăng ký thương hiệu</p><p>Xem hướng dẫn Đăng ký Thương hiệu cho sản phẩm <a  ><strong>tại đây</strong></a></p><p>Sản phẩm không thương hiệu:</p><p>- Chọn <strong>No brand</strong></p><p><br></p><p>⚠️Sản phẩm Mall phải có thương hiệu</p></div>    ";
        document.getElementById('panel-guide').style.display = "block";

}
function changeContentPrice() {
    document.getElementById('panel-title').innerHTML = "Giá";
    document.getElementById('panel-body').innerHTML = "<div><p><span>Giá sản phẩm phải tính bằng đơn vị VNĐ</span></p><p><br></p><p><span>⚠️Lưu ý với bài đăng cho nhiều sản phẩm, Giá phải được phân loại rõ ràng dựa trên kích cỡ, màu sắc, chất lượng</span></p></div>    ";
        document.getElementById('panel-guide').style.display = "block";

}
function changeContentQuantity() {
    document.getElementById('panel-title').innerHTML = "Số lượng";
    document.getElementById('panel-body').innerHTML = "<div ><p><span>Cập nhật só lượng tồn kho thực tế của sản phẩm để tránh hủy/ trễ đơn hàng.</span></p><p><span>Xem thêm Quản lý tồn kho</span><a  ><strong> tại đây</strong></a></p></div> ";
        document.getElementById('panel-guide').style.display = "block";

}

function changeContentSalePrice() {
    document.getElementById('panel-title').innerHTML = "Giá Giảm";
    document.getElementById('panel-body').innerHTML = "<div><p><span>Số tiền giảm giá sản phẩm phải tính bằng đơn vị VNĐ</span></p><p><br></p><p><span>⚠️Lưu ý với bài đăng cho nhiều sản phẩm, Giá phải được phân loại rõ ràng dựa trên kích cỡ, màu sắc, chất lượng</span></p></div>    ";
        document.getElementById('panel-guide').style.display = "block";

}

