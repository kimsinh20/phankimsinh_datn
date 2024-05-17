package jsoft.ads.job;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.javatuples.Quartet;
import org.javatuples.Triplet;

import com.google.gson.Gson;

import jsoft.ConnectionPool;
import jsoft.objects.AddressObject;
import jsoft.objects.CompanyObject;
import jsoft.objects.JobObject;
import jsoft.objects.SkillObject;
import jsoft.objects.UserObject;

/**
 * Servlet implementation class SectionEdit
 */
@WebServlet("/job/view")
public class JobView extends HttpServlet {
	private static final long serialVersionUID = 1L;
	// định nghĩa kiểu nội dung xuất về trình khách
	private static final String CONTENT_TYPE = "text/html; charset=utf-8";

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public JobView() {
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

		JobObject job = null;
		HashMap<Integer, String> author_name = new HashMap<>();
		ArrayList<SkillObject> skills = null;
		ArrayList<UserObject> clients =  null;

		if (id > 0) {
			// tìm bộ quản lý kết nối
			ConnectionPool cp = (ConnectionPool) getServletContext().getAttribute("CPool");
			// tạo đối tượng thực thi chức năng
			JobControl cc = new JobControl(cp);
			if (cp == null) {
				getServletContext().setAttribute("CPool", cp);
			}
			Quartet<JobObject, HashMap<Integer, String>,ArrayList<SkillObject>,ArrayList<UserObject>> data = cc.getJobObject(id, user);
			job = data.getValue0();
			author_name = data.getValue1();
			skills = data.getValue2();
			clients = data.getValue3();
			

			// trả về kết nối
			cc.releaseConnection();
		}
		String job_title = "", job_work_time = "", job_level = "", job_salary = "", job_gender = "";
		String job_degree = "", job_experience = "", job_status = "",job_location="";
		CompanyObject company = null;
		AddressObject location=null;
		if (job != null) {
			company = job.getCompany();
			job_title = job.getJob_title();
			
			switch (job.getJob_work_time()) {
			case 1:
				job_work_time = "Toàn thời gian Thứ 2 - Thứ 6";
				break;
			case 2:
				job_work_time = "Bán thời gian (Tối thiểu 6 buổi/tuần)";
				break;
			case 3:
				job_work_time = "Thực tập (Part time hoặc Full time)";
				break;
			case 4:
				job_work_time = "Việc làm online";
				break;
			case 5:
				job_work_time = "Nghề tự do";
				break;
			case 6:
				job_work_time = "Hợp đồng thời vụ";
				break;
			case 7:
				job_work_time = "Khác";
				break;
			default:
				job_work_time = "Lựa chọn không hợp lệ";
			}
			
			switch (job.getJob_level()) {
			case 1:
				job_level = "Nhân viên chính thức";
				break;
			case 2:
				job_level = "Nhân viên thử việc";
				break;
			case 3:
				job_level = "Quản lí";
				break;
			case 4:
				job_level = "Thực tập sinh/Sinh viên";
				break;
			case 5:
				job_level = "Trưởng nhóm";
				break;
			case 6:
				job_level = "Trưởng phòng";
				break;
			case 7:
				job_level = "Giám đốc và cấp cao hơn";
				break;
			case 8:
				job_level = "Mới tốt nghiệp";
				break;
			case 9:
				job_level = "Khác";
				break;
			default:
				job_level = "Lựa chọn không hợp lệ";
			}
			
			switch (job.getJob_salary()) {
			case 1:
				job_salary = "3 triệu đến 5 triệu";
				break;
			case 2:
				job_salary = "5 triệu đến 7 triệu";
				break;
			case 3:
				job_salary = "7 triệu đến 10 triệu";
				break;
			case 4:
				job_salary = "10 triệu đến 15 triệu";
				break;
			case 5:
				job_salary = "15 triệu đến 30 triệu";
				break;
			case 6:
				job_salary = "Trên 30 triệu";
				break;
			case 7:
				job_salary = "Trên 50 triệu";
				break;
			case 8:
				job_salary = "Không lương";
				break;
			case 9:
				job_salary = "Thương lượng";
				break;
			case -1:
				job_salary = "-- Vui lòng chọn --";
				break;
			default:
				job_salary = "Lựa chọn không hợp lệ";
			}
			
			switch (job.getJob_gender()) {
			case 1:
				job_gender = "Nam";
				break;
			case 2:
				job_gender = "Nữ";
				break;
			case 3:
				job_gender = "Không yêu cầu";
				break;
			default:
				job_gender = "Lựa chọn không hợp lệ";
			}
			
			switch (job.getJob_degree()) {
			case 1:
				job_degree = "Trung học";
				break;
			case 2:
				job_degree = "Trung cấp";
				break;
			case 3:
				job_degree = "Cao đẳng";
				break;
			case 4:
				job_degree = "Cử nhân";
				break;
			case 5:
				job_degree = "Thạc sĩ";
				break;
			case 6:
				job_degree = "Tiến sĩ";
				break;
			case 7:
				job_degree = "Không yêu cầu";
				break;
			default:
				job_degree = "Lựa chọn không hợp lệ";
			}
			switch (job.getJob_experience_id()) {
			case 11:
				job_experience = "Khác";
				break;
			case 12:
				job_experience = "Không yêu cầu";
				break;
			default:
				if (job.getJob_experience_id() >= 1 && job.getJob_experience_id() <= 10) {
					job_experience = job.getJob_experience_id() + " Năm";
				} else {
					job_experience = "Lựa chọn không hợp lệ";
				}
			}

			switch (job.getJob_status()) {
			case 0:
				job_status = "Đang chờ phê duyệt";
				break;
			case 1:
				job_status = "Đang tuyển dụng";
				break;
			case 2:
				job_status = "Đã hết hạn";
				break;
			case 3:
				job_status = "Đã tuyển dụng";
				break;
			case 4:
				job_status = "Tạm ngưng tuyển dụng";
				break;
			case 5:
				job_status = "Đã hủy";
				break;
			default:
				job_status = "Trạng thái không hợp lệ";
			}
           if(job.getJob_location().equalsIgnoreCase("1")) {
        	   job_location = "Làm việc trực tuyến";
           } else if(job.getJob_location().equalsIgnoreCase("2")) {
        	   job_location = "Làm việc ở nước ngoài";
           } else {
        	 Gson gson = new Gson();
  			 location = gson.fromJson(job.getJob_location(), AddressObject.class);
        	 job_location=location.getAddressDetail()+", "+location.getWards()+", "+location.getDistricts()+", " +location.getProvinces();
           }
           
		}

		// tham chiếu tìm header
		RequestDispatcher h = request.getRequestDispatcher("/header?pos=jblist");
		if (h != null) {
			h.include(request, response);
		}

		out.append("<main id=\"main\" class=\"main\">");

		RequestDispatcher error = request.getRequestDispatcher("/error");
		if (error != null) {
			error.include(request, response);
		}

		out.append("<div class=\"pagetitle d-flex\">");
		out.append("<h1>Thông tin chi tiết tin tuyển dụng</h1>");
		out.append("<nav class=\"ms-auto\">");
		out.append("<ol class=\"breadcrumb\">");
		out.append("<li class=\"breadcrumb-item\"><a href=\"/adv/view\"><i class=\"bi bi-house\"></i></a></li>");
		out.append("<li class=\"breadcrumb-item\">Tin tuyển dụng</li>");
		out.append("<li class=\"breadcrumb-item active\">Cập nhật chi tiết</li>");
		out.append("</ol>");
		out.append("</nav>");
		out.append("</div><!-- End Page Title -->");

		out.append("<section class=\"section profile\">");
		out.append("<div class=\"row\">");
		out.append("<div class=\"col-xl-4\">");
		if (job != null) {
			out.append("<div class=\"card\" style=\"background-image: url('" + company.getCompany_banner()
					+ "'); opacity: 0.7; width: 100%;\">");
			out.append("<div class=\"card-body profile-card pt-4 d-flex flex-column align-items-center\">");
			out.append("<img src=\"" + company.getCompany_logo() + "\" alt=\"Profile\" class=\"rounded-circle\">");
			out.append("<h2 class='text-dark text-center'>" + company.getCompany_name() + "</h2>");
			out.append("<div class=\"social-links mt-2\">");
			out.append("<a href=\"#\" class=\"twitter text-dark\"><i class=\"bi bi-twitter\"></i></a>");
			out.append("<a href=\"#\" class=\"facebook text-dark\"><i class=\"bi bi-facebook\"></i></a>");
			out.append("<a href=\"#\" class=\"instagram text-dark\"><i class=\"bi bi-instagram\"></i></a>");
			out.append("<a href=\"#\" class=\"linkedin text-dark\"><i class=\"bi bi-linkedin\"></i></a>");
			out.append("</div>");
			out.append("</div>");
			out.append("</div>");
		}
		out.append("</div>"); // end cod-xl-4

		out.append("<div class=\"col-xl-8\">");

		out.append("<div class=\"card\">");
		out.append("<div class=\"card-body pt-3\">");
		out.append("<!-- Bordered Tabs -->");
		out.append("<ul class=\"nav nav-tabs nav-tabs-bordered\">");

		out.append("<li class=\"nav-item\">");
		out.append(
				"<button class=\"nav-link active\" data-bs-toggle=\"tab\" data-bs-target=\"#overview\"><i class=\"fas fa-info-circle me-1\"></i>Tổng quát</button>");
		out.append("</li>");
		out.append("<li class=\"nav-item\">");
		out.append(
				"<button class=\"nav-link\" data-bs-toggle=\"tab\" data-bs-target=\"#listapp\"><i class=\"fas fa-users me-1\"></i>Danh sách ứng tuyển ("+clients.size()+")</button>");
		out.append("</li>");
		out.append("</ul>");
		out.append("<div class=\"tab-content pt-2\">");

		// tab tong quat

		out.append("<div class=\"tab-pane fade show active profile-overview\" id=\"overview\">");

		out.append("<h5 class=\"card-title\">Chi tiết<i class=\"fas fa-info-circle ms-2\"></i></h5>");

		out.append("<div class=\"row\">");
		out.append("<div class=\"col-lg-3 col-md-4 label \">Tiêu đề tin</div>");
		out.append("<div class=\"col-lg-6 col-md-5\">" + job_title + "</div>");
		out.append("</div>");

		out.append("<div class=\"row\">");
		out.append("<div class=\"col-lg-3 col-md-4 label\">Tình trạng</div>");
		out.append("<div class=\"col-lg-9 col-md-8\">" + job_status + "</div>");
		out.append("</div>");

		out.append("<div class=\"row\">");
		out.append("<div class=\"col-lg-3 col-md-4 label\">Ngày đăng tin</div>");
		out.append("<div class=\"col-lg-9 col-md-8\">" + job.getJob_created_date() + "</div>");
		out.append("</div>");

		out.append("<div class=\"row\">");
		out.append("<div class=\"col-lg-3 col-md-4 label\">Ngày hết hạn</div>");
		out.append("<div class=\"col-lg-9 col-md-8\">"
				+ jsoft.library.Utilities_date.getDateFomat(job.getJob_expiration_date()) + "</div>");
		out.append("</div>");

		out.append("<div class=\"row\">");
		out.append("<div class=\"col-lg-3 col-md-4 label\">Ngành nghề</div>");
		out.append("<div class=\"col-lg-9 col-md-8\">" + job.getJob_career().getCareer_name() + "</div>");
		out.append("</div>");

		out.append("<div class=\"row\">");
		out.append("<div class=\"col-lg-3 col-md-4 label \">Địa chỉ</div>");
		out.append("<div class=\"col-lg-9 col-md-8\">");
        out.append(job_location);
		out.append("</div>");
		out.append("</div>");

		out.append("<div class=\"row\">");
		out.append("<div class=\"col-lg-3 col-md-4 label\">Số lượng</div>");
		out.append("<div class=\"col-lg-9 col-md-8\">" + job.getJob_quantity() + "</div>");
		out.append("</div>");

		out.append("<div class=\"row\">");
		out.append("<div class=\"col-lg-3 col-md-4 label\">Vị trí / Chức vụ</div>");
		out.append("<div class=\"col-lg-9 col-md-8\">" + job_level + "</div>");
		out.append("</div>");

		out.append("<div class=\"row\">");
		out.append("<div class=\"col-lg-3 col-md-4 label\">Thời gian / Hình thức</div>");
		out.append("<div class=\"col-lg-9 col-md-8\">" + job_work_time + "</div>");
		out.append("</div>");

		out.append("<div class=\"row\">");
		out.append("<div class=\"col-lg-3 col-md-4 label\">Lương & Trợ cấp</div>");
		out.append("<div class=\"col-lg-9 col-md-8\">" + job_salary + "</div>");
		out.append("</div>");

		out.append("<div class=\"row\">");
		out.append("<div class=\"col-lg-3 col-md-4 label\">Giới tính</div>");
		out.append("<div class=\"col-lg-9 col-md-8\">" + job_gender + "</div>");
		out.append("</div>");

		out.append("<div class=\"row\">");
		out.append("<div class=\"col-lg-3 col-md-4 label\">Bằng cấp</div>");
		out.append("<div class=\"col-lg-9 col-md-8\">" + job_degree + "</div>");
		out.append("</div>");
		
	    String[] skillIdArray = job.getJob_skills().split(",");
	    // Tạo mảng chứa tên các skill có id trùng khớp
        List<String> skillNames = new ArrayList<>();
        for (String skillId : skillIdArray) {
            int skill_id = Integer.parseInt(skillId);
            for (SkillObject skill : skills) {
                if (skill.getSkill_id() == skill_id) {
                    skillNames.add(skill.getSkill_name());
                    break;
                }
            }
        }
		
		out.append("<div class=\"row\">");
		out.append("<div class=\"col-lg-3 col-md-4 label\">Kĩ năng</div>");
		out.append("<div class=\"col-lg-9 col-md-8\">");
		for (String skillName : skillNames) {
            out.append(skillName+" ");
        }
		out.append("</div>");
		out.append("</div>");

		out.append("<div class=\"row\">");
		out.append("<div class=\"col-lg-3 col-md-4 label\">Khinh nghiệm làm việc</div>");
		out.append("<div class=\"col-lg-9 col-md-8\">" + job_experience + "</div>");
		out.append("</div>");

		out.append("<div class=\"row\">");
		out.append("<div class=\"col-lg-3 col-md-4 label\">Ngày chỉnh sửa gần nhất</div>");
		out.append("<div class=\"col-lg-9 col-md-8\">" + job.getJob_last_modified() + "</div>");
		out.append("</div>");

		out.append("<div class=\"row\">");
		out.append("<div class=\"col-lg-3 col-md-4 label\">Mô tả công việc</div>");
		out.append("<div class=\"col-lg-9 col-md-8\">" + jsoft.library.Utilities.decode(job.getJob_responsibility())
				+ "</div>");
		out.append("</div>");

		out.append("<div class=\"row\">");
		out.append("<div class=\"col-lg-3 col-md-4 label\">Yêu cầu công việc</div>");
		out.append(
				"<div class=\"col-lg-9 col-md-8\">" + jsoft.library.Utilities.decode(job.getJob_purpose()) + "</div>");
		out.append("</div>");

		out.append("<div class=\"row\">");
		out.append("<div class=\"col-lg-3 col-md-4 label\">Phúc lợi</div>");
		out.append(
				"<div class=\"col-lg-9 col-md-8\">" + jsoft.library.Utilities.decode(job.getJob_Welfare()) + "</div>");
		out.append("</div>");

		out.append("<div class=\"row\">");
		out.append("<div class=\"col-lg-3 col-md-4 label\">Người tạo </div>");
		out.append("<div class=\"col-lg-9 col-md-8\">" + author_name.get(job.getJob_author_id()) + "</div>");
		out.append("</div>");

		out.append("<div class=\"row\">");
		out.append("<div class=\"col-lg-3 col-md-4 label\">Đánh giá </div>");
		out.append(
				"<div class=\"col-lg-9 col-md-8\">" + "4.4 <i class=\"fa-solid fa-star text-warning\"></i>" + "</div>");
		out.append("</div>");

		out.append("<div class=\"row\">");
		out.append("<div class=\"col-lg-3 col-md-4 label\">Lượt xem</div>");
		out.append("<div class=\"col-lg-9 col-md-8\">" + 2 + "</div>");
		out.append("</div>");

		out.append("<div class=\"row\">");
		out.append("<div class=\"col-lg-3 col-md-4 label\">Lượt theo dõi</div>");
		out.append("<div class=\"col-lg-9 col-md-8\">" + 201 + "</div>");
		out.append("</div>");

		out.append("</div>"); // tab-pane
		
		out.append("<div class=\"tab-pane fade profile-edit pt-3\" id=\"listapp\">");
		out.append("<h5 class=\"text-center\">Danh sách các ứng viên</h5>");
		out.append("<div class=\"container\">");
		if(clients.size()<=0) {
			out.append("<p class=\"text-center py-2\"> Danh sách rỗng</p>");
		}
		for (int i = 0; i < clients.size(); i++) {
			UserObject client = clients.get(i);
			
			
		if (i % 2 == 0) {
		out.append("<div class=\"row mt-4\">");
		}
		out.append("<div class=\"col-lg-6 col-md-6\">");
		
		out.append("<div class=\"card mb-4\">");
		out.append("<div class=\"card-body\">");
		out.append("<div class=\"d-flex flex-column align-items-center pt-4\">");
		out.append("<img class=\"shadow rounded-circle\" src=\""+client.getUser_avatar()+"\" width=\"80\" height=\"80\" alt=\"\" />");
		out.append("<a href=\"/adv/user/profiles?id="+client.getUser_id()+"&view\" class=\"card-title font-weight-bold text-decoration-none me-3\">"+client.getUser_fullname()+"</a>");
		out.append("</div>");
		
		out.append("</div>");
		out.append("</div>");//end card body
		out.append("</div>");//end col
		 if ((i + 1) % 2 == 0 || (i + 1) == clients.size()) {
			  out.append("</div>");//end row
		  }
		}
		out.append("</div>"); // end container
		out.append("</div>"); // tab-pane
		
		out.append("</div><!-- End Bordered Tabs -->");

		out.append("</div>");
		out.append("</div>");

		out.append("</div>");

		out.append("</div>");
		out.append("</section>");

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

	}

}
