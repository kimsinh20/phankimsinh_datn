<%@page import="jsoft.objects.UserObject"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<fmt:setLocale value="${sessionScope.lang}" />
<fmt:setBundle basename="lang.lang" />
<jsp:include page="data.jsp" flush="true"></jsp:include>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8" />
<title>
	<%
	String title = (String) session.getAttribute("title");
	if (title != null && !title.equalsIgnoreCase("")) {
		out.append(title);
	} else {
		out.append("Jobnow");
	}
	%>
</title>
<meta content="width=device-width, initial-scale=1.0" name="viewport" />
<meta content="" name="keywords" />
<meta content="" name="description" />

<!-- Favicon -->

<link href="/home/img/logo.jpg" rel="icon">
<link href="/home/img/logo.jpg" rel="apple-touch-icon">

<!-- Google Web Fonts -->
<link rel="preconnect" href="https://fonts.googleapis.com" />
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin />
<link
	href="https://fonts.googleapis.com/css2?family=Heebo:wght@400;500;600&family=Inter:wght@700;800&display=swap"
	rel="stylesheet" />

<!-- Icon Font Stylesheet -->
<link
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.1/css/all.min.css"
	rel="stylesheet" />
<!-- Libraries Stylesheet -->
<link href="/home/dist/output.css" rel="stylesheet">
<!-- Customized Bootstrap Stylesheet -->
<!-- <link href="css/bootstrap.min.css" rel="stylesheet" /> -->
<link href="/home/vendor/aos/aos.css" rel="stylesheet">
<!-- Template Stylesheet -->
<link href="/home/css/style.css" rel="stylesheet" />
<link rel="stylesheet" type="text/css"
	href="https://cdn.jsdelivr.net/npm/toastify-js/src/toastify.min.css">
<script type="text/javascript"
	src="https://cdn.jsdelivr.net/npm/toastify-js"></script>
</head>

