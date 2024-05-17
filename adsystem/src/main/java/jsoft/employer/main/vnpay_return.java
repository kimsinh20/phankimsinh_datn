package jsoft.employer.main;

import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jsoft.ConnectionPool;
import jsoft.ads.user.USER_TYPE;
import jsoft.ads.user.UserControl;
import jsoft.objects.ServiceObject;
import jsoft.objects.UserObject;

/**
 * Servlet implementation class Jobs
 */
@WebServlet("/return")
public class vnpay_return extends HttpServlet {
	private static final long serialVersionUID = 1L;
	// định nghĩa kiểu nội dung xuất về trình khách
	private static final String CONTENT_TYPE = "text/html; charset=utf-8";

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public vnpay_return() {
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

		
		UserObject user = (UserObject) request.getSession().getAttribute("employerLogined");
		
		if(user==null) {
			response.sendRedirect("/adv/employer/login");
		}

		// tìm bộ quản lý kết nối
		ConnectionPool cp = (ConnectionPool) getServletContext().getAttribute("CPool");

		if (cp == null) {
			getServletContext().setAttribute("CPool", cp);
		}
		// tạo đối tượng thực thi chức năng
		UserControl dc = new UserControl(cp);	
	
		   Map fields = new HashMap();
           for (Enumeration params = request.getParameterNames(); params.hasMoreElements();) {
               String fieldName = URLEncoder.encode((String) params.nextElement(), StandardCharsets.US_ASCII.toString());
               String fieldValue = URLEncoder.encode(request.getParameter(fieldName), StandardCharsets.US_ASCII.toString());
               if ((fieldValue != null) && (fieldValue.length() > 0)) {
                   fields.put(fieldName, fieldValue);
               }
           }
           int amount = Integer.parseInt(request.getParameter("vnp_Amount"))/100;
           int order_id = Integer.parseInt(request.getParameter("vnp_TxnRef"));
           String vnp_SecureHash = request.getParameter("vnp_SecureHash");
           if (fields.containsKey("vnp_SecureHashType")) {
               fields.remove("vnp_SecureHashType");
           }
           if (fields.containsKey("vnp_SecureHash")) {
               fields.remove("vnp_SecureHash");
           }
           String signValue = Config.hashAllFields(fields);
           ServiceObject s = new ServiceObject();
           s.setService_price(amount);
           
           if (signValue.equals(vnp_SecureHash)) {
               if ("00".equals(request.getParameter("vnp_TransactionStatus"))) {
                   if(amount==500000) {
                	   s.setService_id(57);
                	   boolean isAdd = dc.addOrder(order_id, s, user);
                	   if(isAdd) {
                		   response.sendRedirect("/adv/employer?oke");
                	   } else {
                		   request.setAttribute("user", user);
                			request.setAttribute("amount", amount);
                			request.getRequestDispatcher("vnpay_return.jsp").forward(request, response);
                	   }
                   } else if(amount==600000) {
                	   s.setService_id(58);
                	   boolean isAdd = dc.addOrder(order_id, s, user);
                	   if(isAdd) {
                		   response.sendRedirect("/adv/employer?oke");
                	   } else {
                		   request.setAttribute("user", user);
                			request.setAttribute("amount", amount);
                			request.getRequestDispatcher("vnpay_return.jsp").forward(request, response);
                	   }
                   } else if(amount==700000) {
                	   s.setService_id(56);
                	   boolean isAdd = dc.addOrder(order_id, s, user);
                	   if(isAdd) {
                		   response.sendRedirect("/adv/employer?oke");
                	   } else {
                		   request.setAttribute("user", user);
                			request.setAttribute("amount", amount);
                			request.getRequestDispatcher("vnpay_return.jsp").forward(request, response);
                	   }
                   }
               } else {
            	   System.out.print("Không thành công");
               }

           } else {
        	   System.out.print("invalid signature");
        	   
           }
		
		// trả về kết nối
		dc.releaseConnection();

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
