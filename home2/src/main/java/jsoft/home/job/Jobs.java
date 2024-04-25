package jsoft.home.job;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.javatuples.Pair;
import org.javatuples.Triplet;

import jsoft.ConnectionPool;
import jsoft.library.ORDER;
import jsoft.objects.CareerObject;
import jsoft.objects.JobObject;
import jsoft.objects.UserObject;

/**
 * Servlet implementation class Jobs
 */
@WebServlet("/jobs/")
public class Jobs extends HttpServlet {
	private static final long serialVersionUID = 1L;
	// định nghĩa kiểu nội dung xuất về trình khách
	private static final String CONTENT_TYPE = "text/html; charset=utf-8";

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Jobs() {
		super();
		// TODO Auto-generated constructor stub
	}

	public boolean isCheck(int d, int id[]) {
		if (id == null) {
			return false;
		} else {
			for (int i = 0; i < id.length; i++) {
				if (id[i] == d) {
					return true;
				}
			}
		}
		return false;
	}
	public boolean[] checkbool(int id[],String arr[]) {
		boolean[] selectedList = new boolean[arr.length + 1];
		selectedList[0] = true;

		if (id != null) {
			if (id.length <= 1 && id[0] == 0) {
				selectedList[0] = true;
			} else {
				for (int i = 1; i < arr.length + 1; i++) {
					if (isCheck(i, id)) {
						selectedList[i] = true;
					} else {
						selectedList[i] = false;
					}
				}
				boolean allChecked = true;

				for (int i = 1; i < arr.length + 1; i++) {
					if (!isCheck(i, id)) {
						allChecked = false;
						break;
					}
				}

				if (allChecked) {
					selectedList[0] = true;
				} else {
					selectedList[0] = false;
				}
			}
		}
		return selectedList;
	}
	public int [] convertToArray(String listSlr[]) {
		int[] slr = null;
		if (listSlr != null) {
			slr = new int[listSlr.length];
			for (int i = 0; i < listSlr.length; i++) {
				slr[i] = Integer.parseInt(listSlr[i]);
			}
		}
		return slr;
	}
	public String condsFilter(int arr[],JobObject similar) {
		StringBuilder sb = new StringBuilder();
		if (arr != null) {
			for (int i = 0; i < arr.length; i++) {
				if (arr[i] != 0) {
					sb.append(arr[i]);
					if (i < arr.length - 1) {
						sb.append(",");
					}
				}
			}
		}
		return sb.toString();
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

		// lay page
		int page = 1;
		if (jsoft.library.Utilities.getIntParam(request, "page") > 0) {
			page = jsoft.library.Utilities.getIntParam(request, "page");
		} else {
			page = 1;
		}

		String[] tw = request.getParameterValues("type");
		int[] id = convertToArray(tw);
		String[] jobWorkTimeArray = { "Fulltime", "PartTime", "Intern", "Remote", "Freelance", "Seasonal contracts",
				"other" };
		boolean[] selectedList = checkbool(id, jobWorkTimeArray);
				
				
		String[] listSlr = request.getParameterValues("salary");
		int[] slr = convertToArray(listSlr);
		String[] salaries = { "3 triệu đến 5 triệu", "5 triệu đến 7 triệu", "7 triệu đến 10 triệu",
				"10 triệu đến 15 triệu", "15 triệu đến 30 triệu", "Trên 30 triệu", "Trên 50 triệu", "Không lương",
				"Thương lượng" };
		boolean[] selectedSlr =checkbool(slr, salaries);
		
		String[] listLevel = request.getParameterValues("level");
		int[] level = convertToArray(listLevel);
		String[] levels = { "Nhân viên chính thức", "Nhân viên thử việc", "Quản lí",
				"Thực tập sinh/Sinh viên", "Trưởng nhóm", "Trưởng phòng", "Giám đốc và cấp cao hơn", "Mới tốt nghiệp",
				"Khác" };
		boolean[] selectedLevel =checkbool(level, levels);

		String url = "";
		String queryString = request.getQueryString();
		String uri = request.getRequestURI();
		if (queryString != null && !queryString.equalsIgnoreCase("")) {
			url += uri + "?" + queryString;
		}
		Pair<JOB_SOFT, ORDER> sorting = null;
		String sort = request.getParameter("sort");

		if (sort != null && !sort.equalsIgnoreCase("")) {
			switch (sort) {
			case "general":
				sorting = new Pair<JOB_SOFT, ORDER>(JOB_SOFT.GENERAL, ORDER.DESC);
				break;
			case "lasted":
				sorting = new Pair<JOB_SOFT, ORDER>(JOB_SOFT.DATE, ORDER.DESC);
				break;
			case "oldest":
				sorting = new Pair<JOB_SOFT, ORDER>(JOB_SOFT.DATE, ORDER.ASC);
				break;
			case "atoz":
				sorting = new Pair<JOB_SOFT, ORDER>(JOB_SOFT.TITLE, ORDER.ASC);
				break;
			case "ztoa":
				sorting = new Pair<JOB_SOFT, ORDER>(JOB_SOFT.TITLE, ORDER.DESC);
				break;
			default:
				sorting = new Pair<JOB_SOFT, ORDER>(JOB_SOFT.GENERAL, ORDER.DESC);
			}
		} else {
			sorting = new Pair<JOB_SOFT, ORDER>(JOB_SOFT.GENERAL, ORDER.DESC);
		}

		// lay tu khoa tim kiem
		int cr = jsoft.library.Utilities.getIntParam(request, "cr");
		int f = jsoft.library.Utilities.getIntParam(request, "f");

		String key = request.getParameter("key");
		String saveKey = (key != null && !key.equalsIgnoreCase("")) ? jsoft.library.Utilities.encode(key.trim()) : "";
		String lc = request.getParameter("lc");
		lc = (lc != null && !lc.equalsIgnoreCase("")) ? lc : "";
		// tìm bộ quản lý kết nối
		ConnectionPool cp = (ConnectionPool) getServletContext().getAttribute("CPool");

		if (cp == null) {
			getServletContext().setAttribute("CPool", cp);
		}
		// tạo đối tượng thực thi chức năng
		JobControl jc = new JobControl(cp);

		// lấy cấu trúc
		JobObject similar = new JobObject();
		similar.setJob_title(saveKey);
		similar.setJob_location(lc);
		CareerObject newC = new CareerObject();
		newC.setCareer_id(cr);
		newC.setCareer_field_id(f);
		similar.setJob_career(newC);
		
		similar.setJob_purpose(condsFilter(id, similar));
		similar.setJob_responsibility(condsFilter(slr, similar));
		similar.setJob_expiration_date(condsFilter(level,similar));

		byte pageSize = 10;
		UserObject user = (UserObject) request.getSession().getAttribute("clientLogined");
		Triplet<JobObject, Integer, Byte> infos = new Triplet<>(similar, pageSize * (page - 1), pageSize);
//        boolean checkExits = jc.isExits(f, pageSize);
		ArrayList<String> viewList = jc.viewJobPage(infos, sorting, url, page,user);
		request.setAttribute("jobtime", jobWorkTimeArray);
		request.setAttribute("selected", selectedList);
		request.setAttribute("salaries", salaries);
		request.setAttribute("selectedSlr", selectedSlr);
		request.setAttribute("levels", levels);
		request.setAttribute("selectedLevel", selectedLevel);
		request.setAttribute("viewJobs", viewList);
		// trả về kết nối
		jc.releaseConnection();
		request.getRequestDispatcher("/jobs/index.jsp").forward(request, response);

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
