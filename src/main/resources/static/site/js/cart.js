const shopcartDOM = document.querySelector(".shop_cart_items");
const shoptotalCost = document.getElementById("shop__total__cost");
const onchangepage = document.querySelector("#shoppingcart");

let usernameshop = sessionStorage.getItem("UserName");

// assign all values from local stoarge
let shopCartItems = (JSON.parse(localStorage.getItem(usernameshop)) || []);


document.addEventListener("DOMContentLoaded", loadDatashop);
var dress =[
    name = null,
    phone = null,
    detail = null,
    address =null
]

function setaddress(id,name,phone,detail,address){
    dress =[
        id=id,
        name = name,
        phone = phone,
        detail = detail,
        address=address
        
    ]
   
}
function getaddress(){ 
    document.getElementById("name-phone").innerHTML= dress.at(1)+'  '+dress.at(2);
    document.getElementById("address-detail").innerHTML=dress.at(3) +', '+ dress.at(4); 
    document.getElementById("addressId").setAttribute('value', dress.at(0));
    closeModels();
}

function closeModels(){
    document.getElementById('closeModels').click();
}

function loadDatashop() {
    if (shopCartItems.length > 0) {
        shopCartItems.forEach(product => {
           
            ShowItemToTheDOM(product);
           
            const shopcartDOMItems = document.querySelectorAll(".shop_cart_item");

            shopcartDOMItems.forEach(individualItem => {
                if (individualItem.querySelector("#product__id").value === product.id) {
                    // increrase
                    shopincreaseItem(individualItem, product);
                    // decrease
                    shopdecreaseItem(individualItem, product);
                    // Removing Element
                    shopremoveItem(individualItem, product);

                }
            });

        });
        shopcalculateTotal();
    }
}



function shopcalculateTotal() {
    let total = 0;
    shopCartItems.forEach(item => {
        total += (item.price - item.discount) * item.quantity;
    });

    shoptotalCost.innerHTML = total;
}

function shopsaveToLocalStorage() {

    localStorage.setItem(usernameshop, JSON.stringify(shopCartItems));

}

function clearCartShopItems() {

    
    localStorage.removeItem(usernameshop);
    shopCartItems = [];

    document.querySelectorAll(".shop_cart_items").forEach(item => {

        item.querySelectorAll(".shop_cart_item").forEach(node => {
            node.remove();
        });
    });
    // cartDOM.classList.toggle("active");
    shopcalculateTotal();
}




function ShowItemToTheDOM(product) {
    // Adding the new Item to the Dom
    shopcartDOM.insertAdjacentHTML("afterbegin", `<div class="shop_cart_item"><div class="cart-header">
    <div class="close1 btn__small btn_remove" action="remove">&times;</div>
    <div class="cart-sec simpleCart_shelfItem">
        <div class="cart-item cyc">
            <img id="product_image" src="${product.thumbnail}" class="img-responsive" alt="" />
        </div>
        <div class="cart-item-info">
            <input type="hidden" id="product__id" value="${product.id}">
            <h3><a class="product__name">${product.name}</a><span>Model No: 3578</span></h3>
            <ul class="qty">
            ${product.discount == 0 ? '<li> <p id="product__price">Price : '+product.price+' </p></li>': '<li><p id="product__price">Original Price : '+product.price+'</p></li><li><p class="product__discount">Unit Price : '+(product.price-product.discount)+'</p></li>'}
        
                <li>
                <a class="btn__small" action="decrease">&minus;</a> <p class="product__quantity">Qty : ${product.quantity}</p><a class="btn__small" action="increase">&plus;</a>
                </li>
             
             
            </ul>
            <div class="delivery">
                <p>Service Charges : Rs.100.00</p>
                <span>Delivered in 2-3 business days</span>
                <div class="clearfix"></div>
            </div>
        </div>
        <div class="clearfix"></div>
    </div>
</div></div>`);
}

// ${product.discount == 0 ? '<li> <p>Total Price : '+product.price * product.quantity+' </p></li>': '<li> <p>Total Price : '+((product.price - product.discount) * product.quantity)+'</p></li>'}


function shopincreaseItem(individualItem, product) {

    individualItem.querySelector("[action='increase']").addEventListener('click', () => {
        // Actual Array
        shopCartItems.forEach(cartItem => {
            if (cartItem.id === product.id) {
                individualItem.querySelector(".product__quantity").innerText = ++cartItem.quantity;
                shopcalculateTotal();
                shopsaveToLocalStorage();
                
            }
        })
    });

}

function shopdecreaseItem(individualItem, product) {
    individualItem.querySelector("[action='decrease']").addEventListener('click', () => {
        // all cart items in the dom
        shopCartItems.forEach(cartItem => {
            // Actual Array
            if (cartItem.id === product.id) {
                if (cartItem.quantity > 1) {
                    individualItem.querySelector(".product__quantity").innerText = --cartItem.quantity;
                    shopcalculateTotal();
                   
                    shopsaveToLocalStorage();
                } else {
                    // removing this element and assign the new elemntos to the old of the array

                    shopCartItems = shopCartItems.filter(newElements => newElements.id !== product.id);
                    individualItem.remove();
                 
                    shopcalculateTotal();
                    shopsaveToLocalStorage();

                }

            }
        })
    });
}



function shopremoveItem(individualItem, product) {

    individualItem.querySelector("[action='remove']").addEventListener('click', () => {
        shopCartItems.forEach(cartItem => {
            if (cartItem.id === product.id) {
                shopCartItems = shopCartItems.filter(newElements => newElements.id !== product.id);
                individualItem.remove();
                shopcalculateTotal();      
                shopsaveToLocalStorage();
            }
        })
    });
}