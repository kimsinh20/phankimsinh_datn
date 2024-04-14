package jsoft.home.company;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.javatuples.Pair;
import org.javatuples.Quartet;
import org.javatuples.Quintet;
import org.javatuples.Triplet;

import com.google.gson.Gson;

import jsoft.ConnectionPool;
import jsoft.objects.AddressObject;
import jsoft.objects.ArticleObject;
import jsoft.objects.CareerObject;
import jsoft.objects.CompanyObject;
import jsoft.objects.FieldObject;
import jsoft.objects.JobObject;
import jsoft.objects.SkillObject;

/**
 * Servlet implementation class JobFields
 */
@WebServlet("/company/detail")
public class CompanyDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String CONTENT_TYPE = "text/html; charset=utf-8";

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CompanyDetail() {
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
		response.setContentType(CONTENT_TYPE);
		request.setCharacterEncoding("UTF-8");
		short id = -1;
		try {
			if (jsoft.library.Utilities.getShortParam(request, "id") > 0) {
				 id = jsoft.library.Utilities.getShortParam(request, "id");
			} 
		} catch (Exception e) {
			response.sendRedirect("/home/err");
		}
		
		System.out.println("id"+id);
		if (id > 0) {
			// tìm bộ quản lý kết nối
			ConnectionPool cp = (ConnectionPool) getServletContext().getAttribute("CPool");

			if (cp == null) {
				getServletContext().setAttribute("CPool", cp);
			}
			// tạo đối tượng thực thi chức năng

			CompanyControl jc = new CompanyControl(cp);
			Quartet<JobObject, HashMap<Integer, String>,ArrayList<JobObject>,ArrayList<ArticleObject>> data = jc.getCompanyObject(id);
			
			JobObject job = data.getValue0();
			HashMap<Integer, String> skills = data.getValue1();
			String job_title = "", job_work_time = "", job_level = "", job_salary = "", job_gender = "";
			String job_degree = "", job_experience = "",job_skills="",company_size="", job_status = "",job_location="",job_province="";
			CompanyObject company = null;
			AddressObject location=null;
			String date="";
			if (job != null) {
				long date_count = jsoft.library.Utilities_date.getminusDay(jsoft.library.Utilities_date.getDateForJs(job.getJob_expiration_date()));
				 if(date_count<0) {
		    		 date = "<span class=\"inline-block text-md text-false\">Hết hạn "+Math.abs(date_count)+" ngày</span>";
		    	 } else if(date_count==0) {
		    		 date = "<span class=\"inline-block text-md text-true\">Hôm nay</span>";
		    	 }else {
		    		 date = "<span class=\"inline-block text-md text-true\">Còn "+Math.abs(date_count)+" ngày</span>";
		    	 }
				
				
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
	        	   job_province= "Làm việc trực tuyến";
	           } else if(job.getJob_location().equalsIgnoreCase("2")) {
	        	   job_location = "Làm việc ở nước ngoài";
	        	   job_province = "Làm việc ở nước ngoài";
	           } else {
	        	 Gson gson = new Gson();
	        	 location = gson.fromJson(job.getJob_location(), AddressObject.class);
	        	 job_location=location.getAddressDetail()+", "+location.getWards()+", "+location.getDistricts()+", " +location.getProvinces();
	        	 job_province = location.getProvinces();
	           }
	           
	       	switch (job.getCompany().getCompany_size()) {
			case 0:
				company_size = "Dưới 100 người";
				break;
			case 1:
				company_size = "100 đến 500 người";
				break;
			case 2:
				company_size = "500 trên đến 1000 người";
				break;
			case 3:
				company_size = "Trên 1000 người";
				break;
			case 4:
				company_size = "Trên 5000 người";
				break;
			case 5:
				company_size = "Trên 10000 người";
				break;
			default:
				throw new IllegalArgumentException("Unexpected value: ");
			}
	       	String skill = job.getJob_skills();
	    	if(skill!=null && !skill.equalsIgnoreCase("")) {
	    		String[] idSkill = skill.split(",");
	    		for (String idStr : idSkill) {
	    		    int skill_id = Integer.parseInt(idStr);
	    		    if (skills.containsKey(skill_id)) {
	    		        String name = skills.get(skill_id);
	    		        if(name!=null&&!name.equalsIgnoreCase("")) {
	    			    	 job_skills+="<span class=\"bg-slate-100 dark:bg-slate-800 inline-block text-slate-900 dark:text-slate-300 text-xs px-2.5 py-0.5 font-semibold rounded-full me-1\">"+name+"</span>"; 
	    		        }
	    		    }
	    		}
	    	}
	       	
			}
			request.setAttribute("job", data.getValue0());
			request.setAttribute("skills", data.getValue1());
			request.setAttribute("jobs", data.getValue2());
			request.setAttribute("articles", data.getValue3());
			request.setAttribute("job_work_time", job_work_time);
			request.setAttribute("job_experience", job_experience);
			request.setAttribute("job_gender", job_gender);
			request.setAttribute("job_level", job_level);
			request.setAttribute("job_location", job_location);
			request.setAttribute("job_province", job_province);
			request.setAttribute("job_salary", job_salary);
			request.setAttribute("job_status", job_status);
			request.setAttribute("job_skills", job_skills);
			request.setAttribute("job_degree", job_degree);
			request.setAttribute("date_count", date);
			request.setAttribute("company_size", company_size);
			
			// trả về kết nối
			// trả về kết nối
			jc.releaseConnection();
			request.getRequestDispatcher("/company/detail.jsp").forward(request, response);
		} else {
			response.sendRedirect("/home/err");
		}
		
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
