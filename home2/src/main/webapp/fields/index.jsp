<%@page import="jsoft.library.Utilities_text"%>
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
							<a href="/home/fields"
								class="ms-1 text-sm font-medium text-gray-700 hover:text-blue-600 md:ms-2 dark:text-gray-400 dark:hover:text-white">lĩnh v</a>
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
								class="ms-1 text-sm font-medium text-gray-500 md:ms-2 dark:text-gray-400">danh sách</span>
						</div>
					</li>
				</ol>
			</nav>
		</div>
		`

		<div class="grid md:grid-cols-12 grid-cols-1 gap-[30px]">

			<!--end col-->

			<div class="lg:col-span-9 md:col-span-6 bg-white rounded shadow-lg p-4">
				<h2 class="font-bold text-2xl">Tìm Việc Làm Theo Ngành
					Nghề</h2>
				<div class="grid md:grid-cols-3 mt-6 grid-cols-1 gap-[30px]">
					<c:forEach items="${fiels}" var="i" varStatus="loop">
						<div class="lg:col-span-1 md:col-span-1">
							<h2 class="font-medium text-true text-md">${i.field_name}</h2>
							<c:forEach items="${careers}" var="o" varStatus="u">
								<c:if test="${o.career_field_id eq i.field_id}">
									<div class="flex justify-between my-2">
										<a class="text-sm hover:text-sky-600"
											href="/home/jobs/?cr=${o.career_id}">${o.career_name}</a>
										<c:forEach items="${totaljob}" var="entry">
											<c:if test="${entry.key eq o.career_id}">
												<span class="text-white rounded-full px-2 bg-blue-700">${entry.value}</span>
											</c:if>
										</c:forEach>
									</div>
								</c:if>
								
							</c:forEach>
						</div>
					</c:forEach>
				</div>
			</div>
			<div class="lg:col-span-3 md:col-span-6">
				<div>
					<h2 class="font-medium text-xl text-blue-900 ms-4">Việc làm mới
						nhất</h2>
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
										<a href="employer-detail.html"
											class="block text-[16px] font-semibold hover:text-emerald-600 transition-all duration-500">
											${i.company.company_name} </a> <span
											class="block text-sm text-true">Còn 58 ngày</span>
									</div>
								</div>
							</div>
							<div class="mt-6">
								<a href="job-detail-two.html"
									class="text-lg hover:text-emerald-600 font-semibold transition-all duration-500">${i.job_title}</a>
								<h6 class="text-base font-normal">
									<i class="fa-solid fa-location-dot me-2"></i> Hà Nội
								</h6>
							</div>
							<div class="mt-6">
								<div class="mt-6 flex justify-between items-center">
									<a
										href="job-apply.html"
										class="btn btn-sm px-4 py-2 rounded-md bg-emerald-600 hover:bg-emerald-700 border-emerald-600 hover:border-emerald-700 text-white md:ms-2 lg:w-[200px] w-48 text-center ">Ứng
										tuyển ngay</a>
								</div>
							</div>
						</div>
					</c:forEach>
				</div>

				<div class="mt-6">
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
								<p class="text-small">
									${i.article_summary}
								</p>
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

						<p class="text-slate-400 mt-3 mb-2">Many desktop publishing
							now use and a search for job.</p>

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

						<p class="text-slate-400 mt-3 mb-2">Many desktop publishing
							now use and a search for job.</p>

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

						<p class="text-slate-400 mt-3 mb-2">Many desktop publishing
							now use and a search for job.</p>

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

						<p class="text-slate-400 mt-3 mb-2">Many desktop publishing
							now use and a search for job.</p>

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
         <div class="grid md:grid-cols-12 grid-cols-1 bg-white rounded shadow items-center gap-[30px]">
         	 <div class="lg:col-span-3 md:col-span-4 px-4">
         	 		
				<h2 class="text-xl font-bold"><span style="color: #d34127;"><strong>Hơn 3.500 khách hàng tin dùng</strong></span></h2>
				<p class="font-medium text-lg text-slate-900">Cả các công ty Việt Nam, FDI và đa quốc gia, trải rộng tất cả các ngành từ ngân hàng, fintech đến gia công phần mềm (outsourcing), thương mại điện tử, truyền thông, quảng cáo, v.v.</p>
         	 		
         	 </div>

         	 
         	  <div class="lg:col-span-9 md:col-span-8">
         	    	<img class="w-full" alt="companies" src="/home/img/com.png">
         	 </div>
         </div>
     </div>
		
</main>
<!-- End #main -->

<jsp:include page="../footer.jsp" flush="true"></jsp:include>