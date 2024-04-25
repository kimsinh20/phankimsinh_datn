
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- ======= Header ======= -->
<jsp:include page="../header.jsp" flush="true"></jsp:include>

<main id="main pt-24" class="bg-slate-50">
	<div class="p-6">
		<nav class="pb-4">
			<ul class="flex justify-center items-center text-slate-900">
			<c:forEach items="${sections}" var="i" varStatus="loop" >
				<li class="me-3">
					<a href="/home/blogs/list?id=${i.section_id}" class="font-semibold text-sm ">${i.section_name}</a>
				</li>
			</c:forEach>
				
			</ul>
		</nav>
		
		<div>
		<h1 class="text-xl pb-2 text-orange-700 font-bold">Nổi bật</h1>
		<div class="grid md:grid-cols-12 grid-cols-1 gap-[30px]">
		<c:forEach items="${articleTrend}" begin="0" end="0" var="a" varStatus="loop" >
			<div class="md:col-span-9 col-span-1">
				<div class="group relative article overflow-hidden bg-white dark:bg-slate-900 rounded-md shadow dark:shadow-gray-700">
					<div class="relative overflow-hidden article">
						<img src="${a.article_image }"
							class="scale-110 article_img group-hover:scale-100 transition-all duration-500"
							alt="">
					</div>
					<div class="relative p-6">
						<div class="absolute start-6 -top-4">
							<span
								class="bg-emerald-600 px-3 text-white text-[12px] px-2.5 py-1 font-semibold rounded-full h-5">${a.category_name }</span>
						</div>
						<div class="">
							<div class="flex mb-4 justify-between">
								<span class="text-slate-400 text-sm me-2">
								<i class="fa-solid fa-calendar text-slate-900 dark:text-white me-2"></i>${a.article_created_date }</span>
								<span	class="text-slate-400 text-sm ms-3">
									<i	class="fa-solid ms-2 fa-eye text-slate-900 dark:text-white me-2"></i>${a.article_visited}
									lượt xem</span>
							</div>
							<a href="/home/blogs/detail?id=${a.article_id }" class="title text-xl font-semibold hover:text-emerald-600 duration-500 ease-in-out">${a.article_title}</a>
							<p class="text-small">${a.article_summary}</p>
							<div class="flex justify-between items-center mt-3">
								<a href="/home/blogs/detail?id=${a.article_id }"	class="btn btn-link hover:text-emerald-600 after:bg-emerald-600 duration-500 ease-in-out">ReadMore
									<i class="uil uil-arrow-right"></i>
								</a><span class="text-slate-400 text-sm">by <a href="" class="text-slate-900 dark:text-white hover:text-emerald-600 dark:hover:text-emerald-600 font-medium">admin</a></span>
							</div>
						</div>
					</div>
				</div>
			</div>
			</c:forEach>
			
			<div class="md:col-span-3 col-span-1 flex flex-col justify-between">
					<c:forEach items="${articleTrend}" begin="1" end="2" var="a" varStatus="loop" >
					<div class="group relative article overflow-hidden bg-white dark:bg-slate-900 rounded-md shadow dark:shadow-gray-700">
					<div class="relative overflow-hidden article">
						<img src="${a.article_image }"
							class="scale-110 article_img group-hover:scale-100 transition-all duration-500"
							alt="">
					</div>
					<div class="relative p-6">
						<div class="absolute start-6 -top-4">
							<span
								class="bg-emerald-600 px-3 text-white text-[12px] px-2.5 py-1 font-semibold rounded-full h-5">${a.category_name }</span>
						</div>
						<div class="">
							<div class="flex mb-4 justify-between">
								<span class="text-slate-400 text-sm me-2">
								<i class="fa-solid fa-calendar text-slate-900 dark:text-white me-2"></i>${a.article_created_date }</span>
								<span	class="text-slate-400 text-sm ms-3">
									<i	class="fa-solid ms-2 fa-eye text-slate-900 dark:text-white me-2"></i>${a.article_visited}
									</span>
							</div>
							<a href="/home/blogs/detail?id=${a.article_id }" class="title text-xl font-semibold hover:text-emerald-600 duration-500 ease-in-out">${a.article_title}</a>
						</div>
					</div>
				</div>
				</c:forEach>
				</div> 

			</div>
		</div>
		
		
		
		<c:forEach items="${sections}" var="i" varStatus="loop" >
		<div class="mt-3" id="section-${i.section_id}">
			<div class="py-3 flex justify-between items-center">
				<h1 class="font-medium text-xl text-white bg-emerald-200 inline px-3 py-2 rounded shadow">${i.section_name }</h1>
				<a href="/home/blogs/list?id=${i.section_id}" class="border-2 rounded px-2 py-2 border-slate-400">Xem tất cả</a>
			</div>
			<div class="grid md:grid-cols-12 grid-cols-1 gap-[30px]">
			
			<c:set var="counter" value="0" />
			<c:forEach items="${articles}" var="o" varStatus="index" >
		<c:if test="${i.section_id eq o.article_section_id }">
				<c:if test="${counter <= 2}">
				<div class="md:col-span-4 col-span-1">
					<div class="group relative article overflow-hidden bg-white dark:bg-slate-900 rounded-md shadow dark:shadow-gray-700">
					<div class="relative overflow-hidden article">
						<img src="${o.article_image }"
							class="scale-110 article_img group-hover:scale-100 transition-all duration-500"
							alt="">
					</div>
					<div class="relative p-6">
						<div class="absolute start-6 -top-4">
							<span
								class="bg-emerald-600 px-3 text-white text-[12px] px-2.5 py-1 font-semibold rounded-full h-5">${o.category_name }</span>
						</div>
						<div class="">
							<div class="flex mb-4 justify-between">
								<span class="text-slate-400 text-sm me-2">
								<i class="fa-solid fa-calendar text-slate-900 dark:text-white me-2"></i>${o.article_created_date }</span>
								<span	class="text-slate-400 text-sm ms-3">
									<i	class="fa-solid ms-2 fa-eye text-slate-900 dark:text-white me-2"></i>${o.article_visited }
									</span>
							</div>
							<a href="/home/blogs/detail?id=${o.article_id }" class="title text-xl font-semibold hover:text-emerald-600 duration-500 ease-in-out">${o.article_title }</a>
						</div>
					</div>
				</div>
				</div>
				 <c:set var="counter" value="${counter + 1}" />
				</c:if>
				 
					</c:if>
			</c:forEach>
			</div>
		</div>
		</c:forEach>
		</div>
</main>
<!-- End #main -->

<jsp:include page="../footer.jsp" flush="true"></jsp:include>