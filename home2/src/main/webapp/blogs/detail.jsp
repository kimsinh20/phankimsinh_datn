
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
		<div class="mt-2">
			<div class="grid md:grid-cols-12 grid-cols-1 gap-[30px]">
				<div class="md:col-span-9 col-span-1 px-6">
					<nav class="flex justify-start md:justify-start"
				aria-label="Breadcrumb">
				<ol
					class="inline-flex items-center space-x-1 md:space-x-2 rtl:space-x-reverse">
					<li class="inline-flex items-center"><a href="/home"
						class="inline-flex items-center text-sm font-medium text-gray-700 hover:text-blue-600 dark:text-gray-400 dark:hover:text-white">
							${article.section_name }
					</a></li>
					<li aria-current="page">
						<div class="flex items-center">
							<svg class="rtl:rotate-180 w-3 h-3 text-gray-400 mx-1"
								aria-hidden="true" xmlns="http://www.w3.org/2000/svg"
								fill="none" viewBox="0 0 6 10">
                                    <path stroke="currentColor"
									stroke-linecap="round" stroke-linejoin="round" stroke-width="2"
									d="m1 9 4-4-4-4" />
                                </svg>
							<a href="#"
								class="ms-1 text-sm font-medium text-gray-500 md:ms-2 dark:text-gray-400">${article.category_name }</a>
						</div>
					</li>
				</ol>
			</nav>
			<h2 class="text-2xl py-2 font-bold">${article.article_title }</h2>
			<img src="${article.article_image}" class="w-full rounded shadow" alt="">
				<p class="text-sm font-medium py-2 tracking-wide">${article.article_summary }</p>
				<div class="text-md" id="article_content">${article.article_content}</div>
				<span class="py-2 text-md font-semibold text-blue-500">nguồn :<a href="${article.article_source }">${article.article_source }</a> </span>
				<div class="flex py-2 mb-4 justify-between">
					<span class="text-slate-400 text-sm me-2">
						<i class="fa-solid fa-calendar text-slate-900 dark:text-white me-2"></i>ngày đăng ${article.article_created_date }</span>
					<span	class="text-slate-400 text-sm ms-3">
						<i	class="fa-solid ms-2 fa-eye text-slate-900 dark:text-white me-2"></i>lượt xem ${article.article_visited }
					</span>
				</div>
				
				<span class="inline">Tag : 
			    <c:forEach items="${tags}" var="o" varStatus="index" >
			    <c:if test="${not empty o}">
			        <a href="/home/blogs/list?q=${o}" class="rounded px-2 py-1 border-2 me-2 border-slate-400 hover:border-blue-400">${o}</a>
			    </c:if>
				</c:forEach>
				</span>
				</div>
				
				<div class="md:col-span-3 col-span-1">
					<div>
						<h2 class="font-semibold texl-md lg:text-xl text-slate-600">Bài viết mới nhất</h2>
						<c:forEach items="${articleNew}" var="a" varStatus="loop" >
					<div class="group mt-4 relative article overflow-hidden bg-white dark:bg-slate-900 rounded-md shadow dark:shadow-gray-700">
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
					<div class="mt-6">
						<h2 class="font-semibold texl-md lg:text-xl text-slate-600">Liên kết</h2>
						<ul class="">
						<c:forEach items="${tagsSidebar}" var="tags">
							<li class="inline-block rounded mt-1 border-2 me-1 border-slate-400 hover:border-blue-400"><a href="/home/blogs/list?q=${tags.key}" class="p-1">${tags.key } (${tags.value })</a></li>
						</c:forEach>
						</ul>
					</div>
				</div>
				
			</div>
		</div>
	</div>
</main>
<!-- End #main -->

<jsp:include page="../footer.jsp" flush="true"></jsp:include>