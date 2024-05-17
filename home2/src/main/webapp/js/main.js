
document.addEventListener('DOMContentLoaded', () => {
	"use strict";
	const scrollTop = document.querySelector('.scroll-top');
	if (scrollTop) {
		const togglescrollTop = function() {
			window.scrollY > 100 ? scrollTop.classList.add('active') : scrollTop.classList.remove('active');
		}
		window.addEventListener('load', togglescrollTop);
		document.addEventListener('scroll', togglescrollTop);
		scrollTop.addEventListener('click', window.scrollTo({
			top: 0,
			behavior: 'smooth'
		}));
	}
	function aos_init() {
		AOS.init({
			duration: 1000,
			easing: 'ease-in-out',
			once: true,
			mirror: false
		});
	}
	window.addEventListener('load', () => {
		aos_init();
	});
});
function Menu(e) {
	let list = document.querySelector('nav');
	let lang = document.querySelector('#nav_lang');
	let login = document.querySelector('#nav_login');

	e.name === 'menu' ? (e.name = "close", list.classList.add('top-[80px]'), lang.classList.add('hidden'), login.classList.add('hidden'), list.classList.add('opacity-100')) : (e.name = "menu", list.classList.remove('top-[80px]'), list.classList.remove('opacity-100'), lang.classList.remove('hidden'), login.classList.remove('hidden'))
}
window.onscroll = changePos;

function changePos() {
	const header = document.querySelector('.header');
	if (window.pageYOffset > 100) {
		header.classList.add('sticked');
	} else {
		header.classList.remove('sticked');
	}
}

function setCheck(obj, name, selected) {
	var arr = document.getElementsByName(name);

	if ((obj.id === selected) && (arr[0].checked === true)) {
		for (var i = 1; i < arr.length; i++) {
			arr[i].checked = true;
		}
	} else if ((obj.id === selected) && (arr[0].checked === false)) {
		for (var i = 1; i < arr.length; i++) {
			arr[i].checked = false;
		}
	} else {
		for (var i = 1; i < arr.length; i++) {
			if (arr[i].checked == true) {
				arr[0].checked = false;
				break;
			}
		}
		let allChecked = true;

		for (var i = 1; i < arr.length; i++) {
			if (!arr[i].checked) {
				allChecked = false;
				break;
			}
		}
		if (allChecked) {
			arr[0].checked = true;
		} else {
			arr[0].checked = false;
		}
	}
	document.getElementById('fn_filter').submit();
}

function submitForm(name) {
	document.getElementById(name).submit();
}
function displayResultSearch(f) {

	fetch(`http://localhost:8080/home/api/search?key=${f.value}`)
		.then(response => response.json())
		.then(data => {
			// Lấy tham chiếu đến phần tử <ul>
			let resultList = document.getElementById("result_search");
			// Xóa nội dung hiện tại của phần tử <ul>
			resultList.innerHTML = '';
			resultList.classList.remove("p-3");
			let a = data;
			// Nếu có thay đổi trong kết quả tìm kiếm
			if (a.length > 0) {
				let title = document.createElement("h2");
				title.textContent = "Kết quả tìm kiếm";
				resultList.appendChild(title);
				resultList.classList.add("p-3");

				a.forEach((item) => {
					let li = document.createElement("li");
					li.classList.add("hover:bg-sky-200", "text-sm", "font-normal", "mt-2");
					li.textContent = item.job_title;
					li.addEventListener("click", () => {
						document.getElementById("job-keyword").value = item.job_title;
						resultList.innerHTML = '';
						resultList.classList.remove("p-3");
					});
					resultList.appendChild(li);
				});
				let btn = document.createElement("button");
				btn.textContent = "Hủy";
				btn.classList = "inline-flex justify-center rounded-md bg-rose-600 px-2 mt-2 py-1 text-sm font-semibold text-white shadow-sm hover:bg-red-400";
				btn.addEventListener("click", () => {
					document.getElementById("job-keyword").value = '';
					resultList.innerHTML = '';
					resultList.classList.remove("p-3");
				});
				resultList.appendChild(btn);
			}

		})
		.catch(error => {
			console.error('L?i khi g?i API:', error);
		});

}
function showDialog() {
	let bg_dialog = document.getElementById("bg_dialog");
	let dialog = document.getElementById("dialog");
	bg_dialog.classList.remove("hidden");
	dialog.classList.remove("hidden");
}
function hideDialog() {
	let bg_dialog = document.getElementById("bg_dialog");
	let dialog = document.getElementById("dialog");
	bg_dialog.classList.add("hidden");
	dialog.classList.add("hidden");
}
function showDialogV2() {
	let bg_dialog = document.getElementById("bg_dialog_apply");
	let dialog = document.getElementById("dialog_apply");
	bg_dialog.classList.remove("hidden");
	dialog.classList.remove("hidden");
}
function hideDialogV2() {
	let bg_dialog = document.getElementById("bg_dialog_apply");
	let dialog = document.getElementById("dialog_apply");
	bg_dialog.classList.add("hidden");
	dialog.classList.add("hidden");
}

