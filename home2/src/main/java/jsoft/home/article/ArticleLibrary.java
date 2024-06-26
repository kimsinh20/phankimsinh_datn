package jsoft.home.article;

import java.util.ArrayList;

import jsoft.objects.ArticleObject;
import jsoft.objects.CategoryObject;

public class ArticleLibrary {

	public static String viewList(ArrayList<ArticleObject> items,int page,int total,String url,byte pagesize) {
		StringBuffer out = new StringBuffer();

		out.append("<div class=\"grid lg:grid-cols-3 md:grid-cols-2 grid-cols-1 gap-[30px] mt-6\" data-aos=\"fade-up\" data-aos-duration=\"1000\">");
		if(items.size()<=0) {
			out.append("<h1 class=\"text-2xl text-center\">Không có bài viết nào</h1>");
		} else {
	    items.forEach(item -> {
	    	 out.append("<div class=\"group  mt-4 overflow-hidden bg-white  shadow-lg rounded-md transition-all duration-500 h-fit\" id=\"company-item\">");
	    	 out.append("<div class=\"p-4 relative\">");
	    	 out.append("<div class=\"flex items-center\">");
	    	 out.append("<div class=\"size-14 min-w-[56px] flex items-center justify-center bg-white  shadow dark:shadow-gray-700 rounded-md\">");
	    	 out.append("<img src=\""+item.getArticle_image()+"\" class=\"size-8\" alt=\"\">");
	    	 out.append("</div>");
	    	 out.append("");
	    	 out.append("<div class=\"ms-3\">");
	    	 out.append("<a href=\"/home/blogs/detail?id="+item.getArticle_id()+"\" class=\"inline-block text-[16px] font-semibold hover:text-emerald-600 transition-all duration-500 me-1\">");
	    	 out.append(item.getArticle_title());
	    	 out.append("</a> ");
	    	 out.append("<div>");
	    	 out.append("<p class=\"text-slate-400\">"+item.getArticle_visited()+" lượt xem</p>");
	    	 out.append("</div>");
	    	 out.append("</div>");
	    	 out.append("</div>");
	    	 out.append("");
	    	 
	    	 out.append("");
	    	 
	    	
	    	 out.append("</div>");
	    	 out.append("");
	    	 out.append("<div class=\"p-4 shadow rounded\">");
	    	 out.append("<div class=\"flex  items-center\">");
	    	 out.append("<span class=\"inline-block ms-2 text-slate-400\">");
	    	 out.append(jsoft.library.Utilities_text.shortenText(item.getArticle_summary(), 20));
	    	 out.append("</span>");
	    	 out.append("</div>");
	    	 
	    	 out.append("<div class=\"mt-4\">");
	    	 out.append("<a href=\"/home/blogs/detail?id="+item.getArticle_id()+"\" class=\"btn btn-sm font-semibold px-2 py-1 w-full block border-2 border-green-400 rounded-md bg-emerald-600/5 hover:bg-emerald-600 text-emerald-600 hover:text-white text-center\">");
	    	 out.append("Đọc thêm");  
	    	 out.append("</a>");
	    	 out.append("</div>");
	    	 
	    	 out.append("</div>");
	    	 
	    	 out.append("</div>");
	    	 out.append("<!--end content-->");
	    	
	    });
		
			out.append("</div><!--end joblist-->");
			out.append("<div class=\"grid md:grid-cols-12 grid-cols-1 mt-8\">");
			out.append("<div class=\"md:col-span-12 text-center\">");
			if(items.size()>0) {
				out.append(pagination(total, pagesize, page, url));
			}
			out.append("</div>");
			out.append("<!--end col-->");
			out.append("</div>");
		}
		return out.toString();
		
	}
	
	public static String cateOption(ArrayList<CategoryObject> items,int id) {
		StringBuilder out = new StringBuilder();
		out.append("<option value=\"0\">Tất cả</option>");
		items.forEach(item-> {
			if(item.getCategory_id()==id) {
				out.append("<option value=\""+item.getCategory_id()+"\" selected>"+item.getCategory_name()+"</option>");
			} else {
				out.append("<option value=\""+item.getCategory_id()+"\">"+item.getCategory_name()+"</option>");
			}
			
		});
		
		return out.toString();
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

		String visited = url + "sort=visited";
		String lasted = url + "sort=lasted";
		String oldest = url + "sort=oldest";
		String AtoZ = url + "sort=atoz";
		String ZtoA = url + "sort=ztoa";
		
		out.append("<ul class=\"flex\">");
		out.append("<li class=\"me-2 border hover:bg-emerald-700 hover:text-white rounded px-3 py-2 "+(urlOld.contains("visited")?"bg-emerald-600 text-white":"bg-gray-100")+"\">");
		out.append("<a href=\"" + visited + "\">Mặc định</a></li>");
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
	
	
}
