<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- ======= Header ======= -->
<jsp:include page="../header.jsp" flush="true"></jsp:include>

<main id="main pt-24">
	<div class="container">
		<div>
			<nav class="flex ps-4 ms-2 justify-start md:justify-end mt-6"
				aria-label="Breadcrumb">
				<ol
					class="inline-flex items-center space-x-1 md:space-x-2 rtl:space-x-reverse">
					<li class="inline-flex items-center"><a href="#"
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
							<a href="#"
								class="ms-1 text-sm font-medium text-gray-700 hover:text-blue-600 md:ms-2 dark:text-gray-400 dark:hover:text-white">jobs</a>
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
		<div class="grid md:grid-cols-12 grid-cols-1 gap-[30px]">
			<div class="lg:col-span-4 md:col-span-6">
				<div
					class="shadow dark:shadow-gray-700 p-6 rounded-md bg-white dark:bg-slate-900 sticky top-20">
					<form id="fn_filter" method="get">
						<div class="grid grid-cols-1 gap-3">
							<div>
								<label for="searchname" class="font-semibold">Search
									Company</label>
								<div class="relative mt-2">
									<i
										class="fa-solid fa-magnifying-glass text-lg absolute start-3"></i>
									${viewJobs[5]}
								</div>
							</div>

							<div>
								<label class="font-semibold">Ngành nghề</label> <select
									class="form-select form-input border border-slate-100 dark:border-slate-800 block w-full mt-1"
									name="cr"> ${viewJobs[2]}
								</select>
							</div>

							<div>
								<label class="font-semibold">Địa chỉ</label> <select
									class="form-select form-input border border-slate-100 dark:border-slate-800 block w-full mt-1"
									name=lc> ${viewJobs[1]}
								</select>
							</div>

							<div>
								<label class="font-semibold">Job Types</label>
								<div class="block mt-2">
									<div class="flex justify-between">
										<div class="inline-flex items-center mb-0">
											<input
												class="form-checkbox rounded border-gray-200 dark:border-gray-800 text-emerald-600 focus:border-emerald-300 focus:ring focus:ring-offset-0 focus:ring-emerald-200 focus:ring-opacity-50 me-2"
												type="checkbox" value="0" onchange="setCheck(this)"
												name="type" id="c0" ${selected[0]?"checked":""}> <label
												class="form-checkbox-label text-slate-400" for="fulltime">ALL</label>
										</div>

										<span
											class="bg-emerald-600/10 text-emerald-600 text-xs px-2.5 py-0.5 font-semibold rounded-full h-5">${viewJobs[6]}</span>
									</div>
									<c:forEach items="${jobtime}" var="i" varStatus="loop">
										<div class="flex justify-between">
											<div class="inline-flex items-center mb-0">
												<input	class="form-checkbox rounded border-gray-200 dark:border-gray-800 text-emerald-600 focus:border-emerald-300 focus:ring focus:ring-offset-0 focus:ring-emerald-200 focus:ring-opacity-50 me-2"
													type="checkbox" value="${loop.index+1}" name="type"
													id="fulltime${loop.index+1}"
													${selected[loop.index+1] ? 'checked' : ''}
													onchange="setCheck(this)"> <label
													class="form-checkbox-label text-slate-400"
													for="fulltime${loop.index}">${i}</label>
											</div>
										</div>
									</c:forEach>


								</div>
							</div>

							<div>
								<label class="font-semibold">Salary</label>
								<div class="block mt-2">
									<div class="flex justify-between">
										<div class="inline-flex items-center mb-0">
											<input
												class="form-checkbox rounded border-gray-200 dark:border-gray-800 text-emerald-600 focus:border-emerald-300 focus:ring focus:ring-offset-0 focus:ring-emerald-200 focus:ring-opacity-50 me-2"
												type="checkbox" value="0" onchange="setCheck2(this)"
												name="salary" id="s0" ${selectedSlr[0]?"checked":""}> <label
												class="form-checkbox-label text-slate-400" for="fulltime">ALL</label>
										</div>

										<span
											class="bg-emerald-600/10 text-emerald-600 text-xs px-2.5 py-0.5 font-semibold rounded-full h-5">${viewJobs[6]}</span>
									</div>
									<c:forEach items="${salaries}" var="i" varStatus="count">
										<div class="flex justify-between">
											<div class="inline-flex items-center mb-0">
												<input	class="form-checkbox rounded border-gray-200 dark:border-gray-800 text-emerald-600 focus:border-emerald-300 focus:ring focus:ring-offset-0 focus:ring-emerald-200 focus:ring-opacity-50 me-2"
													type="checkbox" value="${count.index+1}" name="salary"
													id="salary${count.index+1}"
													${selectedSlr[count.index+1] ? 'checked' : ''}
													onchange="setCheck2(this)"> <label
													class="form-checkbox-label text-slate-400"
													for="fulltime${count.index}">${i}</label>
											</div>
										</div>
									</c:forEach>
								
								</div>
							</div>

							<div>
							
								<button type="submit"
									class="btn py-1 font-bold bg-emerald-600 hover:bg-emerald-700 border-emerald-600 hover:border-emerald-700 text-white rounded-md w-full">
									<i class="fa-solid fa-filter me-1"></i>Apply Filter
									</button>
							</div>
						</div>
					</form>
				</div>
			</div>
			<!--end col-->

			<div class="lg:col-span-8 md:col-span-6 mt-6">
				<div class="flex justify-between items-center">
					<h3 class="py-2 text-lg font-medium">${viewJobs[3]}</h3>
					<a class="bg-rose-600 hover:bg-emerald-700 font-bold rounded text-white px-2 py-1" href="/home/jobs"><i class="fa-solid fa-broom me-2"></i>Clear Filter</a>
				</div>
				
				<div class="flex items-center">
					<span class="me-2">Sắp xếp theo : </span> ${viewJobs[4]}
				</div>
				<!--list job-->
				${viewJobs[0]}
				<!--end grid-->
				<!--phân trang-->
			</div>
		</div>
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


</main>
<!-- End #main -->

<jsp:include page="../footer.jsp" flush="true"></jsp:include>