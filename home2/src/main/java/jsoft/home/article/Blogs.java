package jsoft.home.article;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.javatuples.Pair;
import org.javatuples.Triplet;

import jsoft.ConnectionPool;
import jsoft.library.ORDER;
import jsoft.objects.ArticleObject;
import jsoft.objects.UserObject;

/**
 * Servlet implementation class Jobs
 */
@WebServlet("/blogs/list")
public class Blogs extends HttpServlet {
	private static final long serialVersionUID = 1L;
	// định nghĩa kiểu nội dung xuất về trình khách
	private static final String CONTENT_TYPE = "text/html; charset=utf-8";

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Blogs() {
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
		String url = "";
		String queryString = request.getQueryString();
		String uri = request.getRequestURI();
		if (queryString != null && !queryString.equalsIgnoreCase("")) {
			url += uri + "?" + queryString;
		}
		Pair<ARTICLE_SOFT, ORDER> sorting = null;
		String sort = request.getParameter("sort");

		if (sort != null && !sort.equalsIgnoreCase("")) {
			switch (sort) {
			case "visited":
				sorting = new Pair<ARTICLE_SOFT, ORDER>(ARTICLE_SOFT.VISITED, ORDER.DESC);
				break;
			case "lasted":
				sorting = new Pair<ARTICLE_SOFT, ORDER>(ARTICLE_SOFT.DATE, ORDER.DESC);
				break;
			case "oldest":
				sorting = new Pair<ARTICLE_SOFT, ORDER>(ARTICLE_SOFT.DATE, ORDER.ASC);
				break;
			case "atoz":
				sorting = new Pair<ARTICLE_SOFT, ORDER>(ARTICLE_SOFT.TITLE, ORDER.ASC);
				break;
			case "ztoa":
				sorting = new Pair<ARTICLE_SOFT, ORDER>(ARTICLE_SOFT.TITLE, ORDER.DESC);
				break;
			default:
				sorting = new Pair<ARTICLE_SOFT, ORDER>(ARTICLE_SOFT.VISITED, ORDER.DESC);
			}
		} else {
			sorting = new Pair<ARTICLE_SOFT, ORDER>(ARTICLE_SOFT.VISITED, ORDER.DESC);
		}

		// lay tu khoa tim kiem
		short section = jsoft.library.Utilities.getShortParam(request, "id");
		short cate = jsoft.library.Utilities.getShortParam(request, "c");

		String key = request.getParameter("q");
		String saveKey = (key != null && !key.equalsIgnoreCase("")) ? jsoft.library.Utilities.encode(key.trim()) : "";
		String tag = request.getParameter("t");
		String saveTag = (tag != null && !tag.equalsIgnoreCase("")) ? jsoft.library.Utilities.encode(tag.trim()) : "";
		// tìm bộ quản lý kết nối
		ConnectionPool cp = (ConnectionPool) getServletContext().getAttribute("CPool");

		if (cp == null) {
			getServletContext().setAttribute("CPool", cp);
		}
		// tạo đối tượng thực thi chức năng
		ArticleControl jc = new ArticleControl(cp);

		// lấy cấu trúc
		ArticleObject similar = new ArticleObject();
		similar.setArticle_section_id(section);
		similar.setArticle_tag(saveTag);
		similar.setArticle_title(saveKey);
		similar.setArticle_category_id(cate);
	
		byte pageSize = 10;
		UserObject user = (UserObject) request.getSession().getAttribute("clientLogined");
		Triplet<ArticleObject, Integer, Byte> infos = new Triplet<>(similar, pageSize * (page - 1), pageSize);
		
		ArrayList<String> view = jc.ViewBlogsList(infos,sorting,url,page);
		request.setAttribute("view", view);
		request.setAttribute("section_id", section);
		request.setAttribute("q", saveKey);
		
//		
		// trả về kết nối
		jc.releaseConnection();
		request.getRequestDispatcher("/blogs/blogsCate.jsp").forward(request, response);

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
