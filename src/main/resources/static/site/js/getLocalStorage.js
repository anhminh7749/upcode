const checkout = document.querySelector("#checkout");
const checkdiscountcode = document.querySelector("#checkdiscountcode");
const discountcode = document.querySelector("#discountcode");
const countcode = document.querySelector("#discount");
const addressId = document.querySelector("#addressId");
const btnCreateAddress = document.querySelector("#createAddress");
const closeFormAddress = document.querySelector("#closeFormAddress");
const AgreeDel = document.querySelector('#AgreeDel');
var formaddress = document.getElementById("address_form");

let message;

let iddel=null;

function cancelorder(id){
  iddel = id;
}


AgreeDel.addEventListener("click", () => {
  if(iddel){
    $.ajax({
      type: "POST",
      contentType: "application/json; charset=utf-8",
      url:
        "http://localhost:8080/api/order/cancel?id=" + iddel,
      success: function (response) {
        if (response == "success") {      
          alert("success ok");
          document.getElementById("cancel").click();
        }else if(response == "isEmpty"){
          alert("isEmpty");
        }
      },
      error: function (response) {
        alert(response);
      },
    });
  }
  else{
    alert("Không thể hủy!");
  }
});

checkdiscountcode.addEventListener("click", () => {
  $.ajax({
    type: "POST",
    contentType: "application/json; charset=utf-8",
    url:
      "/code/check?discountcode=" +
      discountcode.value +
      "&total=" +
      shoptotalCost.innerText,
    success: function (response) {
      if (response == "null") {
        alert("Mã giảm giá không tồn tại");
      } else if (response == "notexist") {
        alert("Mã giảm giá không tồn tại");
      } else if (response == "mismatched") {
        alert("Mã giảm giá không khớp");
      } else if (response == "oof") {
        alert("Mã giảm giá đã hết lượt sử dụng");
      } else if (response == "Insufficientfunds") {
        alert("Đơn hàng chưa đủ tiền để áp dụng mã giảm giá");
      } else if (response == "date") {
        alert("Mã giảm giá đã hết hạn hoặc chưa đến hạn sử dụng");
      } else {
        alert("success ok");
        countcode.innerHTML = response;
      }
    },
    error: function (response) {
      alert(response);
    },
  });
});

checkout.addEventListener("click", () => {
  if (addressId.value) {
    $.ajax({
      type: "POST",
      contentType: "application/json; charset=utf-8",
      url:
        "http://localhost:8080/cart/save?addressId=" +
        addressId.value +
        "&discountcode=" +
        discountcode.value,
      data: {
        shopcart: JSON.stringify(shopCartItems),
      },
      success: function (response) {
        if (response == "success") {
          clearCartItems();
          clearCartShopItems() ;
          alert("success ok");
        }
      },
      error: function (response) {
        alert(response);
      },
    });
  } else {
    alert("Vui lòng chọn địa chỉ!");
  }
});
document.getElementById("redirect").value = window.location.pathname;
btnCreateAddress.addEventListener("click", () => {


  setTimeout(formaddress.submit(),1000);
});