<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- ======= Header ======= -->
<jsp:include page="../header.jsp" flush="true"></jsp:include>

<main id="main pt-24" class="bg-slate-50">
    <div class="grid md:grid-cols-12 grid-cols-1 p-6 mt-6 gap-[30px]">
       <div class="lg:col-span-4 md:col-span-3 bg-white rounded-md shadow">
       		<div class="py-2 flex flex-col items-center">
       			<img src="/adv/adimgs/WIN_20220924_14_32_07_Pro.jpg" alt="Profile" class="rounded-full size-24 text-center">
       			<p class="text-center font-bold text-xl">Phan Kim Sinh</p>
       		</div>
		    <div class="flex flex-col">
		      <a href="/home/profile?act=home" class="p-2 text-center  text-gray-700 font-bold hover:bg-gray-300 hover:bg-opacity-40 ${act eq 'home' ? 'bg-indigo-200' : ''}"
		        data-tab-target="#tab1">Hồ sơ</a>
		      <a href="/home/profile?act=savejob" class="p-2 text-center font-bold hover:bg-gray-300 hover:bg-opacity-40 text-gray-700 ${act eq 'savejob' ? 'bg-indigo-200' : ''}"
		        data-tab-target="#tab2">Tin tuyển dụng đã lưu</a>
		      <a href="/home/profile?act=setting" class="p-2 text-center font-bold hover:bg-gray-300 hover:bg-opacity-40 text-gray-700 ${act eq 'setting' ? 'bg-indigo-200' : ''}"
		        data-tab-target="#tab3">Cài đặt</a>
		    </div>
	   </div>
    	<div class="lg:col-span-8 md:col-span-9 bg-white rounded-md shadow p-6">
	      <div id="tab1" class="${act eq 'home' ? '' : 'hidden'}  tab-content text-gray-700">
	        <h4 class="font-bold mt-2 mb-4 text-2xl">Hồ sơ cá nhân</h4>
	        <p class="text-xl">Lorem ipsum dolor sit amet consectetur adipisicing elit.
	          Lorem ipsum dolor sit amet consectetur, adipisicing elit. Molestiae quidem impedit doloremque explicabo illum
	          quos.
	          Molestias aspernatur rem itaque doloribus culpa similique rerum provident id quos sed.</p>
	
	      </div>
	      <div id="tab2" class="${act eq 'savejob' ? '' : 'hidden'} tab-content text-gray-700">
	        <h4 class="font-bold mt-9 mb-4 text-2xl">Tin tuyển dụng đã lưu</h4>
	        	<c:if test="${jobsave.size() <= 0}">
				    <h1>Không có tin tuyển dụng nào</h1>
				</c:if>
				<c:forEach items="${jobsave}" var="i" varStatus="loop">
				<div class="group mt-4 relative overflow-hidden bg-white  shadow-lg rounded-md transition-all duration-500 h-fit"
					>
					<div class="p-6">
						<div class="flex items-center">
							<div
								class="size-14 min-w-[56px] flex items-center justify-center bg-white  shadow dark:shadow-gray-700 rounded-md">
								<img src="${i.company.company_logo }" class="size-8" alt="">
							</div>
							<div class="ms-3">
								<a href="/home/jobs/detail?id=87"
									class="inline-block text-[16px] font-semibold hover:text-emerald-600 transition-all duration-500 me-1">${i.job_title}</a> <span
									class="inline-block text-sm text-true">${i.job_expiration_date }</span>
								<div>
									<p class="text-slate-400">${i.company.company_name }</p>
								</div>
							</div>
						</div>
					</div>
					
					<a href="/home/profile/savejob/del?id=${i.job_id }"
						id="save-87"
						class="btn  btn-icon px-2 py-2 rounded-full bg-emerald-600/5 hover:bg-emerald-600 border-emerald-600/10  text-emerald-600 hover:text-white absolute top-0 end-0 m-3">
						<i class="fa-solid fa-trash"></i>
					</a>
				</div>
				</c:forEach>
			</div>
	      <div id="tab3" class="${act eq 'setting' ? '' : 'hidden'} tab-content text-gray-700">
	        <h4 class="font-bold mt-9 mb-4 text-2xl">Contact Info</h4>
	        <p class="text-xl">Phone no : 0987654321 <br>Address : Netherland</p>
	      </div>
    </div>
    </div>
</main>
<!-- End #main -->

 
<jsp:include page="../footer.jsp" flush="true"></jsp:include>
