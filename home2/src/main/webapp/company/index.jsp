<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- ======= Header ======= -->
<jsp:include page="../header.jsp" flush="true"></jsp:include>

<main id="main pt-24" class="bg-slate-50">
	<div class="container">
		<div>
			<nav class="flex ps-4 ms-2 justify-start md:justify-end mt-2"
				aria-label="Breadcrumb">
				<ol
					class="inline-flex items-center space-x-1 md:space-x-2 rtl:space-x-reverse">
					<li class="inline-flex items-center"><a href="/home"
						class="inline-flex items-center text-sm font-medium text-gray-700 hover:text-blue-600 dark:text-gray-400 dark:hover:text-white">
							<svg class="w-3 h-3 me-2.5" aria-hidden="true"
								xmlns="http://www.w3.org/2000/svg" fill="currentColor"
								viewBox="0 0 20 20">
                                    <path
									d="m19.707 9.293-2-2-7-7a1 1 0 0 0-1.414 0l-7 7-2 2a1 1 0 0 0 1.414 1.414L2 10.414V18a2 2 0 0 0 2 2h3a1 1 0 0 0 1-1v-4a1 1 0 0 1 1-1h2a1 1 0 0 1 1 1v4a1 1 0 0 0 1 1h3a2 2 0 0 0 2-2v-7.586l.293.293a1 1 0 0 0 1.414-1.414Z" />
                                </svg> Home
					</a></li>
					<li>
						<div class="flex items-center">
							<svg class="rtl:rotate-180 w-3 h-3 text-gray-400 mx-1"
								aria-hidden="true" xmlns="http://www.w3.org/2000/svg"
								fill="none" viewBox="0 0 6 10">
                                    <path stroke="currentColor"
									stroke-linecap="round" stroke-linejoin="round" stroke-width="2"
									d="m1 9 4-4-4-4" />
                                </svg>
							<a href="/home/company"
								class="ms-1 text-sm font-medium text-gray-700 hover:text-blue-600 md:ms-2 dark:text-gray-400 dark:hover:text-white">Companies</a>
						</div>
					</li>
					<li aria-current="page">
						<div class="flex items-center">
							<svg class="rtl:rotate-180 w-3 h-3 text-gray-400 mx-1"
								aria-hidden="true" xmlns="http://www.w3.org/2000/svg"
								fill="none" viewBox="0 0 6 10">
                                    <path stroke="currentColor"
									stroke-linecap="round" stroke-linejoin="round" stroke-width="2"
									d="m1 9 4-4-4-4" />
                                </svg>
							<span
								class="ms-1 text-sm font-medium text-gray-500 md:ms-2 dark:text-gray-400">list</span>
						</div>
					</li>
				</ol>
			</nav>
		</div>
		<div class="grid md:grid-cols-1 grid-cols-1 mt-2 gap-[30px]">
			<form action="/home/company" id="fn_company" method="get">
			<div class="">
				<h1 class="text-2xl font-semibold text-slate-800">Khám Phá Văn
					Hoá Công Ty</h1>
				<p class="text-lg font-normal text-slate-600 my-3">Tìm hiểu văn hoá
					công ty và chọn cho bạn nơi làm việc phù hợp nhất.</p>
				<div class="flex items-center">
					<div class="sc-cWSHoV fJwGm">
						<svg width="18" height="18" class="" viewBox="0 0 18 18"
							version="1.1" xmlns="http://www.w3.org/2000/svg"
							xmlns:xlink="http://www.w3.org/1999/xlink">
											<g id="Search-Result-WithSkills" stroke="none"
								stroke-width="1" fill="none" fill-rule="evenodd">
											<g id="Search-Result-Filter-Category"
								transform="translate(-277.000000, -242.000000)" fill="#333333">
											<g id="Menu" transform="translate(253.000000, 217.000000)">
											<g id="modecule-/-form-/-desktop-/-dropdown-menu-/-searchbox"
								transform="translate(15.914286, 16.000000)">
											<g id="atom-/-ic-/-Search-Thin"
								transform="translate(9.000000, 9.000000)">
											<path
								d="M7.13182811,0 C3.19719603,0 0,3.19719603 0,7.13182811 C0,11.0664602 3.19719603,14.2636562 7.13182811,14.2636562 C8.68863823,14.2636562 10.1274581,13.7621998 11.3008012,12.9133285 L16.820102,18.4195193 L18,17.2396213 L12.5462491,11.7727604 C13.61799,10.5240352 14.2636562,8.90331381 14.2636562,7.13182811 C14.2636562,3.19719603 11.0664602,0 7.13182811,0 Z M7.13182811,0.839038602 C10.6125273,0.839038602 13.4246176,3.65112891 13.4246176,7.13182811 C13.4246176,10.6125273 10.6125273,13.4246176 7.13182811,13.4246176 C3.65112891,13.4246176 0.839038602,10.6125273 0.839038602,7.13182811 C0.839038602,3.65112891 3.65112891,0.839038602 7.13182811,0.839038602 Z"
								id="Shape"></path></g></g></g></g></g></svg>
					</div>
					<input type="text" value="" name="key" 
						class="outline-none h-[40px] ps-4 w-[320px] md:w-[400px]"
						placeholder="Nhập tên công ty"  autocomplete="off" style="margin-right: 16px"
						maxlength="150" id="company-search-input">
							<button type="submit"
						class="text-md rounded shadow bg-green-400 text-white font-bold px-3 py-2 w-20"
						style="" data-id="btn-search">Tìm</button>
				</div>
			</div>
			
			<div class="lg:col-span-12 md:col-span-12">
				<div class="flex justify-between items-center bg-white px-4 py-2">
					<h3 class="py-2 text-lg font-medium">Công ty nổi bật (${viewJobs[3]})</h3>
					<div>
					<label class="font-semibold">Lĩnh vực</label> 
					<select
									class="form-select outline-none w-[160px] md:w-[320px] form-input border border-slate-100 dark:border-slate-800 block w-full mt-1"
									name="f" onchange="submitFormInCompany()"> ${viewJobs[1]}
					  </select>
					</div>
					
				</div>

				<div class="flex items-center bg-white px-4 py-2">
					<span class="me-2">Sắp xếp theo : </span> ${viewJobs[2]}
				</div>
				<!--list job-->
				${viewJobs[0]}
				<!--end grid-->
				<!--phân trang-->
			</div>
			</form>
		</div>
	</div> <!-- end container -->
	`
	<div class="container md:mt-24 mt-16">
		<div class="grid grid-cols-1 pb-8 text-center">
			<h3
				class="mb-4 md:text-[26px] md:leading-normal text-2xl leading-normal font-semibold">
				Here's why you'll love it Jobstack</h3>

			<p class="text-slate-400 max-w-xl mx-auto">Search all the open
				positions on the web. Get your own personalized salary estimate.
				Read reviews on over 30000+ companies worldwide.</p>
		</div>
		<!--end grid-->
	</div>
	<!--end container-->
	<div class="container md:mt-24 mt-16">
		<div
			class="grid lg:grid-cols-4 md:grid-cols-3 sm:grid-cols-2 grid-cols-1 mt-8 gap-[30px]">
			<div
				class="group p-6 shadow dark:shadow-gray-700 rounded-md bg-white hover:bg-emerald-600/5 dark:bg-slate-900 dark:hover:bg-emerald-600/10 text-center transition-all duration-500"
				data-aos="zoom-out-up">
				<div
					class="w-16 h-16 flex items-center justify-center mx-auto bg-emerald-600/5 group-hover:bg-emerald-600 dark:bg-emerald-600/10 dark:group-hover:bg-emerald-600 shadow dark:shadow-gray-700 rounded-lg transition-all duration-500">
					<i
						class="fa-solid fa-phone text-[30px] text-emerald-600 group-hover:text-white"></i>
				</div>

				<div class="mt-4">
					<a href=""
						class="text-lg font-semibold hover:text-emerald-600 transition-all duration-500">24/7
						Support</a>

					<p class="text-slate-400 mt-3 mb-2">Many desktop publishing now
						use and a search for job.</p>

					<a href=""
						class="hover:text-emerald-600 font-medium transition-all duration-500">Read
						More <i class="uil uil-arrow-right"></i>
					</a>
				</div>
			</div>
			<!--end content-->

			<div
				class="group p-6 shadow dark:shadow-gray-700 rounded-md bg-white hover:bg-emerald-600/5 dark:bg-slate-900 dark:hover:bg-emerald-600/10 text-center transition-all duration-500"
				data-aos="zoom-out-up">
				<div
					class="w-16 h-16 flex items-center justify-center mx-auto bg-emerald-600/5 group-hover:bg-emerald-600 dark:bg-emerald-600/10 dark:group-hover:bg-emerald-600 shadow dark:shadow-gray-700 rounded-lg transition-all duration-500">
					<i
						class="fa-solid fa-envelope text-[30px] text-emerald-600 group-hover:text-white"></i>
				</div>

				<div class="mt-4">
					<a href=""
						class="text-lg font-semibold hover:text-emerald-600 transition-all duration-500">Tech
						& Startup Jobs</a>

					<p class="text-slate-400 mt-3 mb-2">Many desktop publishing now
						use and a search for job.</p>

					<a href=""
						class="hover:text-emerald-600 font-medium transition-all duration-500">Read
						More <i class="uil uil-arrow-right"></i>
					</a>
				</div>
			</div>
			<!--end content-->

			<div
				class="group p-6 shadow dark:shadow-gray-700 rounded-md bg-white hover:bg-emerald-600/5 dark:bg-slate-900 dark:hover:bg-emerald-600/10 text-center transition-all duration-500"
				data-aos="zoom-out-up">
				<div
					class="w-16 h-16 flex items-center justify-center mx-auto bg-emerald-600/5 group-hover:bg-emerald-600 dark:bg-emerald-600/10 dark:group-hover:bg-emerald-600 shadow dark:shadow-gray-700 rounded-lg transition-all duration-500">
					<i
						class="fa-solid fa-truck-fast text-[30px] text-emerald-600 group-hover:text-white"></i>
				</div>

				<div class="mt-4">
					<a href=""
						class="text-lg font-semibold hover:text-emerald-600 transition-all duration-500">Quick
						& Easy</a>

					<p class="text-slate-400 mt-3 mb-2">Many desktop publishing now
						use and a search for job.</p>

					<a href=""
						class="hover:text-emerald-600 font-medium transition-all duration-500">Read
						More <i class="uil uil-arrow-right"></i>
					</a>
				</div>
			</div>
			<!--end content-->

			<div
				class="group p-6 shadow dark:shadow-gray-700 rounded-md bg-white hover:bg-emerald-600/5 dark:bg-slate-900 dark:hover:bg-emerald-600/10 text-center transition-all duration-500"
				data-aos="zoom-out-up">
				<div
					class="w-16 h-16 flex items-center justify-center mx-auto bg-emerald-600/5 group-hover:bg-emerald-600 dark:bg-emerald-600/10 dark:group-hover:bg-emerald-600 shadow dark:shadow-gray-700 rounded-lg transition-all duration-500">
					<i
						class="fa-solid fa-clock text-[30px] text-emerald-600 group-hover:text-white"></i>
				</div>

				<div class="mt-4">
					<a href=""
						class="text-lg font-semibold hover:text-emerald-600 transition-all duration-500">Save
						Time</a>

					<p class="text-slate-400 mt-3 mb-2">Many desktop publishing now
						use and a search for job.</p>

					<a href=""
						class="hover:text-emerald-600 font-medium transition-all duration-500">Read
						More <i class="uil uil-arrow-right"></i>
					</a>
				</div>
			</div>
			<!--end content-->
		</div>
		<!--end grid-->
	</div>
	<!--end container-->




	<div class="container md:mt-24 md:pb-16 mt-16" data-aos="zoom-in">
		<div class="grid md:grid-cols-12 grid-cols-1 items-center gap-[30px]">
			<div class="lg:col-span-5 md:col-span-6">
				<div class="relative">
					<div class="relative">
						<img
							src="https://shreethemes.in/jobstack/layouts/assets/images/about/ab01.jpg"
							class="lg:w-[400px] w-[280px] rounded-md shadow dark:shadow-gray-700"
							alt="">
						<div class="absolute top-0 translate-y-2/4 end-0 text-center">
							<a href="#!" data-type="youtube" data-id="S_CGed6E610"
								class="lightbox h-20 w-20 rounded-full shadow-lg dark:shadow-gray-700 inline-flex items-center justify-center bg-white dark:bg-slate-900 text-emerald-600 dark:text-white">
								<i
								class="mdi mdi-play inline-flex items-center justify-center text-2xl"></i>
							</a>
						</div>
					</div>
					<div class="absolute md:-end-5 end-0 -bottom-16">
						<img
							src="https://shreethemes.in/jobstack/layouts/assets/images/about/ab01.jpg"
							class="lg:w-[280px] w-[200px] border-8 border-white dark:border-slate-900 rounded-md shadow dark:shadow-gray-700"
							alt="">
					</div>
				</div>
			</div>

			<div class="lg:col-span-7 md:col-span-6 mt-14 md:mt-0">
				<div class="lg:ms-5">
					<h3
						class="mb-6 md:text-[26px] text-2xl md:leading-normal leading-normal font-semibold">
						Millions of jobs. <br> Find the one that's right for you.
					</h3>

					<p class="text-slate-400 max-w-xl">Search all the open
						positions on the web. Get your own personalized salary estimate.
						Read reviews on over 30000+ companies worldwide.</p>

					<ul class="list-none text-slate-400 mt-4">
						<li class="mb-1 flex"><i
							class="fa-solid fa-circle-info text-emerald-600 text-xl me-2"></i>
							Digital Marketing Solutions for Tomorrow</li>
						<li class="mb-1 flex"><i
							class="fa-solid fa-circle-info text-emerald-600 text-xl me-2"></i>
							Our Talented & Experienced Marketing Agency</li>
						<li class="mb-1 flex"><i
							class="fa-solid fa-circle-info text-emerald-600 text-xl me-2"></i>
							Create your own skin to match your brand</li>
					</ul>

					<div class="mt-6">
						<a href="contact.html"
							class="btn bg-emerald-600 hover:bg-emerald-700 border-emerald-600 hover:border-emerald-700 text-white py-2 px-4 mt-2 rounded-md"><i
							class="uil uil-envelope"></i> Contact us</a>
					</div>
				</div>
			</div>
		</div>
		<!--end grid-->
	</div>
	<!--end container-->

	<div class="container mt-10" data-aos="zoom-in">
		<div
			class="grid md:grid-cols-12 bg-white grid-cols-1 rounded shadow items-center gap-[30px]">
			<div class="lg:col-span-3 md:col-span-4 px-4">

				<h2 class="text-xl font-bold">
					<span style="color: #d34127;"><strong>Hơn 3.500
							khách hàng tin dùng</strong></span>
				</h2>
				<p class="font-medium text-lg text-slate-900">Cả các công ty
					Việt Nam, FDI và đa quốc gia, trải rộng tất cả các ngành từ ngân
					hàng, fintech đến gia công phần mềm (outsourcing), thương mại điện
					tử, truyền thông, quảng cáo, v.v.</p>

			</div>


			<div class="lg:col-span-9 md:col-span-8">
				<img class="w-full" alt="companies" src="/home/img/com.png">
			</div>
		</div>
	</div>



</main>
<!-- End #main -->

<jsp:include page="../footer.jsp" flush="true"></jsp:include>