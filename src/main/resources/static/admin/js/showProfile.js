function showProfile(email, tt, des) {
console.log(email,tt,des);
	document.getElementById("gmailgmail").value = email;

	document.getElementById("titletitle").value = tt;

	document.getElementById("description").innerHTML = des;
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

	document.getElementById("email").innerHTML = email;

	document.getElementById("name").innerHTML = name;

	document.getElementById("gender").innerHTML = gt;

	document.getElementById("status").innerHTML = tt;

	document.getElementById("birthday").innerHTML = day;
}

function showConfirmModelDialog(id, name) {
	$('#mailName').text(name);
	$('#yesOption').attr('href',
		'/admin/contacs/delete/' + id);
	$('#confirmationId').modal('show');
}
function showConfirmModelDialogCustomer(id, name) {
	$('#mailName').text(name);
	$('#yesOption').attr('href',
		'/admin/customers/delete/' + id);
	$('#confirmationId').modal('show');
}
function showConfirmModelDialogStaff(id, name) {
	$('#mailName').text(name);
	$('#yesOption').attr('href',
		'/admin/staffs/delete/' + id);
	$('#confirmationId').modal('show');
}
function showConfirmModelDialogCategory(id, name) {
	$('#mailName').text(name);
	$('#yesOption').attr('href',
		'/admin/categories/delete/' + id);
	$('#confirmationId').modal('show');
}
function showConfirmModelDialogBrand(id, name) {
	$('#mailName').text(name);
	$('#yesOption').attr('href',
		'/admin/brands/delete/' + id);
	$('#confirmationId').modal('show');
}