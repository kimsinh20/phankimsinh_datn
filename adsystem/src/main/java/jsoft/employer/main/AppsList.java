package jsoft.employer.main;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.javatuples.Pair;
import org.javatuples.Quartet;

import jsoft.ConnectionPool;
import jsoft.ads.applications.APP_SOFT;
import jsoft.ads.applications.AppControl;
import jsoft.ads.job.JOB_EDIT_TYPE;
import jsoft.ads.job.JobControl;
import jsoft.ads.user.USER_EDIT_TYPE;
import jsoft.ads.user.UserControl;
import jsoft.library.ORDER;
import jsoft.objects.ApplicationsObject;
import jsoft.objects.CareerObject;
import jsoft.objects.CompanyObject;
import jsoft.objects.JobObject;
import jsoft.objects.RecruiterObject;
import jsoft.objects.UserObject;

/**
 * Servlet implementation class CategoryList
 */
@WebServlet("/employer/apply")
public class AppsList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	// định nghĩa kiểu nội dung xuất về trình khách
	private static final String CONTENT_TYPE = "text/html; charset=utf-8";
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AppsList() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		// lay page 
		int page = 1;
		if(jsoft.library.Utilities.getIntParam(request, "page")>0) {
			page = jsoft.library.Utilities.getIntParam(request, "page");
		}
		
		
		// tìm thông tin đăng nhập
		RecruiterObject user = (RecruiterObject) request.getSession().getAttribute("employerLogined");
		
		if (user != null) {
			view(request, response, user,page);
		} else {
			response.sendRedirect("/adv/employer/login");
		}

	}

	protected void view(HttpServletRequest request, HttpServletResponse response, RecruiterObject user,int page)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// xác định kiểu nội dung xuất về trình khách
		response.setContentType(CONTENT_TYPE);

		// tạo đối tượng thực hiện xuất nội dung
		PrintWriter out = response.getWriter();

		// tìm bộ quản lý kết nối
		ConnectionPool cp = (ConnectionPool) getServletContext().getAttribute("CPool");

		if (cp == null) {
			getServletContext().setAttribute("CPool", cp);
		}
		
		// lay tu khoa tim kiem
				String key = request.getParameter("key");
				String saveKey = (key!=null && !key.equalsIgnoreCase(""))?key.trim():"";
		        saveKey = jsoft.library.Utilities.encode(saveKey);
		// tạo đối tượng thực thi chức năng
		AppControl jc = new AppControl(cp);

		// lấy cấu trúc
		ApplicationsObject similar = new ApplicationsObject();
		similar.setApplications_delete(false);
		similar.setApplications_letter(saveKey);
		JobObject j = new JobObject();
		j.setJob_company_id(user.getCompany_id());
		similar.setJob(j);

		// tim thanh so xac dinh loại danh sách
		String trash =request.getParameter("trash");
		boolean isTrash = (trash!=null)?true:false;
		String title;
		if(!isTrash) {
	        similar.setApplications_delete(false);
	   		title="Danh sách ứng tuyển";
		} else {
			title ="Danh sách ứng tuyển";
			similar.setApplications_delete(true);
		}
		
		byte pageSize = 5;
		
		Quartet<ApplicationsObject, Integer, Byte,UserObject> infos = new Quartet<>(similar,pageSize*(page-1),pageSize,user);
		
		
		ArrayList<String> viewList = jc.viewApp2(infos, new Pair<>(APP_SOFT.GENERAL, ORDER.ASC),page,saveKey,isTrash);
		
		// trả về kết nối
		jc.releaseConnection();

		
		String pos = (trash==null)?"/employer/header?pos=aplist":"/employer/header?pos=aptrash";
		
		// tham chiếu tìm header
		RequestDispatcher h = request.getRequestDispatcher(pos);
		if (h != null) {
			h.include(request, response);
		}
		RequestDispatcher s = request.getRequestDispatcher("/employer/sidebar");
		if (s != null && user !=null) {
			s.include(request, response);
		}
		out.append("<main id=\"main\" class=\"main\">");

		RequestDispatcher error = request.getRequestDispatcher("/error");
		if (error != null) {
			error.include(request, response);
		}
		
		String success = request.getParameter("success");
		if (success != null) {
			out.append("<div class=\"toast-container position-fixed top-1 end-0 ps-3 pe-5 mb-3\">");
			out.append(
					"<div id=\"liveToast\" class=\"toast\" role=\"alert\" aria-live=\"assertive\" aria-atomic=\"true\">");
			out.append("<div class=\"toast-header\">");
			// out.append("<img src=\"...\" class=\"rounded me-2\" alt=\"...\">");
			out.append("<strong class=\"me-auto text-success\">Thông báo</strong>");
			out.append("<small>10 giây</small>");
			out.append(
					"<button type=\"button\" class=\"btn-close\" data-bs-dismiss=\"toast\" aria-label=\"Close\"></button>");
			out.append("</div>");
			out.append("<div class=\"toast-body\">");
			out.append("xuất file thành công");
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

		out.append("<div class=\"pagetitle d-flex\">");
		out.append("<h1>"+title+"</h1>");
		out.append("<nav class=\"ms-auto\">");
		out.append("<ol class=\"breadcrumb\">");
		out.append("<li class=\"breadcrumb-item\"><a href=\"/adv/view\"><i class=\"bi bi-house\"></i></a></li>");
		out.append("<li class=\"breadcrumb-item\">Tin tuyển dụng</li>");
		out.append("<li class=\"breadcrumb-item active\">"+(isTrash?"Thùng rác":"Danh sách")+"</li>");
		out.append("</ol>");
		out.append("</nav>");
		out.append("</div><!-- End Page Title -->");

		
		// list user
		out.append("<section class=\"section\">");
		out.append("<div class=\"row\">");
		out.append("<div class=\"col-lg-12\">");
		out.append("<div class=\"card\">");
		out.append("<div class=\"card-body\">");
        
		if(trash==null) {
		// add user modal
			
		out.append("<div class=\"d-flex justify-content-between\">");
		out.append("<a href=\"/adv/employer/apply/export\" class=\"btn btn-warning my-4 text-white\" ><i class=\"fa-solid fa-file-export me-2\"></i>Xuất file</a>");
		out.append("<a href=\"/adv/employer/apply?trash\" class=\"btn btn-danger my-4 \" ><i class=\"fas fa-trash-restore me-2\"></i>Thùng rác</a>");
		out.append("</div><!-- End div -->");
		
		
		
		}
		// list section
		out.append(viewList.get(0));
		// phan trang
//		out.append(viewList.get(1));
		
		out.append("</div>"); // end card-body
		out.append("</div>"); // end card

		out.append("</div>"); // col-lg-12
		out.append("</div>"); // row
		out.append("</section>");

		// charts
		out.append("<div class=\"row\">");
		out.append("<div class=\"col-lg-12\">");
//		out.append(viewList.get(3));
		out.append("</div>");
		out.append("</div>");
		out.append("</main><!-- End #main -->");

		
		// tham chiếu tìm sidebar
		RequestDispatcher f = request.getRequestDispatcher("/employer/footer");
		if (f != null) {
			f.include(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	public static boolean checkValidString(String str) {
		boolean flag = true;
		if(str==null || str.equalsIgnoreCase("")) {
			flag = false;
		}
		return flag;
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		RecruiterObject userR = (RecruiterObject) request.getSession().getAttribute("employerLogined");
		String email = request.getParameter("txtemail");
		String title = request.getParameter("txttitle");
		String content = request.getParameter("txtcontent");
		System.out.println(email);
		System.out.println(title);
		System.out.println(content);
		final String senderEmail = "sinhkimphan20@gmail.com";
		final String senderPassword = "foctyundbhlygtts"; // Replace with your password
		
		// Recipient's email address
		if(checkValidString(title) && checkValidString(content) && checkValidString(email)) {
			
		// Email properties
		Properties properties = new Properties();
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.starttls.enable", "true");
		properties.put("mail.smtp.host", "smtp.gmail.com");
		properties.put("mail.smtp.port", "587");

		// Create a session with the sender's credentials
		Session session = Session.getInstance(properties, new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(senderEmail, senderPassword);
			}
		});

		try {
			// tìm bộ quản lý kết nối
			ConnectionPool cp = (ConnectionPool) getServletContext().getAttribute("CPool");
			// tạo đối tượng thực thi chức năng
			UserControl uc = new UserControl(cp);
			
			// thuc hien doi mat khau
			if (cp == null) {
				getServletContext().setAttribute("CPool", cp);
			}
			
			boolean result = true;
//			boolean result =true;
			// trả về kết nối
			uc.releaseConnection();
			// Create a new email message
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(senderEmail));
			message.setRecipient(Message.RecipientType.TO, new InternetAddress(email));
			message.setSubject(title);
			message.setText(content);

			// Send the message
			Transport.send(message);
			response.getWriter().write("Email sent successfully.");
			if (result) {
				response.sendRedirect("/adv/employer/apply?page=");
			} else {
				response.sendRedirect("/adv/employer/apply?err=sendmail?page=");
			}
		} catch (MessagingException e) {
			e.printStackTrace();
			response.getWriter().write("Email sending failed.");
			response.sendRedirect("/adv/employer/apply?err=failed?page=");
		}
		} else {
			response.sendRedirect("/adv/employer/apply?err=notvalid");
		}
	}

}