function checkValiLogin() {
	// tham chieu lay du lieu
	let name = document.getElementById('username').value;
	let pass = document.getElementById('password').value;

	// tham chieu xu ly loi
	let viewErrName = document.getElementById('errName');
	let viewErrPass = document.getElementById('errPass');

	// bien xac nhan hop le cua gia tri
	var validName = true;
	var validPass = true;

	// bien ghi nhan loi
	var messageErr = '';

	// kiem tra name
	name = name.trim(); // loai bo khoang trang dau va cuoi
	if (name == '') {
		validName = false;
		messageErr = 'Vui lòng nhập tên đăng nhập.';
	} else {
		if ((name.length < 5) || (name.length > 50)) {
			validName = false;
			messageErr = 'Tên đăng nhập phải có độ dài từ 5 đến 50 kí tự';
		} else {
			if (name.indexOf(' ') != -1) {
				validName = false;
				messageErr = 'Tên đăng nhập không được có dấu cách';
			} else {
				if (name.indexOf('@') != -1) {
					var parttern = /\w+@\w+[.]\w/;
					if (!name.match(parttern)) {
						validName = false;
						messageErr = 'Tên đăng nhập không đúng cú pháp hộp thư';
					}
				}

			}
		}
	} // name = ''

	// Xuat thong bao
	viewErrName.style.paddingTop = '5px';
	viewErrName.style.paddingBottom = '5px';
	viewErrName.style.marginTop = '4px';
	if (!validName) {
		viewErrName.innerHTML = messageErr;

		// dinh dang style
		viewErrName.style.backgroundColor = '#bd4b6c';
		viewErrName.style.color = '#fff';

	} else {
		viewErrName.innerHTML = '<i class="fa-solid fa-check"></i>';

		// dinh dang style
		viewErrName.style.backgroundColor = 'transparent';
		viewErrName.style.color = 'blue';
	}

	// Kiem tra pass 
	pass = pass.trim(); // loai bo khoang trang dau va cuoi
	if (pass == '') {
		validPass = false;
		messageErr = 'Vui lòng nhập mật khẩu để đăng nhập';
	} else {
		if (pass.length < 6) {
			validPass = false;
			messageErr = 'Mật khẩu phải có ít nhất 6 kí tự';
		}
	}

	// Xuat thong bao
	viewErrPass.style.paddingTop = '5px';
	viewErrPass.style.paddingBottom = '5px';
	viewErrPass.style.marginTop = '4px';
	if (!validPass) {
		viewErrPass.innerHTML = messageErr;

		// dinh dang style
		viewErrPass.style.backgroundColor = '#bd4b6c';
		viewErrPass.style.color = '#fff';

	} else {
		viewErrPass.innerHTML = '<i class="fa-solid fa-check"></i>';

		// dinh dang style
		viewErrPass.style.backgroundColor = 'transparent';
		viewErrPass.style.color = 'blue';
	}

	if (validName && validPass) {
		document.getElementById('btn-login').disabled = false;
	}
	return validName && validPass
}
async function handleLogin() {
	let txtName = document.getElementById("username").value.trim();
	let txtPass = document.getElementById("password").value.trim();
	try {
		const response = await fetch('http://localhost:8080/home/login', {
			method: 'POST',
			headers: {
				'Content-Type': 'application/json'
			},
			body: JSON.stringify({ txtName, txtPass })
		});

		if (response.ok) {
			const data = await response.json();
			console.log(data);
			// Process the login response data
			window.location.reload();

			return data;
		} else {
			throw new Error('Login failed');
		}
	} catch (error) {
		showToast("CÓ lỗi vui lòng thử lại");
		console.error('Error:', error.message);
		throw error;
	}

}
function showToast(title) {
	Toastify({
		text: title,
		duration: 3000,
		destination: "http://localhost:8080/home/",
		newWindow: true,
		close: true,
		gravity: "top", // `top` or `bottom`
		position: "right", // `left`, `center` or `right`
		stopOnFocus: true, // Prevents dismissing of toast on hover
		style: {
			background: "linear-gradient(to right, #00b09b, #96c93d)",
		},
		onClick: function() { } // Callback after click
	}).showToast();
}
function toggle() {
	if (document.getElementById("nav_profile") != null) {
		document.getElementById("nav_profile").classList.toggle("hidden");
		console.log("a");
	}


}
let nav_profile = document.getElementById("nav_profile");
let btn_profile = document.getElementById("nav_login");
if (nav_profile != null && btn_profile != null) {
	window.addEventListener('click', (e) => {
		if (!btn_profile.contains(e.target)) {
			document.getElementById("nav_profile").classList.add("hidden");
		}
	})
}
function isJobIdExists(jobSave, job_id) {
	for (var i = 0; i < jobSave.length; i++) {
		if (jobSave[i].job_id === job_id) {
			return true; // job_id đã tồn tại trong mảng
		}
	}
	return false; // job_id không tồn tại trong mảng
}
async function saveJob(job_id, user_id) {
	console.log("ánds");
	if (user_id != null) {
		try {
			const response = await fetch(`http://localhost:8080/home/save?job_id=${job_id}&user_id=${user_id}`, {
				method: 'POST',
				headers: {
					'Content-Type': 'application/json'
				},
				body: JSON.stringify({ job_id, job_id })
			});

			if (response.ok) {
				const data = await response.json();
				let arr = document.getElementsByClassName("save-job");
				console.log(arr)
				if (data.type == 'del') {
					for (var i = 0; i < arr.length; i++) {
						arr[i].classList.remove("save-active");
					}
					showToast("Xóa tin thành công");
				} else {
					for (var i = 0; i < arr.length; i++) {
						arr[i].classList.add("save-active");
					}
					showToast("Lưu tin thành công");
				}

				// Process the login response data
			} else {
				throw new Error('không có dữ liệu');
			}
		} catch (error) {
			showToast("CÓ lỗi vui lòng thử lại");
			console.error('Error:', error.message);
			throw error;
		}
	} else {
		showDialog();
	}
}

