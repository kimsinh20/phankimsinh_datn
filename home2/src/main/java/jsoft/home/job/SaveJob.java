package jsoft.home.job;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import jsoft.ConnectionPool;
import jsoft.home.user.UserControl;

/**
 * Servlet implementation class UserLogin
 */
@WebServlet("/save")
public class SaveJob extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// định nghĩa kiểu nội dung xuất về trình khách
	private static final String CONTENT_TYPE = "text/html; charset=utf-8";

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SaveJob() {
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
		int job_id = Integer.parseInt(request.getParameter("job_id"));
		int user_id = Integer.parseInt(request.getParameter("user_id"));
		System.out.println("đẫ vào rôdi");
		if (job_id > 0 && user_id > 0) {
			// Tham chiếu ngữ cảnh ứng dụng
			ServletContext application = getServletConfig().getServletContext();

			// Tìm bộ quản lý kết nối trong không gian ngữ cảnh
			ConnectionPool cp = (ConnectionPool) application.getAttribute("CPool");

			// Tạo đối tượng thực thi chúc năng
			JobControl uc = new JobControl(cp);
			if (cp == null) {
				application.setAttribute("CPool", uc.getCP());
			}
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			boolean isExits = uc.isExits(job_id, user_id);
			if (isExits) {
				boolean rs = uc.delJob(job_id, user_id);
				if (rs) {
					// Thiết lập các tiêu đề HTTP và gửi phản hồi JSON
					
					response.setStatus(HttpServletResponse.SC_OK);
					Gson gson = new Gson();
					String jsonResponse = gson.toJson(new jsoft.home.user.Response("del"));

					response.getWriter().write(jsonResponse);

				} else {
					response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
					response.getWriter().write("delete job faill");
				}
			} else {
				boolean rs = uc.saveJob(job_id, user_id);
				if (rs) {
					// Thiết lập các tiêu đề HTTP và gửi phản hồi JSON
					response.setStatus(HttpServletResponse.SC_OK);
					Gson gson = new Gson();
					String jsonResponse = gson.toJson(new jsoft.home.user.Response("save"));

					response.getWriter().write(jsonResponse);

				} else {
					response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
					response.getWriter().write("save job faill");
				}
			}
			// Thực hiện đăng nhập

			// Trả về kết nối
			uc.releaseConnection();

		}
	}
}
