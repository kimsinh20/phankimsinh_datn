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
    <link href="https://fonts.googleapis.com/css2?family=Heebo:wght@400;500;600&family=Inter:wght@700;800&display=swap"
        rel="stylesheet" />

    <!-- Icon Font Stylesheet -->
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.1/css/all.min.css" rel="stylesheet" />
    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.4.1/font/bootstrap-icons.css" rel="stylesheet" />

    <!-- Libraries Stylesheet -->
    <link href="/home/dist/output.css" rel="stylesheet">
    <!-- Customized Bootstrap Stylesheet -->
    <!-- <link href="css/bootstrap.min.css" rel="stylesheet" /> -->
    <link href="/home/vendor/aos/aos.css" rel="stylesheet">
    <!-- Template Stylesheet -->
    <link href="css/style.css" rel="stylesheet" />
</head>

<body>
     <div class="bg-white px-0">
        <header class="header md:container flex justify-between items-center fixed w-full" data-aos="fade-in">
            <div class=" ">
                <a href="index.html" class="text-2xl ms-2 font-[Poppins] cursor-pointer flex items-center">
                    <img class="h-10 inline rounded"
                        src="/home/img/logo.jpg">
                    <h1 class="w-20 mr-6 ml-2">JobNow</h1>
                </a>
            </div>
            <!-- Navbar Start -->
            <nav class="w-full md:flex md:items-center bg-gray-100  justify-between z-[5] md:z-auto md:static absolute w-full left-0 md:w-auto md:py-0 py-2 md:pl-0 pl-7 md:opacity-100 top-[-400px] transition-all ease-in duration-500">
                <ul
                    class="flex justify-center items-center flex-col md:flex-row">
                    <li class="mx-4 my-2 md:my-0 hover:bg-emerald-600">
                        <a href="#" class="text-md hover:text-cyan-500 duration-500"><i class="fa-solid fa-house me-2"></i><fmt:message key="menu.home"/></a>
                    </li>
                    <li class="mx-4 my-2 md:my-0 hover:bg-emerald-600">
                        <a href="#" class="text-md hover:text-cyan-500 duration-500"><fmt:message key="menu.job"/></a>
                    </li>
                    <li class="mx-4 my-2 md:my-0 hover:bg-emerald-600">
                        <a href="#" class="text-md hover:text-cyan-500 duration-500"><fmt:message key="menu.companies"/></a>
                    </li>
                    <li class="mx-4 my-2 md:my-0 hover:bg-emerald-600">
                        <a href="#" class="text-md hover:text-cyan-500 duration-500"><fmt:message key="menu.jobofme"/></a>
                    </li>
                    <li class="mx-4 my-2 md:my-0 hover:bg-emerald-600">
                        <a href="#" class="text-md hover:text-cyan-500 duration-500"><fmt:message key="menu.blog"/></a>
                    </li>
                </ul>
               <div class="flex items-center justify-around  flex-col md:flex-row">
               <a href="#" class="text-md my-2 md:my-0 w-48 text-center md:text-sm rounded-md bg-emerald-600 px-3 py-2 text-white shadow-sm"><fmt:message key="menu.employer"/></a>
                  
             			<%
						  String lang = (String) session.getAttribute("lang");
						  String imageSrc = "/home/img/vn.png";
						  String linkHref = "?lang=vi_VN";
						
						  if (lang != null && lang.equals("vi_VN")) {
						    imageSrc = "/home/img/en.png";
						    linkHref = "?lang=en_US";
						  }
						%>

							<a href="<%= linkHref %>" class="my-2 md:my-0 ml-4">
			 					 <img class="rounded h-10 w-14" id="svg1" src="<%= imageSrc %>" alt="lang">
							</a>
         
            			<button class="inline-flex w-48 my-2 md:my-0 justify-center rounded-md bg-rose-600 px-3 py-2 text-sm font-semibold text-white shadow-sm hover:bg-red-100 sm:ml-3 sm:w-auto"><fmt:message key="menu.login"/></button>
               </div>
            	</nav>
            <!-- Navbar End -->
            <span class="text-2xl cursor-pointer mx-2 md:hidden block">
                <ion-icon name="menu" onclick="Menu(this)"></ion-icon>
            </span>
        </header>