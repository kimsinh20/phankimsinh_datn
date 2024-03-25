package jsoft.home.article;

import jsoft.library.Utilities;
import jsoft.objects.*;
import java.util.*;

import javax.mail.FetchProfile.Item;

import org.apache.jasper.tagplugins.jstl.core.ForEach;
import org.javatuples.*;

public class ArticleLibrary {

	public static ArrayList<String> viewPostGrid(Pair<ArrayList<ArticleObject>, ArrayList<ArticleObject>> datas) {

		ArrayList<String> view = new ArrayList<>();

		// lay danh sach bai viet moi nhat
		ArrayList<ArticleObject> items = datas.getValue0();

		// lay danh sach bai viet dc xem nhieu nhat
		ArrayList<ArticleObject> most_items = datas.getValue1();

		StringBuilder tmp = new StringBuilder();
		if (items.size() > 0) {
			// vi tri dau tien
			ArticleObject item = items.get(0);
			tmp.append("<div class=\"post-entry-1 lg\">");
			tmp.append("<a href=\"/home/news?id="+item.getArticle_id()+"\"><img ");
			tmp.append("src=\"" + item.getArticle_image() + "\" alt=\"\" class=\"img-fluid\"></a>");
			tmp.append("<div class=\"post-meta\">");
			tmp.append(
					"<span class=\"date\">" + item.getCategory_name() + "</span> <span class=\"mx-1\">&bullet;</span>");
			tmp.append("<span>" + item.getArticle_created_date() + "</span>");
			tmp.append("</div>");
			tmp.append("<h2>");
			tmp.append("<a href=\"/home/news?id="+item.getArticle_id()+"\">" + item.getArticle_title() + "</a>");
			tmp.append("</h2>");
			tmp.append("<p class=\"mb-4 d-block\">" + item.getArticle_summary() + "</p>");
			tmp.append("");
			tmp.append("<div class=\"d-flex align-items-center author\">");
			tmp.append("<div class=\"photo\">");
			tmp.append("<img src=\"/home/img/person-1.jpg\" alt=\"\" class=\"img-fluid\">");
			tmp.append("</div>");
			tmp.append("<div class=\"name\">");
			tmp.append("<h3 class=\"m-0 p-0\">" + item.getArticle_author_name() + "</h3>");
			tmp.append("</div>");
			tmp.append("</div>");
			tmp.append("</div>");

			view.add(tmp.toString());

			// 2 cot
			tmp.setLength(0);
			for (int i = 1; i < items.size(); i++) {
				if (i % 2 == 1) {
					tmp.append("<div class=\"col-lg-4 border-start custom-border\">");
				}
				item = items.get(i);
				tmp.append("<div class=\"post-entry-1\">");
				tmp.append("<a href=\"/home/news?id="+item.getArticle_id()+"\"><img ");
				tmp.append("src=\"" + item.getArticle_image() + "\" alt=\"\" class=\"img-fluid\"></a>");
				tmp.append("<div class=\"post-meta\">");
				tmp.append("<span class=\"date\">" + item.getCategory_name()
						+ "</span> <span class=\"mx-1\">&bullet;</span>");
				tmp.append("<span>" + item.getArticle_author_name() + "</span>");
				tmp.append("</div>");
				tmp.append("<h2>");
				tmp.append("<a href=\"/home/news?id="+item.getArticle_id()+"\">" + item.getArticle_title() + "</a>");
				tmp.append("</h2>");
				tmp.append("</div>");
				if ((i % 2 == 0) || (i == items.size() - 1)) {
					tmp.append("</div>");
				}
			}

		}

		tmp.append("<div class=\"col-lg-4\">");
		tmp.append("<div class=\"trending\">");
		tmp.append("<h3>Xu hướng</h3>");
		tmp.append("<ul class=\"trending-post\">");
		if (most_items.size() > 0) {

			most_items.forEach(mi -> {
				tmp.append("<li><a href=\"/home/tin-tuc/?id=" + mi.getArticle_id() + "\"> <span class=\"number\">"
						+ (most_items.indexOf(mi) + 1) + "</span>");
				tmp.append("<h3>" + mi.getArticle_title() + "</h3> <span");
				tmp.append("class=\"author\">" + mi.getArticle_author_name() + "</span>");
				tmp.append("</a></li>");
			});
		}
		tmp.append("</ul>");
		tmp.append("</div>");
		tmp.append("</div>");

		view.add(tmp.toString());

		return view;
	}

