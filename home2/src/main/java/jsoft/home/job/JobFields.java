package jsoft.home.job;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.javatuples.Quintet;
import org.javatuples.Triplet;

import jsoft.ConnectionPool;
import jsoft.objects.ArticleObject;
import jsoft.objects.CareerObject;
import jsoft.objects.FieldObject;
import jsoft.objects.JobObject;

/**
 * Servlet implementation class JobFields
 */
@WebServlet("/fields")
public class JobFields extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String CONTENT_TYPE = "text/html; charset=utf-8";
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JobFields() {
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
		// tìm bộ quản lý kết nối
				ConnectionPool cp = (ConnectionPool) getServletContext().getAttribute("CPool");

				if (cp == null) {
					getServletContext().setAttribute("CPool", cp);
				}
				// tạo đối tượng thực thi chức năng
				JobControl jc = new JobControl(cp);
				Quintet<ArrayList<FieldObject>, ArrayList<CareerObject>, HashMap<Integer, Integer>,ArrayList<JobObject>,ArrayList<ArticleObject>> data =  jc.getFields();
				request.setAttribute("fiels", data.getValue0());
				request.setAttribute("careers", data.getValue1());
				request.setAttribute("totaljob", data.getValue2());
				request.setAttribute("jobs", data.getValue3());
				request.setAttribute("articles", data.getValue4());
				// trả về kết nối
				jc.releaseConnection();
		request.getRequestDispatcher("/fields/index.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
