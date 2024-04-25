package jsoft.home.article;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.javatuples.Quartet;
import org.javatuples.Triplet;

import jsoft.ConnectionPool;
import jsoft.library.Utilities;
import jsoft.objects.ArticleObject;
import jsoft.objects.SectionObject;
import jsoft.objects.UserObject;

/**
 * Servlet implementation class Jobs
 */
@WebServlet("/blogs/detail")
public class BlogDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;
	// định nghĩa kiểu nội dung xuất về trình khách
	private static final String CONTENT_TYPE = "text/html; charset=utf-8";

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BlogDetail() {
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

		int id = jsoft.library.Utilities.getIntParam(request, "id");
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
	
		
		Quartet<ArticleObject, ArrayList<ArticleObject>, ArrayList<SectionObject>,HashMap<String, Integer>> data = jc.getArticleObject(id);
		ArticleObject ar = data.getValue0();
		 String tag="";
         String[] tagList;
      
         if(ar!=null) {
        		tag =(ar.getArticle_tag()!=null)? Utilities.decode(ar.getArticle_tag()).toLowerCase():"";
         }
         tagList = tag.split(","); 
     
		
		
		HashMap<String, Integer> tagsSidebar =data.getValue3();
		System.out.println(tagsSidebar.size());
		request.setAttribute("tagsSidebar",tagsSidebar);
		request.setAttribute("articleNew", data.getValue1());
		request.setAttribute("sections", data.getValue2());
		request.setAttribute("tags", tagList);
		request.setAttribute("article", ar);
		
		// trả về kết nối
		jc.releaseConnection();
		request.getRequestDispatcher("/blogs/detail.jsp").forward(request, response);

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
