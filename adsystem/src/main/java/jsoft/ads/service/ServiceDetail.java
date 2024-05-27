package jsoft.ads.service;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.javatuples.Triplet;

import jsoft.ConnectionPool;
import jsoft.objects.CareerObject;
import jsoft.objects.FieldObject;
import jsoft.objects.UserObject;

/**
 * Servlet implementation class fieldEdit
 */
@WebServlet("/service/view")
public class ServiceDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;
	// định nghĩa kiểu nội dung xuất về trình khách
	private static final String CONTENT_TYPE = "text/html; charset=utf-8";

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServiceDetail() {
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
		// tìm thông tin đăng nhập
		UserObject user = (UserObject) request.getSession().getAttribute("userLogined");

		if (user != null) {
			view(request, response, user);
		} else {
			response.sendRedirect("/adv/user/login");
		}
	}
	@SuppressWarnings("unlikely-arg-type")
	protected void view(HttpServletRequest request, HttpServletResponse response, UserObject user)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// xác định kiểu nội dung xuất về trình khách
		response.setContentType(CONTENT_TYPE);

		// tạo đối tượng thực hiện xuất nội dung
		PrintWriter out = response.getWriter();

		// tim id của người sử dụng đẻ cập nhập
		short id = jsoft.library.Utilities.getShortParam(request, "id");
		short page = jsoft.library.Utilities.getShortParam(request, "page");
		if(page<=0) {
			page=1;
		}
		String view =request.getParameter("view");
		boolean isView = (view!=null)?true:false;
		
		
		CareerObject editCate = null;
		ArrayList<FieldObject> fields = new ArrayList<>();
		HashMap<Integer, String> author_name = new HashMap<>();
		
		
		
		if (id > 0) {
			// tìm bộ quản lý kết nối
			ConnectionPool cp = (ConnectionPool) getServletContext().getAttribute("CPool");
			// tạo đối tượng thực thi chức năng
			ServiceControl cc = new ServiceControl(cp);
			if (cp == null) {
				getServletContext().setAttribute("CPool", cp);
			}
			Triplet<CareerObject, HashMap<Integer, String>,ArrayList<FieldObject>> getCareerObject = cc.getServiceObject(id, user);
			editCate = getCareerObject.getValue0();
			author_name = getCareerObject.getValue1();
			fields = getCareerObject.getValue2();

			// trả về kết nối
			cc.releaseConnection();
		}

		// tham chiếu tìm header
		RequestDispatcher h = request.getRequestDispatcher("/header?pos=crlist");
		if (h != null) {
			h.include(request, response);
		}

		out.append("<main id=\"main\" class=\"main\">");

		RequestDispatcher error = request.getRequestDispatcher("/error");
		if (error != null) {
			error.include(request, response);
		}

		out.append("<div class=\"pagetitle d-flex\">");
		out.append("<h1>Hồ sơ ngành nghề</h1>");
		out.append("<nav class=\"ms-auto\">");
		out.append("<ol class=\"breadcrumb\">");
		out.append("<li class=\"breadcrumb-item\"><a href=\"/adv/view\"><i class=\"bi bi-house\"></i></a></li>");
		out.append("<li class=\"breadcrumb-item\">Chuyên mục</li>");
		out.append("<li class=\"breadcrumb-item active\">Cập nhật chi tiết</li>");
		out.append("</ol>");
		out.append("</nav>");
		out.append("</div><!-- End Page Title -->");

		out.append("<field class=\"field profile\">");
		out.append("<div class=\"row\">");

		out.append("<div class=\"col-xl-12\">");

		out.append("<div class=\"card\">");
		out.append("<div class=\"card-body pt-3\">");
		out.append("<!-- Bordered Tabs -->");
		out.append("<ul class=\"nav nav-tabs nav-tabs-bordered\">");

		out.append("<li class=\"nav-item\">");
		out.append(
				"<button class=\"nav-link active\" data-bs-toggle=\"tab\" data-bs-target=\"#overview\"><i class=\"fas fa-info-circle me-1\"></i>Tổng quát</button>");
		out.append("</li>");
		if(!isView) {
		out.append("<li class=\"nav-item\">");
		out.append(
				"<button class=\"nav-link\" data-bs-toggle=\"tab\" data-bs-target=\"#edit\"><i class=\"fas fa-pen-square me-1\"></i>Chỉnh sửa</button>");
		out.append("</li>");
		}
		out.append("</ul>");
		out.append("<div class=\"tab-content pt-2\">");

		// tab tong quat
		String CareerName = "", CareerInfield="", CareerNotes = "", CareerCreatedDate = "", CareerLastmodify = "", userManager = "", userAuthor = "",CareerStatus="";
		if (editCate != null) {
			
			CareerName = editCate.getCareer_name() != null ? editCate.getCareer_name() : "";
			CareerNotes = editCate.getCareer_notes() != null ? editCate.getCareer_notes() : "";
			CareerCreatedDate = editCate.getCareer_created_date() != null ? editCate.getCareer_created_date() : "";
			CareerLastmodify = editCate.getCareer_last_modified() != null ? editCate.getCareer_last_modified() : "";
			userAuthor = author_name.get(editCate.getCareer_author_id()) != null ? author_name.get(editCate.getCareer_author_id()) : "";
			CareerInfield = editCate.getField().getField_name()!= null ? editCate.getField().getField_name() : "";
			CareerStatus = editCate.isCareer_delete() ? "Đã xóa !!! Sao lưu trong thùng rác" : "";
		}

		out.append("<div class=\"tab-pane fade show active profile-overview\" id=\"overview\">");

		out.append("<div class=\"row mt-3\">");
		out.append("<div class=\"col-lg-3 col-md-4 label \">Tên ngành nghề</div>");
		out.append("<div class=\"col-lg-6 col-md-5\">" + CareerName + "</div>");
		out.append("</div>");
		
		out.append("<div class=\"row mt-3\">");
		out.append("<div class=\"col-lg-3 col-md-4 label \">Chuyên mục</div>");
		out.append("<div class=\"col-lg-6 col-md-5\">" + CareerInfield + "</div>");
		out.append("</div>");

		out.append("<div class=\"row\">");
		out.append("<div class=\"col-lg-3 col-md-4 label\">Ghi chú</div>");
		out.append("<div class=\"col-lg-9 col-md-8\">" + CareerNotes + "</div>");
		out.append("</div>");

		out.append("<div class=\"row\">");
		out.append("<div class=\"col-lg-3 col-md-4 label\">Ngày tạo</div>");
		out.append("<div class=\"col-lg-9 col-md-8\">" + CareerCreatedDate + "</div>");
		out.append("</div>");
		
		out.append("<div class=\"row\">");
		out.append("<div class=\"col-lg-3 col-md-4 label\">Ngày cập nhật</div>");
		out.append("<div class=\"col-lg-9 col-md-8\">" + CareerLastmodify + "</div>");
		out.append("</div>");

		out.append("<div class=\"row\">");
		out.append("<div class=\"col-lg-3 col-md-4 label\">Tình trạng</div>");
		out.append("<div class=\"col-lg-9 col-md-8\">" + CareerStatus + "</div>");
		out.append("</div>");

		out.append("<div class=\"row\">");
		out.append("<div class=\"col-lg-3 col-md-4 label\">Người tạo</div>");
		out.append("<div class=\"col-lg-9 col-md-8\">" + userAuthor + "</div>");
		out.append("</div>");

		out.append("</div>");

		// tab chỉnh sửa
		out.append("<div class=\"tab-pane fade profile-edit pt-3\" id=\"edit\">");

		out.append("<!-- Profile Edit Form -->");
		out.append("<form method=\"POST\">");

		out.append("<div class=\"row mb-3 align-items-center\">");
		out.append("<label for=\"CareerName\" class=\"col-md-3 col-lg-2 col-form-label\">Tên ngành nghề</label>");
		out.append("<div class=\"col-md-9 col-lg-10\">");
		out.append("<div class=\"input-group\">");
		out.append("<input name=\"txtCareerName\" type=\"text\" class=\"form-control\" id=\"CareerName\" value=\""
				+ CareerName + "\">");
		out.append("</div>");
		out.append("</div>");
		out.append("</div>");

		out.append("<div class=\"row mb-3 align-items-center\">");
		out.append("<label for=\"fieldNotes\" class=\"col-md-3 col-lg-2 col-form-label\">Ghi chú</label>");
		out.append("<div class=\"col-md-9 col-lg-10\">");
		out.append("<textarea name=\"txtCareerNotes\" class=\"form-control\" id=\"CareerNotes\" style=\"height: 100px\">" + CareerNotes
				+ "</textarea>");
		  out.append("<script>");
		  out.append("var editor = CKEDITOR.replace(\"CareerNotes\");");
		  out.append("CKFinder.setupCKEditor(editor,\"/adv/ckfinder/\")");
		  out.append("</script>");
		out.append("</div>");
		out.append("</div>");

		 int cateInfieldId  = (editCate!=null)?editCate.getField().getField_id():1;
		 out.append("<div class=\"row mb-3 align-items-center\">");
			out.append("<label for=\"slcManager\" class=\"col-md-3 col-lg-2 col-form-label\">Lĩnh vực</label>");
			out.append("<div class=\"col-md-9 col-lg-10\">");
			out.append("<select class=\"form-select\" id=\"slcfield\" name=\"slcfield\" required>");
			fields.forEach(item->{
				if(item.getField_id()== cateInfieldId) {
					out.append("<option value=\""+item.getField_id()+"\" selected>");
				} else {
					out.append("<option value=\""+item.getField_id()+"\">");	
				}
				out.append(item.getField_name());
				out.append("</option>");
			});
			out.append("</select>");
			out.append("</div>");
			out.append("</div>");
		

		// truyen id theo co che bien trong an de thuc hien edit
		if (id > 0 && page>0) {
			out.append("<input type=\"hidden\" name=\"idForPost\" value=\"" + id + "\">");
			out.append("<input type=\"hidden\" name=\"page\" value=\"" + page + "\">");
			out.append("<input type=\"hidden\" name=\"act\" value=\"edit\">");
		}
		out.append("<div class=\"text-center\">");
		out.append(
				"<button type=\"submit\" class=\"btn btn-primary\"><i class=\"far fa-save me-2\"></i>Lưu thay đổi</button>");
		out.append("</div>");

		out.append("</form><!-- End Profile Edit Form -->");
		out.append("</div>");// end edit

		out.append("</div><!-- End Bordered Tabs -->");

		out.append("</div>");
		out.append("</div>");

		out.append("</div>");

		out.append("</div>");
		out.append("</field>");

		out.append("</main><!-- End #main -->");

		// tham chiếu tìm sidebar
		RequestDispatcher f = request.getRequestDispatcher("/footer");
		if (f != null) {
			f.include(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
			doGet(request, response);

	}

}
