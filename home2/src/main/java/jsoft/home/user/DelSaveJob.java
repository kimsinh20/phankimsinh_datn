package jsoft.home.user;

import java.io.IOException;
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
 * Servlet implementation class DelSaveJob
 */
@WebServlet("/profile/savejob/del")
public class DelSaveJob extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DelSaveJob() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		short id = (jsoft.library.Utilities.getShortParam(request, "id"));
		
		// tìm thông tin đăng nhập
		UserObject user = (UserObject) request.getSession().getAttribute("clientLogined");

		System.out.println(id);
		
		if (user != null && id > 0) {
			ConnectionPool cp = (ConnectionPool) getServletContext().getAttribute("CPool");
			JobControl uc = new JobControl(cp);
			
			boolean delResult;
			
			delResult = uc.delJob(id, user.getUser_id());

			uc.releaseConnection();

			if (delResult) {
				response.sendRedirect("/home/profile?act=savejob");
			} else {
				response.sendRedirect("/home/err");
			}
		} else {
			response.sendRedirect("/home/err");
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
