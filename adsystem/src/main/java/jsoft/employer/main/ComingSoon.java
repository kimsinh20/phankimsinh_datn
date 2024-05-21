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
@WebServlet("/employer/comingsoon")
public class ComingSoon extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// định nghĩa kiểu nội dung xuất về trình khách
	private static final String CONTENT_TYPE = "text/html; charset=utf-8";

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ComingSoon() {
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

		if (user != null) {
			view(request, response, user);
		} else {
			response.sendRedirect("/adv/employer/login");
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
		
		
			
		uc.releaseConnection();
		
		// tham chiếu tìm header
		RequestDispatcher h = request.getRequestDispatcher("/employer/header");
		if(h != null) {
			h.include(request, response);
		}
		
		RequestDispatcher s = request.getRequestDispatcher("/employer/sidebar");
		if (s != null && user !=null) {
			s.include(request, response);
		}
		
		
		out.append("<main id=\"main\" class=\"main\">");

		out.append("<img class=\"w-100\" src=\"https://cdn.optinmonster.com/wp-content/uploads/2019/03/how-to-create-a-coming-soon-page-in-wordpress.png\">");

		out.append("</main><!-- End #main -->");
		
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
