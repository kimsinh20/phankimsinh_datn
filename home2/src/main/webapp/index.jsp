<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

  <fmt:setLocale value="${sessionScope.lang}" />
  <fmt:setBundle basename="lang.lang" />
<!-- ======= Header ======= -->
<jsp:include page="header.jsp" flush="true"></jsp:include>

<main id="main">
      
	<!-- ======= Hero Slider Section ======= -->
	<jsp:include page="hero.jsp" flush="true"></jsp:include>
	<!-- End Hero Slider Section -->
		
	<!-- ======= Hero Slider Section ======= -->
	<jsp:include page="carrertrending.jsp" flush="true"></jsp:include>
	<!-- End Hero Slider Section -->

	<!-- ======= Hero Slider Section ======= -->
	<jsp:include page="companies.jsp" flush="true"></jsp:include>
	<!-- End Hero Slider Section -->

        <div class="container md:mt-24 md:pb-16 mt-16" data-aos="zoom-in">
            <div class="grid md:grid-cols-12 grid-cols-1 items-center gap-[30px]">
                <div class="lg:col-span-5 md:col-span-6">
                    <div class="relative">
                        <div class="relative">
                            <img src="https://shreethemes.in/jobstack/layouts/assets/images/about/ab01.jpg"
                                class="lg:w-[400px] w-[280px] rounded-md shadow dark:shadow-gray-700" alt="">
                            <div class="absolute top-0 translate-y-2/4 end-0 text-center">
                                <a href="#!" data-type="youtube" data-id="S_CGed6E610"
                                    class="lightbox h-20 w-20 rounded-full shadow-lg dark:shadow-gray-700 inline-flex items-center justify-center bg-white dark:bg-slate-900 text-emerald-600 dark:text-white">
                                    <i class="mdi mdi-play inline-flex items-center justify-center text-2xl"></i>
                                </a>
                            </div>
                        </div>
                        <div class="absolute md:-end-5 end-0 -bottom-16">
                            <img src="https://shreethemes.in/jobstack/layouts/assets/images/about/ab01.jpg"
                                class="lg:w-[280px] w-[200px] border-8 border-white dark:border-slate-900 rounded-md shadow dark:shadow-gray-700"
                                alt="">
                        </div>
                    </div>
                </div>

                <div class="lg:col-span-7 md:col-span-6 mt-14 md:mt-0">
                    <div class="lg:ms-5">
                        <h3 class="mb-6 md:text-[26px] text-2xl md:leading-normal leading-normal font-semibold">
                            Millions
                            of jobs. <br> Find the one that's right for you.</h3>

                        <p class="text-slate-400 max-w-xl">Search all the open positions on the web. Get your own
                            personalized salary estimate. Read reviews on over 30000+ companies worldwide.</p>

                        <ul class="list-none text-slate-400 mt-4">
                            <li class="mb-1 flex"><i class="fa-solid fa-circle-info text-emerald-600 text-xl me-2"></i>
                                Digital Marketing Solutions for Tomorrow</li>
                            <li class="mb-1 flex"><i class="fa-solid fa-circle-info text-emerald-600 text-xl me-2"></i>
                                Our
                                Talented & Experienced Marketing Agency</li>
                            <li class="mb-1 flex"><i class="fa-solid fa-circle-info text-emerald-600 text-xl me-2"></i>
                                Create your own skin to match your brand</li>
                        </ul>

                        <div class="mt-6">
                            <a href="contact.html"
                                class="btn bg-emerald-600 hover:bg-emerald-700 border-emerald-600 hover:border-emerald-700 text-white py-2 px-4 mt-2 rounded-md"><i
                                    class="uil uil-envelope"></i> Contact us</a>
                        </div>
                    </div>
                </div>
            </div><!--end grid-->
        </div><!--end container-->
        </section><!--end section-->
        <!-- End -->

      <!-- ======= Hero Slider Section ======= -->
	<jsp:include page="popularjob.jsp" flush="true"></jsp:include>
	<!-- End Hero Slider Section -->

        <div class="container md:mt-24 mt-16">
        <div class="grid grid-cols-1 pb-8 text-center">
            <h3 class="mb-4 md:text-[26px] md:leading-normal text-2xl leading-normal font-semibold">
                Here's why you'll love it Jobstack
            </h3>

            <p class="text-slate-400 max-w-xl mx-auto">
                Search all the open positions on the web. Get your own personalized
                salary estimate. Read reviews on over 30000+ companies worldwide.
            </p>
        </div>
        <!--end grid-->
		</div> <!--end container-->
		<div class="container md:mt-24 mt-16">
        <div class="grid lg:grid-cols-4 md:grid-cols-3 sm:grid-cols-2 grid-cols-1 mt-8 gap-[30px]">
            <div class="group p-6 shadow dark:shadow-gray-700 rounded-md bg-white hover:bg-emerald-600/5 dark:bg-slate-900 dark:hover:bg-emerald-600/10 text-center transition-all duration-500"
                data-aos="zoom-out-up">
                <div
                    class="w-16 h-16 flex items-center justify-center mx-auto bg-emerald-600/5 group-hover:bg-emerald-600 dark:bg-emerald-600/10 dark:group-hover:bg-emerald-600 shadow dark:shadow-gray-700 rounded-lg transition-all duration-500">
                    <i class="fa-solid fa-phone text-[30px] text-emerald-600 group-hover:text-white"></i>
                </div>

                <div class="mt-4">
                    <a href="" class="text-lg font-semibold hover:text-emerald-600 transition-all duration-500">24/7
                        Support</a>

                    <p class="text-slate-400 mt-3 mb-2">
                        Many desktop publishing now use and a search for job.
                    </p>

                    <a href="" class="hover:text-emerald-600 font-medium transition-all duration-500">Read More <i
                            class="uil uil-arrow-right"></i></a>
                </div>
            </div>
            <!--end content-->

            <div class="group p-6 shadow dark:shadow-gray-700 rounded-md bg-white hover:bg-emerald-600/5 dark:bg-slate-900 dark:hover:bg-emerald-600/10 text-center transition-all duration-500"
                data-aos="zoom-out-up">
                <div
                    class="w-16 h-16 flex items-center justify-center mx-auto bg-emerald-600/5 group-hover:bg-emerald-600 dark:bg-emerald-600/10 dark:group-hover:bg-emerald-600 shadow dark:shadow-gray-700 rounded-lg transition-all duration-500">
                    <i class="fa-solid fa-envelope text-[30px] text-emerald-600 group-hover:text-white"></i>
                </div>

                <div class="mt-4">
                    <a href="" class="text-lg font-semibold hover:text-emerald-600 transition-all duration-500">Tech
                        & Startup Jobs</a>

                    <p class="text-slate-400 mt-3 mb-2">
                        Many desktop publishing now use and a search for job.
                    </p>

                    <a href="" class="hover:text-emerald-600 font-medium transition-all duration-500">Read More <i
                            class="uil uil-arrow-right"></i></a>
                </div>
            </div>
            <!--end content-->

            <div class="group p-6 shadow dark:shadow-gray-700 rounded-md bg-white hover:bg-emerald-600/5 dark:bg-slate-900 dark:hover:bg-emerald-600/10 text-center transition-all duration-500"
                data-aos="zoom-out-up">
                <div
                    class="w-16 h-16 flex items-center justify-center mx-auto bg-emerald-600/5 group-hover:bg-emerald-600 dark:bg-emerald-600/10 dark:group-hover:bg-emerald-600 shadow dark:shadow-gray-700 rounded-lg transition-all duration-500">
                    <i class="fa-solid fa-truck-fast text-[30px] text-emerald-600 group-hover:text-white"></i>
                </div>

                <div class="mt-4">
                    <a href="" class="text-lg font-semibold hover:text-emerald-600 transition-all duration-500">Quick &
                        Easy</a>

                    <p class="text-slate-400 mt-3 mb-2">
                        Many desktop publishing now use and a search for job.
                    </p>

                    <a href="" class="hover:text-emerald-600 font-medium transition-all duration-500">Read More <i
                            class="uil uil-arrow-right"></i></a>
                </div>
            </div>
            <!--end content-->

            <div class="group p-6 shadow dark:shadow-gray-700 rounded-md bg-white hover:bg-emerald-600/5 dark:bg-slate-900 dark:hover:bg-emerald-600/10 text-center transition-all duration-500"
                data-aos="zoom-out-up">
                <div
                    class="w-16 h-16 flex items-center justify-center mx-auto bg-emerald-600/5 group-hover:bg-emerald-600 dark:bg-emerald-600/10 dark:group-hover:bg-emerald-600 shadow dark:shadow-gray-700 rounded-lg transition-all duration-500">
                    <i class="fa-solid fa-clock text-[30px] text-emerald-600 group-hover:text-white"></i>
                </div>

                <div class="mt-4">
                    <a href="" class="text-lg font-semibold hover:text-emerald-600 transition-all duration-500">Save
                        Time</a>

                    <p class="text-slate-400 mt-3 mb-2">
                        Many desktop publishing now use and a search for job.
                    </p>

                    <a href="" class="hover:text-emerald-600 font-medium transition-all duration-500">Read More <i
                            class="uil uil-arrow-right"></i></a>
                </div>
            </div>
            <!--end content-->
        </div>
        <!--end grid-->
    </div>
    <!--end container-->
    
   <!-- ======= Hero Slider Section ======= -->
	<jsp:include page="news.jsp" flush="true"></jsp:include>
	<!-- End Hero Slider Section -->
</main>
<!-- End #main -->

<jsp:include page="footer.jsp" flush="true"></jsp:include>