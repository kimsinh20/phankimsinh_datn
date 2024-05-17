package jsoft.ads.field;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jsoft.ConnectionPool;
import jsoft.library.Utilities_date;
import jsoft.objects.FieldObject;
import jsoft.objects.UserObject;

/**
 * Servlet implementation class FieldDR
 */
@WebServlet("/field/dr")
public class FieldDR extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FieldDR() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		short id = (jsoft.library.Utilities.getShortParam(request, "id"));
		int page = (jsoft.library.Utilities.getIntParam(request, "page"));
		if(page<=0) {
			page = 1;
		}
		// tìm thông tin đăng nhập
				UserObject user = (UserObject) request.getSession().getAttribute("userLogined");
		        
				if (user != null && id>0) {
					ConnectionPool cp = (ConnectionPool)getServletContext().getAttribute("CPool");
					FieldControl uc = new FieldControl(cp);
					FieldObject dField = new FieldObject();
					dField.setField_id(id);
					dField.setField_last_modified(Utilities_date.getDate());
					// tim tham so
					String trash =request.getParameter("t");
					String restore =request.getParameter("r");
					String url = "/adv/field/list?page="+page;
					boolean delResult;
						if(trash == null) {
							delResult = uc.delField(dField);	
							url +="&trash"; 
						} else {
							if(restore==null) {
									delResult = uc.editField(dField,FIELD_EDIT_TYPE.TRASH);
							} else {
									delResult = uc.editField(dField, FIELD_EDIT_TYPE.RESTORE);
							   }
							}
							
						uc.releaseConnection();
							
						if(delResult) {
							response.sendRedirect(url);
						} else {
							response.sendRedirect("/adv/field?err=notok");
						}
						} else {
							response.sendRedirect("/adv/field/list?err=nopermis");
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
