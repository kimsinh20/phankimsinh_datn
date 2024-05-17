package jsoft.home.homepage;

import java.util.ArrayList;
import java.util.HashMap;

import com.google.gson.Gson;

import jsoft.library.Utilities;
import jsoft.objects.AddressObject;
import jsoft.objects.ArticleObject;
import jsoft.objects.CareerObject;
import jsoft.objects.CompanyObject;
import jsoft.objects.FieldObject;
import jsoft.objects.JobObject;
import jsoft.objects.UserObject;

public class HomepageLibrary {
	public static boolean isCheck(int d, ArrayList<JobObject> list) {
		if (list == null) {
			return false;
		} else {
			for (JobObject i : list) {
			    if (i.getJob_id() == d) {
			        return true;
			    }
			}
		}
		return false;
	}
	public static String viewCareer(ArrayList<CareerObject> items,HashMap<Integer, Integer> total) {
		StringBuffer tmp = new StringBuffer();
	    items.forEach(item -> {
	    	tmp.append("<div class=\"group px-3 py-10 rounded-md shadow dark:shadow-gray-700 hover:shadow-emerald-600/10 dark:hover:shadow-emerald-600/10 text-center bg-white dark:bg-slate-900 hover:bg-emerald-600/5 dark:hover:bg-emerald-600/5 transition duration-500\" data-aos=\"fade-up\" data-aos-duration=\"1000\">");
			tmp.append("<div class=\"w-16 h-16 bg-emerald-600/5 group-hover:bg-emerald-600 text-emerald-600 group-hover:text-white rounded-md text-2xl flex align-middle justify-center items-center shadow-sm dark:shadow-gray-700 transition duration-500 mx-auto\">");
			tmp.append("<i class=\"fa fa-solid fa-user-doctor\"></i>");
			tmp.append("</div>");

			tmp.append("<div class=\"content mt-6\">");
			tmp.append("<a href=\"/home/fields\" class=\"title text-lg font-semibold hover:text-emerald-600\">"+item.getCareer_name()+"");
			tmp.append("</a>");
			tmp.append("<p class=\"text-slate-400 mt-3\">"+total.get(item.getCareer_id())+" ngành nghề</p>");
			tmp.append("</div>");
			tmp.append("</div><!--end content-->");
	    });
		return tmp.toString();
	}
	
	public static String viewListCompanies(ArrayList<CompanyObject> items,HashMap<Integer, Integer> total) {
		StringBuffer out = new StringBuffer();
	
	    items.forEach(item -> {
	    	out.append("<div class=\"p-3 rounded shadow dark:shadow-gray-700 bg-slate-50 dark:bg-slate-800\" data-aos=\"fade-up\">");
	    	out.append("<div class=\"flex items-center\">");
	    	out.append("<div class=\"size-12 flex items-center justify-center bg-white dark:bg-slate-900 shadow dark:shadow-gray-700 rounded-md me-2\">");
	    	out.append("<img src=\""+item.getCompany_logo()+"\" class=\"size-8\" alt=\"\">");
	    	out.append("</div>");
	    	out.append("");
	    	out.append("<div class=\"ms-3\">");
	    	out.append("<a href=\"/home/company/detail?id="+item.getCompany_id()+"\" class=\"block text-[16px] font-semibold hover:text-emerald-600 transition-all duration-500\">"+jsoft.library.Utilities.decode(item.getCompany_name())+"</a>");
	    	out.append("<span class=\"block text-sm text-emerald-600\">");
	    	out.append(total.get(item.getCompany_id()) == null ? "0" : total.get(item.getCompany_id()));
	    	out.append(" công việc</span>");
	    	out.append("</div>");
	    	out.append("</div>");
	    	out.append("</div>");
	    });
		return out.toString();
	}
	
