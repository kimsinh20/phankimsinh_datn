<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

    <!-- ======= Header ======= -->
    <jsp:include page="../header.jsp" flush="true"></jsp:include>

    <main id="main pt-24">
        <div class="container">
            <div>
                <nav class="flex justify-end mt-6" aria-label="Breadcrumb">
                    <ol class="inline-flex items-center space-x-1 md:space-x-2 rtl:space-x-reverse">
                        <li class="inline-flex items-center"><a href="#"
                                class="inline-flex items-center text-sm font-medium text-gray-700 hover:text-blue-600 dark:text-gray-400 dark:hover:text-white">
                                <svg class="w-3 h-3 me-2.5" aria-hidden="true" xmlns="http://www.w3.org/2000/svg"
                                    fill="currentColor" viewBox="0 0 20 20">
                                    <path
                                        d="m19.707 9.293-2-2-7-7a1 1 0 0 0-1.414 0l-7 7-2 2a1 1 0 0 0 1.414 1.414L2 10.414V18a2 2 0 0 0 2 2h3a1 1 0 0 0 1-1v-4a1 1 0 0 1 1-1h2a1 1 0 0 1 1 1v4a1 1 0 0 0 1 1h3a2 2 0 0 0 2-2v-7.586l.293.293a1 1 0 0 0 1.414-1.414Z" />
                                </svg> Home
                            </a></li>
                        <li>
                            <div class="flex items-center">
                                <svg class="rtl:rotate-180 w-3 h-3 text-gray-400 mx-1" aria-hidden="true"
                                    xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 6 10">
                                    <path stroke="currentColor" stroke-linecap="round" stroke-linejoin="round"
                                        stroke-width="2" d="m1 9 4-4-4-4" />
                                </svg>
                                <a href="#"
                                    class="ms-1 text-sm font-medium text-gray-700 hover:text-blue-600 md:ms-2 dark:text-gray-400 dark:hover:text-white">jobs</a>
                            </div>
                        </li>
                        <li aria-current="page">
                            <div class="flex items-center">
                                <svg class="rtl:rotate-180 w-3 h-3 text-gray-400 mx-1" aria-hidden="true"
                                    xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 6 10">
                                    <path stroke="currentColor" stroke-linecap="round" stroke-linejoin="round"
                                        stroke-width="2" d="m1 9 4-4-4-4" />
                                </svg>
                                <span
                                    class="ms-1 text-sm font-medium text-gray-500 md:ms-2 dark:text-gray-400">list</span>
                            </div>
                        </li>
                    </ol>
                </nav>

               
            </div>
            <div class="grid md:grid-cols-12 grid-cols-1 gap-[30px]">
                <div class="lg:col-span-4 md:col-span-6">
                    <div class="shadow dark:shadow-gray-700 p-6 rounded-md bg-white dark:bg-slate-900 sticky top-20">
                        <form>
                            <div class="grid grid-cols-1 gap-3">
                                <div>
                                    <label for="searchname" class="font-semibold">Search
                                        Company</label>
                                    <div class="relative mt-2">
                                        <i class="uil uil-search text-lg absolute top-[5px] start-3"></i>
                                        <input name="search" id="searchname" type="text"
                                            class="form-input border border-slate-100 dark:border-slate-800 ps-10"
                                            placeholder="Search">
                                    </div>
                                </div>

                                <div>
                                    <label class="font-semibold">Categories</label> <select
                                        class="form-select form-input border border-slate-100 dark:border-slate-800 block w-full mt-1">
                                        <option value="WD">Web Designer</option>
                                        <option value="WD">Web Developer</option>
                                        <option value="UI">UI / UX Desinger</option>
                                    </select>
                                </div>

                                <div>
                                    <label class="font-semibold">Location</label> <select
                                        class="form-select form-input border border-slate-100 dark:border-slate-800 block w-full mt-1">
                                        <option value="NY">New York</option>
                                        <option value="MC">North Carolina</option>
                                        <option value="SC">South Carolina</option>
                                    </select>
                                </div>

                                <div>
                                    <label class="font-semibold">Job Types</label>
                                    <div class="block mt-2">
                                        <div class="flex justify-between">
                                            <div class="inline-flex items-center mb-0">
                                                <input
                                                    class="form-checkbox rounded border-gray-200 dark:border-gray-800 text-emerald-600 focus:border-emerald-300 focus:ring focus:ring-offset-0 focus:ring-emerald-200 focus:ring-opacity-50 me-2"
                                                    type="checkbox" value="" id="fulltime"> <label
                                                    class="form-checkbox-label text-slate-400" for="fulltime">Full
                                                    Time</label>
                                            </div>

                                            <span
                                                class="bg-emerald-600/10 text-emerald-600 text-xs px-2.5 py-0.5 font-semibold rounded-full h-5">3</span>
                                        </div>
                                        <div class="flex justify-between">
                                            <div class="inline-flex items-center mb-0">
                                                <input
                                                    class="form-checkbox rounded border-gray-200 dark:border-gray-800 text-emerald-600 focus:border-emerald-300 focus:ring focus:ring-offset-0 focus:ring-emerald-200 focus:ring-opacity-50 me-2"
                                                    type="checkbox" value="" id="parttime"> <label
                                                    class="form-checkbox-label text-slate-400" for="parttime">Part
                                                    Time</label>
                                            </div>

                                            <span
                                                class="bg-emerald-600/10 text-emerald-600 text-xs px-2.5 py-0.5 font-semibold rounded-full h-5">7</span>
                                        </div>
                                        <div class="flex justify-between">
                                            <div class="inline-flex items-center mb-0">
                                                <input
                                                    class="form-checkbox rounded border-gray-200 dark:border-gray-800 text-emerald-600 focus:border-emerald-300 focus:ring focus:ring-offset-0 focus:ring-emerald-200 focus:ring-opacity-50 me-2"
                                                    type="checkbox" value="" id="Freelancing"> <label
                                                    class="form-checkbox-label text-slate-400"
                                                    for="Freelancing">Freelancing</label>
                                            </div>

                                            <span
                                                class="bg-emerald-600/10 text-emerald-600 text-xs px-2.5 py-0.5 font-semibold rounded-full h-5">4</span>
                                        </div>
                                        <div class="flex justify-between">
                                            <div class="inline-flex items-center mb-0">
                                                <input
                                                    class="form-checkbox rounded border-gray-200 dark:border-gray-800 text-emerald-600 focus:border-emerald-300 focus:ring focus:ring-offset-0 focus:ring-emerald-200 focus:ring-opacity-50 me-2"
                                                    type="checkbox" value="" id="fixedprice"> <label
                                                    class="form-checkbox-label text-slate-400" for="fixedprice">Fixed
                                                    Price</label>
                                            </div>

                                            <span
                                                class="bg-emerald-600/10 text-emerald-600 text-xs px-2.5 py-0.5 font-semibold rounded-full h-5">6</span>
                                        </div>
                                        <div class="flex justify-between">
                                            <div class="inline-flex items-center mb-0">
                                                <input
                                                    class="form-checkbox rounded border-gray-200 dark:border-gray-800 text-emerald-600 focus:border-emerald-300 focus:ring focus:ring-offset-0 focus:ring-emerald-200 focus:ring-opacity-50 me-2"
                                                    type="checkbox" value="" id="Remote"> <label
                                                    class="form-checkbox-label text-slate-400"
                                                    for="Remote">Remote</label>
                                            </div>

                                            <span
                                                class="bg-emerald-600/10 text-emerald-600 text-xs px-2.5 py-0.5 font-semibold rounded-full h-5">7</span>
                                        </div>
                                        <div class="flex justify-between">
                                            <div class="inline-flex items-center mb-0">
                                                <input
                                                    class="form-checkbox rounded border-gray-200 dark:border-gray-800 text-emerald-600 focus:border-emerald-300 focus:ring focus:ring-offset-0 focus:ring-emerald-200 focus:ring-opacity-50 me-2"
                                                    type="checkbox" value="" id="hourlybasis"> <label
                                                    class="form-checkbox-label text-slate-400" for="hourlybasis">Hourly
                                                    Basis</label>
                                            </div>

                                            <span
                                                class="bg-emerald-600/10 text-emerald-600 text-xs px-2.5 py-0.5 font-semibold rounded-full h-5">44</span>
                                        </div>
                                    </div>
                                </div>

                                <div>
                                    <label class="font-semibold">Salary</label>
                                    <div class="block mt-2">
                                        <div>
                                            <label class="inline-flex items-center"> <input type="radio"
                                                    class="form-radio border-gray-200 dark:border-gray-800 text-emerald-600 focus:border-emerald-300 focus:ring focus:ring-offset-0 focus:ring-emerald-200 focus:ring-opacity-50 me-2"
                                                    name="radio-colors" value="1" checked=""> <span
                                                    class="text-slate-400">10k - 15k</span>
                                            </label>
                                        </div>
                                        <div>
                                            <label class="inline-flex items-center"> <input type="radio"
                                                    class="form-radio border-gray-200 dark:border-gray-800 text-emerald-600 focus:border-emerald-300 focus:ring focus:ring-offset-0 focus:ring-emerald-200 focus:ring-opacity-50 me-2"
                                                    name="radio-colors" value="1"> <span class="text-slate-400">15k -
                                                    25k</span>
                                            </label>
                                        </div>
                                        <div>
                                            <label class="inline-flex items-center"> <input type="radio"
                                                    class="form-radio border-gray-200 dark:border-gray-800 text-emerald-600 focus:border-emerald-300 focus:ring focus:ring-offset-0 focus:ring-emerald-200 focus:ring-opacity-50 me-2"
                                                    name="radio-colors" value="1"> <span class="text-slate-400">more
                                                    than 25K</span>
                                            </label>
                                        </div>
                                    </div>
                                </div>

                                <div>
                                    <input type="submit"
                                        class="btn bg-emerald-600 hover:bg-emerald-700 border-emerald-600 hover:border-emerald-700 text-white rounded-md w-full"
                                        value="Apply Filter">
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
                <!--end col-->

                <div class="lg:col-span-8 md:col-span-6 mt-14">
                	<h3 class="py-2 text-lg font-medium">Tuyển dụng <span class="text-xl font-bold">423</span> vị trí việc làm</h3>
                	 <div class="flex items-center">
                    	<span class="me-2">Sắp xếp theo : </span>
	                    <ul class="flex">
	                        <li class="me-2 border rounded px-3 py-2 bg-gray-100"><a href="#">Mặc định</a></li>
	                        <li class="me-2 border rounded px-3 py-2 bg-gray-100"><a href="#">Cũ nhất</a></li>
	                        <li class="me-2 border rounded px-3 py-2 bg-gray-100"><a href="#">Mới nhất</a></li>
	                    </ul>
                	</div>
                    <div class="grid grid-cols-1 gap-[30px] mt-6">
                        <div
                            class="group relative overflow-hidden bg-white dark:bg-slate-900 shadow hover:shadow-md dark:shadow-gray-700 dark:hover:shadow-gray-700 hover:-mt-2 rounded-md transition-all duration-500 h-fit">
                            <div class="p-6">
                                <div class="flex items-center">
                                    <div
                                        class="size-14 min-w-[56px] flex items-center justify-center bg-white dark:bg-slate-900 shadow dark:shadow-gray-700 rounded-md">
                                        <img src="assets/images/company/facebook-logo.png" class="size-8" alt="">
                                    </div>

                                    <div class="ms-3">
                                        <a href="job-detail-three.html"
                                            class="inline-block text-[16px] font-semibold hover:text-emerald-600 transition-all duration-500 me-1">Web
                                            Designer</a> <span class="inline-block text-sm text-slate-400">2
                                            days ago</span>
                                        <div>
                                            <span
                                                class="bg-emerald-600/10 inline-block text-emerald-600 text-xs px-2.5 py-0.5 font-semibold rounded-full me-1">Full
                                                Time</span> <span class="text-sm font-medium inline-block me-1">Est.
                                                time: <span class="text-slate-400">1 to 3 months</span>
                                            </span> <span class="text-sm font-medium inline-block me-1">Hourly:
                                                <span class="text-slate-400">$16 - $20</span>
                                            </span>
                                        </div>
                                    </div>
                                </div>

                                <p class="text-slate-400 py-3">Looking for an experienced Web
                                    Designer for an our company.</p>

                                <div>
                                    <span
                                        class="bg-slate-100 dark:bg-slate-800 inline-block text-slate-900 dark:text-slate-300 text-xs px-2.5 py-0.5 font-semibold rounded-full me-1">HTML</span>
                                    <span
                                        class="bg-slate-100 dark:bg-slate-800 inline-block text-slate-900 dark:text-slate-300 text-xs px-2.5 py-0.5 font-semibold rounded-full me-1">CSS</span>
                                    <span
                                        class="bg-slate-100 dark:bg-slate-800 inline-block text-slate-900 dark:text-slate-300 text-xs px-2.5 py-0.5 font-semibold rounded-full me-1">SASS</span>
                                    <span
                                        class="bg-slate-100 dark:bg-slate-800 inline-block text-slate-900 dark:text-slate-300 text-xs px-2.5 py-0.5 font-semibold rounded-full me-1">SCSS</span>
                                    <span
                                        class="bg-slate-100 dark:bg-slate-800 inline-block text-slate-900 dark:text-slate-300 text-xs px-2.5 py-0.5 font-semibold rounded-full me-1">Photoshop</span>
                                    <span
                                        class="bg-slate-100 dark:bg-slate-800 inline-block text-slate-900 dark:text-slate-300 text-xs px-2.5 py-0.5 font-semibold rounded-full me-1">Graphics</span>
                                    <span
                                        class="bg-slate-100 dark:bg-slate-800 inline-block text-slate-900 dark:text-slate-300 text-xs px-2.5 py-0.5 font-semibold rounded-full me-1">Bootstrap</span>
                                </div>
                            </div>

                            <div class="px-6 py-2 bg-slate-50 dark:bg-slate-800 lg:flex justify-between items-center">
                                <div class="lg:inline-block flex justify-between">
                                    <span class="inline-block me-1 font-semibold"><i
                                            class="mdi mdi-check-decagram mdi-18px text-blue-500 me-1"></i>Verified</span>
                                    <ul class="list-none inline-block me-1 text-yellow-400 space-x-0.5">
                                        <li class="inline"><i class="mdi mdi-star text-lg"></i></li>
                                        <li class="inline"><i class="mdi mdi-star text-lg"></i></li>
                                        <li class="inline"><i class="mdi mdi-star text-lg"></i></li>
                                        <li class="inline"><i class="mdi mdi-star text-lg"></i></li>
                                        <li class="inline"><i class="mdi mdi-star text-lg"></i></li>
                                    </ul>
                                    <span class="inline-block me-1 text-slate-400"><i
                                            class="uil uil-map-marker text-[18px] text-slate-900 dark:text-white me-1"></i>Australia</span>
                                </div>

                                <a href="job-apply.html"
                                    class="btn btn-sm rounded-md bg-emerald-600 hover:bg-emerald-700 border-emerald-600 hover:border-emerald-700 text-white md:ms-2 w-full lg:w-auto lg:mt-0 mt-4">Apply
                                    Now</a>
                            </div>

                            <a href=""
                                class="btn btn-icon rounded-full bg-emerald-600/5 hover:bg-emerald-600 border-emerald-600/10 hover:border-emerald-600 text-emerald-600 hover:text-white absolute top-0 end-0 m-3"><svg
                                    xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24"
                                    fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round"
                                    stroke-linejoin="round" class="feather feather-bookmark size-4">
                                    <path d="M19 21l-7-5-7 5V5a2 2 0 0 1 2-2h10a2 2 0 0 1 2 2z"></path>
                                </svg></a>
                        </div>
                        <!--end content-->

                        <div
                            class="group relative overflow-hidden bg-white dark:bg-slate-900 shadow hover:shadow-md dark:shadow-gray-700 dark:hover:shadow-gray-700 hover:-mt-2 rounded-md transition-all duration-500 h-fit">
                            <div class="p-6">
                                <div class="flex items-center">
                                    <div
                                        class="size-14 min-w-[56px] flex items-center justify-center bg-white dark:bg-slate-900 shadow dark:shadow-gray-700 rounded-md">
                                        <img src="assets/images/company/google-logo.png" class="size-8" alt="">
                                    </div>

                                    <div class="ms-3">
                                        <a href="job-detail-three.html"
                                            class="inline-block text-[16px] font-semibold hover:text-emerald-600 transition-all duration-500 me-1">Marketing
                                            Director</a> <span class="inline-block text-sm text-slate-400">2
                                            days ago</span>
                                        <div>
                                            <span
                                                class="bg-emerald-600/10 inline-block text-emerald-600 text-xs px-2.5 py-0.5 font-semibold rounded-full me-1">Part
                                                Time</span> <span class="text-sm font-medium inline-block me-1">Est.
                                                time: <span class="text-slate-400">1 to 3 months</span>
                                            </span> <span class="text-sm font-medium inline-block me-1">Hourly:
                                                <span class="text-slate-400">$16 - $20</span>
                                            </span>
                                        </div>
                                    </div>
                                </div>

                                <p class="text-slate-400 py-3">Looking for an experienced Web
                                    Designer for an our company.</p>

                                <div>
                                    <span
                                        class="bg-slate-100 dark:bg-slate-800 inline-block text-slate-900 dark:text-slate-300 text-xs px-2.5 py-0.5 font-semibold rounded-full me-1">HTML</span>
                                    <span
                                        class="bg-slate-100 dark:bg-slate-800 inline-block text-slate-900 dark:text-slate-300 text-xs px-2.5 py-0.5 font-semibold rounded-full me-1">CSS</span>
                                    <span
                                        class="bg-slate-100 dark:bg-slate-800 inline-block text-slate-900 dark:text-slate-300 text-xs px-2.5 py-0.5 font-semibold rounded-full me-1">SASS</span>
                                    <span
                                        class="bg-slate-100 dark:bg-slate-800 inline-block text-slate-900 dark:text-slate-300 text-xs px-2.5 py-0.5 font-semibold rounded-full me-1">SCSS</span>
                                    <span
                                        class="bg-slate-100 dark:bg-slate-800 inline-block text-slate-900 dark:text-slate-300 text-xs px-2.5 py-0.5 font-semibold rounded-full me-1">Photoshop</span>
                                    <span
                                        class="bg-slate-100 dark:bg-slate-800 inline-block text-slate-900 dark:text-slate-300 text-xs px-2.5 py-0.5 font-semibold rounded-full me-1">Graphics</span>
                                    <span
                                        class="bg-slate-100 dark:bg-slate-800 inline-block text-slate-900 dark:text-slate-300 text-xs px-2.5 py-0.5 font-semibold rounded-full me-1">Bootstrap</span>
                                </div>
                            </div>

                            <div class="px-6 py-2 bg-slate-50 dark:bg-slate-800 lg:flex justify-between items-center">
                                <div class="lg:inline-block flex justify-between">
                                    <span class="inline-block me-1 font-semibold"><i
                                            class="mdi mdi-check-decagram mdi-18px text-blue-500 me-1"></i>Verified</span>
                                    <ul class="list-none inline-block me-1 text-yellow-400 space-x-0.5">
                                        <li class="inline"><i class="mdi mdi-star text-lg"></i></li>
                                        <li class="inline"><i class="mdi mdi-star text-lg"></i></li>
                                        <li class="inline"><i class="mdi mdi-star text-lg"></i></li>
                                        <li class="inline"><i class="mdi mdi-star text-lg"></i></li>
                                        <li class="inline"><i class="mdi mdi-star text-lg"></i></li>
                                    </ul>
                                    <span class="inline-block me-1 text-slate-400"><i
                                            class="uil uil-map-marker text-[18px] text-slate-900 dark:text-white me-1"></i>USA</span>
                                </div>

                                <a href="job-apply.html"
                                    class="btn btn-sm rounded-md bg-emerald-600 hover:bg-emerald-700 border-emerald-600 hover:border-emerald-700 text-white md:ms-2 w-full lg:w-auto lg:mt-0 mt-4">Apply
                                    Now</a>
                            </div>

                            <a href=""
                                class="btn btn-icon rounded-full bg-emerald-600/5 hover:bg-emerald-600 border-emerald-600/10 hover:border-emerald-600 text-emerald-600 hover:text-white absolute top-0 end-0 m-3"><svg
                                    xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24"
                                    fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round"
                                    stroke-linejoin="round" class="feather feather-bookmark size-4">
                                    <path d="M19 21l-7-5-7 5V5a2 2 0 0 1 2-2h10a2 2 0 0 1 2 2z"></path>
                                </svg></a>
                        </div>
                        <!--end content-->

                        <div
                            class="group relative overflow-hidden bg-white dark:bg-slate-900 shadow hover:shadow-md dark:shadow-gray-700 dark:hover:shadow-gray-700 hover:-mt-2 rounded-md transition-all duration-500 h-fit">
                            <div class="p-6">
                                <div class="flex items-center">
                                    <div
                                        class="size-14 min-w-[56px] flex items-center justify-center bg-white dark:bg-slate-900 shadow dark:shadow-gray-700 rounded-md">
                                        <img src="assets/images/company/android.png" class="size-8" alt="">
                                    </div>

                                    <div class="ms-3">
                                        <a href="job-detail-three.html"
                                            class="inline-block text-[16px] font-semibold hover:text-emerald-600 transition-all duration-500 me-1">App
                                            Developer</a> <span class="inline-block text-sm text-slate-400">2
                                            days ago</span>
                                        <div>
                                            <span
                                                class="bg-emerald-600/10 inline-block text-emerald-600 text-xs px-2.5 py-0.5 font-semibold rounded-full me-1">Remote</span>
                                            <span class="text-sm font-medium inline-block me-1">Est.
                                                time: <span class="text-slate-400">1 to 3 months</span>
                                            </span> <span class="text-sm font-medium inline-block me-1">Hourly:
                                                <span class="text-slate-400">$16 - $20</span>
                                            </span>
                                        </div>
                                    </div>
                                </div>

                                <p class="text-slate-400 py-3">Looking for an experienced Web
                                    Designer for an our company.</p>

                                <div>
                                    <span
                                        class="bg-slate-100 dark:bg-slate-800 inline-block text-slate-900 dark:text-slate-300 text-xs px-2.5 py-0.5 font-semibold rounded-full me-1">HTML</span>
                                    <span
                                        class="bg-slate-100 dark:bg-slate-800 inline-block text-slate-900 dark:text-slate-300 text-xs px-2.5 py-0.5 font-semibold rounded-full me-1">CSS</span>
                                    <span
                                        class="bg-slate-100 dark:bg-slate-800 inline-block text-slate-900 dark:text-slate-300 text-xs px-2.5 py-0.5 font-semibold rounded-full me-1">SASS</span>
                                    <span
                                        class="bg-slate-100 dark:bg-slate-800 inline-block text-slate-900 dark:text-slate-300 text-xs px-2.5 py-0.5 font-semibold rounded-full me-1">SCSS</span>
                                    <span
                                        class="bg-slate-100 dark:bg-slate-800 inline-block text-slate-900 dark:text-slate-300 text-xs px-2.5 py-0.5 font-semibold rounded-full me-1">Photoshop</span>
                                    <span
                                        class="bg-slate-100 dark:bg-slate-800 inline-block text-slate-900 dark:text-slate-300 text-xs px-2.5 py-0.5 font-semibold rounded-full me-1">Graphics</span>
                                    <span
                                        class="bg-slate-100 dark:bg-slate-800 inline-block text-slate-900 dark:text-slate-300 text-xs px-2.5 py-0.5 font-semibold rounded-full me-1">Bootstrap</span>
                                </div>
                            </div>

                            <div class="px-6 py-2 bg-slate-50 dark:bg-slate-800 lg:flex justify-between items-center">
                                <div class="lg:inline-block flex justify-between">
                                    <span class="inline-block me-1 font-semibold"><i
                                            class="mdi mdi-check-decagram mdi-18px text-blue-500 me-1"></i>Verified</span>
                                    <ul class="list-none inline-block me-1 text-yellow-400 space-x-0.5">
                                        <li class="inline"><i class="mdi mdi-star text-lg"></i></li>
                                        <li class="inline"><i class="mdi mdi-star text-lg"></i></li>
                                        <li class="inline"><i class="mdi mdi-star text-lg"></i></li>
                                        <li class="inline"><i class="mdi mdi-star text-lg"></i></li>
                                        <li class="inline"><i class="mdi mdi-star text-lg"></i></li>
                                    </ul>
                                    <span class="inline-block me-1 text-slate-400"><i
                                            class="uil uil-map-marker text-[18px] text-slate-900 dark:text-white me-1"></i>China</span>
                                </div>

                                <a href="job-apply.html"
                                    class="btn btn-sm rounded-md bg-emerald-600 hover:bg-emerald-700 border-emerald-600 hover:border-emerald-700 text-white md:ms-2 w-full lg:w-auto lg:mt-0 mt-4">Apply
                                    Now</a>
                            </div>

                            <a href=""
                                class="btn btn-icon rounded-full bg-emerald-600/5 hover:bg-emerald-600 border-emerald-600/10 hover:border-emerald-600 text-emerald-600 hover:text-white absolute top-0 end-0 m-3"><svg
                                    xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24"
                                    fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round"
                                    stroke-linejoin="round" class="feather feather-bookmark size-4">
                                    <path d="M19 21l-7-5-7 5V5a2 2 0 0 1 2-2h10a2 2 0 0 1 2 2z"></path>
                                </svg></a>
                        </div>
                        <!--end content-->

                        <div
                            class="group relative overflow-hidden bg-white dark:bg-slate-900 shadow hover:shadow-md dark:shadow-gray-700 dark:hover:shadow-gray-700 hover:-mt-2 rounded-md transition-all duration-500 h-fit">
                            <div class="p-6">
                                <div class="flex items-center">
                                    <div
                                        class="size-14 min-w-[56px] flex items-center justify-center bg-white dark:bg-slate-900 shadow dark:shadow-gray-700 rounded-md">
                                        <img src="assets/images/company/lenovo-logo.png" class="size-8" alt="">
                                    </div>

                                    <div class="ms-3">
                                        <a href="job-detail-three.html"
                                            class="inline-block text-[16px] font-semibold hover:text-emerald-600 transition-all duration-500 me-1">Product
                                            Designer</a> <span class="inline-block text-sm text-slate-400">2
                                            days ago</span>
                                        <div>
                                            <span
                                                class="bg-emerald-600/10 inline-block text-emerald-600 text-xs px-2.5 py-0.5 font-semibold rounded-full me-1">WFH</span>
                                            <span class="text-sm font-medium inline-block me-1">Est.
                                                time: <span class="text-slate-400">1 to 3 months</span>
                                            </span> <span class="text-sm font-medium inline-block me-1">Hourly:
                                                <span class="text-slate-400">$16 - $20</span>
                                            </span>
                                        </div>
                                    </div>
                                </div>

                                <p class="text-slate-400 py-3">Looking for an experienced Web
                                    Designer for an our company.</p>

                                <div>
                                    <span
                                        class="bg-slate-100 dark:bg-slate-800 inline-block text-slate-900 dark:text-slate-300 text-xs px-2.5 py-0.5 font-semibold rounded-full me-1">HTML</span>
                                    <span
                                        class="bg-slate-100 dark:bg-slate-800 inline-block text-slate-900 dark:text-slate-300 text-xs px-2.5 py-0.5 font-semibold rounded-full me-1">CSS</span>
                                    <span
                                        class="bg-slate-100 dark:bg-slate-800 inline-block text-slate-900 dark:text-slate-300 text-xs px-2.5 py-0.5 font-semibold rounded-full me-1">SASS</span>
                                    <span
                                        class="bg-slate-100 dark:bg-slate-800 inline-block text-slate-900 dark:text-slate-300 text-xs px-2.5 py-0.5 font-semibold rounded-full me-1">SCSS</span>
                                    <span
                                        class="bg-slate-100 dark:bg-slate-800 inline-block text-slate-900 dark:text-slate-300 text-xs px-2.5 py-0.5 font-semibold rounded-full me-1">Photoshop</span>
                                    <span
                                        class="bg-slate-100 dark:bg-slate-800 inline-block text-slate-900 dark:text-slate-300 text-xs px-2.5 py-0.5 font-semibold rounded-full me-1">Graphics</span>
                                    <span
                                        class="bg-slate-100 dark:bg-slate-800 inline-block text-slate-900 dark:text-slate-300 text-xs px-2.5 py-0.5 font-semibold rounded-full me-1">Bootstrap</span>
                                </div>
                            </div>

                            <div class="px-6 py-2 bg-slate-50 dark:bg-slate-800 lg:flex justify-between items-center">
                                <div class="lg:inline-block flex justify-between">
                                    <span class="inline-block me-1 font-semibold"><i
                                            class="mdi mdi-check-decagram mdi-18px text-blue-500 me-1"></i>Verified</span>
                                    <ul class="list-none inline-block me-1 text-yellow-400 space-x-0.5">
                                        <li class="inline"><i class="mdi mdi-star text-lg"></i></li>
                                        <li class="inline"><i class="mdi mdi-star text-lg"></i></li>
                                        <li class="inline"><i class="mdi mdi-star text-lg"></i></li>
                                        <li class="inline"><i class="mdi mdi-star text-lg"></i></li>
                                        <li class="inline"><i class="mdi mdi-star text-lg"></i></li>
                                    </ul>
                                    <span class="inline-block me-1 text-slate-400"><i
                                            class="uil uil-map-marker text-[18px] text-slate-900 dark:text-white me-1"></i>Dubai</span>
                                </div>

                                <a href="job-apply.html"
                                    class="btn btn-sm rounded-md bg-emerald-600 hover:bg-emerald-700 border-emerald-600 hover:border-emerald-700 text-white md:ms-2 w-full lg:w-auto lg:mt-0 mt-4">Apply
                                    Now</a>
                            </div>

                            <a href=""
                                class="btn btn-icon rounded-full bg-emerald-600/5 hover:bg-emerald-600 border-emerald-600/10 hover:border-emerald-600 text-emerald-600 hover:text-white absolute top-0 end-0 m-3"><svg
                                    xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24"
                                    fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round"
                                    stroke-linejoin="round" class="feather feather-bookmark size-4">
                                    <path d="M19 21l-7-5-7 5V5a2 2 0 0 1 2-2h10a2 2 0 0 1 2 2z"></path>
                                </svg></a>
                        </div>
                        <!--end content-->

                        <div
                            class="group relative overflow-hidden bg-white dark:bg-slate-900 shadow hover:shadow-md dark:shadow-gray-700 dark:hover:shadow-gray-700 hover:-mt-2 rounded-md transition-all duration-500 h-fit">
                            <div class="p-6">
                                <div class="flex items-center">
                                    <div
                                        class="size-14 min-w-[56px] flex items-center justify-center bg-white dark:bg-slate-900 shadow dark:shadow-gray-700 rounded-md">
                                        <img src="assets/images/company/spotify.png" class="size-8" alt="">
                                    </div>

                                    <div class="ms-3">
                                        <a href="job-detail-three.html"
                                            class="inline-block text-[16px] font-semibold hover:text-emerald-600 transition-all duration-500 me-1">C++
                                            Developer</a> <span class="inline-block text-sm text-slate-400">2
                                            days ago</span>
                                        <div>
                                            <span
                                                class="bg-emerald-600/10 inline-block text-emerald-600 text-xs px-2.5 py-0.5 font-semibold rounded-full me-1">Full
                                                Time</span> <span class="text-sm font-medium inline-block me-1">Est.
                                                time: <span class="text-slate-400">1 to 3 months</span>
                                            </span> <span class="text-sm font-medium inline-block me-1">Hourly:
                                                <span class="text-slate-400">$16 - $20</span>
                                            </span>
                                        </div>
                                    </div>
                                </div>

                                <p class="text-slate-400 py-3">Looking for an experienced Web
                                    Designer for an our company.</p>

                                <div>
                                    <span
                                        class="bg-slate-100 dark:bg-slate-800 inline-block text-slate-900 dark:text-slate-300 text-xs px-2.5 py-0.5 font-semibold rounded-full me-1">HTML</span>
                                    <span
                                        class="bg-slate-100 dark:bg-slate-800 inline-block text-slate-900 dark:text-slate-300 text-xs px-2.5 py-0.5 font-semibold rounded-full me-1">CSS</span>
                                    <span
                                        class="bg-slate-100 dark:bg-slate-800 inline-block text-slate-900 dark:text-slate-300 text-xs px-2.5 py-0.5 font-semibold rounded-full me-1">SASS</span>
                                    <span
                                        class="bg-slate-100 dark:bg-slate-800 inline-block text-slate-900 dark:text-slate-300 text-xs px-2.5 py-0.5 font-semibold rounded-full me-1">SCSS</span>
                                    <span
                                        class="bg-slate-100 dark:bg-slate-800 inline-block text-slate-900 dark:text-slate-300 text-xs px-2.5 py-0.5 font-semibold rounded-full me-1">Photoshop</span>
                                    <span
                                        class="bg-slate-100 dark:bg-slate-800 inline-block text-slate-900 dark:text-slate-300 text-xs px-2.5 py-0.5 font-semibold rounded-full me-1">Graphics</span>
                                    <span
                                        class="bg-slate-100 dark:bg-slate-800 inline-block text-slate-900 dark:text-slate-300 text-xs px-2.5 py-0.5 font-semibold rounded-full me-1">Bootstrap</span>
                                </div>
                            </div>

                            <div class="px-6 py-2 bg-slate-50 dark:bg-slate-800 lg:flex justify-between items-center">
                                <div class="lg:inline-block flex justify-between">
                                    <span class="inline-block me-1 font-semibold"><i
                                            class="mdi mdi-check-decagram mdi-18px text-blue-500 me-1"></i>Verified</span>
                                    <ul class="list-none inline-block me-1 text-yellow-400 space-x-0.5">
                                        <li class="inline"><i class="mdi mdi-star text-lg"></i></li>
                                        <li class="inline"><i class="mdi mdi-star text-lg"></i></li>
                                        <li class="inline"><i class="mdi mdi-star text-lg"></i></li>
                                        <li class="inline"><i class="mdi mdi-star text-lg"></i></li>
                                        <li class="inline"><i class="mdi mdi-star text-lg"></i></li>
                                    </ul>
                                    <span class="inline-block me-1 text-slate-400"><i
                                            class="uil uil-map-marker text-[18px] text-slate-900 dark:text-white me-1"></i>India</span>
                                </div>

                                <a href="job-apply.html"
                                    class="btn btn-sm rounded-md bg-emerald-600 hover:bg-emerald-700 border-emerald-600 hover:border-emerald-700 text-white md:ms-2 w-full lg:w-auto lg:mt-0 mt-4">Apply
                                    Now</a>
                            </div>

                            <a href=""
                                class="btn btn-icon rounded-full bg-emerald-600/5 hover:bg-emerald-600 border-emerald-600/10 hover:border-emerald-600 text-emerald-600 hover:text-white absolute top-0 end-0 m-3"><svg
                                    xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24"
                                    fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round"
                                    stroke-linejoin="round" class="feather feather-bookmark size-4">
                                    <path d="M19 21l-7-5-7 5V5a2 2 0 0 1 2-2h10a2 2 0 0 1 2 2z"></path>
                                </svg></a>
                        </div>
                        <!--end content-->

                        <div
                            class="group relative overflow-hidden bg-white dark:bg-slate-900 shadow hover:shadow-md dark:shadow-gray-700 dark:hover:shadow-gray-700 hover:-mt-2 rounded-md transition-all duration-500 h-fit">
                            <div class="p-6">
                                <div class="flex items-center">
                                    <div
                                        class="size-14 min-w-[56px] flex items-center justify-center bg-white dark:bg-slate-900 shadow dark:shadow-gray-700 rounded-md">
                                        <img src="assets/images/company/linkedin.png" class="size-8" alt="">
                                    </div>

                                    <div class="ms-3">
                                        <a href="job-detail-three.html"
                                            class="inline-block text-[16px] font-semibold hover:text-emerald-600 transition-all duration-500 me-1">Php
                                            Developer</a> <span class="inline-block text-sm text-slate-400">2
                                            days ago</span>
                                        <div>
                                            <span
                                                class="bg-emerald-600/10 inline-block text-emerald-600 text-xs px-2.5 py-0.5 font-semibold rounded-full me-1">Remote</span>
                                            <span class="text-sm font-medium inline-block me-1">Est.
                                                time: <span class="text-slate-400">1 to 3 months</span>
                                            </span> <span class="text-sm font-medium inline-block me-1">Hourly:
                                                <span class="text-slate-400">$16 - $20</span>
                                            </span>
                                        </div>
                                    </div>
                                </div>

                                <p class="text-slate-400 py-3">Looking for an experienced Web
                                    Designer for an our company.</p>

                                <div>
                                    <span
                                        class="bg-slate-100 dark:bg-slate-800 inline-block text-slate-900 dark:text-slate-300 text-xs px-2.5 py-0.5 font-semibold rounded-full me-1">HTML</span>
                                    <span
                                        class="bg-slate-100 dark:bg-slate-800 inline-block text-slate-900 dark:text-slate-300 text-xs px-2.5 py-0.5 font-semibold rounded-full me-1">CSS</span>
                                    <span
                                        class="bg-slate-100 dark:bg-slate-800 inline-block text-slate-900 dark:text-slate-300 text-xs px-2.5 py-0.5 font-semibold rounded-full me-1">SASS</span>
                                    <span
                                        class="bg-slate-100 dark:bg-slate-800 inline-block text-slate-900 dark:text-slate-300 text-xs px-2.5 py-0.5 font-semibold rounded-full me-1">SCSS</span>
                                    <span
                                        class="bg-slate-100 dark:bg-slate-800 inline-block text-slate-900 dark:text-slate-300 text-xs px-2.5 py-0.5 font-semibold rounded-full me-1">Photoshop</span>
                                    <span
                                        class="bg-slate-100 dark:bg-slate-800 inline-block text-slate-900 dark:text-slate-300 text-xs px-2.5 py-0.5 font-semibold rounded-full me-1">Graphics</span>
                                    <span
                                        class="bg-slate-100 dark:bg-slate-800 inline-block text-slate-900 dark:text-slate-300 text-xs px-2.5 py-0.5 font-semibold rounded-full me-1">Bootstrap</span>
                                </div>
                            </div>

                            <div class="px-6 py-2 bg-slate-50 dark:bg-slate-800 lg:flex justify-between items-center">
                                <div class="lg:inline-block flex justify-between">
                                    <span class="inline-block me-1 font-semibold"><i
                                            class="mdi mdi-check-decagram mdi-18px text-blue-500 me-1"></i>Verified</span>
                                    <ul class="list-none inline-block me-1 text-yellow-400 space-x-0.5">
                                        <li class="inline"><i class="mdi mdi-star text-lg"></i></li>
                                        <li class="inline"><i class="mdi mdi-star text-lg"></i></li>
                                        <li class="inline"><i class="mdi mdi-star text-lg"></i></li>
                                        <li class="inline"><i class="mdi mdi-star text-lg"></i></li>
                                        <li class="inline"><i class="mdi mdi-star text-lg"></i></li>
                                    </ul>
                                    <span class="inline-block me-1 text-slate-400"><i
                                            class="uil uil-map-marker text-[18px] text-slate-900 dark:text-white me-1"></i>Pakistan</span>
                                </div>

                                <a href="job-apply.html"
                                    class="btn btn-sm rounded-md bg-emerald-600 hover:bg-emerald-700 border-emerald-600 hover:border-emerald-700 text-white md:ms-2 w-full lg:w-auto lg:mt-0 mt-4">Apply
                                    Now</a>
                            </div>

                            <a href=""
                                class="btn btn-icon rounded-full bg-emerald-600/5 hover:bg-emerald-600 border-emerald-600/10 hover:border-emerald-600 text-emerald-600 hover:text-white absolute top-0 end-0 m-3"><svg
                                    xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24"
                                    fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round"
                                    stroke-linejoin="round" class="feather feather-bookmark size-4">
                                    <path d="M19 21l-7-5-7 5V5a2 2 0 0 1 2-2h10a2 2 0 0 1 2 2z"></path>
                                </svg></a>
                        </div>
                        <!--end content-->

                        <div
                            class="group relative overflow-hidden bg-white dark:bg-slate-900 shadow hover:shadow-md dark:shadow-gray-700 dark:hover:shadow-gray-700 hover:-mt-2 rounded-md transition-all duration-500 h-fit">
                            <div class="p-6">
                                <div class="flex items-center">
                                    <div
                                        class="size-14 min-w-[56px] flex items-center justify-center bg-white dark:bg-slate-900 shadow dark:shadow-gray-700 rounded-md">
                                        <img src="assets/images/company/circle-logo.png" class="size-8" alt="">
                                    </div>

                                    <div class="ms-3">
                                        <a href="job-detail-three.html"
                                            class="inline-block text-[16px] font-semibold hover:text-emerald-600 transition-all duration-500 me-1">Web
                                            Designer</a> <span class="inline-block text-sm text-slate-400">2
                                            days ago</span>
                                        <div>
                                            <span
                                                class="bg-emerald-600/10 inline-block text-emerald-600 text-xs px-2.5 py-0.5 font-semibold rounded-full me-1">Full
                                                Time</span> <span class="text-sm font-medium inline-block me-1">Est.
                                                time: <span class="text-slate-400">1 to 3 months</span>
                                            </span> <span class="text-sm font-medium inline-block me-1">Hourly:
                                                <span class="text-slate-400">$16 - $20</span>
                                            </span>
                                        </div>
                                    </div>
                                </div>

                                <p class="text-slate-400 py-3">Looking for an experienced Web
                                    Designer for an our company.</p>

                                <div>
                                    <span
                                        class="bg-slate-100 dark:bg-slate-800 inline-block text-slate-900 dark:text-slate-300 text-xs px-2.5 py-0.5 font-semibold rounded-full me-1">HTML</span>
                                    <span
                                        class="bg-slate-100 dark:bg-slate-800 inline-block text-slate-900 dark:text-slate-300 text-xs px-2.5 py-0.5 font-semibold rounded-full me-1">CSS</span>
                                    <span
                                        class="bg-slate-100 dark:bg-slate-800 inline-block text-slate-900 dark:text-slate-300 text-xs px-2.5 py-0.5 font-semibold rounded-full me-1">SASS</span>
                                    <span
                                        class="bg-slate-100 dark:bg-slate-800 inline-block text-slate-900 dark:text-slate-300 text-xs px-2.5 py-0.5 font-semibold rounded-full me-1">SCSS</span>
                                    <span
                                        class="bg-slate-100 dark:bg-slate-800 inline-block text-slate-900 dark:text-slate-300 text-xs px-2.5 py-0.5 font-semibold rounded-full me-1">Photoshop</span>
                                    <span
                                        class="bg-slate-100 dark:bg-slate-800 inline-block text-slate-900 dark:text-slate-300 text-xs px-2.5 py-0.5 font-semibold rounded-full me-1">Graphics</span>
                                    <span
                                        class="bg-slate-100 dark:bg-slate-800 inline-block text-slate-900 dark:text-slate-300 text-xs px-2.5 py-0.5 font-semibold rounded-full me-1">Bootstrap</span>
                                </div>
                            </div>

                            <div class="px-6 py-2 bg-slate-50 dark:bg-slate-800 lg:flex justify-between items-center">
                                <div class="lg:inline-block flex justify-between">
                                    <span class="inline-block me-1 font-semibold"><i
                                            class="mdi mdi-check-decagram mdi-18px text-blue-500 me-1"></i>Verified</span>
                                    <ul class="list-none inline-block me-1 text-yellow-400 space-x-0.5">
                                        <li class="inline"><i class="mdi mdi-star text-lg"></i></li>
                                        <li class="inline"><i class="mdi mdi-star text-lg"></i></li>
                                        <li class="inline"><i class="mdi mdi-star text-lg"></i></li>
                                        <li class="inline"><i class="mdi mdi-star text-lg"></i></li>
                                        <li class="inline"><i class="mdi mdi-star text-lg"></i></li>
                                    </ul>
                                    <span class="inline-block me-1 text-slate-400"><i
                                            class="uil uil-map-marker text-[18px] text-slate-900 dark:text-white me-1"></i>Australia</span>
                                </div>

                                <a href="job-apply.html"
                                    class="btn btn-sm rounded-md bg-emerald-600 hover:bg-emerald-700 border-emerald-600 hover:border-emerald-700 text-white md:ms-2 w-full lg:w-auto lg:mt-0 mt-4">Apply
                                    Now</a>
                            </div>

                            <a href=""
                                class="btn btn-icon rounded-full bg-emerald-600/5 hover:bg-emerald-600 border-emerald-600/10 hover:border-emerald-600 text-emerald-600 hover:text-white absolute top-0 end-0 m-3"><svg
                                    xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24"
                                    fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round"
                                    stroke-linejoin="round" class="feather feather-bookmark size-4">
                                    <path d="M19 21l-7-5-7 5V5a2 2 0 0 1 2-2h10a2 2 0 0 1 2 2z"></path>
                                </svg></a>
                        </div>
                        <!--end content-->

                        <div
                            class="group relative overflow-hidden bg-white dark:bg-slate-900 shadow hover:shadow-md dark:shadow-gray-700 dark:hover:shadow-gray-700 hover:-mt-2 rounded-md transition-all duration-500 h-fit">
                            <div class="p-6">
                                <div class="flex items-center">
                                    <div
                                        class="size-14 min-w-[56px] flex items-center justify-center bg-white dark:bg-slate-900 shadow dark:shadow-gray-700 rounded-md">
                                        <img src="assets/images/company/skype.png" class="size-8" alt="">
                                    </div>

                                    <div class="ms-3">
                                        <a href="job-detail-three.html"
                                            class="inline-block text-[16px] font-semibold hover:text-emerald-600 transition-all duration-500 me-1">Marketing
                                            Director</a> <span class="inline-block text-sm text-slate-400">2
                                            days ago</span>
                                        <div>
                                            <span
                                                class="bg-emerald-600/10 inline-block text-emerald-600 text-xs px-2.5 py-0.5 font-semibold rounded-full me-1">Part
                                                Time</span> <span class="text-sm font-medium inline-block me-1">Est.
                                                time: <span class="text-slate-400">1 to 3 months</span>
                                            </span> <span class="text-sm font-medium inline-block me-1">Hourly:
                                                <span class="text-slate-400">$16 - $20</span>
                                            </span>
                                        </div>
                                    </div>
                                </div>

                                <p class="text-slate-400 py-3">Looking for an experienced Web
                                    Designer for an our company.</p>

                                <div>
                                    <span
                                        class="bg-slate-100 dark:bg-slate-800 inline-block text-slate-900 dark:text-slate-300 text-xs px-2.5 py-0.5 font-semibold rounded-full me-1">HTML</span>
                                    <span
                                        class="bg-slate-100 dark:bg-slate-800 inline-block text-slate-900 dark:text-slate-300 text-xs px-2.5 py-0.5 font-semibold rounded-full me-1">CSS</span>
                                    <span
                                        class="bg-slate-100 dark:bg-slate-800 inline-block text-slate-900 dark:text-slate-300 text-xs px-2.5 py-0.5 font-semibold rounded-full me-1">SASS</span>
                                    <span
                                        class="bg-slate-100 dark:bg-slate-800 inline-block text-slate-900 dark:text-slate-300 text-xs px-2.5 py-0.5 font-semibold rounded-full me-1">SCSS</span>
                                    <span
                                        class="bg-slate-100 dark:bg-slate-800 inline-block text-slate-900 dark:text-slate-300 text-xs px-2.5 py-0.5 font-semibold rounded-full me-1">Photoshop</span>
                                    <span
                                        class="bg-slate-100 dark:bg-slate-800 inline-block text-slate-900 dark:text-slate-300 text-xs px-2.5 py-0.5 font-semibold rounded-full me-1">Graphics</span>
                                    <span
                                        class="bg-slate-100 dark:bg-slate-800 inline-block text-slate-900 dark:text-slate-300 text-xs px-2.5 py-0.5 font-semibold rounded-full me-1">Bootstrap</span>
                                </div>
                            </div>

                            <div class="px-6 py-2 bg-slate-50 dark:bg-slate-800 lg:flex justify-between items-center">
                                <div class="lg:inline-block flex justify-between">
                                    <span class="inline-block me-1 font-semibold"><i
                                            class="mdi mdi-check-decagram mdi-18px text-blue-500 me-1"></i>Verified</span>
                                    <ul class="list-none inline-block me-1 text-yellow-400 space-x-0.5">
                                        <li class="inline"><i class="mdi mdi-star text-lg"></i></li>
                                        <li class="inline"><i class="mdi mdi-star text-lg"></i></li>
                                        <li class="inline"><i class="mdi mdi-star text-lg"></i></li>
                                        <li class="inline"><i class="mdi mdi-star text-lg"></i></li>
                                        <li class="inline"><i class="mdi mdi-star text-lg"></i></li>
                                    </ul>
                                    <span class="inline-block me-1 text-slate-400"><i
                                            class="uil uil-map-marker text-[18px] text-slate-900 dark:text-white me-1"></i>USA</span>
                                </div>

                                <a href="job-apply.html"
                                    class="btn btn-sm rounded-md bg-emerald-600 hover:bg-emerald-700 border-emerald-600 hover:border-emerald-700 text-white md:ms-2 w-full lg:w-auto lg:mt-0 mt-4">Apply
                                    Now</a>
                            </div>

                            <a href=""
                                class="btn btn-icon rounded-full bg-emerald-600/5 hover:bg-emerald-600 border-emerald-600/10 hover:border-emerald-600 text-emerald-600 hover:text-white absolute top-0 end-0 m-3"><svg
                                    xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24"
                                    fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round"
                                    stroke-linejoin="round" class="feather feather-bookmark size-4">
                                    <path d="M19 21l-7-5-7 5V5a2 2 0 0 1 2-2h10a2 2 0 0 1 2 2z"></path>
                                </svg></a>
                        </div>
                        <!--end content-->

                        <div
                            class="group relative overflow-hidden bg-white dark:bg-slate-900 shadow hover:shadow-md dark:shadow-gray-700 dark:hover:shadow-gray-700 hover:-mt-2 rounded-md transition-all duration-500 h-fit">
                            <div class="p-6">
                                <div class="flex items-center">
                                    <div
                                        class="size-14 min-w-[56px] flex items-center justify-center bg-white dark:bg-slate-900 shadow dark:shadow-gray-700 rounded-md">
                                        <img src="assets/images/company/snapchat.png" class="size-8" alt="">
                                    </div>

                                    <div class="ms-3">
                                        <a href="job-detail-three.html"
                                            class="inline-block text-[16px] font-semibold hover:text-emerald-600 transition-all duration-500 me-1">App
                                            Developer</a> <span class="inline-block text-sm text-slate-400">2
                                            days ago</span>
                                        <div>
                                            <span
                                                class="bg-emerald-600/10 inline-block text-emerald-600 text-xs px-2.5 py-0.5 font-semibold rounded-full me-1">Remote</span>
                                            <span class="text-sm font-medium inline-block me-1">Est.
                                                time: <span class="text-slate-400">1 to 3 months</span>
                                            </span> <span class="text-sm font-medium inline-block me-1">Hourly:
                                                <span class="text-slate-400">$16 - $20</span>
                                            </span>
                                        </div>
                                    </div>
                                </div>

                                <p class="text-slate-400 py-3">Looking for an experienced Web
                                    Designer for an our company.</p>

                                <div>
                                    <span
                                        class="bg-slate-100 dark:bg-slate-800 inline-block text-slate-900 dark:text-slate-300 text-xs px-2.5 py-0.5 font-semibold rounded-full me-1">HTML</span>
                                    <span
                                        class="bg-slate-100 dark:bg-slate-800 inline-block text-slate-900 dark:text-slate-300 text-xs px-2.5 py-0.5 font-semibold rounded-full me-1">CSS</span>
                                    <span
                                        class="bg-slate-100 dark:bg-slate-800 inline-block text-slate-900 dark:text-slate-300 text-xs px-2.5 py-0.5 font-semibold rounded-full me-1">SASS</span>
                                    <span
                                        class="bg-slate-100 dark:bg-slate-800 inline-block text-slate-900 dark:text-slate-300 text-xs px-2.5 py-0.5 font-semibold rounded-full me-1">SCSS</span>
                                    <span
                                        class="bg-slate-100 dark:bg-slate-800 inline-block text-slate-900 dark:text-slate-300 text-xs px-2.5 py-0.5 font-semibold rounded-full me-1">Photoshop</span>
                                    <span
                                        class="bg-slate-100 dark:bg-slate-800 inline-block text-slate-900 dark:text-slate-300 text-xs px-2.5 py-0.5 font-semibold rounded-full me-1">Graphics</span>
                                    <span
                                        class="bg-slate-100 dark:bg-slate-800 inline-block text-slate-900 dark:text-slate-300 text-xs px-2.5 py-0.5 font-semibold rounded-full me-1">Bootstrap</span>
                                </div>
                            </div>

                            <div class="px-6 py-2 bg-slate-50 dark:bg-slate-800 lg:flex justify-between items-center">
                                <div class="lg:inline-block flex justify-between">
                                    <span class="inline-block me-1 font-semibold"><i
                                            class="mdi mdi-check-decagram mdi-18px text-blue-500 me-1"></i>Verified</span>
                                    <ul class="list-none inline-block me-1 text-yellow-400 space-x-0.5">
                                        <li class="inline"><i class="mdi mdi-star text-lg"></i></li>
                                        <li class="inline"><i class="mdi mdi-star text-lg"></i></li>
                                        <li class="inline"><i class="mdi mdi-star text-lg"></i></li>
                                        <li class="inline"><i class="mdi mdi-star text-lg"></i></li>
                                        <li class="inline"><i class="mdi mdi-star text-lg"></i></li>
                                    </ul>
                                    <span class="inline-block me-1 text-slate-400"><i
                                            class="uil uil-map-marker text-[18px] text-slate-900 dark:text-white me-1"></i>China</span>
                                </div>

                                <a href="job-apply.html"
                                    class="btn btn-sm rounded-md bg-emerald-600 hover:bg-emerald-700 border-emerald-600 hover:border-emerald-700 text-white md:ms-2 w-full lg:w-auto lg:mt-0 mt-4">Apply
                                    Now</a>
                            </div>

                            <a href=""
                                class="btn btn-icon rounded-full bg-emerald-600/5 hover:bg-emerald-600 border-emerald-600/10 hover:border-emerald-600 text-emerald-600 hover:text-white absolute top-0 end-0 m-3"><svg
                                    xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24"
                                    fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round"
                                    stroke-linejoin="round" class="feather feather-bookmark size-4">
                                    <path d="M19 21l-7-5-7 5V5a2 2 0 0 1 2-2h10a2 2 0 0 1 2 2z"></path>
                                </svg></a>
                        </div>
                        <!--end content-->

                        <div
                            class="group relative overflow-hidden bg-white dark:bg-slate-900 shadow hover:shadow-md dark:shadow-gray-700 dark:hover:shadow-gray-700 hover:-mt-2 rounded-md transition-all duration-500 h-fit">
                            <div class="p-6">
                                <div class="flex items-center">
                                    <div
                                        class="size-14 min-w-[56px] flex items-center justify-center bg-white dark:bg-slate-900 shadow dark:shadow-gray-700 rounded-md">
                                        <img src="assets/images/company/shree-logo.png" class="size-8" alt="">
                                    </div>

                                    <div class="ms-3">
                                        <a href="job-detail-three.html"
                                            class="inline-block text-[16px] font-semibold hover:text-emerald-600 transition-all duration-500 me-1">Product
                                            Designer</a> <span class="inline-block text-sm text-slate-400">2
                                            days ago</span>
                                        <div>
                                            <span
                                                class="bg-emerald-600/10 inline-block text-emerald-600 text-xs px-2.5 py-0.5 font-semibold rounded-full me-1">WFH</span>
                                            <span class="text-sm font-medium inline-block me-1">Est.
                                                time: <span class="text-slate-400">1 to 3 months</span>
                                            </span> <span class="text-sm font-medium inline-block me-1">Hourly:
                                                <span class="text-slate-400">$16 - $20</span>
                                            </span>
                                        </div>
                                    </div>
                                </div>

                                <p class="text-slate-400 py-3">Looking for an experienced Web
                                    Designer for an our company.</p>

                                <div>
                                    <span
                                        class="bg-slate-100 dark:bg-slate-800 inline-block text-slate-900 dark:text-slate-300 text-xs px-2.5 py-0.5 font-semibold rounded-full me-1">HTML</span>
                                    <span
                                        class="bg-slate-100 dark:bg-slate-800 inline-block text-slate-900 dark:text-slate-300 text-xs px-2.5 py-0.5 font-semibold rounded-full me-1">CSS</span>
                                    <span
                                        class="bg-slate-100 dark:bg-slate-800 inline-block text-slate-900 dark:text-slate-300 text-xs px-2.5 py-0.5 font-semibold rounded-full me-1">SASS</span>
                                    <span
                                        class="bg-slate-100 dark:bg-slate-800 inline-block text-slate-900 dark:text-slate-300 text-xs px-2.5 py-0.5 font-semibold rounded-full me-1">SCSS</span>
                                    <span
                                        class="bg-slate-100 dark:bg-slate-800 inline-block text-slate-900 dark:text-slate-300 text-xs px-2.5 py-0.5 font-semibold rounded-full me-1">Photoshop</span>
                                    <span
                                        class="bg-slate-100 dark:bg-slate-800 inline-block text-slate-900 dark:text-slate-300 text-xs px-2.5 py-0.5 font-semibold rounded-full me-1">Graphics</span>
                                    <span
                                        class="bg-slate-100 dark:bg-slate-800 inline-block text-slate-900 dark:text-slate-300 text-xs px-2.5 py-0.5 font-semibold rounded-full me-1">Bootstrap</span>
                                </div>
                            </div>

                            <div class="px-6 py-2 bg-slate-50 dark:bg-slate-800 lg:flex justify-between items-center">
                                <div class="lg:inline-block flex justify-between">
                                    <span class="inline-block me-1 font-semibold"><i
                                            class="mdi mdi-check-decagram mdi-18px text-blue-500 me-1"></i>Verified</span>
                                    <ul class="list-none inline-block me-1 text-yellow-400 space-x-0.5">
                                        <li class="inline"><i class="mdi mdi-star text-lg"></i></li>
                                        <li class="inline"><i class="mdi mdi-star text-lg"></i></li>
                                        <li class="inline"><i class="mdi mdi-star text-lg"></i></li>
                                        <li class="inline"><i class="mdi mdi-star text-lg"></i></li>
                                        <li class="inline"><i class="mdi mdi-star text-lg"></i></li>
                                    </ul>
                                    <span class="inline-block me-1 text-slate-400"><i
                                            class="uil uil-map-marker text-[18px] text-slate-900 dark:text-white me-1"></i>Dubai</span>
                                </div>

                                <a href="job-apply.html"
                                    class="btn btn-sm rounded-md bg-emerald-600 hover:bg-emerald-700 border-emerald-600 hover:border-emerald-700 text-white md:ms-2 w-full lg:w-auto lg:mt-0 mt-4">Apply
                                    Now</a>
                            </div>

                            <a href=""
                                class="btn btn-icon rounded-full bg-emerald-600/5 hover:bg-emerald-600 border-emerald-600/10 hover:border-emerald-600 text-emerald-600 hover:text-white absolute top-0 end-0 m-3"><svg
                                    xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24"
                                    fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round"
                                    stroke-linejoin="round" class="feather feather-bookmark size-4">
                                    <path d="M19 21l-7-5-7 5V5a2 2 0 0 1 2-2h10a2 2 0 0 1 2 2z"></path>
                                </svg></a>
                        </div>
                        <!--end content-->

                        <div
                            class="group relative overflow-hidden bg-white dark:bg-slate-900 shadow hover:shadow-md dark:shadow-gray-700 dark:hover:shadow-gray-700 hover:-mt-2 rounded-md transition-all duration-500 h-fit">
                            <div class="p-6">
                                <div class="flex items-center">
                                    <div
                                        class="size-14 min-w-[56px] flex items-center justify-center bg-white dark:bg-slate-900 shadow dark:shadow-gray-700 rounded-md">
                                        <img src="assets/images/company/telegram.png" class="size-8" alt="">
                                    </div>

                                    <div class="ms-3">
                                        <a href="job-detail-three.html"
                                            class="inline-block text-[16px] font-semibold hover:text-emerald-600 transition-all duration-500 me-1">C++
                                            Developer</a> <span class="inline-block text-sm text-slate-400">2
                                            days ago</span>
                                        <div>
                                            <span
                                                class="bg-emerald-600/10 inline-block text-emerald-600 text-xs px-2.5 py-0.5 font-semibold rounded-full me-1">Full
                                                Time</span> <span class="text-sm font-medium inline-block me-1">Est.
                                                time: <span class="text-slate-400">1 to 3 months</span>
                                            </span> <span class="text-sm font-medium inline-block me-1">Hourly:
                                                <span class="text-slate-400">$16 - $20</span>
                                            </span>
                                        </div>
                                    </div>
                                </div>

                                <p class="text-slate-400 py-3">Looking for an experienced Web
                                    Designer for an our company.</p>

                                <div>
                                    <span
                                        class="bg-slate-100 dark:bg-slate-800 inline-block text-slate-900 dark:text-slate-300 text-xs px-2.5 py-0.5 font-semibold rounded-full me-1">HTML</span>
                                    <span
                                        class="bg-slate-100 dark:bg-slate-800 inline-block text-slate-900 dark:text-slate-300 text-xs px-2.5 py-0.5 font-semibold rounded-full me-1">CSS</span>
                                    <span
                                        class="bg-slate-100 dark:bg-slate-800 inline-block text-slate-900 dark:text-slate-300 text-xs px-2.5 py-0.5 font-semibold rounded-full me-1">SASS</span>
                                    <span
                                        class="bg-slate-100 dark:bg-slate-800 inline-block text-slate-900 dark:text-slate-300 text-xs px-2.5 py-0.5 font-semibold rounded-full me-1">SCSS</span>
                                    <span
                                        class="bg-slate-100 dark:bg-slate-800 inline-block text-slate-900 dark:text-slate-300 text-xs px-2.5 py-0.5 font-semibold rounded-full me-1">Photoshop</span>
                                    <span
                                        class="bg-slate-100 dark:bg-slate-800 inline-block text-slate-900 dark:text-slate-300 text-xs px-2.5 py-0.5 font-semibold rounded-full me-1">Graphics</span>
                                    <span
                                        class="bg-slate-100 dark:bg-slate-800 inline-block text-slate-900 dark:text-slate-300 text-xs px-2.5 py-0.5 font-semibold rounded-full me-1">Bootstrap</span>
                                </div>
                            </div>

                            <div class="px-6 py-2 bg-slate-50 dark:bg-slate-800 lg:flex justify-between items-center">
                                <div class="lg:inline-block flex justify-between">
                                    <span class="inline-block me-1 font-semibold"><i
                                            class="mdi mdi-check-decagram mdi-18px text-blue-500 me-1"></i>Verified</span>
                                    <ul class="list-none inline-block me-1 text-yellow-400 space-x-0.5">
                                        <li class="inline"><i class="mdi mdi-star text-lg"></i></li>
                                        <li class="inline"><i class="mdi mdi-star text-lg"></i></li>
                                        <li class="inline"><i class="mdi mdi-star text-lg"></i></li>
                                        <li class="inline"><i class="mdi mdi-star text-lg"></i></li>
                                        <li class="inline"><i class="mdi mdi-star text-lg"></i></li>
                                    </ul>
                                    <span class="inline-block me-1 text-slate-400"><i
                                            class="uil uil-map-marker text-[18px] text-slate-900 dark:text-white me-1"></i>India</span>
                                </div>

                                <a href="job-apply.html"
                                    class="btn btn-sm rounded-md bg-emerald-600 hover:bg-emerald-700 border-emerald-600 hover:border-emerald-700 text-white md:ms-2 w-full lg:w-auto lg:mt-0 mt-4">Apply
                                    Now</a>
                            </div>

                            <a href=""
                                class="btn btn-icon rounded-full bg-emerald-600/5 hover:bg-emerald-600 border-emerald-600/10 hover:border-emerald-600 text-emerald-600 hover:text-white absolute top-0 end-0 m-3"><svg
                                    xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24"
                                    fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round"
                                    stroke-linejoin="round" class="feather feather-bookmark size-4">
                                    <path d="M19 21l-7-5-7 5V5a2 2 0 0 1 2-2h10a2 2 0 0 1 2 2z"></path>
                                </svg></a>
                        </div>
                        <!--end content-->

                        <div
                            class="group relative overflow-hidden bg-white dark:bg-slate-900 shadow hover:shadow-md dark:shadow-gray-700 dark:hover:shadow-gray-700 hover:-mt-2 rounded-md transition-all duration-500 h-fit">
                            <div class="p-6">
                                <div class="flex items-center">
                                    <div
                                        class="size-14 min-w-[56px] flex items-center justify-center bg-white dark:bg-slate-900 shadow dark:shadow-gray-700 rounded-md">
                                        <img src="assets/images/company/whatsapp.png" class="size-8" alt="">
                                    </div>

                                    <div class="ms-3">
                                        <a href="job-detail-three.html"
                                            class="inline-block text-[16px] font-semibold hover:text-emerald-600 transition-all duration-500 me-1">Php
                                            Developer</a> <span class="inline-block text-sm text-slate-400">2
                                            days ago</span>
                                        <div>
                                            <span
                                                class="bg-emerald-600/10 inline-block text-emerald-600 text-xs px-2.5 py-0.5 font-semibold rounded-full me-1">Remote</span>
                                            <span class="text-sm font-medium inline-block me-1">Est.
                                                time: <span class="text-slate-400">1 to 3 months</span>
                                            </span> <span class="text-sm font-medium inline-block me-1">Hourly:
                                                <span class="text-slate-400">$16 - $20</span>
                                            </span>
                                        </div>
                                    </div>
                                </div>

                                <p class="text-slate-400 py-3">Looking for an experienced Web
                                    Designer for an our company.</p>

                                <div>
                                    <span
                                        class="bg-slate-100 dark:bg-slate-800 inline-block text-slate-900 dark:text-slate-300 text-xs px-2.5 py-0.5 font-semibold rounded-full me-1">HTML</span>
                                    <span
                                        class="bg-slate-100 dark:bg-slate-800 inline-block text-slate-900 dark:text-slate-300 text-xs px-2.5 py-0.5 font-semibold rounded-full me-1">CSS</span>
                                    <span
                                        class="bg-slate-100 dark:bg-slate-800 inline-block text-slate-900 dark:text-slate-300 text-xs px-2.5 py-0.5 font-semibold rounded-full me-1">SASS</span>
                                    <span
                                        class="bg-slate-100 dark:bg-slate-800 inline-block text-slate-900 dark:text-slate-300 text-xs px-2.5 py-0.5 font-semibold rounded-full me-1">SCSS</span>
                                    <span
                                        class="bg-slate-100 dark:bg-slate-800 inline-block text-slate-900 dark:text-slate-300 text-xs px-2.5 py-0.5 font-semibold rounded-full me-1">Photoshop</span>
                                    <span
                                        class="bg-slate-100 dark:bg-slate-800 inline-block text-slate-900 dark:text-slate-300 text-xs px-2.5 py-0.5 font-semibold rounded-full me-1">Graphics</span>
                                    <span
                                        class="bg-slate-100 dark:bg-slate-800 inline-block text-slate-900 dark:text-slate-300 text-xs px-2.5 py-0.5 font-semibold rounded-full me-1">Bootstrap</span>
                                </div>
                            </div>

                            <div class="px-6 py-2 bg-slate-50 dark:bg-slate-800 lg:flex justify-between items-center">
                                <div class="lg:inline-block flex justify-between">
                                    <span class="inline-block me-1 font-semibold"><i
                                            class="mdi mdi-check-decagram mdi-18px text-blue-500 me-1"></i>Verified</span>
                                    <ul class="list-none inline-block me-1 text-yellow-400 space-x-0.5">
                                        <li class="inline"><i class="mdi mdi-star text-lg"></i></li>
                                        <li class="inline"><i class="mdi mdi-star text-lg"></i></li>
                                        <li class="inline"><i class="mdi mdi-star text-lg"></i></li>
                                        <li class="inline"><i class="mdi mdi-star text-lg"></i></li>
                                        <li class="inline"><i class="mdi mdi-star text-lg"></i></li>
                                    </ul>
                                    <span class="inline-block me-1 text-slate-400"><i
                                            class="uil uil-map-marker text-[18px] text-slate-900 dark:text-white me-1"></i>Pakistan</span>
                                </div>

                                <a href="job-apply.html"
                                    class="btn btn-sm rounded-md bg-emerald-600 hover:bg-emerald-700 border-emerald-600 hover:border-emerald-700 text-white md:ms-2 w-full lg:w-auto lg:mt-0 mt-4">Apply
                                    Now</a>
                            </div>

                            <a href=""
                                class="btn btn-icon rounded-full bg-emerald-600/5 hover:bg-emerald-600 border-emerald-600/10 hover:border-emerald-600 text-emerald-600 hover:text-white absolute top-0 end-0 m-3"><svg
                                    xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24"
                                    fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round"
                                    stroke-linejoin="round" class="feather feather-bookmark size-4">
                                    <path d="M19 21l-7-5-7 5V5a2 2 0 0 1 2-2h10a2 2 0 0 1 2 2z"></path>
                                </svg></a>
                        </div>
                        <!--end content-->
                    </div>
                    <!--end grid-->

                    <div class="grid md:grid-cols-12 grid-cols-1 mt-8">
                        <div class="md:col-span-12 text-center">
                            <nav aria-label="Page navigation example">
                                <ul class="inline-flex items-center -space-x-px">
                                    <li><a href="#"
                                            class="size-[40px] inline-flex justify-center items-center text-slate-400 bg-white dark:bg-slate-900 rounded-s-3xl hover:text-white border border-gray-100 dark:border-gray-800 hover:border-emerald-600 dark:hover:border-emerald-600 hover:bg-emerald-600 dark:hover:bg-emerald-600">
                                            <i class="uil uil-angle-left text-[20px] rtl:rotate-180 rtl:-mt-1"></i>
                                        </a></li>
                                    <li><a href="#"
                                            class="size-[40px] inline-flex justify-center items-center text-slate-400 hover:text-white bg-white dark:bg-slate-900 border border-gray-100 dark:border-gray-800 hover:border-emerald-600 dark:hover:border-emerald-600 hover:bg-emerald-600 dark:hover:bg-emerald-600">1</a>
                                    </li>
                                    <li><a href="#"
                                            class="size-[40px] inline-flex justify-center items-center text-slate-400 hover:text-white bg-white dark:bg-slate-900 border border-gray-100 dark:border-gray-800 hover:border-emerald-600 dark:hover:border-emerald-600 hover:bg-emerald-600 dark:hover:bg-emerald-600">2</a>
                                    </li>
                                    <li><a href="#" aria-current="page"
                                            class="z-10 size-[40px] inline-flex justify-center items-center text-white bg-emerald-600 border border-emerald-600">3</a>
                                    </li>
                                    <li><a href="#"
                                            class="size-[40px] inline-flex justify-center items-center text-slate-400 hover:text-white bg-white dark:bg-slate-900 border border-gray-100 dark:border-gray-800 hover:border-emerald-600 dark:hover:border-emerald-600 hover:bg-emerald-600 dark:hover:bg-emerald-600">4</a>
                                    </li>
                                    <li><a href="#"
                                            class="size-[40px] inline-flex justify-center items-center text-slate-400 hover:text-white bg-white dark:bg-slate-900 border border-gray-100 dark:border-gray-800 hover:border-emerald-600 dark:hover:border-emerald-600 hover:bg-emerald-600 dark:hover:bg-emerald-600">5</a>
                                    </li>
                                    <li><a href="#"
                                            class="size-[40px] inline-flex justify-center items-center text-slate-400 bg-white dark:bg-slate-900 rounded-e-3xl hover:text-white border border-gray-100 dark:border-gray-800 hover:border-emerald-600 dark:hover:border-emerald-600 hover:bg-emerald-600 dark:hover:bg-emerald-600">
                                            <i class="uil uil-angle-right text-[20px] rtl:rotate-180 rtl:-mt-1"></i>
                                        </a></li>
                                </ul>
                            </nav>
                        </div>
                        <!--end col-->
                    </div>
                    <!--end grid-->
                </div>
            </div>
        </div>
        `
    </main>
    <!-- End #main -->

    <jsp:include page="../footer.jsp" flush="true"></jsp:include>