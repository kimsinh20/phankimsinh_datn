<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="data.jsp" flush="true"></jsp:include>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8" />
    <title>JobEntry - Job Portal Website Template</title>
    <meta content="width=device-width, initial-scale=1.0" name="viewport" />
    <meta content="" name="keywords" />
    <meta content="" name="description" />

    <!-- Favicon -->
    <link href="img/favicon.ico" rel="icon" />

    <!-- Google Web Fonts -->
    <link rel="preconnect" href="https://fonts.googleapis.com" />
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin />
    <link href="https://fonts.googleapis.com/css2?family=Heebo:wght@400;500;600&family=Inter:wght@700;800&display=swap"
        rel="stylesheet" />

    <!-- Icon Font Stylesheet -->
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.10.0/css/all.min.css" rel="stylesheet" />
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
        <header class="header container flex justify-between items-center fixed w-full" data-aos="fade-in">
            <div class=" ">
                <a href="index.html" class="text-2xl ms-2 font-[Poppins] cursor-pointer flex items-center">
                    <img class="h-10 inline rounded"
                        src="/home/img/logo.jpg">
                    <h1 class="w-20 mr-6 ml-2">JobNow</h1>
                </a>
            </div>
            <!-- Navbar Start -->
            <nav class="w-full">
                <ul
                    class="md:flex md:items-center bg-gray-100 justify-center z-[5] md:z-auto md:static absolute w-full left-0 md:w-auto md:py-0 py-2 md:pl-0 pl-7 md:opacity-100 opacity-0 top-[-400px] transition-all ease-in duration-500">
                    <li class="mx-4 my-2 md:my-0">
                        <a href="#" class="text-md hover:text-cyan-500 duration-500">Trang chủ</a>
                    </li>
                    <li class="mx-4 my-2 md:my-0">
                        <a href="#" class="text-md hover:text-cyan-500 duration-500">Dịch vụ</a>
                    </li>
                    <li class="mx-4 my-2 md:my-0">
                        <a href="#" class="text-md hover:text-cyan-500 duration-500">Về chúng tôi</a>
                    </li>
                    <li class="mx-4 my-2 md:my-0">
                        <a href="#" class="text-md hover:text-cyan-500 duration-500">Liên hệ</a>
                    </li>
                    <li class="mx-4 my-2 md:my-0">
                        <a href="#" class="text-md hover:text-cyan-500 duration-500">Tin tức & Bài viết</a>
                    </li>
                </ul>
            </nav>
            <span class="text-2xl cursor-pointer mx-2 md:hidden block">
                <ion-icon name="menu" onclick="Menu(this)"></ion-icon>
            </span>
            <!-- Navbar End -->
        </header>