	public static String viewListJob(ArrayList<JobObject> items,UserObject user,ArrayList<JobObject> JobSave) {
		StringBuffer out = new StringBuffer();
	    items.forEach(item -> {
	    	
	    	String job_work_time = "";
	    	switch (item.getJob_work_time()) {
			case 1:
				job_work_time = "Fulltime";
				break;
			case 2:
				job_work_time = "PartTime";
				break;
			case 3:
				job_work_time = "Intern";
				break;
			case 4:
				job_work_time = "Remote";
				break;
			case 5:
				job_work_time = "Freelance";
				break;
			case 6:
				job_work_time = "Seasonal contracts";
				break;
			case 7:
				job_work_time = "orther";
				break;
			default:
				job_work_time = "Lựa chọn không hợp lệ";
			}
	    	String job_location = "";
	    	AddressObject location=null;
	    	 if(item.getJob_location().equalsIgnoreCase("1")) {
	        	   job_location = "Làm việc trực tuyến";
	           } else if(item.getJob_location().equalsIgnoreCase("2")) {
	        	   job_location = "Làm việc ở nước ngoài";
	           } else {
	        	 Gson gson = new Gson();
	  			 location = gson.fromJson(item.getJob_location(), AddressObject.class);
	        	 job_location=location.getProvince().getName();
	           }
	    	 
	    	 String date = "";
	    	 long date_count = jsoft.library.Utilities_date.getminusDay(item.getJob_expiration_date());
	    	 if(date_count<0) {
	    		 date = "<span class=\"block text-sm text-false\">Hết hạn "+Math.abs(date_count)+" ngày</span>";
	    	 } else if(date_count==0) {
	    		 date = "<span class=\"block text-sm text-true\">Hôm nay</span>";
	    	 }else {
	    		 date = "<span class=\"block text-sm text-true\">Còn "+Math.abs(date_count)+" ngày</span>";
	    	 }
	    	 String job_salary ="";
	    	 switch (item.getJob_salary()) {
				case 1:
					job_salary = "3 triệu đến 5 triệu";
					break;
				case 2:
					job_salary = "5 triệu đến 7 triệu";
					break;
				case 3:
					job_salary = "7 triệu đến 10 triệu";
					break;
				case 4:
					job_salary = "10 triệu đến 15 triệu";
					break;
				case 5:
					job_salary = "15 triệu đến 30 triệu";
					break;
				case 6:
					job_salary = "Trên 30 triệu";
					break;
				case 7:
					job_salary = "Trên 50 triệu";
					break;
				case 8:
					job_salary = "Không lương";
					break;
				case 9:
					job_salary = "Thương lượng";
					break;
				case -1:
					job_salary = "-- Vui lòng chọn --";
					break;
				default:
					job_salary = "Lựa chọn không hợp lệ";
				}

	    	 
	    	out.append("<div class=\"group shadow dark:shadow-gray-700 p-6 rounded-md bg-white dark:bg-slate-900\">");
	    	out.append("<div class=\"flex items-center justify-between\">");
	    	out.append("<div class=\"flex items-center\">");
	    	out.append("<div class=\"size-14 flex items-center justify-center bg-white dark:bg-slate-900 shadow dark:shadow-gray-700 rounded-md\">");
	    	out.append("<img src=\""+item.getCompany().getCompany_logo()+"\" class=\"size-8\" alt=\"\" />");
	    	out.append("</div>");
	    	out.append("");
	    	out.append("<div class=\"ms-2\">");
	    	out.append("<a href=\"/home/jobs/detail?id="+item.getJob_id()+"\"");
	    	out.append("class=\"block text-[16px] font-semibold hover:text-emerald-600 transition-all duration-500\">"+item.getCompany().getCompany_name()+"</a>");
	    	out.append(date);
	    	out.append("</div>");
	    	out.append("</div>");
	    	out.append("");
	    	out.append("<span");
	    	out.append(" class=\"bg-sky-300 px-3 group-hover:bg-emerald-600 inline-block text-emerald-600 group-hover:text-white text-xs px-2.5 py-0.5 font-semibold rounded-full transition-all duration-500\">"+job_work_time+"</span>");
	    	out.append("</div>");
	    	out.append("");
	    	out.append("<div class=\"mt-6 h-[80px]\">");
	    	out.append("<a href=\"/home/jobs/detail?id="+item.getJob_id()+"\" ");
	    	out.append("class=\"text-lg hover:text-emerald-600 font-semibold transition-all duration-500\">");
	    	out.append(""+item.getJob_title()+"</a>");
	    	out.append("<h6 class=\"text-base font-normal\">");
	    	out.append("<i class=\"fa-solid fa-location-dot me-2\"></i> "+job_location+"");
	    	out.append("</h6>");
	    	out.append("</div>");
	    	out.append("<span class=\"text-lg text-false\"><i class=\"fa-solid fa-dollar-sign me-2\"></i>"+job_salary+"</span>");
	    	out.append("<div class=\"mt-6\">");
	    	out.append("<div class=\"w-full bg-gray-100 dark:bg-gray-800 rounded-full h-[6px]\">");
	    	out.append("<div class=\"bg-emerald-600 h-[6px] rounded-full\" style=\"width: 55%\"></div>");
	    	out.append("</div>");
	    	out.append("<div class=\"mt-2\">");
	    	out.append("<span class=\"text-slate-400 text-sm\">");
	    	out.append("<span class=\"text-slate-900 dark:text-white font-semibold inline-block\">");
	    	out.append("số lượng tuyển dụng : ");
	    	out.append("</span>");
	    	out.append(" "+item.getJob_quantity()+"");
	    	out.append("</span>");
	    	out.append("</div>");
	    	out.append("<div class=\"mt-6 flex justify-between items-center\">");
	    	 out.append("<button href=\"#\" type=\"button\" onclick=\"saveJobv2("+item.getJob_id()+", "+(user!=null?user.getUser_id():null)+")\" id=\"save-"+item.getJob_id()+"\" class=\"btn "+(isCheck(item.getJob_id(), JobSave)?"save-active":"")+" btn-icon px-2 py-2 rounded-full bg-emerald-600/5 hover:bg-emerald-600 border-emerald-600/10  text-emerald-600 hover:text-white\">");
	    	 out.append("<svg xmlns=\"http://www.w3.org/2000/svg\" width=\"24\" height=\"24\" viewBox=\"0 0 24 24\" fill=\"none\" stroke=\"currentColor\" stroke-width=\"2\" stroke-linecap=\"round\" stroke-linejoin=\"round\" class=\"feather feather-bookmark size-4\">");
	    	 out.append("<path d=\"M19 21l-7-5-7 5V5a2 2 0 0 1 2-2h10a2 2 0 0 1 2 2z\"></path>");
	    	 out.append("</svg>");
	    	 out.append("</button>");
	    	out.append("<a href=\"/home/jobs/detail?id="+item.getJob_id()+"\" class=\"btn btn-sm px-4 py-2 rounded-md bg-emerald-600 hover:bg-emerald-700 border-emerald-600 hover:border-emerald-700 text-white md:ms-2 lg:w-[200px] w-48 text-center \">Ứng tuyển ngay</a>");
	    	out.append("</div>");
	    	out.append("</div>");
	    	out.append("</div>");
	    	out.append("<!--end content-->");
	    });
		return out.toString();
	}
	
