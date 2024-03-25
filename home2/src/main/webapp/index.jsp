<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!-- ======= Header ======= -->
<jsp:include page="header.jsp" flush="true"></jsp:include>

<main id="main">
       <!-- Start Hero -->
        <section class="relative  md:py-56 py-36 container" data-aos="fade-up">
            <div class="absolute inset-0 bg-emerald-600/5 dark:bg-emerald-600/10"></div>
            <div class="container z-1">
                <div class="grid grid-cols-1 text-center mt-10 relative">
                    <h4 class="lg:leading-normal leading-normal text-4xl lg:text-5xl mb-5 font-bold">Hãy tham gia cùng chúng tôi & <span
                            class="text-emerald-600 font-bold">Khám phá</span> <br> <span
                            class="text-emerald-600 font-bold">hàng nghìn</span> việc làm</h4>
                    <p class="text-slate-400 text-lg max-w-xl mx-auto">Tìm việc làm, việc làm và cơ hội nghề nghiệp. Một số công ty chúng tôi đã giúp tuyển dụng những ứng viên xuất sắc trong những năm qua.</p>

                    <div class="d-flex" id="reserve-form">
                        <div class="md:w-5/6 mx-auto">
                            <div class="lg:col-span-10 mt-8">
                                <div class="bg-white dark:bg-slate-900 border-0 shadow rounded-md p-3">
                                    <form action="#">
                                        <div class="registration-form text-dark text-start">
                                            <div class="grid lg:grid-cols-4 md:grid-cols-2 grid-cols-1 lg:gap-0 gap-6">
                                                <div class="filter-search-form relative filter-border">
                                                    <i class="uil uil-briefcase-alt icons"></i>
                                                    <input name="name" type="text" id="job-keyword" class="form-control"
                                                        placeholder="Search your Keywords">
                                                </div>

                                                <div class="filter-search-form relative filter-border">
                                                    <i class="uil uil-map-marker icons"></i>
                                                    <select class="form-select" data-trigger name="choices-location"
                                                        id="choices-location" aria-label="Default select example">
                                                        <option value="AF">Afghanistan</option>
                                                        <option value="AZ">Azerbaijan</option>
                                                        <option value="BS">Bahamas</option>
                                                        <option value="BH">Bahrain</option>
                                                        <option value="CA">Canada</option>
                                                        <option value="CV">Cape Verde</option>
                                                        <option value="DK">Denmark</option>
                                                        <option value="DJ">Djibouti</option>
                                                        <option value="ER">Eritrea</option>
                                                        <option value="EE">Estonia</option>
                                                        <option value="GM">Gambia</option>
                                                    </select>
                                                </div>

                                                <div class="filter-search-form relative filter-border">
                                                    <i class="uil uil-briefcase-alt icons"></i>
                                                    <select class="form-select" data-trigger name="choices-type"
                                                        id="choices-type" aria-label="Default select example">
                                                        <option selected="" value="1">Full Time</option>
                                                        <option value="2">Part Time</option>
                                                        <option value="3">Freelancer</option>
                                                        <option value="4">Remote Work</option>
                                                        <option value="5">Office Work</option>
                                                    </select>
                                                </div>

                                                <input type="submit" id="search" name="search" style=""
                                                    class="btn bg-emerald-600 hover:bg-emerald-700 border-emerald-600 hover:border-emerald-700 text-white searchbtn submit-btn w-100"
                                                    value="Search">
                                            </div><!--end grid-->
                                        </div><!--end container-->
                                    </form>
                                </div>
                            </div><!--ed col-->
                        </div>
                    </div><!--end grid-->

                    <div class="mt-4">
                        <span class="text-slate-400"><span class="text-dark">Popular Searches :</span> Designer,
                            Developer,
                            Web, IOS, PHP Senior Engineer</span>
                    </div>

                    <div class="absolute -top-20 start-1/2 -translate-x-1/2">
                        <div
                            class="w-10 h-10 animate-[bounce_2s_infinite] bg-white dark:bg-slate-900 flex items-center justify-center shadow dark:shadow-gray-700 rounded-md">
                            <img src="/home/img/facebook-logo.png" class="h-6 w-6" alt="">
                        </div>
                    </div>

                    <div class="absolute top-[20%] start-10">
                        <div
                            class="w-10 h-10 animate-[spin_5s_linear_infinite] bg-white dark:bg-slate-900 flex items-center justify-center shadow dark:shadow-gray-700 rounded-md">
                            <img src="/home/img/google-logo.png" class="h-6 w-6" alt="">
                        </div>
                    </div>

                    <div class="absolute top-[20%] end-1">
                        <div
                            class="w-10 h-10 bg-white dark:bg-slate-900 flex items-center justify-center shadow dark:shadow-gray-700 rounded-md">
                            <img src="/home/img/android.png" class="h-6 w-6" alt="">
                        </div>
                    </div>

                    <div class="absolute top-3/4 start-1">
                        <div
                            class="w-10 h-10 bg-white dark:bg-slate-900 flex items-center justify-center shadow dark:shadow-gray-700 rounded-md">
                            <img src="/home/img/lenovo-logo.png" class="h-6 w-6" alt="">
                        </div>
                    </div>

                    <div class="absolute top-3/4 end-10">
                        <div
                            class="w-10 h-10 animate-[spin_5s_linear_infinite] bg-white dark:bg-slate-900 flex items-center justify-center shadow dark:shadow-gray-700 rounded-md">
                            <img src="/home/img/skype.png" class="h-6 w-6" alt="">
                        </div>
                    </div>

                    <div class="absolute -bottom-32 start-1/2 -translate-x-1/2">
                        <div
                            class="w-10 h-10 animate-pulse bg-white dark:bg-slate-900 flex items-center justify-center shadow dark:shadow-gray-700 rounded-md">
                            <img src="/home/img/snapchat.png" class="h-6 w-6" alt="">
                        </div>
                    </div>
                </div><!--end grid-->
            </div><!--end container-->
        </section><!--end section-->
        <!-- End Hero -->

        <!-- Start -->
        <div class="container">
            <div class="grid grid-cols-1 pb-8 text-center">
                <h3 class="mb-4 md:text-[26px] md:leading-normal text-2xl leading-normal font-semibold">Popular
                    Categories</h3>

                <p class="text-slate-400 max-w-xl mx-auto">Search all the open positions on the web. Get your own
                    personalized salary estimate. Read reviews on over 30000+ companies worldwide.</p>
            </div><!--end grid-->

            <div class="grid lg:grid-cols-5 md:grid-cols-3 sm:grid-cols-2 grid-cols-1 mt-8 gap-[30px]">
                <div class="group px-3 py-10 rounded-md shadow dark:shadow-gray-700 hover:shadow-emerald-600/10 dark:hover:shadow-emerald-600/10 text-center bg-white dark:bg-slate-900 hover:bg-emerald-600/5 dark:hover:bg-emerald-600/5 transition duration-500"
                    data-aos="fade-up" data-aos-duration="1000">
                    <div
                        class="w-16 h-16 bg-emerald-600/5 group-hover:bg-emerald-600 text-emerald-600 group-hover:text-white rounded-md text-2xl flex align-middle justify-center items-center shadow-sm dark:shadow-gray-700 transition duration-500 mx-auto">
                        <i class="uil uil-gitlab"></i>
                    </div>

                    <div class="content mt-6">
                        <a href="" class="title text-lg font-semibold hover:text-emerald-600">Business <br>
                            Development</a>
                        <p class="text-slate-400 mt-3">74 Jobs</p>
                    </div>
                </div><!--end content-->

                <div class="group px-3 py-10 rounded-md shadow dark:shadow-gray-700 hover:shadow-emerald-600/10 dark:hover:shadow-emerald-600/10 text-center bg-white dark:bg-slate-900 hover:bg-emerald-600/5 dark:hover:bg-emerald-600/5 transition duration-500"
                    data-aos="fade-up" data-aos-duration="1000">
                    <div
                        class="w-16 h-16 bg-emerald-600/5 group-hover:bg-emerald-600 text-emerald-600 group-hover:text-white rounded-md text-2xl flex align-middle justify-center items-center shadow-sm dark:shadow-gray-700 transition duration-500 mx-auto">
                        <i class="uil uil-book-open"></i>
                    </div>

                    <div class="content mt-6">
                        <a href="" class="title text-lg font-semibold hover:text-emerald-600">Marketing & <br>
                            Communication</a>
                        <p class="text-slate-400 mt-3">20 Jobs</p>
                    </div>
                </div><!--end content-->

                <div class="group px-3 py-10 rounded-md shadow dark:shadow-gray-700 hover:shadow-emerald-600/10 dark:hover:shadow-emerald-600/10 text-center bg-white dark:bg-slate-900 hover:bg-emerald-600/5 dark:hover:bg-emerald-600/5 transition duration-500"
                    data-aos="fade-up" data-aos-duration="1000">
                    <div
                        class="w-16 h-16 bg-emerald-600/5 group-hover:bg-emerald-600 text-emerald-600 group-hover:text-white rounded-md text-2xl flex align-middle justify-center items-center shadow-sm dark:shadow-gray-700 transition duration-500 mx-auto">
                        <i class="uil uil-chart-pie-alt"></i>
                    </div>

                    <div class="content mt-6">
                        <a href="" class="title text-lg font-semibold hover:text-emerald-600">Project <br>
                            Management</a>
                        <p class="text-slate-400 mt-3">35 Jobs</p>
                    </div>
                </div><!--end content-->

                <div class="group px-3 py-10 rounded-md shadow dark:shadow-gray-700 hover:shadow-emerald-600/10 dark:hover:shadow-emerald-600/10 text-center bg-white dark:bg-slate-900 hover:bg-emerald-600/5 dark:hover:bg-emerald-600/5 transition duration-500"
                    data-aos="fade-up" data-aos-duration="1000">
                    <div
                        class="w-16 h-16 bg-emerald-600/5 group-hover:bg-emerald-600 text-emerald-600 group-hover:text-white rounded-md text-2xl flex align-middle justify-center items-center shadow-sm dark:shadow-gray-700 transition duration-500 mx-auto">
                        <i class="uil uil-feedback"></i>
                    </div>

                    <div class="content mt-6">
                        <a href="" class="title text-lg font-semibold hover:text-emerald-600">Customer <br>
                            Service</a>
                        <p class="text-slate-400 mt-3">46 Jobs</p>
                    </div>
                </div><!--end content-->

                <div class="group px-3 py-10 rounded-md shadow dark:shadow-gray-700 hover:shadow-emerald-600/10 dark:hover:shadow-emerald-600/10 text-center bg-white dark:bg-slate-900 hover:bg-emerald-600/5 dark:hover:bg-emerald-600/5 transition duration-500"
                    data-aos="fade-up" data-aos-duration="1000">
                    <div
                        class="w-16 h-16 bg-emerald-600/5 group-hover:bg-emerald-600 text-emerald-600 group-hover:text-white rounded-md text-2xl flex align-middle justify-center items-center shadow-sm dark:shadow-gray-700 transition duration-500 mx-auto">
                        <i class="uil uil-presentation-line"></i>
                    </div>

                    <div class="content mt-6">
                        <a href="" class="title text-lg font-semibold hover:text-emerald-600">Software <br>
                            Engineering</a>
                        <p class="text-slate-400 mt-3">60 Jobs</p>
                    </div>
                </div><!--end content-->
            </div><!--end grid-->
        </div><!--end container-->

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
                            <li class="mb-1 flex"><i class="uil uil-check-circle text-emerald-600 text-xl me-2"></i>
                                Digital Marketing Solutions for Tomorrow</li>
                            <li class="mb-1 flex"><i class="uil uil-check-circle text-emerald-600 text-xl me-2"></i>
                                Our
                                Talented & Experienced Marketing Agency</li>
                            <li class="mb-1 flex"><i class="uil uil-check-circle text-emerald-600 text-xl me-2"></i>
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

        <section class="container relative bg-slate-50 dark:bg-slate-800 md:py-24 py-16" data-aos="flip-up">
                <div class="grid grid-cols-1 pb-8 text-center">
                    <h3 class="mb-4 md:text-[26px] md:leading-normal text-2xl leading-normal font-semibold">
                        Popular Jobs
                    </h3>

                    <p class="text-slate-400 max-w-xl mx-auto">
                        Search all the open positions on the web. Get your own
                        personalized salary estimate. Read reviews on over 30000+
                        companies worldwide.
                    </p>
                </div>
                <!--end grid-->

                <div class="grid lg:grid-cols-3 md:grid-cols-2 mt-8 gap-[30px]">
                    <div class="group shadow dark:shadow-gray-700 p-6 rounded-md bg-white dark:bg-slate-900">
                        <div class="flex items-center justify-between">
                            <div class="flex items-center">
                                <div
                                    class="w-14 h-14 flex items-center justify-center bg-white dark:bg-slate-900 shadow dark:shadow-gray-700 rounded-md">
                                    <img src="assets/images/company/facebook-logo.png" class="h-8 w-8" alt="" />
                                </div>

                                <div class="ms-3">
                                    <a href="employer-detail.html"
                                        class="block text-[16px] font-semibold hover:text-emerald-600 transition-all duration-500">Facebook</a>
                                    <span class="block text-sm text-slate-400">2 days ago</span>
                                </div>
                            </div>

                            <span
                                class="bg-emerald-600/10 group-hover:bg-emerald-600 inline-block text-emerald-600 group-hover:text-white text-xs px-2.5 py-0.5 font-semibold rounded-full transition-all duration-500">Full
                                Time</span>
                        </div>

                        <div class="mt-6">
                            <a href="job-detail-two.html"
                                class="text-lg hover:text-emerald-600 font-semibold transition-all duration-500">Web
                                Designer / Developer</a>
                            <h6 class="text-base font-medium">
                                <i class="uil uil-map-marker"></i> Australia
                            </h6>
                        </div>

                        <div class="mt-6">
                            <div class="w-full bg-gray-100 dark:bg-gray-800 rounded-full h-[6px]">
                                <div class="bg-emerald-600 h-[6px] rounded-full" style="width: 55%"></div>
                            </div>
                            <div class="mt-2">
                                <span class="text-slate-400 text-sm"><span
                                        class="text-slate-900 dark:text-white font-semibold inline-block">21
                                        applied</span>
                                    of 40 vacancy</span>
                            </div>
                        </div>
                    </div>
                    <!--end content-->

                    <div class="group shadow dark:shadow-gray-700 p-6 rounded-md bg-white dark:bg-slate-900">
                        <div class="flex items-center justify-between">
                            <div class="flex items-center">
                                <div
                                    class="w-14 h-14 flex items-center justify-center bg-white dark:bg-slate-900 shadow dark:shadow-gray-700 rounded-md">
                                    <img src="assets/images/company/google-logo.png" class="h-8 w-8" alt="" />
                                </div>

                                <div class="ms-3">
                                    <a href="employer-detail.html"
                                        class="block text-[16px] font-semibold hover:text-emerald-600 transition-all duration-500">Google</a>
                                    <span class="block text-sm text-slate-400">2 days ago</span>
                                </div>
                            </div>

                            <span
                                class="bg-emerald-600/10 group-hover:bg-emerald-600 inline-block text-emerald-600 group-hover:text-white text-xs px-2.5 py-0.5 font-semibold rounded-full transition-all duration-500">Part
                                Time</span>
                        </div>

                        <div class="mt-6">
                            <a href="job-detail-two.html"
                                class="text-lg hover:text-emerald-600 font-semibold transition-all duration-500">Marketing
                                Director</a>
                            <h6 class="text-base font-medium">
                                <i class="uil uil-map-marker"></i> USA
                            </h6>
                        </div>

                        <div class="mt-6">
                            <div class="w-full bg-gray-100 dark:bg-gray-800 rounded-full h-[6px]">
                                <div class="bg-emerald-600 h-[6px] rounded-full" style="width: 55%"></div>
                            </div>
                            <div class="mt-2">
                                <span class="text-slate-400 text-sm"><span
                                        class="text-slate-900 dark:text-white font-semibold inline-block">21
                                        applied</span>
                                    of 40 vacancy</span>
                            </div>
                        </div>
                    </div>
                    <!--end content-->

                    <div class="group shadow dark:shadow-gray-700 p-6 rounded-md bg-white dark:bg-slate-900">
                        <div class="flex items-center justify-between">
                            <div class="flex items-center">
                                <div
                                    class="w-14 h-14 flex items-center justify-center bg-white dark:bg-slate-900 shadow dark:shadow-gray-700 rounded-md">
                                    <img src="assets/images/company/android.png" class="h-8 w-8" alt="" />
                                </div>

                                <div class="ms-3">
                                    <a href="employer-detail.html"
                                        class="block text-[16px] font-semibold hover:text-emerald-600 transition-all duration-500">Android</a>
                                    <span class="block text-sm text-slate-400">2 days ago</span>
                                </div>
                            </div>

                            <span
                                class="bg-emerald-600/10 group-hover:bg-emerald-600 inline-block text-emerald-600 group-hover:text-white text-xs px-2.5 py-0.5 font-semibold rounded-full transition-all duration-500">Remote</span>
                        </div>

                        <div class="mt-6">
                            <a href="job-detail-two.html"
                                class="text-lg hover:text-emerald-600 font-semibold transition-all duration-500">Application
                                Developer</a>
                            <h6 class="text-base font-medium">
                                <i class="uil uil-map-marker"></i> China
                            </h6>
                        </div>

                        <div class="mt-6">
                            <div class="w-full bg-gray-100 dark:bg-gray-800 rounded-full h-[6px]">
                                <div class="bg-emerald-600 h-[6px] rounded-full" style="width: 55%"></div>
                            </div>
                            <div class="mt-2">
                                <span class="text-slate-400 text-sm"><span
                                        class="text-slate-900 dark:text-white font-semibold inline-block">21
                                        applied</span>
                                    of 40 vacancy</span>
                            </div>
                        </div>
                    </div>
                    <!--end content-->

                    <div class="group shadow dark:shadow-gray-700 p-6 rounded-md bg-white dark:bg-slate-900">
                        <div class="flex items-center justify-between">
                            <div class="flex items-center">
                                <div
                                    class="w-14 h-14 flex items-center justify-center bg-white dark:bg-slate-900 shadow dark:shadow-gray-700 rounded-md">
                                    <img src="assets/images/company/lenovo-logo.png" class="h-8 w-8" alt="" />
                                </div>

                                <div class="ms-3">
                                    <a href="employer-detail.html"
                                        class="block text-[16px] font-semibold hover:text-emerald-600 transition-all duration-500">Lenovo</a>
                                    <span class="block text-sm text-slate-400">2 days ago</span>
                                </div>
                            </div>

                            <span
                                class="bg-emerald-600/10 group-hover:bg-emerald-600 inline-block text-emerald-600 group-hover:text-white text-xs px-2.5 py-0.5 font-semibold rounded-full transition-all duration-500">WFH</span>
                        </div>

                        <div class="mt-6">
                            <a href="job-detail-two.html"
                                class="text-lg hover:text-emerald-600 font-semibold transition-all duration-500">Senior
                                Product Designer</a>
                            <h6 class="text-base font-medium">
                                <i class="uil uil-map-marker"></i> Dubai
                            </h6>
                        </div>

                        <div class="mt-6">
                            <div class="w-full bg-gray-100 dark:bg-gray-800 rounded-full h-[6px]">
                                <div class="bg-emerald-600 h-[6px] rounded-full" style="width: 55%"></div>
                            </div>
                            <div class="mt-2">
                                <span class="text-slate-400 text-sm"><span
                                        class="text-slate-900 dark:text-white font-semibold inline-block">21
                                        applied</span>
                                    of 40 vacancy</span>
                            </div>
                        </div>
                    </div>
                    <!--end content-->

                    <div class="group shadow dark:shadow-gray-700 p-6 rounded-md bg-white dark:bg-slate-900">
                        <div class="flex items-center justify-between">
                            <div class="flex items-center">
                                <div
                                    class="w-14 h-14 flex items-center justify-center bg-white dark:bg-slate-900 shadow dark:shadow-gray-700 rounded-md">
                                    <img src="assets/images/company/spotify.png" class="h-8 w-8" alt="" />
                                </div>

                                <div class="ms-3">
                                    <a href="employer-detail.html"
                                        class="block text-[16px] font-semibold hover:text-emerald-600 transition-all duration-500">Spotify</a>
                                    <span class="block text-sm text-slate-400">2 days ago</span>
                                </div>
                            </div>

                            <span
                                class="bg-emerald-600/10 group-hover:bg-emerald-600 inline-block text-emerald-600 group-hover:text-white text-xs px-2.5 py-0.5 font-semibold rounded-full transition-all duration-500">Full
                                Time</span>
                        </div>

                        <div class="mt-6">
                            <a href="job-detail-two.html"
                                class="text-lg hover:text-emerald-600 font-semibold transition-all duration-500">C++
                                Developer</a>
                            <h6 class="text-base font-medium">
                                <i class="uil uil-map-marker"></i> India
                            </h6>
                        </div>

                        <div class="mt-6">
                            <div class="w-full bg-gray-100 dark:bg-gray-800 rounded-full h-[6px]">
                                <div class="bg-emerald-600 h-[6px] rounded-full" style="width: 55%"></div>
                            </div>
                            <div class="mt-2">
                                <span class="text-slate-400 text-sm"><span
                                        class="text-slate-900 dark:text-white font-semibold inline-block">21
                                        applied</span>
                                    of 40 vacancy</span>
                            </div>
                        </div>
                    </div>
                    <!--end content-->

                    <div class="group shadow dark:shadow-gray-700 p-6 rounded-md bg-white dark:bg-slate-900">
                        <div class="flex items-center justify-between">
                            <div class="flex items-center">
                                <div
                                    class="w-14 h-14 flex items-center justify-center bg-white dark:bg-slate-900 shadow dark:shadow-gray-700 rounded-md">
                                    <img src="assets/images/company/linkedin.png" class="h-8 w-8" alt="" />
                                </div>

                                <div class="ms-3">
                                    <a href="employer-detail.html"
                                        class="block text-[16px] font-semibold hover:text-emerald-600 transition-all duration-500">Linkedin</a>
                                    <span class="block text-sm text-slate-400">2 days ago</span>
                                </div>
                            </div>

                            <span
                                class="bg-emerald-600/10 group-hover:bg-emerald-600 inline-block text-emerald-600 group-hover:text-white text-xs px-2.5 py-0.5 font-semibold rounded-full transition-all duration-500">Remote</span>
                        </div>

                        <div class="mt-6">
                            <a href="job-detail-two.html"
                                class="text-lg hover:text-emerald-600 font-semibold transition-all duration-500">Php
                                Developer</a>
                            <h6 class="text-base font-medium">
                                <i class="uil uil-map-marker"></i> Pakistan
                            </h6>
                        </div>

                        <div class="mt-6">
                            <div class="w-full bg-gray-100 dark:bg-gray-800 rounded-full h-[6px]">
                                <div class="bg-emerald-600 h-[6px] rounded-full" style="width: 55%"></div>
                            </div>
                            <div class="mt-2">
                                <span class="text-slate-400 text-sm"><span
                                        class="text-slate-900 dark:text-white font-semibold inline-block">21
                                        applied</span>
                                    of 40 vacancy</span>
                            </div>
                        </div>
                    </div>
                    <!--end content-->
                </div>
                <!--end grid-->

                <div class="grid md:grid-cols-12 grid-cols-1 mt-8">
                    <div class="md:col-span-12 text-center">
                        <a href="job-grid-two.html"
                            class="btn btn-link text-slate-400 hover:text-emerald-600 after:bg-emerald-600 duration-500 ease-in-out">See
                            More Jobs <i class="uil uil-arrow-right align-middle"></i></a>
                    </div>
                </div>
                <!--end grid-->
            <!--end container-->
        </section>
        <!--end section-->
        <!-- End -->

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
                    <i class="uil uil-phone text-[30px] text-emerald-600 group-hover:text-white"></i>
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
                    <i class="uil uil-atom text-[30px] text-emerald-600 group-hover:text-white"></i>
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
                    <i class="uil uil-user-arrows text-[30px] text-emerald-600 group-hover:text-white"></i>
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
                    <i class="uil uil-hourglass text-[30px] text-emerald-600 group-hover:text-white"></i>
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
    <div class="container mb-16 md:mt-24 mt-16" data-aos="fade-in">
        <div class="grid grid-cols-1 pb-8 text-center">
            <h3 class="mb-4 md:text-[26px] md:leading-normal text-2xl leading-normal font-semibold">
                Latest Blog or News
            </h3>

            <p class="text-slate-400 max-w-xl mx-auto">
                Search all the open positions on the web. Get your own personalized
                salary estimate. Read reviews on over 30000+ companies worldwide.
            </p>
        </div>
        <!--end grid-->

        <div class="grid lg:grid-cols-3 md:grid-cols-2 grid-cols-1 mt-8 gap-[30px]">
            <div
                class="group relative overflow-hidden bg-white dark:bg-slate-900 rounded-md shadow dark:shadow-gray-700">
                <div class="relative overflow-hidden">
                    <img src="https://shreethemes.in/jobstack/layouts/assets/images/blog/02.jpg"
                        class="scale-110 group-hover:scale-100 transition-all duration-500" alt="" />
                </div>

                <div class="relative p-6">
                    <div class="absolute start-6 -top-4">
                        <span
                            class="bg-emerald-600 text-white text-[12px] px-2.5 py-1 font-semibold rounded-full h-5">Arts</span>
                    </div>

                    <div class="">
                        <div class="flex mb-4">
                            <span class="text-slate-400 text-sm"><i
                                    class="uil uil-calendar-alt text-slate-900 dark:text-white me-2"></i>20th
                                February, 2023</span>
                            <span class="text-slate-400 text-sm ms-3"><i
                                    class="uil uil-clock text-slate-900 dark:text-white me-2"></i>5 min read</span>
                        </div>

                        <a href="blog-detail.html"
                            class="title text-lg font-semibold hover:text-emerald-600 duration-500 ease-in-out">11
                            Tips to Help You Get New Clients Through Cold Calling</a>

                        <div class="flex justify-between items-center mt-3">
                            <a href="blog-detail.html"
                                class="btn btn-link hover:text-emerald-600 after:bg-emerald-600 duration-500 ease-in-out">Read
                                More <i class="uil uil-arrow-right"></i></a>
                            <span class="text-slate-400 text-sm">by
                                <a href=""
                                    class="text-slate-900 dark:text-white hover:text-emerald-600 dark:hover:text-emerald-600 font-medium">Google</a></span>
                        </div>
                    </div>
                </div>
            </div>
            <!--end content-->

            <div
                class="group relative overflow-hidden bg-white dark:bg-slate-900 rounded-md shadow dark:shadow-gray-700">
                <div class="relative overflow-hidden">
                    <img src="https://shreethemes.in/jobstack/layouts/assets/images/blog/02.jpg"
                        class="scale-110 group-hover:scale-100 transition-all duration-500" alt="" />
                </div>

                <div class="relative p-6">
                    <div class="absolute start-6 -top-4">
                        <span
                            class="bg-emerald-600 text-white text-[12px] px-2.5 py-1 font-semibold rounded-full h-5">Illustration</span>
                    </div>

                    <div class="">
                        <div class="flex mb-4">
                            <span class="text-slate-400 text-sm"><i
                                    class="uil uil-calendar-alt text-slate-900 dark:text-white me-2"></i>20th
                                February, 2023</span>
                            <span class="text-slate-400 text-sm ms-3"><i
                                    class="uil uil-clock text-slate-900 dark:text-white me-2"></i>5 min read</span>
                        </div>

                        <a href="blog-detail.html"
                            class="title text-lg font-semibold hover:text-emerald-600 duration-500 ease-in-out">DigitalOcean
                            launches first Canadian data centre in
                            Toronto</a>

                        <div class="flex justify-between items-center mt-3">
                            <a href="blog-detail.html"
                                class="btn btn-link hover:text-emerald-600 after:bg-emerald-600 duration-500 ease-in-out">Read
                                More <i class="uil uil-arrow-right"></i></a>
                            <span class="text-slate-400 text-sm">by
                                <a href=""
                                    class="text-slate-900 dark:text-white hover:text-emerald-600 dark:hover:text-emerald-600 font-medium">Facebook</a></span>
                        </div>
                    </div>
                </div>
            </div>
            <!--end content-->

            <div
                class="group relative overflow-hidden bg-white dark:bg-slate-900 rounded-md shadow dark:shadow-gray-700">
                <div class="relative overflow-hidden">
                    <img src="https://shreethemes.in/jobstack/layouts/assets/images/blog/02.jpg"
                        class="scale-110 group-hover:scale-100 transition-all duration-500" alt="" />
                </div>

                <div class="relative p-6">
                    <div class="absolute start-6 -top-4">
                        <span
                            class="bg-emerald-600 text-white text-[12px] px-2.5 py-1 font-semibold rounded-full h-5">Music</span>
                    </div>

                    <div class="">
                        <div class="flex mb-4">
                            <span class="text-slate-400 text-sm"><i
                                    class="uil uil-calendar-alt text-slate-900 dark:text-white me-2"></i>20th
                                February, 2023</span>
                            <span class="text-slate-400 text-sm ms-3"><i
                                    class="uil uil-clock text-slate-900 dark:text-white me-2"></i>5 min read</span>
                        </div>

                        <a href="blog-detail.html"
                            class="title text-lg font-semibold hover:text-emerald-600 duration-500 ease-in-out">Using
                            Banner Stands To Increase Trade Show Traffic</a>

                        <div class="flex justify-between items-center mt-3">
                            <a href="blog-detail.html"
                                class="btn btn-link hover:text-emerald-600 after:bg-emerald-600 duration-500 ease-in-out">Read
                                More <i class="uil uil-arrow-right"></i></a>
                            <span class="text-slate-400 text-sm">by
                                <a href=""
                                    class="text-slate-900 dark:text-white hover:text-emerald-600 dark:hover:text-emerald-600 font-medium">Linkedin</a></span>
                        </div>
                    </div>
                </div>
            </div>
            <!--end content-->
        </div>
        <!--end grid-->
    </div>
    <!--end container-->
</main>
<!-- End #main -->

<jsp:include page="footer.jsp" flush="true"></jsp:include>