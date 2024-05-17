package jsoft.home.applications;

import java.util.ArrayList;
import java.util.HashMap;

import jsoft.library.Utilities;
import jsoft.objects.ApplicationsObject;
import jsoft.objects.FieldObject;
import jsoft.objects.UserObject;

public class AppLibrary {
	public static String viewApp(ArrayList<ApplicationsObject> items,Short total,int page,UserObject user) {
		StringBuffer tmp = new StringBuffer();
		
		tmp.append("<div class=\"card\">");
		tmp.append("<div class=\"card-body\">");

		tmp.append("<table class=\"table table-striped\">");
		tmp.append("<thead>");
		tmp.append("<tr>");
		tmp.append("<th scope=\"col\">STT</th>");
		tmp.append("<th scope=\"col\">Ngày ứng tuyển</th>");
		tmp.append("<th scope=\"col\">Tin tuyển dụng</th>");
		tmp.append("<th scope=\"col\">Người ứng tuyển</th>");
		tmp.append("<th scope=\"col\">Trạng thái</th>");
		tmp.append("<th scope=\"col\" colspan=\"3\">Thao tác</th>");
		tmp.append("<th scope=\"col\">#</th>");
		tmp.append("</tr>");
		tmp.append("</thead>");
		
		tmp.append("<tbody>");
		if(items.size()>0) {
		items.forEach(item -> {
			tmp.append("<tr>");
			tmp.append("<th scope=\"row\">"+(items.indexOf(item) + 1)+"</th>");
			tmp.append("<td>"+item.getApplications_created_date()+"</td>");
			tmp.append("<td>"+item.getJob().getJob_title()+"<br/><a href=\"/adv/job/view?id="+item.getJob().getJob_id()+"\">Xem chi tiết</a>"+"</td>");
			tmp.append("<td>"+item.getUser().getUser_fullname()+"<br/><a href=\"/adv/user/profiles?id="+item.getUser().getUser_id()+"&view&page=1\">Xem hồ sơ</a>"+"</td>");
			
			tmp.append("<td>");
			tmp.append("<select onchange=\"fetchUpdateStatusApp("+item.getApplications_id()+",this.value);\" id=\"slcStatus\" class=\"form-control\">");
			tmp.append("<option value=\"0\" "+(item.getApplications_status()==0?"selected":"")+">Chưa xem</option>");
			tmp.append("<option value=\"1\" "+(item.getApplications_status()==1?"selected":"")+">Lọc hồ sơ</option>");
			tmp.append("<option value=\"2\" "+(item.getApplications_status()==2?"selected":"")+">Phỏng vấn</option>");
			tmp.append("<option value=\"3\" "+(item.getApplications_status()==3?"selected":"")+">Ðã chọn</option>");
			tmp.append("<option value=\"4\" "+(item.getApplications_status()==4?"selected":"")+">Đã từ chối</option>");
			tmp.append("<option value=\"5\" "+(item.getApplications_status()==5?"selected":"")+">Không thành công</option>");
			tmp.append("</select >");
			tmp.append("</td>");
			if(item.isApplications_delete()) {
			tmp.append("<td class=\"text-center\"><a href=\"/adv/career/dr?id=" + item.getApplications_id() + "&t&r&page=" + page
					+ "\" class=\"btn btn-primary btn-sm\"><i class=\"fas fa-trash-restore-alt\"></i></a></td>");
			}
			tmp.append("<td><a href=\"/adv/career/edit?id="+item.getApplications_id()+"&view&page="+page+"\" class=\"btn btn-primary btn-sm\"><i class=\"bi bi-eye-fill\"></i></a></td>");
			tmp.append("<td><a href=\"/adv/career/edit?id=" + item.getApplications_id()+"&page="+page+"\" class=\"btn btn-secondary btn-sm\"><i class=\"bi bi-pencil-square\"></i></a></td>");
		
			tmp.append("<td class=\"text-center\"><a href=\"#\" class=\"btn btn-warning btn-sm\" data-bs-toggle=\"modal\" data-bs-target=\"#delCareer"
						+ item.getApplications_id() + "\"><i class=\"bi bi-archive\"></i></a></td>");
			tmp.append(AppLibrary.ViewDellApp(item, page));
			tmp.append("<th scope=\"row\">"+item.getApplications_id()+"</th>");
			tmp.append("</tr>");			
		});
		} else {
			 tmp.append("<tr><th class=\"text-center\" colspan=\"10\">Danh sách rỗng</th></tr>");
		}

		
		tmp.append("</tbody>");
		tmp.append("</table>");
		
		tmp.append("</div>");
		tmp.append("</div>");

		
		return tmp.toString();
	}
	public static String viewFieldOptions(ArrayList<FieldObject> fields,int selected_id) {
		StringBuilder tmp = new StringBuilder();
		fields.forEach(item->{
			if(item.getField_id()==selected_id) {
				tmp.append("<option value=\""+item.getField_id()+"\" selected>");
			} else {
				tmp.append("<option value=\""+item.getField_id()+"\">");	
			}
			
			tmp.append(item.getField_name());
			tmp.append("</option>");
		});
		return tmp.toString();
	}
	public static StringBuilder pagination(int total, Byte pageSize,int page,String saveKey,boolean trash) {
//		System.out.println(total);
		 page =(page<=1)? 1 : page;
		 
		 String urlkey = "";
		 if(saveKey!=null && !saveKey.equalsIgnoreCase("")) {
			 // savekey ton tai
			 urlkey="&key="+saveKey;
		 } 
		 if(trash) {
			 urlkey+="&trash";
		 }
		int totalPage = total < pageSize ? 1 : (int) Math.ceil((double) total / pageSize);

		if (total % pageSize == 0) {
			totalPage = totalPage - 1;
		}

		
		StringBuilder out = new StringBuilder();
		//phan trang
		if(total>0) {
		out.append("<nav aria-label=\"Page navigation example\">");
		out.append("<ul class=\"pagination justify-content-center\">");
		
		String isPrevious = (page<=1)?"disabled":"";
		String isNext = (page==totalPage)?"disabled":"";
		
		out.append("<li class=\"page-item "+isPrevious+"\">");
		out.append("<a class=\"page-link\" href=\"/adv/career/list?page="+(page > 1 ? page - 1 : 1)+urlkey+"\" tabindex=\"-1\" aria-disabled=\"true\"><span aria-hidden=\"true\">&laquo;</span></a></a>");
		out.append("</li>");
		if(page>=4) {
		out.append("<li class=\"page-item\">");
		out.append("<a class=\"page-link\" href=\"/adv/career/list?page=1"+urlkey+"\" tabindex=\"-1\" aria-disabled=\"true\"><span aria-hidden=\"true\">1</span></a></a>");
		out.append("</li>");
		}
		//left current
		String leftCurrent = "";
		int count=0;
		for(int i=page-1;i>0;i--) {
			leftCurrent = "<li class=\"page-item\"><a class=\"page-link\" href=\"/adv/career/list?page="+i+urlkey+"\">"+i+"</a></li>"+leftCurrent;

			if(++count>=2) {
				break;
			}
		}
		if(page>=4) {
			leftCurrent = "<li class=\"page-item disabled\"><a class=\"page-link\" href=\"#\">....</a></li>"+leftCurrent;
		}
		out.append(leftCurrent);
		
		out.append(" <li class=\"page-item active\" aria-current=\"page\">");
		out.append("<a class=\"page-link\" href=\"/adv/career/list?page="+page+urlkey+"\">"+page+"</a>");
		out.append("</li>");
		
		String rightCurrent ="";
		 count = 0;
		for(int i=page+1;i<=totalPage;i++) {
			rightCurrent+="<li class=\"page-item\"><a class=\"page-link\" href=\"/adv/career/list?page="+i+urlkey+"\">"+i+"</a></li>";
			if(++count>=2) {
				break;
			}
		}
	
		if(totalPage>page+2) {
			rightCurrent += "<li class=\"page-item disabled\"><a class=\"page-link\" href=\"#\">....</a></li>";
		}
		out.append(rightCurrent);
//		out.append(" <li class=\"page-item\"><a class=\"page-link\" href=\"/adv/user/list?page="+totalPage+"\">"+totalPage+"</a></li>");
		if(page<totalPage-2) {
		out.append("<li class=\"page-item\" >");
		out.append("<a class=\"page-link\"  href=\"/adv/career/list?page="+totalPage+urlkey+"\"><span aria-hidden=\"true\">"+totalPage+"</span></a></a>");
		out.append("</li>");
		}
		out.append("<li class=\"page-item "+isNext+"\" >");
		out.append("<a class=\"page-link\"  href=\"/adv/career/list?page="+(page < totalPage ? page + 1 : totalPage)+urlkey+"\"><span aria-hidden=\"true\">&raquo;</span></a></a>");
		out.append("</li>");
		out.append("</ul>");
		out.append("</nav><!-- End Disabled and active states -->");
		}
		return out;
	}
	private static StringBuilder ViewDellApp(ApplicationsObject item, int page) {
		StringBuilder tmp = new StringBuilder();

		String title;
		if (item.isApplications_delete()) {
			title = "Xóa vĩnh viễn";
		} else {
			title = "Xóa tài khoản";
		}

		tmp.append("<div class=\"modal modal-fullscreen-sm-down fade\" id=\"delCareer" + item.getApplications_id()
				+ "\" tabindex=\"-1\" aria-labelledby=\"exampleModalLabel\" aria-hidden=\"true\">");
		tmp.append("<div class=\"modal-dialog\">");
		tmp.append("<div class=\"modal-content\">");
		tmp.append("<div class=\"modal-header\">");
		tmp.append("<h1 class=\"modal-title fs-5\" id=\"exampleModalLabel\">" + title + "</h1>");
		tmp.append(
				"<button type=\"button\" class=\"btn-close\" data-bs-dismiss=\"modal\" aria-label=\"Close\"></button>");
		tmp.append("</div>");
		tmp.append("<div class=\"modal-body\">");
		if (item.isApplications_delete()) {
			tmp.append("Bạn sẽ vĩnh viễn xóa ngành nghề <b>").append(" (" + item.getApplications_id() + ")</b>");
			tmp.append("<p>Tài khoản không thể phục hồi được nữa!!!</p>");
		} else {
			tmp.append("Bạn có chắc chắn xóa ngành nghề <b>").append(" (" + item.getApplications_id() + ")</b>");
			tmp.append("Hệ thống tạm thời lưu vào thùng rác có thể phuc hồi trong vòng 30 ngày");
		}

		tmp.append("</div>");
		tmp.append("<div class=\"modal-footer\">");
		if (item.isApplications_delete()) {
			tmp.append("<a href=\"/adv/career/dr?id=" + item.getApplications_id() + "&page="
					+ page + "\" class=\"btn btn-danger px-5 py-2\">Xóa vĩnh viễn</a>");
		} else {
			tmp.append("<a href=\"/adv/career/dr?id=" + item.getApplications_id() + "&t"
					+ "&page=" + page + "\" class=\"btn btn-warning px-5 py-2\">Xóa</a>");
		}
		tmp.append(
				"<button type=\"button\" class=\"btn btn-secondary px-5 py-2\" data-bs-dismiss=\"modal\">Hủy</button>");
		tmp.append("</div>");
		tmp.append("</div>");
		tmp.append("</div>");
		tmp.append("</div>");
		return tmp;
	}
	
