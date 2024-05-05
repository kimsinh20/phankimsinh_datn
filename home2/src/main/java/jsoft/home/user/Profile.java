package jsoft.home.user;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jsoft.ConnectionPool;
import jsoft.home.job.JobControl;
import jsoft.objects.JobObject;
import jsoft.objects.UserObject;

/**
 * Servlet implementation class Profile
 */
@WebServlet("/profile")
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
			
			ArrayList<JobObject> jobsave = jc.JobSave(88);
		request.setAttribute("jobsave", jobsave);
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
		doGet(request, response);
	}

}
