<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <!-- Start -->
        <div class="container">
            <div class="grid grid-cols-1 pb-8 text-center">
                <h3 class="mb-4 md:text-[26px] md:leading-normal text-2xl leading-normal font-semibold">Các lĩnh vực Hot</h3>

                <p class="text-slate-400 max-w-xl mx-auto">Tìm kiếm tất cả các lĩnh vực hot trên hiện nay. Các cơ hội việc làm phong phú , phù hợp với mọi đối tượng . Đọc đánh giá về hơn 30000 công ty trên toàn thế giới.</p>
            </div><!--end grid-->
			<div class="grid lg:grid-cols-5 md:grid-cols-3 sm:grid-cols-2 grid-cols-1 mt-8 gap-[30px]">
          	<%
			// lay cau truc hien thi trong phien
			ArrayList<String> viewlist = (ArrayList<String>) session.getAttribute("listview");
          	if (viewlist != null && viewlist.size()>0 ){
				out.append(viewlist.get(0));
			}
			%>
			</div><!--end grid-->
        </div><!--end container-->