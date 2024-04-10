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
<title>Jobnow</title>
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
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.4.1/font/bootstrap-icons.css"
	rel="stylesheet" />

<!-- Libraries Stylesheet -->
<link href="/home/dist/output.css" rel="stylesheet">
<!-- Customized Bootstrap Stylesheet -->
<!-- <link href="css/bootstrap.min.css" rel="stylesheet" /> -->
<link href="/home/vendor/aos/aos.css" rel="stylesheet">
<!-- Template Stylesheet -->
<link href="/home/css/style.css" rel="stylesheet" />
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
				<ul	class="flex justify-center md:items-center  flex-col md:flex-row ">
					<li
						class="relative me-4 max-w-fit pr-3 md:pr-0 py-1 after:bg-gradient-to-r from-[#2b68e0] to-[#e710ea]  after:absolute after:h-1 after:w-0 after:bottom-0 after:left-0 hover:after:w-full after:transition-all after:duration-300">
						<a href="/home" class="text-md hover:text-cyan-500 duration-500"><i
							class="fa-solid fa-house me-2"></i> <fmt:message key="menu.home" /></a>
					</li>

					<li id="menu-job"	class="group inline-block relative me-4 max-w-fit pr-3 md:pr-0 py-1 after:bg-gradient-to-r from-[#2b68e0] to-[#e710ea]  after:absolute after:h-1 after:w-0 after:bottom-0 after:left-0 hover:after:w-full after:transition-all after:duration-300">
						<button	class="text-md flex items-center hover:text-cyan-500">
							<span class="pr-1 font-semibold flex-1"><i class="fa-solid fa-user-doctor me-1"></i><fmt:message key="menu.job" /></span> <span>
								<svg	class="fill-current h-4 w-4 transform group-hover:-rotate-180
        					transition duration-150 ease-in-out"
									xmlns="http://www.w3.org/2000/svg" viewBox="0 0 20 20">
        						<path	d="M9.293 12.95l.707.707L15.657 8l-1.414-1.414L10 10.828 5.757 6.586 4.343 8z" />
      					</svg>
							</span>
						</button>
						<ul class="parent-menu text-gray-500 bg-slate-100 border rounded shadow transform scale-0 group-hover:scale-100 absolute transition duration-150 ease-in-out origin-top min-w-32">
							<li class="rounded-sm px-3 py-1 hover:bg-emerald-600 hover:text-white">
								<a href="/home/jobs/?sort=lasted">Việc làm mới nhất</a>
							</li>
							<li class="rounded-sm px-3 py-1 hover:bg-emerald-600 hover:text-white">
								<a href="/home/jobs">Việc làm phù hợp</a>
							</li>
							<li class="rounded-sm sub relative px-3 py-1 hover:bg-emerald-600 hover:text-white">
								<button	class="w-full text-left flex items-center outline-none focus:outline-none">
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
								<ul class="sub-menu bg-slate-100 rounded border shadow absolute hidden right-0 top-0 transition duration-150 ease-in-out origin-top-left min-w-32">
								<li class="rounded-sm px-3 py-1 hover:bg-emerald-600 text-gray-500 hover:text-white">
									<a href="/home/jobs/?lc=Hà Nội">Hà Nội</a>
								</li>
								<li class="rounded-sm px-3 py-1 hover:bg-emerald-600 text-gray-500 hover:text-white">
									<a href="/home/jobs/?lc=Hồ Chí Minh">Hồ Chí Minh</a>
								</li>
									<li class="rounded-sm px-3 py-1 hover:bg-emerald-600 text-gray-500 hover:text-white">
									<a href="/home/jobs/?lc=Đà Nẵng">Đà Nẵng</a>
								</li>
								</ul>
							</li>
							<li class="rounded-sm sub relative px-3 py-1 hover:bg-emerald-600 hover:text-white">
								<button	class="w-full text-left flex items-center outline-none focus:outline-none">
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
								<ul class="sub-menu bg-slate-100 rounded border shadow absolute hidden right-0 top-0 transition duration-150 ease-in-out origin-top-left min-w-32">
								<li class="rounded-sm px-3 py-1 hover:bg-emerald-600 text-gray-500 hover:text-white">
									<a href="/home/jobs/?cr=90">Viễn Thông</a>
								</li>
									<li class="rounded-sm px-3 py-1 hover:bg-emerald-600 text-gray-500 hover:text-white">
									<a href="/home/jobs/?cr=78">Chuyển Đổi Số</a>
								</li>
									<li class="rounded-sm px-3 py-1 hover:bg-emerald-600 text-gray-500 hover:text-white">
									<a href="/home/jobs/?cr=79">Data Engineer/Data Analyst/AI</a>
								</li>
									<li class="rounded-sm px-3 py-1 hover:bg-emerald-600 text-gray-500 hover:text-white">
									<a href="/home/jobs/?cr=80">IT Support/Help Desk</a>
								</li>
								</ul>
							</li>
						</ul>
					</li>

					<li
						class="relative me-4 max-w-fit pr-3 md:pr-0 py-1 after:bg-gradient-to-r from-[#2b68e0] to-[#e710ea]  after:absolute after:h-1 after:w-0 after:bottom-0 after:left-0 hover:after:w-full after:transition-all after:duration-300">
						<a href="#" class="text-md hover:text-cyan-500 duration-500"><i class="fa-solid fa-building me-1"></i>
						<fmt:message key="menu.companies" />
								</a>
					</li>
					<li
						class="relative me-4 max-w-fit pr-3 md:pr-0 py-1 after:bg-gradient-to-r from-[#2b68e0] to-[#e710ea]  after:absolute after:h-1 after:w-0 after:bottom-0 after:left-0 hover:after:w-full after:transition-all after:duration-300 ">
						<a href="#" class="text-md hover:text-cyan-500 duration-500"><i class="fa-regular fa-heart e-1"></i>
						<fmt:message key="menu.jobofme" /></a>
					</li>
					<li
						class="relative me-4 max-w-fit pr-3 md:pr-0 py-1 after:bg-gradient-to-r from-[#2b68e0] to-[#e710ea]  after:absolute after:h-1 after:w-0 after:bottom-0 after:left-0 hover:after:w-full after:transition-all after:duration-300 ">
						<a href="#" class="text-md hover:text-cyan-500 duration-500"><i class="fa-solid fa-newspaper me-1">
						</i><fmt:message key="menu.blog" /></a>
					</li>
				</ul>
				<div class="flex md:items-center justify-around  flex-col md:flex-row ">
					<a href="#"
						class="text-md md:my-0 text-center md:text-sm rounded-md bg-emerald-600 md:py-2 md:px-1 px-2 py-1 text-white shadow-sm"><i class="fa-solid fa-users me-1"></i><fmt:message
							key="menu.employer" /></a>

					<%
					String lang = (String) session.getAttribute("lang");
					String imageSrc = "/home/img/vn.png";
					String linkHref = "?lang=vi_VN";

					if (lang != null && lang.equals("vi_VN")) {
						imageSrc = "/home/img/en.png";
						linkHref = "?lang=en_US";
					}
					%>

					<a href="<%=linkHref%>" id="nav_lang" class="my-2 md:my-0 ml-4">
						<img class="rounded h-8 w-14" id="svg1" src="<%=imageSrc%>"
						alt="lang">
					</a>

					<a id="nav_login" href="/home/login"
						class="inline-flex w-48 my-2 md:my-0 justify-center rounded-md bg-rose-600 px-3 py-2 text-sm font-semibold text-white shadow-sm hover:bg-red-400 sm:ml-3 sm:w-auto">
						<i class="fa-solid fa-user me-1 text-md inline-flex items-center"></i><fmt:message key="menu.login" />
					</a>
				</div>
			</nav>
			<!-- Navbar End -->
			<span class="text-2xl cursor-pointer mx-2 md:hidden block">
				<div class="flex items-center">
					<a href="<%=linkHref%>" class="md:my-0 me-2"> <img
						class="rounded h-7 w-10" id="svg1" src="<%=imageSrc%>" alt="lang">
					</a>
					<button
						class="inline-flex  me-2 md:my-0 justify-center rounded-md bg-rose-600 px-2 py-1 text-sm font-semibold text-white shadow-sm hover:bg-red-400 sm:ml-3 sm:w-auto">
						<fmt:message key="menu.login" />
					</button>
					<ion-icon name="menu" onclick="Menu(this)"></ion-icon>
				</div>

			</span>
		</header>