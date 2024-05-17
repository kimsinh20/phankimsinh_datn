package jsoft.home.user;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Paths;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import jsoft.ConnectionPool;
import jsoft.home.job.JobControl;
import jsoft.objects.ApplicationsObject;
import jsoft.objects.JobObject;
import jsoft.objects.UserObject;

/**
 * Servlet implementation class Profile
 */
@WebServlet("/profile")
@MultipartConfig(
		fileSizeThreshold = 1024*1024*2,
		maxFileSize = 1024*1024*10,
		maxRequestSize = 1024*1024*11
		)
public class Profile extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String CONTENT_TYPE = "text/html; charset=utf-8";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Profile() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType(CONTENT_TYPE);
		request.setCharacterEncoding("UTF-8");
		String act = request.getParameter("act");
		if(act==null || act.equalsIgnoreCase("")) {
			act = "home";
		}
		UserObject user = (UserObject) request.getSession().getAttribute("clientLogined");
		if(user!=null) {
			// tìm bộ quản lý kết nối
			ConnectionPool cp = (ConnectionPool) getServletContext().getAttribute("CPool");

			if (cp == null) {
				getServletContext().setAttribute("CPool", cp);
			}
			// tạo đối tượng thực thi chức năng
			JobControl jc = new JobControl(cp);
			UserControl uc = new UserControl(cp);
			UserObject getUser = uc.getUserObject(88);
		
		ArrayList<JobObject> jobsave = jc.JobSave(user.getUser_id());
		ArrayList<ApplicationsObject> jobapply = jc.JobApply(user.getUser_id());
		request.setAttribute("jobsave", jobsave);
		request.setAttribute("jobapply", jobapply);
		request.setAttribute("user", getUser);
		request.setAttribute("act", act);
		request.getRequestDispatcher("/profile/index.jsp").forward(request, response);
		} else {
			response.sendRedirect("/home/err?e=login");
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		

		// thiết lập tập ký tự cần lấy
		request.setCharacterEncoding("utf-8");

		// lay id
		int id = jsoft.library.Utilities.getIntParam(request, "idForPost");
		String action = request.getParameter("action");
		System.out.println(action);
		System.out.println("idforpost"+id);
		if (id > 0) {
			if (action != null && action.equalsIgnoreCase("edit")) {
				// lấy thông tin
				String fullname = request.getParameter("txtFullName");
				String alias = request.getParameter("txtAlias");
				String address = request.getParameter("txtAddress");
				String job = request.getParameter("txtJob");
				String jobArea = request.getParameter("txtJobArea");
				String email = request.getParameter("txtEmail");
				String notes = request.getParameter("txtNotes");
				String birthaday = request.getParameter("txtBirthday");
				String home = request.getParameter("txtHomePhone");
				String office = request.getParameter("txtOfficePhone");
				String mobile = request.getParameter("txtMobilePhone");
				int gender = jsoft.library.Utilities.getByteParam(request, "slcGender");
				Part filePart = request.getPart("avatar");
				String avatar = "";
				String filename = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();
				InputStream io = filePart.getInputStream();
				  String path  = getServletContext().getRealPath("/")+"adimgs" + File.separator + filename;
				  
                if(jsoft.library.Utilities.saveFile(io, path)) {
                	avatar = "/adv/adimgs/"+filename;
                } 

				if (fullname != null && !fullname.equalsIgnoreCase("") && email != null && !email.equalsIgnoreCase("")
						) {
					// Tạo đối tượng UserObject
					UserObject eUser = new UserObject();
					eUser.setUser_id(id);
					eUser.setUser_fullname(jsoft.library.Utilities.encode(fullname));
					eUser.setUser_alias(alias);
					eUser.setUser_job(jsoft.library.Utilities.encode(job));
					eUser.setUser_jobarea(jsoft.library.Utilities.encode(jobArea));
					eUser.setUser_email(email);
					eUser.setUser_homephone(home);
					eUser.setUser_officephone(office);
					eUser.setUser_gender(gender);
					eUser.setUser_mobilephone(mobile);
					if (avatar != null && !avatar.equalsIgnoreCase("")) {
						eUser.setUser_avatar(avatar);
					}
					eUser.setUser_last_logined(jsoft.library.Utilities_date.getDate());
					eUser.setUser_birthday(birthaday);
					eUser.setUser_notes(jsoft.library.Utilities.encode(notes));
					eUser.setUser_address(jsoft.library.Utilities.encode(address));

					//
					ConnectionPool cp = (ConnectionPool) getServletContext().getAttribute("CPool");
					UserControl uc = new UserControl(cp);
					if (cp == null) {
						getServletContext().setAttribute("CPool", uc.getCP());
					}

					// thuc hien chỉnh sủa
					boolean result = uc.editUser(eUser, USER_EDIT_TYPE.GENERAL);

					// tra ve ket noi
					uc.releaseConnection();

					//
					if (result) {
						response.sendRedirect("/home/profile");
					} else {
						response.sendRedirect("/home/profile?err=edit");
					}

				} else {
					response.sendRedirect("/adv/user/list?err=valueeadd");
				}
			} else if (action != null && action.equalsIgnoreCase("changePass")) {
				// sua mat khau
				String currenPass = request.getParameter("currentPassword");

				if (currenPass != null && !currenPass.equalsIgnoreCase("")) {
					// tìm bộ quản lý kết nối
					ConnectionPool cp = (ConnectionPool) getServletContext().getAttribute("CPool");
					// tạo đối tượng thực thi chức năng
					UserControl uc = new UserControl(cp);
					if (cp == null) {
						getServletContext().setAttribute("CPool", cp);
					}
					UserObject userE = uc.getCheckPass(id, currenPass);
					// trả về kết nối
					uc.releaseConnection();

					if (userE != null) {
						String newPass = request.getParameter("newpassword");
						String reNewPass = request.getParameter("renewpassword");
						if (newPass != null && !newPass.equalsIgnoreCase("") && reNewPass != null
								&& !newPass.equalsIgnoreCase("") && newPass.equalsIgnoreCase(reNewPass)) {
							UserObject eUser = new UserObject();
							eUser.setUser_id(id);
							eUser.setUser_pass(newPass);
							// thuc hien doi mat khau
							if (cp == null) {
								getServletContext().setAttribute("CPool", cp);
							}
							boolean result = uc.editUser(eUser, USER_EDIT_TYPE.PASS);
//								boolean result =true;
							// trả về kết nối
							uc.releaseConnection();
							if (result) {
								response.sendRedirect("/home/user/list");
							} else {
								response.sendRedirect("/home/user/list?err=changepass&page=");
							}

						} else {
							response.sendRedirect("/home/user/list?err=valuepass&page=");
						}
					} else {
						response.sendRedirect("/home/user/list?err=passnotmatch&page=");
					}
				} else {
					response.sendRedirect("/home/user/list?err=valuepass&page=");
				}
			}
		} else {
			response.sendRedirect("/home/user/list?err=profiles");
		}
	}

}
