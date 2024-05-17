package jsoft.ads.main;

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
@WebServlet("/sidebar")
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
		UserObject user = (UserObject) request.getSession().getAttribute("userLogined");

		if (user == null) {
			response.sendRedirect("/adv/user/login");
		}
		HashMap<String, String> collapsed = new HashMap<>();
		HashMap<String, String> show = new HashMap<>();
		HashMap<String, String> actives = new HashMap<>();

		// find prametter index
		String pos = request.getParameter("pos");
		if (pos != null) {
			String menu = pos.substring(0, 2);
			String act = pos.substring(2);
			switch (menu) {
			case "ur": {
				collapsed.put("user", "");
				show.put("user", "show");
				switch (act) {
				case "list":
					actives.put("list", "class=\"active\" ");
					break;
				case "client":
					actives.put("client", "class=\"active\" ");
					break;
				case "recruiter":
					actives.put("recruiter", "class=\"active\" ");
					break;
				case "upd":
				case "trash":
					actives.put("utrash", "class=\"active\" ");
					break;
				case "log":
				}

				break;
			}
			case "sc": {
				collapsed.put("article", "");
				show.put("article", "show");
				switch (act) {
				case "list":
					actives.put("listsc", "class=\"active\" ");
					break;
				case "upd":
				case "trash":
					actives.put("listsc", "class=\"active\" ");
					break;
				case "log":
				}

				break;
			}
			case "cc": {
				collapsed.put("article", "");
				show.put("article", "show");
				switch (act) {
				case "list":
					actives.put("listcc", "class=\"active\" ");
					break;
				case "upd":
				case "trash":
					actives.put("listcc", "class=\"active\" ");
					break;
				case "log":
				}

				break;
			}
			case "ar": {
				collapsed.put("article", "");
				show.put("article", "show");
				switch (act) {
				case "list":
					actives.put("listar", "class=\"active\" ");
					break;
				case "upd":
					actives.put("arupd", "class=\"active\" ");
					break;
				case "trash":
					actives.put("artrash", "class=\"active\" ");
					break;
				}

				break;
			}
			case "cp": {
				collapsed.put("company", "");
				show.put("company", "show");
				switch (act) {
				case "list":
					actives.put("listcp", "class=\"active\" ");
					break;
				case "trash":
					actives.put("cptrash", "class=\"active\" ");
					break;
				}

				break;
			}
			case "jb": {
				collapsed.put("job", "");
				show.put("job", "show");
				switch (act) {
				case "list":
					actives.put("listjb", "class=\"active\" ");
					break;
				case "trash":
					actives.put("jbtrash", "class=\"active\" ");
					break;
				}

				break;
			}
			case "fl": {
				collapsed.put("field_career", "");
				show.put("field_career", "show");
				switch (act) {
				case "list":
					actives.put("listfl", "class=\"active\" ");
					break;
				case "trash":
					actives.put("fltrash", "class=\"active\" ");
					break;
				}

				break;
			}
			case "cr": {
				collapsed.put("field_career", "");
				show.put("field_career", "show");
				switch (act) {
				case "list":
					actives.put("listcr", "class=\"active\" ");
					break;
				case "trash":
					actives.put("crtrash", "class=\"active\" ");
					break;
				}

				break;
			}
			case "ap": {
				collapsed.put("applications", "");
				show.put("applications", "show");
				switch (act) {
				case "list":
					actives.put("listap", "class=\"active\" ");
					break;
				case "trash":
					actives.put("aptrash", "class=\"active\" ");
					break;
				}

				break;
			}
			case "sv": {
				collapsed.put("service", "");
				show.put("service", "show");
				switch (act) {
				case "list":
					actives.put("listsv", "class=\"active\" ");
					break;
				case "trash":
					actives.put("svtrash", "class=\"active\" ");
					break;
				}

				break;
			}

			default:
				throw new IllegalArgumentException("Unexpected value: " + menu);
			}
		}

		out.append("<!-- ======= Sidebar ======= -->");
		out.append("<aside id=\"sidebar\" class=\"sidebar\">");

		out.append("<ul class=\"sidebar-nav\" id=\"sidebar-nav\">");

		out.append("<li class=\"nav-item\">");
		out.append(
				"<a class=\"nav-link " + collapsed.getOrDefault("Dashboard", "collapsed") + "\" href=\"/adv/view\">");
		out.append("<i class=\"bi bi-house\"></i>");
		out.append("<span>Dashboard</span>");
		out.append("</a>");
		out.append("</li><!-- End Dashboard Nav -->");

		out.append("<li class=\"nav-item\">");
		out.append("<a class=\"nav-link " + collapsed.getOrDefault("user", "collapsed")
				+ "\" data-bs-target=\"#user-nav\" data-bs-toggle=\"collapse\" href=\"#\">");
		out.append(
				"<i class=\"bi bi-people\"></i><span>Người sử dụng</span><i class=\"bi bi-chevron-down ms-auto\"></i>");
		out.append("</a>");
		out.append("<ul id=\"user-nav\" class=\"nav-content collapse " + show.getOrDefault("user", "")
				+ " \" data-bs-parent=\"#user-nav\">");
		out.append("<li>");
		out.append("<a href=\"/adv/user/list\" " + actives.getOrDefault("list", "") + " >");
		out.append("<i class=\"fas fa-users-cog\"></i><span>Quản trị</span>");
		out.append("</a>");
		out.append("</li>");
		out.append("<li>");
		out.append("<a href=\"/adv/recruiter/list\" " + actives.getOrDefault("recruiter", "") + " >");
		out.append("<i class=\"fas fa-user-tie\"></i><span>Nhà tuyển dụng</span>");
		out.append("</a>");
		out.append("</li>");
		out.append("<li>");
		out.append("<a href=\"/adv/client/list\" " + actives.getOrDefault("client", "") + " >");
		out.append("<i class=\"fas fa-users\"></i><span>Ứng viên</span>");
		out.append("</a>");
		out.append("</li>");
		out.append("<li>");
		out.append("<a href=\"/adv/user/list?trash\" " + actives.getOrDefault("utrash", "") + ">");
		out.append("<i class=\"fas fa-trash-restore\"></i><span>Thùng rác</span>");
		out.append("</a>");
		out.append("</li>");
		out.append("</ul>");
		out.append("</li><!-- End Components Nav -->");

		// bai viet
		out.append("<li class=\"nav-item\">");
		out.append("<a class=\"nav-link " + collapsed.getOrDefault("article", "collapsed")
				+ "\" data-bs-target=\"#article-nav\" data-bs-toggle=\"collapse\" href=\"#\">");
		out.append(
				"<i class=\"fas fa-newspaper\"></i><span>Bài viết & Tin tức</span><i class=\"bi bi-chevron-down ms-auto\"></i>");
		out.append("</a>");
		out.append("<ul id=\"article-nav\" class=\"nav-content collapse " + show.getOrDefault("article", "")
				+ " \" data-bs-parent=\"#article-nav\">");
		out.append("<li>");
		out.append("<a href=\"/adv/ar/list\"" + actives.getOrDefault("listar", "") + ">");
		out.append("<i class=\"fas fa-list\"></i><span>Danh sách</span>");
		out.append("</a>");
		out.append("</li>");
		out.append("<li>");
		out.append("<a href=\"/adv/ar/upd\" " + actives.getOrDefault("arupd", "") + ">");
		out.append("<i class=\"fas fa-plus-square\"></i><span>Thêm mới</span>");
		out.append("</a>");
		out.append("</li>");
		out.append("<li>");
		out.append("<a href=\"/adv/section/list\" " + actives.getOrDefault("listsc", "") + " >");
		out.append("<i class=\"fas fa-book-open\"></i><span>Chuyên mục</span>");
		out.append("</a>");
		out.append("</li>");
		out.append("<li>");
		out.append("<a href=\"/adv/category/list\" " + actives.getOrDefault("listcc", "") + " >");
		out.append("<i class=\"fas fa-list-ol\"></i><span>Thể loại</span>");
		out.append("</a>");
		out.append("</li>");
		out.append("<li>");
		out.append("<a href=\"/adv/ar/list?trash\" " + actives.getOrDefault("artrash", "") + ">");
		out.append("<i class=\"fas fa-trash-restore\"></i><span>Thùng rác</span>");
		out.append("</a>");
		out.append("</li>");
		out.append("</ul>");
		out.append("</li><!-- End Components Nav -->");

		// công ty
		out.append("<li class=\"nav-item\">");
		out.append("<a class=\"nav-link " + collapsed.getOrDefault("company", "collapsed")
				+ "\" data-bs-target=\"#company-nav\" data-bs-toggle=\"collapse\" href=\"#\">");
		out.append("<i class=\"fas fa-building\"></i><span>Công ty</span><i class=\"bi bi-chevron-down ms-auto\"></i>");
		out.append("</a>");
		out.append("<ul id=\"company-nav\" class=\"nav-content collapse " + show.getOrDefault("company", "")
				+ " \" data-bs-parent=\"#company-nav\">");
		out.append("<li>");
		out.append("<a href=\"/adv/company/list\"" + actives.getOrDefault("listcp", "") + ">");
		out.append("<i class=\"fas fa-list\"></i><span>Danh sách</span>");
		out.append("</a>");
		out.append("</li>");
		out.append("<li>");
		out.append("<a href=\"/adv/company/list?trash\" " + actives.getOrDefault("cptrash", "") + ">");
		out.append("<i class=\"fas fa-trash-restore\"></i><span>Thùng rác</span>");
		out.append("</a>");
		out.append("</li>");
		out.append("</ul>");
		out.append("</li><!-- End Components Nav -->");

		// tin tuyển dụng
		out.append("<li class=\"nav-item\">");
		out.append("<a class=\"nav-link " + collapsed.getOrDefault("job", "collapsed")
				+ "\" data-bs-target=\"#job-nav\" data-bs-toggle=\"collapse\" href=\"#\">");
		out.append(
				"<i class=\"far fa-bookmark\"></i><span>Tin tuyển dụng</span><i class=\"bi bi-chevron-down ms-auto\"></i>");
		out.append("</a>");
		out.append("<ul id=\"job-nav\" class=\"nav-content collapse " + show.getOrDefault("job", "")
				+ " \" data-bs-parent=\"#job-nav\">");
		out.append("<li>");
		out.append("<a href=\"/adv/job/list\"" + actives.getOrDefault("listjb", "") + ">");
		out.append("<i class=\"fas fa-list\"></i><span>Danh sách</span>");
		out.append("</a>");
		out.append("</li>");
		out.append("<li>");
		out.append("<a href=\"/adv/job/list?trash\" " + actives.getOrDefault("jbtrash", "") + ">");
		out.append("<i class=\"fas fa-trash-restore\"></i><span>Thùng rác</span>");
		out.append("</a>");
		out.append("</li>");
		out.append("</ul>");
		out.append("</li><!-- End Components Nav -->");

		// lĩnh vực
		out.append("<li class=\"nav-item\">");
		out.append("<a class=\"nav-link " + collapsed.getOrDefault("field_career", "collapsed")
				+ "\" data-bs-target=\"#field_career-nav\" data-bs-toggle=\"collapse\" href=\"#\">");
		out.append(
				"<i class=\"bi bi-envelope\"></i><span>Lĩnh vực ngành nghề</span><i class=\"bi bi-chevron-down ms-auto\"></i>");
		out.append("</a>");
		out.append("<ul id=\"field_career-nav\" class=\"nav-content collapse " + show.getOrDefault("field_career", "")
				+ " \" data-bs-parent=\"#field_career-nav\">");
		out.append("<li>");
		out.append("<a href=\"/adv/field/list\"" + actives.getOrDefault("listfl", "") + ">");
		out.append("<i class=\"fas fa-list\"></i><span>Lĩnh vực</span>");
		out.append("</a>");
		out.append("</li>");
		out.append("<li>");
		out.append("<a href=\"/adv/career/list\" " + actives.getOrDefault("listcr", "") + ">");
		out.append("<i class=\"bi bi-textarea\"></i><span>Ngành nghề</span>");
		out.append("</a>");
		out.append("</li>");
		out.append("</ul>");
		out.append("</li><!-- End Components Nav -->");

		// ưng tuyen
		out.append("<li class=\"nav-item\">");
		out.append("<a class=\"nav-link " + collapsed.getOrDefault("applications", "collapsed")
				+ "\" data-bs-target=\"#app-nav\" data-bs-toggle=\"collapse\" href=\"#\">");
		out.append(
				"<i class=\"bi bi-bag-check-fill\"></i><span>Ứng tuyển</span><i class=\"bi bi-chevron-down ms-auto\"></i>");
		out.append("</a>");
		out.append("<ul id=\"app-nav\" class=\"nav-content collapse " + show.getOrDefault("applications", "")
				+ " \" data-bs-parent=\"#app-nav\">");
		out.append("<li>");
		out.append("<a href=\"/adv/app/list\"" + actives.getOrDefault("listap", "") + ">");
		out.append("<i class=\"fas fa-list\"></i><span>Danh sách</span>");
		out.append("</a>");
		out.append("</li>");
		out.append("<li>");
		out.append("<li>");
		out.append("<a href=\"/adv/app/list?trash\" " + actives.getOrDefault("aptrash", "") + ">");
		out.append("<i class=\"fas fa-trash-restore\"></i><span>Thùng rác</span>");
		out.append("</a>");
		out.append("</li>");
		out.append("</ul>");
		out.append("</li><!-- End Components Nav -->");

		// dich vu
		out.append("<li class=\"nav-item\">");
		out.append("<a class=\"nav-link  " + collapsed.getOrDefault("service", "collapsed")
				+ "\" data-bs-target=\"#service-nav\" data-bs-toggle=\"collapse\" href=\"#\">");
		out.append(
				"<i class=\"bi bi-bag-check-fill\"></i><span>Dịch vụ</span><i class=\"bi bi-chevron-down ms-auto\"></i>");
		out.append("</a>");
		out.append("<ul id=\"service-nav\" class=\"nav-content collapse " + show.getOrDefault("collapsed", "")
				+ " \" data-bs-parent=\"#service-nav\">");
		out.append("<li>");
		out.append("<a href=\"/adv/service/list\"" + actives.getOrDefault("listsv", "") + ">");
		out.append("<i class=\"fas fa-list\"></i><span>Danh sách</span>");
		out.append("</a>");
		out.append("</li>");
		out.append("<li>");
		out.append("<li>");
		out.append("<a href=\"/adv/service/list?trash\" " + actives.getOrDefault("svtrash", "") + ">");
		out.append("<i class=\"fas fa-trash-restore\"></i><span>Thùng rác</span>");
		out.append("</a>");
		out.append("</li>");
		out.append("</ul>");
		out.append("</li><!-- End Components Nav -->");

		out.append("<li class=\"nav-heading\">Pages</li>");

		out.append("<li class=\"nav-item\">");
