package jsoft.home.job;

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
import jsoft.objects.ProvinceObject;
import jsoft.objects.SkillObject;
import jsoft.objects.UserObject;

public class JobLibrary {
	

	public static String viewListJob(ArrayList<JobObject> items,HashMap<Integer, String> skills,int page,int total,String url,byte pagesize) {
		StringBuffer out = new StringBuffer();
		out.append("<div class=\"grid grid-cols-1 gap-[30px] mt-6\" data-aos=\"fade-up\" data-aos-duration=\"1000\">");
		if(items.size()<=0) {
			out.append("<h1 class=\"text-2xl text-center\">Không có tin tuyển dụng nào</h1>");
		} else {
	    items.forEach(item -> {
	    	String job_work_time = "";
	    	switch (item.getJob_work_time()) {
			case 1:
				job_work_time = "Fulltime";
				break;
			case 2:
				job_work_time = "PartTime)";
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
	    		 date = "<span class=\"inline-block text-sm text-false\">Hết hạn "+Math.abs(date_count)+" ngày</span>";
	    	 } else if(date_count==0) {
	    		 date = "<span class=\"inline-block text-sm text-true\">Hôm nay</span>";
	    	 }else {
	    		 date = "<span class=\"inline-block text-sm text-true\">Còn "+Math.abs(date_count)+" ngày</span>";
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
	    	 
	    	 String job_degree = "";
	    	 switch (item.getJob_degree()) {
				case 1:
					job_degree = "Trung học";
					break;
				case 2:
					job_degree = "Trung cấp";
					break;
				case 3:
					job_degree = "Cao đẳng";
					break;
				case 4:
					job_degree = "Cử nhân";
					break;
				case 5:
					job_degree = "Thạc sĩ";
					break;
				case 6:
					job_degree = "Tiến sĩ";
					break;
				case 7:
					job_degree = "Không yêu cầu";
					break;
				default:
					job_degree = "Lựa chọn không hợp lệ";
				}
	    	 StringBuilder job_status = new StringBuilder();
	    	
	    	 switch (item.getJob_status()) {
				case 0:
					 job_status.append("<span class=\"inline-block me-1 text-pending font-semibold\">");
					 job_status.append("<i class=\"fa-solid fa-x  text-pending text-lg rounded-full px-2 py-1 border-2 me-1\"></i>Đang chờ phê duyệt");
			    	 job_status.append("</span>");
					break;
				case 1:
					 job_status.append("<span class=\"inline-block text-true me-1 font-semibold\">");
			    	 job_status.append("<i class=\"fa-solid fa-check text-lg text-green-500 rounded-full px-2 py-1 border-2 me-1\"></i>Đang tuyển dụng");
			    	 job_status.append("</span>");
					break;
				case 2:
					 job_status.append("<span class=\"inline-block text-false me-1 font-semibold\">");
			    	 job_status.append("<i class=\"fa-solid fa-x  text-false text-lg rounded-full px-2 py-1 border-2 me-1\"></i>Đã hết hạn");
			    	 job_status.append("</span>");
					break;
				case 3:
					 job_status.append("<span class=\"inline-block text-false me-1 font-semibold\">");
			    	 job_status.append("<i class=\"fa-solid fa-x   text-false text-lg rounded-full px-2 py-1 border-2 me-1\"></i>Đã tuyển dụng");
			    	 job_status.append("</span>");
					break;
				case 4:
					 job_status.append("<span class=\"inline-block text-false me-1 font-semibold\">");
			    	 job_status.append("<i class=\"fa-solid fa-x  text-false text-lg rounded-full px-2 py-1 border-2 me-1\"></i>Tạm ngưng tuyển dụng");
			    	 job_status.append("</span>");
					break;
				case 5:
					 job_status.append("<span class=\"inline-block text-false me-1 font-semibold\">");
			    	 job_status.append("<i class=\"fa-solid fa-x  text-false text-lg rounded-full px-2 py-1 border-2 me-1\"></i>Đã hủy");
			    	 job_status.append("</span>");
					break;
				default:
					 job_status.append("<span class=\"inline-block text-false me-1 font-semibold\">");
			    	 job_status.append("<i class=\"fa-solid fa-x  text-false text-lg rounded-full px-2 py-1 border-2 me-1\"></i>Trạng thái không hợp lệ");
			    	 job_status.append("</span>");
				}

	    	 out.append("<div class=\"group relative overflow-hidden bg-white  shadow-lg rounded-md transition-all duration-500 h-fit\" id=\"job-item\">");
	    	 out.append("<div class=\"p-6\">");
	    	 out.append("<div class=\"flex items-center\">");
	    	 out.append("<div class=\"size-14 min-w-[56px] flex items-center justify-center bg-white  shadow dark:shadow-gray-700 rounded-md\">");
	    	 out.append("<img src=\""+item.getCompany().getCompany_logo()+"\" class=\"size-8\" alt=\"\">");
	    	 out.append("</div>");
	    	 out.append("");
	    	 out.append("<div class=\"ms-3\">");
	    	 out.append("<a href=\"/home/jobs/detail?id="+item.getJob_id()+"\" class=\"inline-block text-[16px] font-semibold hover:text-emerald-600 transition-all duration-500 me-1\">");
	    	 out.append(item.getJob_title());
	    	 out.append("</a> ");
	    	 out.append(date);
	    	 out.append("<div>");
	    	 out.append("<p class=\"text-slate-400\">"+item.getCompany().getCompany_name()+"</p>");
	    	 out.append("</div>");
	    	 out.append("</div>");
	    	 out.append("</div>");
	    	 out.append("");
	    	
	    	 out.append("<div class=\"my-2\">");
	    	 out.append("<span class=\"bg-emerald-600/10 inline-block text-emerald-600 text-xs px-2.5 py-0.5 font-semibold rounded-full me-1\">");
	    	 out.append(job_work_time);
	    	 out.append("</span> ");
	    	 out.append("<span class=\"text-sm font-medium inline-block ms-2\">Bằng cấp: ");
	    	 out.append("<span class=\"text-slate-400\">"+job_degree+"</span>");
	    	 out.append("</span> ");
	    	 out.append("<span class=\"text-sm font-medium inline-block ms-2\">Lương: ");
	    	 out.append("<span class=\"text-slate-400\">"+job_salary+"</span>");
	    	 out.append("</span>");
	    	 out.append("<span class=\"text-sm font-medium inline-block ms-2\">Số lượng tuyển dụng: ");
	    	 out.append("<span class=\"text-slate-400\">"+item.getJob_quantity()+"</span>");
	    	 out.append("</span>");
	    	 out.append("</div>");
	    	 
	    	 out.append("");
	    	 out.append("<div>");
	    	 
	    	 String skill = item.getJob_skills();
		    	
		    	if(skill!=null && !skill.equalsIgnoreCase("")) {
		    		String[] idSkill = skill.split(",");
		    		for (String idStr : idSkill) {
		    		    int id = Integer.parseInt(idStr);
		    		    if (skills.containsKey(id)) {
		    		        String name = skills.get(id);
		    		        if(name!=null&&!name.equalsIgnoreCase("")) {
		    			    	 out.append("<span class=\"bg-slate-100 dark:bg-slate-800 inline-block text-slate-900 dark:text-slate-300 text-xs px-2.5 py-0.5 font-semibold rounded-full me-1\">"+name+"</span>"); 
		    		        }
		    		    }
		    		}
		    	}

	    	 out.append("</div>");
	    	 out.append("</div>");
	    	 out.append("");
	    	 out.append("<div class=\" p-6 bg-slate-50 dark:bg-slate-800 flex justify-between items-center\">");
	    	 out.append("<div class=\"lg:inline-block flex items-center\">");
	    	 out.append(job_status.toString());
	    	 out.append("<span class=\"inline-block ms-2 text-slate-400\">");
	    	 out.append("<i class=\"fa-solid fa-location-dot me-2\"></i> "+job_location+"");
	    	 out.append("</span>");
	    	 out.append("</div>");
	    	 out.append("");
	    	 out.append("<a href=\"/home/jobs/detail?id="+item.getJob_id()+"\" class=\"btn btn-sm font-semibold px-3 py-2 me-6 rounded-md bg-emerald-600 hover:bg-emerald-700 border-emerald-600 hover:border-emerald-700 text-white w-48 text-center lg:w-auto lg:mt-0\">");
	    	 out.append("Apply Now");
	    	 out.append("</a>");
	    	 out.append("</div>");
	    	 out.append("");
	    	 out.append("<a href=\"\" class=\"btn btn-icon px-2 py-2 rounded-full bg-emerald-600/5 hover:bg-emerald-600 border-emerald-600/10  text-emerald-600 hover:text-white absolute top-0 end-0 m-3\">");
	    	 out.append("<svg xmlns=\"http://www.w3.org/2000/svg\" width=\"24\" height=\"24\" viewBox=\"0 0 24 24\" fill=\"none\" stroke=\"currentColor\" stroke-width=\"2\" stroke-linecap=\"round\" stroke-linejoin=\"round\" class=\"feather feather-bookmark size-4\">");
	    	 out.append("<path d=\"M19 21l-7-5-7 5V5a2 2 0 0 1 2-2h10a2 2 0 0 1 2 2z\"></path>");
	    	 out.append("</svg>");
	    	 out.append("</a>");
	    	 out.append("</div>");
	    	 out.append("<!--end content-->");
	    	
	    });
		}
			out.append("</div><!--end joblist-->");
			out.append("<div class=\"grid md:grid-cols-12 grid-cols-1 mt-8\">");
			out.append("<div class=\"md:col-span-12 text-center\">");
			if(items.size()>0) {
				out.append(pagination(total, pagesize, page, url));
			}
			out.append("</div>");
			out.append("<!--end col-->");
			out.append("</div>");
		return out.toString();
	}
	
	public static String provicesOption(ArrayList<ProvinceObject> items,String province) {
		StringBuilder out = new StringBuilder();
		out.append("<option value=\"\">Tất cả</option>");
		items.forEach(item-> {
			if(item.getName().equalsIgnoreCase(province)) {
				out.append("<option value=\""+item.getName()+"\" selected>"+item.getName()+"</option>");
			} else {
				out.append("<option value=\""+item.getName()+"\">"+item.getName()+"</option>");
			}
		});
		
		return out.toString();
	}
	public static String careerOption(ArrayList<CareerObject> items,int id) {
		StringBuilder out = new StringBuilder();
		out.append("<option value=\"0\">Tất cả</option>");
		items.forEach(item-> {
			if(item.getCareer_id()==id) {
				out.append("<option value=\""+item.getCareer_id()+"\" selected>"+item.getCareer_name()+"</option>");
			} else {
				out.append("<option value=\""+item.getCareer_id()+"\">"+item.getCareer_name()+"</option>");
			}
			
		});
		
		return out.toString();
	}
	public static String SearchInput(String key) {
		StringBuilder out = new StringBuilder();
		out.append("<input onblur=\"submitForm()\" name=\"key\" id=\"searchname\" value=\""+key+"\" type=\"text\" class=\"form-input w-full border border-slate-100 dark:border-slate-800 ps-10\" placeholder=\"Search\">");
		return out.toString();
	}
	public static String countJob(int count,String key) {
		String str = "Tuyển dụng <span class=\"text-xl font-bold\">"+count+"</span> vị trí việc làm ";
		if(key!=null && !key.equalsIgnoreCase("")) {
			str+="với từ khóa <span class=\"text-true text-lg\">"+key+"</span><i class=\"fa-solid fa-magnifying-glass ms-1\"></i>";
		}
		return str;
	}
	public static String sortView(String url) {
		StringBuilder out = new StringBuilder();
        String urlOld = url;
        System.out.println(url);
		if (url.contains("?")) {
		    url += "&";
		} 
		else if(url.contains("?") && url.contains("&"))  {
		    url += "&";
		}else  {
		    url += "?";
		}

		

		if (url.contains("&sort=")) {
		    url = url.replaceAll("&sort=[^&]+", "");
		} else if (url.contains("?sort=")) {
		    url = url.replaceAll("\\?sort=[^&]+", "?");
		}

		String general = url + "sort=general";
		String lasted = url + "sort=lasted";
		String oldest = url + "sort=oldest";
		String AtoZ = url + "sort=atoz";
		String ZtoA = url + "sort=ztoa";
		
		out.append("<ul class=\"flex\">");
		out.append("<li class=\"me-2 border hover:bg-emerald-700 hover:text-white rounded px-3 py-2 "+(urlOld.contains("general")?"bg-emerald-600 text-white":"bg-gray-100")+"\">");
		out.append("<a href=\"" + general + "\">Mặc định</a></li>");
		out.append("<li class=\"me-2 border hover:bg-emerald-700 hover:text-white rounded px-3 py-2 "+(urlOld.contains("lasted")?"bg-emerald-600 text-white":"bg-gray-100")+"\">");
		out.append("<a href=\"" + lasted + "\">Mới nhất</a></li>");
		out.append("<li class=\"me-2 border hover:bg-emerald-700 hover:text-white rounded px-3 py-2 "+(urlOld.contains("oldest")?"bg-emerald-600 text-white":"bg-gray-100")+"\">");
		out.append("<a href=\"" + oldest + "\">Cũ nhất</a></li>");
		out.append("<li class=\"me-2 border hover:bg-emerald-700 hover:text-white rounded px-3 py-2 "+(urlOld.contains("atoz")?"bg-emerald-600 text-white":"bg-gray-100")+"\">");
		out.append("<a href=\"" + AtoZ + "\"><i class=\"fa-solid fa-arrow-up-a-z\"></i></a></li>");
		out.append("<li class=\"me-2 border hover:bg-emerald-700 hover:text-white rounded px-3 py-2 "+(urlOld.contains("ztoa")?"bg-emerald-600 text-white":"bg-gray-100")+"\">");
		out.append("<a href=\"" + ZtoA + "\"><i class=\"fa-solid fa-arrow-down-z-a\"></i></a></li>");
		out.append("</ul>");
		return out.toString();
	}
	public static StringBuilder pagination(int total, Byte pageSize,int page,String url) {
//		System.out.println(total);
		 String urlOld = url;
		 System.out.println(url.indexOf("?"));
		 	if (url.contains("?")) {
			    url += "&";
			} 
			else if(url.contains("?") && url.contains("&"))  {
			    url += "&";
			}else  {
			    url += "?";
			}
			if (url.contains("&page=")) {
			    url = url.replaceAll("&page=[^&]+", "");
			} else if (url.contains("?page=")) {
			    url = url.replaceAll("\\?page=[^&]+", "?");
			}
			url=url+"page=";
		 page =(page<=1)? 1 : page;
		 
		int totalPage = total < pageSize ? 1 : (int) Math.ceil((double) total / pageSize);

		if (total % pageSize == 0) {
			totalPage = totalPage - 1;
		}

		
		StringBuilder out = new StringBuilder();
		//phan trang
		if(total>0) {
		out.append("<nav aria-label=\"Page navigation example\">");
		out.append("<ul class=\"inline-flex items-center -space-x-px\">");
		
		String isPrevious = (page<=1)?"hidden":"text-slate-900 bg-white";
		String isNext = (page==totalPage)?"hidden":"text-slate-900 bg-white";
		
		out.append("<li class=\"page-item\">");
		out.append("<a class=\"size-[40px] inline-flex justify-center "+isPrevious+" items-center text-slate-400 bg-white  rounded-s-3xl hover:text-white border border-gray-100    hover:bg-emerald-600 \" href=\""+url+(page > 1 ? page - 1 : 1)+"\" tabindex=\"-1\" aria-disabled=\"true\"><span aria-hidden=\"true\">&laquo;</span></a></a>");
		out.append("</li>");
		if(page>=4) {
		out.append("<li class=\"page-item\">");
		out.append("<a class=\"size-[40px] inline-flex justify-center items-center text-slate-400 bg-white  hover:text-white border border-gray-100    hover:bg-emerald-600 \" href=\""+url+"1"+"\" tabindex=\"-1\" aria-disabled=\"true\"><span aria-hidden=\"true\">1</span></a></a>");
		out.append("</li>");
		}
		//left current
		String leftCurrent = "";
		int count=0;
		for(int i=page-1;i>0;i--) {
			leftCurrent = "<li class=\"page-item\"><a class=\"size-[40px] inline-flex justify-center items-center text-slate-400 bg-white  hover:text-white border border-gray-100    hover:bg-emerald-600 \" href=\""+url+""+i+"\">"+i+"</a></li>"+leftCurrent;

			if(++count>=2) {
				break;
			}
		}
		if(page>=4) {
			leftCurrent = "<li class=\"page-item disabled\"><a class=\"size-[40px] inline-flex justify-center items-center text-slate-400 bg-white   hover:text-white border border-gray-100    hover:bg-emerald-600 \" href=\"#\">....</a></li>"+leftCurrent;
		}
		out.append(leftCurrent);
		
		out.append(" <li class=\"page-item\" aria-current=\"page\">");
		out.append("<a class=\"size-[40px] inline-flex justify-center items-center bg-emerald-600 text-white   hover:text-gray-100 border border-gray-100    hover:bg-emerald-600 \" href=\""+url+page+"\">"+page+"</a>");
		out.append("</li>");
		
		String rightCurrent ="";
		 count = 0;
		for(int i=page+1;i<=totalPage;i++) {
			rightCurrent+="<li class=\"page-item\"><a class=\"size-[40px] inline-flex justify-center items-center text-slate-400 bg-white  hover:text-white border border-gray-100    hover:bg-emerald-600 \" href=\""+url+i+"\">"+i+"</a></li>";
			if(++count>=2) {
				break;
			}
		}
	
		if(totalPage>page+2) {
			rightCurrent += "<li class=\"page-item disabled\"><a class=\"size-[40px] inline-flex justify-center items-center text-slate-400 bg-white  hover:text-white border border-gray-100    hover:bg-emerald-600 \" href=\"#\">....</a></li>";
		}
		out.append(rightCurrent);
		if(page<totalPage-2) {
		out.append("<li class=\"page-item\" >");
		out.append("<a class=\"size-[40px] inline-flex justify-center items-center text-slate-400 bg-white  hover:text-white border border-gray-100    hover:bg-emerald-600 \"  href=\""+url+totalPage+"\"><span aria-hidden=\"true\">"+totalPage+"</span></a></a>");
		out.append("</li>");
		}
		out.append("<li class=\"page-item \" >");
		out.append("<a class=\"size-[40px] inline-flex justify-center items-center "+isNext+"  rounded-e-3xl hover:text-white border border-gray-100   hover:bg-emerald-600 \"  href=\""+url+(page < totalPage ? page + 1 : totalPage)+"\"><span aria-hidden=\"true\">&raquo;</span></a></a>");
		out.append("</li>");
		out.append("</ul>");
		out.append("</nav><!-- End Disabled and active states -->");
		}
		return out;
	}
	public static String getTotal(int total) {
		StringBuilder out = new StringBuilder();
		out.append(total);
		return out.toString();
	}
}