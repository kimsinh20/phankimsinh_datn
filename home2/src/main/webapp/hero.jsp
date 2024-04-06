 <%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

  <fmt:setLocale value="${sessionScope.lang}" />
  <fmt:setBundle basename="lang.lang" />
 <!-- Start Hero -->
        <section class="relative  md:py-56 py-36 container" data-aos="fade-up">
            <div class="absolute inset-0 bg-emerald-600/5 dark:bg-emerald-600/10"></div>
            <div class="container z-1">
                <div class="grid grid-cols-1 text-center mt-10 relative">
                    <h4 class="lg:leading-normal leading-normal text-4xl lg:text-5xl mb-5 font-bold"><fmt:message key="menu.join"/> & 
                    <span class="text-emerald-600 font-bold"><fmt:message key="menu.explore"/></span> <br> 
                     <span class="text-emerald-600 font-bold"><fmt:message key="menu.thousands"/></span> <fmt:message key="menu.ofjob"/> 
                     </h4>
               		<p class="text-slate-400 text-lg max-w-xl mx-auto"><fmt:message key="menu.des"/></p> 

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
                                                        placeholder="Nhập từ khóa">
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
                                                    class="btn rounded bg-emerald-600 hover:bg-emerald-700 border-emerald-600 hover:border-emerald-700 text-white searchbtn submit-btn w-100"
                                                    value="Lọc">
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