//		out.append("<a class=\"nav-link collapsed\" href=\"/adv/user/profiles?id=" + user.getUser_id() + "\">");
		out.append("<i class=\"bi bi-person\"></i>");
		out.append("<span>Profile</span>");
		out.append("</a>");
		out.append("</li><!-- End Profile Page Nav -->");

		out.append("<li class=\"nav-item\">");
		out.append("<a class=\"nav-link collapsed\" href=\"pages-faq.html\">");
		out.append("<i class=\"bi bi-question-circle\"></i>");
		out.append("<span>F.A.Q</span>");
		out.append("</a>");
		out.append("</li><!-- End F.A.Q Page Nav -->");

		out.append("<li class=\"nav-item\">");
		out.append("<a class=\"nav-link collapsed\" href=\"pages-contact.html\">");
		out.append("<i class=\"bi bi-envelope\"></i>");
		out.append("<span>Contact</span>");
		out.append("</a>");
		out.append("</li><!-- End Contact Page Nav -->");

		out.append("<li class=\"nav-item\">");
		out.append("<a class=\"nav-link collapsed\" href=\"pages-register.html\">");
		out.append("<i class=\"bi bi-card-list\"></i>");
		out.append("<span>Register</span>");
		out.append("</a>");
		out.append("</li><!-- End Register Page Nav -->");

		out.append("<li class=\"nav-item\">");
		out.append("<a class=\"nav-link collapsed\" href=\"pages-login.html\">");
		out.append("<i class=\"bi bi-box-arrow-in-right\"></i>");
		out.append("<span>Login</span>");
		out.append("</a>");
		out.append("</li><!-- End Login Page Nav -->");

		out.append("<li class=\"nav-item\">");
		out.append("<a class=\"nav-link collapsed\" href=\"pages-error-404.html\">");
		out.append("<i class=\"bi bi-dash-circle\"></i>");
		out.append("<span>Error 404</span>");
		out.append("</a>");
		out.append("</li><!-- End Error 404 Page Nav -->");

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