	public static StringBuilder createdChart(HashMap<Integer, String> datas) {
		StringBuilder data = new StringBuilder();
		StringBuilder sections = new StringBuilder();
		 for (int i : datas.keySet()) {
			    data.append(i);
			    sections.append("'" + Utilities.decode(datas.get(i))).append("'");
				if (i < datas.size()) {
					data.append(",");
					sections.append(",");
				}
		    }
		StringBuilder tmp = new StringBuilder();
		tmp.append("<div class=\"card\">");
		tmp.append("<div class=\"card-body\">");
		tmp.append("<h5 class=\"card-title\">Biểu đồ thống kê thể loại theo chuyên mục</h5>");
		tmp.append("");
		tmp.append("<!-- Bar Chart -->");
		tmp.append("<div id=\"barChart\"></div>");
		tmp.append("");
		tmp.append("<script>");
		tmp.append("document.addEventListener(\"DOMContentLoaded\", () => {");
		tmp.append("new ApexCharts(document.querySelector(\"#barChart\"), {");
		tmp.append("series: [{");
		tmp.append("data: [" + data.toString() + "]");
		tmp.append("}],");
		tmp.append("chart: {");
		tmp.append("type: 'bar',");
		if(datas.size()<=15) {
			tmp.append("height: 350,");
		} else if(datas.size()<=30) {
			tmp.append("height: 600,");
		} else {
			tmp.append("height: 750,");
		}
		
		tmp.append("},");
		tmp.append("plotOptions: {");
		tmp.append("bar: {");
		tmp.append("borderRadius: 4,");
		tmp.append("horizontal: true,");
		tmp.append("}");
		tmp.append("},");
		tmp.append("dataLabels: {");
		tmp.append("enabled: false");
		tmp.append("},");
		tmp.append("xaxis: {");
		tmp.append("categories: [" + sections.toString() + "],");
		tmp.append("}, ");
		tmp.append("yaxis: {");
		tmp.append("show: true,");
		tmp.append("labels: {");
		tmp.append("show: true,");
		tmp.append("align: 'right',");
		tmp.append("minWidth: 0,");
		tmp.append("maxWidth: 300,");
		tmp.append(
				"style: {color:[], fontSize: '15px', fontFamily: 'Arial, san-serif', fontWeight: 400, cssClass:'apexcharts-yaxis-label'},");
		tmp.append("},");
		tmp.append("}");
		tmp.append("}).render();");
		tmp.append("});");
		tmp.append("</script>");
		tmp.append("<!-- End Bar Chart -->");
		tmp.append("");
		tmp.append("</div>");
		tmp.append("</div>");
		return tmp;
	}
	
	
}
