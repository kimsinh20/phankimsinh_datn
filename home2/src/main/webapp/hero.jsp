
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<fmt:setLocale value="${sessionScope.lang}" />
<fmt:setBundle basename="lang.lang" />
<!-- Start Hero -->
<section class="relative  md:py-56 py-36 container" data-aos="fade-up">
	<div class="absolute inset-0 bg-hero"></div>
	<div class="container z-1">
		<div class="grid grid-cols-1 text-center mt-10 relative">
			<h4
				class="lg:leading-normal leading-normal text-4xl lg:text-5xl mb-5 font-bold">
				<fmt:message key="menu.join" />
				& <span class="text-emerald-600 font-bold"><fmt:message
						key="menu.explore" /></span> <br> <span
					class="text-emerald-600 font-bold"><fmt:message
						key="menu.thousands" /></span>
				<fmt:message key="menu.ofjob" />
			</h4>
			<p class="text-slate-400 text-lg max-w-xl mx-auto">
				<fmt:message key="menu.des" />
			</p>

			<div class="d-flex" id="reserve-form">
				<div class="md:w-5/6 mx-auto">
					<div class="lg:col-span-10 mt-8">
						<div
							class="bg-white dark:bg-slate-900 border-0 shadow rounded-md p-3">
							<form action="/home/jobs" autocomplete="off" class=""
								method="get">
								<div class="registration-form text-dark text-start">
									<div id="filter_box"
										class="grid lg:grid-cols-12 md:grid-cols-6 relative items-center grid-cols-1 lg:gap-0 gap-6">
										<div
											class="filter-search-form lg:col-span-5 md:col-span-3 relative items-center flex filter-border">
											<i class="fa-solid fa-magnifying-glass"></i> <input
												type="text" onkeyup="displayResultSearch(this)"
												id="job-keyword" name="key"
												class="outline-none ps-4 lg:w-[260px] md:w-[120px]  form-control"
												placeholder="Nhập từ khóa">
										</div>
										<ul id="result_search"
											class="absolute hidden md:block bg-white w-[280px] z-5 rounded shadow top-12 left-0 ">

										</ul>


										<div
											class="filter-search-form flex items-center lg:col-span-3 md:col-span-2  filter-border">
											<i class="fa-solid fa-location-dot"></i> <select
												class="form-select outline-none w-full" name="lc" data-trigger
												name="choices-location" id="choices-location"
												aria-label="Default select example">
												<option value="">Tất cả thành phố</option>
												<option value="Hà Nội">Hà Nội</option>
												<option value="Hà Nam">Hà Nam</option>
												<option value="Hải Phòng">Hải Phòng</option>
												<option value="Thái Nguyên">Thái Nguyên</option>
												<option value="Nam Định">Nam Định</option>
												<option value="Thanh Hóa">Thanh Hóa</option>
												<option value="Nghệ An">Nghệ An</option>
												<option value="Hồ Chí Minh">Hồ Chí Minh</option>
												<option value="Thái Bình">Thái Bình</option>
												<option value="Khánh hòa">Khánh hòa</option>
												<option value="Cao Bằng">Cao Bằng</option>
											</select>
										</div>

										<div
											class="filter-search-form flex items-center lg:col-span-3 md:col-span-2  filter-border">
											<i class="fa-solid fa-users"></i> <select
												class="form-select outline-none w-full" name="cr" data-trigger
												name="choices-type" id="choices-type"
												aria-label="Default select example">
												<option value="0">Tất cả ngành nghề</option>
												<option value="129">Bán Hàng Kỹ Thuật</option>
												<option value="150">Bán Hàng Kỹ Thuật</option>
												<option value="130">Bán Hàng Qua Điện Thoại</option>
												<option value="151">Bán Hàng Qua Điện Thoại</option> 
												<option value="61">Bảo Hiểm</option>
												<option value="62">Bao Tiêu/Bảo Lãnh</option>
												<option value="153">Bảo trì/Bảo Dưỡng</option>
												<option value="106">Bảo Vệ</option>
											</select>
										</div>

										<button type="submit" id="search" style=""
											class="btn rounded lg:col-span-1 md:col-span-2 bg-emerald-600 hover:bg-emerald-700 border-emerald-600 hover:border-emerald-700 text-white searchbtn submit-btn px-2 py-1">
											Lọc<i class="fa-solid fa-filter ms-1"></i>
										</button>
									</div>
									<!--end grid-->

								</div>
								<!--end container-->
							</form>
						</div>
					</div>
					<!--ed col-->
				</div>
			</div>
			<!--end grid-->

			<div class="mt-4">
				<span class="text-slate-400"><span class="text-dark">Popular
						Searches :</span> Designer, Developer, Web, IOS, PHP Senior Engineer</span>
			</div>

			<div
				class="absolute -top-20 hidden md:block  start-1/2 -translate-x-1/2">
				<div
					class="w-10 h-10 animate-[bounce_2s_infinite] bg-white dark:bg-slate-900 flex items-center justify-center shadow dark:shadow-gray-700 rounded-md">
					<img src="/home/img/facebook-logo.png" class="h-6 w-6" alt="">
				</div>
			</div>

			<div class="absolute top-[20%] hidden md:block  start-10">
				<div
					class="w-10 h-10 animate-[spin_5s_linear_infinite] bg-white dark:bg-slate-900 flex items-center justify-center shadow dark:shadow-gray-700 rounded-md">
					<img src="/home/img/google-logo.png" class="h-6 w-6" alt="">
				</div>
			</div>

			<div class="absolute top-[20%] hidden md:block end-1">
				<div
					class="w-10 h-10 bg-white dark:bg-slate-900 flex items-center justify-center shadow dark:shadow-gray-700 rounded-md">
					<img src="/home/img/android.png" class="h-6 w-6" alt="">
				</div>
			</div>

			<div class="absolute top-3/4 hidden md:block start-1">
				<div
					class="w-10 h-10 bg-white dark:bg-slate-900 flex items-center justify-center shadow dark:shadow-gray-700 rounded-md">
					<img src="/home/img/lenovo-logo.png" class="h-6 w-6" alt="">
				</div>
			</div>

			<div class="absolute top-3/4 hidden md:block  end-10">
				<div
					class="w-10 h-10 animate-[spin_5s_linear_infinite] bg-white dark:bg-slate-900 flex items-center justify-center shadow dark:shadow-gray-700 rounded-md">
					<img src="/home/img/skype.png" class="h-6 w-6" alt="">
				</div>
			</div>

			<div
				class="absolute -bottom-32 hidden md:block  start-1/2 -translate-x-1/2">
				<div
					class="w-10 h-10 animate-pulse bg-white dark:bg-slate-900 flex items-center justify-center shadow dark:shadow-gray-700 rounded-md">
					<img src="/home/img/snapchat.png" class="h-6 w-6" alt="">
				</div>
			</div>
		</div>
		<!--end grid-->
	</div>
	<!--end container-->
</section>
<!--end section-->
<!-- End Hero -->