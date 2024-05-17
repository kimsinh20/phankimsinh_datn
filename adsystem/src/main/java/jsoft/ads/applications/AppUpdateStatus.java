package jsoft.ads.applications;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import jsoft.ConnectionPool;
import jsoft.objects.ApplicationsObject;
import jsoft.objects.CareerObject;
import jsoft.objects.JobObject;

/**
 * Servlet implementation class JobCareer
 */
@WebServlet("/api/app/status")
public class AppUpdateStatus extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AppUpdateStatus() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		  int app_id = jsoft.library.Utilities.getByteParam(request, "app_id");
		  int app_status = jsoft.library.Utilities.getByteParam(request, "app_status");
	        
	        if (app_id >0 &&app_status>=0) {
	            // Gọi phương thức để truy xuất CSDL và lấy danh sách các ngành nghề dựa trên ID công ty
	        	ConnectionPool cp = (ConnectionPool) getServletContext().getAttribute("CPool");
	        	AppControl jb = new AppControl(cp);
	        	if (jb != null) {
					getServletContext().setAttribute("CPool", jb.getCP());
				}
	        	ApplicationsObject eApp = new ApplicationsObject();
	        	eApp.setApplications_id(app_id);
	        	eApp.setApplications_status(app_status);
	        	eApp.setApplications_last_modified(jsoft.library.Utilities_date.getDate());
	        	jb.editApp(eApp, APP_EDIT_TYPE.STATUS);

	        	jb.releaseConnection();
	            // Chuyển danh sách ngành nghề thành JSON

	            // Thiết lập các tiêu đề HTTP và gửi phản hồi JSON
	        	 response.setContentType("application/json");
	             response.setCharacterEncoding("UTF-8");
	             response.getWriter().write("applications status updated successfully.");
	        } else {
	            // Xử lý lỗi nếu không có ID công ty trong yêu cầu
	            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
	            response.getWriter().write("Missing 'id' parameter.");
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
