package jsoft.home.company;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.javatuples.Pair;
import org.javatuples.Triplet;

import jsoft.ConnectionPool;
import jsoft.library.ORDER;
import jsoft.objects.CareerObject;
import jsoft.objects.CompanyObject;
import jsoft.objects.JobObject;
import jsoft.objects.UserObject;

/**
 * Servlet implementation class Jobs
 */
@WebServlet("/company/")
public class CompanyList extends HttpServlet {
	private static final long serialVersionUID = 1L;
	// định nghĩa kiểu nội dung xuất về trình khách
	private static final String CONTENT_TYPE = "text/html; charset=utf-8";

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CompanyList() {
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
		UserObject user = (UserObject) request.getSession().getAttribute("clientLogined");
		String url = "";
		String queryString = request.getQueryString();
		String uri = request.getRequestURI();
		if (queryString != null && !queryString.equalsIgnoreCase("")) {
			url += uri + "?" + queryString;
		}
		Pair<COMPANY_SOFT, ORDER> sorting = null;
		String sort = request.getParameter("sort");

		if (sort != null && !sort.equalsIgnoreCase("")) {
			switch (sort) {
			case "general":
				sorting = new Pair<COMPANY_SOFT, ORDER>(COMPANY_SOFT.GENERAL, ORDER.DESC);
				break;
			case "lasted":
				sorting = new Pair<COMPANY_SOFT, ORDER>(COMPANY_SOFT.DATE, ORDER.DESC);
				break;
			case "oldest":
				sorting = new Pair<COMPANY_SOFT, ORDER>(COMPANY_SOFT.DATE, ORDER.ASC);
				break;
			case "atoz":
				sorting = new Pair<COMPANY_SOFT, ORDER>(COMPANY_SOFT.TITLE, ORDER.ASC);
				break;
			case "ztoa":
				sorting = new Pair<COMPANY_SOFT, ORDER>(COMPANY_SOFT.TITLE, ORDER.DESC);
				break;
			default:
				sorting = new Pair<COMPANY_SOFT, ORDER>(COMPANY_SOFT.GENERAL, ORDER.DESC);
			}
		} else {
			sorting = new Pair<COMPANY_SOFT, ORDER>(COMPANY_SOFT.GENERAL, ORDER.DESC);
		}

		// lay tu khoa tim kiem
		int cr = jsoft.library.Utilities.getIntParam(request, "cr");

		String key = request.getParameter("key");
		String saveKey = (key != null && !key.equalsIgnoreCase("")) ? jsoft.library.Utilities.encode(key.trim()) : "";
		int f = jsoft.library.Utilities.getIntParam(request, "f");
		// tìm bộ quản lý kết nối
		ConnectionPool cp = (ConnectionPool) getServletContext().getAttribute("CPool");

		if (cp == null) {
			getServletContext().setAttribute("CPool", cp);
		}
		// tạo đối tượng thực thi chức năng
		CompanyControl jc = new CompanyControl(cp);

		// lấy cấu trúc
		CompanyObject similar = new CompanyObject();
		similar.setCompany_field_id(f);
		similar.setCompany_name(saveKey);
		
		

		byte pageSize = 9;

		Triplet<CompanyObject, Integer, Byte> infos = new Triplet<>(similar, pageSize * (page - 1), pageSize);

		ArrayList<String> viewList = jc.viewCompanyPage(infos, sorting, url, page,user);
		request.setAttribute("viewJobs", viewList);
		// trả về kết nối
		jc.releaseConnection();
		request.getRequestDispatcher("/company/index.jsp").forward(request, response);

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
