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
import jsoft.ads.user.UserControl;
import jsoft.library.Utilities;
import jsoft.objects.ArticleObject;
import jsoft.objects.JobObject;
import jsoft.objects.UserObject;

/**
 * Servlet implementation class View
 */
@WebServlet("/employer/about")
public class About extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// định nghĩa kiểu nội dung xuất về trình khách
	private static final String CONTENT_TYPE = "text/html; charset=utf-8";

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public About() {
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
		
		out.append("<main >");
		out.append("<section>");
		out.append("<div class=\"container\" data-aos=\"fade-up\">");
		out.append("<div class=\"row\">");
		out.append("<div class=\"col-lg-12 text-center mb-5\">");
		out.append("<h1 class=\"page-title\">About us</h1>");
		out.append("</div>");
		out.append("</div>");
		out.append("");
		out.append("<div class=\"row mb-5\">");
		out.append("");
		out.append("<div class=\"d-md-flex post-entry-2 half\">");
		out.append("<a href=\"#\" class=\"me-4 thumbnail\">");
		out.append("<img src=\"/adv/adimgs/logo.jpg\" alt=\"\" class=\"img-fluid\">");
		out.append("</a>");
		out.append("<div class=\"ps-md-5 mt-4 mt-md-0\">");
		out.append("<div class=\"post-meta mt-4\">About us</div>");
		out.append("<h2 class=\"mb-4 display-4\">Company History</h2>");
		out.append("");
		out.append("<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Facilis, perspiciatis repellat maxime, adipisci non ipsam at itaque rerum vitae, necessitatibus nulla animi expedita cumque provident inventore? Voluptatum in tempora earum deleniti, culpa odit veniam, ea reiciendis sunt ullam temporibus aut!</p>");
		out.append("<p>Fugit eaque illum blanditiis, quo exercitationem maiores autem laudantium unde excepturi dolores quasi eos vero harum ipsa quam laborum illo aut facere voluptates aliquam adipisci sapiente beatae ullam. Tempora culpa iusto illum accusantium cum hic quisquam dolor placeat officiis eligendi.</p>");
		out.append("</div>");
		out.append("</div>");
		out.append("");
		out.append("<div class=\"d-md-flex post-entry-2 half mt-5\">");
		out.append("<a href=\"#\" class=\"me-4 thumbnail order-2\">");
		out.append("<img src=\"/adv/adimgs/job-search.png\" alt=\"\" class=\"img-fluid\">");
		out.append("</a>");
		out.append("<div class=\"pe-md-5 mt-4 mt-md-0\">");
		out.append("<div class=\"post-meta mt-4\">Mission &amp; Vision</div>");
		out.append("<h2 class=\"mb-4 display-4\">Mission &amp; Vision</h2>");
		out.append("");
		out.append("<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Facilis, perspiciatis repellat maxime, adipisci non ipsam at itaque rerum vitae, necessitatibus nulla animi expedita cumque provident inventore? Voluptatum in tempora earum deleniti, culpa odit veniam, ea reiciendis sunt ullam temporibus aut!</p>");
		out.append("<p>Fugit eaque illum blanditiis, quo exercitationem maiores autem laudantium unde excepturi dolores quasi eos vero harum ipsa quam laborum illo aut facere voluptates aliquam adipisci sapiente beatae ullam. Tempora culpa iusto illum accusantium cum hic quisquam dolor placeat officiis eligendi.</p>");
		out.append("</div>");
		out.append("</div>");
		out.append("");
		out.append("</div>");
		out.append("");
		out.append("</div>");
		out.append("</section>");
		out.append("");
		out.append("<section class=\"mb-5 bg-light py-5\">");
		out.append("<div class=\"container\" data-aos=\"fade-up\">");
		out.append("<div class=\"row justify-content-between align-items-lg-center\">");
		out.append("<div class=\"col-lg-5 mb-4 mb-lg-0\">");
		out.append("<h2 class=\"display-4 mb-4\">Latest News</h2>");
		out.append("<p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Sed, rem eaque vel est asperiores iste pariatur placeat molestias, rerum provident ea maiores debitis eum earum esse quas architecto! Minima, voluptatum! Minus tempora distinctio quo sint est blanditiis voluptate eos. Commodi dolore nesciunt culpa adipisci nemo expedita suscipit autem dolorum rerum?</p>");
		out.append("<p>At magni dolore ullam odio sapiente ipsam, numquam eius minus animi inventore alias quam fugit corrupti error iste laboriosam dolorum culpa doloremque eligendi repellat iusto vel impedit odit cum. Sequi atque molestias nesciunt rem eum pariatur quibusdam deleniti saepe eius maiores porro quam, praesentium ipsa deserunt laboriosam adipisci. Optio, animi!</p>");
		out.append("<p><a href=\"#\" class=\"more\">View All Blog Posts</a></p>");
		out.append("</div>");
		out.append("<div class=\"col-lg-6\">");
		out.append("<div class=\"row\">");
		out.append("<div class=\"col-6\">");
		out.append("<img src=\"/adv/adimgs/a.jpg\" alt=\"\" class=\"img-fluid mb-4\">");
		out.append("</div>");
		out.append("<div class=\"col-6 mt-4\">");
		out.append("<img src=\"/adv/adimgs/job-search.png\" alt=\"\" class=\"img-fluid mb-4\">");
		out.append("</div>");
		out.append("</div>");
		out.append("</div>");
		out.append("</div>");
		out.append("</div>");
		out.append("</section>");
		out.append("");
		out.append("<section>");
		out.append("<div class=\"container\" data-aos=\"fade-up\">");
		out.append("<div class=\"row\">");
		out.append("<div class=\"col-12 text-center mb-5\">");
		out.append("<div class=\"row justify-content-center\">");
		out.append("<div class=\"col-lg-6\">");
		out.append("<h2 class=\"display-4\">Our Team</h2>");
		out.append("<p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Nihil sint sed, fugit distinctio ad eius itaque deserunt doloribus harum excepturi laudantium sit officiis et eaque blanditiis. Dolore natus excepturi recusandae.</p>");
		out.append("</div>");
		out.append("</div>");
		out.append("</div>");
		out.append("<div class=\"col-lg-4 text-center mb-5\">");
		out.append("<img src=\"/adv/adimgs/avatar1.png\" alt=\"\" class=\"img-fluid rounded-circle w-50 mb-4\">");
		out.append("<h4>Cameron Williamson</h4>");
		out.append("<span class=\"d-block mb-3 text-uppercase\">Founder &amp; CEO</span>");
		out.append("<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Facilis, perspiciatis repellat maxime, adipisci non ipsam at itaque rerum vitae, necessitatibus nulla animi expedita cumque provident inventore? Voluptatum in tempora earum deleniti, culpa odit veniam, ea reiciendis sunt ullam temporibus aut!</p>");
		out.append("</div>");
		out.append("<div class=\"col-lg-4 text-center mb-5\">");
		out.append("<img src=\"/adv/adimgs/avatar2.png\" alt=\"\" class=\"img-fluid rounded-circle w-50 mb-4\">");
		out.append("<h4>Wade Warren</h4>");
		out.append("<span class=\"d-block mb-3 text-uppercase\">Founder, VP</span>");
		out.append("<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Facilis, perspiciatis repellat maxime, adipisci non ipsam at itaque rerum vitae, necessitatibus nulla animi expedita cumque provident inventore? Voluptatum in tempora earum deleniti, culpa odit veniam, ea reiciendis sunt ullam temporibus aut!</p>");
		out.append("</div>");
		out.append("<div class=\"col-lg-4 text-center mb-5\">");
		out.append("<img src=\"/adv/adimgs/avatar4.png\" alt=\"\" class=\"img-fluid rounded-circle w-50 mb-4\">");
		out.append("<h4>Jane Cooper</h4>");
		out.append("<span class=\"d-block mb-3 text-uppercase\">Editor Staff</span>");
		out.append("<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Facilis, perspiciatis repellat maxime, adipisci non ipsam at itaque rerum vitae, necessitatibus nulla animi expedita cumque provident inventore? Voluptatum in tempora earum deleniti, culpa odit veniam, ea reiciendis sunt ullam temporibus aut!</p>");
		out.append("</div>");
		
		out.append("</div>");
		out.append("</div>");
		out.append("</section>");
		out.append("");
		out.append("</main><!-- End #main -->");
		out.append("<!-- End #main -->");
		
		// tham chiếu tìm sidebar
		RequestDispatcher f = request.getRequestDispatcher("/employer/footer");
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