	public static String viewListArticle(ArrayList<ArticleObject> items) {
		StringBuffer out = new StringBuffer();
	
	    items.forEach(item -> {
			out.append("<div class=\"group relative article overflow-hidden bg-white dark:bg-slate-900 rounded-md shadow dark:shadow-gray-700\">");
			out.append("<div class=\"relative overflow-hidden article\">");
			out.append("<img src=\""+item.getArticle_image()+"\"");
			out.append("class=\"scale-110 article_img group-hover:scale-100 transition-all duration-500\" alt=\"\" />");
			out.append("</div>");
			out.append("");
			out.append("<div class=\"relative p-6\">");
			out.append("<div class=\"absolute start-6 -top-4\">");
			out.append("<span ");
			out.append("class=\"bg-emerald-600 px-3 text-white text-[12px] px-2.5 py-1 font-semibold rounded-full h-5\">"+item.getCategory_name()+"</span>");
			out.append("</div>");
			out.append("");
			out.append("<div class=\"\">");
			out.append("<div class=\"flex mb-4 justify-between\">");
			out.append("<span class=\"text-slate-400 text-sm me-2\">");
			out.append("<i class=\"fa-solid fa-calendar text-slate-900 dark:text-white me-2\"></i>");
			out.append(item.getArticle_created_date());
			out.append("</span>");
			out.append("<span class=\"text-slate-400 text-sm ms-3\">");
			out.append("<i class=\"fa-solid ms-2 fa-eye text-slate-900 dark:text-white me-2\"></i>"+item.getArticle_visited()+" lượt xem</span>");
			out.append("</div>");
			out.append("");
			out.append("<a href=\"/home/blogs/detail?id="+item.getArticle_id()+"\" class=\"title text-xl font-semibold hover:text-emerald-600 duration-500 ease-in-out\">");
			out.append(""+item.getArticle_title()+"</a>");
			out.append("<p class=\"text-small\">"+jsoft.library.Utilities_text.shortenText(item.getArticle_summary(), 20)+"</p>");
			out.append("<div class=\"flex justify-between items-center mt-3\">");
			out.append("<a href=\"/home/blogs/detail?id="+item.getArticle_id()+"\" ");
			out.append("class=\"btn btn-link hover:text-emerald-600 after:bg-emerald-600 duration-500 ease-in-out\">Đọc thêm");
			out.append("<i class=\"uil uil-arrow-right\"></i></a>");
			out.append("<span class=\"text-slate-400 text-sm\">by ");
			out.append("<a href=\"\"");
			out.append(" class=\"text-slate-900 dark:text-white hover:text-emerald-600 dark:hover:text-emerald-600 font-medium\">"+item.getArticle_author_name()+"</a></span>");
			out.append("</div>");
			out.append("</div>");
			out.append("</div>");
			out.append("</div>");
			out.append("<!--end content-->");
	    });
		return out.toString();
	}
	
	public static String viewFieldInFooter(ArrayList<FieldObject> items) {
		StringBuffer out = new StringBuffer();
		items.forEach(item -> {
			out.append("<p class=\"mb-4\">");
			   out.append("<a href=\"/home/jobs?f="+item.getField_id()+"\" class=\"text-blue-300\">"+item.getField_name()+"</a>");
			   out.append("</p>");
		}); 
		return out.toString();
	}
	
}