async function saveJobv2(job_id, user_id) {
	if (user_id !== null) {
		try {
			const response = await fetch(`http://localhost:8080/home/save?job_id=${job_id}&user_id=${user_id}`, {
				method: 'POST',
				headers: {
					'Content-Type': 'application/json'
				},
				body: JSON.stringify({ job_id, job_id })
			});

			if (response.ok) {
				const data = await response.json();
				let arr = document.getElementById("save-" + job_id);
				if (data.type == 'del') {
					arr.classList.remove("save-active");
					showToast("Xóa tin thành công");
				} else {
					arr.classList.add("save-active");
					showToast("Lưu tin thành công");
				}

				// Process the login response data
			} else {
				throw new Error('không có dữ liệu');
			}
		} catch (error) {
			showToast("CÓ lỗi vui lòng thử lại");
			console.error('Error:', error.message);
			throw error;
		}
	} else {
		showDialog();
	}
}

async function followCompany(com_id, user_id) {

	if (user_id != null) {
		try {
			const response = await fetch(`http://localhost:8080/home/follow?com_id=${com_id}&user_id=${user_id}`, {
				method: 'POST',
				headers: {
					'Content-Type': 'application/json'
				},
				body: JSON.stringify({ com_id, user_id })
			});

			if (response.ok) {
				const data = await response.json();
				let listBtn = document.getElementsByClassName("follow-company");
				console.log(listBtn)
				if (data.type == 'unfollow') {
					for (var i = 0; i < listBtn.length; i++) {
						listBtn[i].classList.remove("save-active");
					}
					showToast("Hủy theo dõi");
				} else {
					for (var i = 0; i < listBtn.length; i++) {
						listBtn[i].classList.add("save-active");
					}
					showToast("Đã theo dõi");
				}

				// Process the login response data
			} else {
				throw new Error('không có dữ liệu');
			}
		} catch (error) {
			showToast("CÓ lỗi vui lòng thử lại");
			console.error('Error:', error.message);
			throw error;
		}
	} else {
		showDialog();
	}
}

async function followCompanyV2(com_id, user_id) {
	if (user_id !== null) {
		try {
			const response = await fetch(`http://localhost:8080/home/follow?com_id=${com_id}&user_id=${user_id}`, {
				method: 'POST',
				headers: {
					'Content-Type': 'application/json'
				},
				body: JSON.stringify({ com_id, user_id })
			});

			if (response.ok) {
				const data = await response.json();
				let arr = document.getElementById("follow-" + com_id);
				if (data.type == 'unfollow') {
					arr.classList.remove("save-active");
					showToast("Hủy theo dõi");
				} else {
					arr.classList.add("save-active");
					showToast("Đã theo dõi");
				}

				// Process the login response data
			} else {
				throw new Error('không có dữ liệu');
			}
		} catch (error) {
			showToast("CÓ lỗi vui lòng thử lại");
			console.error('Error:', error.message);
			throw error;
		}
	} else {
		showDialog();
	}
}




