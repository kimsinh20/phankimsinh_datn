package jsoft.employer.main;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.javatuples.Pair;
import org.javatuples.Triplet;

import jsoft.ConnectionPool;
import jsoft.ads.user.UserControl;
import jsoft.library.ORDER;
import jsoft.objects.CareerObject;
import jsoft.objects.CompanyObject;
import jsoft.objects.JobObject;
import jsoft.objects.ServiceObject;
import jsoft.objects.UserObject;

/**
 * Servlet implementation class Jobs
 */
@WebServlet("/service")
public class payment extends HttpServlet {
	private static final long serialVersionUID = 1L;
	// định nghĩa kiểu nội dung xuất về trình khách
	private static final String CONTENT_TYPE = "text/html; charset=utf-8";

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public payment() {
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

		short id = jsoft.library.Utilities.getShortParam(request, "id");
	
		UserObject user = (UserObject) request.getSession().getAttribute("employerLogined");
		

		// tìm bộ quản lý kết nối
		ConnectionPool cp = (ConnectionPool) getServletContext().getAttribute("CPool");

		if (cp == null) {
			getServletContext().setAttribute("CPool", cp);
		}
		// tạo đối tượng thực thi chức năng
		UserControl dc = new UserControl(cp);
		ServiceObject service =  dc.getServiceObject(id);
		
	
		// trả về kết nối
		dc.releaseConnection();
		request.setAttribute("user", user);
		request.setAttribute("service", service);
		request.getRequestDispatcher("vnpay_pay.jsp").forward(request, response);

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
