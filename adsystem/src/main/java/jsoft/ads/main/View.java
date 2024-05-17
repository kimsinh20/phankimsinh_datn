package jsoft.ads.main;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.javatuples.Quartet;
import org.javatuples.Sextet;

import jsoft.ConnectionPool;
import jsoft.ads.user.UserControl;
import jsoft.library.Utilities;
import jsoft.objects.ArticleObject;
import jsoft.objects.JobObject;
import jsoft.objects.UserObject;

/**
 * Servlet implementation class View
 */
@WebServlet("/view")
public class View extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// định nghĩa kiểu nội dung xuất về trình khách
	private static final String CONTENT_TYPE = "text/html; charset=utf-8";

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public View() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		// tìm thông tin đăng nhập
		UserObject user = (UserObject) request.getSession().getAttribute("userLogined");

		if (user != null) {
			view(request, response, user);
		} else {
			response.sendRedirect("/adv/user/login");
		}

	}

	protected void view(HttpServletRequest request, HttpServletResponse response, UserObject user) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// xác định kiểu nội dung xuất về trình khách
		response.setContentType(CONTENT_TYPE);

		// tạo đối tượng thực hiện xuất nội dung
		PrintWriter out = response.getWriter();
		
		
		// tìm bộ quản lý kết nối
		ConnectionPool cp = (ConnectionPool) getServletContext().getAttribute("CPool");

		if (cp == null) {
			getServletContext().setAttribute("CPool", cp);
		}
		UserControl uc = new UserControl(cp);
		 Sextet<Integer, Integer, Integer, ArrayList<JobObject>,ArrayList<ArticleObject>,HashMap<Integer, Integer>> data =  uc.getDashboard();
		 int total_employer = data.getValue0();
		 int total_job = data.getValue1();
		 int total_apply = data.getValue2();
		 ArrayList<JobObject> list_job = data.getValue3();
		 ArrayList<ArticleObject> list_ar = data.getValue4();
		 HashMap<Integer, Integer> data_chart = data.getValue5();
	
		 StringBuilder values = new StringBuilder();
			StringBuilder accounts = new StringBuilder();
			 for (int i : data_chart.keySet()) {
				    switch (i) {
					case 0:
						 accounts.append("'Đang chờ phê duyệt'");
						break;
					case 1:
						 accounts.append("'Đang tuyển dụng'");
						break;
					case 2:
						 accounts.append("'Đã hết hạn'");
						break;
					case 3:
						 accounts.append("'Đã tuyển dụng'");
						break;
					case 4:
						 accounts.append("'Tạm ngưng tuyển dụng'");
						break;
					case 5:
						 accounts.append("'Đã hủy'");
						break;
					default:
						 accounts.append("'Trạng thái không hợp lệ'");
					}
				    values.append("'" + (data_chart.get(i))).append("'");
					if (i < data_chart.size()) {
						values.append(",");
						accounts.append(",");
					}
			    }
			 System.out.println(accounts);
			 System.out.println(values);
		uc.releaseConnection();
		
		// tham chiếu tìm header
		RequestDispatcher h = request.getRequestDispatcher("/header");
		if(h != null) {
			h.include(request, response);
		}
		// if login thanh cong thi show toast
		String success = request.getParameter("success");
		if (success != null) {
			out.append("<div class=\"toast-container position-fixed top-1 end-0 ps-3 pe-5 mb-3\">");
			out.append(
					"<div id=\"liveToast\" class=\"toast\" role=\"alert\" aria-live=\"assertive\" aria-atomic=\"true\">");
			out.append("<div class=\"toast-header\">");
			// out.append("<img src=\"...\" class=\"rounded me-2\" alt=\"...\">");
			out.append("<strong class=\"me-auto text-success\">Thông báo</strong>");
			out.append("<small>10 giây</small>");
			out.append(
					"<button type=\"button\" class=\"btn-close\" data-bs-dismiss=\"toast\" aria-label=\"Close\"></button>");
			out.append("</div>");
			out.append("<div class=\"toast-body\">");
			out.append("Đăng nhập thành công");
			out.append("</div>");
			out.append("</div>");
			out.append("</div>");

			// script
			out.append("<script language=\"javascript\" >");
			out.append("const viewToast = document.getElementById('liveToast');");
			out.append("const toast = new bootstrap.Toast(viewToast);");
			out.append("toast.show();");
			out.append("</script>");
		}
		
		out.append("<main id=\"main\" class=\"main\">");

		out.append("<div class=\"pagetitle\">");
		out.append("<h1>Dashboard</h1>");
		out.append("<nav>");
		out.append("<ol class=\"breadcrumb\">");
		out.append("<li class=\"breadcrumb-item\"><a href=\"/adv/view\">Trang chủ</a></li>");
		out.append("<li class=\"breadcrumb-item active\">Dashboard</li>");
		out.append("</ol>");
		out.append("</nav>");
		out.append("</div><!-- End Page Title -->");

		out.append("<section class=\"section dashboard\">");
		out.append("<div class=\"row\">");

		out.append("<!-- Left side columns -->");
		out.append("<div class=\"col-lg-8\">");
		out.append("<div class=\"row\">");

		out.append("<!-- Sales Card -->");
		out.append("<div class=\"col-xxl-4 col-md-6\">");
		out.append("<div class=\"card info-card sales-card\">");

	

		out.append("<div class=\"card-body\">");
		out.append("<h5 class=\"card-title\">Nhà tuyển dụng</h5>");

		out.append("<div class=\"d-flex align-items-center\">");
		out.append("<div class=\"card-icon rounded-circle d-flex align-items-center justify-content-center\">");
		out.append("<i class=\"fas fa-user-tie\"></i>");
		out.append("</div>");
		out.append("<div class=\"ps-3\">");
		out.append("<h6>"+total_employer+"</h6>");

		out.append("</div>");
		out.append("</div>");
		out.append("</div>");

		out.append("</div>");
		out.append("</div><!-- End Sales Card -->");

		out.append("<!-- Revenue Card -->");
		out.append("<div class=\"col-xxl-4 col-md-6\">");
		out.append("<div class=\"card info-card revenue-card\">");

		out.append("<div class=\"filter\">");
		out.append("<a class=\"icon\" href=\"#\" data-bs-toggle=\"dropdown\"><i class=\"bi bi-three-dots\"></i></a>");
		out.append("<ul class=\"dropdown-menu dropdown-menu-end dropdown-menu-arrow\">");
		out.append("<li class=\"dropdown-header text-start\">");
		out.append("<h6>Filter</h6>");
		out.append("</li>");

		out.append("<li><a class=\"dropdown-item\" href=\"#\">Today</a></li>");
		out.append("<li><a class=\"dropdown-item\" href=\"#\">This Month</a></li>");
		out.append("<li><a class=\"dropdown-item\" href=\"#\">This Year</a></li>");
		out.append("</ul>");
		out.append("</div>");

		out.append("<div class=\"card-body\">");
		out.append("<h5 class=\"card-title \">Tin tuyển dụng</span></h5>");

		out.append("<div class=\"d-flex align-items-center\">");
		out.append("<div class=\"card-icon rounded-circle d-flex align-items-center justify-content-center\">");
		out.append("<i class=\"far fa-bookmark\"></i>");
		out.append("</div>");
		out.append("<div class=\"ps-3\">");
		out.append("<h6>"+total_job+"</h6>");

		out.append("</div>");
		out.append("</div>");
		out.append("</div>");

		out.append("</div>");
		out.append("</div><!-- End Revenue Card -->");

		out.append("<!-- Customers Card -->");
		out.append("<div class=\"col-xxl-4 col-xl-12\">");

		out.append("<div class=\"card info-card customers-card\">");

		out.append("<div class=\"filter\">");
		out.append("<a class=\"icon\" href=\"#\" data-bs-toggle=\"dropdown\"><i class=\"bi bi-three-dots\"></i></a>");
		out.append("<ul class=\"dropdown-menu dropdown-menu-end dropdown-menu-arrow\">");
		out.append("<li class=\"dropdown-header text-start\">");
		out.append("<h6>Filter</h6>");
		out.append("</li>");

		out.append("<li><a class=\"dropdown-item\" href=\"#\">Today</a></li>");
		out.append("<li><a class=\"dropdown-item\" href=\"#\">This Month</a></li>");
		out.append("<li><a class=\"dropdown-item\" href=\"#\">This Year</a></li>");
		out.append("</ul>");
		out.append("</div>");

		out.append("<div class=\"card-body\">");
		out.append("<h5 class=\"card-title \">Ứng tuyển</span></h5>");

		out.append("<div class=\"d-flex align-items-center\">");
		out.append("<div class=\"card-icon rounded-circle d-flex align-items-center justify-content-center\">");
		out.append("<i class=\"bi bi-people\"></i>");
		out.append("</div>");
		out.append("<div class=\"ps-3\">");
		out.append("<h6>"+total_apply+"</h6>");

		out.append("</div>");
		out.append("</div>");

		out.append("</div>");
		out.append("</div>");

		out.append("</div><!-- End Customers Card -->");

		out.append("<!-- Reports -->");
		out.append("<div class=\"col-12\">");
		out.append("<div class=\"card\">");

		out.append("<div class=\"filter\">");
		out.append("<a class=\"icon\" href=\"#\" data-bs-toggle=\"dropdown\"><i class=\"bi bi-three-dots\"></i></a>");
		out.append("<ul class=\"dropdown-menu dropdown-menu-end dropdown-menu-arrow\">");
		out.append("<li class=\"dropdown-header text-start\">");
		out.append("<h6>Filter</h6>");
		out.append("</li>");

		out.append("<li><a class=\"dropdown-item\" href=\"#\">Today</a></li>");
		out.append("<li><a class=\"dropdown-item\" href=\"#\">This Month</a></li>");
		out.append("<li><a class=\"dropdown-item\" href=\"#\">This Year</a></li>");
		out.append("</ul>");
		out.append("</div>");

		out.append("<div class=\"card\">");
		out.append("<div class=\"card-body\">");
		out.append("<h5 class=\"card-title\">Biểu đồ trạng thái các tin tuyển dụng</h5>");
	
		out.append("<!-- Bar Chart -->");
		out.append("<div id=\"barChart\"></div>");
		
		out.append("<script>");
		out.append("document.addEventListener(\"DOMContentLoaded\", () => {");
		out.append("new ApexCharts(document.querySelector(\"#barChart\"), {");
		out.append("series: [{");
		out.append("data: [" + values.toString() + "]");
		out.append("}],");
		out.append("chart: {");
		out.append("type: 'bar',");
		if(data_chart.size()<=15) {
			out.append("height: 350,");
		} else if(data_chart.size()<=30) {
			out.append("height: 600,");
		} else {
			out.append("height: 750,");
		}
		
		out.append("},");
		out.append("plotOptions: {");
		out.append("bar: {");
		out.append("borderRadius: 4,");
		out.append("horizontal: true,");
		out.append("}");
		out.append("},");
		out.append("dataLabels: {");
		out.append("enabled: false");
		out.append("},");
		out.append("xaxis: {");
		out.append("categories: [" + accounts.toString() + "],");
		out.append("}, ");
		out.append("yaxis: {");
		out.append("show: true,");
		out.append("labels: {");
		out.append("show: true,");
		out.append("align: 'right',");
		out.append("minWidth: 0,");
		out.append("maxWidth: 300,");
		out.append(
				"style: {color:[], fontSize: '15px', fontFamily: 'Arial, san-serif', fontWeight: 400, cssClass:'apexcharts-yaxis-label'},");
		out.append("},");
		out.append("}");
		out.append("}).render();");
		out.append("});");
		out.append("</script>");
		out.append("<!-- End Bar Chart -->");
	
		out.append("</div>");
		out.append("</div>");

		out.append("</div>");
		out.append("</div><!-- End Reports -->");

		

		out.append("</div>");
		out.append("</div><!-- End Left side columns -->");

		out.append("<!-- Right side columns -->");
		out.append("<div class=\"col-lg-4\">");

		out.append("<!-- Recent Activity -->");
		out.append("<div class=\"card\">");
		out.append("<div class=\"filter\">");
		out.append("<a class=\"icon\" href=\"#\" data-bs-toggle=\"dropdown\"><i class=\"bi bi-three-dots\"></i></a>");
		out.append("<ul class=\"dropdown-menu dropdown-menu-end dropdown-menu-arrow\">");
		out.append("<li class=\"dropdown-header text-start\">");
		out.append("<h6>Filter</h6>");
		out.append("</li>");

		out.append("<li><a class=\"dropdown-item\" href=\"#\">Today</a></li>");
		out.append("<li><a class=\"dropdown-item\" href=\"#\">This Month</a></li>");
		out.append("<li><a class=\"dropdown-item\" href=\"#\">This Year</a></li>");
		out.append("</ul>");
		out.append("</div>");

		out.append("<div class=\"card-body\">");
		out.append("<h5 class=\"card-title\">Lịch sử đăng tin tuyển dụng</h5>");

		out.append("<div class=\"activity\">");
		int index = 0; // Biến đếm index

		for (JobObject j : list_job) {
			 long dateCount = Math.abs(jsoft.library.Utilities_date.getminusDay(j.getJob_created_date()));
		     String time = "";
		     if(dateCount==0) {
		    	 time ="today";
		     } else {
		    	 time=dateCount+" days";
		     }
			 out.append("<div class=\"activity-item d-flex\">");
		    out.append("<div class=\"activite-label\">" + time + "</div>");
       
            // Sử dụng switch-case với giá trị của biến index
		    switch (index) {
		        case 0:
		            out.append("<i class='bi bi-circle-fill activity-badge text-primary align-self-start'></i>");
		            break;
		        case 1:
		            out.append("<i class='bi bi-circle-fill activity-badge text-warning align-self-start'></i>");
		            break;
		        case 2:
		            out.append("<i class='bi bi-circle-fill activity-badge text-success align-self-start'></i>");
		            break;
		        case 3:
		            out.append("<i class='bi bi-circle-fill activity-badge text-danger align-self-start'></i>");
		            break;
		        case 4:
		            out.append("<i class='bi bi-circle-fill activity-badge text-info align-self-start'></i>");
		            break;
		        case 5:
		            out.append("<i class='bi bi-circle-fill activity-badge text-muted align-self-start'></i>");
		            break;
		        default:
		            out.append("<i class='bi bi-circle-fill activity-badge align-self-start'></i>");
		            break;
		    }

		    out.append("<div class=\"activity-content\">");
		    out.append("<a href=\"/adv/job/view?id=" + j.getJob_id() + "\" class=\"fw-bold text-dark\">" + j.getJob_title() + "</a>");
		    out.append("</div>");
		    out.append("</div><!-- End activity item-->");

		    index++; // Tăng giá trị của biến index sau mỗi vòng lặp
		}
		

