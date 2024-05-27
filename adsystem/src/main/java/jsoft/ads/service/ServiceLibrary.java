package jsoft.ads.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map.Entry;

import org.javatuples.Triplet;

import jsoft.ads.section.SectionLibrary;
import jsoft.library.Utilities;
import jsoft.objects.CareerObject;
import jsoft.objects.FieldObject;
import jsoft.objects.OrderObject;
import jsoft.objects.SectionObject;
import jsoft.objects.ServiceObject;
import jsoft.objects.UserObject;

public class ServiceLibrary {
	public static String viewService(ArrayList<OrderObject> items,Short total,int page) {
		StringBuffer tmp = new StringBuffer();
		
		tmp.append("<div class=\"card\">");
		tmp.append("<div class=\"card-body\">");

		tmp.append("<table class=\"table table-striped\">");
		tmp.append("<thead>");
		tmp.append("<tr>");
		tmp.append("<th scope=\"col\">STT</th>");
		tmp.append("<th scope=\"col\">Tên dịch vụ</th>");
		tmp.append("<th scope=\"col\">Tên người đăng ký</th>");
		tmp.append("<th scope=\"col\">Số tiền</th>");
		tmp.append("<th scope=\"col\">Ngày đăng ký</th>");
		tmp.append("<th scope=\"col\" colspan=\"2\">Thao tác</th>");
		tmp.append("<th scope=\"col\">#</th>");
		tmp.append("</tr>");
		tmp.append("</thead>");
		
		tmp.append("<tbody>");
		if(items.size()>0) {
		items.forEach(item -> {
			tmp.append("<tr>");
			tmp.append("<th scope=\"row\">"+(items.indexOf(item) + 1)+"</th>");
			tmp.append("<td>"+item.getService().getService_name()+"</td>");
			tmp.append("<td>"+item.getUser().getUser_name()+"("+item.getUser().getUser_fullname()+")</td>");
			tmp.append("<td>"+item.getService().getService_price()+" VNĐ</td>");
			tmp.append("<td>"+item.getOrder_created_date()+"</td>");
		
			tmp.append("<td><a href=\"/adv/service/view?id="+item.getService().getService_id()+"&page="+page+"\" class=\"btn btn-primary btn-sm\"><i class=\"bi bi-eye-fill\"></i></a></td>");
		
			tmp.append("<td class=\"text-center\"><a href=\"#\" class=\"btn btn-warning btn-sm\" data-bs-toggle=\"modal\" data-bs-target=\"#del"
						+item.getOrder_id() + "\"><i class=\"bi bi-archive\"></i></a></td>");
		tmp.append(ServiceLibrary.ViewDell(item.getOrder_id(), page));
			tmp.append("<th scope=\"row\">"+item.getOrder_id()+"</th>");
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
	public static StringBuilder pagination(int total, Byte pageSize,int page) {
//		System.out.println(total);
		 page =(page<=1)? 1 : page;
		 
		 String urlkey = "";
		
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
	private static StringBuilder ViewDell(int id, int page) {
		StringBuilder tmp = new StringBuilder();

		String title = "Xóa vĩnh viễn";

		tmp.append("<div class=\"modal modal-fullscreen-sm-down fade\" id=\"del" + id
				+ "\" tabindex=\"-1\" aria-labelledby=\"exampleModalLabel\" aria-hidden=\"true\">");
		tmp.append("<div class=\"modal-dialog\">");
		tmp.append("<div class=\"modal-content\">");
		tmp.append("<div class=\"modal-header\">");
		tmp.append("<h1 class=\"modal-title fs-5\" id=\"exampleModalLabel\">" + title + "</h1>");
		tmp.append(
				"<button type=\"button\" class=\"btn-close\" data-bs-dismiss=\"modal\" aria-label=\"Close\"></button>");
		tmp.append("</div>");
		tmp.append("<div class=\"modal-body\">");
		
			tmp.append("Bạn sẽ vĩnh viễn xóa lịch sử đăng ký <b>").append(" (" + id + ")</b>");
			tmp.append("<p>Tài khoản không thể phục hồi được nữa!!!</p>");
	

		tmp.append("</div>");
		tmp.append("<div class=\"modal-footer\">");
		
			tmp.append("<a href=\"/adv/service/dr?id=" + id + "&page="
					+ page + "\" class=\"btn btn-danger px-5 py-2\">Xóa vĩnh viễn</a>");
		tmp.append(
				"<button type=\"button\" class=\"btn btn-secondary px-5 py-2\" data-bs-dismiss=\"modal\">Hủy</button>");
		tmp.append("</div>");
		tmp.append("</div>");
		tmp.append("</div>");
		tmp.append("</div>");
		return tmp;
	}
	
	public static StringBuilder createdChart(LinkedHashMap<String,Integer > datas) {
		StringBuilder data = new StringBuilder();
		StringBuilder time = new StringBuilder();
		int index = 0;
		for(Entry<String, Integer> entry:datas.entrySet()) {
			time.append("'" +entry.getKey()).append("'");
			data.append(entry.getValue());
			System.out.println(entry.getKey());
			index++;
			if (index < datas.size()) {
				data.append(",");
				time.append(",");
			}
		}
		
		System.out.println(data);
		System.out.println(time);
		
		StringBuilder tmp = new StringBuilder();
		tmp.append("<div class=\"card\">");
		tmp.append("<div class=\"card-body\">");
		tmp.append("<h5 class=\"card-title\">Biểu đồ thống kê doanh thu</h5>");

		tmp.append("<!-- Line Chart -->");
		tmp.append("<div id=\"lineChart\"></div>");

		tmp.append("<script>");
		tmp.append("document.addEventListener(\"DOMContentLoaded\", () => {");
		tmp.append("new ApexCharts(document.querySelector(\"#lineChart\"), {");
		tmp.append("series: [{");
		tmp.append("name: \"Desktops\",");
		tmp.append("data: ["+data.toString()+"]");
		tmp.append("}],");
		tmp.append("chart: {");
		tmp.append("height: 350,");
		tmp.append("type: 'line',");
		tmp.append("zoom: {");
		tmp.append("enabled: false");
		tmp.append("}");
		tmp.append("},");
		tmp.append("dataLabels: {");
		tmp.append("enabled: false");
		tmp.append("},");
		tmp.append("stroke: {");
		tmp.append("curve: 'straight'");
		tmp.append("},");
		tmp.append("grid: {");
		tmp.append("row: {");
		tmp.append("colors: ['#f3f3f3', 'transparent'],");
		tmp.append("opacity: 0.5");
		tmp.append("},");
		tmp.append("},");
		tmp.append("xaxis: {");
		tmp.append("categories: ["+time.toString()+"],");
		tmp.append("}");
		tmp.append("}).render();");
		tmp.append("});");
		tmp.append("</script>");		
		tmp.append("<!-- End Line Chart -->");

		tmp.append("</div>");
		tmp.append("</div>");
		return tmp;
	}
	
	
}
