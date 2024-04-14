
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
function submitForm() {
	document.getElementById('fn_filter').submit();
}
function submitFormInCompany() {
	document.getElementById('fn_company').submit();
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
	 	 if (a.length > 0 ) {
			    let title = document.createElement("h2");
			    title.textContent = "Kết quả tìm kiếm";
			    resultList.appendChild(title);
			    resultList.classList.add("p-3");
    
		    a.forEach((item)=> {
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
			  btn.classList="inline-flex justify-center rounded-md bg-rose-600 px-2 mt-2 py-1 text-sm font-semibold text-white shadow-sm hover:bg-red-400";
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






