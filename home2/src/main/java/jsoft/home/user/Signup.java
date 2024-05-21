package jsoft.home.user;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jsoft.ConnectionPool;
import jsoft.objects.ClientObject;

/**
 * Servlet implementation class UserLogin
 */
@WebServlet("/client/signup")
public class Signup extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// định nghĩa kiểu nội dung xuất về trình khách
	private static final String CONTENT_TYPE = "text/html; charset=utf-8";

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Signup() {
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

		// tạo đối tượng thực hiện xuất nội dung
		PrintWriter out = response.getWriter();
		out.append("<!doctype html>");
		out.append("<html lang=\"en\">");
		out.append("<head>");
		out.append("<meta charset=\"utf-8\">");
		out.append("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">");
		out.append("<title>Đăng Nhập</title>");
		out.append("<link href=\"https://fonts.gstatic.com\" rel=\"preconnect\">");
		out.append("<link href=\"https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i|Nunito:300,300i,400,400i,600,600i,700,700i|Poppins:300,300i,400,400i,500,500i,600,600i,700,700i\" rel=\"stylesheet\">");
		out.append("<link href=\"/adv/adcss/all.min.css\" rel=\"stylesheet\">");
		out.append("<link href=\"/adv/adcss/bootstrap.min.css\" rel=\"stylesheet\">");
		out.append("<link href=\"/adv/adcss/bootstrap-icons/bootstrap-icons.css\" rel=\"stylesheet\">");
		out.append("<script src=\"/adv/adjavascript/bootstrap.bundle.min.js\"></script>");
		out.append("</head>");
		out.append("<style>");
		out.append("body{");
		out.append("background: linear-gradient(120deg,#3ca7ee, #9b408f) ;");
		out.append("height:100vh;");
		out.append("overflow:hidden;");
		out.append("}");
		out.append("#errName {");
		out.append("border-radius: 5px;");
		out.append("margin-top: 4px;");
		out.append("padding: 2px 0px;");
		out.append("}");
		out.append("#errPass {");
		out.append("border-radius: 5px;");
		out.append("margin-top: 4px;");
		out.append("padding: 2px 0px;");
		out.append("}");
		out.append("</style>");
		out.append("<body>");
		out.append("<main class=\"overflow-scroll h-100\">");
		out.append("<div class=\"container\">");
		out.append("<section class=\"section register d-flex flex-column align-items-center justify-content-center\">");
		out.append("<div class=\"container\">");
		out.append("<div class=\"row justify-content-center\">");
		out.append("<div class=\"col-md-6 d-flex flex-column align-items-center justify-content-center\">");
		// tìm tham số báo lỗi nếu có
		String err = request.getParameter("err");
		if (err != null) {
			out.append("<div class=\"toast-container position-fixed top-0 end-0 me-4 mt-4\">");
			out.append(
					"<div id=\"liveToast\" class=\"toast\" role=\"alert\" aria-live=\"assertive\" aria-atomic=\"true\">");
			out.append("<div class=\"toast-header\">");

			out.append("<strong class=\"me-auto text-danger\">Thông báo</strong>");
			out.append("<small>10 giây</small>");
			out.append(
					"<button type=\"button\" class=\"btn-close\" data-bs-dismiss=\"toast\" aria-label=\"Close\"></button>");
			out.append("</div>");
			out.append("<div class=\"toast-body d-flex justify-content-between\">");
			out.append("<p class=\"main\">");
			switch (err) {
			case "param":
				out.append("Không tồn tại giá trị cho tài khoản");
				break;
			case "value":
				out.append("Tên đăng nhập chưa đúng yêu cầu. Vui lòng nhập lại!");
				break;
			case "loginfail":
				out.append("Có lỗi trong quá trình đăng nhập!");
				break;
			case "nopermiss":
				out.append("Tài khoản của bạn không có quyền đăng nhập hệ thống!");
				break;
			default:
				out.append("Có lỗi,vui lòng kiểm tra lại");
			}
			out.append("</p>");
			out.append("<div class=\"spinner-border text-danger\" role=\"status\">");
			out.append("<span class=\"visually-hidden\">Loading...</span>");
			out.append("</div><!-- End Border spinner -->");
			out.append("</div>");
			out.append("</div>");
			out.append("</div>");

			// script
			out.append("<script language=\"javascript\" >");
			out.append("const viewToast = document.getElementById('liveToast');");
			out.append("const toast = new bootstrap.Toast(viewToast);");
			out.append("toast.show();");
			out.append("</script>");
		}

		out.append("<div class=\"d-flex justify-content-center py-2 py-2\">");
		out.append("<a href=\"/adv/view\" class=\"logo d-flex flex-column align-items-center w-auto\">");
		out.append("<img class=\"rounded-circle\" width=\"100\" height=\"100\" src=\"/adv/adimgs/logo.jpg\" alt=\"\">");
		out.append("<span class=\"d-none d-lg-block fs-3 text-dark fw-bold\" id=\"brand\">JOBNOW</span>");
		out.append("</a>");
		out.append("</div><!-- End Logo -->");

		out.append("<div class=\"card mb-3\">");
		out.append("<div class=\"card-body\">");

		out.append("<div class=\"pt-2 pb-2\">");
		out.append("<h5 class=\"card-title text-center pb-0 fs-5 mb-2\">Đăng ký tài khoản người tìm việc</h5>");
		out.append("</div>");

		out.append("<form class=\"row g-3 needs-validation\" method=\"POST\" novalidate>");

		out.append("<div class=\"col-12\">");
		out.append("<label for=\"yourUsername\" class=\"form-label\"><i class=\"bi bi-person-circle me-2\"></i>Tên tài khoản</label>");
		out.append(
				"<input \" type=\"text\" class=\"form-control\" name=\"txtName\" id=\"name\">");
		out.append("<div id=\"errName\"></div>");
		out.append("</div>");
		
		out.append("<div class=\"col-12\">");
		out.append("<label for=\"fullname\" class=\"form-label\"><i class=\"bi bi-person-bounding-box me-2\"></i>Tên đầy đủ</label>");
		out.append(
				"<input \" type=\"text\" class=\"form-control\" name=\"txtFullname\" id=\"fullname\">");
		out.append("<div id=\"errName\"></div>");
		out.append("</div>");
		
		out.append("<div class=\"col-12\">");
		out.append("<label for=\"email\" class=\"form-label\"><i class=\"bi bi-telephone-fill me-2\"></i>Hộp thư</label>");
		out.append(
				"<input \" type=\"text\" class=\"form-control\" name=\"txtEmail\" id=\"email\">");
		out.append("<div id=\"errName\"></div>");
		out.append("</div>");
		
		out.append("<div class=\"col-12\">");
		out.append("<label for=\"phone\" class=\"form-label\"><i class=\"bi bi-telephone-fill me-2\"></i>Điện thoại</label>");
		out.append(
				"<input \" type=\"text\" class=\"form-control\" name=\"txtPhone\" id=\"phone\">");
		out.append("<div id=\"errName\"></div>");
		out.append("</div>");

		out.append("<div class=\"col-12\">");
		out.append("<label for=\"yourPassword\" class=\"form-label\"><i class=\"bi bi-lock me-2\"></i>Mật Khẩu</label>");
		out.append(
				"<input  type=\"password\" class=\"form-control\" name=\"txtPass\" id=\"pass\">");
		out.append("<div id=\"errPass\"></div>");
		out.append("</div>");
		
		out.append("<div class=\"col-12\">");
		out.append("<label for=\"confirmPassword\" class=\"form-label\"><i class=\"bi bi-lock me-2\"></i>Nhập lại Mật Khẩu</label>");
		out.append(
				"<input  type=\"password\" class=\"form-control\" name=\"txtConfirmPassword\" id=\"confirmPassword\">");
		out.append("<div id=\"errPass\"></div>");
		out.append("</div>");

		out.append("<div class=\"col-12\">");
		out.append(
				"<button class=\"btn btn-primary w-100\" id=\"btn-login\" type=\"submit\"><span class=\"spinner-border spinner-border-sm\" role=\"status\" aria-hidden=\"true\"></span>&nbsp;Đăng ký</button>");
		out.append("</div>");
		out.append("<div class=\"col-12\">");
		out.append("<p class=\"small mb-0\">Bạn đã có tài khoản <a href=\"/home\">đăng nhập ngay</a></p>");
		out.append("</div>");
		out.append("</form>");

		out.append("</div>");
		out.append("</div>");

		out.append("<div class=\"credits text-white\">");
		out.append("<!-- All the links in the footer should remain intact. -->");
		out.append("<!-- You can delete the links only if you purchased the pro version. -->");
		out.append("<!-- Licensing information: https://bootstrapmade.com/license/ -->");
		out.append(
				"<!-- Purchase the pro version with working PHP/AJAX contact form: https://bootstrapmade.com/nice-admin-bootstrap-admin-html-template/ -->");
		out.append("Thiết kế bởi <a class='text-white' href=\"https://bootstrapmade.com/\">Phan Kim Sinh</a>");
		out.append("</div>");

		out.append("</div>");
		out.append("</div>");
		out.append("</div>");

		out.append("</section>");

		out.append("</div>");
		out.append("</main><!-- End #main -->");

		out.append("<script src=\"/adv/adjavascript/bootstrap.bundle.min.js\"></script>");
		out.append("</body>");
		out.append("</html>");
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
		String username = request.getParameter("txtName");
		String fullname = request.getParameter("txtFullname");
		String userpass = request.getParameter("txtPass");
		String email = request.getParameter("txtEmail");
		String phone = request.getParameter("txtPhone");
		String userconfirmpass = request.getParameter("txtConfirmPassword"); 
		System.out.println(username+fullname+email+phone+userconfirmpass);
		if (username != null && userpass != null && userconfirmpass!=null && phone!=null && email!=null && fullname!=null) {
			username = username.trim();
			userpass = userpass.trim();
			userconfirmpass= userconfirmpass.trim();
			phone= phone.trim();
			fullname= fullname.trim();
			email = email.trim();

			if (userpass.equalsIgnoreCase(userconfirmpass) && !username.equalsIgnoreCase("") && !userpass.equalsIgnoreCase("") && !userconfirmpass.equalsIgnoreCase("") && !fullname.equalsIgnoreCase("") && !phone.equalsIgnoreCase("") && !email.equalsIgnoreCase("")) {
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
				ClientObject newUser = new ClientObject();
				newUser.setUser_name(username);
				newUser.setUser_fullname(jsoft.library.Utilities.encode(fullname));
				newUser.setUser_pass(userpass);
				newUser.setUser_permission((byte)1);
				newUser.setUser_homephone(phone);
				newUser.setUser_address(jsoft.library.Utilities.encode(""));
				newUser.setUser_email(email);
				newUser.setUser_avatar("default.jpg");
				newUser.setUser_parent_id(20);
				newUser.setUser_created_date(jsoft.library.Utilities_date.getDate());
				newUser.setClient_profiles("");
				newUser.setClient_career_goals("");
				Boolean signup = uc.signup(newUser);
				// Trả về kết nối
				uc.releaseConnection();
				// Tham chiếu phiên làm việc
				
				if (signup) {
					response.sendRedirect("/home");
				} else {
					response.sendRedirect("/home/client/signup?err=loginfail");
				}

			} else {
				response.sendRedirect("/home/client/signup?err=value");
			}

		} else {
			response.sendRedirect("/home/client/signup?err=param");

		}
	}

}
