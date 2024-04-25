<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- ======= Header ======= -->
<jsp:include page="../header.jsp" flush="true"></jsp:include>

<main id="main pt-24" class="bg-slate-50">
	<div class="container">
		<div>
			<nav class="flex ps-4 ms-2 justify-start md:justify-end mt-6"
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
                                </svg> Trang chủ
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
								class="ms-1 text-sm font-medium text-gray-700 hover:text-blue-600 md:ms-2 dark:text-gray-400 dark:hover:text-white">công
								ty</a>
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
								class="ms-1 text-sm font-medium text-gray-500 md:ms-2 dark:text-gray-400">chi
								tiết</span>
						</div>
					</li>
				</ol>
			</nav>
		</div>

		<div class="bg-white rounded shadow mt-4  overflow-hidden bg-linear" style="">
			<div class="">
				<img draggable="false"
					src="${com.company_banner}"
					width="100%" class="w-full h-[230px]">
			</div>
		
			<div class="company-detail-overview relative text-white flex lg:flex-row flex-col items-center gap-[30px] py-[30px] pl-0 md:pl-[20%] pr-[20px] md:pr-[40px]">
					<div class="company-logo absolute lg:left-[30px] left-auto top-[-64px] ">
					<img draggable="false"
						src="${com.company_logo}"
						alt="${com.company_name}" class="object-cover size-32 rounded-full shadow" style="">
					</div>
				<div class="box-detail block w-full flex-1 lg:mt-0 mt-16">
					<h1 data-toggle="tooltip" title=""
						class="text-lg font-bold mb-4 text-center lg:text-start"
						data-original-title="Công ty Cổ phần Solazu">${com.company_name}</h1>
					<div class=" flex gap-[30px] flex-col md:flex-row items-center lg:justify-start	 justify-center ">
						<div data-toggle="tooltip" title=""
							class=""
							data-original-title="https://solazu.com/">
							<span class=""> <i
								class="fa-solid fa-globe"></i>
							</span> <a class="company-subdetail-info-text"
								href="https://solazu.com/" target="_blank">${com.company_website}</a>
						</div>
						<div class="">
							<span class=""> <i
								class="fa-solid fa-building"></i>
							</span> <span class="">${company_size }</span>
						</div>
					</div>
				</div>
				<div class="box-follow">
					<a href="javascript:showLoginPopup(null, null);"
						class="btn btn-follow bg-white font-bold py-2 px-2 text-sm rounded shadow text-green-400"> <span><i
							class="fa-regular fa-plus"></i></span> Theo dõi công ty
					</a>
				</div>
			</div>
		</div>

		<div class="grid md:grid-cols-12 grid-cols-1 mt-6 gap-[30px]">
			<div class="lg:col-span-8 md:col-span-6">
				<h5 class="text-lg font-semibold py-3 bg-linear rounded-t-lg shadow-lg text-white px-3">Giới thiệu công ty</h5>
				<div class="bg-white p-6 orverflow-hidden rounded shadow-lg">

					<p class="text-slate-400 mt-4">${com.company_about}</p>

 					<c:if test="${not empty com.company_remuneration}">
					  <h5 class="text-lg font-semibold mt-6">Phúc lợi :</h5>
					  <p class="text-slate-400 mt-4">${com.company_remuneration}</p>
					</c:if>


					<div class="mt-5 flex justify-between items-center">
						<div class="flex justify-between items-center">
							<a href=""
								class="btn btn-icon me-3 px-3 py-2 flex justify-center items-center border-2 border-green-400  rounded bg-emerald-600/5 hover:bg-emerald-600 border-emerald-600/10  text-emerald-600 hover:text-white">
								<svg xmlns="http://www.w3.org/2000/svg" width="24" height="24"
									viewBox="0 0 24 24" fill="none" stroke="currentColor"
									stroke-width="2" stroke-linecap="round" stroke-linejoin="round"
									class="feather feather-bookmark size-4">
									<path d="M19 21l-7-5-7 5V5a2 2 0 0 1 2-2h10a2 2 0 0 1 2 2z"></path></svg>
								<span class="ms-2">Theo dõi</span>
							</a> <a
								href="https://www.facebook.com/share_channel/?link=https%3A%2F%2Fcareerviet.vn%2Fvi%2Ftim-viec-lam%2Fpho-phong-nhan-su-nha-may-lam-viec-tai-yen-bai-cach-ha-noi-160km.35C0281A.html&app_id=966242223397117&source_surface=external_reshare&display&hashtag"
								class="btn btn-icon me-3 px-3 py-2 flex justify-center items-center border-2 border-green-400  rounded bg-emerald-600/5 hover:bg-emerald-600 border-emerald-600/10  text-emerald-600 hover:text-white">
								<i class="fa-solid fa-square-share-nodes"></i> <span
								class="ms-2">Chia sẻ</span>
							</a> <a href=""
								class="btn btn-icon px-3 py-2 flex justify-center items-center border-2 border-green-400  rounded bg-emerald-600/5 hover:bg-emerald-600 border-emerald-600/10  text-emerald-600 hover:text-white">
								<i class="fa-solid fa-flag"></i> <span class="ms-2">Báo
									cáo</span>
							</a>
						</div>
					</div>

				</div>

				<div class="bg-white shadow rounded p-6 mt-10">
					<h2 class="font-medium text-xl text-blue-900 ms-4">Việc làm
						liên quan</h2>
					<c:forEach items="${jobs}" var="i" varStatus="loop">
						<div
							class="group shadow dark:shadow-gray-700 mt-4 p-6 rounded-md bg-white dark:bg-slate-900">
							<div class="flex items-center justify-between">
								<div class="flex items-center">
									<div
										class="size-14 flex items-center justify-center bg-white dark:bg-slate-900 shadow dark:shadow-gray-700 rounded-md">
										<img src="${i.company.company_logo}" class="size-8" alt="">
									</div>
									<div class="ms-2">
										<a href="/home/jobs/detail?id=${i.job_id }"
											class="block text-[16px] font-semibold hover:text-emerald-600 transition-all duration-500">
											${i.company.company_name} </a> <span
											class="block text-sm text-true">Còn 58 ngày</span>
									</div>
								</div>
							</div>
							<div class="mt-6">
								<a href="/home/jobs/detail?id=${i.job_id }"
									class="text-lg hover:text-emerald-600 font-semibold transition-all duration-500">${i.job_title}</a>
								<h6 class="text-base font-normal">
									<i class="fa-solid fa-location-dot me-2"></i> Hà Nội
								</h6>
							</div>
							<div class="mt-6">
								<div class="mt-6 flex justify-between items-center">
									<a href=""
										class="rounded-full px-3 py-2 text-2xl bg-emerald-600/5 hover:bg-emerald-600 border-emerald-600/10 hover:border-emerald-600 text-emerald-600"
										id="icon-save"><i class="fa-regular fa-heart"></i></a><a
										href="/home/jobs/detail?id=${i.job_id }"
										class="btn btn-sm px-4 py-2 rounded-md bg-emerald-600 hover:bg-emerald-700 border-emerald-600 hover:border-emerald-700 text-white lg:w-[200px] w-48 text-center ">Ứng
										tuyển ngay</a>
								</div>
							</div>
						</div>
					</c:forEach>
				</div>

			</div>
			<!--end col-->

			<div class="lg:col-span-4 md:col-span-6  sticky top-20">
				<h5 class="text-lg font-semibold py-3 bg-linear rounded-t-lg shadow-lg text-white px-3">Giới thiệu chung</h5>
				<div
					class="shadow-lg dark:shadow-gray-700 p-6 rounded-md bg-white dark:bg-slate-900">
					<div class="mt-2">
						<span class="text-slate-600 font-medium me-2 block"><span
							class="font-bold text-md text-slate-400"><i
								class="fa-solid fa-users me-2"></i>Mô tả :</span> ${com.company_summary}</span> <span
							class="text-slate-600 font-medium py-2 me-2 block">
							<span
							class="font-bold text-md text-slate-400"><i
								class="fa-regular fa-clone me-2"></i>Địa chỉ công ty :</span>
						  </span>
						 <c:forEach items="${location}" var="i" varStatus="loop">
						  <div class="font-normal text-sm flex flex-col text-gray-900">
						  <span>
						   + ${i.addressDetail}, ${i.wards}, ${i.districts}, ${i.provinces}. 
						  </span>    
						  </div>
						</c:forEach>
					</div>
					<div
						class="md:flex items-center justify-center mt-6 hover:underline">
						<a target="_blank"
							class="text-center bg-emerald-600 text-white hover:bg-blue-800 rounded px-3 py-2"
							href="https://www.google.com/maps/search/${location[0].addressDetail}+${location[0].wards}+${location[0].districts}+${ilocation[0].provinces}/@21.0345169,105.8247409,17z/data=!3m1!4b1?entry=ttu">Xem bản đồ <i
							class="fa-solid ms-2 fa-arrow-up-right-from-square"></i></a>
					</div>

				</div>

				<div
					class="shadow-lg dark:shadow-gray-700 rounded-md bg-white dark:bg-slate-900 mt-6">
					<h5 class="text-lg font-semibold py-3 bg-linear rounded-t-lg shadow-lg text-white px-3">Thông tin liên hệ</h5>
					<div class="p-6 border-t border-slate-100 dark:border-t-gray-700">
						<ul class="list-none">
							<li class="flex items-center"><svg
									xmlns="http://www.w3.org/2000/svg" width="24" height="24"
									viewBox="0 0 24 24" fill="none" stroke="currentColor"
									stroke-width="2" stroke-linecap="round" stroke-linejoin="round"
									class="feather feather-user-check size-5">
									<path d="M16 21v-2a4 4 0 0 0-4-4H5a4 4 0 0 0-4 4v2"></path>
									<circle cx="8.5" cy="7" r="4"></circle>
									<polyline points="17 11 19 13 23 9"></polyline></svg>

								<div class="ms-4">
									<p class="font-medium">Quốc gia:</p>
									<span class="text-emerald-600 font-medium text-sm">${company_nationality}</span>
								</div></li>

							<li class="flex items-center mt-3"><svg
									xmlns="http://www.w3.org/2000/svg" width="24" height="24"
									viewBox="0 0 24 24" fill="none" stroke="currentColor"
									stroke-width="2" stroke-linecap="round" stroke-linejoin="round"
									class="feather feather-map-pin size-5">
									<path d="M21 10c0 7-9 13-9 13s-9-6-9-13a9 9 0 0 1 18 0z"></path>
									<circle cx="12" cy="10" r="3"></circle></svg>

								<div class="ms-4">
									<p class="font-medium">Điên thoại:</p>
									<span class="text-emerald-600 font-medium text-sm">${com.company_homephone}</span>
								</div></li>

							<li class="flex items-center mt-3"><i
								class="fa-solid fa-user-doctor me-1"></i>

								<div class="ms-4">
									<p class="font-medium">Lĩnh vực:</p>
									<span class="text-emerald-600 font-medium text-sm">${com.field.field_name}</span>
								</div></li>

							<li class="flex items-center mt-3"><svg
									xmlns="http://www.w3.org/2000/svg" width="24" height="24"
									viewBox="0 0 24 24" fill="none" stroke="currentColor"
									stroke-width="2" stroke-linecap="round" stroke-linejoin="round"
									class="feather feather-monitor size-5">
									<rect x="2" y="3" width="20" height="14" rx="2" ry="2"></rect>
									<line x1="8" y1="21" x2="16" y2="21"></line>
									<line x1="12" y1="17" x2="12" y2="21"></line></svg>

								<div class="ms-4">
									<p class="font-medium">Hộp thư:</p>
									<span class="text-emerald-600 font-medium text-sm">${com.company_email}</span>
								</div></li>

							<li class="flex items-center mt-3"><svg
									xmlns="http://www.w3.org/2000/svg" width="24" height="24"
									viewBox="0 0 24 24" fill="none" stroke="currentColor"
									stroke-width="2" stroke-linecap="round" stroke-linejoin="round"
									class="feather feather-briefcase size-5">
									<rect x="2" y="7" width="20" height="14" rx="2" ry="2"></rect>
									<path d="M16 21V5a2 2 0 0 0-2-2h-4a2 2 0 0 0-2 2v16"></path></svg>

								<div class="ms-4">
									<p class="font-medium">Website:</p>
									<span class="text-emerald-600 font-medium text-sm">${com.company_website }</span>
								</div></li>

							<li class="flex items-center mt-3"><svg
									xmlns="http://www.w3.org/2000/svg" width="24" height="24"
									viewBox="0 0 24 24" fill="none" stroke="currentColor"
									stroke-width="2" stroke-linecap="round" stroke-linejoin="round"
									class="feather feather-book size-5">
									<path d="M4 19.5A2.5 2.5 0 0 1 6.5 17H20"></path>
									<path
										d="M6.5 2H20v20H6.5A2.5 2.5 0 0 1 4 19.5v-15A2.5 2.5 0 0 1 6.5 2z"></path></svg>

								<div class="ms-4">
									<p class="font-medium">Làm thêm giờ:</p>
									<span class="text-emerald-600 font-medium text-sm">
									<c:if test="${com.company_isOT}">
										có
									</c:if>
									<c:if test="${!com.company_isOT}">
										không
									</c:if>
									</span>
								</div></li>

							<li class="flex items-center mt-3"><i
								class="fa-solid fa-venus-double"></i>

								<div class="ms-4">
									<p class="font-medium">Quy mô:</p>
									<span class="text-emerald-600 font-medium text-sm">${company_size}</span>
								</div></li>

							<li class="flex items-center mt-3"><i
								class="fa-regular fa-address-book"></i>

								<div class="ms-4">
									<p class="font-medium">Đánh giá:</p>
									<span class="text-emerald-600 font-medium text-sm">4.5<i class="fa-solid fa-star" style="color: yellow;"></i></span>
								</div></li>


							<li class="flex items-center mt-3"><svg
									xmlns="http://www.w3.org/2000/svg" width="24" height="24"
									viewBox="0 0 24 24" fill="none" stroke="currentColor"
									stroke-width="2" stroke-linecap="round" stroke-linejoin="round"
									class="feather feather-dollar-sign size-5">
									<line x1="12" y1="1" x2="12" y2="23"></line>
									<path d="M17 5H9.5a3.5 3.5 0 0 0 0 7h5a3.5 3.5 0 0 1 0 7H6"></path></svg>

								<div class="ms-4">
									<p class="font-medium">Lượt theo dõi:</p>
									<span class="text-emerald-600 font-medium text-sm">20</span>
								</div></li>

						</ul>
					</div>
				</div>


				<div class="mt-6 bg-white">
					<h2 class="font-medium text-xl text-blue-900">Bài viết nổi bật</h2>
					<c:forEach items="${articles}" var="i" varStatus="loop">
						<div
							class="group relative article mt-6 overflow-hidden bg-white dark:bg-slate-900 rounded-md shadow dark:shadow-gray-700">
							<div class="relative overflow-hidden article">
								<img src="${i.article_image}"
									class="scale-110 article_img group-hover:scale-100 transition-all duration-500"
									alt="" />
							</div>
							<div class="relative p-6">
								<div class="absolute start-6 -top-4">
									<span
										class="bg-emerald-600 px-3 text-white text-[12px] px-2.5 py-1 font-semibold rounded-full h-5">${i.category_name}</span>
								</div>
								<div class="">
									<div class="flex mb-4 justify-between">
										<span class="text-slate-400 text-sm me-2"><i
											class="fa-solid fa-calendar text-slate-900 dark:text-white me-2"></i>${i.article_created_date}</span><span
											class="text-slate-400 text-sm ms-3"><i
											class="fa-solid ms-2 fa-eye text-slate-900 dark:text-white me-2"></i>${i.article_visited}
											lượt xem</span>
									</div>
									<a href="blog-detail.html"
										class="title text-md font-semibold hover:text-emerald-600 duration-500 ease-in-out">${i.article_title }</a>
									<p class="text-small">${i.article_summary}</p>
									<div class="flex justify-between items-center mt-3">
										<a href="/home/blogs/?id=${i.article_id}"
											class="btn btn-link hover:text-emerald-600 after:bg-emerald-600 duration-500 ease-in-out">ReadMore
											<i class="uil uil-arrow-right"></i>
										</a><span class="text-slate-400 text-sm">by <a href="#"
											class="text-slate-900 dark:text-white hover:text-emerald-600 dark:hover:text-emerald-600 font-medium">admin</a></span>
									</div>
								</div>
							</div>
						</div>
					</c:forEach>
				</div>
			</div>

		</div>
		<!--end col-->
	</div>
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

	<div class="container mt-6" data-aos="zoom-in">
		<div
			class="grid md:grid-cols-12 grid-cols-1 bg-white rounded shadow items-center gap-[30px]">
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