//		out.append("<div class=\"activity-item d-flex\">");
//		out.append("<div class=\"activite-label\">56 min</div>");
//		out.append("<i class='bi bi-circle-fill activity-badge text-danger align-self-start'></i>");
//		out.append("<div class=\"activity-content\">");
//		out.append("Voluptatem blanditiis blanditiis eveniet");
//		out.append("</div>");
//		out.append("</div><!-- End activity item-->");
//
//		out.append("<div class=\"activity-item d-flex\">");
//		out.append("<div class=\"activite-label\">2 hrs</div>");
//		out.append("<i class='bi bi-circle-fill activity-badge text-primary align-self-start'></i>");
//		out.append("<div class=\"activity-content\">");
//		out.append("Voluptates corrupti molestias voluptatem");
//		out.append("</div>");
//		out.append("</div><!-- End activity item-->");
//
//		out.append("<div class=\"activity-item d-flex\">");
//		out.append("<div class=\"activite-label\">1 day</div>");
//		out.append("<i class='bi bi-circle-fill activity-badge text-info align-self-start'></i>");
//		out.append("<div class=\"activity-content\">");
//		out.append("Tempore autem saepe <a href=\"#\" class=\"fw-bold text-dark\">occaecati voluptatem</a> tempore");
//		out.append("</div>");
//		out.append("</div><!-- End activity item-->");
//
//		out.append("<div class=\"activity-item d-flex\">");
//		out.append("<div class=\"activite-label\">2 days</div>");
//		out.append("<i class='bi bi-circle-fill activity-badge text-warning align-self-start'></i>");
//		out.append("<div class=\"activity-content\">");
//		out.append("Est sit eum reiciendis exercitationem");
//		out.append("</div>");
//		out.append("</div><!-- End activity item-->");
//
//		out.append("<div class=\"activity-item d-flex\">");
//		out.append("<div class=\"activite-label\">4 weeks</div>");
//		out.append("<i class='bi bi-circle-fill activity-badge text-muted align-self-start'></i>");
//		out.append("<div class=\"activity-content\">");
//		out.append("Dicta dolorem harum nulla eius. Ut quidem quidem sit quas");
//		out.append("</div>");
//		out.append("</div><!-- End activity item-->");

		out.append("</div>");

		out.append("</div>");
		out.append("</div><!-- End Recent Activity -->");



		out.append("<!-- News & Updates Traffic -->");
		out.append("<div class=\"card\">");
		out.append("<div class=\"filter\">");
		out.append("<a class=\"icon\" href=\"#\" data-bs-toggle=\"dropdown\"><i class=\"bi bi-three-dots\"></i></a>");
		out.append("<ul class=\"dropdown-menu dropdown-menu-end dropdown-menu-arrow\">");
		out.append("<li class=\"dropdown-header text-start\">");
		out.append("<h6>Filter</h6>");
		out.append("</li>");

		out.append("<li><a class=\"dropdown-item\" href=\"#\">Today</a></li>");
		out.append("<li><a class=\"dropdown-item\" href=\"#\">This Month</a></li>");
		out.append("<li><a class=\"dropdown-item\" href=\"#\">This Year</a></li>");
		out.append("</ul>");
		out.append("</div>");

		out.append("<div class=\"card-body pb-0\">");
		out.append("<h5 class=\"card-title\">News &amp; Updates <span>| Today</span></h5>");

		out.append("<div class=\"news\">");
		
		// thêm các bài viết 
		list_ar.forEach(e-> {
			out.append("<div class=\"post-item clearfix\">");
			out.append(" <img src=\""+e.getArticle_image()+"\" alt=\"\">");
			out.append("<h4><a href=\"#\">"+e.getArticle_title()+"</a></h4>");
			out.append("<p>"+jsoft.library.Utilities_text.shortenText(e.getArticle_summary(), 12)+"</p>");
			out.append("</div>");
		});
		out.append("</div><!-- End sidebar recent posts-->");

		out.append("</div>");
		out.append("</div><!-- End News & Updates -->");

		out.append("</div><!-- End Right side columns -->");

		out.append("</div>");
		out.append("</section>");

		out.append("</main><!-- End #main -->");
		
		// tham chiếu tìm sidebar
		RequestDispatcher f = request.getRequestDispatcher("/footer");
		if(f != null) {
			f.include(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
