package jsoft.ads.contact;

import java.util.ArrayList;

import jsoft.objects.ContactObject;

public class ContactLibrary {
	public static String viewContact(ArrayList<ContactObject> items,Short total,int page) {
		StringBuffer tmp = new StringBuffer();
		
		tmp.append("<div class=\"card\">");
		tmp.append("<div class=\"card-body\">");
		
		tmp.append("<table class=\"table table-striped\">");
		tmp.append("<thead>");
		tmp.append("<tr>");
		tmp.append("<th scope=\"col\">STT</th>");
		tmp.append("<th scope=\"col\">Ngày gửi</th>");
		tmp.append("<th scope=\"col\">Email</th>");
		tmp.append("<th scope=\"col\">Tiêu đề</th>");
		tmp.append("<th scope=\"col\">Nội dung</th>");
		
		tmp.append("<th scope=\"col\" class=\"text-center\" colspan=\"2\">Thực hiện</th>");
		tmp.append("<th scope=\"col\">#</th>");
		tmp.append("</tr>");
		tmp.append("</thead>");
		
		tmp.append("<tbody>");
		if(items.size()>0) {
		items.forEach(item -> {
			tmp.append("<tr>");
			tmp.append("<th scope=\"row\">"+(items.indexOf(item) + 1)+"</th>");
			tmp.append("<td>"+item.getContact_created_date()+"</td>");
			tmp.append("<td>"+item.getContact_email()+"</td>");
			tmp.append("<td>"+item.getContact_title()+"</td>");
			tmp.append("<td>"+item.getContact_content()+"</td>");
			if(item.isContact_enable()) {
				tmp.append("<td class=\"text-center\"><a href=\"#\" class=\"btn btn-primary btn-sm\" data-bs-toggle=\"modal\" data-bs-target=\"#"
						+ item.getContact_id() + "\">Đã Phản hồi</a></td>");
			} else {
				tmp.append("<td class=\"text-center\"><a href=\"#\" class=\"btn btn-primary btn-sm\" data-bs-toggle=\"modal\" data-bs-target=\"#respContact"
						+ item.getContact_id() + "\">Phản hồi</a></td>");
			}
 			
			tmp.append("<td class=\"text-center\"><a href=\"#\" class=\"btn btn-warning btn-sm\" data-bs-toggle=\"modal\" data-bs-target=\"#delContact"
				+ item.getContact_id() + "\"><i class=\"bi bi-archive\"></i></a></td>");
			tmp.append(ContactLibrary.ViewDellContact(item, page));
			tmp.append(ContactLibrary.ViewSendMail(item, page));
			tmp.append("<th scope=\"row\">"+item.getContact_id()+"</th>");
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
		out.append("<a class=\"page-link\" href=\"/adv/Contact/list?page="+(page > 1 ? page - 1 : 1)+urlkey+"\" tabindex=\"-1\" aria-disabled=\"true\"><span aria-hidden=\"true\">&laquo;</span></a></a>");
		out.append("</li>");
		if(page>=4) {
		out.append("<li class=\"page-item\">");
		out.append("<a class=\"page-link\" href=\"/adv/Contact/list?page=1"+urlkey+"\" tabindex=\"-1\" aria-disabled=\"true\"><span aria-hidden=\"true\">1</span></a></a>");
		out.append("</li>");
		}
		//left current
		String leftCurrent = "";
		int count=0;
		for(int i=page-1;i>0;i--) {
			leftCurrent = "<li class=\"page-item\"><a class=\"page-link\" href=\"/adv/Contact/list?page="+i+urlkey+"\">"+i+"</a></li>"+leftCurrent;

			if(++count>=2) {
				break;
			}
		}
		if(page>=4) {
			leftCurrent = "<li class=\"page-item disabled\"><a class=\"page-link\" href=\"#\">....</a></li>"+leftCurrent;
		}
		out.append(leftCurrent);
		
		out.append(" <li class=\"page-item active\" aria-current=\"page\">");
		out.append("<a class=\"page-link\" href=\"/adv/Contact/list?page="+page+urlkey+"\">"+page+"</a>");
		out.append("</li>");
		
		String rightCurrent ="";
		 count = 0;
		for(int i=page+1;i<=totalPage;i++) {
			rightCurrent+="<li class=\"page-item\"><a class=\"page-link\" href=\"/adv/Contact/list?page="+i+urlkey+"\">"+i+"</a></li>";
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
		out.append("<a class=\"page-link\"  href=\"/adv/Contact/list?page="+totalPage+urlkey+"\"><span aria-hidden=\"true\">"+totalPage+"</span></a></a>");
		out.append("</li>");
		}
		out.append("<li class=\"page-item "+isNext+"\" >");
		out.append("<a class=\"page-link\"  href=\"/adv/Contact/list?page="+(page < totalPage ? page + 1 : totalPage)+urlkey+"\"><span aria-hidden=\"true\">&raquo;</span></a></a>");
		out.append("</li>");
		out.append("</ul>");
		out.append("</nav><!-- End Disabled and active states -->");
		}
		return out;
	}
	private static StringBuilder ViewDellContact(ContactObject item, int page) {
		StringBuilder tmp = new StringBuilder();

		String title;
		
			title = "Xóa vĩnh viễn";

		tmp.append("<div class=\"modal modal-fullscreen-sm-down fade\" id=\"delContact" + item.getContact_id()
				+ "\" tabindex=\"-1\" aria-labelledby=\"exampleModalLabel\" aria-hidden=\"true\">");
		tmp.append("<div class=\"modal-dialog\">");
		tmp.append("<div class=\"modal-content\">");
		tmp.append("<div class=\"modal-header\">");
		tmp.append("<h1 class=\"modal-title fs-5\" id=\"exampleModalLabel\">" + title + "</h1>");
		tmp.append(
				"<button type=\"button\" class=\"btn-close\" data-bs-dismiss=\"modal\" aria-label=\"Close\"></button>");
		tmp.append("</div>");
		tmp.append("<div class=\"modal-body\">");
		
		tmp.append("Bạn sẽ vĩnh viễn xóa lĩnh vực <b>").append(" (" + item.getContact_title() + ")</b>");
		tmp.append("<p>Liên hệ này không thể phục hồi được nữa!!!</p>");

		tmp.append("</div>");
		tmp.append("<div class=\"modal-footer\">");
		
		tmp.append("<a href=\"/adv/contact/dr?id=" + item.getContact_id() + "&page="
					+ page + "\" class=\"btn btn-danger px-5 py-2\">Xóa vĩnh viễn</a>");
		tmp.append(
				"<button type=\"button\" class=\"btn btn-secondary px-5 py-2\" data-bs-dismiss=\"modal\">Hủy</button>");
		tmp.append("</div>");
		tmp.append("</div>");
		tmp.append("</div>");
		tmp.append("</div>");
		return tmp;
	}
	
	private static StringBuilder ViewSendMail(ContactObject item, int page) {
		StringBuilder tmp = new StringBuilder();

		tmp.append("<div class=\"modal modal-fullscreen-sm-down fade\" id=\"respContact" + item.getContact_id()
				+ "\" tabindex=\"-1\" aria-labelledby=\"exampleModalLabel\" aria-hidden=\"true\">");
		tmp.append("<div class=\"modal-dialog\">");
		tmp.append("<div class=\"modal-content\">");
		tmp.append("<form method=\"POST\">");
		tmp.append("<div class=\"modal-header\">");
		tmp.append("<h1 class=\"modal-title fs-5\" id=\"exampleModalLabel\">" +"Gửi mail" + "</h1>");
		tmp.append("<button type=\"button\" class=\"btn-close\" data-bs-dismiss=\"modal\" aria-label=\"Close\"></button>");
		tmp.append("</div>");
		tmp.append("<div class=\"modal-body\">");
		
		tmp.append("<label for=\"email\" class=\"form-label mt-3\"><i class=\"fas fa-envelope-open me-2\"></i>Hộp thư</label>");
		tmp.append("<input type=\"email\" class=\"form-control\" placeholder=\"...\" name=\"txtemail\" value=\""+item.getContact_email()+"\" id=\"email\" required >");
		
		tmp.append("<label for=\"title\" class=\"form-label mt-3\"><i class=\"fas fa-file-signature me-2\"></i>Tiêu đề</label>");
		tmp.append("<input type=\"text\" class=\"form-control\" placeholder=\"...\" name=\"txttitle\" id=\"title\" required>");
		
		tmp.append("<label for=\"content\" class=\"form-label mt-3\"><i class=\"fas fa-file-signature me-2\"></i>Nội dung</label>");
		tmp.append("<textarea name=\"txtcontent\" class=\"form-control\" id=\"Emailcontent\" style=\"height: 100px\"></textarea>");
		tmp.append("<script>");
		tmp.append("var editor = CKEDITOR.replace(\"Emailcontent\");");
		tmp.append("CKFinder.setupCKEditor(editor,\"/adv/ckfinder/\")");
		tmp.append("</script>");
		
		tmp.append("</div>");
		tmp.append("<div class=\"modal-footer\">");
		tmp.append("<button type=\"submit\" class=\"btn btn-primary px-5 py-2\">Gửi</button>");
		tmp.append("<button type=\"button\" class=\"btn btn-secondary px-5 py-2\" data-bs-dismiss=\"modal\">Hủy</button>");
		tmp.append("</div>");
		tmp.append("</form>");
		tmp.append("</div>");
		tmp.append("</div>");
		tmp.append("</div>");
		return tmp;
	}
}
