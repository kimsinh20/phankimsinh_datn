package jsoft.home.article;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.javatuples.Triplet;

import jsoft.ConnectionPool;
import jsoft.objects.ArticleObject;
import jsoft.objects.SectionObject;
import jsoft.objects.UserObject;

/**
 * Servlet implementation class Jobs
 */
@WebServlet("/blogs/")
public class HomeBlog extends HttpServlet {
	private static final long serialVersionUID = 1L;
	// định nghĩa kiểu nội dung xuất về trình khách
	private static final String CONTENT_TYPE = "text/html; charset=utf-8";

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public HomeBlog() {
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
		// xác định kiểu nội dung xuất về trình khách
		response.setContentType(CONTENT_TYPE);
		request.setCharacterEncoding("UTF-8");

		// lay page
		int page = 1;
		if (jsoft.library.Utilities.getIntParam(request, "page") > 0) {
			page = jsoft.library.Utilities.getIntParam(request, "page");
		} else {
			page = 1;
		}

		
		// tìm bộ quản lý kết nối
		ConnectionPool cp = (ConnectionPool) getServletContext().getAttribute("CPool");

		if (cp == null) {
			getServletContext().setAttribute("CPool", cp);
		}
		// tạo đối tượng thực thi chức năng
		ArticleControl jc = new ArticleControl(cp);

		// lấy cấu trúc
		ArticleObject similar = new ArticleObject();
		
	
		byte pageSize = 10;
		UserObject user = (UserObject) request.getSession().getAttribute("clientLogined");
		Triplet<ArticleObject, Integer, Byte> infos = new Triplet<>(similar, pageSize * (page - 1), pageSize);
		
		Triplet<ArrayList<ArticleObject>, ArrayList<ArticleObject>,ArrayList<SectionObject>> data = jc.viewArticleBolg(infos);
		request.setAttribute("articleTrend", data.getValue0());
		request.setAttribute("articles", data.getValue1());
		request.setAttribute("sections", data.getValue2());
		
		// trả về kết nối
		jc.releaseConnection();
		request.getRequestDispatcher("/blogs/index.jsp").forward(request, response);

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
