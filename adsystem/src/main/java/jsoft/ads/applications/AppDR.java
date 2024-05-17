package jsoft.ads.applications;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jsoft.ConnectionPool;
import jsoft.ads.article.ArticleControl;
import jsoft.library.Utilities_date;
import jsoft.objects.ApplicationsObject;
import jsoft.objects.ArticleObject;
import jsoft.objects.UserObject;

/**
 * Servlet implementation class SectionDR
 */
@WebServlet("/apply/dr")
public class AppDR extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AppDR() {
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
			AppControl uc = new AppControl(cp);
			ApplicationsObject dAr = new ApplicationsObject();
			dAr.setApplications_id(id);
			dAr.setApplications_last_modified(Utilities_date.getDate());
			// tim tham so
			String trash = request.getParameter("t");
			String restore = request.getParameter("r");
			String url = "/adv/app/list?page=" + page;
			boolean delResult;
			if (trash == null) {
				delResult = uc.delApp(dAr);
				url += "&trash";
			} else {
				if (restore == null) {
					delResult = uc.editApp(dAr, APP_EDIT_TYPE.TRASH);
				} else {
					delResult = uc.editApp(dAr, APP_EDIT_TYPE.RESTORE);
				}
			}

			uc.releaseConnection();

			if (delResult) {
				response.sendRedirect(url);
			} else {
				response.sendRedirect("/adv/app/list?err=notok");
			}
		} else {
			response.sendRedirect("/adv/article/list?err=nopermis");
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
