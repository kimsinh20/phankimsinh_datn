<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- ======= Header ======= -->
<jsp:include page="../header.jsp" flush="true"></jsp:include>

<main id="main pt-24" class="bg-slate-50">
	<div class="container">
		<div class="grid md:grid-cols-1 grid-cols-1 mt-2 gap-[30px]">
			<form action="/home/blogs/list" id="fn_blogs" method="get">
			<div class="">
				<h1 class="text-2xl font-semibold text-slate-800">Cẩm nang tìm việc</h1>
				<p class="text-lg font-normal text-slate-600 my-3">Tìm hiểu các bài viết , tin tức về thị trường việc làm mới nhất</p>
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
					<input type="text" value="${q}" name="q" 
						class="outline-none h-[40px] ps-4 w-[320px] md:w-[400px]"
						placeholder="Nhập từ khóa"  autocomplete="off" style="margin-right: 16px"
						maxlength="150" id="company-search-input">
							<button type="submit"
						class="text-md rounded shadow bg-green-400 text-white font-bold px-3 py-2 w-20"
						style="" data-id="btn-search">Tìm</button>
				</div>
			</div>
			
			<div class="lg:col-span-12 md:col-span-12">
				<div class="flex justify-between items-center bg-white px-4 py-2">
					<h3 class="py-2 text-lg font-medium">Chuyên mục : ${view[3]}</h3>
					<div>
					<label class="font-semibold">Thể loại</label> 
					<select
									class="form-select outline-none w-[160px] md:w-[320px] form-input border border-slate-100 dark:border-slate-800 block w-full mt-1"
									name="c" onchange="submitForm('fn_blogs')"> ${view[1]}
					  </select>
					</div>
					
				</div>
				<input value="${section_id}" name="id" hidden>
				<div class="flex items-center bg-white px-4 py-2">
					<span class="me-2">Sắp xếp theo : </span> ${view[2]}
				</div>
				<!--list job-->
				${view[0]}
				<!--end grid-->
				<!--phân trang-->
			</div>
			</form>
		</div>
	</div> <!-- end container -->

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