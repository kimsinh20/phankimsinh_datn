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
				<img src="${user.user_avatar }" alt="Profile"
					class="rounded-full size-24 text-center">
				<p class="text-center font-bold text-xl">${user.user_name }</p>
			</div>
			<div class="flex flex-col">
				<a href="/home/profile?act=home"
					class="p-2 text-center  text-gray-700 font-bold hover:bg-gray-300 hover:bg-opacity-40 ${act eq 'home' ? 'bg-indigo-200' : ''}"
					data-tab-target="#tab1">Hồ sơ</a> <a href="/home/profile?act=apply"
					class="p-2 text-center font-bold hover:bg-gray-300 hover:bg-opacity-40 text-gray-700 ${act eq 'apply' ? 'bg-indigo-200' : ''}"
					data-tab-target="#tab2">Tin tuyển dụng đã ứng tuyển</a> <a
					href="/home/profile?act=savejob"
					class="p-2 text-center font-bold hover:bg-gray-300 hover:bg-opacity-40 text-gray-700 ${act eq 'savejob' ? 'bg-indigo-200' : ''}"
					data-tab-target="#tab3">Tin tuyển dụng đã lưu</a> <a
					href="/home/profile?act=setting"
					class="p-2 text-center font-bold hover:bg-gray-300 hover:bg-opacity-40 text-gray-700 ${act eq 'setting' ? 'bg-indigo-200' : ''}"
					data-tab-target="#tab4">Cài đặt</a>
			</div>
		</div>
		<div
			class="lg:col-span-8 md:col-span-9 bg-white rounded-md shadow p-6">
			<div id="tab1"
				class="${act eq 'home' ? '' : 'hidden'}  tab-content text-gray-700">
				<h4 class="font-bold mt-2 mb-4 text-2xl">Hồ sơ cá nhân</h4>
				<form method="POST" enctype="multipart/form-data">
				 	<div class="grid  md:grid-cols-2 grid-cols-1 gap-4">
					<div class="">
						<label for="profileImage" class="text-xl font-bold">Hình
							Ảnh</label>
						<div class="">
							<img src="${user.user_avatar }" id="blah" alt="Profile" class="rounded-full size-32">
							<div class="mt-2">
								<input type="file" value="/adv/adimgs/baocao_nhom20.pdf"
									name="avatar"
									onchange="document.getElementById('blah').src = window.URL.createObjectURL(this.files[0])">
							</div>
						</div>
					</div>
					<div class="">
						<label for="fullName" class="text-xl font-bold">Họ
							và tên</label>
						<div class="">
							<div class="">
								<input name="txtFullName" type="text" class="w-full py-2 mt-3 border border-2"
									id="fullName" value="${user.user_fullname }">
							</div>
						</div>
					</div>
					
					<div class="">
						<label for="date" class="text-xl font-bold">Ngày Sinh</label>
						<div class="col-md-9 col-lg-10">
							<input name="txtBirthday" type="date" class="w-full py-2 mt-3 border border-2"
								id="date" value="${user.user_birthday }">
						</div>
					</div>
					<div class="">
					<label for="date" class="text-xl font-bold">Giới tính</label>
						<div class="">
							<select class="w-full py-2 mt-3 border border-2" id="slcGender" name="slcGender">
								<option value="0">----</option>
								  <option  value="1" ${user.user_gender eq 1 ? 'selected' : ''}>Nam</option>
    							  <option value="2" ${user.user_gender eq 2 ? 'selected' : ''}>Nữ</option>
							</select>
						</div>
					</div>
					<div class="">
						<label for="Job" class="text-xl font-bold">Nghề nghiệp</label>
						<div class="">
							<input name="txtJob" type="text" class="w-full py-2 mt-3 border border-2" id="Job"
								value="${user.user_job }">
						</div>
					
					</div>
					<div class="">
							<label for="Country" class="text-xl font-bold">Lĩnh
							vực</label>
						<div class="">
							<input name="txtJobArea" type="text" class="w-full py-2 mt-3 border border-2"
								id="Country" value="${user.user_jobarea }">
						</div>
					</div>
					<div class="">
						<label for="Address" class="text-xl font-bold">Địa
							chỉ</label>
						<div class="">
							<input name="txtAddress" type="text" class="w-full py-2 mt-3 border border-2"
								id="Address" value="${user.user_address }">
						</div>
					</div>
					<div class="">
						<label for="txtPhone" class="text-xl font-bold">Điện
							thoại</label>
						<div class="col-md-9 col-lg-10">
							<div class="input-group">
								<input name="txtHomePhone" type="text" class="w-full py-2 mt-3 border border-2"
									placehoder="Home phone" id="homePhone" value="${user.user_homephone }"><input
									name="txtOfficePhone" type="text" class="w-full py-2 mt-3 border border-2"
									placehoder="Office phone" id="officePhone" value="${user.user_officephone }"><input
									name="txtMobilePhone" type="text" class="w-full py-2 mt-3 border border-2"
									placehoder="Mobile phone" id="mobilePhone" value="${user.user_mobilephone }">
							</div>
						</div>
					</div>
					<div class="">
						<label for="Email" class="text-xl font-bold">Hộp
							thư</label>
						<div class="">
							<input name="txtEmail" type="email" class="w-full py-2 mt-3 border border-2"
								id="Email" value="${user.user_email }">
						</div>
					</div>
					<div class="">
						<label for="Email" class="text-xl font-bold">CV <a class="text-true" target="_blank" href="${user.client_profiles}">${user.client_profiles}</a></label>
						<div class="">
							<input name="txtCV" type="file" class="w-full py-2 mt-3 border border-2"
								id="cv" >
						</div>
					</div>
					</div>
					<input type="hidden" name="idForPost" value="${user.user_id }">
						<input type="hidden"
						name="action" value="edit">
					<div class="text-center mt-3">
						<button type="submit" class="bg-emerald-600 text-white py-2 px-3 rounded">
							<i class="far fa-save me-2"></i>Lưu thay đổi
						</button>
				
					</div>
				</form>

			</div>
			<div id="tab2"
				class="${act eq 'apply' ? '' : 'hidden'} tab-content text-gray-700">
				<h4 class="font-bold mt-9 mb-4 text-2xl">Tin tuyển dụng ứng
					tuyển</h4>
				<c:if test="${jobapply.size() <= 0}">
					<h1>Bạn chưa ứng tuyển tin tuyển dụng nào</h1>
				</c:if>
				<c:forEach items="${jobapply}" var="i" varStatus="loop">
					<div
						class="group mt-4 relative overflow-hidden bg-white  shadow-lg rounded-md transition-all duration-500 h-fit">
						<div class="p-6">
							<div class="flex items-center">
								<div
									class="size-14 min-w-[56px] flex items-center justify-center bg-white  shadow dark:shadow-gray-700 rounded-md">
									<img src="${i.job.company.company_logo }" class="size-8" alt="">
								</div>
								<div class="ms-3">
									<a href="/home/jobs/detail?id=${i.job.job_id }"
										class="inline-block text-[16px] font-semibold hover:text-emerald-600 transition-all duration-500 me-1">${i.job.job_title}</a>
									<span class="inline-block text-sm text-true">${i.job.job_expiration_date }</span>
									<div>
										<p class="text-slate-400">${i.job.company.company_name }</p>
									</div>
									<div>
									 <c:choose>
									  <c:when test="${i.applications_status eq 0}">
									    <p style="color: #f5ce42;">Trạng thái : Chưa xem</p>
									  </c:when>
									  <c:when test="${i.applications_status eq 1}">
									    <p style="color: green;">Trạng thái : Lọc hồ sơ</p>
									  </c:when>
									  <c:when test="${i.applications_status eq 2}">
									    <p style="color: green;">Trạng thái : Phỏng vấn</p>
									  </c:when>
									  <c:when test="${i.applications_status eq 3}">
									    <p style="color: green;">Trạng thái : Đã chọn</p>
									  </c:when>
									  <c:when test="${i.applications_status eq 4}">
									    <p style="color: red;">Trạng thái : Đã từ chối</p>
									  </c:when>
									  <c:when test="${i.applications_status eq 5}">
									    <p style="color: red;">Trạng thái : Không thành công</p>
									  </c:when>
									</c:choose>
									</div>
								</div>
							</div>
						</div>

						<a href="${i.applications_cv}" target="_blank" id="save-87"
							class="btn btn-icon px-2 py-2 rounded-full bg-emerald-600/5 hover:bg-emerald-600 border-emerald-600/10  text-emerald-600 hover:text-white absolute top-0 end-0 m-3">
							<i class="fa-solid fa-eye me-2"></i>xem CV
						</a>
					</div>
				</c:forEach>
			</div>
			<div id="tab3"
				class="${act eq 'savejob' ? '' : 'hidden'} tab-content text-gray-700">
				<h4 class="font-bold mt-9 mb-4 text-2xl">Tin tuyển dụng đã lưu</h4>
				<c:if test="${jobsave.size() <= 0}">
					<h1>Không có tin tuyển dụng nào</h1>
				</c:if>
				<c:forEach items="${jobsave}" var="i" varStatus="loop">
					<div
						class="group mt-4 relative overflow-hidden bg-white  shadow-lg rounded-md transition-all duration-500 h-fit">
						<div class="p-6">
							<div class="flex items-center">
								<div
									class="size-14 min-w-[56px] flex items-center justify-center bg-white  shadow dark:shadow-gray-700 rounded-md">
									<img src="${i.company.company_logo }" class="size-8" alt="">
								</div>
								<div class="ms-3">
									<a href="/home/jobs/detail?id=${i.job_id }"
										class="inline-block text-[16px] font-semibold hover:text-emerald-600 transition-all duration-500 me-1">${i.job_title}</a>
									<span class="inline-block text-sm text-true">${i.job_expiration_date }</span>
									<div>
										<p class="text-slate-400">${i.company.company_name }</p>
									</div>
								</div>
							</div>
						</div>

						<a href="/home/profile/savejob/del?id=${i.job_id }" id="save-87"
							class="btn  btn-icon px-2 py-2 rounded-full bg-emerald-600/5 hover:bg-emerald-600 border-emerald-600/10  text-emerald-600 hover:text-white absolute top-0 end-0 m-3">
							<i class="fa-solid fa-trash"></i>
						</a>
					</div>
				</c:forEach>
			</div>
			<div id="tab4"
				class="${act eq 'setting' ? '' : 'hidden'} tab-content text-gray-700">
				<a class="font-bold mt-9 mb-4 text-2xl text-false" href="/home/logout">Đăng xuất</a>
			</div>
		</div>
	</div>
</main>
<!-- End #main -->


<jsp:include page="../footer.jsp" flush="true"></jsp:include>
