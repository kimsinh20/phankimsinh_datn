package jsoft.employer.main;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.javatuples.Pair;
import org.javatuples.Quartet;

import jsoft.ConnectionPool;
import jsoft.ads.applications.APP_SOFT;
import jsoft.ads.applications.AppControl;
import jsoft.ads.applications.AppModel;
import jsoft.library.ORDER;
import jsoft.objects.ApplicationsObject;
import jsoft.objects.JobObject;
import jsoft.objects.RecruiterObject;
import jsoft.objects.UserObject;

/**
 * Servlet implementation class UserExport
 */
@WebServlet("/employer/apply/export")
public class ApplyExport extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ApplyExport() {
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
		RecruiterObject user = (RecruiterObject) request.getSession().getAttribute("employerLogined");
		// tìm bộ quản lý kết nối
		ConnectionPool cp = (ConnectionPool) getServletContext().getAttribute("CPool");

		if (cp == null) {
			getServletContext().setAttribute("CPool", cp);
		}
		// tạo đối tượng thực thi chức năng
		
		AppModel am = new AppModel(cp);
		ApplicationsObject similar = new ApplicationsObject();
		similar.setApplications_delete(false);
		JobObject j = new JobObject();
		j.setJob_company_id(user.getCompany_id());
		similar.setJob(j);

		// tim thanh so xac dinh loại danh sách
		String trash =request.getParameter("trash");
		boolean isTrash = (trash!=null)?true:false;
		String title;
		if(!isTrash) {
	        similar.setApplications_delete(false);
	   		title="Danh sách ứng tuyển";
		} else {
			title ="Danh sách ứng tuyển";
			similar.setApplications_delete(true);
		}
		
		byte pageSize = 100;
		Quartet<ApplicationsObject, Integer, Byte,UserObject> infos = new Quartet<>(similar,0,pageSize,user);
		Pair<ArrayList<ApplicationsObject>, Short> datas = am.getAppObjects(infos, new Pair<>(APP_SOFT.GENERAL, ORDER.ASC));
        ArrayList<ApplicationsObject> u = datas.getValue0();
		HSSFWorkbook workbook = new HSSFWorkbook();
		HSSFSheet sheet = workbook.createSheet();
		
		sheet.createRow(0);
		
		sheet.getRow(0).createCell(0).setCellValue("tin tuyển dụng");
		sheet.getRow(0).createCell(1).setCellValue("tên người ứng tuyển");
		sheet.getRow(0).createCell(2).setCellValue("email");
		sheet.getRow(0).createCell(3).setCellValue("thời gian ứng tuyển");
		int i =1;
		for(ApplicationsObject e : u) {
			sheet.createRow(i);
			sheet.getRow(i).createCell(0).setCellValue(jsoft.library.Utilities.decode(e.getJob().getJob_title()));
			sheet.getRow(i).createCell(1).setCellValue(jsoft.library.Utilities.decode(e.getUser().getUser_fullname()));
			sheet.getRow(i).createCell(2).setCellValue(e.getUser().getUser_email());
			sheet.getRow(i).createCell(3).setCellValue(e.getApplications_created_date());
			i++;
		}
		
		Desktop desktop = Desktop.getDesktop();
		String path = "D:\\apply_"+LocalDate.now()+"_by_"+user.getUser_name()+".xls";
		File file = new File(path);
		try {
			workbook.write(file);
			desktop.open(file);
			workbook.close();
			response.sendRedirect("/adv/employer/apply?success");
		} catch (IOException e) {
			response.sendRedirect("/adv//employer/apply?err=exfail");
			// TODO Auto-generated catch block
			e.printStackTrace();
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
