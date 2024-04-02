<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
         		<%
                   ArrayList<String> viewlist = (ArrayList<String>) session.getAttribute("listview");
                   if (viewlist != null && viewlist.size()>0 ){
                   out.append(viewlist.get(3));
                   }
				%>
        </div>
        <!--end grid-->
    </div>
    <!--end container-->