<body>
	<div class="bg-white px-0">
		<header
			class="header z-[5] bg-gray-100 flex justify-between text-white items-center fixed w-full">
			<div class=" ">
				<a href="/home"
					class="text-2xl ms-2 font-[Poppins] cursor-pointer flex items-center">
					<img class="h-10 inline rounded" src="/home/img/logo.jpg">
					<h1 class="w-20 mr-6 ml-2">JobNow</h1>
				</a>
			</div>
			<!-- Navbar Start -->
			<nav
				class="w-full md:flex md:items-center pe-5 justify-between z-[5] md:z-auto md:static absolute w-full left-0 md:w-auto md:py-0 py-2 md:pl-0 pl-7 md:opacity-100 top-[-400px] transition-all ease-in duration-500">
				<ul
					class="flex justify-center md:items-center  flex-col md:flex-row ">
					<li
						class="relative me-4 max-w-fit pr-3 md:pr-0 py-1 after:bg-gradient-to-r from-[#2b68e0] to-[#e710ea]  after:absolute after:h-1 after:w-0 after:bottom-0 after:left-0 hover:after:w-full after:transition-all after:duration-300">
						<a href="/home"
						class="text-md hover:text-cyan-500 duration-500 font-semibold"><i
							class="fa-solid fa-house me-2"></i> <fmt:message key="menu.home" /></a>
					</li>

					<li id="menu-job"
						class="group inline-block relative me-4 max-w-fit pr-3 md:pr-0 py-1 after:bg-gradient-to-r from-[#2b68e0] to-[#e710ea]  after:absolute after:h-1 after:w-0 after:bottom-0 after:left-0 hover:after:w-full after:transition-all after:duration-300">
						<button class="text-md flex items-center hover:text-cyan-500">
							<span class="pr-1 font-semibold flex-1"><i
								class="fa-solid fa-user-doctor me-1"></i> <fmt:message
									key="menu.job" /></span> <span> <svg
									class="fill-current h-4 w-4 transform group-hover:-rotate-180
        					transition duration-150 ease-in-out"
									xmlns="http://www.w3.org/2000/svg" viewBox="0 0 20 20">
        						<path
										d="M9.293 12.95l.707.707L15.657 8l-1.414-1.414L10 10.828 5.757 6.586 4.343 8z" />
      					</svg>
							</span>
						</button>
						<ul
							class="parent-menu text-gray-500 bg-slate-100 border rounded shadow transform scale-0 group-hover:scale-100 absolute transition duration-150 ease-in-out origin-top min-w-32">
							<li
								class="rounded-sm px-3 py-1 hover:bg-emerald-600 hover:text-white">
								<a href="/home/jobs/?sort=lasted">Việc làm mới nhất</a>
							</li>
							<li
								class="rounded-sm px-3 py-1 hover:bg-emerald-600 hover:text-white">
								<a href="/home/jobs">Việc làm phù hợp</a>
							</li>
							<li
								class="rounded-sm sub relative px-3 py-1 hover:bg-emerald-600 hover:text-white">
								<button
									class="w-full text-left flex items-center outline-none focus:outline-none">
									<span class="pr-1 flex-1">Việc làm theo thành phố</span> <span
										class="mr-auto"> <svg
											class="fill-current h-4 w-4
            							transition duration-150 ease-in-out"
											xmlns="http://www.w3.org/2000/svg" viewBox="0 0 20 20">
            <path
												d="M9.293 12.95l.707.707L15.657 8l-1.414-1.414L10 10.828 5.757 6.586 4.343 8z" />
          </svg>
									</span>
								</button>
								<ul
									class="sub-menu bg-slate-100 rounded border shadow absolute hidden right-0 top-0 transition duration-150 ease-in-out origin-top-left min-w-32">
									<li
										class="rounded-sm px-3 py-1 hover:bg-emerald-600 text-gray-500 hover:text-white">
										<a href="/home/jobs/?lc=Hà Nội">Hà Nội</a>
									</li>
									<li
										class="rounded-sm px-3 py-1 hover:bg-emerald-600 text-gray-500 hover:text-white">
										<a href="/home/jobs/?lc=Hồ Chí Minh">Hồ Chí Minh</a>
									</li>
									<li
										class="rounded-sm px-3 py-1 hover:bg-emerald-600 text-gray-500 hover:text-white">
										<a href="/home/jobs/?lc=Đà Nẵng">Đà Nẵng</a>
									</li>
								</ul>
							</li>
							<li
								class="rounded-sm sub relative px-3 py-1 hover:bg-emerald-600 hover:text-white">
								<button
									class="w-full text-left flex items-center outline-none focus:outline-none">
									<span class="pr-1 flex-1">Việc làm theo ngành nghề</span> <span
										class="mr-auto"> <svg
											class="fill-current h-4 w-4
            							transition duration-150 ease-in-out"
											xmlns="http://www.w3.org/2000/svg" viewBox="0 0 20 20">
            <path
												d="M9.293 12.95l.707.707L15.657 8l-1.414-1.414L10 10.828 5.757 6.586 4.343 8z" />
          </svg>
									</span>
								</button>
								<ul
									class="sub-menu bg-slate-100 rounded border shadow absolute hidden right-0 top-0 transition duration-150 ease-in-out origin-top-left min-w-32">
									<li
										class="rounded-sm px-3 py-1 hover:bg-emerald-600 text-gray-500 hover:text-white">
										<a href="/home/jobs/?cr=90">Viễn Thông</a>
									</li>
									<li
										class="rounded-sm px-3 py-1 hover:bg-emerald-600 text-gray-500 hover:text-white">
										<a href="/home/jobs/?cr=78">Chuyển Đổi Số</a>
									</li>
									<li
										class="rounded-sm px-3 py-1 hover:bg-emerald-600 text-gray-500 hover:text-white">
										<a href="/home/jobs/?cr=79">Data Engineer/Data Analyst/AI</a>
									</li>
									<li
										class="rounded-sm px-3 py-1 hover:bg-emerald-600 text-gray-500 hover:text-white">
										<a href="/home/jobs/?cr=80">IT Support/Help Desk</a>
									</li>
								</ul>
							</li>
							<li
								class="rounded-sm px-3 py-1 hover:bg-emerald-600 hover:text-white">
								<a href="/home/fields">Việc làm theo lĩnh vực</a>
							</li>
						</ul>
					</li>

					<li
						class="relative me-4 max-w-fit pr-3 md:pr-0 py-1 after:bg-gradient-to-r from-[#2b68e0] to-[#e710ea]  after:absolute after:h-1 after:w-0 after:bottom-0 after:left-0 hover:after:w-full after:transition-all after:duration-300">
						<a href="/home/company"
						class="text-md hover:text-cyan-500 duration-500 font-semibold"><i
							class="fa-solid fa-building me-1"></i> <fmt:message
								key="menu.companies" /> </a>
					</li>
					<li id="menu-job"
						class="group inline-block relative me-4 max-w-fit pr-3 md:pr-0 py-1 after:bg-gradient-to-r from-[#2b68e0] to-[#e710ea]  after:absolute after:h-1 after:w-0 after:bottom-0 after:left-0 hover:after:w-full after:transition-all after:duration-300">
						<button class="text-md flex items-center hover:text-cyan-500">
							<span class="pr-1 font-semibold flex-1"><i
								class="fa-solid fa-user-doctor me-1"></i> <fmt:message
									key="menu.jobofme" /></span> <span> <svg
									class="fill-current h-4 w-4 transform group-hover:-rotate-180
        					transition duration-150 ease-in-out"
									xmlns="http://www.w3.org/2000/svg" viewBox="0 0 20 20">
        						<path
										d="M9.293 12.95l.707.707L15.657 8l-1.414-1.414L10 10.828 5.757 6.586 4.343 8z" />
      					</svg>
							</span>
						</button>
						<ul
							class="parent-menu text-gray-500 bg-slate-100 border rounded shadow transform scale-0 group-hover:scale-100 absolute transition duration-150 ease-in-out origin-top min-w-32">
							<li
								class="rounded-sm px-3 py-1 hover:bg-emerald-600 hover:text-white">
								<a href="/home/profile">Việc đã lưu </a>
							</li>
							<li
								class="rounded-sm px-3 py-1 hover:bg-emerald-600 hover:text-white">
								<a href="/home/profile">Việc đã ứng tuyển</a>
							</li>
							<li
								class="rounded-sm px-3 py-1 hover:bg-emerald-600 hover:text-white">
								<a href="/home/jobs">Việc đành cho bạn</a>
							</li>
						</ul>
					</li>
					<li
						class="relative me-4 max-w-fit pr-3 md:pr-0 py-1 after:bg-gradient-to-r from-[#2b68e0] to-[#e710ea]  after:absolute after:h-1 after:w-0 after:bottom-0 after:left-0 hover:after:w-full after:transition-all after:duration-300 ">
						<a href="/home/blogs"
						class="text-md hover:text-cyan-500 duration-500 font-semibold"><i
							class="fa-solid fa-newspaper me-1"> </i> <fmt:message
								key="menu.blog" /></a>
					</li>
				</ul>
				
				<ul
					class="flex md:items-center justify-between  flex-col md:flex-row ">
						<%
					String lang = (String) session.getAttribute("lang");
					String imageSrc = "/home/img/vn.png";
					String linkHref = "?lang=vi_VN";

					if (lang != null && lang.equals("vi_VN")) {
						imageSrc = "/home/img/en.png";
						linkHref = "?lang=en_US";
					}
					%>
						<li class="">
					<a href="<%=linkHref%>" id="nav_lang" class="">
						<img class="rounded h-6 w-10" id="svg1" src="<%=imageSrc%>"
						alt="lang">
					</a>
					</li>
					<li>
					
					<a href="/home/recruiter"
						class="text-sm ml-2 md:my-0 text-center md:text-sm rounded-md bg-emerald-600 md:py-2 md:px-1 px-2 py-1 text-white shadow-sm"><i
						class="fa-solid fa-users me-1"></i> <fmt:message
							key="menu.employer" /></a>
					</li>
					
				
					<%
					UserObject user = (UserObject) request.getSession().getAttribute("clientLogined");
					%>
					<%
					if (user != null) {
					%>
					<li
						class="ml-2 flex relative cursor-pointer items-center pe-0 show" onclick="toggle()" id="nav_login">
						 <img
						src="/adv/adimgs/WIN_20220924_14_32_07_Pro.jpg" alt="Profile"
						class="rounded-full size-8"> <span
						class="hidden md:block dropdown-toggle ms-2"><%=user.getUser_name()%><i class="fa-solid fa-caret-down ms-1"></i></span>
						
				
					<ul id="nav_profile" class="nav_profile p-3 overflow-hidden absolute hidden rounded shadow-lg text-slate-900 right-0 bg-white" style="top: 40px;min-width: 240px;"
							>
							<li class="py-1 hover:bg-gray-100">
							
							<a class=" flex items-center"
								href="users-profile.html"><i class="fa-solid fa-address-card me-1"></i><span>My
										Profile</span></a></li>
							<li class="py-1 hover:bg-gray-100"><a class=" flex items-center"
								href="users-profile.html"><i class="fa-solid fa-gear me-1"></i><span >Account
										Settings</span></a></li>
							<li class="py-1 hover:bg-gray-100"><a class=" flex items-center"
								href="pages-faq.html"><i class="fa-solid fa-handshake-angle me-1"></i><span>Need
										Help?</span></a></li>
							<li class="py-1 hover:bg-gray-100"><a class=" flex items-center"
								href="/home/logout"><i class="fa-solid fa-right-from-bracket me-1"></i><span>Sign
										Out</span></a></li>
						</ul>
					</li>
					<!-- End Profile Image Icon -->

					<!-- End Profile Dropdown Items -->
					<%
					} else {
					%>
					<button onclick="showDialog()" data-modal-target="default-modal"
						data-modal-toggle="default-modal" id="nav_login"
						class="inline-flex w-48 my-2 md:my-0 justify-center items-center rounded-md bg-rose-600 px-3 py-2 text-sm font-semibold text-white shadow-sm hover:bg-red-400 sm:ml-3 sm:w-auto">
						<i class="fa-solid fa-user me-1 text-md inline-flex items-center"></i>
						<fmt:message key="menu.login" />
					</button>
					<%
					}
					%>
					<!-- Main modal -->
					<div class="relative z-10" aria-labelledby="modal-title"
						role="dialog" aria-modal="true">
						<div id="bg_dialog"
							class="fixed hidden inset-0 bg-gray-500 bg-opacity-75 transition-opacity duration-500"></div>

						<div id="dialog"
							class="fixed hidden inset-0 z-10 w-screen overflow-y-auto">
							<div
								class="flex min-h-full items-end justify-center text-center sm:items-center sm:p-0">
								<div
									class="relative transform overflow-hidden rounded-lg bg-white text-left shadow-xl transition-all sm:my-8 sm:w-full sm:max-w-lg">
									<div class="bg-white sm:p-0 sm:pb-4 h-screen">
										<div class="">
											<section class="bg-gray-50">
												<div
													class="flex flex-col items-center justify-center px-4 py-4 mx-auto md:h-screen lg:py-0">
													<a href="#"
														class="flex items-center mb-6 text-2xl font-semibold text-true">
														<img class="w-8 h-8 mr-2" src="/home/img/logo.jpg"
														alt="logo"> JobNow
													</a>
													<div
														class="w-full bg-white rounded-lg shadow dark:border md:mt-0 sm:max-w-md xl:p-0 dark:bg-gray-800 dark:border-gray-700">
														<div class="p-2 space-y-2 md:space-y-4 sm:p-4">
															<h1
																class="text-lg text-center font-bold leading-tight tracking-tight text-true md:text-2xl">
																Đăng nhập tài khoản của bạn</h1>
															<form class="space-y-2 " action="#">
																<div class="">
																	<label for="username"
																		class="block mb-2 text-sm font-medium text-slate-900">Tên
																		đăng nhập</label> <input type="text"
																		onkeyup="checkValiLogin()" name="username"
																		id="username"
																		class="bg-gray-50 border border-gray-300 text-slate-900 sm:text-sm rounded-lg focus:ring-primary-600 focus:border-primary-600 block w-full p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500"
																		placeholder="nhập tên đăng nhập" required="">
																	<div class="p-0 m-0 rounded px-2" id="errName"></div>
																</div>
																<div class="">
																	<label for="password"
																		class="block mb-2 text-sm font-medium text-slate-900">Mật khẩu</label> <input type="password" onkeyup="checkValiLogin()"
																		name="password" id="password" placeholder="••••••••"
																		class="bg-gray-50 border border-gray-300 text-slate-900 sm:text-sm rounded-lg focus:ring-primary-600 focus:border-primary-600 block w-full p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500"
																		required="">
																	<div class="p-0 m-0 rounded px-2" id="errPass"></div>
																</div>
																<div
																	class="bg-gray-50 mt-0 px-2 py-2 flex flex-col flex-col-reverse">

																	<button type="button" onclick="hideDialog()"
																		class="mt-2 inline-flex w-full justify-center rounded-md bg-rose-600 px-3 py-2 text-sm font-semibold text-white shadow-sm hover:bg-emerald-600 sm:w-auto">Hủy</button>
																	<button type="button" id="btn-login"
																		onclick="handleLogin()"
																		class="inline-flex mt-2 w-full justify-center rounded-md bg-rose-600 px-3 py-2 text-sm font-semibold text-white shadow-sm hover:bg-emerald-600 sm:w-auto"
																		disabled>Đăng nhập</button>
																</div>
																<div class="flex items-center justify-between mt-3">
																	<a href="#"
																		class="text-sm font-medium text-true hover:underline dark:text-primary-500">Quên
																		mật khẩu?</a>
																</div>
																<p
																	class="text-sm font-light text-gray-500  mt-3 dark:text-gray-400">
																	Bạn chưa có tài khoản? <a href="#"
																		class="font-medium text-primary-600 hover:underline dark:text-primary-500">Đăng
																		ký ngay</a>
																</p>
															</form>
														</div>
													</div>
												</div>
											</section>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
					<!-- end modal -->

				</ul>
			</nav>
			<!-- Navbar End -->
			<span class="text-2xl cursor-pointer mx-2 md:hidden block">
				<div class="flex items-center">
					<a href="<%=linkHref%>" class="md:my-0 me-2"> <img
						class="rounded h-7 w-10" id="svg1" src="<%=imageSrc%>" alt="lang">
					</a>
					<%
					if (user != null) {
					%>
					<li
						class="ml-2 flex relative cursor-pointer items-center pe-0 show" onclick="toggle()" id="nav_login">
						 <img
						src="/adv/adimgs/WIN_20220924_14_32_07_Pro.jpg" alt="Profile"
						class="rounded-full size-8"> <span
						class="hidden md:block dropdown-toggle ms-2"><%=user.getUser_name()%></span>
						<a href="/home/logout" class="text-sm underline">logout</a>
					</li>
					<!-- End Profile Image Icon -->

					<!-- End Profile Dropdown Items -->
					<%
					} else {
					%>
					<button onclick="showDialog()" data-modal-target="default-modal"
						data-modal-toggle="default-modal"
						class="inline-flex  me-2 md:my-0 justify-center rounded-md bg-rose-600 px-2 py-1 text-sm font-semibold text-white shadow-sm hover:bg-red-400 sm:ml-3 sm:w-auto">
						<fmt:message key="menu.login" />
					</button>
					<%
					}
					%>
					
					<ion-icon class="ms-2" name="menu" onclick="Menu(this)"></ion-icon>
				</div>

			</span>
		</header>