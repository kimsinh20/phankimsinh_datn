
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
function setCheck(obj) {
	var arr = document.getElementsByName("type");

	if ((obj.id === 'c0') && (arr[0].checked === true)) {
		for (var i = 1; i < arr.length; i++) {
			arr[i].checked = true;
		}
	} else if ((obj.id === 'c0') && (arr[0].checked === false)) {
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
		if(allChecked) {
			arr[0].checked = true;
		} else {
			arr[0].checked = false;
		}
	}
	 document.getElementById('fn_filter').submit();
}
function setCheck2(obj) {
	var arr = document.getElementsByName("salary");

	if ((obj.id === 's0') && (arr[0].checked === true)) {
		for (var i = 1; i < arr.length; i++) {
			arr[i].checked = true;
		}
	} else if ((obj.id === 's0') && (arr[0].checked === false)) {
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
		if(allChecked) {
			arr[0].checked = true;
		} else {
			arr[0].checked = false;
		}
	}
	 document.getElementById('fn_filter').submit();
}





