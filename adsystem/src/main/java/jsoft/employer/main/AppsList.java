package jsoft.employer.main;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.javatuples.Pair;
import org.javatuples.Quartet;

import jsoft.ConnectionPool;
import jsoft.ads.applications.APP_SOFT;
import jsoft.ads.applications.AppControl;
import jsoft.ads.job.JOB_EDIT_TYPE;
import jsoft.ads.job.JobControl;
import jsoft.library.ORDER;
import jsoft.objects.ApplicationsObject;
import jsoft.objects.CareerObject;
import jsoft.objects.CompanyObject;
import jsoft.objects.JobObject;
import jsoft.objects.RecruiterObject;
import jsoft.objects.UserObject;

/**
 * Servlet implementation class CategoryList
 */
@WebServlet("/employer/apply")
public class AppsList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	// định nghĩa kiểu nội dung xuất về trình khách
	private static final String CONTENT_TYPE = "text/html; charset=utf-8";
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AppsList() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		// lay page 
		int page = 1;
		if(jsoft.library.Utilities.getIntParam(request, "page")>0) {
			page = jsoft.library.Utilities.getIntParam(request, "page");
		}
		
		
		// tìm thông tin đăng nhập
		RecruiterObject user = (RecruiterObject) request.getSession().getAttribute("employerLogined");
		
		if (user != null) {
			view(request, response, user,page);
		} else {
			response.sendRedirect("/adv/employer/login");
		}

	}

	protected void view(HttpServletRequest request, HttpServletResponse response, RecruiterObject user,int page)
			throws ServletException, IOException {
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
		
		// lay tu khoa tim kiem
				String key = request.getParameter("key");
				String saveKey = (key!=null && !key.equalsIgnoreCase(""))?key.trim():"";
		        saveKey = jsoft.library.Utilities.encode(saveKey);
		// tạo đối tượng thực thi chức năng
		AppControl jc = new AppControl(cp);

		// lấy cấu trúc
		ApplicationsObject similar = new ApplicationsObject();
		similar.setApplications_delete(false);
		similar.setApplications_letter(saveKey);
		JobObject j = new JobObject();
		j.setJob_company_id(user.getCompany_id());
		similar.setJob(j);

		// tim thanh so xac dinh loại danh sách
		String trash =request.getParameter("trash");
		boolean isTrash = (trash!=null)?true:false;
		String title;
		if(!isTrash) {
	        similar.setApplications_delete(false);
	   		title="Danh sách ứng tuyển";
		} else {
			title ="Danh sách ứng tuyển";
			similar.setApplications_delete(true);
		}
		
		byte pageSize = 5;
		
		Quartet<ApplicationsObject, Integer, Byte,UserObject> infos = new Quartet<>(similar,pageSize*(page-1),pageSize,user);
		
		
		ArrayList<String> viewList = jc.viewApp2(infos, new Pair<>(APP_SOFT.GENERAL, ORDER.ASC),page,saveKey,isTrash);
		
		// trả về kết nối
		jc.releaseConnection();

		
		String pos = (trash==null)?"/employer/header?pos=aplist":"/employer/header?pos=aptrash";
		
		// tham chiếu tìm header
		RequestDispatcher h = request.getRequestDispatcher(pos);
		if (h != null) {
			h.include(request, response);
		}
		RequestDispatcher s = request.getRequestDispatcher("/employer/sidebar");
		if (s != null && user !=null) {
			s.include(request, response);
		}
		out.append("<main id=\"main\" class=\"main\">");

		RequestDispatcher error = request.getRequestDispatcher("/error");
		if (error != null) {
			error.include(request, response);
		}

		out.append("<div class=\"pagetitle d-flex\">");
		out.append("<h1>"+title+"</h1>");
		out.append("<nav class=\"ms-auto\">");
		out.append("<ol class=\"breadcrumb\">");
		out.append("<li class=\"breadcrumb-item\"><a href=\"/adv/view\"><i class=\"bi bi-house\"></i></a></li>");
		out.append("<li class=\"breadcrumb-item\">Tin tuyển dụng</li>");
		out.append("<li class=\"breadcrumb-item active\">"+(isTrash?"Thùng rác":"Danh sách")+"</li>");
		out.append("</ol>");
		out.append("</nav>");
		out.append("</div><!-- End Page Title -->");

		
		// list user
		out.append("<section class=\"section\">");
		out.append("<div class=\"row\">");
		out.append("<div class=\"col-lg-12\">");
		out.append("<div class=\"card\">");
		out.append("<div class=\"card-body\">");
        
		if(trash==null) {
		// add user modal
			
		out.append("<div class=\"d-flex justify-content-between\">");
		out.append("<a href=\"/adv/job/list?trash\" class=\"btn btn-danger my-4 \" ><i class=\"fas fa-trash-restore\"></i>Thùng rác</a>");
		out.append("</div><!-- End div -->");
		
		
		
		}
		// list section
		out.append(viewList.get(0));
		// phan trang
//		out.append(viewList.get(1));
		
		out.append("</div>"); // end card-body
		out.append("</div>"); // end card

		out.append("</div>"); // col-lg-12
		out.append("</div>"); // row
		out.append("</section>");

		// charts
		out.append("<div class=\"row\">");
		out.append("<div class=\"col-lg-12\">");
//		out.append(viewList.get(3));
		out.append("</div>");
		out.append("</div>");
		out.append("</main><!-- End #main -->");

		
		// tham chiếu tìm sidebar
		RequestDispatcher f = request.getRequestDispatcher("/employer/footer");
		if (f != null) {
			f.include(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	public static boolean checkValidString(String str) {
		boolean flag = true;
		if(str==null || str.equalsIgnoreCase("")) {
			flag = false;
		}
		return flag;
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		
		System.out.println("absdsad");
		doGet(request, response);
	}

}
