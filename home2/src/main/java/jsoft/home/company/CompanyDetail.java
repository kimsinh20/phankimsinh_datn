package jsoft.home.company;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.javatuples.Pair;
import org.javatuples.Quartet;
import org.javatuples.Quintet;
import org.javatuples.Triplet;

import com.google.gson.Gson;

import jsoft.ConnectionPool;
import jsoft.objects.AddressObject;
import jsoft.objects.ArticleObject;
import jsoft.objects.CareerObject;
import jsoft.objects.CompanyObject;
import jsoft.objects.FieldObject;
import jsoft.objects.JobObject;
import jsoft.objects.SkillObject;

/**
 * Servlet implementation class JobFields
 */
@WebServlet("/company/detail")
public class CompanyDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String CONTENT_TYPE = "text/html; charset=utf-8";

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CompanyDetail() {
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
		response.setContentType(CONTENT_TYPE);
		request.setCharacterEncoding("UTF-8");
		short id = -1;
		try {
			if (jsoft.library.Utilities.getShortParam(request, "id") > 0) {
				 id = jsoft.library.Utilities.getShortParam(request, "id");
			} 
		} catch (Exception e) {
			response.sendRedirect("/home/err");
		}
		if (id > 0) {
			// tìm bộ quản lý kết nối
			ConnectionPool cp = (ConnectionPool) getServletContext().getAttribute("CPool");

			if (cp == null) {
				getServletContext().setAttribute("CPool", cp);
			}
			// tạo đối tượng thực thi chức năng

			CompanyControl jc = new CompanyControl(cp);
			Quartet<CompanyObject, HashMap<Integer, String>,ArrayList<JobObject>,ArrayList<ArticleObject>> data = jc.getCompanyObject(id);
			
			CompanyObject com = data.getValue0();
			String company_size="",company_nationality="";
			AddressObject[] addressList = null;
			
			if(com!=null) {
				Gson gson = new Gson();
				addressList = gson.fromJson(jsoft.library.Utilities.decode(com.getCompany_location()),AddressObject[].class);
				
				switch (com.getCompany_size()) {
				case 0:
					company_size = "Dưới 100 người";
					break;
				case 1:
					company_size = "100 đến 500 người";
					break;
				case 2:
					company_size = "500 trên đến 1000 người";
					break;
				case 3:
					company_size = "Trên 1000 người";
					break;
				case 4:
					company_size = "Trên 5000 người";
					break;
				case 5:
					company_size = "Trên 10000 người";
					break;
				default:
					throw new IllegalArgumentException("Unexpected value: " + com);
				}
				switch (com.getCompany_nationality()) {
				case 0:
					company_nationality = "Việt Nam";
					break;
				case 1:
					company_nationality = "Trung quốc";
					break;
				case 2:
					company_nationality = "Nhật bản";
					break;
				case 3:
					company_nationality = "Hàn quốc";
					break;
				case 4:
					company_nationality = "Singapo";
					break;
				case 5:
					company_nationality = "Mỹ";
					break;
				default:
					throw new IllegalArgumentException("Unexpected value: " + com);
				}
			}
			request.setAttribute("com", data.getValue0());
			request.setAttribute("skills", data.getValue1());
			request.setAttribute("jobs", data.getValue2());
			request.setAttribute("articles", data.getValue3());
			request.setAttribute("company_size", company_size);
			request.setAttribute("company_nationality", company_nationality);
			request.setAttribute("location", addressList);
		
			
			// trả về kết nối
			// trả về kết nối
			jc.releaseConnection();
			request.getRequestDispatcher("/company/detail.jsp").forward(request, response);
		} else {
			response.sendRedirect("/home/err");
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
