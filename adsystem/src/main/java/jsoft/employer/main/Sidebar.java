package jsoft.employer.main;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jsoft.objects.UserObject;

import java.util.*;

/**
 * Servlet implementation class Sidebar
 */
@WebServlet("/employer/sidebar")
public class Sidebar extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Sidebar() {
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
		PrintWriter out = response.getWriter();
		UserObject user = (UserObject) request.getSession().getAttribute("employerLogined");

		if (user == null) {
//			response.sendRedirect("/adv/user/login");
		}
		HashMap<String, String> collapsed = new HashMap<>();
		HashMap<String, String> show = new HashMap<>();
		HashMap<String, String> actives = new HashMap<>();

		// find prametter index
		

		out.append("<!-- ======= Sidebar ======= -->");
		out.append("<aside id=\"sidebar\" class=\"sidebar\">");

		out.append("<ul class=\"sidebar-nav\" id=\"sidebar-nav\">");

		out.append("<li class=\"nav-item\">");
		out.append(
				"<a class=\"nav-link " + collapsed.getOrDefault("Dashboard", "collapsed") + "\" href=\"/adv/employer/dashboard\">");
		out.append("<i class=\"bi bi-house\"></i>");
		out.append("<span>Dashboard</span>");
		out.append("</a>");
		out.append("</li><!-- End Dashboard Nav -->");

		out.append("<li class=\"nav-item\">");
		out.append("<a class=\"nav-link collapsed\" data-bs-target=\"#job-nav\" data-bs-toggle=\"collapse\" href=\"#\">");
		out.append("<i class=\"far fa-bookmark\"></i>");
		out.append("<span>Quản lí đăng tuyển</span>");
		out.append("<i class=\"bi bi-chevron-down ms-auto\"></i>");
		out.append("</a>");
		out.append("<ul id=\"job-nav\" class=\"nav-content collapse show\" data-bs-parent=\"#job-nav\">");
		out.append("<li><a href=\"/adv/employer/job\"><i class=\"fas fa-list\"></i><span>Tạo tin tuyển dụng</span></a></li>");
		out.append("<li><a href=\"/adv/employer/job?trash\"><i class=\"fas fa-trash-restore\"></i><span>Thùng rác</span></a></li>");
		out.append("</ul>");
		out.append("</li>");
		out.append("<!-- End Components Nav -->");
		out.append("<li class=\"nav-item\">");
		out.append("<a class=\"nav-link collapsed\" data-bs-target=\"#user-nav\" data-bs-toggle=\"collapse\" href=\"#\">");
		out.append("<i class=\"bi bi-people\"></i>");
		out.append("<span>Quản lí ứng viên</span>");
		out.append("<i class=\"bi bi-chevron-down ms-auto\"></i>");
		out.append("</a>");
		out.append("<ul id=\"user-nav\" class=\"nav-content collapse show \" data-bs-parent=\"#user-nav\">");
		out.append("<li><a href=\"/adv/employer/apply\"><i class=\"fas fa-users-cog\"></i><span>Hồ sơ ứng tuyển</span></a></li>");
		out.append("<li><a href=\"/adv/employer/comingsoon\"><i class=\"fas fa-user-tie\"></i><span>Hồ sơ đã lưu</span></a></li>");
		out.append("<li><a href=\"/adv/employer/comingsoon\"><i class=\"fas fa-users\"></i><span>Tìm kiếm ứng viên");
		out.append("</span></a></li>");
		out.append("</ul></li>");
		out.append("<!-- End Components Nav -->");
		out.append("<!-- End Components Nav -->");
		out.append("<li class=\"nav-item\"><a class=\"nav-link  collapsed\"");
		out.append("data-bs-target=\"#service-nav\" data-bs-toggle=\"collapse\" href=\"#\"><i");
		out.append("class=\"bi bi-bag-check-fill\"></i><span>Quản lí dịch vụ</span><i");
		out.append("class=\"bi bi-chevron-down ms-auto\"></i></a>");
		out.append("<ul id=\"service-nav\" class=\"nav-content collapse show \"");
		out.append("data-bs-parent=\"#service-nav\">");
		out.append("<li><a href=\"/adv/employer/comingsoon\"><i class=\"fas fa-list\"></i><span>Lịch sử mua hàng</span></a></li>");
		out.append("<li><a href=\"/adv/employer/comingsoon\"><i class=\"fas fa-list\"></i><span>Dịch vụ đang kích hoạt</span></a></li>");
		out.append("<li></li>");
		out.append("<li><a href=\"/adv/employer/comingsoon\"><i class=\"fas fa-list\"></i><span>Dịch vụ đã hết hạn</span></a></li>");
		out.append("<li></li>");
		out.append("</ul>");
		out.append("<!-- End Components Nav -->");

		out.append("<li class=\"nav-heading\">Pages</li>");

		out.append("<li class=\"nav-item\">");
		out.append("<a class=\"nav-link collapsed\" href=\"/adv/employer/profiles?id=" + user.getUser_id() + "\">");
		out.append("<i class=\"bi bi-person\"></i>");
		out.append("<span>Profile</span>");
		out.append("</a>");
		out.append("</li><!-- End Profile Page Nav -->");

		out.append("</ul>");

		out.append("</aside><!-- End Sidebar-->");
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
