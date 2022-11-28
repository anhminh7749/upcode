function showProfile(email, tt, des) {
console.log(email,tt,des);
	document.getElementById("gmailgmail").value = email;

	document.getElementById("titletitle").value = tt;

	document.getElementById("description").innerHTML = des;
}
function showProfileBrand(name,ig, des) {
console.log(name,ig,des);
	document.getElementById("name").value = name;

	document.getElementById("thumbnail").innerHTML = ig;

	document.getElementById("description").innerHTML = des;
}
function showProfileBlog(ig,name, td,tt) {
console.log(ig,name,td,tt);
	document.getElementById("banner").value = ig;

	document.getElementById("name").value = name;

	document.getElementById("title").value = td;

	document.getElementById("Active").value = tt;
}
function showProfileCategory(name) {
console.log(name);
	document.getElementById("name").value = name;
}
function showProfileProduct(ig,name,pr,qt,dc,ct,br,tt) {

	document.getElementById("thumbnail").value = ig;

	document.getElementById("Name").value = name;

	document.getElementById("Price").value = pr;
	document.getElementById("Quantity").value = qt;
	document.getElementById("Discount").value = dc;
	document.getElementById("Category.name").value = ct;
	document.getElementById("brand.name").value =br;
	document.getElementById("Active").value = tt;
}
function showProfileStaff(email,name,pb,cv,phone,creat,l) {

	document.getElementById("email").value = email;

	document.getElementById("name").value = name;

	document.getElementById("pBan").value = pb;
	document.getElementById("cVu").value = cv;
	document.getElementById("phone").value = phone;
	document.getElementById("ngayBD").value = creat;
	document.getElementById("luong").value = l;
}
function showProfileCustomer(email, name, gt, tt, day) {

	document.getElementById("email").value = email;

	document.getElementById("name").value = name;

	document.getElementById("gender").value = gt;

	document.getElementById("status").value = tt;

	document.getElementById("birthday").value = day;
}
function showProfileDiscountcode(name,ra,aa,qt,bc,ad,ed) {

	document.getElementById("name").value = name;

	document.getElementById("ReductionAmount").value = ra;

	document.getElementById("AmountApplied").value = aa;
	document.getElementById("Quantity").value = qt;
	document.getElementById("ByteCode").value = bc;
	document.getElementById("ApplicableDate").value = ad;
	document.getElementById("ExpirationDate").value =ed;
}

function showConfirmModelDialog(id, name) {
	$('#mailName').text(name);
	$('#yesOption').attr('href',
		'/api/admin/contacs/delete/' + id);
	$('#confirmationId').modal('show');
}
function showConfirmModelDialogCustomer(id, name) {
	$('#mailName').text(name);
	$('#yesOption').attr('href',
		'/api/admin/customers/delete/' + id);
	$('#confirmationId').modal('show');
}
function showConfirmModelDialogStaff(id, name) {
	$('#mailName').text(name);
	$('#yesOption').attr('href',
		'/api/admin/staffs/delete/' + id);
	$('#confirmationId').modal('show');
}
function showConfirmModelDialogCategory(id, name) {
	$('#mailName').text(name);
	$('#yesOption').attr('href',
		'/api/admin/categories/delete/' + id);
	$('#confirmationId').modal('show');
}
function showConfirmModelDialogBrand(id, name) {
	$('#mailName').text(name);
	$('#yesOption').attr('href',
		'/api/admin/brands/delete/' + id);
	$('#confirmationId').modal('show');
}