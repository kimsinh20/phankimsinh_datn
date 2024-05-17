package jsoft.ads.career;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jsoft.ConnectionPool;
import jsoft.library.Utilities_date;
import jsoft.objects.CareerObject;
import jsoft.objects.UserObject;

/**
 * Servlet implementation class SectionDR
 */
@WebServlet("/career/dr")
public class CareerDR extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CareerDR() {
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
		short id = (jsoft.library.Utilities.getShortParam(request, "id"));
		int page = (jsoft.library.Utilities.getIntParam(request, "page"));
		if (page <= 0) {
			page = 1;
		}
		// tìm thông tin đăng nhập
		UserObject user = (UserObject) request.getSession().getAttribute("userLogined");

		System.out.println(id);
		
		if (user != null && id > 0) {
			ConnectionPool cp = (ConnectionPool) getServletContext().getAttribute("CPool");
			CareerControl uc = new CareerControl(cp);
			CareerObject dCate = new CareerObject();
			dCate.setCareer_id(id);
			dCate.setCareer_last_modified(Utilities_date.getDate());
			// tim tham so
			String trash = request.getParameter("t");
			String restore = request.getParameter("r");
			String url = "/adv/career/list?page=" + page;
			boolean delResult;
			if (trash == null) {
				delResult = uc.delCareer(dCate);
				url += "&trash";
			} else {
				if (restore == null) {
					delResult = uc.editCareer(dCate, CAREER_EDIT_TYPE.TRASH);
				} else {
					delResult = uc.editCareer(dCate, CAREER_EDIT_TYPE.RESTORE);
				}
			}

			uc.releaseConnection();

			if (delResult) {
				response.sendRedirect(url);
			} else {
				response.sendRedirect("/adv/career?err=notok&page="+page);
			}
		} else {
			response.sendRedirect("/adv/career/list?err=nopermis&page="+page);
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
