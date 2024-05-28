package jsoft.employer.main;

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
import org.javatuples.Quintet;
import org.javatuples.Sextet;

import jsoft.ConnectionPool;
import jsoft.ads.contact.ContactControl;
import jsoft.ads.user.USER_TYPE;
import jsoft.ads.user.UserControl;
import jsoft.library.Utilities;
import jsoft.objects.ArticleObject;
import jsoft.objects.ContactObject;
import jsoft.objects.JobObject;
import jsoft.objects.UserObject;

/**
 * Servlet implementation class View
 */
@WebServlet("/employer/contact")
public class Contact extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// định nghĩa kiểu nội dung xuất về trình khách
	private static final String CONTENT_TYPE = "text/html; charset=utf-8";

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Contact() {
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
		UserObject user = (UserObject) request.getSession().getAttribute("employerLogined");

		
		view(request, response, user);

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
		
		
			
		uc.releaseConnection();
		
		// tham chiếu tìm header
		RequestDispatcher h = request.getRequestDispatcher("/employer/header");
		if(h != null) {
			h.include(request, response);
		}
		
		RequestDispatcher error = request.getRequestDispatcher("/error");
		if (error != null) {
			error.include(request, response);
		}
		
		String success = request.getParameter("success");
		if (success != null) {
			out.append("<div class=\"toast-container position-fixed top-1 end-0 ps-3 pe-5 mb-3\">");
			out.append(
					"<div id=\"liveToast\" class=\"toast\" role=\"alert\" aria-live=\"assertive\" aria-atomic=\"true\">");
			out.append("<div class=\"toast-header\">");
			// out.append("<img src=\"...\" class=\"rounded me-2\" alt=\"...\">");
			out.append("<strong class=\"me-auto text-success\">Thông báo</strong>");
			out.append("<small>10 giây</small>");
			out.append("<button type=\"button\" class=\"btn-close\" data-bs-dismiss=\"toast\" aria-label=\"Close\"></button>");
			out.append("</div>");
			out.append("<div class=\"toast-body\">");
			out.append("Liên hệ thành công");
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
		
		out.append("<main>");
		out.append("<section id=\"contact\" class=\"contact mb-5\">");
		out.append("<div class=\"container\" data-aos=\"fade-up\">");
		out.append("<div class=\"row mt-5\">");
		out.append("<div class=\"col-lg-12 text-center mt-5 mb-5\">");
		out.append("<iframe src=\"https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3723.8288721720933!2d105.76094617343418!3d21.03953218741198!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x313454c0bcc98819%3A0xfe283d141978e385!2zTmcuIDE5OSDEkC4gSOG7kyBUw7luZyBN4bqtdSwgQ-G6p3UgRGnhu4VuLCBOYW0gVOG7qyBMacOqbSwgSMOgIE7hu5lpLCBWaWV0bmFt!5e0!3m2!1sfr!2s!4v1716846535955!5m2!1sfr!2s\" width=\"1000\" height=\"450\" style=\"border:0;\" allowfullscreen=\"\" loading=\"lazy\" referrerpolicy=\"no-referrer-when-downgrade\"></iframe>");
		out.append("</div>");
		out.append("</div>");
		out.append("<div class=\"row\">");
		out.append("<div class=\"col-lg-12 text-center mb-5\">");
		out.append("<h1 class=\"page-title\">Contact us</h1>");
		out.append("</div>");
		out.append("</div>");
		out.append("");
		out.append("<div class=\"row gy-4\">");
		out.append("");
		out.append("<div class=\"col-md-4\">");
		out.append("<div class=\"info-item\">");
		out.append("<i class=\"bi bi-geo-alt\"></i>");
		out.append("<h3>Address</h3>");
		out.append("<address>ngõ 199 Hồ Tùng Mậu Quận Nam từ Liêm Tp Hà Nội</address>");
		out.append("</div>");
		out.append("</div><!-- End Info Item -->");
		out.append("");
		out.append("<div class=\"col-md-4\">");
		out.append("<div class=\"info-item info-item-borders\">");
		out.append("<i class=\"bi bi-phone\"></i>");
		out.append("<h3>Phone Number</h3>");
		out.append("<p><a href=\"tel:+155895548855\">+1 5589 55488 55</a></p>");
		out.append("</div>");
		out.append("</div><!-- End Info Item -->");
		out.append("");
		out.append("<div class=\"col-md-4\">");
		out.append("<div class=\"info-item\">");
		out.append("<i class=\"bi bi-envelope\"></i>");
		out.append("<h3>Email</h3>");
		out.append("<p><a href=\"mailto:phankimsinh20@gmail.com\">jobnow@gmail.com</a></p>");
		out.append("</div>");
		out.append("</div><!-- End Info Item -->");
		out.append("");
		out.append("</div>");
		out.append("");
		out.append("<div class=\"form mt-5\">");
		out.append("<form method=\"post\" role=\"form\" class=\"php-email-form\">");
		out.append("<div class=\"row\">");
		out.append("<div class=\"form-group col-md-6\">");
		out.append("<input type=\"text\" name=\"name\" class=\"form-control\" id=\"name\" placeholder=\"Your Name\" required>");
		out.append("</div>");
		out.append("<div class=\"form-group col-md-6\">");
		out.append("<input type=\"email\" class=\"form-control\" name=\"email\" id=\"email\" placeholder=\"Your Email\" required>");
		out.append("</div>");
		out.append("</div>");
		out.append("<div class=\"form-group\">");
		out.append("<input type=\"text\" class=\"form-control\" name=\"subject\" id=\"subject\" placeholder=\"Subject\" required>");
		out.append("</div>");
		out.append("<div class=\"form-group\">");
		out.append("<textarea class=\"form-control\" name=\"message\" rows=\"5\" placeholder=\"Message\" required></textarea>");
		out.append("</div>");
		out.append("<div class=\"my-3\">");
		out.append("<div class=\"loading\">Loading</div>");
		out.append("<div class=\"error-message\"></div>");
		out.append("<div class=\"sent-message\">Your message has been sent. Thank you!</div>");
		out.append("</div>");
		out.append("<div class=\"text-center\"><button type=\"submit\">Send Message</button></div>");
		out.append("</form>");
		out.append("</div><!-- End Contact Form -->");
		out.append("");
		out.append("</div>");
		out.append("</section>");
		out.append("");
		out.append("</main><!-- End #main -->");
		out.append("<!-- End #main -->");
		out.append("");
		out.append("");
		
		// tham chiếu tìm sidebar
		out.append("<!-- ======= Footer ======= -->");
		out.append("<footer  class=\"footer\">");
		out.append("<div class=\"copyright\">");
		out.append("&copy; Copyright <strong><span>JP255</span></strong>. All Rights Reserved");
		out.append("</div>");
		out.append("<div class=\"credits\">");
		out.append("<!-- All the links in the footer should remain intact. -->");
		out.append("<!-- You can delete the links only if you purchased the pro version. -->");
		out.append("<!-- Licensing information: https://bootstrapmade.com/license/ -->");
		out.append(
				"<!-- Purchase the pro version with working PHP/AJAX contact form: https://bootstrapmade.com/nice-admin-bootstrap-admin-html-template/ -->");
		out.append("Designed by <a href=\"https://bootstrapmade.com/\">BootstrapMade</a>");
		out.append("</div>");
		out.append("</footer><!-- End Footer -->");
		
		out.append("<a href=\"#\" class=\"back-to-top d-flex align-items-center justify-content-center\"><i class=\"bi bi-arrow-up-short\"></i></a>");
		
		out.append("<!-- Vendor JS Files -->");
		out.append("<script src=\"/adv/adjavascript/apexcharts/apexcharts.min.js\"></script>");
	
		// out.append("<script src=\"assets/vendor/chart.js/chart.umd.js\"></script>");
		// out.append("<script src=\"assets/vendor/echarts/echarts.min.js\"></script>");
		
		out.append("<!-- Template Main JS File -->");
		out.append("<script src=\"/adv/adjavascript/main.js\"></script>");
		out.append("<script src=\"/adv/adjavascript/tags.js\"></script>");
		out.append("<script src=\"/adv/adjavascript/scripts.js\"></script>");
		out.append("<script src=\"/adv/adjavascript/profilesChangePassword.js\"></script>");
		
		out.append("</body>");
		
		out.append("</html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String subject = request.getParameter("subject");
		String message = request.getParameter("message");
		ContactObject c = new ContactObject();
		c.setContact_fullname(name);
		c.setContact_email(email);
		c.setContact_title(subject);
		c.setContact_content(message);
		c.setContact_created_date(jsoft.library.Utilities_date.getDate());
		c.setContact_enable(false);
		ConnectionPool cp = (ConnectionPool) getServletContext().getAttribute("CPool");
		ContactControl uc = new ContactControl(cp);
		// add new user
		if (cp != null) {
			getServletContext().setAttribute("CPool", uc.getCP());
		}
		boolean result = uc.addContact(c);
		// return connect
		uc.releaseConnection();
		if(result) {
			response.sendRedirect("/adv/employer/contact?success");
		} else {
			response.sendRedirect("/adv/employer/contact?err=add");
		}
		System.out.print(name+email+subject+message);
	}

}
