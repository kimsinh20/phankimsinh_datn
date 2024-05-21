<%@page import="jsoft.objects.UserObject"%>
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
							<a href="/home/jobs"
								class="ms-1 text-sm font-medium text-gray-700 hover:text-blue-600 md:ms-2 dark:text-gray-400 dark:hover:text-white">công
								việc</a>
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

		<div class="grid md:grid-cols-12 grid-cols-1 mt-6 gap-[30px]">
			<div class="lg:col-span-8 md:col-span-6">
				<div
					class="md:flex items-center p-6 shadow dark:shadow-gray-700 rounded-md bg-white dark:bg-slate-900">
					<img src="${job.company.company_logo }"
						class="rounded size-28 p-4 bg-white dark:bg-slate-900 shadow dark:shadow-gray-700"
						alt="">

					<div class="md:ms-4 md:mt-0 mt-6">
						<h5 class="text-xl font-semibold">${job.job_title}<span>(${date_count})</span>
						</h5>
						<div class="mt-2">
							<span class="text-slate-400 font-medium me-2 inline-block"><i
								class="fa-solid fa-building text-[18px] text-emerald-600 me-1"></i>${job.company.company_name }</span>
							<span class="text-slate-400 font-medium me-2 inline-block"><i
								class="fa-solid fa-location-dot text-[18px] text-emerald-600 me-1"></i>
								${job_province}</span> <span
								class="text-slate-400 font-medium me-2 inline-block"><i
								class="fa-solid fa-clock text-[18px] text-emerald-600 me-1"></i>Hạn
								nộp hồ sơ : ${job.job_expiration_date}</span>
						</div>
						<div class="flex mt-4 justify-between">
					<%	
						UserObject user = (UserObject) request.getSession().getAttribute("clientLogined");
					%>
					<%
					if (user == null) {
					%>
						    <button onclick="showDialog()" href="#" class="btn items-center flex justify-center btn-sm font-semibold px-3 py-2 w-3/4 rounded-md bg-emerald-600 hover:bg-emerald-700 border-emerald-600 hover:border-emerald-700 text-white lg:mt-0">Đăng nhập để ứng tuyển</button>
						<%
					} else {
					%>
						   <c:choose>
					  <c:when test="${isApp}">
					    <button  href="#" class="btn items-center flex justify-center btn-sm font-semibold px-3 py-2 w-3/4 rounded-md bg-rose-600 hover:bg-emerald-700 border-emerald-600 hover:border-emerald-700 text-white lg:mt-0">Đã ứng tuyển</button>
					  </c:when>
					  <c:otherwise>
					    <button onclick="showDialogV2()" href="#" class="btn items-center flex justify-center btn-sm font-semibold px-3 py-2 w-3/4 rounded-md bg-emerald-600 hover:bg-emerald-700 border-emerald-600 hover:border-emerald-700 text-white lg:mt-0">Ứng tuyển ngay</button>
					  </c:otherwise>
					</c:choose>
						<%
					}
					%>
							<button type="button" onclick="saveJob(${job.job_id},${user})"
								class="btn ${isSave} save-job btn-icon px-3 py-2 flex justify-center items-center border-2 border-green-400 rounded bg-emerald-600/5 hover:bg-emerald-600 border-emerald-600/10 text-emerald-600 hover:text-white">
								<svg xmlns="http://www.w3.org/2000/svg" width="24" height="24"
									viewBox="0 0 24 24" fill="none" stroke="currentColor"
									stroke-width="2" stroke-linecap="round" stroke-linejoin="round"
									class="feather feather-bookmark size-4">
						    <path d="M19 21l-7-5-7 5V5a2 2 0 0 1 2-2h10a2 2 0 0 1 2 2z"></path>
						  </svg>
								<span class="ms-2">Lưu tin</span>
							</button>
						</div>
					</div>
				</div>

				<h5
					class="text-md mt-6 font-semibold py-3 bg-linear rounded-t-lg shadow-lg text-white px-3">Mô
					tả công việc</h5>
				<div class="bg-white p-6 rounded shadow-lg">


					<p class="text-slate-400 mt-4">${job.job_responsibility}</p>



					<h5 class="text-lg font-semibold mt-6">Yêu cầu công việc :</h5>
					<p class="text-slate-400 mt-4">${job.job_purpose}</p>


					<h5 class="text-lg font-semibold mt-6">Phúc lợi :</h5>
					<p class="text-slate-400 mt-4">${job.job_Welfare}</p>

					<div class="mt-4">
						<h3 class="text-lg font-semibold mt-6">Quy trình phỏng vấn</h3>
						<div>
							<ul class="">
								<li class="mb-1 text-md ">Vòng 1: Làm bài test</li>
								<li class="mb-1 text-md ">Vòng 2: Phỏng vấn Tech
									Lead(online)</li>
								<li class="mb-1 text-md ">Vòng 3: Deal lương</li>
							</ul>
						</div>
					</div>

					<div class="mt-5 flex justify-between items-center">
						<div class="flex justify-between items-center">
							<button type="button" onclick="saveJob(${job.job_id},${user })"
								class="btn ${isSave} save-job btn-icon px-3 py-2 flex justify-center items-center border-2 border-green-400 rounded bg-emerald-600/5 hover:bg-emerald-600 border-emerald-600/10 text-emerald-600 me-3 hover:text-white">
								<svg xmlns="http://www.w3.org/2000/svg" width="24" height="24"
									viewBox="0 0 24 24" fill="none" stroke="currentColor"
									stroke-width="2" stroke-linecap="round" stroke-linejoin="round"
									class="feather feather-bookmark size-4">
					    <path d="M19 21l-7-5-7 5V5a2 2 0 0 1 2-2h10a2 2 0 0 1 2 2z"></path>
					  </svg>
								<span class="ms-2">Lưu tin</span>
							</button>
							<a
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
						<a href="job-apply.html"
							class="btn btn-icon px-3 py-2 flex justify-center items-center border-2 border-green-400  rounded bg-emerald-600/3 hover:bg-emerald-600 border-emerald-600/10  text-emerald-600 hover:text-white">Nộp
							hồ sơ ngay</a>
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
				<div
					class="shadow-lg dark:shadow-gray-700 p-6 rounded-md bg-white dark:bg-slate-900">
					<div class="md:flex items-center">
						<img src="${job.company.company_logo }"
							class="rounded size-28 p-4 bg-white dark:bg-slate-900 shadow dark:shadow-gray-700"
							alt="">
						<div class="md:ms-4 md:mt-0 mt-6">
							<h5 class="text-xl font-semibold">${job.company.company_name }</h5>
						</div>
					</div>
					<div class="mt-2">
						<span class="text-slate-600 font-medium me-2 block"><span
							class="font-bold text-lg text-slate-400"><i
								class="fa-solid fa-users me-2"></i>Quy mô :</span> ${company_size}</span> <span
							class="text-slate-600 font-medium py-2 me-2 block"><span
							class="font-bold text-lg text-slate-400"><i
								class="fa-regular fa-clone me-2"></i>Lĩnh vực :</span>
							${job.company.field.field_name} </span>
					</div>
					<div
						class="md:flex items-center justify-center mt-6 hover:underline">
						<a
							class="text-center bg-emerald-600 text-white hover:bg-blue-800 rounded px-3 py-2"
							href="/home/company/detail?id=${job.company.company_id}">Xem
							trang công ty <i
							class="fa-solid ms-2 fa-arrow-up-right-from-square"></i>
						</a>
					</div>

				</div>

				<div
					class="shadow-lg dark:shadow-gray-700 rounded-md bg-white dark:bg-slate-900 mt-6">
					<h5
						class="text-md font-semibold py-3 bg-linear rounded-t-lg shadow-lg text-white px-3">Thông
						tin công việc</h5>
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
									<p class="font-medium">Thời gian làm việc:</p>
									<span class="text-emerald-600 font-medium text-sm">${job_work_time}</span>
								</div></li>

							<li class="flex items-center mt-3"><svg
									xmlns="http://www.w3.org/2000/svg" width="24" height="24"
									viewBox="0 0 24 24" fill="none" stroke="currentColor"
									stroke-width="2" stroke-linecap="round" stroke-linejoin="round"
									class="feather feather-map-pin size-5">
									<path d="M21 10c0 7-9 13-9 13s-9-6-9-13a9 9 0 0 1 18 0z"></path>
									<circle cx="12" cy="10" r="3"></circle></svg>

								<div class="ms-4">
									<p class="font-medium">Địa chỉ làm việc:</p>
									<span class="text-emerald-600 font-medium text-sm">${job_location}</span>
								</div></li>

							<li class="flex items-center mt-3"><i
								class="fa-solid fa-user-doctor me-1"></i>

								<div class="ms-4">
									<p class="font-medium">Ngành nghề:</p>
									<span class="text-emerald-600 font-medium text-sm">${job.job_career.career_name}</span>
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
									<p class="font-medium">Vị trí:</p>
									<span class="text-emerald-600 font-medium text-sm">${job_level}</span>
								</div></li>

							<li class="flex items-center mt-3"><svg
									xmlns="http://www.w3.org/2000/svg" width="24" height="24"
									viewBox="0 0 24 24" fill="none" stroke="currentColor"
									stroke-width="2" stroke-linecap="round" stroke-linejoin="round"
									class="feather feather-briefcase size-5">
									<rect x="2" y="7" width="20" height="14" rx="2" ry="2"></rect>
									<path d="M16 21V5a2 2 0 0 0-2-2h-4a2 2 0 0 0-2 2v16"></path></svg>

								<div class="ms-4">
									<p class="font-medium">Kinh nghiệm:</p>
									<span class="text-emerald-600 font-medium text-sm">${job_experience }</span>
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
									<p class="font-medium">Bằng cấp:</p>
									<span class="text-emerald-600 font-medium text-sm">${job_degree}</span>
								</div></li>

							<li class="flex items-center mt-3"><i
								class="fa-solid fa-venus-double"></i>

								<div class="ms-4">
									<p class="font-medium">Giới tính:</p>
									<span class="text-emerald-600 font-medium text-sm">${job_gender}</span>
								</div></li>

							<li class="flex items-center mt-3"><i
								class="fa-regular fa-address-book"></i>

								<div class="ms-4">
									<p class="font-medium">Số lượng tuyển:</p>
									<span class="text-emerald-600 font-medium text-sm">${job.job_quantity}</span>
								</div></li>

							<li class="flex items-center mt-3"><i
								class="fa-solid fa-book-skull"></i>

								<div class="ms-4">
									<p class="font-medium">Kỹ năng yêu cầu:</p>

									${job_skills}

								</div></li>

							<li class="flex items-center mt-3"><svg
									xmlns="http://www.w3.org/2000/svg" width="24" height="24"
									viewBox="0 0 24 24" fill="none" stroke="currentColor"
									stroke-width="2" stroke-linecap="round" stroke-linejoin="round"
									class="feather feather-dollar-sign size-5">
									<line x1="12" y1="1" x2="12" y2="23"></line>
									<path d="M17 5H9.5a3.5 3.5 0 0 0 0 7h5a3.5 3.5 0 0 1 0 7H6"></path></svg>

								<div class="ms-4">
									<p class="font-medium">Lương:</p>
									<span class="text-emerald-600 font-medium text-sm">${job_salary}</span>
								</div></li>

							<li class="flex items-center mt-3"><svg
									xmlns="http://www.w3.org/2000/svg" width="24" height="24"
									viewBox="0 0 24 24" fill="none" stroke="currentColor"
									stroke-width="2" stroke-linecap="round" stroke-linejoin="round"
									class="feather feather-clock size-5">
									<circle cx="12" cy="12" r="10"></circle>
									<polyline points="12 6 12 12 16 14"></polyline></svg>

								<div class="ms-4">
									<p class="font-medium">Ngày đăng tin:</p>
									<span class="text-emerald-600 font-medium text-sm">${job.job_created_date}</span>
								</div></li>
							<li class="flex items-center mt-3"><svg
									xmlns="http://www.w3.org/2000/svg" width="24" height="24"
									viewBox="0 0 24 24" fill="none" stroke="currentColor"
									stroke-width="2" stroke-linecap="round" stroke-linejoin="round"
									class="feather feather-clock size-5">
									<circle cx="12" cy="12" r="10"></circle>
									<polyline points="12 6 12 12 16 14"></polyline></svg>

								<div class="ms-4">
									<p class="font-medium">Ngày hết hạn:</p>
									<span class="text-emerald-600 font-medium text-sm">${job.job_expiration_date}</span>
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
<div class="relative z-10" aria-labelledby="modal-title" role="dialog"
	aria-modal="true">
	<div id="bg_dialog_apply"
		class="fixed hidden inset-0 bg-gray-500 bg-opacity-75 transition-opacity duration-500"></div>

	<div id="dialog_apply"
		class="fixed hidden inset-0 z-10 w-screen overflow-y-auto">
		<div
			class="flex min-h-full items-end justify-center text-center sm:items-center sm:p-0">
			<div
				class="relative transform overflow-hidden rounded-lg bg-white text-left shadow-xl transition-all sm:my-8 sm:w-full sm:max-w-lg">
				<div class="bg-white sm:p-0 sm:pb-4 h-screen">
					<div class="">
						<button onclick="hideDialogV2()"
							class="text-2xl text-false absolute top-0 right-0">
							<i class="fa-solid fa-xmark px-2 py-2"></i>
						</button>
						<section class="bg-gray-50">
							<div class="flex flex-col  px-4 py-4 mx-auto md:h-screen lg:py-0">
								<h2 class="text-xl mt-6 font-semibold">
									Ứng tuyển <span class="text-true text-md">${job.job_title }</span>
								</h2>
								<form method="post" enctype="multipart/form-data">
									<div class="mt-6">
										<div class="mt-2 text-xl font-semibold">
											<i class="fa-solid fa-folder-user"></i> <span>Chọn CV
												để ứng tuyển</span>
										</div>
										<div>
											<input type="radio" id="html" name="fav_language"
												value="b"> <label for="html">${client.client_profiles }<a class="text-true ms-3" target="_blank" href="${client.client_profiles }">Xem CV</a></label><br>
											<input type="radio" id="css" name="fav_language" value="a">
											<label for="css"><input type="file" id="file"
												name="client_profiles"></label><br>
										</div>
									</div>
									<div class="mt-6">
										<div class="mt-2 text-xl font-semibold">
											<i class="fa-sharp fa-solid fa-feather-pointed"></i> <span>Thư
												giới thiệu:</span>
										</div>
										<div class="text-sm text-slate-400 my-2">Một thư giới
											thiệu ngắn gọn, chỉn chu sẽ giúp bạn trở nên chuyên nghiệp và
											gây ấn tượng hơn với nhà tuyển dụng.</div>
										<div class="cover-letter-area">
											<textarea style="height: 200px;" name="letter" class="text-md text-slate-600 w-full" rows="3"
												id="letter"
												placeholder="Viết giới thiệu ngắn gọn về bản thân (điểm mạnh, điểm yếu) và nêu rõ mong muốn, lý do bạn muốn ứng tuyển cho vị trí này.">Kính gửi: Nhà tuyển dụng,Tôi xin gửi đến Anh/Chị lời chào trân trọng và sự quan tâm đặc biệt của mình đối với vị trí thực tập sinh react js hiện đang được Công ty Anh/Chị tuyển dụng.Tôi là phan kim sinh.Hiện là sinh viên năm cuối trường đại học công nghiệp Hà Nội.Tôi rất ấn tượng với sứ mệnh và giá trị của Công ty Anh/Chị. Tôi tin rằng sự đa dạng của kinh nghiệm và kiến thức của tôi sẽ làm cho tôi trở thành một người đóng góp có giá trị cho đội ngũ của Anh/Chị.Tôi đã đính kèm CV của mình để cung cấp thêm thông tin chi tiết về quá trình làm việc và học vấn của tôi. Tôi rất mong có cơ hội được thảo luận về cách tôi có thể đóng góp vào sự phát triển của Công ty Anh/Chị.
												Cảm ơn Anh/Chị đã xem xét đơn của tôi. Tôi mong sớm có cơ hội thảo luận chi tiết với Anh/Chị.
Trân trọng,
   Sinh</textarea>
											
										</div>
									</div>
									<div class="flex justify-center mt-6">
										<button class="bg-rose-600 py-3 w-full rounded text-white">Ứng tuyển</button>
									</div>
								</form>
							</div>
						</section>
					</div>
				</div>
			</div>
		</div>
	</div>