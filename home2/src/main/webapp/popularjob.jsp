<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
	<%
                               	ArrayList<String> viewlist = (ArrayList<String>) session.getAttribute("listview");
                              	if (viewlist != null && viewlist.size()>0 ){
                    				out.append(viewlist.get(2));
                    			}
								%>
                   
                     
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