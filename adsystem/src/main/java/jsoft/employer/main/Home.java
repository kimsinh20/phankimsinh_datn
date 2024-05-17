package jsoft.employer.main;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jsoft.objects.RecruiterObject;
import jsoft.objects.UserObject;

/**
 * Servlet implementation class View
 */
@WebServlet("/employer")
public class Home extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// định nghĩa kiểu nội dung xuất về trình khách
	private static final String CONTENT_TYPE = "text/html; charset=utf-8";

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Home() {
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
		
			view(request, response);

	}

	protected void view(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// xác định kiểu nội dung xuất về trình khách
		response.setContentType(CONTENT_TYPE);

		// tạo đối tượng thực hiện xuất nội dung
		PrintWriter out = response.getWriter();
		
		RecruiterObject user = (RecruiterObject) request.getSession().getAttribute("employerLogined");
		
		// tham chiếu tìm header
		RequestDispatcher h = request.getRequestDispatcher("/employer/header");
		if(h != null) {
			h.include(request, response);
		}
		
		// if login thanh cong thi show toast
		String success = request.getParameter("success");
		if (success != null) {
			out.append("<div class=\"toast-container position-fixed top-1 end-0 ps-3 pe-5 mb-3\">");
			out.append(
					"<div id=\"liveToast\" class=\"toast\" role=\"alert\" aria-live=\"assertive\" aria-atomic=\"true\">");
			out.append("<div class=\"toast-header\">");
			// out.append("<img src=\"...\" class=\"rounded me-2\" alt=\"...\">");
			out.append("<strong class=\"me-auto text-success\">Thông báo</strong>");
			out.append("<small>10 giây</small>");
			out.append(
					"<button type=\"button\" class=\"btn-close\" data-bs-dismiss=\"toast\" aria-label=\"Close\"></button>");
			out.append("</div>");
			out.append("<div class=\"toast-body\">");
			out.append("Đăng nhập thành công");
			out.append("</div>");
			out.append("</div>");
			out.append("</div>");

			// script
			out.append("<script language=\"javascript\" >");
			out.append("const viewToast = document.getElementById('liveToast');");
			out.append("const toast = new bootstrap.Toast(viewToast);");
			out.append("toast.show();");
			out.append("</script>");
		}
		
		String oke = request.getParameter("oke");
		if (oke != null) {
			out.append("<div class=\"toast-container position-fixed top-1 end-0 ps-3 pe-5 mb-3\">");
			out.append(
					"<div id=\"liveToast\" class=\"toast\" role=\"alert\" aria-live=\"assertive\" aria-atomic=\"true\">");
			out.append("<div class=\"toast-header\">");
			// out.append("<img src=\"...\" class=\"rounded me-2\" alt=\"...\">");
			out.append("<strong class=\"me-auto text-success\">Thông báo</strong>");
			out.append("<small>10 giây</small>");
			out.append(
					"<button type=\"button\" class=\"btn-close\" data-bs-dismiss=\"toast\" aria-label=\"Close\"></button>");
			out.append("</div>");
			out.append("<div class=\"toast-body\">");
			out.append("Mua dịch vụ thành công");
			out.append("</div>");
			out.append("</div>");
			out.append("</div>");

			// script
			out.append("<script language=\"javascript\" >");
			out.append("const viewToast = document.getElementById('liveToast');");
			out.append("const toast = new bootstrap.Toast(viewToast);");
			out.append("toast.show();");
			out.append("</script>");
		}
		
		out.append("<main style=\"margin-top: 60px; padding: 0px 30px;\" class=\"main\">");
		out.append("<div class=\"section d-flex gap-5 align-items-center\" style=\"height: 600px;\">");
		out.append("<div class=\" \">");
		out.append("<div class=\"w-20 h-4 bg-primary\"></div>");
		out.append("<div class=\"fs-2 fw-bold pt-4 pb-2\">");
		out.append("<span>Nơi gặp gỡ giữa doanh nghiệp");
		out.append("<div>");
		out.append("và 10 triệu ứng viên <span class=\"talent-text relative\">chất");
		out.append("lượng</span>");
		out.append("</div>");
		out.append("</span>");
		out.append("</div>");
		out.append("<div class=\"fw-normal pb-3\">Tuyển người dễ dàng với Việc Làm");
		out.append("24h - Chúng tôi luôn có ứng viên phù hợp cho bạn</div>");
		out.append("<a href=\"#\" class=\"btn btn-primary rounded py-3 px-5 text-center cursor-pointer\">Đăng tin ngay!");
		out.append("</a>");
		out.append("</div>");
		out.append("<div class=\" content\">");
		out.append("<span style=\"box-sizing: border-box; display: inline-block; overflow: hidden; width: initial; height: initial; background: none; opacity: 1; border: 0; margin: 0; padding: 0; position: relative; max-width: 100%\"><span style=\"box-sizing: border-box; display: block; width: initial; height: initial; background: none; opacity: 1; border: 0; margin: 0; padding: 0; max-width: 100%\">");
		out.append("<img style=\"display: block; max-width: 100%; width: initial; height: initial; background: none; opacity: 1; border: 0; margin: 0; padding: 0\" alt=\"\" aria-hidden=\"true\" src=\"https://ntd.vieclam24h.vn/_next/image?url=%2Fimg%2Flanding_page_right.png&amp;w=1920&amp;q=75\">");
		out.append("</span> <img alt=\"\" srcset=\"/_next/image?url=%2Fimg%2Flanding_page_right.png&amp;w=750&amp;q=75 1x, /_next/image?url=%2Fimg%2Flanding_page_right.png&amp;w=1920&amp;q=75 2x\" src=\"https://ntd.vieclam24h.vn/_next/image?url=%2Fimg%2Flanding_page_right.png&amp;w=1920&amp;q=75\" decoding=\"async\" data-nimg=\"intrinsic\" style=\"position: absolute; top: 0; left: 0; bottom: 0; right: 0; box-sizing: border-box; padding: 0; border: none; margin: auto; display: block; width: 0; height: 0; min-width: 100%; max-width: 100%; min-height: 100%; max-height: 100%\"></span>");
		out.append("</div>");
		out.append("</div>");
		out.append("");
		out.append("<div class=\"text-center mt-4 mb-8\">");
		out.append("<h1 class=\"fs-1 fw-bold\">JobNow - website việc làm phổ biến");
		out.append(" nhất Việt Nam với gần 20 năm kinh nghiệm trên thị trường</h1>");
		out.append("<div class=\"container gap-4\">");
		out.append("<div class=\"row mt-5\">");
		out.append("<div class=\"col d-flex align-items-center gap-3\">");
		out.append("<svg width=\"64\" height=\"64\" viewBox=\"0 0 64 64\" fill=\"none\" xmlns=\"http://www.w3.org/2000/svg\" class=\"\" style=\"min-width: 60px;\">");
		out.append("<path d=\"M28.4669 20.5763C27.11 19.4913 26.3194 17.8475 26.3194 16.11V12.1407H23.9269C23.1369 12.1407 22.4969 11.5 22.4969 10.7107V1.54816C22.4969 0.758789 23.1369 0.118164 23.9269 0.118164H14.1169C13.3275 0.118164 12.6875 0.758164 12.6875 1.54816V10.7107C12.6875 11.5 13.3275 12.14 14.1169 12.14H16.51V16.11C16.51 17.8475 17.3 19.4907 18.6569 20.5763L32.9406 32L37.8456 28.0769L28.4669 20.5763Z\" fill=\"#DEEBFF\"></path>");
		out.append("<path d=\"M22.4969 62.4519V55.7419C22.4969 54.9525 23.1369 54.3119 23.9269 54.3119H26.4794V47.4238C26.4794 45.6569 27.2962 43.9888 28.6931 42.9056L37.8931 35.7688L32.9406 32L18.8837 42.905C17.4875 43.9881 16.67 45.6563 16.67 47.4231V54.3119H14.1169C13.3275 54.3119 12.6875 54.9525 12.6875 55.7419V62.4519C12.6875 63.2413 13.3275 63.8819 14.1169 63.8819H23.9269C23.1375 63.8819 22.4969 63.2419 22.4969 62.4519Z\" fill=\"#DEEBFF\"></path>");
		out.append("<path d=\"M32.0013 33.5997C31.6381 33.5997 31.2856 33.4766 31.0019 33.2491L17.3825 22.3566C15.7044 21.021 14.7294 18.9922 14.7344 16.8485V10.851C14.7344 9.96723 15.4506 9.25098 16.3344 9.25098C17.2181 9.25098 17.9344 9.96723 17.9344 10.851V16.8485C17.9319 18.0197 18.4644 19.1279 19.3806 19.8572L32.0013 29.9516L44.6219 19.8579C45.5382 19.1291 46.0707 18.0204 46.0682 16.8491V10.851C46.0682 9.96723 46.7844 9.25098 47.6682 9.25098C48.5519 9.25098 49.2682 9.96723 49.2682 10.851V16.8485C49.2732 18.9929 48.2982 21.0216 46.62 22.3566L33.0006 33.2491C32.7169 33.4766 32.3644 33.5997 32.0013 33.5997Z\" fill=\"#1AE5BE\"></path>");
		out.append("<path d=\"M47.8199 54.9015C46.9361 54.9015 46.2199 54.1853 46.2199 53.3015V46.739C46.2161 45.5359 45.6549 44.4034 44.6999 43.6721L32.0099 34.0178L19.578 43.6628C18.6343 44.3903 18.083 45.5153 18.0868 46.7071V53.3015C18.0868 54.1853 17.3705 54.9015 16.4868 54.9015C15.603 54.9015 14.8868 54.1853 14.8868 53.3015V46.7071C14.8799 44.5259 15.8893 42.4659 17.6168 41.134L31.0199 30.7365C31.5924 30.2921 32.3924 30.2884 32.9693 30.7271L46.6374 41.1259C48.3855 42.4634 49.4137 44.5378 49.4199 46.739V53.3021C49.4199 54.1853 48.703 54.9015 47.8199 54.9015Z\" fill=\"#1AE5BE\"></path>");
		out.append("<path d=\"M52.799 2.96312C52.799 1.32688 51.4722 0 49.8359 0H14.0022C12.3659 0 11.0391 1.32688 11.0391 2.96312V9.35687C11.0391 10.9931 12.3659 12.32 14.0022 12.32H49.8359C51.4722 12.32 52.799 10.9931 52.799 9.35687V2.96312ZM49.7591 9.12H14.2391V3.2H49.7591V9.12Z\" fill=\"#0635C9\"></path>");
		out.append("<path d=\"M52.799 54.6431C52.799 53.0068 51.4722 51.6799 49.8359 51.6799H14.0022C12.3659 51.6799 11.0391 53.0068 11.0391 54.6431V61.0368C11.0391 62.6731 12.3659 63.9999 14.0022 63.9999H49.8359C51.4722 63.9999 52.799 62.6731 52.799 61.0368V54.6431ZM49.7591 60.7999H14.2391V54.8799H49.7591V60.7999Z\" fill=\"#0635C9\"></path></svg>");
		out.append("<div class=\"text-left\">");
		out.append("<div class=\"fs-3 fw-bold\">Nguồn ứng");
		out.append("viên chất lượng</div>");
		out.append("<div class=\"text-sm md:text-lg\">");
		out.append("<span>Nhà tuyển dụng có thể tiếp cận nguồn ứng viên dồi ");
		out.append("dào với hơn <b>10 triệu hồ sơ </b> và hơn <b> 50 triệu lượt ");
		out.append("truy cập</b> mỗi năm");
		out.append("</span>");
		out.append("</div>");
		out.append("</div>");
		out.append("</div>");
		out.append("<div class=\"col d-flex align-items-center gap-3\">");
		out.append("<svg width=\"64\" height=\"64\" viewBox=\"0 0 64 64\" fill=\"none\" xmlns=\"http://www.w3.org/2000/svg\" class=\"md:min-w-[60px] min-w-[50px]\" style=\"min-width: 60px;\">");
		out.append("<g clip-path=\"url(#clip0_4931_21299)\">");
		out.append("<path d=\"M15.2034 24.8643L32.0016 59.7986L1.60156 24.8643H15.2034Z\" fill=\"#D4E1F4\"></path>");
		out.append("<path d=\"M23.6016 4.32031L15.2034 24.8647H1.60156L14.1059 4.32031H23.6016Z\" fill=\"#D4E1F4\"></path>");
		out.append("<path d=\"M32.0007 61.399C31.3851 61.3997 30.8238 61.0472 30.5576 60.4922L13.7595 25.5578C13.5632 25.1497 13.5495 24.6778 13.7207 24.2591L22.1188 3.71468C22.4532 2.89718 23.3876 2.50468 24.2057 2.83906C25.0238 3.17343 25.4157 4.1078 25.0813 4.92593L16.9513 24.8116L33.4419 59.1053C33.6794 59.6009 33.6463 60.184 33.3538 60.6497C33.0613 61.1153 32.5507 61.3984 32.0007 61.399Z\" fill=\"#1AE5BE\"></path>");
		out.append("<path d=\"M31.9969 61.399C31.4475 61.3984 30.9362 61.1153 30.6437 60.6497C30.3512 60.184 30.3181 59.6009 30.5562 59.1053L47.0469 24.8116L38.9169 4.92593C38.5825 4.1078 38.975 3.17343 39.7931 2.83906C40.6106 2.50468 41.545 2.89718 41.8794 3.71468L50.2775 24.2591C50.4494 24.6778 50.435 25.1497 50.2387 25.5578L33.4406 60.4915C33.1737 61.0465 32.6125 61.3997 31.9969 61.399Z\" fill=\"#1AE5BE\"></path>");
		out.append("<path d=\"M63.7094 25.7817C63.7206 25.7654 63.7306 25.751 63.7419 25.7348C63.7575 25.7104 63.7725 25.6848 63.7875 25.6592C63.7969 25.6435 63.8062 25.6273 63.815 25.611C63.8312 25.5817 63.845 25.5517 63.8587 25.521C63.8656 25.5048 63.8737 25.4892 63.88 25.4729C63.8962 25.4348 63.9106 25.3954 63.9231 25.356C63.9287 25.3373 63.9338 25.3185 63.9387 25.2992C63.9469 25.2717 63.9537 25.2442 63.9606 25.216C63.965 25.1967 63.9688 25.1773 63.9725 25.1573C63.9781 25.126 63.9831 25.0948 63.9869 25.0635C63.9888 25.0473 63.9912 25.031 63.9925 25.0154C63.9975 24.9673 64 24.9192 64 24.8698V24.8654C64 24.8579 63.9987 24.8517 63.9987 24.8442C63.9987 24.8035 63.9963 24.7629 63.9925 24.7223C63.9912 24.7054 63.9894 24.6885 63.9875 24.6723C63.9831 24.6398 63.9787 24.6085 63.9725 24.5773C63.9694 24.5592 63.9662 24.541 63.9625 24.5235C63.9556 24.491 63.9462 24.4592 63.9375 24.4273C63.9338 24.4123 63.93 24.3973 63.925 24.3823C63.9119 24.3398 63.8962 24.2979 63.8794 24.2567C63.8713 24.2373 63.8625 24.2192 63.8537 24.1998C63.8425 24.1754 63.8306 24.1517 63.8181 24.1273C63.8081 24.1079 63.7975 24.0885 63.7862 24.0698C63.7794 24.0579 63.7738 24.046 63.7662 24.0342L51.2631 3.51792C50.9694 3.04792 50.45 2.7673 49.8962 2.77917H14.1044C13.55 2.7673 13.0312 3.04792 12.7375 3.51792L0.23375 24.0467C0.22625 24.0585 0.220625 24.0629 0.21375 24.0754C0.2025 24.0942 0.191875 24.1092 0.181875 24.1292C0.169375 24.1529 0.1575 24.1754 0.14625 24.1998C0.1375 24.2185 0.12875 24.2367 0.120625 24.2554C0.10375 24.2973 0.0887501 24.3385 0.075 24.381C0.07 24.3954 0.0662499 24.4104 0.0625 24.4254C0.053125 24.4573 0.044375 24.4892 0.0375 24.5217C0.0337501 24.5392 0.030625 24.5573 0.0275 24.5754C0.0212499 24.6073 0.016875 24.6392 0.0125 24.6704C0.010625 24.686 0.00875 24.7035 0.0075 24.7204C0.00375 24.761 0.00187501 24.8017 0.00125 24.8423C0.00125 24.8492 0 24.856 0 24.8635V24.8679C0 24.916 0.0025 24.9648 0.0075 25.0135C0.00875 25.0292 0.01125 25.0454 0.013125 25.061C0.016875 25.0935 0.021875 25.1248 0.0275 25.1554C0.0312499 25.1754 0.035 25.1948 0.039375 25.2142C0.045625 25.2423 0.053125 25.2698 0.0612499 25.2973C0.0662499 25.3167 0.0712499 25.3354 0.076875 25.3542C0.089375 25.3935 0.10375 25.4323 0.12 25.471C0.12625 25.4873 0.134375 25.5029 0.14125 25.5192C0.155 25.5492 0.169375 25.5798 0.185 25.6092C0.19375 25.6254 0.203125 25.641 0.2125 25.6573C0.2275 25.6829 0.2425 25.7079 0.258125 25.7329C0.26875 25.7492 0.279375 25.7648 0.290625 25.7798C0.3075 25.8042 0.325625 25.8279 0.344375 25.8523C0.355625 25.866 0.36625 25.8798 0.3775 25.8935C0.383125 25.8998 0.3875 25.906 0.3925 25.9123L30.7925 60.8467C30.8031 60.8585 30.8144 60.8685 30.825 60.8798C30.8469 60.9035 30.8694 60.9279 30.8931 60.9504C30.9094 60.966 30.9269 60.981 30.9437 60.9967C30.9681 61.0179 30.9919 61.0379 31.0175 61.0579C31.0356 61.0717 31.0531 61.0848 31.0712 61.0979C31.0981 61.1173 31.1262 61.1354 31.155 61.1529C31.1719 61.1642 31.1894 61.1748 31.2069 61.1854C31.2387 61.2029 31.2712 61.2198 31.3031 61.2354C31.3187 61.2429 31.335 61.2517 31.3512 61.2585C31.3875 61.2742 31.4244 61.2885 31.4619 61.3017C31.4762 61.3067 31.4894 61.3129 31.5037 61.3179C31.5444 61.331 31.5856 61.3417 31.6275 61.3517C31.6394 61.3548 31.6519 61.3585 31.6644 61.361C31.7081 61.371 31.7525 61.3773 31.7975 61.3829C31.8088 61.3848 31.8194 61.3867 31.8294 61.3879C31.9425 61.4004 32.0556 61.4004 32.1688 61.3879C32.1794 61.3867 32.19 61.3848 32.2006 61.3829C32.2456 61.3773 32.29 61.371 32.3337 61.361C32.3462 61.3585 32.3587 61.3548 32.3713 61.3517C32.4125 61.3417 32.4538 61.331 32.4944 61.3179C32.5088 61.3135 32.5219 61.3073 32.5363 61.3017C32.5737 61.2885 32.6106 61.2742 32.6469 61.2585C32.6631 61.251 32.6787 61.2423 32.695 61.2354C32.7269 61.2192 32.76 61.2035 32.7912 61.1854C32.8088 61.1748 32.8262 61.1642 32.8431 61.1529C32.8719 61.1354 32.8994 61.1173 32.9269 61.0979C32.945 61.0848 32.9625 61.0717 32.9806 61.0579C33.0056 61.0379 33.03 61.0179 33.0537 60.9967C33.0713 60.981 33.0881 60.966 33.105 60.9504C33.1287 60.9273 33.1512 60.9035 33.1731 60.8798C33.1838 60.8685 33.195 60.8585 33.205 60.8467L63.605 25.9123C63.6106 25.906 63.615 25.8998 63.6206 25.8935C63.6319 25.8798 63.6425 25.866 63.6537 25.8523C63.6737 25.8298 63.6925 25.8067 63.7094 25.7817ZM30.4 55.5223L5.11375 26.4592H30.4V55.5223ZM33.6 26.4592H58.8869L33.6 55.5223V26.4592ZM59.5531 23.2592H33.6V5.97917H48.9969L59.5531 23.2592ZM15.0037 5.97917H30.4V23.2592H4.44688L15.0037 5.97917Z\" fill=\"#0635C9\"></path></g>");
		out.append("<defs>");
		out.append("<clipPath id=\"clip0_4931_21299\">");
		out.append("<rect width=\"64\" height=\"64\" fill=\"white\"></rect></clipPath></defs></svg>");
		out.append("<div class=\"text-left \">");
		out.append("<div class=\"fs-3 fw-bold\">Trải nghiệm");
		out.append("toàn diện</div>");
		out.append("<div class=\"text-sm md:text-lg\">Tài khoản nhà tuyển dụng ");
		out.append("được tích hợp thêm các tính năng thông minh, giúp thuận tiện quản ");
		out.append("lý tin đăng, quản lý hồ sơ và theo dõi ứng viên, và lượng nộp đơn</div>");
		out.append("</div>");
		out.append("</div>");
		out.append("</div>");
		out.append("<div class=\"row mt-5\">");
		out.append("<div class=\"col d-flex align-items-center gap-3\">");
		out.append("<svg width=\"64\" height=\"64\" viewBox=\"0 0 64 64\" fill=\"none\" xmlns=\"http://www.w3.org/2000/svg\" class=\"md:min-w-[60px] min-w-[50px]\" style=\"min-width: 60px;\">");
		out.append("<g clip-path=\"url(#clip0_4931_21324)\">");
		out.append("<path d=\"M5.75495 5.72956H27.1722V1.46289H1.48828V27.1473H5.75495V5.72956Z\" fill=\"#D4E1F4\"></path>");
		out.append("<path d=\"M41.1456 5.72956H62.5628V1.46289H36.8789V27.1473H41.1456V5.72956Z\" fill=\"#D4E1F4\"></path>");
		out.append("<path d=\"M5.75495 41.1192H27.1722V36.8525H1.48828V62.5364H5.75495V41.1192Z\" fill=\"#D4E1F4\"></path>");
		out.append("<path d=\"M41.1456 41.1192H62.5628V36.8525H36.8789V62.5364H41.1456V41.1192Z\" fill=\"#D4E1F4\"></path>");
		out.append("<path d=\"M27.1686 28.5699H1.48472C0.699167 28.5699 0.0625 27.9332 0.0625 27.1477V1.46324C0.0625 0.678238 0.699167 0.0410156 1.48472 0.0410156H27.1686C27.9542 0.0410156 28.5908 0.678238 28.5908 1.46324V27.1477C28.5908 27.9332 27.9542 28.5699 27.1686 28.5699ZM2.90694 25.7255H25.7464V2.88546H2.90694V25.7255Z\" fill=\"#1AE5BE\"></path>");
		out.append("<path d=\"M62.5592 63.959H36.8753C36.0898 63.959 35.4531 63.3223 35.4531 62.5368V36.8529C35.4531 36.0673 36.0898 35.4307 36.8753 35.4307H62.5592C63.3448 35.4307 63.9815 36.0673 63.9815 36.8529V62.5368C63.9815 63.3223 63.3448 63.959 62.5592 63.959ZM38.2976 61.1146H61.137V38.2751H38.2976V61.1146Z\" fill=\"#1AE5BE\"></path>");
		out.append("<path d=\"M64.0007 1.42222C64.0007 0.636667 63.3641 0 62.5785 0H36.8363C36.0507 0 35.4141 0.636667 35.4141 1.42222V27.1644C35.4141 27.95 36.0507 28.5867 36.8363 28.5867H62.5785C63.3641 28.5867 64.0007 27.95 64.0007 27.1644V1.42222ZM61.1563 25.7422H38.2585V2.84444H61.1563V25.7422Z\" fill=\"#0635C9\"></path>");
		out.append("<path d=\"M28.5867 36.8356C28.5867 36.05 27.95 35.4133 27.1644 35.4133H1.42222C0.636667 35.4133 0 36.05 0 36.8356V62.5778C0 63.3633 0.636667 64 1.42222 64H27.1644C27.95 64 28.5867 63.3633 28.5867 62.5778V36.8356ZM25.7422 61.1556H2.84444V38.2578H25.7422V61.1556Z\" fill=\"#0635C9\"></path></g>");
		out.append("<defs>");
		out.append("<clipPath id=\"clip0_4931_21324\">");
		out.append("<rect width=\"64\" height=\"64\" fill=\"white\"></rect></clipPath></defs></svg>");
		out.append("<div class=\"text-left \">");
		out.append("<div class=\"fs-3 fw-bold\">Chi phí hợp");
		out.append("lý</div>");
		out.append("<div class=\"text-sm md:text-lg\">");
		out.append("<span>Đặc quyền <b>12++ tin đăng miễn phí</b> mỗi năm giúp ");
		out.append("nhà tuyển dụng tối ưu chi phí &amp; quy trình tuyển dụng");
		out.append("</span>");
		out.append("</div>");
		out.append("</div>");
		out.append("</div>");
		out.append("<div class=\"col d-flex align-items-center gap-3\">");
		out.append("<svg width=\"64\" height=\"64\" viewBox=\"0 0 64 64\" fill=\"none\" xmlns=\"http://www.w3.org/2000/svg\" class=\"md:min-w-[60px] min-w-[50px]\" style=\"min-width: 60px;\">");
		out.append("<path d=\"M30.8157 14.8012V13.0519H26.4211C24.6401 13.037 23.0941 14.2755 22.7198 16.0168V16.0174C22.5684 16.7566 22.4367 17.4985 22.3164 18.2411H27.2948C29.2171 18.2634 30.7928 16.7235 30.8157 14.8012Z\" fill=\"#D4E1F4\"></path>");
		out.append("<path d=\"M29.9974 57.0812C20.4656 57.0812 12.2974 50.4238 10.5926 41.2643L9.73452 36.6562C8.52304 30.1488 8.52304 23.4731 9.73452 16.9657L10.5926 12.3576C11.071 9.78663 12.0771 7.34271 13.546 5.1792C9.2879 8.04744 6.35547 12.5015 5.40344 17.5468L4.54533 22.1549C3.33385 28.6623 3.33385 35.338 4.54533 41.8454L5.40344 46.4535C7.10817 55.613 15.2764 62.2704 24.8082 62.2704H27.2933C29.2156 62.2927 30.792 60.7528 30.8149 58.8306V57.0812H29.9974Z\" fill=\"#D4E1F4\"></path>");
		out.append("<path d=\"M50.339 57.8981C49.6356 57.8981 49.0025 57.4724 48.7369 56.821C48.4721 56.1697 48.6275 55.4224 49.1308 54.9312C55.4045 48.8035 58.8592 40.6609 58.8592 32.0001C58.8592 23.3393 55.4045 15.1967 49.1308 9.06901C48.4552 8.4028 48.443 7.31699 49.1025 6.63523C49.7619 5.95347 50.8477 5.9305 51.5356 6.5832L51.5471 6.59401C58.4937 13.3778 62.3187 22.4001 62.3187 32.0001C62.3187 41.6001 58.4937 50.6224 51.5477 57.4062C51.2248 57.7224 50.791 57.8987 50.339 57.8981Z\" fill=\"#1AE5BE\"></path>");
		out.append("<path d=\"M42.2862 50.0346C41.5829 50.0346 40.9497 49.6089 40.6842 48.9576C40.4187 48.3062 40.5747 47.5589 41.0774 47.0677C49.3991 39.0285 49.6281 25.7657 41.5889 17.4441C41.4214 17.2711 41.2511 17.1008 41.0774 16.9326C40.391 16.2684 40.3734 15.1731 41.0376 14.4866C41.7018 13.8001 42.797 13.7826 43.4835 14.4468L43.495 14.4582C53.1829 23.8319 53.4383 39.2846 44.0639 48.9731C43.8774 49.1664 43.6876 49.3556 43.495 49.542C43.172 49.8583 42.7383 50.0353 42.2862 50.0346Z\" fill=\"#1AE5BE\"></path>");
		out.append("<path d=\"M33.4743 41.4269C32.7709 41.4269 32.1372 41.0013 31.8723 40.3499C31.6068 39.6986 31.7622 38.9513 32.2655 38.4601C35.8318 35.0168 35.9324 29.3344 32.4905 25.7675C32.4162 25.6905 32.3412 25.6155 32.2655 25.5425C31.5784 24.8776 31.5608 23.783 32.225 23.0959C32.8892 22.4094 33.9845 22.3911 34.6709 23.0553L34.6824 23.0668C39.6169 27.8445 39.7439 35.7168 34.9662 40.6513C34.8736 40.7472 34.7791 40.8418 34.6824 40.9351C34.3601 41.2513 33.9257 41.4276 33.4743 41.4269Z\" fill=\"#1AE5BE\"></path>");
		out.append("<path d=\"M27.292 64H24.8069C14.436 64 5.56028 56.7534 3.7015 46.7696L2.84339 42.1615C1.58866 35.4453 1.58866 28.5541 2.84339 21.8372L3.7015 17.2297C5.56028 7.24662 14.4353 0 24.8069 0H27.292C30.1873 0 32.5434 2.31892 32.5434 5.16959V14.8007C32.5434 17.6514 30.1873 19.9703 27.292 19.9703H21.2299C20.2758 19.9574 19.4414 20.6101 19.2245 21.5392L19.2218 21.5534C17.8022 28.4453 17.8022 35.5547 19.2218 42.4466C19.2231 42.4514 19.2238 42.4561 19.2251 42.4608C19.4414 43.3899 20.2758 44.0426 21.2299 44.0297H27.292C30.1873 44.0297 32.5434 46.3486 32.5434 49.1993V58.8304C32.5434 61.6811 30.1873 64 27.292 64ZM24.8069 3.45946C16.1022 3.45946 8.65623 9.51689 7.10217 17.8635L6.24474 22.4709C5.06772 28.7696 5.06772 35.2304 6.24474 41.5291L7.10217 46.1365C8.65623 54.4831 16.1022 60.5405 24.8069 60.5405H27.292C28.2583 60.5615 29.0596 59.7966 29.0839 58.8304V49.1993C29.0596 48.2324 28.2583 47.4676 27.292 47.4892H21.2299C18.6299 47.498 16.3785 45.6845 15.8333 43.1419C15.8319 43.1358 15.8306 43.1291 15.8292 43.123C14.3204 35.7845 14.3204 28.2155 15.8292 20.877C15.8306 20.8703 15.8319 20.8642 15.8333 20.8581C16.3785 18.3155 18.6299 16.502 21.2299 16.5108H27.292C28.2583 16.5324 29.0596 15.7676 29.0839 14.8007V5.16959C29.0596 4.20338 28.2583 3.43851 27.292 3.45946H24.8069Z\" fill=\"#0635C9\"></path></svg>");
		out.append("<div class=\"text-left \">");
		out.append("<div class=\"fs-3 fw-bold\">Chất lượng ");
		out.append("CSKH chuyên nghiệp</div>");
		out.append("<div class=\"text-sm md:text-lg\">Đội ngũ CSKH giờ tập trung ");
		out.append("cho vieclam24h.vn, chuyên nghiệp hơn &amp; tận tình hơn, nhằm ");
		out.append("mang lại trải nghiệm tốt nhất và hiệu quả tối đa</div>");
		out.append("</div>");
		out.append("</div>");
		out.append("</div>");
		out.append("</div>");
		out.append("<div class=\"mt-5\">");
		out.append("<h2 class=\"fs-2 fw-bold\">Trải nghiệm dịch vụ đăng tin tại JobNow");
		out.append("</h2>");
		out.append("<div class=\"d-flex justify-content-center\">");
		out.append("<button class=\"d-flex align-items-center justify-content-center rounded px-5 py-2 h-11 btn btn-primary !h-[50px] px-16 w-full md:w-[358px]\">");
		out.append("<h3>Đăng tin ngay!</h3>");
		out.append("</button>");
		out.append("</div>");
		out.append("</div>");
		out.append("</div>");
		out.append("<div class=\"mt-5 mb-5\">");
		out.append("<div class=\"text-center\">");
		out.append("<h1>Tìm hiểu dịch vụ chúng tôi có thể giúp bạn</h1>");
		out.append("<span>Chúng tôi mang đến giải pháp kết nối, tuyển dụng, thu hút nhân tài tốt nhất tới bạn</span>");
		out.append("</div>");
		out.append("<div class=\"container mt-3\">");
		out.append("<div class=\"row\">");
		out.append("<div class=\"col d-flex justify-content-center flex-column align-items-center\">");
		out.append("<h2>Đăng tin cơ bản</h2>");
		out.append("<p>");
		out.append("Giúp tin đăng tuyển của công ty sẽ được hiển thị ngay lập tức trên trang web jobow trong 90 ngày");
		out.append("</p>");
		out.append("<span class=\"text-danger fs-2 mb-2\">700 000 vnd</span>");
		out.append("<div>");
		out.append("<a href=\""+(user!=null?"/adv/service?id=56":"/adv/employer/login")+"\" class=\"btn btn-primary\">Xem thêm</a>");
		out.append("</div>");
		out.append("</div>");
		out.append("<div class=\"col d-flex justify-content-center flex-column align-items-center\">");
		out.append("<h2>Tìm kiếm ứng viên</h2>");
		out.append("<p>");
		out.append("Giúp nhà tuyển dụng chủ động tìm kiếm ứng viên trong hơn 1,2 triệu hồ sơ chất lượng để mời phỏng vấn");
		out.append("</p>");
		out.append("<span class=\"text-danger fs-2 mb-2\">600 000 vnd</span>");
		out.append("<div>");
		out.append("<a href=\""+(user!=null?"/adv/service?id=57":"/adv/employer/login")+"\" class=\"btn btn-primary\">Xem thêm</a>");
		out.append("</div>");
		out.append("</div>");
		out.append("<div class=\"col d-flex justify-content-center  flex-column align-items-center\">");
		out.append("<h2>Xây dựng thương hiệu</h2>");
		out.append("<p>");
		out.append("xây dựng thương hiệu cá nhân,quảng cáo cho nhà tuyển dụng");
		out.append("</p>");
		out.append("<span class=\"text-danger fs-2 mb-2\">500 000 vnd</span>");
		out.append("<div>");
		out.append("<a href=\""+(user!=null?"/adv/service?id=58":"/adv/employer/login")+"\" class=\"btn btn-primary\">Xem thêm</a>");
		out.append("</div>");
		out.append("</div>");
		out.append("</div>");
		out.append("</div>");
		out.append("</div>");
		out.append("</main>");
		
		// tham chiếu tìm sidebar
		RequestDispatcher f = request.getRequestDispatcher("/employer/footer");
		if(f != null) {
			f.include(request, response);
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
