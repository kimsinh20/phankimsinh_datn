package jsoft.ads.applications;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.stream.Stream;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.javatuples.Pair;
import org.javatuples.Quartet;

import jsoft.ConnectionPool;
import jsoft.ads.job.JOB_EDIT_TYPE;
import jsoft.ads.job.JOB_SOFT;
import jsoft.ads.job.JobControl;
import jsoft.library.ORDER;
import jsoft.objects.ApplicationsObject;
import jsoft.objects.CareerObject;
import jsoft.objects.JobObject;
import jsoft.objects.SkillObject;
import jsoft.objects.UserObject;

/**
 * Servlet implementation class CategoryList
 */
@WebServlet("/app/list")
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
		UserObject user = (UserObject) request.getSession().getAttribute("userLogined");
        
		if (user != null) {
			view(request, response, user,page);
		} else {
			response.sendRedirect("/adv/user/login");
		}

	}

	protected void view(HttpServletRequest request, HttpServletResponse response, UserObject user,int page)
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

		// tim thanh so xac dinh loại danh sách
		String trash =request.getParameter("trash");
		boolean isTrash = (trash!=null)?true:false;
		String title;
		if(!isTrash) {
	        similar.setApplications_delete(false);
	   		title="Danh sách tin tuyển dụng";
		} else {
			title ="Danh sách tin tuyển dụng bị xóa";
			similar.setApplications_delete(true);
		}
		
		byte pageSize = 5;
		
		Quartet<ApplicationsObject, Integer, Byte,UserObject> infos = new Quartet<>(similar,pageSize*(page-1),pageSize,user);
		
		
		ArrayList<String> viewList = jc.viewApp(infos, new Pair<>(APP_SOFT.GENERAL, ORDER.ASC),page,saveKey,isTrash);
		
		// trả về kết nối
		jc.releaseConnection();

		
		String pos = (trash==null)?"/header?pos=aplist":"/header?pos=aptrash";
		
		// tham chiếu tìm header
		RequestDispatcher h = request.getRequestDispatcher(pos);
		if (h != null) {
			h.include(request, response);
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
		out.append("<button type=\"button\" class=\"btn btn-primary my-4 \" data-bs-toggle=\"modal\" data-bs-target=\"#addEditJob\"><i class=\"fa-solid fa-plus me-2\"></i>Thêm mới</button>");
		out.append("<a href=\"/adv/job/list?trash\" class=\"btn btn-danger my-4 \" ><i class=\"fas fa-trash-restore\"></i>Thùng rác</a>");
		out.append("</div><!-- End div -->");
		
		
		out.append("<div class=\"modal fade modal-lg\" id=\"addEditJob\" data-bs-backdrop=\"static\" data-bs-keyboard=\"false\" tabindex=\"-1\" aria-labelledby=\"staticBackdropLabel\" aria-hidden=\"true\">");
		out.append("<div class=\"modal-dialog\">");
		out.append("<div class=\"modal-content\">");
		out.append("<div class=\"modal-header\">");
		out.append("<h1 class=\"modal-title fs-5\" id=\"staticBackdropLabel\">Thêm tin tuyển dụng</h1>");
		out.append("<button type=\"button\" class=\"btn-close\" data-bs-dismiss=\"modal\" aria-label=\"Close\"></button>");
		out.append("</div>");

		out.append("<div class=\"modal-body\">");
		out.append("<div class=\"container\">");
		
		out.append("<form method=\"POST\" id=\"regForm\" id=\"form_add\">");
		
		out.append("</form>");
		
		out.append("</div>"); // end container
		out.append("</div>"); // end model body
		
	
		out.append("</div>");
		out.append("</div>");
		out.append("</div>");
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
		RequestDispatcher f = request.getRequestDispatcher("/footer");
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
		
		short id = jsoft.library.Utilities.getShortParam(request, "idForPost");
		String job_skills = request.getParameter("job_skills");
		String job_title = request.getParameter("job_title");
		String job_expiration_date = request.getParameter("job_expiration_date");
		String job_description = request.getParameter("job_description");
		String job_purpose = request.getParameter("job_purpose");
		String job_welfare = request.getParameter("job_welfare");
		String job_location = request.getParameter("job_location");
		
		byte job_experience =  jsoft.library.Utilities.getByteParam(request, "job_experience");
		byte job_degree  =  jsoft.library.Utilities.getByteParam(request, "job_degree");
		byte job_salary  =  jsoft.library.Utilities.getByteParam(request, "job_salary");
		byte job_gender = jsoft.library.Utilities.getByteParam(request, "job_gender");
		byte job_level  =  jsoft.library.Utilities.getByteParam(request, "job_level");
		byte job_work_time = jsoft.library.Utilities.getByteParam(request, "job_work_time");
		byte job_company = jsoft.library.Utilities.getByteParam(request, "job_company");
		int job_career = jsoft.library.Utilities.getIntParam(request, "job_career");
		byte job_quantity = jsoft.library.Utilities.getByteParam(request, "job_quantity");

		if (checkValidString(job_title) && checkValidString(job_expiration_date) 
				&& checkValidString(job_description) && checkValidString(job_purpose) 
				&& checkValidString(job_welfare)  
			    && job_company>=0 && job_career>=0 && job_quantity>0) {

			UserObject user = (UserObject) request.getSession().getAttribute("userLogined");
            JobObject job = new JobObject();
            if(id>0) {
    		job.setJob_id(id);	
    		}
            job.setJob_experience_id(job_experience);
            job.setJob_degree(job_degree);
            job.setJob_skills(job_skills);
            job.setJob_salary(job_salary);
            job.setJob_location(job_location);
            job.setJob_quantity(job_quantity);
            CareerObject c = new CareerObject();
            c.setCareer_id(job_career);
            job.setJob_career(c);
            job.setJob_level(job_level);
            job.setJob_work_time(job_work_time);
            job.setJob_gender(job_gender);
            job.setJob_company_id(job_company);
            job.setJob_created_date(jsoft.library.Utilities_date.getDate());
            job.setJob_last_modified(jsoft.library.Utilities_date.getDate());
            job.setJob_author_id(user.getUser_id());
            job.setJob_purpose(jsoft.library.Utilities.encode(job_purpose));
            job.setJob_expiration_date(jsoft.library.Utilities_date.getDateFomat(job_expiration_date));
            job.setJob_responsibility(jsoft.library.Utilities.encode(job_description));
            job.setJob_Welfare(jsoft.library.Utilities.encode(job_welfare));
            job.setJob_title(jsoft.library.Utilities.encode(job_title));
			
			ConnectionPool cp = (ConnectionPool) getServletContext().getAttribute("CPool");
			JobControl cc = new JobControl(cp);
			// add new user
			if (cc != null) {
				getServletContext().setAttribute("CPool", cc.getCP());
			}
			
			if(id>0) {
				boolean resultEdit = cc.editJob(job,JOB_EDIT_TYPE.GENERAL);
				// return connect
				cc.releaseConnection();
				if (resultEdit) {
					response.sendRedirect("/adv/job/list");
				} else {
					response.sendRedirect("/adv/job/list?err=edit");
				}
			} else {
				boolean resultAdd = cc.addJob(job);
				// return connect
				cc.releaseConnection();
				if (resultAdd) {
					response.sendRedirect("/adv/job/list");
				} else {
					response.sendRedirect("/adv/job/list?err=add");
				}
			}
		} else {
			String key = request.getParameter("keyword");
			String encodedKeyword = URLEncoder.encode(key, "UTF-8");
			String key_url = (key!=null && !key.equalsIgnoreCase(""))?("&key="+encodedKeyword):"";
			response.sendRedirect("/adv/job/list?page=1"+key_url);
		}
	}

}
