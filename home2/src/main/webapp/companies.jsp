<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class="container md:mt-24 md:pb-16 mt-16" data-aos="fade-up" data-aos-duration="1000">
                <div class="grid md:grid-cols-12 grid-cols-1 items-center gap-[30px]">
                    <div class="lg:col-span-5 md:col-span-6 md:order-2 order-1">
                        <div class="relative">
                            <div class="relative flex justify-end">
                                <img src="/home/img/job.jpg" class="lg:w-[400px] w-[280px] rounded-md shadow dark:shadow-gray-700" alt="">
                                <div class="absolute top-0 translate-y-2/4 start-0 text-center">
                                    <a href="#!" data-type="youtube" data-id="S_CGed6E610" class="lightbox size-20 rounded-full shadow-lg dark:shadow-gray-700 inline-flex items-center justify-center bg-white dark:bg-slate-900 text-emerald-600 dark:text-white">
                                       job now
                                    </a>
                                </div>
                            </div>
                            <div class="absolute md:-start-5 start-0 -bottom-16">
                                <img src="/home/img/lap.jpg" class="lg:w-[280px] w-[200px] border-8 border-white dark:border-slate-900 rounded-md shadow dark:shadow-gray-700" alt="">
                            </div>
                        </div>
                    </div>

                    <div class="lg:col-span-7 md:col-span-6 mt-14 md:mt-0 md:order-1 order-2">
                        <div class="lg:me-5">
                            <h3 class="mb-6 md:text-[26px] text-2xl md:leading-normal leading-normal font-semibold">Find Best Companies.</h3>

                            <p class="text-slate-400 max-w-xl">Search all the open positions on the web. Get your own personalized salary estimate. Read reviews on over 30000+ companies worldwide.</p>

                            <div class="grid md:grid-cols-2 grid-cols-1 gap-6 mt-8">
               
                               	<%
                               	ArrayList<String> viewlist = (ArrayList<String>) session.getAttribute("listview");
                              	if (viewlist != null && viewlist.size()>0 ){
                    				out.append(viewlist.get(1));
                    			}
								%>
                            </div>

                            <div class="grid md:grid-cols-12 grid-cols-1 mt-6">
                                <div class="md:col-span-12">
                                    <a href="" class="btn btn-link text-slate-400 hover:text-emerald-600 after:bg-emerald-600 duration-500 ease-in-out">See More Companies <i class="uil uil-arrow-right align-middle"></i></a>
                                </div>
                            </div><!--end grid-->
                        </div>
                    </div>
                </div>
            </div>
<!--end container-->