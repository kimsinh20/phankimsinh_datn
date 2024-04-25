package jsoft.home.user;

import java.io.BufferedReader;
import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import jsoft.ConnectionPool;
import jsoft.objects.LoginFormObejct;
import jsoft.objects.UserObject;

/**
 * Servlet implementation class UserLogin
 */
@WebServlet("/login")
public class UserLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// định nghĩa kiểu nội dung xuất về trình khách
	private static final String CONTENT_TYPE = "text/html; charset=utf-8";

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserLogin() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * Thường đc dùng để cung cấp một giao diện (GUI - cấu trúc HTML) <br>
	 * Đc gọi trong 2 trường hợp:<br>
	 * - Thông qua URL / URI <br>
	 * - Thông qua sự kiện của form (method="get")<br>
	 * 
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 * 
	 * @param request  - Lưu trữ các yêu cầu xử lý, các dữ liệu được gửi lên bởi
	 *                 Client
	 * @param response - Lưu trữ các đáp ứng dữ liệu sẽ được trả về Client
	 * 
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		// xác định kiểu nội dung xuất về trình khách
		response.setContentType(CONTENT_TYPE);
	}

	/**
	 * Thường được dùng để xử lý dữ liệu do doGet chuyển cho<br>
	 * Được gọi trong sự kiện của from ( method="post" )<br>
	 * 
	 * 
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// doGet(request, response);
		BufferedReader reader = request.getReader();
        StringBuilder stringBuilder = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            stringBuilder.append(line);
        }
        String requestBody = stringBuilder.toString();

        // Giải mã dữ liệu JSON
        Gson gson = new Gson();
        LoginFormObejct json = gson.fromJson(requestBody, LoginFormObejct.class);
        String username = json.getTxtName();
        String userpass = json.getTxPass();
		if (username != null && userpass != null) {
			username = username.trim();
			userpass = userpass.trim();

			if (!username.equalsIgnoreCase("") && !userpass.equalsIgnoreCase("")) {
				// Tham chiếu ngữ cảnh ứng dụng
				ServletContext application = getServletConfig().getServletContext();

				// Tìm bộ quản lý kết nối trong không gian ngữ cảnh
				ConnectionPool cp = (ConnectionPool) application.getAttribute("CPool");

				// Tạo đối tượng thực thi chúc năng
				UserControl uc = new UserControl(cp);
				if (cp == null) {
					application.setAttribute("CPool", uc.getCP());
				}

				// Thực hiện đăng nhập
				UserObject user = uc.getUserObject(username, userpass);

				// Trả về kết nối
				uc.releaseConnection();

				if (user != null) {
					if(user.getUser_permission()>10) {
						
					} else {
						// Tham chiếu phiên làm việc
						HttpSession session = request.getSession(true);
//						Boolean checkUpdateLogined = uc.getUpdateLogined(user);
						// Đưa thông tin đăng nhập vào phiên
						 session.setAttribute("clientLogined", user);
				            String u = gson.toJson(user);

				            // Thiết lập các tiêu đề HTTP và gửi phản hồi JSON
				            response.setContentType("application/json");
				            response.setCharacterEncoding("UTF-8");
				            response.setStatus(HttpServletResponse.SC_OK);
				            response.getWriter().write(u);
				            
					}
					
				} else {
					   response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			            response.getWriter().write("passwork or user name is invalid");
				}

			} else {
				   response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
		            response.getWriter().write("user name or passwork is blank ");
			}

		} else {
			   response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
	            response.getWriter().write("user name or password null");

		}
	}

}