	public static ArrayList<String> viewNews(Sextet<ArrayList<ArticleObject>, ArrayList<ArticleObject>,ArrayList<CategoryObject>,HashMap<String, Integer>,Integer,ArrayList<ArticleObject>> datas,
			Quartet<ArticleObject, Integer, Byte,Boolean> infos) {

		ArrayList<String> view = new ArrayList<>();

		// lay danh sach bai viet moi nhat
		ArrayList<ArticleObject> items = datas.getValue0();

		// lay danh sach bai viet dc xem nhieu nhat
		ArrayList<ArticleObject> most_items = datas.getValue1();
		
		// danh sach the loai
		ArrayList<CategoryObject> cates = datas.getValue2();
		
		// danh sach tag
		HashMap<String, Integer> tags = datas.getValue3();
		// tong so ban ghi
		int total = datas.getValue4();
		// co phan trang
		ArrayList<ArticleObject> list_most_items = datas.getValue5();
		
		ArticleObject similar = infos.getValue0();
		int page = infos.getValue1();
		byte totalInPage = infos.getValue2();
	

		StringBuilder tmp = new StringBuilder();

		tmp.append("<section>");
		tmp.append("<div class=\"container\">");
		tmp.append("<div class=\"row\">");
		
		tmp.append("<div class=\"col-md-9\" data-aos=\"fade-up\">");
		
		tmp.append(ArticleLibrary.viewCategoryOptions(cates,similar));
		
		list_most_items.forEach(item -> {
			
			tmp.append("<div class=\"d-md-flex post-entry-2 half\">");
			tmp.append("<a href=\"/home/news?id="+item.getArticle_id()+"\" class=\"me-4 thumbnail\">");
			tmp.append("<img width=\"483px\" src=\""+item.getArticle_image()+"\" alt=\""+item.getArticle_title()+"\" class=\"img-fluid\">");
			tmp.append("</a>");
			tmp.append("<div>");
			tmp.append("<div class=\"post-meta\"><span class=\"date\">"+item.getCategory_name()+"</span> <span class=\"mx-1\">&bullet;</span> <span>"+item.getArticle_created_date()+"</span></div>");
			tmp.append("<h3><a href=\"/home/news?id="+item.getArticle_id()+"\">"+item.getArticle_title()+"</a></h3>");
			tmp.append("<p>"+item.getArticle_summary()+"</p>");
			tmp.append("<div class=\"d-flex align-items-center author\">");
			tmp.append("<div class=\"photo\"><img src=\"/home/img/person-2.jpg\" alt=\""+item.getArticle_author_name()+"\" class=\"img-fluid\"></div>");
			tmp.append("<div class=\"name\">");
			tmp.append("<h3 class=\"m-0 p-0\">"+item.getArticle_author_name()+"</h3>");
			tmp.append("</div>");
			tmp.append("</div>");
			tmp.append("</div>");
			tmp.append("</div>");
		});
		// phan trang
		String url = "/home/news?page=";
        String tag = similar.getArticle_tag();
        if(!tag.equalsIgnoreCase("")) {
        	url= "/home/news?tag="+tag+"&page=";
        }
		int cid = similar.getArticle_category_id();
		tmp.append(getPagination(url, total, page, totalInPage,cid));
	
		tmp.append("</div>");// end col-md-9
		 
		tmp.append(viewSideBar(items,most_items, cates, tags));
		
		
		
		tmp.append("</div>");
		tmp.append("</div>");
		tmp.append("</section>");
		
		tmp.append("<script language=\"javascript\" >");
		tmp.append("function refreshCate(fn) {");
		tmp.append("let cate_id = fn.slcCateId.value;");
		tmp.append("fn.method = 'post';");
		tmp.append("fn.action = `/home/news?cid=${cate_id}`;");
		tmp.append("fn.submit();");
		tmp.append("}");
		tmp.append("</script>");
		
		view.add(tmp.toString());
		return view;
	}
	public static ArrayList<String> viewDetail(Sextet<ArrayList<ArticleObject>, ArrayList<ArticleObject>,ArrayList<CategoryObject>,HashMap<String, Integer>,Integer,ArrayList<ArticleObject>> datas,
			Quartet<ArticleObject, Integer, Byte,Boolean> infos) {

		ArrayList<String> view = new ArrayList<>();

		// lay danh sach bai viet moi nhat
		ArrayList<ArticleObject> items = datas.getValue0();

		// lay danh sach bai viet dc xem nhieu nhat
		ArrayList<ArticleObject> most_items = datas.getValue1();
		
		// danh sach the loai
		ArrayList<CategoryObject> cates = datas.getValue2();
		
		// danh sach tag
		HashMap<String, Integer> tags = datas.getValue3();
		ArrayList<ArticleObject> list_most_items = datas.getValue5();
		
		ArticleObject item = null;
		if(list_most_items.size()>0) {
			item = list_most_items.get(0);
		}

		StringBuilder tmp = new StringBuilder();

		tmp.append("<section>");
		tmp.append("<div class=\"container\">");
		tmp.append("<div class=\"row\">");
		 
		tmp.append(" <div class=\"col-md-9 post-content\" data-aos=\"fade-up\">");
		if(item!=null) {
		tmp.append("<div class=\"single-post\">");
		
		tmp.append("<div class=\"post-meta\"><span class=\"date\">"+item.getCategory_name()+"</span> <span class=\"mx-1\">&bullet;</span> <span>"+item.getArticle_created_date()+"</span></div>");
		tmp.append("<h1 class=\"mb-5\">"+item.getArticle_title()+"</h1>");
		tmp.append("<p><span class=\"firstcharacter\">"+item.getArticle_summary().substring(0, 1)+"</span>"+item.getArticle_summary().substring(1)+"</p>");
		
		tmp.append("<figure class=\"my-4 text-center \">");
		tmp.append("<img src=\""+item.getArticle_image()+"\" alt=\"\" width=\"500\" style=\"max-width: 720px;\" class=\"img-fluid\">");
		tmp.append("<figcaption>Ảnh minh họa</figcaption>");
		tmp.append("</figure>");
		tmp.append(Utilities.decode(item.getArticle_content()));
		tmp.append("<span class=\"fs-5\">Nguồn : <a class=\"link-underline-success\" href=\"#\">"+item.getArticle_source()+"</a></span>");
		
		// tag
		 String tag;
         String[] tagList;
      
     	tag =(item.getArticle_tag()!=null)? Utilities.decode(item.getArticle_tag()).toLowerCase():"";
		tagList = tag.split(",");
		
		tmp.append("<div id=\"box_tag mt-3\">");
		tmp.append("<h3 class=\"txt_tag fs-4\">Tags:</h3>");
		for(String word:tagList) {
			if(!"".equalsIgnoreCase(word)) {
				word = word.trim();
				tmp.append("<h5 class=\"tag_item\">");
				tmp.append("<a class=\"fs-5\" href=\"/home/news?tag="+word+"\" title=\""+word+"\">");
				tmp.append(word);
				tmp.append("</a>");
				tmp.append("</h5>");
			}
		}
		tmp.append("</div>");
		
		tmp.append("</div>");
		}
		tmp.append("</div>");//end col-md-9
		
		tmp.append(viewSideBar(items,most_items, cates, tags));
		
		tmp.append("</div>");
		tmp.append("</div>");
		tmp.append("</section>");
		
		tmp.append("<script language=\"javascript\" >");
		tmp.append("function refreshCate(fn) {");
		tmp.append("let cate_id = fn.slcCateId.value;");
		tmp.append("fn.method = 'post';");
		tmp.append("fn.action = `/home/news?cid=${cate_id}`;");
		tmp.append("fn.submit();");
		tmp.append("}");
		tmp.append("</script>");
		
		view.add(tmp.toString());
		
		return view;
	}
	private static StringBuilder viewCategoryOptions(ArrayList<CategoryObject> cates,ArticleObject similar) {
		StringBuilder tmp = new StringBuilder();

		tmp.append("<div class=\"row align-item-center mb-5\">");
		tmp.append("<div class=\"col-sm-3\">");
		tmp.append("<h3>Thể loại: </h3>");
		tmp.append("</div>");
		tmp.append("<div class=\"col-sm-4\">");
		tmp.append("<form>");
		tmp.append("<select name=\"slcCateId\" class=\"form-select\" onchange=\"refreshCate(this.form)\">");
		tmp.append("<option value=\"0\">-----Tùy chọn-----</option>");
		cates.forEach(cate-> {
			if(cate.getCategory_id()==similar.getArticle_category_id()) {
				tmp.append("<option class=\"my-2\" value=\"").append(cate.getCategory_id()).append("\"selected>");
			} else {
				tmp.append("<option class=\"my-2\" value=\"").append(cate.getCategory_id()).append("\">");
			}
			
			tmp.append(cate.getCategory_name());
			tmp.append("</option>");
		});
		tmp.append("</select>");
		tmp.append("</form>");
		tmp.append("</div>");
		tmp.append("</div>");
		return tmp;
	}
	public static StringBuilder ViewFooter(Pair<ArrayList<ArticleObject>, ArrayList<CategoryObject>> datas) {
		StringBuilder tmp = new StringBuilder();
		// lay danh sach bai viet moi nhat
		ArrayList<ArticleObject> items = datas.getValue0();
				
		// danh sach the loai
		ArrayList<CategoryObject> cates = datas.getValue1();
		
		tmp.append("<div class=\"col-6 col-lg-2\">");
		tmp.append("<h3 class=\"footer-heading\">Thể loại</h3>");
		tmp.append("<ul class=\"footer-links list-unstyled\">");
		cates.forEach(cate->{
			tmp.append("<li>");
			tmp.append("<a href=\"/home/news?cid="+cate.getCategory_id()+"\"><i class=\"bi bi-chevron-right\"></i> "+cate.getCategory_name()+"</a>");
			tmp.append("</li>");
		});
		
		tmp.append("</ul>");
		tmp.append("</div>");
		tmp.append("<div class=\"col-lg-4\">");
		tmp.append("<h3 class=\"footer-heading\">Bài viết mới nhất</h3>");
		tmp.append("<ul class=\"footer-links footer-blog-entry list-unstyled\">");
		items.forEach(item-> {
		tmp.append("<li>");
		tmp.append("<a href=\"#\" class=\"d-flex align-items-center\">");
		tmp.append("<img src=\""+item.getArticle_image()+"\" alt=\"\" class=\"img-fluid me-3\">");
		tmp.append("<div>");
		tmp.append("<div class=\"post-meta d-block\">");
		tmp.append("<span class=\"date\">"+item.getCategory_name()+"</span> <span class=\"mx-1\">&bullet;</span>");
		tmp.append("<span>"+item.getArticle_created_date()+"</span>");
		tmp.append("</div>");
		tmp.append("<span>"+item.getArticle_title()+"</span>");
		tmp.append("</div>");
		tmp.append("</a></li>");
		});
		tmp.append("</ul>");
		tmp.append("</div>");
		return tmp;
	}
	private static StringBuilder getPagination(String url,int total,int page,int totalPerPage,int cid) {
		StringBuilder tmp = new StringBuilder();
		String urlkey ="";
		if(cid>0) {
			urlkey="&cid="+cid;
		} else {
			urlkey="";
		}
		short pages =(short) (total < totalPerPage ? 1 : (int) Math.ceil((double) total / totalPerPage));
		if (total % totalPerPage == 0) {
			pages = (short) (pages - 1);
		}
		 page =(page<=0 || page>pages)? 1 : page;
		
		tmp.append("<div class=\"text-start py-4\">");
		tmp.append("<div class=\"custom-pagination\">");
		if(total>0) {
			tmp.append("<a  href=\""+url+""+(page > 1 ? page - 1 : 1)+urlkey+"\" tabindex=\"-1\" aria-disabled=\"true\"><span aria-hidden=\"true\">&laquo;</span></a></a>");
			
			if(page>=4) {
			tmp.append("<a  href=\""+url+"1"+urlkey+"\" tabindex=\"-1\" aria-disabled=\"true\"><span aria-hidden=\"true\">1</span></a></a>");
			}
			//left current
			String leftCurrent = "";
			int count=0;
			for(int i=page-1;i>0;i--) {
				leftCurrent = "<a  href=\""+url+""+i+urlkey+"\">"+i+"</a>"+leftCurrent;

				if(++count>=2) {
					break;
				}
			}
			if(page>=4) {
				leftCurrent = "<a  href=\"#\">....</a>"+leftCurrent;
			}
			tmp.append(leftCurrent);
			
			tmp.append("<a  href=\""+url+""+page+urlkey+"\" class=\"active\">"+page+"</a>");
			
			String rightCurrent ="";
			 count = 0;
			for(int i=page+1;i<=pages;i++) {
				rightCurrent+="<a  href=\""+url+""+i+urlkey+"\">"+i+"</a>";
				if(++count>=2) {
					break;
				}
			}
		
			if(pages>page+2) {
				rightCurrent += "<a  href=\"#\">....</a>";
			}
			
			tmp.append(rightCurrent);
			
			if(page<pages-2) {
			tmp.append("<a href=\""+url+""+pages+urlkey+"\"><span aria-hidden=\"true\">"+pages+"</span></a></a>");
			}
			tmp.append("<a href=\""+url+""+(page < pages ? page + 1 : pages)+urlkey+"\"><span aria-hidden=\"true\">&raquo;</span></a></a>");
			}
		tmp.append("</div>");
		tmp.append("</div>");// text start
		return tmp;
	}
	private static StringBuilder viewSideBar(ArrayList<ArticleObject> items,
			ArrayList<ArticleObject> most_items,
			ArrayList<CategoryObject> cates,
			HashMap<String, Integer> tags) {
		StringBuilder tmp = new StringBuilder();
		tmp.append("<div class=\"col-md-3\">");
		tmp.append("<!-- ======= Sidebar ======= -->");
		tmp.append("<div class=\"aside-block\">");
		
		tmp.append("<ul class=\"nav nav-pills custom-tab-nav mb-4\" id=\"pills-tab\" role=\"tablist\">");
		tmp.append("<li class=\"nav-item\" role=\"presentation\">");
		tmp.append("<button class=\"nav-link active\" id=\"pills-trending-tab\" data-bs-toggle=\"pill\" data-bs-target=\"#pills-trending\" type=\"button\" role=\"tab\" aria-controls=\"pills-trending\" aria-selected=\"true\">Xu hướng</button>");
		tmp.append("</li>");
		tmp.append("<li class=\"nav-item\" role=\"presentation\">");
		tmp.append("<button class=\"nav-link\" id=\"pills-latest-tab\" data-bs-toggle=\"pill\" data-bs-target=\"#pills-latest\" type=\"button\" role=\"tab\" aria-controls=\"pills-latest\" aria-selected=\"false\">Mới nhất</button>");
		tmp.append("</li>");
		tmp.append("</ul>");
		
		tmp.append("<div class=\"tab-content\" id=\"pills-tabContent\">");
		
		tmp.append("<!-- Trending -->");
		tmp.append("<div class=\"tab-pane fade show active\" id=\"pills-trending\" role=\"tabpanel\" aria-labelledby=\"pills-trending-tab\">");
		items.forEach(item->{
		tmp.append("<div class=\"post-entry-1 border-bottom\">");
		tmp.append("<div class=\"post-meta\"><span class=\"date\">"+item.getCategory_name()+"</span> <span class=\"mx-1\">&bullet;</span> <span>"+item.getArticle_created_date()+"</span></div>");
		tmp.append("<h2 class=\"mb-2\"><a href=\"/home/news?id="+item.getArticle_id()+"\">"+item.getArticle_title()+"</a></h2>");
		tmp.append("<span class=\"author mb-3 d-block\">"+item.getArticle_author_name()+"</span>");
		tmp.append("</div>");
		});
		tmp.append("</div> <!-- End Trending -->");
		
		tmp.append("<!-- Latest -->");
		tmp.append("<div class=\"tab-pane fade\" id=\"pills-latest\" role=\"tabpanel\" aria-labelledby=\"pills-latest-tab\">");
		
		most_items.forEach(item->{
		tmp.append("<div class=\"post-entry-1 border-bottom\">");
		tmp.append("<div class=\"post-meta\"><span class=\"date\">"+item.getCategory_name()+"</span> <span class=\"mx-1\">&bullet;</span> <span>"+item.getArticle_created_date()+"</span></div>");
		tmp.append("<h2 class=\"mb-2\"><a href=\"/home/news?id="+item.getArticle_id()+"\">"+item.getArticle_title()+"</a></h2>");
		tmp.append("<span class=\"author mb-3 d-block\">"+item.getArticle_author_name()+"</span>");
		tmp.append("</div>");
		});
		tmp.append("</div> <!-- End Latest -->");
		
		tmp.append("</div>");
		tmp.append("</div>");
		tmp.append("<div class=\"aside-block\">");
		tmp.append("<h3 class=\"aside-title\">Video</h3>");
		tmp.append("<div class=\"video-post\">");
		tmp.append("<a href=\"https://www.ytmpube.com/watch?v=AiFfDjmd0jU\" class=\"glightbox link-video\">");
		tmp.append("<span class=\"bi-play-fill\"></span>");
		tmp.append("<img src=\"/home/img/post-landscape-5.jpg\" alt=\"\" class=\"img-fluid\">");
		tmp.append("</a>");
		tmp.append("</div>");
		tmp.append("</div><!-- End Video -->");
		tmp.append("<div class=\"aside-block\">");
		tmp.append("<h3 class=\"aside-title\">Thể loại</h3>");
		tmp.append("<ul class=\"aside-links list-unstyled\">");
		cates.forEach(cate-> {
		tmp.append("<li><a href=\"/home/news?cid="+cate.getCategory_id()+"\"><i class=\"bi bi-chevron-right\"></i>"+cate.getCategory_name()+"</a></li>");
		});
		tmp.append("</ul>");
		tmp.append("</div><!-- End Categories -->");
		tmp.append("<div class=\"aside-block\">");
		tmp.append("<h3 class=\"aside-title\">Liên kết</h3>");
		tmp.append("<ul class=\"aside-tags list-unstyled\">");
		tags.forEach((tag,number)->{
			if(number!=null) {
			tmp.append("<li><a href=\"/home/news?tag="+tag+"\">"+tag+" ("+number+")</a></li>");
			}
		});
		tmp.append("</ul>");
		tmp.append("</div><!-- End Tags -->");
		tmp.append("</div>");
		return tmp;
	}
}
