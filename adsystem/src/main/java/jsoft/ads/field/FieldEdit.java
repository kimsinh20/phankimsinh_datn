package jsoft.ads.field;

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

import org.javatuples.Pair;

import jsoft.ConnectionPool;
import jsoft.objects.FieldObject;
import jsoft.objects.UserObject;

/**
 * Servlet implementation class FieldEdit
 */
@WebServlet("/field/edit")
public class FieldEdit extends HttpServlet {
	private static final long serialVersionUID = 1L;
	// định nghĩa kiểu nội dung xuất về trình khách
	private static final String CONTENT_TYPE = "text/html; charset=utf-8";

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FieldEdit() {
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
		String view =request.getParameter("view");
		boolean isView = (view!=null)?true:false;
		
		FieldObject editField = null;
		HashMap<Integer, String> author_name = new HashMap<>();
		
		if (id > 0) {
			// tìm bộ quản lý kết nối
			ConnectionPool cp = (ConnectionPool) getServletContext().getAttribute("CPool");
			// tạo đối tượng thực thi chức năng
			FieldControl uc = new FieldControl(cp);
			if (cp == null) {
				getServletContext().setAttribute("CPool", cp);
			}
			Pair<FieldObject, HashMap<Integer, String>> getFieldObject = uc.getFieldObject(id, user);
			editField = getFieldObject.getValue0();
			author_name = getFieldObject.getValue1();

			// trả về kết nối
			uc.releaseConnection();
		}

		// tham chiếu tìm header
		RequestDispatcher h = request.getRequestDispatcher("/header?pos=fllist");
		if (h != null) {
			h.include(request, response);
		}

		out.append("<main id=\"main\" class=\"main\">");

		RequestDispatcher error = request.getRequestDispatcher("/error");
		if (error != null) {
			error.include(request, response);
		}

		out.append("<div class=\"pagetitle d-flex\">");
		out.append("<h1>Hồ sơ lĩnh vực</h1>");
		out.append("<nav class=\"ms-auto\">");
		out.append("<ol class=\"breadcrumb\">");
		out.append("<li class=\"breadcrumb-item\"><a href=\"/adv/view\"><i class=\"bi bi-house\"></i></a></li>");
		out.append("<li class=\"breadcrumb-item\">lĩnh vực</li>");
		out.append("<li class=\"breadcrumb-item active\">Cập nhật chi tiết</li>");
		out.append("</ol>");
		out.append("</nav>");
		out.append("</div><!-- End Page Title -->");

		out.append("<Field class=\"Field profile\">");
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
		String FieldName = "", setionNotes = "", FieldCreatedDate = "", FieldLastmodify = "", userAuthor = "",FieldStatus="";
		boolean isEdit = false;
		if (editField != null) {
			FieldName = editField.getField_name() != null ? editField.getField_name() : "";
			setionNotes = editField.getField_notes() != null ? editField.getField_notes() : "";
			FieldCreatedDate = editField.getField_created_date() != null ? editField.getField_created_date() : "";
			FieldLastmodify = editField.getField_last_modified() != null ? editField.getField_last_modified() : "";
			userAuthor = author_name.get(editField.getField_author_id()) != null ? author_name.get(editField.getField_author_id()) : "";
			FieldStatus = editField.isField_delete() ? "Đã xóa !!! Sao lưu trong thùng rác" : "";
			isEdit = true;
		}

		out.append("<div class=\"tab-pane fade show active profile-overview\" id=\"overview\">");

		out.append("<div class=\"row mt-3\">");
		out.append("<div class=\"col-lg-3 col-md-4 label \">Tên lĩnh vực</div>");
		out.append("<div class=\"col-lg-6 col-md-5\">" + FieldName + "</div>");
		out.append("</div>");

		out.append("<div class=\"row\">");
		out.append("<div class=\"col-lg-3 col-md-4 label\">Ghi chú</div>");
		out.append("<div class=\"col-lg-9 col-md-8\">" + setionNotes + "</div>");
		out.append("</div>");

		out.append("<div class=\"row\">");
		out.append("<div class=\"col-lg-3 col-md-4 label\">Ngày tạo</div>");
		out.append("<div class=\"col-lg-9 col-md-8\">" + FieldCreatedDate + "</div>");
		out.append("</div>");
		
		out.append("<div class=\"row\">");
		out.append("<div class=\"col-lg-3 col-md-4 label\">Ngày cập nhật</div>");
		out.append("<div class=\"col-lg-9 col-md-8\">" + FieldLastmodify + "</div>");
		out.append("</div>");


		out.append("<div class=\"row\">");
		out.append("<div class=\"col-lg-3 col-md-4 label\">Tình trạng</div>");
		out.append("<div class=\"col-lg-9 col-md-8\">" + FieldStatus + "</div>");
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
		out.append("<label for=\"FieldName\" class=\"col-md-3 col-lg-2 col-form-label\">Tên lĩnh vực</label>");
		out.append("<div class=\"col-md-9 col-lg-10\">");
		out.append("<div class=\"input-group\">");
		out.append("<input name=\"txtFieldName\" type=\"text\" class=\"form-control\" id=\"FieldName\" value=\""
				+ FieldName + "\">");
		out.append("</div>");
		out.append("</div>");
		out.append("</div>");

		out.append("<div class=\"row mb-3 align-items-center\">");
		out.append("<label for=\"FieldNotes\" class=\"col-md-3 col-lg-2 col-form-label\">Ghi chú</label>");
		out.append("<div class=\"col-md-9 col-lg-10\">");
		out.append("<textarea name=\"txtFieldNotes\" class=\"form-control\" id=\"FieldNotes\" style=\"height: 100px\">" + setionNotes
				+ "</textarea>");
		 out.append("<script>");
		  out.append("var editor = CKEDITOR.replace(\"FieldNotes\");");
		  out.append("CKFinder.setupCKEditor(editor,\"/adv/ckfinder/\")");
		  out.append("</script>");
		out.append("</div>");
		out.append("</div>");


		// truyen id theo co che bien trong an de thuc hien edit
		if (id > 0 && isEdit && page>0) {
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
		out.append("</Field>");

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
				UserObject user = (UserObject) request.getSession().getAttribute("userLogined");

				// thiết lập tập ký tự cần lấy
				request.setCharacterEncoding("utf-8");

				// lay id

				short id = jsoft.library.Utilities.getShortParam(request, "idForPost");
				short page = jsoft.library.Utilities.getShortParam(request, "page");
				String action = request.getParameter("act");

				if (id > 0) {
					if (action != null && action.equalsIgnoreCase("edit")) {
						// lấy thông tin
						String Field_name = request.getParameter("txtFieldName");
						String Field_notes = request.getParameter("txtFieldNotes");

						if (Field_name != null && !Field_name.equalsIgnoreCase("") && Field_notes != null && !Field_notes.equalsIgnoreCase("") ) {
							// Tạo đối tượng UserObject
							FieldObject eField = new FieldObject();
							eField.setField_id(id);
							eField.setField_name(Field_name);
							eField.setField_notes(Field_notes);
					
							eField.setField_last_modified(jsoft.library.Utilities_date.getDate());
							
							// connect db
							ConnectionPool cp = (ConnectionPool) getServletContext().getAttribute("CPool");
							FieldControl uc = new FieldControl(cp);
							if (cp == null) {
								getServletContext().setAttribute("CPool", uc.getCP());
							}

							// thuc hien chỉnh sủa
							boolean result = uc.editField(eField, FIELD_EDIT_TYPE.GENERAL);

							// tra ve ket noi
							uc.releaseConnection();

							//
							if (result) {
								response.sendRedirect("/adv/field/list?page="+page);
							} else {
								response.sendRedirect("/adv/field/list?err=edit&page="+page);
							}

						} else {
							response.sendRedirect("/adv/field/list?err=valueeadd&page="+page);
						}
					} 
				} else {
					response.sendRedirect("/adv/field/list?err=profiles&page="+page);
				}
	}

}
